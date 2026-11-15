# @JavascriptInterface 方法必须保名保体：R8 裁掉/改名后 WebView 调不到，桥会静默失效。
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# Xposed API 是 compileOnly（类不在 APK 内），R8 full mode 下防 missing-class 警告。
# MainHook 的防删除/防改名规则由 :core 的 consumer-rules.pro 继承。
-dontwarn de.robv.android.xposed.**

# @JavascriptInterface 是运行时注解，WebView 靠它识别可调用方法
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

# Xposed API 是 compileOnly：R8 full mode 会把匿名 XC_MethodHook 子类的
# afterHookedMethod/beforeHookedMethod 当死代码全部删除——hook 装得上但永不回调。
# 实测：不加本行时 lite 包内回调方法数量为 0（GUI 版类图下未触发，不可依赖）。
-keep class com.example.waspwingtempctrl.MainHook$* { *; }
