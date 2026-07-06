package a;

import a.p80;
import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class le1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me1 f6698a;

    public le1(me1 me1Var) {
        this.f6698a = me1Var;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, a.p80$b] */
    @Override // java.lang.Runnable
    public final void run() {
        n92 n92Var = new n92();
        n92Var.f6891a = p80.a.G(p80.f2403a, ActivityPowerBench.this, null, 2, null);
        qc2.d(xd2.a(qe2.b()), null, null, new ke1(this, n92Var, null), 3, null);
    }
}
