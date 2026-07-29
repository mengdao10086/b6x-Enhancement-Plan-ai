package um;

import gm.c0;
import gm.f0;
import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class f extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52233a;

    public f(f0 f0Var) {
        f0 f0Var2 = (f0) f0Var.K(0);
        this.f52233a = f0Var2;
        Enumeration enumerationL = f0Var2.L();
        while (enumerationL.hasMoreElements()) {
            h.z(enumerationL.nextElement());
        }
    }

    public f(h[] hVarArr) {
        this.f52233a = new j2(hVarArr);
    }

    public static f y(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new j2(this.f52233a);
    }

    public h[] x() {
        int size = this.f52233a.size();
        h[] hVarArr = new h[size];
        for (int i10 = 0; i10 < size; i10++) {
            hVarArr[i10] = h.z(this.f52233a.K(i10));
        }
        return hVarArr;
    }
}
