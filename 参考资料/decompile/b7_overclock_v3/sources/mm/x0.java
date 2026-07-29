package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class x0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f41430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.p f41431b;

    public x0(gm.f0 f0Var) {
        this.f41430a = n.A(f0Var.K(0));
        if (f0Var.size() == 2) {
            this.f41431b = zn.p.y(f0Var.K(1));
        }
    }

    public x0(n nVar) {
        this.f41430a = nVar;
    }

    public static x0 z(Object obj) {
        if (obj instanceof x0) {
            return (x0) obj;
        }
        if (obj != null) {
            return new x0(gm.f0.J(obj));
        }
        return null;
    }

    public n A() {
        return this.f41430a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41430a);
        zn.p pVar = this.f41431b;
        if (pVar != null) {
            iVar.a(pVar);
        }
        return new j2(iVar);
    }

    public zn.p x() {
        return this.f41431b;
    }

    public zn.p y() {
        return this.f41431b;
    }
}
