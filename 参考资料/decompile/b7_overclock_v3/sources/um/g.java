package um;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class g extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f52234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f52235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f52236c;

    public g(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f52234a = f.y(n0Var.U());
            } else if (iQ == 1) {
                this.f52235b = k.x(n0Var.U());
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("illegal tag");
                }
                this.f52236c = o.x(n0Var.U());
            }
        }
    }

    public g(f fVar, k kVar, o oVar) {
        this.f52234a = fVar;
        this.f52235b = kVar;
        this.f52236c = oVar;
    }

    public static g y(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    public o A() {
        return this.f52236c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        f fVar = this.f52234a;
        if (fVar != null) {
            iVar.a(new n2(true, 0, (gm.h) fVar.b()));
        }
        k kVar = this.f52235b;
        if (kVar != null) {
            iVar.a(new n2(true, 1, (gm.h) kVar.b()));
        }
        o oVar = this.f52236c;
        if (oVar != null) {
            iVar.a(new n2(true, 2, (gm.h) oVar.b()));
        }
        return new j2(iVar);
    }

    public f x() {
        return this.f52234a;
    }

    public k z() {
        return this.f52235b;
    }
}
