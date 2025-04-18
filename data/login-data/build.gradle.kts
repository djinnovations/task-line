import com.android.build.gradle.BaseExtension

fun android(configuration: BaseExtension.() -> Unit) = configure(configuration)

apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.oma.android.login.data"
}

dependencies {
    "implementation"(project(Modules.roomDb))
    "implementation"(project(Modules.dataUtils))
    "implementation"(project(Modules.base))
}