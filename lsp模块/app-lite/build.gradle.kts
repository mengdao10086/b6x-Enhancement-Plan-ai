plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.waspwingtempctrl.lite"
    compileSdk = 34

    defaultConfig {
        // 与 GUI 同 applicationId + versionCode：两版互斥安装、可互相覆盖，数据目录共用
        applicationId = "com.example.waspwingtempctrl"
        minSdk = 25
        targetSdk = 34
        versionCode = 5
        versionName = "3.0-lite"
    }

    signingConfigs {
        create("b6x") {
            // 与 GUI 同一 keystore，保证可互相覆盖安装
            storeFile = file("../app/b6x.keystore")
            storePassword = "android"
            keyAlias = "b6x"
            keyPassword = "android"
            // lite 不在 CI 里重签：由 AGP 直接出 v2+v3（minSdk 25 不需要 v1）
            enableV1Signing = false
            enableV2Signing = true
            enableV3Signing = true
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("b6x")
            isMinifyEnabled = true
            isShrinkResources = true
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

    // 与 GUI 同理：签名块里的依赖树仅供 Play 索引，本模块侧载分发
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
}

dependencies {
    // 共享协议/配置/部署实现与资产。core 的运行时依赖为空（Xposed API 为 compileOnly），
    // lite 因此不会带进 material/appcompat/viewpager2/fragment。
    implementation(project(":core"))
}
