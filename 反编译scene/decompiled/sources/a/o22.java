package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o22 extends XC_MethodHook {
    public o22(p22 p22Var) {
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.args[0] = Integer.valueOf(new d60(((Integer) methodHookParam.args[0]).intValue()).c(16777216));
    }
}
