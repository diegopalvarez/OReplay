package com.diegopalvarez.oreplay.feature.stageDetails.common

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class AbstractStageComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext {

    // Declare the coroutine scope
    val scope = CoroutineScope(Dispatchers.Default)

    // Variable to store the loading stage
    protected val _isLoaded = MutableValue(false)
    val isLoaded: Value<Boolean> = _isLoaded

    // Variable to store if there is an error
    protected val _isError = MutableValue(false)
    val isError: Value<Boolean> = _isError

    // Variable to store the error type
    protected val _errorType = MutableValue(RepositoryError.UNKNOWN)
    val errorType: Value<RepositoryError> = _errorType

    // Function to fetch the classes/clubs from the repository
    abstract suspend fun fetchData()

}