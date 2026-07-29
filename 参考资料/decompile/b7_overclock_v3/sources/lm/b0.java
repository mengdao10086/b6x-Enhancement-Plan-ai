package lm;

import gm.j2;
import gm.n0;
import gm.u1;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f39856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f39857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f39858c;

    public b0(gm.f0 f0Var) {
        gm.d dVarK;
        this.f39856a = gm.t.I(f0Var.K(0));
        this.f39857b = null;
        this.f39858c = null;
        if (f0Var.size() > 2) {
            this.f39857b = v.y(f0Var.K(1));
            dVarK = u1.S(f0Var.K(2));
        } else {
            if (f0Var.size() <= 1) {
                return;
            }
            gm.h hVarK = f0Var.K(1);
            if (!(hVarK instanceof gm.d)) {
                this.f39857b = v.y(hVarK);
                return;
            }
            dVarK = gm.d.K(hVarK);
        }
        this.f39858c = dVarK;
    }

    public b0(a0 a0Var) {
        this.f39856a = gm.t.I(a0Var.b());
    }

    public b0(a0 a0Var, v vVar) {
        this.f39856a = gm.t.I(a0Var.b());
        this.f39857b = vVar;
    }

    public b0(a0 a0Var, v vVar, u uVar) {
        this.f39856a = gm.t.I(a0Var.b());
        this.f39857b = vVar;
        this.f39858c = uVar;
    }

    public static b0 y(n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static b0 z(Object obj) {
        if (obj instanceof b0) {
            return (b0) obj;
        }
        if (obj != null) {
            return new b0(gm.f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f39856a.K();
    }

    public v B() {
        return this.f39857b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f39856a);
        v vVar = this.f39857b;
        if (vVar != null) {
            iVar.a(vVar);
        }
        gm.d dVar = this.f39858c;
        if (dVar != null) {
            iVar.a(dVar);
        }
        return new j2(iVar);
    }

    public gm.d x() {
        return this.f39858c;
    }
}
