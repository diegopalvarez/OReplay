package com.diegopalvarez.oreplay.app.platform

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.js.ExperimentalJsExport
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.JsExport

private val _isTouchTarget = MutableStateFlow(false)
val isTouchTarget: StateFlow<Boolean> = _isTouchTarget

@OptIn(ExperimentalJsExport::class)
@JsExport
fun setPointerType(pointerType: String) {
    _isTouchTarget.value = pointerType == "touch"
}

@OptIn(ExperimentalWasmJsInterop::class)
@JsFun("(callback) => document.addEventListener('pointerdown', event => callback(event.pointerType))")
external fun addPointerListener(callback: (String) -> Unit)