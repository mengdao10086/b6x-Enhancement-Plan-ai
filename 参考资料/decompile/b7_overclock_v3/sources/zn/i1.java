package zn;

import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class i1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58773a;

    public i1(gm.f0 f0Var) {
        this.f58773a = f0Var;
    }

    public i1(g1[] g1VarArr) {
        this.f58773a = new j2(g1VarArr);
    }

    public static i1 x(Object obj) {
        if (obj instanceof i1) {
            return (i1) obj;
        }
        if (obj != null) {
            return new i1(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58773a;
    }

    public g1[] y() {
        g1[] g1VarArr = new g1[this.f58773a.size()];
        Enumeration enumerationL = this.f58773a.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            g1VarArr[i10] = g1.x(enumerationL.nextElement());
            i10++;
        }
        return g1VarArr;
    }
}
