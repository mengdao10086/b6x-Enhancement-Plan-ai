# Add project specific ProGuard rules here.
-keep class de.robv.android.xposed.** { *; }
# Xposed API 是 compileOnly（类不在 APK 内），R8 full mode 下防 missing-class 警告
-dontwarn de.robv.android.xposed.**

# LSPosed 按 assets/xposed_init 里的字面类名加载本类；该类在代码与 manifest 里零引用，
# 开裁剪后必须同时防删除 + 防改名（-keepnames 只防改名，不够）
-keep class com.example.waspwingtempctrl.MainHook { *; }

# 保住日志与堆栈里的行号可读性（AGP 默认 proguard-common.txt 未含这两个属性）
-keepattributes SourceFile,LineNumberTable

# 允许不同签名的方法/字段复用同一个混淆名，进一步缩短 dex 名字表。
# 前提是「本模块自身不靠名字反射自己的方法」——已核查：全仓库唯一的按名反射是
#   MainHook.findProcessDataMethod → 反射的是宿主类 AbstractDataInteractionController；
#   EdgeToEdge.disableMagnifier → 反射的是框架类 TextView 的 mEditor 隐藏字段。
# 本模块任何类都没有被 XposedHelpers / getDeclaredMethod / getMethod 按名查找，
# 故 -overloadaggressively 的反射破坏面不涉及本模块代码。
-overloadaggressively
