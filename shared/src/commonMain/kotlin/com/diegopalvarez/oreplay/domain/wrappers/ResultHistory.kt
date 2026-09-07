package com.diegopalvarez.oreplay.domain.wrappers

import com.diegopalvarez.oreplay.domain.model.StageCategory
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.serializer.HistoryDequeSerializer
import kotlinx.serialization.Serializable

@Serializable
class ResultHistory(
    val classList: List<StageClass>,
    val clubList: List<StageClub>,

    @Serializable(with = HistoryDequeSerializer::class)
    private val history: ArrayDeque<StageCategory> = ArrayDeque()
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
}