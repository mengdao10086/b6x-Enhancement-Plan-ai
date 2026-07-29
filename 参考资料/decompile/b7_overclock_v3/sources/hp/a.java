package hp;

import ir.e;
import ir.h;
import ir.i;
import java.math.BigInteger;
import java.security.SecureRandom;
import np.g0;
import np.j0;
import np.l0;
import np.m0;
import np.m1;
import np.n1;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.q;
import org.bouncycastle.crypto.w;

/* JADX INFO: loaded from: classes5.dex */
public class a implements w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f31386g = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f31387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f31388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j0 f31389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f31390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f31391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f31392f;

    public a(q qVar, SecureRandom secureRandom) {
        this.f31387a = qVar;
        this.f31388b = secureRandom;
        this.f31390d = false;
        this.f31391e = false;
        this.f31392f = false;
    }

    public a(q qVar, SecureRandom secureRandom, boolean z10, boolean z11, boolean z12) {
        this.f31387a = qVar;
        this.f31388b = secureRandom;
        this.f31390d = z10;
        if (z10) {
            this.f31391e = false;
        } else {
            this.f31391e = z11;
        }
        this.f31392f = z12;
    }

    @Override // org.bouncycastle.crypto.w
    public void a(k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof j0)) {
            throw new IllegalArgumentException("EC key required");
        }
        this.f31389c = (j0) kVar;
    }

    @Override // org.bouncycastle.crypto.w
    public k b(byte[] bArr, int i10, int i11) throws IllegalArgumentException {
        j0 j0Var = this.f31389c;
        if (!(j0Var instanceof m0)) {
            throw new IllegalArgumentException("Public key required for encryption");
        }
        m0 m0Var = (m0) j0Var;
        g0 g0VarD = m0Var.d();
        e eVarA = g0VarD.a();
        BigInteger bigIntegerE = g0VarD.e();
        BigInteger bigIntegerC = g0VarD.c();
        BigInteger bigIntegerG = org.bouncycastle.util.b.g(f31386g, bigIntegerE, this.f31388b);
        i[] iVarArr = {d().a(g0VarD.b(), bigIntegerG), m0Var.e().z(this.f31391e ? bigIntegerG.multiply(bigIntegerC).mod(bigIntegerE) : bigIntegerG)};
        eVarA.C(iVarArr);
        i iVar = iVarArr[0];
        i iVar2 = iVarArr[1];
        byte[] bArrL = iVar.l(false);
        System.arraycopy(bArrL, 0, bArr, i10, bArrL.length);
        return f(i11, bArrL, iVar2.f().e());
    }

    @Override // org.bouncycastle.crypto.w
    public k c(byte[] bArr, int i10, int i11, int i12) throws IllegalArgumentException {
        j0 j0Var = this.f31389c;
        if (!(j0Var instanceof l0)) {
            throw new IllegalArgumentException("Private key required for encryption");
        }
        l0 l0Var = (l0) j0Var;
        g0 g0VarD = l0Var.d();
        e eVarA = g0VarD.a();
        BigInteger bigIntegerE = g0VarD.e();
        BigInteger bigIntegerC = g0VarD.c();
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        i iVarK = eVarA.k(bArr2);
        if (this.f31390d || this.f31391e) {
            iVarK = iVarK.z(bigIntegerC);
        }
        BigInteger bigIntegerE2 = l0Var.e();
        if (this.f31390d) {
            bigIntegerE2 = bigIntegerE2.multiply(g0VarD.d()).mod(bigIntegerE);
        }
        return f(i12, bArr2, iVarK.z(bigIntegerE2).B().f().e());
    }

    public h d() {
        return new ir.k();
    }

    public k e(byte[] bArr, int i10) {
        return c(bArr, 0, bArr.length, i10);
    }

    public n1 f(int i10, byte[] bArr, byte[] bArr2) {
        if (!this.f31392f) {
            byte[] bArrB = org.bouncycastle.util.a.B(bArr, bArr2);
            org.bouncycastle.util.a.d0(bArr2, (byte) 0);
            bArr2 = bArrB;
        }
        try {
            this.f31387a.a(new m1(bArr2, null));
            byte[] bArr3 = new byte[i10];
            this.f31387a.b(bArr3, 0, i10);
            return new n1(bArr3);
        } finally {
            org.bouncycastle.util.a.d0(bArr2, (byte) 0);
        }
    }

    public k g(byte[] bArr, int i10) {
        return b(bArr, 0, i10);
    }
}
