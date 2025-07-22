plugins {
    id("com.android.library") version "8.1.1"
    id("org.jetbrains.kotlin.android") version "1.9.10"
    id("maven-publish")
}

android {
    namespace = "com.salem.hyperpayaar"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    publishing {
        singleVariant("release")
    }

    buildFeatures {
        buildConfig = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.aar"))))
}