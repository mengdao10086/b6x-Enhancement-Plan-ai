package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.u1;

/* JADX INFO: loaded from: classes5.dex */
public class q extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f44326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.d f44327b;

    public q(f0 f0Var) {
        this.f44326a = zn.b.z(f0Var.K(0));
        this.f44327b = gm.d.K(f0Var.K(1));
    }

    public q(lm.r rVar, u1 u1Var) {
        this(new zn.b(lm.c.f39859a, rVar), u1Var);
    }

    public q(zn.b bVar, u1 u1Var) {
        this.f44326a = bVar;
        this.f44327b = u1Var;
    }

    public static q y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static q z(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(f0.J(obj));
        }
        return null;
    }

    public gm.d A() {
        return this.f44327b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f44326a);
        iVar.a(this.f44327b);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f44326a;
    }
}
