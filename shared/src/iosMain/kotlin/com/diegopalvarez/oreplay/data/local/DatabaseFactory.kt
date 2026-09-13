package com.diegopalvarez.oreplay.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

class IOSDatabaseDriverFactory() : DatabaseDriverFactory {
    override suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            LocalDatabase.Schema,
            "local.db"
        )
    }
}