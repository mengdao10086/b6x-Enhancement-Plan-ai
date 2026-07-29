package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.w;
import gm.y;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class k extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f42280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f42281b;

    public k(f0 f0Var) {
        this.f42280a = (y) f0Var.K(0);
        this.f42281b = (z) f0Var.K(1);
    }

    public k(y yVar, z zVar) {
        this.f42280a = yVar;
        this.f42281b = zVar;
    }

    public static k x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static k y(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    public y A() {
        return this.f42280a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f42280a);
        iVar.a(this.f42281b);
        return new j2(iVar);
    }

    public z z() {
        return this.f42281b;
    }
}
