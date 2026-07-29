package zn;

import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class h1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58762a;

    public h1(gm.f0 f0Var) {
        this.f58762a = f0Var;
    }

    public h1(i1 i1Var) {
        this.f58762a = new j2(i1Var);
    }

    public h1(g1[] g1VarArr) {
        this(new i1(g1VarArr));
    }

    public static h1 x(Object obj) {
        if (obj instanceof h1) {
            return (h1) obj;
        }
        if (obj != null) {
            return new h1(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58762a;
    }

    public i1[] y() {
        i1[] i1VarArr = new i1[this.f58762a.size()];
        Enumeration enumerationL = this.f58762a.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            i1VarArr[i10] = i1.x(enumerationL.nextElement());
            i10++;
        }
        return i1VarArr;
    }
}
