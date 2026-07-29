package km;

import gm.j2;
import gm.n0;

/* JADX INFO: loaded from: classes5.dex */
public class b extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a[] f37428a;

    public b(gm.f0 f0Var) {
        this.f37428a = k0.c(f0Var);
    }

    public b(a aVar) {
        this.f37428a = new a[]{aVar};
    }

    public b(a[] aVarArr) {
        this.f37428a = k0.a(aVarArr);
    }

    public static b y(n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(this.f37428a);
    }

    public a[] x() {
        return k0.a(this.f37428a);
    }
}
