plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // ✅ APPLY Compose compiler
    id("org.jetbrains.kotlin.plugin.compose")

   // id("com.google.gms.google-services")
}


android {
    namespace = "com.example.localhomeservicebookingapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.localhomeservicebookingapp"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

dependencies {

    // Compose BOM
    implementation(platform("androidx.compose:compose-bom:2024.10.00"))

    // Core Compose
    implementation("androidx.activity:activity-compose")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
// Firebase BOM (manages versions automatically)
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))

// Firebase services
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("com.google.android.material:material:1.13.0")

    debugImplementation("androidx.compose.ui:ui-tooling")


    // Optional
    implementation("androidx.core:core-ktx:1.13.1")
}
