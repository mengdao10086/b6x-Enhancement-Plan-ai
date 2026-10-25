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

            // assets/dexopt/baseline.prof(+.profm) 实测 1,694 字节且为 STORED，
            // 全部来自 appcompat/material 等外部依赖带的 baseline-prof.txt。
            // 忽略外部依赖的 baseline profile 即可不再产出该资产（本项目无自建 profile）。
            optimization {
                baselineProfile {
                    ignoreFromAllExternalDependencies = true
                }
            }
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

    // 资源侧密度裁剪：库里 5 档密度（mdpi/hdpi/xhdpi/xxhdpi/xxxhdpi）的 appcompat
    // .9.png/图标各存一份，实测共 70,899 字节（STORED，1:1 落包）。只留 xxhdpi 一档、
    // 其余交给系统按密度缩放，约省 4/5。
    // 注意：resConfigs/resourceConfigurations 在 aapt2（aapt>=21）已不支持密度过滤，
    // 只能用 aapt2 的 --preferred-density（单档）。
    androidResources {
        additionalParameters("--preferred-density", "xxhdpi")
    }

    // AGP 会把依赖树加密写进 APK 签名块（DependencyInfoBlock，实测 3,907 字节），
    // 仅供 Google Play 做 SDK 索引。本模块走 GitHub Release 侧载、不上架 Play，
    // 关掉后签名块按 4096 对齐会从 8192 降到 4096。
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
}

dependencies {
    // 共享协议/配置/部署实现（MainHook、ConfigStore、Deployer、RootShell、AppFiles、StartupTiming、PageAware）
    implementation(project(":core"))

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
}

// ──────────────────────────────────────
// 预制造并发前提的构建期检查（Z-3）
// ──────────────────────────────────────
// 依据：ConfigPreInflater 用后台线程与主线程共用同一个 AppCompat 视图工厂（cloneInContext 按引用
// 复制 mFactory2），该工厂内有「无同步」的共享可变状态。当前安全「是布局属性决定的」——只有某个
// layout 里出现 android:theme / app:theme，才会走进 AppCompatViewInflater.createViewFromTag 那条
// 竞争分支（两根线程同时改 mConstructorArgs）。见 ConfigPreInflater.java 类注释 / app 逻辑说明.md §6.2。
//
// 本任务把这条「靠约定守住」的前提变成硬失败：扫 res/layout 下全部 .xml，出现主题属性即构建失败。
// 为什么扫整目录而非只扫 item_config_*：预制造实际 inflate 的布局含 item_chart_window_button.xml
// （enum 分组按钮复用它），并不匹配 item_config_* 前缀；扫整目录既覆盖它、也覆盖将来新增的预制造
// 布局，且与逻辑说明 §6.2 记下的不变量（「res/layout 下没有任何一处带主题属性」）同口径，无需维护清单。
// 代价：给「只在主线程 inflate 的布局」加主题属性也会被拦下——属可接受的假阳性（当前 0 处命中）。
val checkPreInflateThemeAttr by tasks.registering {
    // 配置期解析成 File / Regex 局部量：doLast 只捕获这两个可序列化对象，
    // 不把脚本实例（其持有 Project 引用）带进任务动作，保持与 configuration-cache 兼容。
    val layoutDir = file("src/main/res/layout")
    val themeAttrPattern = Regex("""(android|app):theme\s*=""")

    group = "verification"
    description = "断言 res/layout 下无 android:theme/app:theme（预制造跨线程共享视图工厂的安全前提）"
    inputs.dir(layoutDir)
    doLast {
        val xmls = layoutDir.listFiles { f -> f.isFile && f.name.endsWith(".xml") }
            ?: throw GradleException("布局目录不存在：$layoutDir")
        val hits = xmls.sortedBy { it.name }.flatMap { f ->
            f.readLines().withIndex()
                .filter { (_, line) -> themeAttrPattern.containsMatchIn(line) }
                .map { (i, line) -> "  ${f.name}:${i + 1}  ${line.trim()}" }
        }
        if (hits.isNotEmpty()) {
            throw GradleException(
                buildString {
                    appendLine("预制造并发前提被破坏：res/layout 下出现 android:theme / app:theme。")
                    appendLine("ConfigPreInflater 用后台线程与主线程共用 AppCompat 视图工厂（无同步共享可变状态，")
                    appendLine("见 ConfigPreInflater.java 类注释 / app 逻辑说明.md §6.2）：布局一旦带主题属性，")
                    appendLine("两根线程会并发进入 AppCompatViewInflater.createViewFromTag（同改 mConstructorArgs），")
                    appendLine("当前「安全是布局属性决定的」这条约定即失效。命中：")
                    hits.forEach { appendLine(it) }
                    append("处理：要么去掉该主题属性，要么先把预制造挪到首帧之后（与主线程 inflate 错开），再同步改本检查。")
                }
            )
        }
    }
}

// 挂到 preBuild：assembleDebug / assembleRelease 之前必跑（本地与 CI 的 ./gradlew assembleRelease 都覆盖；
// 也可单独跑 ./gradlew checkPreInflateThemeAttr）
tasks.named("preBuild") { dependsOn(checkPreInflateThemeAttr) }

