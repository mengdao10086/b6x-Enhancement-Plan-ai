package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s22 extends XC_MethodHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a32 f7356a;

    public s22(a32 a32Var) {
        this.f7356a = a32Var;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (this.f7356a.k()) {
            methodHookParam.setResult(3000);
        }
    }
}
