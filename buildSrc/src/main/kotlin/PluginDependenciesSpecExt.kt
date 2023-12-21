import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.application() {
    id("com.android.application")
}

fun PluginDependenciesSpec.library() {
    id("com.android.library")
}

fun PluginDependenciesSpec.kotlin() {
    id("org.jetbrains.kotlin.android")
}

fun PluginDependenciesSpec.kapt() {
    id("kotlin-kapt")
}

fun PluginDependenciesSpec.daggerHilt() {
    id("com.google.dagger.hilt.android")
}



// alias(libs.plugins.application)
//    alias(libs.plugins.kotlin)
//    alias(libs.plugins.kapt)
//    alias(libs.plugins.kotlin.serialization)
//    alias(libs.plugins.dagger.hilt)
//    id("com.google.gms.google-services")
//    id("com.google.firebase.crashlytics")