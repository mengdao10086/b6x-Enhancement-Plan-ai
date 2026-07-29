package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class r extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0[] f58931a;

    public r(gm.f0 f0Var) {
        this.f58931a = new s0[f0Var.size()];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            this.f58931a[i10] = s0.x(f0Var.K(i10));
        }
    }

    public r(s0 s0Var) {
        this.f58931a = new s0[]{s0Var};
    }

    public r(s0[] s0VarArr) {
        this.f58931a = x(s0VarArr);
    }

    public static r A(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj != null) {
            return new r(gm.f0.J(obj));
        }
        return null;
    }

    public static s0[] x(s0[] s0VarArr) {
        s0[] s0VarArr2 = new s0[s0VarArr.length];
        System.arraycopy(s0VarArr, 0, s0VarArr2, 0, s0VarArr.length);
        return s0VarArr2;
    }

    public static r y(z zVar) {
        return A(z.E(zVar, y.f59075t));
    }

    public static r z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public s0 B(gm.y yVar) {
        int i10 = 0;
        while (true) {
            s0[] s0VarArr = this.f58931a;
            if (i10 == s0VarArr.length) {
                return null;
            }
            if (yVar.C(s0VarArr[i10].y())) {
                return this.f58931a[i10];
            }
            i10++;
        }
    }

    public s0[] C() {
        return x(this.f58931a);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(this.f58931a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < this.f58931a.length; i10++) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.f58931a[i10]);
        }
        return "CertificatePolicies: [" + ((Object) stringBuffer) + "]";
    }
}
