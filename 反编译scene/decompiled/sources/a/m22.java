package a;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m22 extends XC_MethodHook {
    public m22(p22 p22Var) {
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        XposedHelpers.setObjectField(methodHookParam.thisObject, "mHardwareAccelerated", Boolean.FALSE);
    }
}
