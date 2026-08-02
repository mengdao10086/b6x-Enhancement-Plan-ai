# B8X 超频工具 V2 — 加固壳层分析

> 来源：`参考资料/apk_original/B8X超频工具V2.apk` + `参考资料/decompile/b8x/`（baksmali 只能反编译出 4 个壳类）
> 状态：⚠️ **加壳，静态无法恢复业务代码，需动态脱壳**
> 分析日期：2026-08-02

---

## 一、结论先行

B8X 超频工具 V2 是**双重加固** APK：
1. **爱加密加固**（`libjiagu.so` / `libjiagu_a64.so`）
2. **自定义 JNI 壳**（`libjgdtc.so` + 字符串 XOR 加密）

`classes.dex`（17.9MB）里只有壳代码（4 个类），真正的业务 dex 在运行时由 native 层解密后注入。**纯静态反编译只能看到壳，无法分析 App 运行逻辑。**

## 二、App 身份

- **包名**：`com.fdg.flashplay.farb8x`（从壳代码硬编码路径 `/data/data/com.fdg.flashplay.farb8x/lib/libjgdtc.so` 还原）
  - `fdg` = 飞迪/飞智游戏，`flashplay` = 飞智体系，`far` = 风扇（Fan），`b8x` = 设备型号
- **版本线索**：APK 打包时间 2025-04-12，`assets/cfg/test_keymapping.local.fdg` 等飞智配置

## 三、加固机制拆解

### 3.1 壳入口：`com/stub/StubApp`

```
StubApp extends android.app.Application   // 壳的 Application 入口
  ├─ static 字段保存真实 Application 引用（a/b 两个引用）
  ├─ 保存解密后的 dex 路径、ClassLoader 引用
  └─ 典型爱加密壳结构：onCreate 中解密 payload → 替换 Application
```

### 3.2 dex 解密加载器：`com/tianyu/util/DtcLoader`

```
static <clinit>():
  System.loadLibrary("jgdtc")          // 加载 native 壳 so
  a()                                  // 解密字符串 → 得到真实类名
  System.load("/data/data/<pkg>/lib/libjgdtc.so")

a():                                   // 字符串解密
  XOR/移位解密 "q~tbyt>q``>QsdyfydiDxbuqt" → 真实类名（如 MainActivity）
  Class.forName(解密结果)               // 反射加载真实入口类
```

### 3.3 字符串加密：`com/tianyu/util/a`

所有关键字符串（类名、路径）均为**异或/移位加密**（`a.a(String)` 解密）。静态搜索不到业务类名、Activity、字符串。

### 3.4 加固配置：`com/tianyu/util/Configuration`

```
ENABLE_CRASH_REPORT   // 崩溃上报开关
ENABLE_PT             // PT（protection/反调试）开关
```

## 四、静态可获取的信息（不完整）

| 来源 | 能拿到什么 |
|---|---|
| APK 解包 | `AndroidManifest.xml`（二进制，需 aapt/apktool 解码）、`assets/`（cfg 配置、iconfont.ttf、firmware_min_supported.json）、`lib/` |
| baksmali classes.dex | 仅 4 个壳类（StubApp / DtcLoader / Configuration / util.a） |
| `AndroidManifest字符串表.txt` | 二进制编码，可读组件需解码后提取 |

## 五、为什么静态分析不可行

1. `classes.dex` 只含壳，业务 dex 是加密 payload（在 lib 或 assets 中），静态无法解出
2. 字符串全 XOR 加密，无业务符号可搜
3. native 壳（libjgdtc.so）内含解密逻辑，静态分析 so 需要 IDA/Ghidra 逆向，工作量极大且壳可能反调试

## 六、脱壳指引（后续可选）

要分析 B8X 真实代码，需**动态脱壳**（任选一）：

| 方案 | 工具 | 说明 |
|---|---|---|
| **内存 dump dex** | Frida + `dump_dex` 脚本 | 真机/模拟器运行 app，启动完成后 hook `ClassLoader` dump 已解密 dex。需 root 或模拟器 |
| **脱壳机** | BlackDex / Youpk / 常见脱壳工具 | 自动化脱壳，直接输出真实 dex，再 jadx 反编译 |
| **native 逆向** | IDA Pro / Ghidra | 静态分析 libjgdtc.so 还原解密算法（工作量大，非首选） |

脱壳得到真实 `classes.dex` 后，用 `工具/jadx.jar`（或 baksmali）反编译，即可按 b6_overclock_v2 的分析流程补齐本 App 的运行逻辑文档。

---

## 附：相关文档

- [B6X超频V2运行逻辑.md](B6X超频V2运行逻辑.md) — B6X 超频工具 V2（未加固，已完整分析）
- 见 `参考资料/decompile/b8x/反编译报告.md`（早期尝试的原始记录）
