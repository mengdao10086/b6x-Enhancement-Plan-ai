package um;

import gm.c0;
import gm.f0;
import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class k extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52255a;

    public k(f0 f0Var) {
        if (f0Var.size() != 1) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        f0 f0Var2 = (f0) f0Var.K(0);
        this.f52255a = f0Var2;
        Enumeration enumerationL = f0Var2.L();
        while (enumerationL.hasMoreElements()) {
            l.x(enumerationL.nextElement());
        }
    }

    public k(l[] lVarArr) {
        this.f52255a = new j2(lVarArr);
    }

    public static k x(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new j2(this.f52255a);
    }

    public l[] y() {
        int size = this.f52255a.size();
        l[] lVarArr = new l[size];
        for (int i10 = 0; i10 < size; i10++) {
            lVarArr[i10] = l.x(this.f52255a.K(i10));
        }
        return lVarArr;
    }
}
