package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class y22 extends XC_MethodHook {
    public y22(a32 a32Var) {
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(200);
    }
}
