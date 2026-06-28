package com.diegopalvarez.oreplay.app.di

import com.diegopalvarez.oreplay.data.local.AndroidDatabaseDriverFactory
import com.diegopalvarez.oreplay.data.local.DatabaseDriverFactory
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val platformModule = module {
    single {
        OkHttp.create()
    }
    single<DatabaseDriverFactory> {
        AndroidDatabaseDriverFactory(androidContext())
    }
}