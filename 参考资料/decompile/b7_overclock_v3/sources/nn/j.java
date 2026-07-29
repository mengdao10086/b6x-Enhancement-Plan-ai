package nn;

import gm.c0;
import gm.f2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class j extends w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f42279a;

    public j(z zVar) {
        this.f42279a = zVar;
    }

    public j(xn.d dVar) {
        this.f42279a = dVar;
    }

    public static j x(n0 n0Var, boolean z10) {
        return y(n0Var.U());
    }

    public static j y(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof f2) {
            return new j((f2) obj);
        }
        if (!(obj instanceof n0)) {
            return new j(xn.d.A(obj));
        }
        n0 n0Var = (n0) obj;
        return n0Var.q() == 1 ? new j(xn.d.z(n0Var, true)) : new j(z.H(n0Var, true));
    }

    public xn.d A() {
        gm.h hVar = this.f42279a;
        if (hVar instanceof z) {
            return null;
        }
        return xn.d.A(hVar);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.h hVar = this.f42279a;
        return hVar instanceof z ? new n2(true, 2, hVar) : new n2(true, 1, hVar);
    }

    public byte[] z() {
        gm.h hVar = this.f42279a;
        if (hVar instanceof z) {
            return ((z) hVar).J();
        }
        return null;
    }
}
