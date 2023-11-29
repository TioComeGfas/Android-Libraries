plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "cl.tiocomegfas.lib.uicompose"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.version.get()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Core
    implementation(libs.bundles.kotlin)
    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)


    implementation(libs.kotlin.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
    testImplementation(libs.testing.junit)
    androidTestImplementation(libs.android.testing.junit)
    androidTestImplementation(libs.android.testing.espresso.core)
}