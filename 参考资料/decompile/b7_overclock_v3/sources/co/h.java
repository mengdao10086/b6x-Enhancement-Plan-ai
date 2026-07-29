package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.t;
import gm.u1;
import gm.w;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.d f11107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f11108b;

    public h(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f11107a = gm.d.K(f0Var.K(0));
            this.f11108b = t.I(f0Var.K(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public h(u1 u1Var, t tVar) {
        if (u1Var == null) {
            throw new IllegalArgumentException("'seed' cannot be null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("'pgenCounter' cannot be null");
        }
        this.f11107a = u1Var;
        this.f11108b = tVar;
    }

    public h(byte[] bArr, int i10) {
        if (bArr == null) {
            throw new IllegalArgumentException("'seed' cannot be null");
        }
        this.f11107a = new u1(bArr);
        this.f11108b = new t(i10);
    }

    public static h x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static h y(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(f0.J(obj));
        }
        return null;
    }

    public byte[] A() {
        return this.f11107a.H();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f11107a);
        iVar.a(this.f11108b);
        return new j2(iVar);
    }

    public BigInteger z() {
        return this.f11108b.J();
    }
}
