package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivitySwap;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class og1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySwap.m f7020a;

    public og1(ActivitySwap.m mVar) {
        this.f7020a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Integer numV;
        int i = ActivitySwap.l(ActivitySwap.this).getInt(hz0.f1282a.u0(), -2);
        if (i == 0 && (numV = ActivitySwap.this.f5510a.v()) != null && numV.intValue() < 0) {
            Timer timerS = ActivitySwap.this.S();
            ActivitySwap.this.f5510a.G();
            timerS.cancel();
        }
        String strF = ActivitySwap.this.f5510a.F(i, ActivitySwap.l(ActivitySwap.this).getBoolean(hz0.f1282a.w0(), false));
        if (strF.length() > 0) {
            Scene.f4798a.o(strF, 1);
        }
        ActivitySwap.this.B().i();
        Scene.c cVar = Scene.f4798a;
        v72 v72Var = ActivitySwap.this.b;
        Object kg1Var = v72Var;
        if (v72Var != null) {
            kg1Var = new kg1(v72Var);
        }
        cVar.i((Runnable) kg1Var);
        ActivitySwap.j(ActivitySwap.this).c();
    }
}
