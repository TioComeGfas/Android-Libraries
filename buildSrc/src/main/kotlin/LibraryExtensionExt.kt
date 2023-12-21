import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun LibraryExtension.sdkVersions(
    min: Int = Versions.minSdk.toInt(),
    max: Int = Versions.targetSdk.toInt()
) {
    compileSdk = max
    this.defaultConfig.minSdk = min
}

fun LibraryExtension.setPackage(pkg: String) {
    namespace = pkg
}

fun LibraryExtension.configureTestInstrumentation() {
    defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    defaultConfig.consumerProguardFiles("consumer-rules.pro")
}

fun LibraryExtension.releaseConfiguration(
    isObfuscated: Boolean
) {
    buildTypes {
        release {
            isJniDebuggable = false
            isMinifyEnabled = isObfuscated
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

fun LibraryExtension.debugConfiguration(
    isObfuscated: Boolean
) {
    buildTypes {
        debug {
            isJniDebuggable = true
            isMinifyEnabled = isObfuscated
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

fun LibraryExtension.configureJavaAndKotlin(version: JavaVersion) {
    compileOptions {
        sourceCompatibility = version
        targetCompatibility = version
    }

    (this as ExtensionAware).extensions.configure(
        "kotlinOptions",
        object: Action<KotlinJvmOptions> {
            override fun execute(t: KotlinJvmOptions) {
                t.jvmTarget = version.name.replace("VERSION_","").replace("_", ".")
            }
        }
    )
}

fun LibraryExtension.configureCompose() {
    buildFeatures.compose = true
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}