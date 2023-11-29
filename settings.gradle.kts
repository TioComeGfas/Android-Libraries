pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs {
        create("libs") {
            from(files("../catalogAndroid/gradle/libs.versions.toml"))
        }
    }
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android-Libraries"
include(":app")
//include(":bluetooth")
//include(":ui-view")
//include(":network")
//include(":persistence")
//include(":catalog")
include(":core")
//include(":flagr")
//include(":ui-compose")
