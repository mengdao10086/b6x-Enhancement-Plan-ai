package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityChargeControl;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j91 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityChargeControl f1516a;
    public final /* synthetic */ n92 b;
    public final /* synthetic */ n92 c;

    public j91(ActivityChargeControl activityChargeControl, n92 n92Var, n92 n92Var2, n92 n92Var3) {
        this.f1516a = activityChargeControl;
        this.f6489a = n92Var;
        this.b = n92Var2;
        this.c = n92Var3;
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.String] */
    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        i92 i92Var = new i92();
        i92Var.b = false;
        i92 i92Var2 = new i92();
        i92Var2.b = false;
        if (this.f1516a.c) {
            i92Var.b = this.f1516a.f8575a.u();
            i92Var2.b = this.f1516a.f8575a.t();
        }
        if (this.f1516a.b) {
            this.f6489a.f6891a = this.f1516a.f8575a.n();
        }
        this.b.f6891a = this.f1516a.f8575a.h();
        this.c.f6891a = this.f1516a.f8575a.r();
        qc2.d(xd2.a(qe2.b()), null, null, new h91(this, null), 3, null);
        Scene.f4798a.i(new i91(this, i92Var, i92Var2));
    }
}
