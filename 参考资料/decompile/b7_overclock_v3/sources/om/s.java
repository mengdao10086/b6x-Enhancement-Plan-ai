package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class s extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f44335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f44336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f44337c;

    public s(f0 f0Var) {
        int i10 = 0;
        if (f0Var.K(0) instanceof n0) {
            n0 n0Var = (n0) f0Var.K(0);
            if (n0Var.q() != 0) {
                throw new IllegalArgumentException("Unknown POPOSigningKeyInput tag: " + n0Var.q());
            }
            this.f44335a = t.x(n0Var.U());
            i10 = 1;
        }
        this.f44336b = zn.b.z(f0Var.K(i10));
        this.f44337c = gm.d.K(f0Var.K(i10 + 1));
    }

    public s(t tVar, zn.b bVar, gm.d dVar) {
        this.f44335a = tVar;
        this.f44336b = bVar;
        this.f44337c = dVar;
    }

    public static s y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static s z(Object obj) {
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj != null) {
            return new s(f0.J(obj));
        }
        return null;
    }

    public t A() {
        return this.f44335a;
    }

    public gm.d B() {
        return this.f44337c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        t tVar = this.f44335a;
        if (tVar != null) {
            iVar.a(new n2(false, 0, (gm.h) tVar));
        }
        iVar.a(this.f44336b);
        iVar.a(this.f44337c);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f44336b;
    }
}
