package zn;

import gm.j2;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class m0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0[] f58848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0[] f58849b;

    public m0(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.n0 n0VarT = gm.n0.T(enumerationL.nextElement());
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f58848a = y(gm.f0.I(n0VarT, false));
            } else {
                if (iQ != 1) {
                    throw new IllegalArgumentException("Unknown tag encountered: " + n0VarT.q());
                }
                this.f58849b = y(gm.f0.I(n0VarT, false));
            }
        }
    }

    public m0(e0[] e0VarArr, e0[] e0VarArr2) {
        this.f58848a = x(e0VarArr);
        this.f58849b = x(e0VarArr2);
    }

    public static m0 A(Object obj) {
        if (obj instanceof m0) {
            return (m0) obj;
        }
        if (obj != null) {
            return new m0(gm.f0.J(obj));
        }
        return null;
    }

    public static e0[] x(e0[] e0VarArr) {
        if (e0VarArr == null) {
            return null;
        }
        int length = e0VarArr.length;
        e0[] e0VarArr2 = new e0[length];
        System.arraycopy(e0VarArr, 0, e0VarArr2, 0, length);
        return e0VarArr2;
    }

    public e0[] B() {
        return x(this.f58848a);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        if (this.f58848a != null) {
            iVar.a(new n2(false, 0, (gm.h) new j2(this.f58848a)));
        }
        if (this.f58849b != null) {
            iVar.a(new n2(false, 1, (gm.h) new j2(this.f58849b)));
        }
        return new j2(iVar);
    }

    public final e0[] y(gm.f0 f0Var) {
        int size = f0Var.size();
        e0[] e0VarArr = new e0[size];
        for (int i10 = 0; i10 != size; i10++) {
            e0VarArr[i10] = e0.z(f0Var.K(i10));
        }
        return e0VarArr;
    }

    public e0[] z() {
        return x(this.f58849b);
    }
}
