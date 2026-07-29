package zn;

import gm.j2;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class w0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.o f59021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.o f59022b;

    public w0(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.n0 n0Var = (gm.n0) enumerationL.nextElement();
            if (n0Var.q() == 0) {
                this.f59021a = gm.o.L(n0Var, false);
            } else if (n0Var.q() == 1) {
                this.f59022b = gm.o.L(n0Var, false);
            }
        }
    }

    public static w0 x(Object obj) {
        if (obj instanceof w0) {
            return (w0) obj;
        }
        if (obj != null) {
            return new w0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        gm.o oVar = this.f59021a;
        if (oVar != null) {
            iVar.a(new n2(false, 0, (gm.h) oVar));
        }
        gm.o oVar2 = this.f59022b;
        if (oVar2 != null) {
            iVar.a(new n2(false, 1, (gm.h) oVar2));
        }
        return new j2(iVar);
    }

    public gm.o y() {
        return this.f59022b;
    }

    public gm.o z() {
        return this.f59021a;
    }
}
