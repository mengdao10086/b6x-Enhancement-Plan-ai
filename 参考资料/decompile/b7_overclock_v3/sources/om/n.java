package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;
import zn.j1;

/* JADX INFO: loaded from: classes5.dex */
public class n extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j1 f44316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j1 f44317b;

    public n(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            int iQ = n0Var.q();
            j1 j1VarY = j1.y(n0Var, true);
            if (iQ == 0) {
                this.f44316a = j1VarY;
            } else {
                this.f44317b = j1VarY;
            }
        }
    }

    public n(j1 j1Var, j1 j1Var2) {
        if (j1Var == null && j1Var2 == null) {
            throw new IllegalArgumentException("at least one of notBefore/notAfter must not be null.");
        }
        this.f44316a = j1Var;
        this.f44317b = j1Var2;
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
        j1 j1Var = this.f44316a;
        if (j1Var != null) {
            iVar.a(new n2(true, 0, (gm.h) j1Var));
        }
        j1 j1Var2 = this.f44317b;
        if (j1Var2 != null) {
            iVar.a(new n2(true, 1, (gm.h) j1Var2));
        }
        return new j2(iVar);
    }

    public j1 y() {
        return this.f44317b;
    }

    public j1 z() {
        return this.f44316a;
    }
}
