package lm;

import gm.j2;
import gm.n0;
import gm.p2;
import gm.r0;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class v extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39998a;

    public v(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            if (!(enumerationL.nextElement() instanceof r0)) {
                throw new IllegalArgumentException("attempt to insert non UTF8 STRING into PKIFreeText");
            }
        }
        this.f39998a = f0Var;
    }

    public v(r0 r0Var) {
        this.f39998a = new j2(r0Var);
    }

    public v(String str) {
        this(new p2(str));
    }

    public v(r0[] r0VarArr) {
        this.f39998a = new j2(r0VarArr);
    }

    public v(String[] strArr) {
        gm.i iVar = new gm.i(strArr.length);
        for (String str : strArr) {
            iVar.a(new p2(str));
        }
        this.f39998a = new j2(iVar);
    }

    public static v x(n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static v y(Object obj) {
        if (obj instanceof v) {
            return (v) obj;
        }
        if (obj != null) {
            return new v(gm.f0.J(obj));
        }
        return null;
    }

    public r0 A(int i10) {
        return (r0) this.f39998a.K(i10);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39998a;
    }

    public int size() {
        return this.f39998a.size();
    }

    public p2 z(int i10) {
        r0 r0VarA = A(i10);
        return (r0VarA == null || (r0VarA instanceof p2)) ? (p2) r0VarA : new p2(r0VarA.d());
    }
}
