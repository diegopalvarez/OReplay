package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ClassicTicketTableHeader

@Composable
fun OneManRelayTicketSplitTable(
    result: StageResult
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Table Header
        ClassicTicketTableHeader()

        // Table Content
        for(index in result.splits.indices) {
            OneManRelayTicketSplitItem(
                split = result.splits[index],
                alternateColor = (index % 2 == 0)
            )
        }
    }
}