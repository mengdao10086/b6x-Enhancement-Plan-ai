package km;

import gm.j2;
import gm.n0;

/* JADX INFO: loaded from: classes5.dex */
public class c extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a[] f37432a;

    public c(gm.f0 f0Var) {
        this.f37432a = k0.c(f0Var);
    }

    public c(a aVar) {
        this.f37432a = new a[]{aVar};
    }

    public c(a[] aVarArr) {
        this.f37432a = k0.a(aVarArr);
    }

    public static c y(n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static c z(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(this.f37432a);
    }

    public a[] x() {
        return k0.a(this.f37432a);
    }
}
