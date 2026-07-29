package un;

import gm.c0;
import gm.f0;
import gm.n0;
import gm.w;
import gm.y;
import gm.z2;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f52298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f52299b;

    public f(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f52298a = y.N(f0Var.K(0));
            this.f52299b = f0Var.K(1);
        } else {
            throw new IllegalArgumentException("wrong sequence size in constructor: " + f0Var.size());
        }
    }

    public f(y yVar, gm.h hVar) {
        this.f52298a = yVar;
        this.f52299b = hVar;
    }

    public static f x(w wVar) {
        if (wVar instanceof f) {
            return (f) wVar;
        }
        if (wVar != null) {
            return new f(f0.J(wVar));
        }
        return null;
    }

    public static f y(n0 n0Var, boolean z10) {
        return x(f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52298a);
        iVar.a(this.f52299b);
        return new z2(iVar);
    }
}
