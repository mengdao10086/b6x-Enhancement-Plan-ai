package pn;

import gm.f0;
import gm.h0;
import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;
import zn.c1;
import zn.w1;

/* JADX INFO: loaded from: classes5.dex */
public class f extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f46757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c1 f46758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f46759d;

    public f(f0 f0Var) {
        this.f46756a = new gm.t(0L);
        this.f46759d = null;
        this.f46756a = (gm.t) f0Var.K(0);
        this.f46757b = xn.d.A(f0Var.K(1));
        this.f46758c = c1.A(f0Var.K(2));
        if (f0Var.size() > 3) {
            this.f46759d = h0.H((n0) f0Var.K(3), false);
        }
        C(this.f46759d);
        if (this.f46757b == null || this.f46756a == null || this.f46758c == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    public f(xn.d dVar, c1 c1Var, h0 h0Var) {
        this.f46756a = new gm.t(0L);
        this.f46759d = null;
        if (dVar == null || c1Var == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
        C(h0Var);
        this.f46757b = dVar;
        this.f46758c = c1Var;
        this.f46759d = h0Var;
    }

    public f(w1 w1Var, c1 c1Var, h0 h0Var) {
        this(xn.d.A(w1Var.b()), c1Var, h0Var);
    }

    public static void C(h0 h0Var) {
        if (h0Var == null) {
            return;
        }
        Enumeration enumerationK = h0Var.K();
        while (enumerationK.hasMoreElements()) {
            a aVarA = a.A(enumerationK.nextElement());
            if (aVarA.x().C(s.B4) && aVarA.y().size() != 1) {
                throw new IllegalArgumentException("challengePassword attribute must have one value");
            }
        }
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

    public c1 A() {
        return this.f46758c;
    }

    public gm.t B() {
        return this.f46756a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f46756a);
        iVar.a(this.f46757b);
        iVar.a(this.f46758c);
        h0 h0Var = this.f46759d;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        return new j2(iVar);
    }

    public h0 x() {
        return this.f46759d;
    }

    public xn.d z() {
        return this.f46757b;
    }
}
