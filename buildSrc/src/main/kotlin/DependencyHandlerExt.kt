import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.kotlin() {
    add(IMPLEMENTATION, Dependencies.kotlinCore)
    //add(IMPLEMENTATION, Dependencies.kotlinCore)
}

fun DependencyHandler.compose() {
    add(IMPLEMENTATION, Dependencies.composeBOM)
    //add(IMPLEMENTATION, Dependencies.composeUi)
    //add(IMPLEMENTATION, Dependencies.composeActivity)
    //add(IMPLEMENTATION, Dependencies.composeFoundation)
    //add(IMPLEMENTATION, Dependencies.composeIconsCore)
    //(IMPLEMENTATION, Dependencies.composeLifecycle)
}

fun DependencyHandler.daggerHilt() {
    add(IMPLEMENTATION, Dependencies.hilt)
    add(KAPT, Dependencies.hiltCompiler)
}