package com.diegopalvarez.oreplay.domain.wrappers

import com.diegopalvarez.oreplay.domain.model.ResultClass
import com.diegopalvarez.oreplay.domain.model.StageCategory
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.serializer.HistoryDequeSerializer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

@Serializable
class ResultHistory(
    var classList: List<StageClass>,
    var clubList: List<StageClub>,

    @Serializable(with = HistoryDequeSerializer::class)
    private val history: ArrayDeque<StageCategory> = ArrayDeque(),

    // Store the current category outside the flow so that it survives
    private var currentCategoryValue: StageCategory? = null
) {

    // Function to add a visited item to the queue
    fun push(item: StageCategory) {
        // Check if the item is already on the list
        val index = history.indexOf(item)

        if(index != -1) {
            // If the history already contains the item, move it to the front
            history.removeAt(index)
        }
        else{
            // If the history doesn't contain the item, add it to the front and check if there's a need to pop the back
            if(history.size >= 3){
                history.removeLast()
            }
        }

        // Add the item to the front
        history.addFirst(item)
    }

    // Function to get the history
    fun getHistory(): List<StageCategory> = history.toList()

    // Function to get the corresponding StageClass to a ResultClass
    fun getClass(resultClass: ResultClass): StageClass? {
        return classList.firstOrNull { it.id == resultClass.id }
    }

    // Functions to update the lists
    fun updateClassList(list: List<StageClass>){
        classList = list
    }

    fun updateClubList(list: List<StageClub>){
        clubList = list
    }

    // StateFlow to store the current selected category. It's transient because flows should not be serialized
    @kotlinx.serialization.Transient
    private val currentCategory: MutableStateFlow<StageCategory?> = MutableStateFlow(currentCategoryValue)

    // Function to edit the current category
    fun setCurrentCategory(category: StageCategory) {
        // Update the flow AND the stored category so it survives component recreation
        currentCategoryValue = category
        currentCategory.value = category
    }

    // Function to empty the current category
    fun clearCurrentCategory() {
        // Clean the flow category AND the saved category
        currentCategoryValue = null
        currentCategory.value = null
    }

    // Function to get the current category
    fun getCurrentCategory(): StateFlow<StageCategory?> = currentCategory
}