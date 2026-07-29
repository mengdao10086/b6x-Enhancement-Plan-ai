package an;

import gm.c0;
import gm.f0;
import gm.h0;
import gm.i;
import gm.j2;
import gm.l2;
import gm.t;
import gm.w;
import zn.o;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o[] f804b;

    public a(f0 f0Var) {
        this.f803a = new t(0L);
        if (f0Var == null || f0Var.size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("Incorrect sequence size: " + f0Var.size());
        }
        int i10 = 0;
        this.f803a = t.I(f0Var.K(0));
        h0 h0VarI = h0.I(f0Var.K(1));
        this.f804b = new o[h0VarI.size()];
        while (true) {
            o[] oVarArr = this.f804b;
            if (i10 >= oVarArr.length) {
                return;
            }
            oVarArr[i10] = o.z(h0VarI.J(i10));
            i10++;
        }
    }

    public a(o[] oVarArr) {
        this.f803a = new t(0L);
        this.f804b = x(oVarArr);
    }

    public static a z(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    public int A() {
        return this.f803a.Q();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f803a);
        iVar.a(new l2(this.f804b));
        return new j2(iVar);
    }

    public final o[] x(o[] oVarArr) {
        int length = oVarArr.length;
        o[] oVarArr2 = new o[length];
        for (int i10 = 0; i10 != length; i10++) {
            oVarArr2[i10] = oVarArr[i10];
        }
        return oVarArr2;
    }

    public o[] y() {
        return x(this.f804b);
    }
}
