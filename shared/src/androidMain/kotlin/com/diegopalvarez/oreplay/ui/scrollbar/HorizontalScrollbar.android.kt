package com.diegopalvarez.oreplay.ui.scrollbar

import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun HorizontalScrollBar(
    scrollState: ScrollState,
    modifier: Modifier
) {
    // In Android, we don't show scrollbars
}