package com.diegopalvarez.oreplay.data.local

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

class AndroidDatabaseDriverFactory(
    private val context: Context,
) : DatabaseDriverFactory {
    override suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            LocalDatabase.Schema.synchronous(),
            context,
            "local.db"
        )
    }
}