package com.diegopalvarez.oreplay.ui.scrollbar

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun VerticalScrollBar(
    scrollState: LazyListState,
    modifier: Modifier = Modifier,
)