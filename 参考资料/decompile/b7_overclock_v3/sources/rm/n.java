package rm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class n extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f48908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f48909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f48910c;

    public n(f0 f0Var) {
        this.f48908a = a.z(f0Var.K(0));
        if (f0Var.size() > 1) {
            gm.h hVarK = f0Var.K(1);
            if (hVarK instanceof n0) {
                y(hVarK);
                return;
            }
            this.f48909b = f0.J(hVarK);
            if (f0Var.size() > 2) {
                y(f0Var.K(2));
            }
        }
    }

    public n(a aVar) {
        this(aVar, null, null);
    }

    public n(a aVar, l lVar) {
        this(aVar, null, lVar);
    }

    public n(a aVar, a[] aVarArr) {
        this(aVar, aVarArr, null);
    }

    public n(a aVar, a[] aVarArr, l lVar) {
        this.f48908a = aVar;
        if (aVarArr != null) {
            this.f48909b = new j2(aVarArr);
        }
        this.f48910c = lVar;
    }

    public static n A(n0 n0Var, boolean z10) {
        return B(f0.I(n0Var, z10));
    }

    public static n B(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(f0.J(obj));
        }
        return null;
    }

    public static n[] x(f0 f0Var) {
        int size = f0Var.size();
        n[] nVarArr = new n[size];
        for (int i10 = 0; i10 != size; i10++) {
            nVarArr[i10] = B(f0Var.K(i10));
        }
        return nVarArr;
    }

    public l C() {
        return this.f48910c;
    }

    public a D() {
        return this.f48908a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f48908a);
        f0 f0Var = this.f48909b;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        l lVar = this.f48910c;
        if (lVar != null) {
            iVar.a(new n2(false, 0, (gm.h) lVar));
        }
        return new j2(iVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TargetEtcChain {\n");
        stringBuffer.append("target: " + this.f48908a + "\n");
        if (this.f48909b != null) {
            stringBuffer.append("chain: " + this.f48909b + "\n");
        }
        if (this.f48910c != null) {
            stringBuffer.append("pathProcInput: " + this.f48910c + "\n");
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public final void y(gm.h hVar) {
        n0 n0VarT = n0.T(hVar);
        if (n0VarT.q() == 0) {
            this.f48910c = l.A(n0VarT, false);
            return;
        }
        throw new IllegalArgumentException("Unknown tag encountered: " + n0VarT.q());
    }

    public a[] z() {
        f0 f0Var = this.f48909b;
        if (f0Var != null) {
            return a.x(f0Var);
        }
        return null;
    }
}
