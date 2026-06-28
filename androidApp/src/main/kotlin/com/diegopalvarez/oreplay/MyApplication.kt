package com.diegopalvarez.oreplay

import android.app.Application
import com.diegopalvarez.oreplay.app.di.initKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        // Additional AndroidContext can be added if needed
    }
}