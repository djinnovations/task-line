import com.android.build.gradle.BaseExtension
import extensions.implementation
import extensions.ksp

fun android(configuration: BaseExtension.() -> Unit) = configure(configuration)

apply {
    from("$rootDir/android-library-build.gradle")
}

android {
    namespace = "com.oma.android.roomdb"
}

dependencies {
    implementation(AndroidX.roomRuntime)
    implementation(AndroidX.roomKtx)
    ksp(AndroidX.roomCompiler)
}