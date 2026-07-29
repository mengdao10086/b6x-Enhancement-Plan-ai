package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import zn.b0;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class t extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f44338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f44339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c1 f44340c;

    public t(f0 f0Var) {
        gm.h hVarK = f0Var.K(0);
        if (hVarK instanceof n0) {
            n0 n0Var = (n0) hVarK;
            if (n0Var.q() != 0) {
                throw new IllegalArgumentException("Unknown authInfo tag: " + n0Var.q());
            }
            this.f44338a = b0.z(n0Var.U());
        } else {
            this.f44339b = q.z(hVarK);
        }
        this.f44340c = c1.A(f0Var.K(1));
    }

    public t(q qVar, c1 c1Var) {
        this.f44339b = qVar;
        this.f44340c = c1Var;
    }

    public t(b0 b0Var, c1 c1Var) {
        this.f44338a = b0Var;
        this.f44340c = c1Var;
    }

    public static t x(Object obj) {
        if (obj instanceof t) {
            return (t) obj;
        }
        if (obj != null) {
            return new t(f0.J(obj));
        }
        return null;
    }

    public b0 A() {
        return this.f44338a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        b0 b0Var = this.f44338a;
        if (b0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) b0Var));
        } else {
            iVar.a(this.f44339b);
        }
        iVar.a(this.f44340c);
        return new j2(iVar);
    }

    public c1 y() {
        return this.f44340c;
    }

    public q z() {
        return this.f44339b;
    }
}
