package com.diegopalvarez.oreplay.data.local

import app.cash.sqldelight.db.SqlDriver

interface DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

class CacheDatabase(
    databaseDriverFactory: DatabaseDriverFactory
) {
    private val database = LocalDatabase(
        databaseDriverFactory.createDriver()
    )

    // private val query = database.localDatabaseQueries    // Object that gives access to all the different methods created automatically by SQLDelight
}