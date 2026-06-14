package a;

import a.p80;
import com.omarea.vtools.activities.ActivityFpsSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xa1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ya1 f7870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3564a;

    public xa1(ya1 ya1Var, String str) {
        this.f7870a = ya1Var;
        this.f3564a = str;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, a.p80$b] */
    @Override // java.lang.Runnable
    public final void run() {
        n92 n92Var = new n92();
        n92Var.f6891a = p80.a.G(p80.f2403a, ActivityFpsSession.this, null, 2, null);
        qc2.d(xd2.a(qe2.b()), null, null, new wa1(this, n92Var, null), 3, null);
    }
}
