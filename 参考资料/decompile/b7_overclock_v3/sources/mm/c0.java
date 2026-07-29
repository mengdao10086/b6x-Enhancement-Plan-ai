package mm;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f41287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.z f41288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f41289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.f0 f41290e;

    public c0(gm.f0 f0Var) {
        this.f41286a = (gm.t) f0Var.K(0);
        this.f41287b = f0.y((gm.n0) f0Var.K(1), true);
        int i10 = 2;
        if (f0Var.K(2) instanceof gm.n0) {
            this.f41288c = gm.z.H((gm.n0) f0Var.K(2), true);
            i10 = 3;
        }
        this.f41289d = zn.b.z(f0Var.K(i10));
        this.f41290e = (gm.f0) f0Var.K(i10 + 1);
    }

    public c0(f0 f0Var, gm.z zVar, zn.b bVar, gm.f0 f0Var2) {
        this.f41286a = new gm.t(3L);
        this.f41287b = f0Var;
        this.f41288c = zVar;
        this.f41289d = bVar;
        this.f41290e = f0Var2;
    }

    public static c0 x(gm.n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static c0 y(Object obj) {
        if (obj instanceof c0) {
            return (c0) obj;
        }
        if (obj != null) {
            return new c0(gm.f0.J(obj));
        }
        return null;
    }

    public f0 A() {
        return this.f41287b;
    }

    public gm.f0 B() {
        return this.f41290e;
    }

    public gm.z C() {
        return this.f41288c;
    }

    public gm.t D() {
        return this.f41286a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f41286a);
        iVar.a(new n2(true, 0, (gm.h) this.f41287b));
        gm.z zVar = this.f41288c;
        if (zVar != null) {
            iVar.a(new n2(true, 1, (gm.h) zVar));
        }
        iVar.a(this.f41289d);
        iVar.a(this.f41290e);
        return new j2(iVar);
    }

    public zn.b z() {
        return this.f41289d;
    }
}
