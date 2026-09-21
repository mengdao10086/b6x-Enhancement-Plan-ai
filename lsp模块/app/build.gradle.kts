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
        versionCode = 5
        versionName = "3.0"
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

    // 原生界面（androidx Material / appcompat）。版本对齐 compileSdk 34：
    // material 1.11.0 要求 compileSdk 34，appcompat 1.6.1 与之匹配。
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    // 显式声明：material 自己就传递依赖 viewpager2（1.0.0），但页面容器直接用它，
    // 由本模块声明版本才不会被传递版本的升降悄悄影响
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    // 显式声明：同上，material 传递依赖 androidx.transition，状态页的手动刷新补间（TransitionManager）直接用它
    implementation("androidx.transition:transition:1.2.0")
}

