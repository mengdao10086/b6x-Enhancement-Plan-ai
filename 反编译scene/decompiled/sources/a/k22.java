package a;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k22 extends XC_MethodHook {
    public k22(p22 p22Var) {
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        XposedHelpers.callMethod(methodHookParam.thisObject, "setItemViewCacheSize", new Object[]{0});
    }
}
