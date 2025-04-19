plugins {
    id("com.android.application") version "8.8.2" apply false
    id("org.jetbrains.kotlin.android") version Kotlin.version apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.google.firebase.crashlytics") version "3.0.3" apply false
    id("com.google.devtools.ksp") version Kotlin.kspVersion apply false
    id("com.google.dagger.hilt.android") version "2.51" apply false
    id("com.android.library") version "8.8.2" apply false
    id("org.jetbrains.kotlin.plugin.compose") version Kotlin.version apply false
    id("org.jetbrains.kotlin.plugin.serialization") version Kotlin.version apply false
}