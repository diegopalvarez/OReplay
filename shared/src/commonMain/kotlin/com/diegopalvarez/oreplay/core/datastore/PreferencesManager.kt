package com.diegopalvarez.oreplay.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.diegopalvarez.oreplay.core.language.getDefaultLocale
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PreferencesManager(
    private val dataStore: DataStore<Preferences>
) {
    // Call Coroutine Scope
    private val scope = CoroutineScope(Dispatchers.Main)

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
}