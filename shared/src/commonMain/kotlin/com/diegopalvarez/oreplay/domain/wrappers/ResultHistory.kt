package com.diegopalvarez.oreplay.domain.wrappers

import com.diegopalvarez.oreplay.domain.model.StageCategory
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub

class ResultHistory(
    val classList: List<StageClass>,
    val clubList: List<StageClub>
) {
    // Create the queue for the history
    private val _history = ArrayDeque<StageCategory>()

    // Function to add a visited item to the queue
    fun push(item: StageCategory) {
        // Check if the item is already on the list
        val index = _history.indexOf(item)

        if(index != -1) {
            // If the history already contains the item, move it to the front
            _history.removeAt(index)
        }
        else{
            // If the history doesn't contain the item, add it to the front and check if there's a need to pop the back
            if(_history.size >= 3){
                _history.removeLast()
            }
        }

        // Add the item to the front
        _history.addFirst(item)
    }

    // Function to get the history
    fun getHistory(): List<StageCategory> = _history.toList()
}