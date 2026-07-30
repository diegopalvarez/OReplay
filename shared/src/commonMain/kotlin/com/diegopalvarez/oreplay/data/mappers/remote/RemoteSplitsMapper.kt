package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteSplit
import com.diegopalvarez.oreplay.domain.model.Control
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.types.ControlID
import kotlin.time.Instant

/**
 * Private function to map an individual split
 * @param remoteSplit single split from the API
 * @return domain model object for a single Split, without the attributes that need to be compared to the class (partial and accumulated)
 */
private fun getSplit(remoteSplit: RemoteSplit): SplitIndividual{
    return SplitIndividual(
        id = remoteSplit.id,
        isIntermediate = remoteSplit.isIntermediate,
        readingTime =   remoteSplit.readingTime?.let(::getInstant),
        points = remoteSplit.points,
        orderNumber = remoteSplit.orderNumber ?: -1,
        created = getInstant(remoteSplit.created),
        control = getControl(remoteSplit.control)
        // Class-related attributes must be calculated in a later stage, since the comparison data isn't available at this time
    )
}

/**
 * Private function to map and sort all the splits from a list of RemoteSplits from the API.
 *
 * Adds a Finish Control to the end of the list
 *
 * @param splits List of RemoteSplits
 * @param finishTime Finish time for the runner, used to add an artificial finish control
 * @return list of domain model splits, sorted by order number
 */
fun getSplits(splits: List<RemoteSplit>, finishTime: Instant): List<SplitIndividual> {
    val splitList = splits.map(::getSplit) as MutableList<SplitIndividual>

    // Artificially add a Finish Control to the list
    splitList.add(SplitIndividual(
        id = "Finish",
        isIntermediate = false,
        readingTime = finishTime,       // The reading time corresponds to the actual finishTime
        points = 0,
        orderNumber = splitList.size + 1L,  // It's added as a last control to the list
        created = Instant.DISTANT_PAST,
        control = Control(
            id = "Finish",
            station = "Finish",
            controlType = ControlID.FINISH.id      // The Finish Control UUID allows to identify it
        )
    ))

    return splitList.sortedBy { it.orderNumber }
}