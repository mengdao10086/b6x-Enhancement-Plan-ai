package wm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a[] f54750a;

    public b(f0 f0Var) {
        this.f54750a = new a[f0Var.size()];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            this.f54750a[i10] = a.y(f0Var.K(i10));
        }
    }

    public b(a aVar) {
        this.f54750a = new a[]{aVar};
    }

    public b(a[] aVarArr) {
        this.f54750a = c.a(aVarArr);
    }

    public static b y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new j2(this.f54750a);
    }

    public int size() {
        return this.f54750a.length;
    }

    public a[] x() {
        return c.a(this.f54750a);
    }
}
