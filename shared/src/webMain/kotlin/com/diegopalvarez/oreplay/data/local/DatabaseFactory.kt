package com.diegopalvarez.oreplay.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import app.cash.sqldelight.driver.worker.createDefaultWebWorkerDriver
import app.cash.sqldelight.driver.worker.expected.Worker
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.js

class WebDatabaseDriverFactory() : DatabaseDriverFactory {
    override suspend fun createDriver(): SqlDriver {
        // The Web implementation of a DataBase doesn't have a file since it doesn't survive reloads
        return createDefaultWebWorkerDriver()
            .also {
                LocalDatabase.Schema.create(it).await()
            }
    }
}