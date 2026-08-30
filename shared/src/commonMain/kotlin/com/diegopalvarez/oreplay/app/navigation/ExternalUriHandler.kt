package com.diegopalvarez.oreplay.app.navigation

object ExternalUriHandler {
    private var cached: String? = null

    var listener: ((uri: String) -> Unit)? = null
        set(value) {
            field = value
            if(value != null) {
                cached?.let { cachedURL ->
                    value.invoke(cachedURL)
                }
                cached = null
            }
        }

    // Function that handles every new received external URL
    fun onNewUri(uri: String) {
        // First cache the uri in the object
        // If there's no listener set up, caching it lets it handle the uri link later
        cached = uri

        // If there's a listener already set up, invoke it
        listener?.let {
            it.invoke(uri)
            cached = null
        }
    }
}