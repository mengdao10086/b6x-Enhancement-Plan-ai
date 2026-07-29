package uo;

import java.math.BigInteger;
import np.g0;
import np.l0;
import np.m0;
import np.z1;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f52367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0 f52368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f52369c;

    public j(s sVar) {
        this.f52367a = sVar;
    }

    public static BigInteger e(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr2[i10] = bArr[(bArr.length - i10) - 1];
        }
        return new BigInteger(1, bArr2);
    }

    public byte[] a(org.bouncycastle.crypto.k kVar) {
        m0 m0Var = (m0) kVar;
        g0 g0VarD = this.f52368b.d();
        if (!g0VarD.equals(m0Var.d())) {
            throw new IllegalStateException("ECVKO public key has wrong domain parameters");
        }
        BigInteger bigIntegerMod = g0VarD.c().multiply(this.f52369c).multiply(this.f52368b.e()).mod(g0VarD.e());
        ir.i iVarA = ir.c.a(g0VarD.a(), m0Var.e());
        if (iVarA.v()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
        }
        ir.i iVarB = iVarA.z(bigIntegerMod).B();
        if (iVarB.v()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
        }
        return b(iVarB);
    }

    public final byte[] b(ir.i iVar) {
        BigInteger bigIntegerV = iVar.f().v();
        BigInteger bigIntegerV2 = iVar.g().v();
        int i10 = bigIntegerV.toByteArray().length > 33 ? 64 : 32;
        int i11 = i10 * 2;
        byte[] bArr = new byte[i11];
        byte[] bArrB = org.bouncycastle.util.b.b(i10, bigIntegerV);
        byte[] bArrB2 = org.bouncycastle.util.b.b(i10, bigIntegerV2);
        for (int i12 = 0; i12 != i10; i12++) {
            bArr[i12] = bArrB[(i10 - i12) - 1];
        }
        for (int i13 = 0; i13 != i10; i13++) {
            bArr[i10 + i13] = bArrB2[(i10 - i13) - 1];
        }
        this.f52367a.update(bArr, 0, i11);
        byte[] bArr2 = new byte[this.f52367a.h()];
        this.f52367a.c(bArr2, 0);
        return bArr2;
    }

    public int c() {
        return (this.f52368b.d().a().v() + 7) / 8;
    }

    public void d(org.bouncycastle.crypto.k kVar) {
        z1 z1Var = (z1) kVar;
        this.f52368b = (l0) z1Var.a();
        this.f52369c = e(z1Var.b());
    }
}
