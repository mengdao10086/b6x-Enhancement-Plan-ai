# Add project specific ProGuard rules here.
-keep class de.robv.android.xposed.** { *; }
# Xposed API 是 compileOnly（类不在 APK 内），R8 full mode 下防 missing-class 警告
-dontwarn de.robv.android.xposed.**

# LSPosed 按 assets/xposed_init 里的字面类名加载本类；该类在代码与 manifest 里零引用，
# 开裁剪后必须同时防删除 + 防改名（-keepnames 只防改名，不够）
-keep class com.example.waspwingtempctrl.MainHook { *; }

# 保住日志与堆栈里的行号可读性（AGP 默认 proguard-common.txt 未含这两个属性）
-keepattributes SourceFile,LineNumberTable
