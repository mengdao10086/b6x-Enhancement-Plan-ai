package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.u1;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f42293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u1 f42294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f42295c;

    public o(f0 f0Var) {
        this.f42293a = zn.b.z(f0Var.K(0));
        this.f42294b = (u1) f0Var.K(1);
        if (f0Var.size() == 3) {
            this.f42295c = f0.I((n0) f0Var.K(2), true);
        }
    }

    public o(zn.b bVar, u1 u1Var) {
        this.f42293a = bVar;
        this.f42294b = u1Var;
    }

    public o(zn.b bVar, u1 u1Var, f0 f0Var) {
        this.f42293a = bVar;
        this.f42294b = u1Var;
        this.f42295c = f0Var;
    }

    public static o y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static o z(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(f0.J(obj));
        }
        return null;
    }

    public u1 A() {
        return this.f42294b;
    }

    public zn.b B() {
        return this.f42293a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f42293a);
        iVar.a(this.f42294b);
        f0 f0Var = this.f42295c;
        if (f0Var != null) {
            iVar.a(new n2(true, 0, (gm.h) f0Var));
        }
        return new j2(iVar);
    }

    public f0 x() {
        return this.f42295c;
    }
}
