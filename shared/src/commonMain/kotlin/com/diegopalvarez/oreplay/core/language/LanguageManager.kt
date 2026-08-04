package com.diegopalvarez.oreplay.core.language

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.get

class LanguageManager(
    private val dataStore: DataStore<Preferences>
) {
    // Call Coroutine Scope
    private val scope = CoroutineScope(Dispatchers.Main)

    private val languageCodeKey = stringPreferencesKey("languageCode")

    val languageCode = dataStore
        .data
        .map { prefs -> prefs[languageCodeKey] }
        .stateIn(
            scope,
            SharingStarted.WhileSubscribed(5000L),
            getDefaultLocale()
        )

    fun switchLanguage(languageCode: String) {
        scope.launch {
            dataStore.edit { mutablePrefs ->
                mutablePrefs[languageCodeKey] = languageCode
            }
        }

        // TODO - Check if this is actually needed since it doesn't solve the Date Picker language problem
        // Also set the actual application locale to the new language
        setApplicationLocale(languageCode)
    }
}