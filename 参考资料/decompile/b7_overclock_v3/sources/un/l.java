package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;
import java.util.Enumeration;
import lm.b0;
import mm.n;

/* JADX INFO: loaded from: classes5.dex */
public class l extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f52325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f52326b;

    public l(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f52325a = b0.z(enumerationL.nextElement());
        if (enumerationL.hasMoreElements()) {
            this.f52326b = n.A(enumerationL.nextElement());
        }
    }

    public l(b0 b0Var, n nVar) {
        this.f52325a = b0Var;
        this.f52326b = nVar;
    }

    public static l x(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52325a);
        n nVar = this.f52326b;
        if (nVar != null) {
            iVar.a(nVar);
        }
        return new j2(iVar);
    }

    public b0 y() {
        return this.f52325a;
    }

    public n z() {
        return this.f52326b;
    }
}
