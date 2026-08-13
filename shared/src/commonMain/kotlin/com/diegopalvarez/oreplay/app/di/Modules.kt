package com.diegopalvarez.oreplay.app.di

import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.core.language.LanguageManager
import com.diegopalvarez.oreplay.core.network.createHttpClient
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.domain.repository.ClassResultsRepository
import com.diegopalvarez.oreplay.domain.repository.ClubResultsRepository
import com.diegopalvarez.oreplay.domain.repository.EventRepository
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single {
        createHttpClient(get())
    }.bind<HttpClient>()

    single {
        OReplayAPI(get())
    }

    single<LanguageManager> {
        LanguageManager(get())
    }

    single<PreferencesManager> {
        PreferencesManager(get())
    }

    single<EventRepository>{
        EventRepository(get())
    }

    single<StageRepository>{
        StageRepository(get())
    }

    single<ClassResultsRepository>{
        ClassResultsRepository(get())
    }

    single<ClubResultsRepository>{
        ClubResultsRepository(get())
    }
}