package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class n extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xn.d f42291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.h f42292b;

    public n(f0 f0Var) {
        this.f42291a = xn.d.A(f0Var.K(0));
        this.f42292b = f0Var.size() == 2 ? zn.h.A(f0Var.K(1)) : null;
    }

    public static n x(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f42291a);
        zn.h hVar = this.f42292b;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public xn.d y() {
        return this.f42291a;
    }

    public zn.h z() {
        return this.f42292b;
    }
}
