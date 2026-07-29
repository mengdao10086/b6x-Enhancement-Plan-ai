package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class h extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a[] f58758a;

    public h(gm.f0 f0Var) {
        if (f0Var.size() < 1) {
            throw new IllegalArgumentException("sequence may not be empty");
        }
        this.f58758a = new a[f0Var.size()];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            this.f58758a[i10] = a.z(f0Var.K(i10));
        }
    }

    public h(gm.y yVar, b0 b0Var) {
        this(new a(yVar, b0Var));
    }

    public h(a aVar) {
        this.f58758a = new a[]{aVar};
    }

    public h(a[] aVarArr) {
        this.f58758a = x(aVarArr);
    }

    public static h A(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(gm.f0.J(obj));
        }
        return null;
    }

    public static a[] x(a[] aVarArr) {
        a[] aVarArr2 = new a[aVarArr.length];
        System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
        return aVarArr2;
    }

    public static h y(z zVar) {
        return A(z.E(zVar, y.A));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(this.f58758a);
    }

    public String toString() {
        return "AuthorityInformationAccess: Oid(" + this.f58758a[0].y().L() + ee.a.f26979d;
    }

    public a[] z() {
        return x(this.f58758a);
    }
}
