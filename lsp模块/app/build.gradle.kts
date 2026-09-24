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

        // 只保留中英：库自带 ja/ru/de/fr/ko/es 全套译文，而 resources.arsc 是 STORED 未压缩，
        // 删掉的字节 1:1 落到 APK 体积。只过滤 locale 维度，密度等维度不受影响。
        // AGP 8.2.0 无 androidResources.localeFilters（该 DSL 自 8.8 起才有），
        // 故用 resourceConfigurations——resConfigs 的现行名，8.2 尚未标记废弃。
        resourceConfigurations += listOf("zh", "en")
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
            // 代码与资源必须同时裁剪：只开 isShrinkResources 而 isMinifyEnabled=false 时 AGP 直接报错
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

    // 本工程是纯 Java（无 .kt 源），以下三类是 kotlin-stdlib / coroutines 传递进来的零引用资产。
    // kotlin_builtins 用 ** 开头：实测 kotlin/**/*.kotlin_builtins 匹配不到顶层
    // kotlin/kotlin.kotlin_builtins（5,004 字节，会 1:1 进包）。
    packaging {
        resources {
            excludes += listOf(
                "DebugProbesKt.bin",
                "**/*.kotlin_builtins",
                "META-INF/*.version"
            )
        }
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

