package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class v22 extends XC_MethodHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a32 f7652a;

    public v22(a32 a32Var) {
        this.f7652a = a32Var;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (this.f7652a.k()) {
            methodHookParam.setResult(Float.valueOf(0.012f));
        }
    }
}
