package com.diegopalvarez.oreplay.data.local

import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface DatabaseDriverFactory {
    suspend fun createDriver(): SqlDriver
}

class CacheDatabase private constructor(
    val database: LocalDatabase,
) {
    // Create a suspend constructor
    companion object {
        suspend fun create(
            databaseDriverFactory: DatabaseDriverFactory
        ): CacheDatabase {
            val driver = databaseDriverFactory.createDriver()

            return CacheDatabase(
                LocalDatabase(driver)
            )
        }
    }

    // private val query = database.localDatabaseQueries    // Object that gives access to all the different methods created automatically by SQLDelight
}