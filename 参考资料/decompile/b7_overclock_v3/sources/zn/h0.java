package zn;

import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f58759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f58761c;

    public h0(gm.f0 f0Var) {
        if (f0Var.size() != 2 && f0Var.size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f58759a = c0.A(f0Var.K(0));
        this.f58760b = gm.t.I(f0Var.K(1));
        if (f0Var.size() == 3) {
            this.f58761c = gm.u1.S(f0Var.K(2));
        }
    }

    public h0(xn.d dVar, BigInteger bigInteger) {
        this(new c0(new b0(dVar)), new gm.t(bigInteger));
    }

    public h0(c0 c0Var, gm.t tVar) {
        this.f58759a = c0Var;
        this.f58760b = tVar;
    }

    public h0(c0 c0Var, BigInteger bigInteger) {
        this(c0Var, new gm.t(bigInteger));
    }

    public static h0 x(gm.n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static h0 y(Object obj) {
        if (obj instanceof h0) {
            return (h0) obj;
        }
        if (obj != null) {
            return new h0(gm.f0.J(obj));
        }
        return null;
    }

    public gm.d A() {
        return this.f58761c;
    }

    public gm.t B() {
        return this.f58760b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f58759a);
        iVar.a(this.f58760b);
        gm.d dVar = this.f58761c;
        if (dVar != null) {
            iVar.a(dVar);
        }
        return new j2(iVar);
    }

    public c0 z() {
        return this.f58759a;
    }
}
