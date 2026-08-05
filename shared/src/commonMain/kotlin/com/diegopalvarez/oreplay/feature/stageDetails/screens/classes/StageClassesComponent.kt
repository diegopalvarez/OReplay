package com.diegopalvarez.oreplay.feature.stageDetails.screens.classes

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import com.diegopalvarez.oreplay.feature.stageDetails.common.AbstractStageComponent
import kotlinx.coroutines.launch

class StageClassesComponent(
    componentContext: ComponentContext,
    private val eventID: String,
    private val stageID: String,
    private val repository: StageRepository
): AbstractStageComponent(componentContext) {

    // Variable to store the list of classes.
    private val _list = MutableValue<List<StageClass>>(emptyList())
    val list: Value<List<StageClass>> = _list


    // TODO - Decide if sort classes or let them in the same order received
    override suspend fun fetchData(){
        repository.getStageClasses(eventID, stageID)
            .onSuccess {
                _isError.value = false
                _list.value = it

            }
            .onError {
                _isError.value = true
                _errorType.value = it
            }
        _isLoaded.value = true
    }

    // Function to search by name the classes loaded
    fun searchClasses(name: String): List<StageClass>{
        // TODO - Better search logic
        return list.value.filter { it.longName.contains(name) ||it.shortName.contains(name) }
    }

    // Init function
    init {
        scope.launch {
            fetchData()
        }
    }
}