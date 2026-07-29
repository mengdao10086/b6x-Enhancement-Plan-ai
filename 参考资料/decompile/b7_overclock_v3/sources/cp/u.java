package cp;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class u implements org.bouncycastle.crypto.l0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f25672h = {74, -35, -94, rc.a.f48412d0, 121, -24, rc.a.V, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jp.c f25673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public np.n1 f25674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public np.v1 f25675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public org.bouncycastle.crypto.s f25678f = org.bouncycastle.crypto.util.f.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f25679g = new byte[20];

    public static byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = i10 + 1;
            bArr2[i10] = bArr[bArr.length - i11];
            i10 = i11;
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        SecureRandom secureRandomF;
        this.f25677e = z10;
        this.f25673a = new jp.c(new t());
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            org.bouncycastle.crypto.k kVarA = w1Var.a();
            SecureRandom secureRandomB = w1Var.b();
            kVar = kVarA;
            secureRandomF = secureRandomB;
        } else {
            secureRandomF = org.bouncycastle.crypto.n.f();
        }
        if (kVar instanceof np.n1) {
            this.f25674b = (np.n1) kVar;
            if (this.f25677e) {
                byte[] bArr = new byte[8];
                this.f25676d = bArr;
                secureRandomF.nextBytes(bArr);
                this.f25675c = new np.v1(this.f25674b, this.f25676d);
                return;
            }
            return;
        }
        if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            this.f25675c = v1Var;
            this.f25676d = v1Var.a();
            this.f25674b = (np.n1) this.f25675c.b();
            if (!this.f25677e) {
                throw new IllegalArgumentException("You should not supply an IV for unwrapping");
            }
            byte[] bArr2 = this.f25676d;
            if (bArr2 == null || bArr2.length != 8) {
                throw new IllegalArgumentException("IV is not 8 octets");
            }
        }
    }

    @Override // org.bouncycastle.crypto.l0
    public String b() {
        return "DESede";
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25677e) {
            throw new IllegalStateException("Not set for unwrapping");
        }
        if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
        int iC = this.f25673a.c();
        if (i11 % iC != 0) {
            throw new InvalidCipherTextException("Ciphertext not multiple of " + iC);
        }
        this.f25673a.a(false, new np.v1(this.f25674b, f25672h));
        byte[] bArr2 = new byte[i11];
        for (int i12 = 0; i12 != i11; i12 += iC) {
            this.f25673a.d(bArr, i10 + i12, bArr2, i12);
        }
        byte[] bArrG = g(bArr2);
        byte[] bArr3 = new byte[8];
        this.f25676d = bArr3;
        int length = bArrG.length - 8;
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArrG, 0, bArr3, 0, 8);
        System.arraycopy(bArrG, 8, bArr4, 0, bArrG.length - 8);
        np.v1 v1Var = new np.v1(this.f25674b, this.f25676d);
        this.f25675c = v1Var;
        this.f25673a.a(false, v1Var);
        byte[] bArr5 = new byte[length];
        for (int i13 = 0; i13 != length; i13 += iC) {
            this.f25673a.d(bArr4, i13, bArr5, i13);
        }
        int i14 = length - 8;
        byte[] bArr6 = new byte[i14];
        byte[] bArr7 = new byte[8];
        System.arraycopy(bArr5, 0, bArr6, 0, i14);
        System.arraycopy(bArr5, i14, bArr7, 0, 8);
        if (f(bArr6, bArr7)) {
            return bArr6;
        }
        throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] d(byte[] bArr, int i10, int i11) {
        if (!this.f25677e) {
            throw new IllegalStateException("Not initialized for wrapping");
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        byte[] bArrE = e(bArr2);
        int length = bArrE.length + i11;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, 0, bArr3, 0, i11);
        System.arraycopy(bArrE, 0, bArr3, i11, bArrE.length);
        int iC = this.f25673a.c();
        if (length % iC != 0) {
            throw new IllegalStateException("Not multiple of block length");
        }
        this.f25673a.a(true, this.f25675c);
        byte[] bArr4 = new byte[length];
        for (int i12 = 0; i12 != length; i12 += iC) {
            this.f25673a.d(bArr3, i12, bArr4, i12);
        }
        byte[] bArr5 = this.f25676d;
        byte[] bArr6 = new byte[bArr5.length + length];
        System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
        System.arraycopy(bArr4, 0, bArr6, this.f25676d.length, length);
        byte[] bArrG = g(bArr6);
        this.f25673a.a(true, new np.v1(this.f25674b, f25672h));
        for (int i13 = 0; i13 != bArrG.length; i13 += iC) {
            this.f25673a.d(bArrG, i13, bArrG, i13);
        }
        return bArrG;
    }

    public final byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.f25678f.update(bArr, 0, bArr.length);
        this.f25678f.c(this.f25679g, 0);
        System.arraycopy(this.f25679g, 0, bArr2, 0, 8);
        return bArr2;
    }

    public final boolean f(byte[] bArr, byte[] bArr2) {
        return org.bouncycastle.util.a.I(e(bArr), bArr2);
    }
}
