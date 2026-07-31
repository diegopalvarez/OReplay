import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeCacheApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    // Serialization
    alias(libs.plugins.kotlinSerialization)

    // SQLDelight
    alias(libs.plugins.sqlDelight)
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
            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.preferences)
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
        }
    }
}