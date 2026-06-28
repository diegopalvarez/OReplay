package com.diegopalvarez.oreplay.app.di

import com.diegopalvarez.oreplay.data.local.DatabaseDriverFactory
import com.diegopalvarez.oreplay.data.local.IOSDatabaseDriverFactory
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule = module {
    single {
        Darwin.create()
    }
    single<DatabaseDriverFactory> {
        IOSDatabaseDriverFactory()
    }
}