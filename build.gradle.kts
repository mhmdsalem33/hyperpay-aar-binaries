plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.salem.hyperpayaar"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
            manifest.srcFile("src/main/AndroidManifest.xml")
        }
    }

    buildFeatures {
        buildConfig = false
    }
}

repositories {
    flatDir {
        dirs("libs")
    }
}

dependencies {
    implementation(name = "ipworks3ds_sdk_8648", ext = "aar")
    implementation(name = "oppwa.mobile-6.0.0-release", ext = "aar")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}