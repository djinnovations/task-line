import com.android.build.gradle.BaseExtension
import extensions.api

fun android(configuration: BaseExtension.() -> Unit) = configure(configuration)

apply {
    // Precompiled plugin with the base android configuration.
    from("$rootDir/android-library-build.gradle")
}

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.oma.android.composeui"
    // ===== compose =====
    buildFeatures.compose = true
}

dependencies {
    "api"(platform(JetpackCompose.bom))

    api(JetpackCompose.composeBlur)
    api(JetpackCompose.composeMaterial3)
    api(JetpackCompose.composeFoundation)
    api(JetpackCompose.composeFoundationLayout)
    api(JetpackCompose.composeUi)
    api(JetpackCompose.composeUiGraphics)
    api(JetpackCompose.composePreview)
    api(JetpackCompose.composeTooling)
    api(JetpackCompose.composeBinding)
    api(JetpackCompose.composeActivity)
    api(JetpackCompose.composeLifecycle)
    api(JetpackCompose.composeRuntime)
    api(JetpackCompose.composeLiveData)
    api(JetpackCompose.composeRuntimeSaveable)
    api(JetpackCompose.composeCoil)
    api(JetpackCompose.animation)
    api(JetpackCompose.balloon)
    api(JetpackCompose.composeMaterialIcons)
    api(JetpackCompose.composeNavigation)
    api(JetpackCompose.hiltCompose)
    api(AndroidX.navigationRuntime)
    api(AndroidX.navigationUiKtx)
    api(AndroidX.navigationFragmentKtx)
    api(AndroidX.lifecycleCompose)
    api(Kotlin.collectionImmutable)
    api(MiscSdks.intuitSdp)
    api(MiscSdks.intuitSsp)
}