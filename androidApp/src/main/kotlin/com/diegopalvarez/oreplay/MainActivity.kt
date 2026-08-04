package com.diegopalvarez.oreplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.diegopalvarez.oreplay.app.App
import com.diegopalvarez.oreplay.app.navigation.RootComponent
import com.arkivanov.decompose.retainedComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val root = retainedComponent {
            RootComponent(
                componentContext = it
            )
        }

        setContent {
            App(root = root)
        }
    }
}