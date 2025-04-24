import com.android.build.gradle.BaseExtension

fun android(configuration: BaseExtension.() -> Unit) = configure(configuration)

apply {
    from("$rootDir/android-library-build.gradle")
}

android {
    namespace = "com.oma.android.projecttask.data"
}

dependencies {
    "implementation"(project(Modules.roomDb))
    "implementation"(project(Modules.base))
}