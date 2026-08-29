package com.diegopalvarez.oreplay.feature.results.stageClub.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.ClubResultsRepository
import com.diegopalvarez.oreplay.domain.repository.type.ScoreRepositoryResult
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.domain.types.getStageType
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class ClubResultsComponent(
    componentContext: ComponentContext,
    val pageEvent: Event,
    val stage: Stage,
    val stageClubID: String,
    val stageClubName: String,
    private val repository: ClubResultsRepository,
    private val preferences: PreferencesManager,
    private val onGoBack: () -> Unit,
    private val onGoToClass: (Event, Stage, String, String) -> Unit,
    private val onGoToClub: (Event, Stage, String, String) -> Unit,

    // List of clubs for the dialog picker
    val stageClubs: List<StageClub>
): AbstractResultsComponent(
    componentContext = componentContext,
    onGoBack = onGoBack,
    event = pageEvent,
    stage = stage,
    isClubResults = true,
    preferencesManager = preferences
) {
    /**
     * Result Functionality
     */
    private val scope = CoroutineScope(Dispatchers.Main)

    override suspend fun fetchResults(){
        repository.getClubResults(
            eventID = pageEvent.id,
            stageID = stage.id,
            clubID = stageClubID,
            stageType = stage.stageType.getStageType()
        )
            .onSuccess {
                _isError.value = false
                _results.value = it.result

                // If the results are Score, also fetch the additional information
                if(stage.stageType.getStageType() == StageType.SCORE){
                    _visitedScoreControls.value = Optional.Some((it as ScoreRepositoryResult).visitedControls)
                }

                _isInit.value = true
            }
            .onError {
                _isError.value = true
                _errorType.value = it


                // In case of error, also reset the optional values for these types of events
                if(stage.stageType.getStageType() == StageType.SCORE){
                    _visitedScoreControls.value = Optional.None
                }
            }
    }

    /**
     * Init function
     */
    init {
        // Set up scope cancellation if the component is destroyed
        componentContext.lifecycle.doOnDestroy {
            scope.cancel()
        }

        scope.launch {
            getResults()

            // If the event is live, set up the automatic reload timer
            if(isLive.value){
                while(scope.isActive){
                    delay(reloadInterval.value?.seconds ?: 1.minutes)       // Use 1 minute as the default value
                    getResults()
                }
            }
        }
    }

    /**
     * Reload function
     */
    override fun reloadResults(){
        scope.launch {
            _isRefreshing.value = true // TODO - Check and standardize where the loading state is updated
            getResults()
            _isRefreshing.value = false
        }
    }

    /**
     * Event Handling
     */
    fun onEvent(event: ClubResultsEvent) {
        when(event) {
            ClubResultsEvent.GoBack -> {
                onGoBack()
            }
        }
    }

    /**
     * Function to go directly to a class
     */
    override fun goToPage(id: String, name: String, isClub: Boolean) {
        if(isClub){
            onGoToClub(pageEvent, stage, id, name)
        }
        else{
            onGoToClass(pageEvent, stage, id, name)
        }
    }
}