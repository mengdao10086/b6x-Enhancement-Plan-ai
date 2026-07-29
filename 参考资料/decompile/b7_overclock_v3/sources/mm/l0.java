package mm;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class l0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f41354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f41355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.z f41356d;

    public l0(gm.f0 f0Var) {
        gm.h hVarK;
        this.f41353a = (gm.t) f0Var.K(0);
        if (f0Var.K(1) instanceof gm.n0) {
            this.f41354b = zn.b.y((gm.n0) f0Var.K(1), false);
            this.f41355c = zn.b.z(f0Var.K(2));
            hVarK = f0Var.K(3);
        } else {
            this.f41355c = zn.b.z(f0Var.K(1));
            hVarK = f0Var.K(2);
        }
        this.f41356d = (gm.z) hVarK;
    }

    public l0(zn.b bVar, gm.z zVar) {
        this.f41353a = new gm.t(0L);
        this.f41355c = bVar;
        this.f41356d = zVar;
    }

    public l0(zn.b bVar, zn.b bVar2, gm.z zVar) {
        this.f41353a = new gm.t(0L);
        this.f41354b = bVar;
        this.f41355c = bVar2;
        this.f41356d = zVar;
    }

    public static l0 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static l0 z(Object obj) {
        if (obj instanceof l0) {
            return (l0) obj;
        }
        if (obj != null) {
            return new l0(gm.f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f41354b;
    }

    public zn.b B() {
        return this.f41355c;
    }

    public gm.t C() {
        return this.f41353a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f41353a);
        zn.b bVar = this.f41354b;
        if (bVar != null) {
            iVar.a(new n2(false, 0, (gm.h) bVar));
        }
        iVar.a(this.f41355c);
        iVar.a(this.f41356d);
        return new j2(iVar);
    }

    public gm.z x() {
        return this.f41356d;
    }
}
