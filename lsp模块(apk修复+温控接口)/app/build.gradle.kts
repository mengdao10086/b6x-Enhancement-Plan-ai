plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.waspwingtempctrl"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.waspwingtempctrl"
        minSdk = 25
        targetSdk = 34
        versionCode = 2
        versionName = "2.0"
    }

    signingConfigs {
        create("b6x") {
            storeFile = file("b6x.keystore")
            storePassword = "android"
            keyAlias = "b6x"
            keyPassword = "android"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("b6x")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Xposed API (LSPosed 兼容)
    compileOnly("de.robv.android.xposed:api:82")
    compileOnly("de.robv.android.xposed:api:82:sources")
}
