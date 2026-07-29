package rm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;
import zn.t;

/* JADX INFO: loaded from: classes5.dex */
public class k extends w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f48896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f48897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f48898c;

    public k(f0 f0Var) {
        this.f48898c = f0Var;
    }

    public k(z zVar) {
        this.f48896a = zVar;
    }

    public k(n nVar) {
        this.f48898c = new j2(nVar);
    }

    public k(t tVar) {
        this.f48897b = tVar;
    }

    public k(byte[] bArr) {
        this.f48896a = new f2(bArr);
    }

    public k(n[] nVarArr) {
        this.f48898c = new j2(nVarArr);
    }

    public static k y(n0 n0Var, boolean z10) {
        return z(n0Var.U());
    }

    public static k z(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj instanceof z) {
            return new k((z) obj);
        }
        if (obj instanceof f0) {
            return new k(t.A(obj));
        }
        if (obj instanceof n0) {
            return new k(f0.I((n0) obj, false));
        }
        throw new IllegalArgumentException("Unknown object submitted to getInstance: " + obj.getClass().getName());
    }

    public z A() {
        return this.f48896a;
    }

    public t B() {
        return this.f48897b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        z zVar = this.f48896a;
        if (zVar != null) {
            return zVar.b();
        }
        t tVar = this.f48897b;
        return tVar != null ? tVar.b() : new n2(false, 0, (gm.h) this.f48898c);
    }

    public String toString() {
        StringBuilder sb2;
        Object obj;
        if (this.f48896a != null) {
            sb2 = new StringBuilder();
            sb2.append("Data {\n");
            obj = this.f48896a;
        } else if (this.f48897b != null) {
            sb2 = new StringBuilder();
            sb2.append("Data {\n");
            obj = this.f48897b;
        } else {
            sb2 = new StringBuilder();
            sb2.append("Data {\n");
            obj = this.f48898c;
        }
        sb2.append(obj);
        sb2.append("}\n");
        return sb2.toString();
    }

    public n[] x() {
        f0 f0Var = this.f48898c;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        n[] nVarArr = new n[size];
        for (int i10 = 0; i10 != size; i10++) {
            nVarArr[i10] = n.B(this.f48898c.K(i10));
        }
        return nVarArr;
    }
}
