package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class x22 extends XC_MethodHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a32 f7848a;

    public x22(a32 a32Var) {
        this.f7848a = a32Var;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (this.f7848a.k()) {
            float f = a32.f5566a;
            methodHookParam.setResult(Integer.valueOf(f == -1.0f ? 150 : (int) ((f * 150.0f) + 0.5f)));
        }
    }
}
