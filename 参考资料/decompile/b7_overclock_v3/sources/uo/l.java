package uo;

import java.math.BigInteger;
import np.g0;
import np.g2;
import np.h2;
import np.l0;
import np.u1;
import org.bouncycastle.crypto.s;
import zo.k0;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f52372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f52373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f52374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ir.i f52375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ir.i f52376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g0 f52377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f52378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l0 f52379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f52380i;

    public l() {
        this(new k0());
    }

    public l(s sVar) {
        this.f52372a = sVar;
    }

    public final byte[] a(s sVar, ir.i iVar, byte[] bArr) {
        sVar.update((byte) 2);
        c(sVar, iVar.g());
        sVar.update(bArr, 0, bArr.length);
        return i();
    }

    public final byte[] b(s sVar, ir.i iVar, byte[] bArr) {
        sVar.update((byte) 3);
        c(sVar, iVar.g());
        sVar.update(bArr, 0, bArr.length);
        return i();
    }

    public final void c(s sVar, ir.f fVar) {
        byte[] bArrE = fVar.e();
        sVar.update(bArrE, 0, bArrE.length);
    }

    public final void d(s sVar, byte[] bArr) {
        int length = bArr.length * 8;
        sVar.update((byte) (length >>> 8));
        sVar.update((byte) length);
        sVar.update(bArr, 0, bArr.length);
    }

    public final byte[] e(s sVar, ir.i iVar, byte[] bArr, byte[] bArr2, ir.i iVar2, ir.i iVar3) {
        c(sVar, iVar.f());
        sVar.update(bArr, 0, bArr.length);
        sVar.update(bArr2, 0, bArr2.length);
        c(sVar, iVar2.f());
        c(sVar, iVar2.g());
        c(sVar, iVar3.f());
        c(sVar, iVar3.g());
        return i();
    }

    public byte[] f(int i10, org.bouncycastle.crypto.k kVar) {
        h2 h2Var;
        byte[] bArrA;
        if (kVar instanceof u1) {
            u1 u1Var = (u1) kVar;
            h2Var = (h2) u1Var.b();
            bArrA = u1Var.a();
        } else {
            h2Var = (h2) kVar;
            bArrA = new byte[0];
        }
        byte[] bArrJ = j(this.f52372a, this.f52373b, this.f52375d);
        byte[] bArrJ2 = j(this.f52372a, bArrA, h2Var.b().e());
        ir.i iVarH = h(h2Var);
        return this.f52380i ? l(iVarH, bArrJ, bArrJ2, i10) : l(iVarH, bArrJ2, bArrJ, i10);
    }

    public byte[][] g(int i10, byte[] bArr, org.bouncycastle.crypto.k kVar) {
        h2 h2Var;
        byte[] bArrA;
        if (kVar instanceof u1) {
            u1 u1Var = (u1) kVar;
            h2Var = (h2) u1Var.b();
            bArrA = u1Var.a();
        } else {
            h2Var = (h2) kVar;
            bArrA = new byte[0];
        }
        if (this.f52380i && bArr == null) {
            throw new IllegalArgumentException("if initiating, confirmationTag must be set");
        }
        byte[] bArrJ = j(this.f52372a, this.f52373b, this.f52375d);
        byte[] bArrJ2 = j(this.f52372a, bArrA, h2Var.b().e());
        ir.i iVarH = h(h2Var);
        if (!this.f52380i) {
            byte[] bArrL = l(iVarH, bArrJ2, bArrJ, i10);
            byte[] bArrE = e(this.f52372a, iVarH, bArrJ2, bArrJ, h2Var.a().e(), this.f52376e);
            return new byte[][]{bArrL, a(this.f52372a, iVarH, bArrE), b(this.f52372a, iVarH, bArrE)};
        }
        byte[] bArrL2 = l(iVarH, bArrJ, bArrJ2, i10);
        byte[] bArrE2 = e(this.f52372a, iVarH, bArrJ, bArrJ2, this.f52376e, h2Var.a().e());
        if (org.bouncycastle.util.a.I(a(this.f52372a, iVarH, bArrE2), bArr)) {
            return new byte[][]{bArrL2, b(this.f52372a, iVarH, bArrE2)};
        }
        throw new IllegalStateException("confirmation tag mismatch");
    }

    public final ir.i h(h2 h2Var) {
        g0 g0VarD = this.f52374c.d();
        ir.i iVarA = ir.c.a(g0VarD.a(), h2Var.b().e());
        ir.i iVarA2 = ir.c.a(g0VarD.a(), h2Var.a().e());
        BigInteger bigIntegerM = m(this.f52376e.f().v());
        BigInteger bigIntegerM2 = m(iVarA2.f().v());
        BigInteger bigIntegerMod = this.f52377f.c().multiply(this.f52374c.e().add(bigIntegerM.multiply(this.f52379h.e()))).mod(this.f52377f.e());
        return ir.c.v(iVarA, bigIntegerMod, iVarA2, bigIntegerMod.multiply(bigIntegerM2).mod(this.f52377f.e())).B();
    }

    public final byte[] i() {
        byte[] bArr = new byte[this.f52372a.h()];
        this.f52372a.c(bArr, 0);
        return bArr;
    }

    public final byte[] j(s sVar, byte[] bArr, ir.i iVar) {
        d(sVar, bArr);
        c(sVar, this.f52377f.a().o());
        c(sVar, this.f52377f.a().q());
        c(sVar, this.f52377f.b().f());
        c(sVar, this.f52377f.b().g());
        c(sVar, iVar.f());
        c(sVar, iVar.g());
        return i();
    }

    public void k(org.bouncycastle.crypto.k kVar) {
        g2 g2Var;
        if (kVar instanceof u1) {
            u1 u1Var = (u1) kVar;
            g2Var = (g2) u1Var.b();
            this.f52373b = u1Var.a();
        } else {
            g2Var = (g2) kVar;
            this.f52373b = new byte[0];
        }
        this.f52380i = g2Var.e();
        this.f52374c = g2Var.c();
        this.f52379h = g2Var.a();
        this.f52377f = this.f52374c.d();
        this.f52375d = g2Var.d();
        this.f52376e = g2Var.b();
        this.f52378g = (this.f52377f.a().v() / 2) - 1;
    }

    public final byte[] l(ir.i iVar, byte[] bArr, byte[] bArr2, int i10) {
        org.bouncycastle.util.m mVarD;
        int iH = this.f52372a.h();
        byte[] bArr3 = new byte[Math.max(4, iH)];
        int i11 = (i10 + 7) / 8;
        byte[] bArr4 = new byte[i11];
        s sVar = this.f52372a;
        org.bouncycastle.util.m mVar = null;
        if (sVar instanceof org.bouncycastle.util.m) {
            c(sVar, iVar.f());
            c(this.f52372a, iVar.g());
            this.f52372a.update(bArr, 0, bArr.length);
            this.f52372a.update(bArr2, 0, bArr2.length);
            mVar = (org.bouncycastle.util.m) this.f52372a;
            mVarD = mVar.d();
        } else {
            mVarD = null;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            if (mVar != null) {
                mVar.i(mVarD);
            } else {
                c(this.f52372a, iVar.f());
                c(this.f52372a, iVar.g());
                this.f52372a.update(bArr, 0, bArr.length);
                this.f52372a.update(bArr2, 0, bArr2.length);
            }
            i13++;
            org.bouncycastle.util.o.h(i13, bArr3, 0);
            this.f52372a.update(bArr3, 0, 4);
            this.f52372a.c(bArr3, 0);
            int iMin = Math.min(iH, i11 - i12);
            System.arraycopy(bArr3, 0, bArr4, i12, iMin);
            i12 += iMin;
        }
        return bArr4;
    }

    public final BigInteger m(BigInteger bigInteger) {
        return bigInteger.and(BigInteger.valueOf(1L).shiftLeft(this.f52378g).subtract(BigInteger.valueOf(1L))).setBit(this.f52378g);
    }
}
