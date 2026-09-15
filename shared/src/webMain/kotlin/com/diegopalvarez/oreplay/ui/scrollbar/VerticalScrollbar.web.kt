package com.diegopalvarez.oreplay.ui.scrollbar

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.app.platform.isTouchTarget
import kotlinx.coroutines.flow.subscribe

@Composable
actual fun VerticalScrollBar(
    scrollState: LazyListState,
    modifier: Modifier,
) {
    // Subscribe to know if the target is touchable
    val isTouchable = isTouchTarget.collectAsState()

    // Only show scrollbars if the platform is NOT touch target
    if(!isTouchable.value) {
        VerticalScrollbar(
            modifier = modifier
                .padding(horizontal = 3.dp),
            adapter = rememberScrollbarAdapter(scrollState),
            style = LocalScrollbarStyle.current.copy(
                unhoverColor = MaterialTheme.colorScheme.onSurfaceVariant,
                hoverColor = MaterialTheme.colorScheme.primary,
            )
        )
    }
}

@Composable
actual fun VerticalGridScrollBar(
    scrollState: LazyGridState,
    modifier: Modifier
) {
    // Subscribe to know if the target is touchable
    val isTouchable = isTouchTarget.collectAsState()

    // Only show scrollbars if the platform is NOT touch target
    if(!isTouchable.value) {
        VerticalScrollbar(
            modifier = modifier
                .padding(horizontal = 3.dp),
            adapter = rememberScrollbarAdapter(scrollState),
            style = LocalScrollbarStyle.current.copy(
                unhoverColor = MaterialTheme.colorScheme.onSurfaceVariant,
                hoverColor = MaterialTheme.colorScheme.primary,
            )
        )
    }
}