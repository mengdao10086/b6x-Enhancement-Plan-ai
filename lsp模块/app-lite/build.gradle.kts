import java.nio.file.Files
import java.nio.file.StandardCopyOption

plugins {
    id("com.android.application")
}

// WebUI 打包资源：源码保持可维护，打包时复制一份并只压缩 app.js。
// 生成目录整体替换 src/main/assets（先完整复制，再替换 webui/app.js），源码目录不动。
val webUiAssetsSrc = layout.projectDirectory.dir("src/main/assets")
val webUiAssetsOut = layout.buildDirectory.dir("generated/webUiAssets")

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

    // 打包只读生成目录（任务会完整复制后替换 app.js）；源码目录不再直接参与打包
    sourceSets.getByName("main").assets.setSrcDirs(listOf(webUiAssetsOut.get().asFile))
}

// ---- app.js 压缩：terser --compress --mangle --ecma 5；工具缺失即失败，不静默跳过 ----
abstract class PrepareWebUiAssetsTask : DefaultTask() {
    @get:InputDirectory
    abstract val sourceDir: DirectoryProperty

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @get:Internal
    abstract val workDir: DirectoryProperty

    @TaskAction
    fun prepare() {
        val src = sourceDir.get().asFile
        val outDir = outputDir.get().asFile
        outDir.deleteRecursively()
        src.copyRecursively(outDir, overwrite = true)

        val appJs = File(outDir, "webui/app.js")
        check(appJs.isFile) { "缺少 WebUI 源文件：$appJs" }
        val minified = File(outDir, "webui/app.js.min")
        val isWindows = System.getProperty("os.name").lowercase().contains("win")

        fun run(vararg cmd: String) {
            val process = ProcessBuilder(*cmd)
                .directory(workDir.get().asFile)
                .redirectErrorStream(true)
                .start()
            val output = process.inputStream.bufferedReader().readText()
            val code = process.waitFor()
            check(code == 0) { "命令失败（exit=$code）：${cmd.joinToString(" ")}\n$output" }
        }

        // 固定版本：npx 不写版本会随最新发布漂移，破坏发版构建的确定性
        run(
            if (isWindows) "npx.cmd" else "npx",
            "--yes", "terser@5.51.3", appJs.absolutePath,
            "--compress", "--mangle", "--ecma", "5", "--comments", "false",
            "--output", minified.absolutePath
        )
        Files.move(minified.toPath(), appJs.toPath(), StandardCopyOption.REPLACE_EXISTING)
        run(if (isWindows) "node.exe" else "node", "--check", appJs.absolutePath)

        // 契约自检：这些入口/字符串必须仍在（terser 只改本地名）
        val js = appJs.readText()
        listOf(
            "WaspBridge", "LiteApp", "applySysTheme",
            "defs", "snapshot", "chartData", "logs", "status",
            "setValues", "deploy", "uninstall", "startDaemon", "stopDaemon"
        ).forEach { key ->
            check(js.contains(key)) { "压缩后 app.js 丢失契约字符串：$key" }
        }
        logger.lifecycle("WebUI app.js 已压缩：${appJs.length()} B")
    }
}

val prepareWebUiAssets = tasks.register<PrepareWebUiAssetsTask>("prepareWebUiAssets") {
    description = "复制 WebUI 资产并以 terser 压缩 webui/app.js（不修改源码）"
    sourceDir.set(webUiAssetsSrc)
    outputDir.set(webUiAssetsOut)
    workDir.set(layout.projectDirectory)
}

tasks.matching { it.name.startsWith("merge") && it.name.endsWith("Assets") }
    .configureEach { dependsOn(prepareWebUiAssets) }
tasks.matching { it.name == "preBuild" }.configureEach { dependsOn(prepareWebUiAssets) }

dependencies {
    // 共享协议/配置/部署实现与资产。core 的运行时依赖为空（Xposed API 为 compileOnly），
    // lite 因此不会带进 material/appcompat/viewpager2/fragment。
    implementation(project(":core"))
}
