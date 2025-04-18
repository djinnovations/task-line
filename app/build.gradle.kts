import extensions.ksp

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.oma.android.taskline"
    compileSdk = BuildInfo.compileSdk

    defaultConfig {
        applicationId = "com.oma.android.taskline"
        minSdk = BuildInfo.minSdk
        targetSdk = BuildInfo.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_9
        targetCompatibility = JavaVersion.VERSION_1_9
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_9.toString()
    }
    buildFeatures {
        viewBinding = true
        compose = true
        buildConfig = true
    }
}

dependencies {
    "implementation"(project(Modules.composeUi))
    "implementation"(project(Modules.login))
    "implementation"(project(Modules.base))
    "implementation"(project(Modules.dashboard))

    // Test
    AndroidTest.dependencies.forEach { androidTestImplementation(it) }

    // Hilt
    implementation(Hilt.daggerHiltAndroid)
    ksp(Hilt.daggerHiltCompiler)
}