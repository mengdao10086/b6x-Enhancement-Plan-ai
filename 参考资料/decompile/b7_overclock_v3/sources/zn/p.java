package zn;

import gm.j2;
import java.util.Enumeration;
import zn.d1;

/* JADX INFO: loaded from: classes5.dex */
public class p extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d1 f58885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f58886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f58887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f58888d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f58889e;

    public p(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for CertificateList");
        }
        this.f58885a = d1.z(f0Var.K(0));
        this.f58886b = b.z(f0Var.K(1));
        this.f58887c = gm.u1.S(f0Var.K(2));
    }

    public static p x(gm.n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static p y(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(gm.f0.J(obj));
        }
        return null;
    }

    public j1 A() {
        return this.f58885a.B();
    }

    public Enumeration B() {
        return this.f58885a.C();
    }

    public d1.b[] C() {
        return this.f58885a.D();
    }

    public gm.d D() {
        return this.f58887c;
    }

    public b E() {
        return this.f58886b;
    }

    public d1 F() {
        return this.f58885a;
    }

    public j1 G() {
        return this.f58885a.F();
    }

    public int H() {
        return this.f58885a.H();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f58885a);
        iVar.a(this.f58886b);
        iVar.a(this.f58887c);
        return new j2(iVar);
    }

    @Override // gm.w
    public int hashCode() {
        if (!this.f58888d) {
            this.f58889e = super.hashCode();
            this.f58888d = true;
        }
        return this.f58889e;
    }

    public xn.d z() {
        return this.f58885a.A();
    }
}
