package com.diegopalvarez.oreplay.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

fun createDataStore(
    storage: Storage<Preferences>,
): DataStore<Preferences> {
    return DataStoreFactory.create(
        storage = storage,
    )
}

internal const val dataStoreFileName = "prefs.preferences_pb"