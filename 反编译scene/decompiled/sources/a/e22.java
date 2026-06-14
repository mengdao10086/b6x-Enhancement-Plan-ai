package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e22 extends XC_MethodHook {
    public e22(f22 f22Var) {
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        super.afterHookedMethod(methodHookParam);
        methodHookParam.setResult(Boolean.TRUE);
    }
}
