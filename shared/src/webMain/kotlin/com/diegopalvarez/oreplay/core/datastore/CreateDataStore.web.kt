package com.diegopalvarez.oreplay.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.okio.WebLocalStorage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesSerializer

fun createDataStore(): DataStore<Preferences> {
    return createDataStore(
        storage = WebLocalStorage(
            serializer = PreferencesSerializer,
            name = dataStoreFileName
        )
    )
}