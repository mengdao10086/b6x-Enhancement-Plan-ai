# 路线 A — 线 B 进展（APK 工程骨架 + RootShell）

## 改动（只碰了这些文件）
- 新增 `lsp模块(apk修复+温控接口)/app/src/main/java/com/example/waspwingtempctrl/RootShell.java`
- 新增 `.../SetupActivity.java`（最小壳，无 res 引用，线 D 接手时整体替换）
- 改 `app/src/main/AndroidManifest.xml`：加 SetupActivity（LAUNCHER / `exported="true"`）；**未加任何权限**（本批确实不需要）
- 改 `app/build.gradle.kts`：+ `appcompat:1.6.1`、`material:1.11.0`（对齐 compileSdk 34）；xposed `compileOnly` 原样；`targetSdk` 保持 34
- `MainHook.java` / `assets/**` / `res/**` / `magisk模块(智能温控)/**` 一个字未动

## 编译验证：通过（真 build，非静态检查）
本机无 Android SDK 且工程路径含非 ASCII（AGP 直接拒绝），故在 `%TEMP%\wwbuild\proj`（ASCII 副本）用临时装的 SDK 34 + JDK 17 验证：
- `assembleDebug` 与 `assembleRelease` 均 BUILD SUCCESSFUL（后者即 CI 实际跑的变体，含 `lintVitalRelease`）
- 产物核对：versionCode 4 / versionName 2.6 未变；targetSdk 34、minSdk 25；xposed 四条 meta-data 完好；launcher activity 存在且 `exported=true`
- 唯一新增权限是 androidx.core 自动带的 `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`（本包自签名权限，非用户可见权限）。appcompat/material 会额外合并 androidx.startup 等 provider，只在本模块自身进程生效，不影响宿主
- 临时工具链留在 `%TEMP%\wwbuild\`（sdk/ + jdk-17.0.2/），可复用或直接删

## I2 冻结：`RootShell`（包 `com.example.waspwingtempctrl`）
`static RootShell get(Context)` 单例；`enum SuType { MAGISK, KERNELSU, APATCH, UNKNOWN }`

**嗅探 / 选型**（除 `detectSuType` 外均不阻塞）：`SuType getSuType()` 缓存值 · `SuType detectSuType(boolean force)` 阻塞跑 `su -v` 并持久化 · `String getRecommendedSuCommand()` · `String getSuCommand()` 手动值优先 · `boolean isSuCommandManual()` · `void setSuCommand(String)`（空白串 = reset）· `void resetSuCommand()`
选型表：SDK<30 → `su`；SDK≥30+KERNELSU → `su -M`；SDK≥30+APATCH → `magisk su -mm`；MAGISK、UNKNOWN → `su`。

**判活**：`boolean isAlive()` 缓存不阻塞 · `boolean checkAlive()` 阻塞跑 `id` 并要求含 `uid=0`，命中退避窗口直接返回 false 不探测；自动模式依次试「选型命令 → 裸 `su`」，跑通的记为 workingCommand。退避 1s 起指数、上限 60s，**只作用于 `checkAlive()`**；`exec()` 不退避，但失败会更新退避窗口。

**执行**（阻塞，禁止主线程；脚本不得为空、不得含 `exit`）：`Result exec(String script)`（默认超时 30000ms）· `Result exec(String script, long timeoutMs)`
`Result`：`command / exitCode / stdout / stderr / timedOut / elapsedMs / channelFailed`；`isOk()` = 通道正常且 exitCode==0；`describe()` 出诊断串。

**常驻会话**：`Session openSession()`；`write(String,long)` / `isAlive()` / `lastCommandOk()` / `getOpenError()` / `close()`。真常驻：结束标记 `__WW_END_<seq>__ $?` + 读超时 + 退出码回传；`cd` / `export` 跨命令保留。

**诊断**：`String buildDiagnostics()` —— 模式 / SU CMD / 实测可用命令 / 通道 / 当前用户 / SDK / 最近错误（阻塞探测一次）

**线程模型**：仅 `getSuType` `getSuCommand` `getRecommendedSuCommand` `isSuCommandManual` `isAlive` `Session.isAlive` 不阻塞；其余一律阻塞 I/O，线 C / 线 D 必须放后台线程。

## 未决（需主窗口拍板）
1. **选型表与文档口径不一致**：`待办.md` 第 111 行「SDK≥30 其他 → `magisk su -mm`」，而 Scene 源码（`scene相关/decompiled/sources/a/a70.java` 的 `f()`）MAGISK 是单独一支 → `su`，只有 APATCH 才落到 `magisk su -mm`。本实现照源码；若要按文档改，只需改 `getRecommendedSuCommand()` 一处。
2. **`magisk` 不在 app 的 PATH**：`magisk su -mm` 由 app 进程 `Runtime.exec` 启动，用的是 app 的 PATH 而非 su 的；APATCH 设备上可能起不来。已用 `checkAlive()` 的「退回裸 `su`」+ 手动切换兜底。
3. 权限（`POST_NOTIFICATIONS` 等）留到后续批次；线 D 换 AppCompatActivity 时需在 `res/values/themes.xml` 加 AppCompat/Material 主题（`res/**` 属线 D）。

## 追加：`MainHook.java` 的 last_dev 落点迁移（第 2 批）
`tempctrl_last_dev` 由 `/data/local/tmp/`（四包共用）迁到宿主 app 私有目录 `/data/data/<宿主包名>/files/tempctrl_last_dev`，各包各记。共改 4 处（+24/-4）：
1. 常量 `LAST_DEV_FILE` 删除，换成 `private static String lastDevFile`（在 `handleLoadPackage` 赋值）
2. `handleLoadPackage` 两个命中分支各加一行赋值；**键是包名常量不是 `appKind`**——包名常量 3 个（`PACKAGE_B6X` / `PACKAGE_B6X_NEW` / `PACKAGE_B7X`）而 `appKind` 只有 6/7 两值，**不是一一对应**，按 `appKind` 拼会把两个 B6X 包并成同一个文件
3. 新增 `lastDevFileFor(String pkg)` → `"/data/data/" + pkg + "/files/tempctrl_last_dev"`；不用 `getFilesDir()`（冷启动可能早于 Application 挂载拿不到 context），故 path 拼死
4. `saveLastDeviceAddress` 写前 `getParentFile().mkdirs()`；读/写各加一行 `lastDevFile == null` 防御性早返回

未动：`STATUS_FILE_B6/B7` 与 status 字段、广播 action/extra、`AUTO_LAUNCH_EXTRA`、一切钩子逻辑；未加旧路径兼容读取（一次性切换）。`loadLastDeviceAddress` 的「无记录 → 静默 null / 异常 → 带路径与异常类型记日志」语义原样保留。
验证：`assembleDebug` + `assembleRelease` 双 BUILD SUCCESSFUL。
