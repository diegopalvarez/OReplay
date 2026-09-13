package com.diegopalvarez.oreplay.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.w3c.dom.Worker
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.js

class WebDatabaseDriverFactory() : DatabaseDriverFactory {
    val scope = CoroutineScope(Dispatchers.Default)

    override suspend fun createDriver(): SqlDriver {
        return WebWorkerDriver(worker())        // The Web implementation of a DataBase doesn't have a file since it doesn't survive reloads
    }

    // The JS block must be declared in a separate function to work
    @OptIn(ExperimentalWasmJsInterop::class)
    fun worker(): app.cash.sqldelight.driver.worker.expected.Worker =
        js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
}