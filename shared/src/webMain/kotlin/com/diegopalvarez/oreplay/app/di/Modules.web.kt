package com.diegopalvarez.oreplay.app.di

import com.diegopalvarez.oreplay.core.datastore.createDataStore
import com.diegopalvarez.oreplay.data.local.DatabaseDriverFactory
import com.diegopalvarez.oreplay.data.local.WebDatabaseDriverFactory
import io.ktor.client.engine.js.Js
import org.koin.dsl.module

actual val platformModule = module {
    single {
        Js.create()
    }
    single<DatabaseDriverFactory> {
        WebDatabaseDriverFactory()
    }
    single {
        createDataStore()
    }
}