package com.diegopalvarez.oreplay.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

class AndroidDatabaseDriverFactory(
    private val context: Context,
) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            LocalDatabase.Schema,
            context,
            "local.db"
        )
    }
}