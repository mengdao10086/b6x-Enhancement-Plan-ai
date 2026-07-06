package a;

import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l32 extends XC_MethodHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n32 f6670a;

    public l32(n32 n32Var) {
        this.f6670a = n32Var;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        super.beforeHookedMethod(methodHookParam);
        if (methodHookParam.thisObject.getClass().getName().equals("com.tencent.mm.plugin.scanner.ui.BaseScanUI")) {
            this.f6670a.f6871a.d();
        }
    }
}
