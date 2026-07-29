package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.t;
import gm.u1;
import gm.w;
import gm.y;
import gm.z;
import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class k extends w implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ir.e f11136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f11137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f11138c;

    public k(p pVar, BigInteger bigInteger, BigInteger bigInteger2, f0 f0Var) {
        int iQ;
        int iQ2;
        int i10;
        ir.e c0401e;
        this.f11138c = null;
        y yVarX = pVar.x();
        this.f11138c = yVarX;
        if (yVarX.C(r.f11158c0)) {
            c0401e = new e.f(((t) pVar.z()).K(), new BigInteger(1, z.I(f0Var.K(0)).J()), new BigInteger(1, z.I(f0Var.K(1)).J()), bigInteger, bigInteger2);
        } else {
            if (!this.f11138c.C(r.f11160d0)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            f0 f0VarJ = f0.J(pVar.z());
            int iQ3 = ((t) f0VarJ.K(0)).Q();
            y yVar = (y) f0VarJ.K(1);
            if (yVar.C(r.f11164f0)) {
                iQ2 = t.I(f0VarJ.K(2)).Q();
                i10 = 0;
                iQ = 0;
            } else {
                if (!yVar.C(r.f11166g0)) {
                    throw new IllegalArgumentException("This type of EC basis is not implemented");
                }
                f0 f0VarJ2 = f0.J(f0VarJ.K(2));
                int iQ4 = t.I(f0VarJ2.K(0)).Q();
                int iQ5 = t.I(f0VarJ2.K(1)).Q();
                iQ = t.I(f0VarJ2.K(2)).Q();
                iQ2 = iQ4;
                i10 = iQ5;
            }
            c0401e = new e.C0401e(iQ3, iQ2, i10, iQ, new BigInteger(1, z.I(f0Var.K(0)).J()), new BigInteger(1, z.I(f0Var.K(1)).J()), bigInteger, bigInteger2);
        }
        this.f11136a = c0401e;
        if (f0Var.size() == 3) {
            this.f11137b = ((u1) f0Var.K(2)).H();
        }
    }

    public k(ir.e eVar) {
        this(eVar, null);
    }

    public k(ir.e eVar, byte[] bArr) {
        this.f11138c = null;
        this.f11136a = eVar;
        this.f11137b = org.bouncycastle.util.a.p(bArr);
        z();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        if (this.f11138c.C(r.f11158c0) || this.f11138c.C(r.f11160d0)) {
            iVar.a(new o(this.f11136a.o()).b());
            o oVar = new o(this.f11136a.q());
            iVar.a(oVar.b());
        }
        if (this.f11137b != null) {
            iVar.a(new u1(this.f11137b));
        }
        return new j2(iVar);
    }

    public ir.e x() {
        return this.f11136a;
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f11137b);
    }

    public final void z() {
        y yVar;
        if (ir.c.o(this.f11136a)) {
            yVar = r.f11158c0;
        } else {
            if (!ir.c.m(this.f11136a)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            yVar = r.f11160d0;
        }
        this.f11138c = yVar;
    }
}
