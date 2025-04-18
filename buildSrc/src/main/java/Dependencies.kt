object AndroidX {
    const val navigationVersion = "2.7.7"
    const val lifecycleVersion = "2.8.0"

    // AndroidX (https://developer.android.com/jetpack/androidx/versions)
    const val activityKtx = "androidx.activity:activity-ktx:1.9.0"
    const val appCompat = "androidx.appcompat:appcompat:1.6.1"
    const val browser = "androidx.browser:browser:1.8.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val coreKtx = "androidx.core:core-ktx:1.13.1"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.7.1"
    const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val lifecycleCompose = "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVersion"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    const val navigationRuntime = "androidx.navigation:navigation-runtime-ktx:$navigationVersion"
    const val preferencesKtx = "androidx.preference:preference-ktx:1.2.1"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.3.2"
    const val roomRuntime = "androidx.room:room-runtime:2.6.1"
    const val roomKtx = "androidx.room:room-ktx:2.6.1"
    const val roomCompiler = "androidx.room:room-compiler:2.6.1"
    const val workRuntime = "androidx.work:work-runtime-ktx:2.9.0"

    // Splash Screen (https://developer.android.com/develop/ui/views/launch/splash-screen)
    const val splashScreen = "androidx.core:core-splashscreen:1.0.1"
    const val dataStorePreferences = "androidx.datastore:datastore-preferences:1.1.1"
    const val paletteApi = "androidx.palette:palette-ktx:1.0.0"
}

object Kotlin {
    // Kotlin (https://blog.jetbrains.com/kotlin/category/releases)
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin
    const val version = "2.0.20"
    const val kspVersion = "2.0.20-1.0.25"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$version"

    // Kotlin Coroutines (https://github.com/Kotlin/kotlinx.coroutines/releases)
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"
    const val coroutinesPlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3"
    const val collectionImmutable = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.8"
}

object Google {
    // Google Play Services (https://developers.google.com/android/guides/releases)
    // Also: https://developers.google.com/android/guides/setup
    // And: https://developers.google.com/admob/android/rel-notes
    const val protoBufVersion = "3.24.0"
    const val playCore = "com.google.android.play:core:1.10.3"
    const val playServicesBase = "com.google.android.gms:play-services-base:18.4.0"
    const val playServicesAuth = "com.google.android.gms:play-services-auth:21.1.1"
    const val protoBuf = "com.google.protobuf:protobuf-javalite:$protoBufVersion"
}

object Firebase {
    // Firebase (https://firebase.google.com/support/release-notes/android)
    const val bom = "com.google.firebase:firebase-bom:33.12.0"
    const val auth = "com.google.firebase:firebase-auth"
    const val config = "com.google.firebase:firebase-config"
    const val crashlytics = "com.google.firebase:firebase-crashlytics"
}

object Material {
    // Material Design (https://github.com/material-components/material-components-android/releases)
    const val materialDesign = "com.google.android.material:material:1.12.0"
}

object MiscSdks {
    // Intuit Size unit library
    // https://github.com/intuit/sdp
    const val intuitSdp = "com.intuit.sdp:sdp-android:1.1.1"
    const val intuitSsp = "com.intuit.ssp:ssp-android:1.1.1"

    //AWS
    const val awsSdkCore = "com.amazonaws:aws-android-sdk-core:2.16.6"
    const val awsSdkS3 = "com.amazonaws:aws-android-sdk-s3:2.22.4"

    // QR code
    const val qrZxing = "com.google.zxing:core:3.4.1"

    // My script lib for OCR
    const val myScript = "com.myscript:iink:4.0.0"


    // Glide (https://github.com/bumptech/glide/releases)
    const val glideSdk = "com.github.bumptech.glide:glide:4.15.1"
    const val glideKaptCompiler = "com.github.bumptech.glide:compiler:4.15.1"

    // Joda (https://github.com/dlew/joda-time-android)
    // Need to update it later carefully by checking time everywhere
    const val jodaTime = "net.danlew:android.joda:2.10.14"

    // GSON (https://github.com/google/gson/releases)
    const val gson = "com.google.code.gson:gson:2.10.1"

    // Android Image Picker (https://github.com/esafirm/android-image-picker)
    const val imagePicker = "com.github.esafirm.android-image-picker:imagepicker:2.4.5"

    //junit test
    const val junit = "junit:junit:4.13.2"

    // Youtube iFrame Player (https://github.com/PierfrancescoSoffritti/android-youtube-player)
    const val youtubePlayer = "com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0"

    // read ppt file
    const val aspose = "libs/aspose-slides-24.12-android.via.java.jar"

    // Realm Db
    const val realmDb = "io.realm.kotlin:library-base:2.3.0"
}

object Hilt {
    // DI (https://developer.android.com/training/dependency-injection/hilt-android)
    const val plugin = "com.google.dagger.hilt.android"

    const val version = "2.51"
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:$version"
    const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:$version"

    const val hiltWorker = "androidx.hilt:hilt-work:1.2.0"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.2.0"
//
//    // https://developer.android.com/training/dependency-injection/hilt-jetpack
//    const val hiltFragment = "androidx.hilt:hilt-navigation-fragment:1.2.0"
}

object Paging {
    const val paging_version = "3.3.0"
    val paging = "androidx.paging:paging-runtime:$paging_version"
    val pagingCommon = "androidx.paging:paging-common:$paging_version"
    val pagingCompose = "androidx.paging:paging-compose:$paging_version"
    val pagingComposeAndroid = "androidx.paging:paging-compose-android:$paging_version"
}

object Media3 {
    const val version = "1.3.1"
    const val exoplayer = "androidx.media3:media3-exoplayer:$version"
    const val exoplayerDash = "androidx.media3:media3-exoplayer-dash:$version"
    const val exoplayerHls = "androidx.media3:media3-exoplayer-hls:$version"
    const val mediaUi = "androidx.media3:media3-ui:$version"
    const val mediaSession = "androidx.media3:media3-session:$version"
    const val dataSource = "androidx.media3:media3-datasource:$version"
    const val database = "androidx.media3:media3-database:$version"
    const val exoPlayerIMA = "androidx.media3:media3-exoplayer-ima:$version"
}

object JetpackCompose {
    const val bom = "androidx.compose:compose-bom:2024.05.00"
    const val composeMaterial3 = "androidx.compose.material3:material3:1.2.1"
    const val composeFoundation = "androidx.compose.foundation:foundation"
    const val composeFoundationLayout = "androidx.compose.foundation:foundation-layout"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeNavigation = "androidx.navigation:navigation-compose:"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeTooling = "androidx.compose.ui:ui-tooling"
    const val composeBinding = "androidx.compose.ui:ui-viewbinding"
    const val composeActivity = "androidx.activity:activity-compose:1.9.0"
    const val composeLifecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata"
    const val composeRuntime = "androidx.compose.runtime:runtime"
    const val composeRuntimeSaveable = "androidx.compose.runtime:runtime-saveable"
    const val composeCoil = "io.coil-kt:coil-compose:2.6.0"
    const val composeBlur = "com.github.skydoves:cloudy:0.1.2"
    const val animation = "androidx.compose.animation:animation-android:1.6.7"
    const val composeMaterialIcons = "androidx.compose.material:material-icons-extended:1.2.1"
    const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.2.0"

    //https://github.com/skydoves/Balloon#balloon-in-jetpack-compose-1
    const val balloon = "com.github.skydoves:balloon-compose:1.6.11"
}

object AndroidTest {
    const val jUnit = "junit:junit:4.13.2"
    const val androidJUnit = "androidx.test.ext:junit:1.1.5"
    const val androidRunner = "androidx.test:runner:1.5.2"
    const val espresso = "androidx.test.espresso:espresso-core:3.5.1"

    val dependencies = listOf(
        jUnit,
        androidJUnit,
        androidRunner,
        espresso
    )
}