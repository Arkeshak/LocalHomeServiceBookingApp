pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("com.android.application") version "8.3.2"
        id("org.jetbrains.kotlin.android") version "2.0.21"

        // ✅ REQUIRED for Compose with Kotlin 2.0
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"

        id("com.google.gms.google-services") version "4.4.2"
    }
}

    dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LocalHomeServiceBookingApp"
include(":app")
