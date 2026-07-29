package lm;

import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class f0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39894a;

    public f0(gm.f0 f0Var) {
        this.f39894a = f0Var;
    }

    public f0(gm.t tVar) {
        this(new j2(new j2(tVar)));
    }

    public f0(BigInteger bigInteger) {
        this(new gm.t(bigInteger));
    }

    public f0(gm.t[] tVarArr) {
        this(new j2(B(tVarArr)));
    }

    public f0(BigInteger[] bigIntegerArr) {
        this(A(bigIntegerArr));
    }

    public static gm.t[] A(BigInteger[] bigIntegerArr) {
        int length = bigIntegerArr.length;
        gm.t[] tVarArr = new gm.t[length];
        for (int i10 = 0; i10 != length; i10++) {
            tVarArr[i10] = new gm.t(bigIntegerArr[i10]);
        }
        return tVarArr;
    }

    public static j2[] B(gm.t[] tVarArr) {
        int length = tVarArr.length;
        j2[] j2VarArr = new j2[length];
        for (int i10 = 0; i10 != length; i10++) {
            j2VarArr[i10] = new j2(tVarArr[i10]);
        }
        return j2VarArr;
    }

    public static gm.t[] C(gm.f0 f0Var) {
        int size = f0Var.size();
        gm.t[] tVarArr = new gm.t[size];
        for (int i10 = 0; i10 != size; i10++) {
            tVarArr[i10] = gm.t.I(f0Var.K(i10));
        }
        return tVarArr;
    }

    public static f0 z(Object obj) {
        if (obj instanceof f0) {
            return (f0) obj;
        }
        if (obj != null) {
            return new f0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39894a;
    }

    public BigInteger[] x() {
        int size = this.f39894a.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i10 = 0; i10 != size; i10++) {
            bigIntegerArr[i10] = gm.t.I(gm.f0.J(this.f39894a.K(i10)).K(0)).K();
        }
        return bigIntegerArr;
    }

    public gm.t[][] y() {
        int size = this.f39894a.size();
        gm.t[][] tVarArr = new gm.t[size][];
        for (int i10 = 0; i10 != size; i10++) {
            tVarArr[i10] = C((gm.f0) this.f39894a.K(i10));
        }
        return tVarArr;
    }
}
