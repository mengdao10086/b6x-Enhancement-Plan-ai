package zn;

import gm.f2;
import gm.j2;
import gm.n2;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class i extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.z f58763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f58764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f58765c;

    public i(gm.f0 f0Var) {
        this.f58763a = null;
        this.f58764b = null;
        this.f58765c = null;
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.n0 n0VarT = gm.n0.T(enumerationL.nextElement());
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f58763a = gm.z.H(n0VarT, false);
            } else if (iQ == 1) {
                this.f58764b = c0.z(n0VarT, false);
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("illegal tag");
                }
                this.f58765c = gm.t.H(n0VarT, false);
            }
        }
    }

    public i(c0 c0Var, BigInteger bigInteger) {
        this((byte[]) null, c0Var, bigInteger);
    }

    public i(c1 c1Var) {
        this(c1Var, (c0) null, (BigInteger) null);
    }

    public i(c1 c1Var, c0 c0Var, BigInteger bigInteger) {
        this.f58763a = null;
        this.f58764b = null;
        this.f58765c = null;
        zo.c0 c0Var2 = new zo.c0();
        byte[] bArr = new byte[c0Var2.h()];
        byte[] bArrH = c1Var.C().H();
        c0Var2.update(bArrH, 0, bArrH.length);
        c0Var2.c(bArr, 0);
        this.f58763a = new f2(bArr);
        this.f58764b = c0Var;
        this.f58765c = bigInteger != null ? new gm.t(bigInteger) : null;
    }

    public i(byte[] bArr) {
        this(bArr, (c0) null, (BigInteger) null);
    }

    public i(byte[] bArr, c0 c0Var, BigInteger bigInteger) {
        this.f58763a = null;
        this.f58764b = null;
        this.f58765c = null;
        this.f58763a = bArr != null ? new f2(bArr) : null;
        this.f58764b = c0Var;
        this.f58765c = bigInteger != null ? new gm.t(bigInteger) : null;
    }

    public static i A(gm.n0 n0Var, boolean z10) {
        return B(gm.f0.I(n0Var, z10));
    }

    public static i B(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(gm.f0.J(obj));
        }
        return null;
    }

    public static i x(z zVar) {
        return B(z.E(zVar, y.f59077v));
    }

    public byte[] C() {
        gm.z zVar = this.f58763a;
        if (zVar != null) {
            return zVar.J();
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        gm.z zVar = this.f58763a;
        if (zVar != null) {
            iVar.a(new n2(false, 0, (gm.h) zVar));
        }
        c0 c0Var = this.f58764b;
        if (c0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) c0Var));
        }
        gm.t tVar = this.f58765c;
        if (tVar != null) {
            iVar.a(new n2(false, 2, (gm.h) tVar));
        }
        return new j2(iVar);
    }

    public String toString() {
        gm.z zVar = this.f58763a;
        return "AuthorityKeyIdentifier: KeyID(" + (zVar != null ? jt.h.j(zVar.J()) : com.blankj.utilcode.util.i0.f11859x) + ee.a.f26979d;
    }

    public c0 y() {
        return this.f58764b;
    }

    public BigInteger z() {
        gm.t tVar = this.f58765c;
        if (tVar != null) {
            return tVar.K();
        }
        return null;
    }
}
