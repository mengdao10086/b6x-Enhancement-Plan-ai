package cp;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class u0 implements org.bouncycastle.crypto.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jp.c f25680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public np.v1 f25681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f25683d;

    public u0(org.bouncycastle.crypto.f fVar) {
        this.f25680a = new jp.c(fVar);
    }

    @Override // org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f25682c = z10;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f25683d = w1Var.b();
            if (!(w1Var.a() instanceof np.v1)) {
                throw new IllegalArgumentException("RFC3211Wrap requires an IV");
            }
            this.f25681b = (np.v1) w1Var.a();
            return;
        }
        if (z10) {
            this.f25683d = org.bouncycastle.crypto.n.f();
        }
        if (!(kVar instanceof np.v1)) {
            throw new IllegalArgumentException("RFC3211Wrap requires an IV");
        }
        this.f25681b = (np.v1) kVar;
    }

    @Override // org.bouncycastle.crypto.l0
    public String b() {
        return this.f25680a.g().b() + "/RFC3211Wrap";
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25682c) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int iC = this.f25680a.c();
        if (i11 < iC * 2) {
            throw new InvalidCipherTextException("input too short");
        }
        byte[] bArr2 = new byte[i11];
        byte[] bArr3 = new byte[iC];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        System.arraycopy(bArr, i10, bArr3, 0, iC);
        this.f25680a.a(false, new np.v1(this.f25681b.b(), bArr3));
        for (int i12 = iC; i12 < i11; i12 += iC) {
            this.f25680a.d(bArr2, i12, bArr2, i12);
        }
        System.arraycopy(bArr2, i11 - iC, bArr3, 0, iC);
        this.f25680a.a(false, new np.v1(this.f25681b.b(), bArr3));
        this.f25680a.d(bArr2, 0, bArr2, 0);
        this.f25680a.a(false, this.f25681b);
        for (int i13 = 0; i13 < i11; i13 += iC) {
            this.f25680a.d(bArr2, i13, bArr2, i13);
        }
        int i14 = i11 - 4;
        boolean z10 = (bArr2[0] & 255) > i14;
        if (!z10) {
            i14 = bArr2[0] & 255;
        }
        byte[] bArr4 = new byte[i14];
        System.arraycopy(bArr2, 4, bArr4, 0, bArr4.length);
        int i15 = 0;
        int i16 = 0;
        while (i15 != 3) {
            int i17 = i15 + 1;
            i16 |= bArr2[i15 + 4] ^ ((byte) (~bArr2[i17]));
            i15 = i17;
        }
        org.bouncycastle.util.a.n(bArr2);
        if (!z10 && !(i16 != 0)) {
            return bArr4;
        }
        throw new InvalidCipherTextException("wrapped key corrupted");
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] d(byte[] bArr, int i10, int i11) {
        if (!this.f25682c) {
            throw new IllegalStateException("not set for wrapping");
        }
        if (i11 > 255 || i11 < 0) {
            throw new IllegalArgumentException("input must be from 0 to 255 bytes");
        }
        this.f25680a.a(true, this.f25681b);
        int iC = this.f25680a.c();
        int i12 = i11 + 4;
        int i13 = iC * 2;
        if (i12 >= i13) {
            i13 = i12 % iC == 0 ? i12 : ((i12 / iC) + 1) * iC;
        }
        byte[] bArr2 = new byte[i13];
        bArr2[0] = (byte) i11;
        System.arraycopy(bArr, i10, bArr2, 4, i11);
        int length = bArr2.length - i12;
        byte[] bArr3 = new byte[length];
        this.f25683d.nextBytes(bArr3);
        System.arraycopy(bArr3, 0, bArr2, i12, length);
        bArr2[1] = (byte) (~bArr2[4]);
        bArr2[2] = (byte) (~bArr2[5]);
        bArr2[3] = (byte) (~bArr2[6]);
        for (int i14 = 0; i14 < bArr2.length; i14 += iC) {
            this.f25680a.d(bArr2, i14, bArr2, i14);
        }
        for (int i15 = 0; i15 < bArr2.length; i15 += iC) {
            this.f25680a.d(bArr2, i15, bArr2, i15);
        }
        return bArr2;
    }
}
