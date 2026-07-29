package um;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.q0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class e extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn.d f52230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q0 f52231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f52232c;

    public e(f0 f0Var) {
        if (f0Var.size() < 2 || f0Var.size() > 3) {
            throw new IllegalArgumentException();
        }
        this.f52230a = xn.d.A(f0Var.K(0));
        this.f52231b = q0.L(f0Var.K(1));
        if (f0Var.size() > 2) {
            this.f52232c = gm.t.I(f0Var.K(2));
        }
    }

    public e(xn.d dVar, q0 q0Var) {
        this(dVar, q0Var, null);
    }

    public e(xn.d dVar, q0 q0Var, BigInteger bigInteger) {
        this.f52230a = dVar;
        this.f52231b = q0Var;
        if (bigInteger != null) {
            this.f52232c = new gm.t(bigInteger);
        }
    }

    public static e A(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f52230a.b());
        iVar.a(this.f52231b);
        gm.t tVar = this.f52232c;
        if (tVar != null) {
            iVar.a(tVar);
        }
        return new j2(iVar);
    }

    public q0 x() {
        return this.f52231b;
    }

    public xn.d y() {
        return this.f52230a;
    }

    public BigInteger z() {
        gm.t tVar = this.f52232c;
        if (tVar == null) {
            return null;
        }
        return tVar.K();
    }
}
