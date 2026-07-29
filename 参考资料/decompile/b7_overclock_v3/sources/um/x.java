package um;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class x extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f52280a;

    public x(f0 f0Var) {
        this.f52280a = new Object[f0Var.size()];
        Enumeration enumerationL = f0Var.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            n0 n0VarT = n0.T(enumerationL.nextElement());
            if (n0VarT.q() == 0) {
                f0 f0VarI = f0.I(n0VarT, true);
                int size = f0VarI.size();
                zn.e[] eVarArr = new zn.e[size];
                for (int i11 = 0; i11 != size; i11++) {
                    eVarArr[i11] = zn.e.A(f0VarI.K(i11));
                }
                this.f52280a[i10] = eVarArr;
            } else {
                if (n0VarT.q() != 1) {
                    throw new IllegalArgumentException("illegal tag: " + n0VarT.q());
                }
                this.f52280a[i10] = zn.f.y(f0.I(n0VarT, true));
            }
            i10++;
        }
    }

    public x(zn.f fVar) {
        this.f52280a = new Object[]{fVar};
    }

    public x(zn.e[] eVarArr) {
        this.f52280a = new Object[]{eVarArr};
    }

    public static x x(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        if (obj != null) {
            return new x(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(this.f52280a.length);
        int i10 = 0;
        while (true) {
            Object[] objArr = this.f52280a;
            if (i10 == objArr.length) {
                return new j2(iVar);
            }
            if (objArr[i10] instanceof zn.e[]) {
                iVar.a(new n2(0, new j2((zn.e[]) this.f52280a[i10])));
            } else {
                iVar.a(new n2(1, (zn.f) objArr[i10]));
            }
            i10++;
        }
    }

    public Object[] y() {
        Object[] objArr = this.f52280a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }
}
