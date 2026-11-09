# 日志归因：HyperCeiler 安装器布局栈

> **日志**：`D:\下载\LocalSend\modules_2026-11-06T00_37_00.14501.log`（619,904 B / 5,013 行 / 跨 4 天 / LSPosed 模块日志导出）
> **被分析模块**：HyperCeiler `2.10.166-20260331`（versionCode 4571，`D:\下载\LocalSend\base.apk`，md5 `eaf7c7ae356f7527480ca47779b92af5`）
> **分析性质**：只读取证，未修改日志与 APK
> **日期**：2026-11-10

---

## 结论速览

| 问题 | 结论 |
|------|------|
| 谁打的 | LSPosed 框架（`LSPosedFramework`），不是 HyperCeiler 自己。HyperCeiler 的 hook 以 libxposed `PROTECTIVE` 模式注册，hook 内抛异常时由框架捕获并打印完整栈 |
| 打了多少 | **26 次**异常，每次约 95 帧，合计 78 条 log 记录 / 2,382 行 / **174,815 B（占全文 28.2%）** |
| 是什么 | 全部是同一条：`NoSuchMethodError: DisplayMoreApkInfoNew#H()#bestmatch` |
| 归属 | HyperCeiler 规则 `DisplayMoreApkInfoNew`（应用包管理组件 → 「显示更多安装包信息」） |
| 严重性 | **噪音 + 该功能的前置兜底失效**；不是崩溃、不影响安装器正常使用。框架已兜底继续执行原方法 |
| 要不要管 | 不需要处理。属 HyperCeiler 上游代码缺陷，可在模块里关掉该功能消除，或等上游修复 |

---

## 1. 日志结构还原

日志导出器把一条多行模块消息拆成「带头的首条 + 裸续行」：首条带 `[ 时间 uid:pid:tid 级别/标签 ]`，其后线程栈的每一帧是**没有框架头的裸行**。因此统计时不能按「一行 = 一条日志」算。

| 行类型 | 行数 | 说明 |
|--------|------|------|
| 带框架头 | 1,514 | 即 1,514 条日志记录 |
| 无框架头续行 | 3,499 | 其中 3,467 行以 `at ` 开头（栈帧） |
| 续行字节数 | 238,657 B | 占全文 **38.5%**，与既有统计一致 |

**归属修正**：这 38.5% 的续行并非全部来自本类布局栈。经逐条归组：

- 本文分析的 HyperCeiler 安装器布局栈：**157,999 B 续行 + 16,816 B 首行 = 174,815 B（28.2%）**
- 其余约 81 KB 续行来自同文件内的另外三类栈（见 2.3）

### 1.1 为什么看起来有 78 条记录却只有 26 次异常

同一次异常的约 95 帧，被导出器按记录大小切成 3～4 条：

```
[带框架头] (...) Exception in hooker
           java.lang.NoSuchMethodError: ...        ← 第 1 条记录
[带框架头] (...) at android.widget.FrameLayout.onLayout(...)   ← 第 2 条（从栈中间续）
           at android.view.View.layout(...)
           ...（46 行）
[带框架头] (...) at android.view.Choreographer$CallbackRecord.run(...)  ← 第 3 条
           ...
[带框架头] (...) at com.android.internal.os.ZygoteInit.main(...)  ← 部分异常有第 4 条
```

78 条 = 26 条异常头 + 26 条中段 + 13 条尾段 + 13 条（尾段再切分）。26 条异常头里全部只有一句 `Exception in hooker`，紧随其后全部是同一个 `NoSuchMethodError`。

---

## 2. 栈组明细

### 2.1 主表

| 栈组 | 出现次数 | 时间范围 | 关键帧（自抛点向下） | 归属功能 |
|------|----------|----------|----------------------|----------|
| **A：深栈（95 帧）** | 13 | 2026-11-06 01:56 ~ 11-10 00:49 | `EzxMethodHelper.findMethodBestMatch` → `KtHelpUtilsKt.callMethod` → `DisplayMoreApkInfoNew.init$lambda$31$lambda$30` → `BeforeChainStage.intercept` → `com.miui.packageInstaller.ui.listcomponets.d.s` → `AdapterDelegate.a/c` → RecyclerView 布局（4 层 FrameLayout + ActionBarOverlayLayout + ConstraintLayout） | HyperCeiler / 应用包管理组件 / 显示更多安装包信息 |
| **B：浅栈（84～85 帧）** | 13 | 同上（每次 A 之后 0.19～2.5 s） | 同上，仅中间布局嵌套比 A 少 10 帧（直接到 `ConstraintLayout.onLayout`） | 同上 |

说明：A/B 头部 35 帧与尾部（`ViewRootImpl.performLayout` 以下）完全相同，唯一差异是异常发生时所在窗口的视图嵌套深度不同——对应安装器里两个不同的列表页/卡片。

### 2.2 时间分布：13 次操作，每次 2 条

| 日期 | 次数 | 触发时刻（同一 pid） |
|------|------|----------------------|
| 11-06 | 2 | 01:56:20.367 / .558（pid 17084） |
| 11-07 | 16 | 19:39:47.287 与 19:39:49.810、20:04:04、20:19:48、21:27:28、21:48:39、22:31:20、23:04:52、23:12:08（8 个进程，各 2 条） |
| 11-08 | 4 | 00:54:10、23:28:32 |
| 11-10 | 4 | 00:29:28、00:49:35 |

- 26 条异常分布在 **13 个不同的 `com.miui.packageinstaller` 进程**里，每进程恰好 2 条。
- 同一份日志里该应用共启动 **15 次**（每次启动都会打 `[DisableAd]: Hook Failed`、`[InstallRiskDisable]: Hook Failed`），其中 13 次进入到了会绑定列表项的页面，才产生这 2 条异常。
- 结论：**不是"每次布局都刷"，而是"每次打开安装/确认页列表、发生一次项绑定时刷 2 条"**。

### 2.3 同文件内的其他栈（对照，非本文主题）

| 栈组 | 次数 | 体积 | 关键帧 | 性质 |
|------|------|------|--------|------|
| `InstallRiskDisable: Hook Failed` | 15 | 45.8 KB | `DexKit...single` → `NoResultException: No result found for query` | 进程启动时规则初始化失败，hook 未安装 |
| `DisableAd: Hook Failed` | 15 | 38.7 KB | `EzxMethodHelper.formatMethodSignature` → `NullPointerException`（对 null Method 调 `getParameterTypes`） | 同上 |
| `CrashMonitor: Crash detected` | 5 | 8.0 KB | 目标应用自身崩溃（`com.accessibilitymanager`、`com.miui.powerinsight`、`com.example.waspwingtempctrl`） | HyperCeiler 的崩溃监控转储，与布局栈无关 |

这三类都是**进程启动时一次性**的，只有本文的布局栈是**随界面绑定反复出现**的。

---

## 3. HyperCeiler 侧证据

### 3.1 版本确认

- 解包对象就是 `D:\下载\LocalSend\base.apk` 本身：先按字节复制到纯 ASCII 临时路径（`aapt` 处理中文路径会报 `Illegal byte sequence`），md5 与源文件一致（`eaf7c7ae356f7527480ca47779b92af5`）。
- `aapt dump badging` 输出：`package: name='com.sevtinge.hyperceiler' versionCode='4571' versionName='2.10.166-20260331'`。
- 日志中的模块前缀 `(com.miui.packageinstaller)[com.sevtinge.hyperceiler,ProtectiveHooker,...]` 与之对应；`ProtectiveHooker` 是该包在 LSPosed 里注册的模块入口名，不是另一个模块。

### 3.2 异常由哪一行代码抛出（字节码级）

`DisplayMoreApkInfoNew.init()` 里注册了一个 before hook：

```java
// 反编译产物 .../rules/packageinstaller/DisplayMoreApkInfoNew.java:72
public static final al0 init$lambda$31$lambda$30(Method method, HookParam hookParam) {
    String name = method.getName();                       // method = 目标应用的私有方法 H
    KtHelpUtilsKt.callMethod(INSTANCE, name, new Object[0]);  // ← 在“规则对象自己”身上找 H()
    return al0.a;
}
```

baksmali 对同一方法的反汇编（`smali/.../DisplayMoreApkInfoNew.smali:444`）一致：

```
sget-object p1, ...DisplayMoreApkInfoNew;->INSTANCE:...
invoke-virtual {p0}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;
invoke-static {p1, p0, v0}, ...KtHelpUtilsKt;->callMethod(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
```

即：**接收者是规则单例 `DisplayMoreApkInfoNew.INSTANCE`，方法名是目标应用的 `H`**。规则类里没有 `H()`，`EzxMethodHelper.findMethodBestMatch` 找不到 → 抛 `NoSuchMethodError`，错误串格式为 `类名#方法名#bestmatch`。

对照组：同一 lambda 在上游源码里的原文（tag `2.10.166`，`library/libhook/src/main/java/com/sevtinge/hyperceiler/libhook/rules/packageinstaller/DisplayMoreApkInfoNew.kt:156-162`）：

```kotlin
// pick the first view method that is not excluded
val reallyViewMethod: Method? = viewMethod.firstOrNull { it != viewExcludeMethod1 && it != viewExcludeMethod2 }

// if we have a specific view method, ensure entry calls it
reallyViewMethod?.let { method ->
    entryMethod.createBeforeHook {
        callMethod(method.name)
    }
}
```

`createBeforeHook` 的 lambda 参数是 `(HookParam) -> Unit`（非 `HookParam.() -> Unit`），所以 `callMethod(...)` 的隐式接收者是外层规则对象——与字节码一致。**这不是本机环境特有的问题，是上游代码本身的行为**；同一段代码在 `main`（3.7.171）里仍然存在。

### 3.3 被 hook 的是什么

规则通过 DexKit 在 `com.miui.packageinstaller` 里按指纹找成员（源码同上文件 50-145 行）：

| 成员 | 指纹 | 实际命中 |
|------|------|----------|
| `entryMethod`（被挂 before hook） | `public void`，唯一参数类型 `com.miui.packageInstaller.ui.listcomponets.AppInfoViewObject$ViewHolder` | 栈中的 `com.miui.packageInstaller.ui.listcomponets.d.s` |
| `reallyViewMethod`（即 `H`） | `private final void`、无参、所在类含字符串 `context.ge…ta.versionName` | 私有成员 `H` |
| after hook 目标 | 同上 `H` | 负责把版本号/版本代码/SDK/体积插进视图 |

### 3.4 功能名

资源表 `resources.arsc` 中存在功能标题「**显示更多安装包信息**」（同表另有「显示更多应用信息」，属其它规则，勿混）。该规则在模块里注册于「应用包管理组件 → 应用包管理组件」分组（`libhook/app/PackageInstaller.java` 中 `initHook(DisplayMoreApkInfoNew.INSTANCE, <开关>)`），说明用户已开启此功能。

---

## 4. 95 帧是怎么来的

异常发生时的真实调用现场（自下向上）：

```
Choreographer 帧回调
 └ ViewRootImpl.performTraversals / performLayout
   └ DecorView.onLayout → 多层 LinearLayout / FrameLayout / miuix.ActionBarOverlayLayout / ConstraintLayout
     └ RecyclerView.onLayout → LinearLayoutManager → RecyclerView$w / $h
       └ AdapterDelegate.a / c        ← 列表项绑定
         └ d.s(ViewHolder)            ← 被 hook 的方法
           └ ClidstPoundRaerniem.J   ← libxposed 注入的蹦床
             └ m.proceed → xi.intercept → EzxHelper HookChain.invoke
               └ BeforeChainStage.intercept → qg.invoke
                 └ DisplayMoreApkInfoNew.init$lambda$31$lambda$30
                   └ KtHelpUtilsKt.callMethod → EzxHelpUtils.callMethod
                     └ EzxMethodHelper.callMethod → findMethodBestMatch  ← 抛 NoSuchMethodError
```

- 抛点以上的 20 余帧是**模块自己的 hook 链**；
- 抛点以下的 70 余帧是**被 hook 的系统/应用调用现场**（RecyclerView 布局 + 视图树递归），这 10 多次 `ViewGroup.layout / View.layout / FrameLayout.layoutChildren` 全是 Android 框架自身的递归，不是模块循环打印。
- 因此「`ViewGroup.layout` 260 行」= 26 次 × 10 帧，是同一个异常的重复出现，不是 260 个独立事件。

---

## 5. 严重性判定

**判定：真实的 hook 异常，但被框架兜底；对外表现为"噪音 + 一个兜底分支永远不生效"，不是崩溃源。**

依据：

1. **注册模式是 PROTECTIVE**。EzXHelper 的 `HookFactory` 构造函数写死 `ExceptionMode.DEFAULT`，libxposed 文档明确：`DEFAULT` 跟随 `module.prop` 全局配置，未指定时等同 `PROTECTIVE`；`PROTECTIVE` 的语义是「hooker 抛出的异常被捕获并记录，调用按"没有这个 hook"继续」。
2. **日志侧印证**：整个 4 天里 `com.miui.packageinstaller` 没有任何 `CrashMonitor` 崩溃记录；异常之后同一 pid 继续正常运行（例如 pid 17084 在 01:56 抛错后进程仍在）。如果是 `PASSTHROUGH` 模式，异常会直接抛给 `d.s` 的调用方（列表绑定），大概率表现为安装器崩溃或列表空白——没有发生。
3. **只影响 before 兜底分支**：这条规则真正改 UI 的是挂在 `H` 上的 **after hook**，与 before hook 相互独立。before hook 的原意是「确保 entry 方法一定会调用目标视图方法」，现在这个"强制调用"永远失败。
4. **代价很小但非零**：每次列表绑定要在 UI 主线程构造并格式化一条 95 帧栈（`fillInStackTrace` + 文本拼接 + 落日志）。13 次操作共约 175 KB 文本，单次约 2～5 ms 量级，没有观察到卡顿证据。

**不能从日志判定的部分**：after hook 是否成功把"版本名/版本代码/SDK/体积"插进视图——日志里没有该功能的成功/失败标记。若界面里能看到这些字段，说明主路径正常，本文的异常纯属兜底分支噪音；若看不到，则是功能本身在这版安装器上已失效，与这条异常没有因果关系。

---

## 6. 结论与建议

**结论**

- 这 175 KB 栈是 **HyperCeiler 2.10.166 的 `DisplayMoreApkInfoNew`（显示更多安装包信息）规则**在 `com.miui.packageinstaller` 里的 before hook 每次触发时抛出的 `NoSuchMethodError`，由 LSPosed 以 PROTECTIVE 模式捕获后原样打印。
- 之所以"这么多"，是因为栈里有 70 余帧 Android 布局递归，一次异常就 ~95 行；而该 hook 挂在列表项绑定方法 `d.s` 上，每次打开安装/确认页会触发 2 次。
- 根因是上游代码把调用打在了规则对象 `INSTANCE` 上，而不是目标对象上——`DisplayMoreApkInfoNew` 类里当然没有名为 `H` 的方法。

**建议**

1. **不必处理**。不影响安装器使用，也不影响 HyperCeiler 其它规则；上游 `main` 仍是同样写法，属已知缺陷而非本机问题。
2. 若确实想消除：模块内关闭「应用包管理组件 → 显示更多安装包信息」。关闭后这 175 KB 栈会完全消失，代价是失去该功能。
3. 若向上游反馈：可附 `Exception in hooker` 全文与 `DisplayMoreApkInfoNew.kt:156-162`，指出 `callMethod(method.name)` 的接收者应为目标实例而非规则单例（具体应是 `hookParam.thisObject` 还是其 ViewHolder/ApkInfo 字段，需拿到对应版本 `com.miui.packageinstaller` 的类结构才能确定，本次未获取该 APK）。
4. 后续抓日志可先按特征过滤，避免被这类栈淹没：剔除 `ProtectiveHooker` 段落，或只保留带框架头的行（`grep '^\['`）。

---

## 附：复核方式

- 日志归组：以带框架头的行切分记录，记录内 `msg` + 后续裸行合并为一条完整消息；`ProtectiveHooker` + `Exception in hooker` 为一次异常起点。
- 反编译：`D:/tools/jadx/bin/jadx.bat -d out --no-res --no-imports hc.apk`（`finished with errors, count: 17`，目标类均成功产出，已用 baksmali 交叉核对关键方法）。
- 上游源码：`https://github.com/ReChronoRain/HyperCeiler` tag `2.10.166`，`library/libhook/src/main/java/com/sevtinge/hyperceiler/libhook/rules/packageinstaller/DisplayMoreApkInfoNew.kt`。
- 临时解包目录在分析结束后已清理，未改动仓库内任何已有文件。
