package en;

import gm.c0;
import gm.f0;
import gm.i2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.o;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w implements gm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f27043b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27044c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27045d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f27046a;

    public d(int i10) {
        this.f27046a = new n2(false, 0, (gm.h) new t(i10));
    }

    public d(n0 n0Var) {
        if (n0Var.q() <= 2) {
            this.f27046a = n0Var;
            return;
        }
        throw new IllegalArgumentException("Bad tag number: " + n0Var.q());
    }

    public d(o oVar) {
        this.f27046a = new n2(false, 2, (gm.h) oVar);
    }

    public d(boolean z10, String str) {
        if (str.length() > 2) {
            throw new IllegalArgumentException("country can only be 2 characters");
        }
        if (z10) {
            this.f27046a = new n2(false, 1, (gm.h) new j2(new i2(str, true)));
            return;
        }
        gm.i iVar = new gm.i(2);
        iVar.a(gm.f.f29674e);
        iVar.a(new i2(str, true));
        this.f27046a = new n2(false, 1, (gm.h) new j2(iVar));
    }

    public static d z(Object obj) {
        if (obj == null || (obj instanceof d)) {
            return (d) obj;
        }
        if (obj instanceof n0) {
            return new d((n0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public int A() {
        return this.f27046a.q();
    }

    public int B() {
        if (this.f27046a.q() != 0) {
            return -1;
        }
        return t.H(this.f27046a, false).Q();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f27046a;
    }

    public f0 x() {
        if (this.f27046a.q() != 1) {
            return null;
        }
        return f0.I(this.f27046a, false);
    }

    public o y() {
        if (this.f27046a.q() != 2) {
            return null;
        }
        return o.L(this.f27046a, false);
    }
}
