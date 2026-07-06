package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u22 extends XC_MethodHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a32 f7560a;

    public u22(a32 a32Var) {
        this.f7560a = a32Var;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (this.f7560a.k()) {
            float f = a32.f5566a;
            methodHookParam.setResult(Integer.valueOf(f == -1.0f ? 3000 : (int) ((f * 3000.0f) + 0.5f)));
        }
    }
}
