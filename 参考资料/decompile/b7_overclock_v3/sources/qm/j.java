package qm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class j extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f47506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f47507b;

    public j(f0 f0Var) {
        this.f47506a = h.y(f0Var.K(0));
        this.f47507b = k.z(n0.T(f0Var.K(1)), false);
    }

    public j(h hVar, k kVar) {
        this.f47506a = hVar;
        this.f47507b = kVar;
    }

    public static j x(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f47506a);
        k kVar = this.f47507b;
        if (kVar != null) {
            iVar.a(new n2(false, 0, (gm.h) kVar));
        }
        return new j2(iVar);
    }

    public h y() {
        return this.f47506a;
    }

    public k z() {
        return this.f47507b;
    }
}
