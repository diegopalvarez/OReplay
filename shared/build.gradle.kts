import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    // Serialization
    alias(libs.plugins.kotlinSerialization)

    // SQLDelight
    alias(libs.plugins.sqlDelight)

    // KMP Native Coroutines
    alias(libs.plugins.kmpNativeCoroutines)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
            linkerOpts("-miphoneos-version-min=16.0")
            linkerOpts("-mios-simulator-version-min=16.0")
        }
    }

    // Web Target
    js {
        browser()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    
    androidLibrary {
       namespace = "com.diegopalvarez.oreplay.shared"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)

            // Decompose
            implementation(libs.decompose)

            // Dependency Injection
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)

            // HTTP Requests
            implementation(libs.ktor.client.okhttp)

            // SQLDelight
            implementation(libs.sqldelight.android)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            // Decompose
            implementation(libs.decompose)
            implementation(libs.decompose.jetbrains)
            implementation(libs.decompose.extensions.experimental)

            // Serialization
            implementation(libs.kotlinx.serialization.json)

            // Dependency Injection
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // HTTP Requests
            implementation(libs.bundles.ktor)

            // DateTime
            implementation(libs.kotlinx.datetime)

            // DataStore
            implementation(libs.androidx.datastore.core)
            implementation(libs.androidx.datastore.preferences.core)

            // Material3 Adaptive Layout
            implementation(libs.compose.material3.adaptive)
            implementation(libs.compose.material3.adaptive.layout)
            implementation(libs.compose.material3.adaptive.navigation)

            // Material3 Window Size Class
            implementation(libs.compose.material3.adaptive.navigation.suite)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            //implementation(kotlin("test-annotations-common"))
            implementation(libs.assertk)

            implementation(libs.compose.ui.test)

            // Ktor Testing
            implementation(libs.ktor.client.mock)
            implementation(libs.assertk)
            implementation(libs.turbine)
            implementation(libs.coroutines.test)
        }

        iosMain.dependencies {
            // HTTP Requests
            implementation(libs.ktor.client.darwin)

            // SQLDelight
            implementation(libs.sqldelight.ios)
        }

        jsMain.dependencies {
            implementation(libs.wrappers.browser)
        }

        webMain.dependencies {
            // HTTP Requests
            implementation(libs.ktor.client.js)

            // SQLDelight
            implementation(libs.sqldelight.web)
            implementation(devNpm("copy-webpack-plugin", "9.1.0"))

            // SQL.js
            implementation(npm("@cashapp/sqldelight-sqljs-worker", "2.3.2"))
            implementation(npm("sql.js", "1.8.0"))

            // DateTime
            implementation(npm("@js-joda/timezone", "2.25.1"))
        }

        all {
            languageSettings {
                optIn("kotlin.experimental.ExperimentalObjCName")
            }
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}

// SQLDelight Database
sqldelight {
    databases {
        create("LocalDatabase") {
            packageName.set("com.diegopalvarez.oreplay.data.local")
            generateAsync.set(true)
        }
    }
}