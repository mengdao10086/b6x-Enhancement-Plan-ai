package a;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f22 {
    public void a(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        XposedHelpers.findAndHookMethod("com.omarea.xposed.XposedCheck", loadPackageParam.classLoader, "xposedIsRunning", new Object[]{new e22(this)});
    }
}
