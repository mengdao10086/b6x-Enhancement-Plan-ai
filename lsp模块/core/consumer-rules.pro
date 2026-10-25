# LSPosed 按 assets/xposed_init 里的字面类名加载本类；该类在代码与 manifest 里零引用，
# 开裁剪后必须同时防删除 + 防改名（-keepnames 只防改名，不够）。
# 规则放 library 的 consumer rules：GUI 与后续 lite 两个 app 都自动继承，不各写一份。
-keep class com.example.waspwingtempctrl.MainHook { *; }
