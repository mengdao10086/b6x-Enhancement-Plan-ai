package um;

import gm.c0;
import gm.f0;
import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class d extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52229a;

    public d(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            g.y(enumerationL.nextElement());
        }
        this.f52229a = f0Var;
    }

    public d(g[] gVarArr) {
        this.f52229a = new j2(gVarArr);
    }

    public static d y(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f52229a;
    }

    public g[] x() {
        int size = this.f52229a.size();
        g[] gVarArr = new g[size];
        for (int i10 = 0; i10 < size; i10++) {
            gVarArr[i10] = g.y(this.f52229a.K(i10));
        }
        return gVarArr;
    }
}
