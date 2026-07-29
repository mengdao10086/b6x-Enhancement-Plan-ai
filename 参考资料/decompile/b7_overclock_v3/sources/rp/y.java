package rp;

import java.math.BigInteger;
import np.g0;
import np.j0;
import np.l0;
import np.m0;
import np.u1;
import np.w1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.e0;
import zo.k0;

/* JADX INFO: loaded from: classes5.dex */
public class y implements e0, ir.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f49109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f49110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f49111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g0 f49112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ir.i f49113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public j0 f49114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f49115m;

    public y() {
        this(z.f49116a, new k0());
    }

    public y(org.bouncycastle.crypto.s sVar) {
        this(z.f49116a, sVar);
    }

    public y(b bVar) {
        this.f49109g = new x();
        this.f49111i = bVar;
        this.f49110h = new k0();
    }

    public y(b bVar, org.bouncycastle.crypto.s sVar) {
        this.f49109g = new x();
        this.f49111i = bVar;
        this.f49110h = sVar;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        byte[] bArrD;
        ir.i iVarE;
        if (kVar instanceof u1) {
            u1 u1Var = (u1) kVar;
            org.bouncycastle.crypto.k kVarB = u1Var.b();
            byte[] bArrA = u1Var.a();
            if (bArrA.length >= 8192) {
                throw new IllegalArgumentException("SM2 user ID must be less than 2^16 bits long");
            }
            bArrD = bArrA;
            kVar = kVarB;
        } else {
            bArrD = jt.h.d("31323334353637383132333435363738");
        }
        if (z10) {
            if (kVar instanceof w1) {
                w1 w1Var = (w1) kVar;
                j0 j0Var = (j0) w1Var.a();
                this.f49114l = j0Var;
                g0 g0VarD = j0Var.d();
                this.f49112j = g0VarD;
                this.f49109g.c(g0VarD.e(), w1Var.b());
            } else {
                j0 j0Var2 = (j0) kVar;
                this.f49114l = j0Var2;
                g0 g0VarD2 = j0Var2.d();
                this.f49112j = g0VarD2;
                this.f49109g.c(g0VarD2.e(), org.bouncycastle.crypto.n.f());
            }
            iVarE = j().a(this.f49112j.b(), ((l0) this.f49114l).e()).B();
        } else {
            j0 j0Var3 = (j0) kVar;
            this.f49114l = j0Var3;
            this.f49112j = j0Var3.d();
            iVarE = ((m0) this.f49114l).e();
        }
        this.f49113k = iVarE;
        byte[] bArrL = l(bArrD);
        this.f49115m = bArrL;
        this.f49110h.update(bArrL, 0, bArrL.length);
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        try {
            BigInteger[] bigIntegerArrA = this.f49111i.a(this.f49112j.e(), bArr);
            return m(bigIntegerArrA[0], bigIntegerArrA[1]);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() throws CryptoException {
        byte[] bArrK = k();
        BigInteger bigIntegerE = this.f49112j.e();
        BigInteger bigIntegerI = i(bigIntegerE, bArrK);
        BigInteger bigIntegerE2 = ((l0) this.f49114l).e();
        ir.h hVarJ = j();
        while (true) {
            BigInteger bigIntegerA = this.f49109g.a();
            BigInteger bigIntegerMod = bigIntegerI.add(hVarJ.a(this.f49112j.b(), bigIntegerA).B().f().v()).mod(bigIntegerE);
            BigInteger bigInteger = ir.d.f35646a;
            if (!bigIntegerMod.equals(bigInteger) && !bigIntegerMod.add(bigIntegerA).equals(bigIntegerE)) {
                BigInteger bigIntegerMod2 = org.bouncycastle.util.b.n(bigIntegerE, bigIntegerE2.add(ir.d.f35647b)).multiply(bigIntegerA.subtract(bigIntegerMod.multiply(bigIntegerE2)).mod(bigIntegerE)).mod(bigIntegerE);
                if (!bigIntegerMod2.equals(bigInteger)) {
                    try {
                        return this.f49111i.b(this.f49112j.e(), bigIntegerMod, bigIntegerMod2);
                    } catch (Exception e10) {
                        throw new CryptoException("unable to encode signature: " + e10.getMessage(), e10);
                    }
                }
            }
        }
    }

    public final void g(org.bouncycastle.crypto.s sVar, ir.f fVar) {
        byte[] bArrE = fVar.e();
        sVar.update(bArrE, 0, bArrE.length);
    }

    public final void h(org.bouncycastle.crypto.s sVar, byte[] bArr) {
        int length = bArr.length * 8;
        sVar.update((byte) ((length >> 8) & 255));
        sVar.update((byte) (length & 255));
        sVar.update(bArr, 0, bArr.length);
    }

    public BigInteger i(BigInteger bigInteger, byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public ir.h j() {
        return new ir.k();
    }

    public final byte[] k() {
        byte[] bArr = new byte[this.f49110h.h()];
        this.f49110h.c(bArr, 0);
        reset();
        return bArr;
    }

    public final byte[] l(byte[] bArr) {
        this.f49110h.reset();
        h(this.f49110h, bArr);
        g(this.f49110h, this.f49112j.a().o());
        g(this.f49110h, this.f49112j.a().q());
        g(this.f49110h, this.f49112j.b().f());
        g(this.f49110h, this.f49112j.b().g());
        g(this.f49110h, this.f49113k.f());
        g(this.f49110h, this.f49113k.g());
        byte[] bArr2 = new byte[this.f49110h.h()];
        this.f49110h.c(bArr2, 0);
        return bArr2;
    }

    public final boolean m(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerE = this.f49112j.e();
        BigInteger bigInteger3 = ir.d.f35647b;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(bigIntegerE) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(bigIntegerE) >= 0) {
            return false;
        }
        BigInteger bigIntegerI = i(bigIntegerE, k());
        BigInteger bigIntegerMod = bigInteger.add(bigInteger2).mod(bigIntegerE);
        if (bigIntegerMod.equals(ir.d.f35646a)) {
            return false;
        }
        ir.i iVarB = ir.c.v(this.f49112j.b(), bigInteger2, ((m0) this.f49114l).e(), bigIntegerMod).B();
        if (iVarB.v()) {
            return false;
        }
        return bigIntegerI.add(iVarB.f().v()).mod(bigIntegerE).equals(bigInteger);
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49110h.reset();
        byte[] bArr = this.f49115m;
        if (bArr != null) {
            this.f49110h.update(bArr, 0, bArr.length);
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49110h.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49110h.update(bArr, i10, i11);
    }
}
