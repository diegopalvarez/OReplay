package com.diegopalvarez.oreplay.ui.scrollbar

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.app.platform.isTouchTarget
import kotlinx.coroutines.flow.subscribe

@Composable
actual fun HorizontalScrollBar(
    scrollState: ScrollState,
    modifier: Modifier,
) {
    // Subscribe to know if the target is touchable
    val isTouchable = isTouchTarget.collectAsState()

    // Only show scrollbars if the platform is NOT touch target
    if(!isTouchable.value) {
        HorizontalScrollbar(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp),
            adapter = rememberScrollbarAdapter(scrollState),
            style = LocalScrollbarStyle.current.copy(
                unhoverColor = MaterialTheme.colorScheme.onSurfaceVariant,
                hoverColor = MaterialTheme.colorScheme.primary,
            )
        )
    }
}