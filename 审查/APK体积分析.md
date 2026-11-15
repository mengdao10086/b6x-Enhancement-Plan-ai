# APK 体积实验与分析

> 2026-11-15。实验对象：`D:\下载\Edge\b6x-EP-v3.0-lite.apk`（173,803 B）与 `b6x-EP-v3.0.apk`（1,508,619 B）。
> 只改 `lsp模块/app-lite/proguard-rules.pro`（实验），未提交、未推送、未投放 Edge。实验结果已应用并保留，原始规则见 §1.5 回退方法。

## 0. 结论先行

| 任务 | 结论 |
|---|---|
| keep 规则收窄 | **成功**。回调定义保持 28 个 `afterHookedMethod` + 12 个 `beforeHookedMethod`，dex 减少 4,128 B（-2.62%），APK 减少 852 B |
| lite params.json 是否精简 | **没有精简**。两个 APK 内 `assets/params.json` 逐字节相同（md5 `85902d58…`，105,510 B） |
| GUI 体积 | dex 占 52.4%，resources.arsc 占 22.6%，res 文件占 14.2%。语言与密度已无修剪空间；唯一值得做的是「单布局依赖的 ConstraintLayout」 |

## 1. lite keep 规则收窄实验

### 1.1 改动

`lsp模块/app-lite/proguard-rules.pro` 第 17 行原为：

```proguard
-keep class com.example.waspwingtempctrl.MainHook$* { *; }
```

改为：

```proguard
-keepclassmembers class com.example.waspwingtempctrl.MainHook$* {
    protected void afterHookedMethod(de.robv.android.xposed.XC_MethodHook$MethodHookParam);
    protected void beforeHookedMethod(de.robv.android.xposed.XC_MethodHook$MethodHookParam);
}
```

### 1.2 数据（本地同环境重编，非跨版本对比）

| | 原规则（`{ *; }`） | 收窄后 | 差异 |
|---|---|---|---|
| APK 字节 | 173,807 | **172,955** | -852（-0.49%） |
| `classes.dex` 未压缩 | 157,668 | **153,540** | -4,128（-2.62%） |
| `afterHookedMethod` 定义 | 28 | **28** | 0 |
| `beforeHookedMethod` 定义 | 12 | **12** | 0 |
| 类总数 | 81 | 80 | -1 |
| `XC_MethodHook` 子类数 | 37 | **37** | 0 |

说明：Edge 的 lite 包是 CI 产物（C 二进制 75,176 B），本地基线重编后 `tempctrl-arm64` 为 75,328 B，因此本地基线 173,807 与 Edge 173,803 差 4 B，属正常；上表只用本地两次构建对比。

### 1.3 功能等价性核验

- 37 个 `XC_MethodHook` 子类数量不变；`MainHook` 主类保名（`xposed_init` 按名加载正常）。
- 收窄后回调类被混淆改名（如 `a/a0`），但方法名 `afterHookedMethod`/`beforeHookedMethod` 保留、父类 `de.robv.android.xposed.XC_MethodHook` 保留。Xposed 按对象虚分派，不依赖类名，因此改名不影响回调。
- 类数 81→80：少掉的是 1 个 `Object` 子类，属 R8 合并/删除死类；关键匿名类（`MainHook$2/$7/$40/$43`）的特征字符串在收窄包中仍全部存在。
- 可复现：最终包 md5 `b2d69ee3f7a5d698fd5e3edac716d985`，重编得到同一 md5。

### 1.4 风险

方法数量只能证明「方法还在」，不能证明「LSPosed 运行时真的会调用」。采纳前建议真机装一次 lite，确认 hook 生效（曲线/状态有数据）。另注意：GUI 不可照搬此规则——GUI 的 43 个 MainHook 内部类中 37 个被 R8 移除/合并，dex 里只剩 3 个 `afterHookedMethod` 定义（`g1/r`、`g1/t`、`g1/v`，带 `int` 标签做分发），方法定义数本来就只有 3/2，不能用数量判断。

### 1.5 回退方法

原规则与注释备份在 `/tmp/proguard-rules.pro.orig`（md5 `4aa42a80f5de70cd5870dfcb6bb8c6be`）。回退只需把第 14–20 行恢复为：

```proguard
# Xposed API 是 compileOnly：R8 full mode 会把匿名 XC_MethodHook 子类的
# afterHookedMethod/beforeHookedMethod 当死代码全部删除——hook 装得上但永不回调。
# 实测：不加本行时 lite 包内回调方法数量为 0（GUI 版类图下未触发，不可依赖）。
-keep class com.example.waspwingtempctrl.MainHook$* { *; }
```

## 2. lite 的 params.json 核实

1. 字节比对：两个 APK 解出的 `assets/params.json` md5 均为 `85902d58723b176c2093b28989a0b0b6`，`cmp` 判定完全相同，105,510 B。
2. 构建链核查：
   - `参数定义/gen_params.py` 的 `PRODUCTS` 只有一个 `params.json` 产物，目标固定为 `lsp模块/core/src/main/assets/params.json`，没有 lite 变体；
   - `app-lite/build.gradle.kts` 无 assets 过滤/替换；
   - `build_local_apk.sh` 只调 `./gradlew :app:assembleRelease :app-lite:assembleRelease`，无裁剪；
   - CI 的 `aapt2 optimize` 只折叠 GUI 资源（且断言 `classes.dex` 与 assets 不变），lite 不经过该步骤，只断言 `assets/params.json` 存在。
3. 消费方式：lite 的 `app-lite/src/main/assets/webui/app.js` 按 `defs.keys` / `defs.groups` 通用遍历渲染，不区分 lite。没有「按 lite 剔除某键」的代码或脚本。

**结论：lite 未精简 params.json，用户记忆与现状不符。** 若确实要精简，得在 `参数定义/params.def.json` 层面新增 lite 专用产物，并同步 C 端键表；仅改打包步骤无效。

## 3. GUI 体积构成

### 3.1 APK 分层

| 分区 | 未压缩 | 压缩后 | 占 APK |
|---|---|---|---|
| `classes.dex` | 1,634,948 | 791,074 | 52.4% |
| `resources.arsc`（STORED） | 340,516 | 340,516 | 22.6% |
| `res/` 671 个文件 | 488,454 | 214,122 | 14.2% |
| `assets/` 4 个 | 201,355 | 71,522 | 4.7% |
| `AndroidManifest.xml` | 5,760 | 1,800 | 0.1% |
| 签名块 / zip 目录等 | — | 约 89,500 | 5.9% |

assets 明细（压缩后）：`params.json` 23,745、`tempctrl-arm64` 39,762、`deploy/b6x-tempctrl.sh` 7,977、`xposed_init` 38。

### 3.2 dex 构成（按 R8 mapping 还原原始包名；口径为字节码 code 字节）

总代码 835.6 KB，dex 其余约 799 KB 为字符串/类型/方法 ID/调试信息等元数据。

| 原始包 | 方法数 | code KB | 占 code |
|---|---|---|---|
| `com.google.android.material` | 2,062 | 160.5 | 19.2% |
| `androidx.appcompat` | 2,106 | 149.4 | 17.9% |
| `com.example.waspwingtempctrl` | 1,036 | 140.7 | 16.8% |
| `androidx.recyclerview` | 673 | 79.8 | 9.5% |
| `androidx.constraintlayout` | 344 | 78.7 | 9.4% |
| `androidx.core` | 872 | 60.5 | 7.2% |
| `androidx.fragment` | 408 | 47.0 | 5.6% |
| `androidx.activity` | 185 | 14.7 | 1.8% |
| `androidx.transition` | 166 | 13.3 | 1.6% |
| `androidx.emoji2` | 172 | 12.0 | 1.4% |
| `kotlin` 全部 | 191 | 10.5 | 1.3% |
| `androidx.coordinatorlayout` | 99 | 10.4 | 1.2% |
| `androidx.viewpager2` | 111 | 9.8 | 1.2% |
| 其余（vectordrawable/collection/lifecycle 等） | — | 约 45 | 5.4% |

dex 头：string 9,308 / type 2,248 / proto 2,840 / field 6,457 / method 12,851 / class 1,513。

### 3.3 resources.arsc 与 res 配置

- 类型条目：attr 1,159、style 1,126、dimen 884、color 814、id 571、string 346、drawable 235、layout 110、integer 68。
- **语言**：`aapt2 dump resources` 中没有任何 locale 配置（zh/en 之外早已被 `resourceConfigurations` 截掉，剩余译文又被 shrink 清掉）。再砍语言：**0 收益**。
- **密度**：xxhdpi 33 个文件（20,482 B）+ xhdpi 5 个 9-patch（共 375 B）+ 1 个 hdpi style（无文件）。`--preferred-density xxhdpi` 已生效，再砍：**<1 KB**。
- 其他配置：v31 5,180 B、watch 1,204 B、land 1,131 B、v26 650 B、night 601 B、sw600dp 577 B，均为库内按配置保留的资源，合计压缩后约 10 KB；全部属于平板/横屏/夜间/手表兜底，删除收益小、风险大。
- res 文件大头：drawable 82,629、color 52,234、layout 51,997、anim 11,995、animator 11,023（均为压缩后）。

### 3.4 已做过、无需重复建议的优化

`isMinifyEnabled + isShrinkResources`、`resourceConfigurations` 中英、`--preferred-density xxhdpi`、`nonTransitiveRClass`、关闭 baseline profile、剔除 kotlin_builtins/版本文件、关闭 v1 签名（约省 59 KB）、`-overloadaggressively`、CI 的 `aapt2 optimize --collapse-resource-names --deduplicate-entry-values` 与 19 个无用 layout 删除。这些已在现状中生效。

## 4. 可优化项清单

| # | 项目 | 预估收益 | 风险 | 说明 |
|---|---|---|---|---|
| 1 | lite keep 收窄（本实验） | APK -852 B，dex -4,128 B | 低风险 | 已应用；需真机确认 hook 回调 |
| 2 | 移除 ConstraintLayout | APK 约 -60～75 KB | 需验证 | `fragment_log.xml` 是唯一使用处（344 方法 / 78.7 KB code），依赖由 Material 传递引入（2.0.1）。需把该布局改成 LinearLayout/FrameLayout + 在 `configurations.configureEach` 排除，真机看日志页滚动/布局。收益按 code×1.96 元数据系数、再乘 dex 压缩率 0.484 估算 |
| 3 | GUI 加回调保护规则 | 可能 **+2～5 KB** | 需验证 | GUI 现在靠 R8 把 43 个内部类合并/删减到 6 个（其中 3 个带回调方法），体积更小、回调名保留。加 `keepclassmembers` 会更稳，但可能阻止合并而变大；不建议为体积而加 |
| 4 | 再砍语言/密度（resConfigs） | <1 KB | 低风险但无意义 | 语言配置已为 0，密度只剩 375 B xhdpi |
| 5 | 过滤 tablet/land/watch 等配置 | 约 -10 KB（压缩后） | 不建议 | 需放弃横屏/平板兜底，K60 虽为手机，但收益不抵风险 |
| 6 | 去掉 SourceFile/LineNumberTable | 未精确量化 | 不建议 | 调试信息占 dex 元数据一部分，删后日志/堆栈行号全失效，排障代价远大于收益 |
| 7 | 精简 params.json | 压缩后最多 23.7 KB 的一部分 | 不建议 | 通用渲染消费全部键；要减只能改 `params.def.json` 定义并同步 C 端，属功能变更 |
| 8 | 替换 RecyclerView 为 ListView | 约 -70 KB | 不建议 | 日志页大量使用 RecyclerView（673 方法 / 79.8 KB code），重写适配器与滚动逻辑，风险高 |
| 9 | 剔除 transition / emoji2 / kotlin | 合计 code 35.8 KB | 不建议 | 均由 appcompat/material/fragment 传递依赖，剔除易触发 `NoClassDefFoundError` |
| 10 | 换掉 Material/AppCompat | 300+ KB | 不建议 | 界面全面依赖 Material3 组件（20 处 MaterialButton、12 处 MaterialCardView、6 处 TextInputLayout 等） |
| 11 | aapt2 稀疏编码 | **0 B** | — | 实测 `--enable-sparse-encoding` 后 arsc 仍为 340,516 B，AGP 产物已无稀疏化空间 |

## 5. 复现命令

```bash
# 基线/实验构建（C 代码未变，不需要 build_local_apk.sh）
cd lsp模块
JAVA_HOME=D:/tools/jdk-17.0.2 ./gradlew :app-lite:assembleRelease

# 回调数（baksmali）
unzip -o app-lite/build/outputs/apk/release/app-lite-release.apk classes.dex
java -jar D:/tools/baksmali.jar d classes.dex -o out
grep -rhoE '^\.method[^ ]*( [^ ]+)* (afterHookedMethod|beforeHookedMethod)\(' out | \
  grep -oE '(afterHookedMethod|beforeHookedMethod)' | sort | uniq -c

# 资源/配置构成
D:/tools/android-sdk/build-tools/34.0.0/aapt2.exe dump resources b6x-EP-v3.0.apk
D:/tools/android-sdk/build-tools/34.0.0/aapt2.exe dump configurations b6x-EP-v3.0.apk
```
