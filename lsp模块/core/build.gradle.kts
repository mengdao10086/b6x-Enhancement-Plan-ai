plugins {
    id("com.android.library")
}

android {
    namespace = "com.example.waspwingtempctrl.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 25
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Xposed API (LSPosed 兼容)：仅 MainHook 编译用，类不进 APK
    compileOnly("de.robv.android.xposed:api:82")
    compileOnly("de.robv.android.xposed:api:82:sources")
}
