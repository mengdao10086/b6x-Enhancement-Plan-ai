package mm;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class r0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f41383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f41384b;

    public r0(gm.f0 f0Var) {
        gm.h hVarK;
        if (f0Var.K(0) instanceof gm.n0) {
            this.f41383a = n.z(gm.n0.T(f0Var.K(0)), true);
            hVarK = f0Var.K(1);
        } else {
            this.f41383a = null;
            hVarK = f0Var.K(0);
        }
        this.f41384b = n.A(hVarK);
    }

    public r0(n nVar) {
        this.f41383a = null;
        this.f41384b = nVar;
    }

    public r0(n nVar, n nVar2) {
        this.f41383a = nVar;
        this.f41384b = nVar2;
    }

    public static r0 x(Object obj) {
        if (obj instanceof r0) {
            return (r0) obj;
        }
        if (obj != null) {
            return new r0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        n nVar = this.f41383a;
        if (nVar != null) {
            iVar.a(new n2(true, 0, (gm.h) nVar));
        }
        iVar.a(this.f41384b);
        return new j2(iVar);
    }

    public n y() {
        return this.f41383a;
    }

    public n z() {
        return this.f41384b;
    }
}
