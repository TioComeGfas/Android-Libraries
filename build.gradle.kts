buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:${libs.versions.agp.version}")
    }
}
plugins {
    alias(libs.plugins.application) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.java) apply false
    alias(libs.plugins.parcelable) apply false
}