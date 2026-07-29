package mm;

import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class y0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x0[] f41434a;

    public y0(gm.f0 f0Var) {
        this.f41434a = new x0[f0Var.size()];
        Enumeration enumerationL = f0Var.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            this.f41434a[i10] = x0.z(enumerationL.nextElement());
            i10++;
        }
    }

    public y0(x0 x0Var) {
        this.f41434a = new x0[]{x0Var};
    }

    public y0(x0[] x0VarArr) {
        this.f41434a = x(x0VarArr);
    }

    public static y0 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static y0 z(Object obj) {
        if (obj instanceof y0) {
            return (y0) obj;
        }
        if (obj != null) {
            return new y0(gm.f0.J(obj));
        }
        return null;
    }

    public x0[] A() {
        return x(this.f41434a);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(this.f41434a.length);
        int i10 = 0;
        while (true) {
            x0[] x0VarArr = this.f41434a;
            if (i10 == x0VarArr.length) {
                return new j2(iVar);
            }
            iVar.a(x0VarArr[i10]);
            i10++;
        }
    }

    public final x0[] x(x0[] x0VarArr) {
        int length = x0VarArr.length;
        x0[] x0VarArr2 = new x0[length];
        System.arraycopy(x0VarArr, 0, x0VarArr2, 0, length);
        return x0VarArr2;
    }
}
