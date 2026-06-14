package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t22 extends XC_MethodHook {
    public t22(a32 a32Var) {
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.setResult(5);
    }
}
