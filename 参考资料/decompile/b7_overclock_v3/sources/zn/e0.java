package zn;

import gm.j2;
import gm.n2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class e0 extends gm.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f58702d = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f58703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f58705c;

    public e0(gm.f0 f0Var) {
        gm.n0 n0VarT;
        this.f58703a = b0.z(f0Var.K(0));
        int size = f0Var.size();
        if (size != 1) {
            if (size == 2) {
                n0VarT = gm.n0.T(f0Var.K(1));
                int iQ = n0VarT.q();
                if (iQ == 0) {
                    this.f58704b = gm.t.H(n0VarT, false);
                    return;
                } else if (iQ != 1) {
                    throw new IllegalArgumentException("Bad tag number: " + n0VarT.q());
                }
            } else {
                if (size != 3) {
                    throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
                }
                gm.n0 n0VarT2 = gm.n0.T(f0Var.K(1));
                if (n0VarT2.q() != 0) {
                    throw new IllegalArgumentException("Bad tag number for 'minimum': " + n0VarT2.q());
                }
                this.f58704b = gm.t.H(n0VarT2, false);
                n0VarT = gm.n0.T(f0Var.K(2));
                if (n0VarT.q() != 1) {
                    throw new IllegalArgumentException("Bad tag number for 'maximum': " + n0VarT.q());
                }
            }
            this.f58705c = gm.t.H(n0VarT, false);
        }
    }

    public e0(b0 b0Var) {
        this(b0Var, null, null);
    }

    public e0(b0 b0Var, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f58703a = b0Var;
        if (bigInteger2 != null) {
            this.f58705c = new gm.t(bigInteger2);
        }
        this.f58704b = bigInteger == null ? null : new gm.t(bigInteger);
    }

    public static e0 y(gm.n0 n0Var, boolean z10) {
        return new e0(gm.f0.I(n0Var, z10));
    }

    public static e0 z(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof e0 ? (e0) obj : new e0(gm.f0.J(obj));
    }

    public BigInteger A() {
        gm.t tVar = this.f58705c;
        if (tVar == null) {
            return null;
        }
        return tVar.K();
    }

    public BigInteger B() {
        gm.t tVar = this.f58704b;
        return tVar == null ? f58702d : tVar.K();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f58703a);
        gm.t tVar = this.f58704b;
        if (tVar != null && !tVar.L(0)) {
            iVar.a(new n2(false, 0, (gm.h) this.f58704b));
        }
        gm.t tVar2 = this.f58705c;
        if (tVar2 != null) {
            iVar.a(new n2(false, 1, (gm.h) tVar2));
        }
        return new j2(iVar);
    }

    public b0 x() {
        return this.f58703a;
    }
}
