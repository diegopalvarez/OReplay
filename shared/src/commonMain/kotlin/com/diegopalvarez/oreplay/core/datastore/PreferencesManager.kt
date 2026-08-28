package com.diegopalvarez.oreplay.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.diegopalvarez.oreplay.core.language.getDefaultLocale
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.minutes
import kotlin.time.toDuration

class PreferencesManager(
    private val dataStore: DataStore<Preferences>
) {
    // Call Coroutine Scope
    private val scope = CoroutineScope(Dispatchers.Default)

    // Preference 1 - Convert Timezone
    private val convertTimezoneKey = booleanPreferencesKey("convertTimezone")

    // By default, the timezones are converted
    val convertTimezone = dataStore
        .data
        .map { prefs -> prefs[convertTimezoneKey] }
        .stateIn(
            scope,
            SharingStarted.WhileSubscribed(5000L),
            true
        )

    fun toggleTimezonePreference(){
        scope.launch {
            dataStore.edit { mutablePrefs ->
                mutablePrefs[convertTimezoneKey] = !(mutablePrefs[convertTimezoneKey] ?: true)      // By default, it's true
            }
        }
    }

    // Preference 2 - Refresh interval
    private val convertRefreshKey = longPreferencesKey("refreshInterval")

    // By default, the timezones are converted
    val convertRefresh = dataStore
        .data
        .map { prefs -> prefs[convertRefreshKey] ?: 1.minutes.inWholeSeconds }
        .stateIn(
            scope,
            SharingStarted.WhileSubscribed(5000L),
            1.minutes.inWholeSeconds
        )

    fun changeRefreshInterval(
        newInterval: Long
    ){
        scope.launch {
            dataStore.edit { mutablePrefs ->
                mutablePrefs[convertRefreshKey] = newInterval
            }
        }
    }
}