package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f42266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f42267b;

    public f(f0 f0Var) {
        this.f42266a = q.y(f0Var.K(0));
        if (f0Var.size() == 2) {
            this.f42267b = o.y((n0) f0Var.K(1), true);
        }
    }

    public f(q qVar, o oVar) {
        this.f42266a = qVar;
        this.f42267b = oVar;
    }

    public static f x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static f y(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    public q A() {
        return this.f42266a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f42266a);
        o oVar = this.f42267b;
        if (oVar != null) {
            iVar.a(new n2(true, 0, (gm.h) oVar));
        }
        return new j2(iVar);
    }

    public o z() {
        return this.f42267b;
    }
}
