import com.android.build.gradle.BaseExtension

fun android(configuration: BaseExtension.() -> Unit) = configure(configuration)

apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.oma.android.login"

    buildFeatures.compose = true
}

dependencies {
    "implementation"(project(Modules.composeUi))
}