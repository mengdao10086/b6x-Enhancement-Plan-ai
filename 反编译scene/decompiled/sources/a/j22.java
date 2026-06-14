package a;

import android.os.Bundle;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j22 {
    public void a(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        XposedHelpers.findAndHookMethod("android.app.Activity", loadPackageParam.classLoader, "onCreate", new Object[]{Bundle.class, new i22(this)});
    }
}
