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
# 收窄为 keepclassmembers：实测回调定义 28/12 全保留，dex 比 { *; } 少 4,128 B。
# GUI 类图下 R8 会合并成带 int 标签的少数类，不能按方法数判断，勿照搬。
-keepclassmembers class com.example.waspwingtempctrl.MainHook$* {
    protected void afterHookedMethod(de.robv.android.xposed.XC_MethodHook$MethodHookParam);
    protected void beforeHookedMethod(de.robv.android.xposed.XC_MethodHook$MethodHookParam);
}
