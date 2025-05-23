import com.android.build.gradle.BaseExtension

fun android(configuration: BaseExtension.() -> Unit) = configure(configuration)

apply {
    from("$rootDir/android-library-build.gradle")
}

android {
    namespace = "com.oma.android.domainmodel"
}

dependencies {
    "implementation"(project(Modules.projectTaskTimesheetData))
}