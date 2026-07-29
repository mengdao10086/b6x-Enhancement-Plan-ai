package cp;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class p0 implements org.bouncycastle.crypto.l0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f25596i = {74, -35, -94, rc.a.f48412d0, 121, -24, rc.a.V, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jp.c f25597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.k f25598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public np.v1 f25599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SecureRandom f25602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.s f25603g = org.bouncycastle.crypto.util.f.c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f25604h = new byte[20];

    @Override // org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f25601e = z10;
        this.f25597a = new jp.c(new o0());
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f25602f = w1Var.b();
            kVar = w1Var.a();
        } else {
            this.f25602f = org.bouncycastle.crypto.n.f();
        }
        if (!(kVar instanceof np.v1)) {
            this.f25598b = kVar;
            if (this.f25601e) {
                byte[] bArr = new byte[8];
                this.f25600d = bArr;
                this.f25602f.nextBytes(bArr);
                this.f25599c = new np.v1(this.f25598b, this.f25600d);
                return;
            }
            return;
        }
        np.v1 v1Var = (np.v1) kVar;
        this.f25599c = v1Var;
        this.f25600d = v1Var.a();
        this.f25598b = this.f25599c.b();
        if (!this.f25601e) {
            throw new IllegalArgumentException("You should not supply an IV for unwrapping");
        }
        byte[] bArr2 = this.f25600d;
        if (bArr2 == null || bArr2.length != 8) {
            throw new IllegalArgumentException("IV is not 8 octets");
        }
    }

    @Override // org.bouncycastle.crypto.l0
    public String b() {
        return "RC2";
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25601e) {
            throw new IllegalStateException("Not set for unwrapping");
        }
        if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
        if (i11 % this.f25597a.c() != 0) {
            throw new InvalidCipherTextException("Ciphertext not multiple of " + this.f25597a.c());
        }
        this.f25597a.a(false, new np.v1(this.f25598b, f25596i));
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        for (int i12 = 0; i12 < i11 / this.f25597a.c(); i12++) {
            int iC = this.f25597a.c() * i12;
            this.f25597a.d(bArr2, iC, bArr2, iC);
        }
        byte[] bArr3 = new byte[i11];
        int i13 = 0;
        while (i13 < i11) {
            int i14 = i13 + 1;
            bArr3[i13] = bArr2[i11 - i14];
            i13 = i14;
        }
        byte[] bArr4 = new byte[8];
        this.f25600d = bArr4;
        int i15 = i11 - 8;
        byte[] bArr5 = new byte[i15];
        System.arraycopy(bArr3, 0, bArr4, 0, 8);
        System.arraycopy(bArr3, 8, bArr5, 0, i15);
        np.v1 v1Var = new np.v1(this.f25598b, this.f25600d);
        this.f25599c = v1Var;
        this.f25597a.a(false, v1Var);
        byte[] bArr6 = new byte[i15];
        System.arraycopy(bArr5, 0, bArr6, 0, i15);
        for (int i16 = 0; i16 < i15 / this.f25597a.c(); i16++) {
            int iC2 = this.f25597a.c() * i16;
            this.f25597a.d(bArr6, iC2, bArr6, iC2);
        }
        int i17 = i15 - 8;
        byte[] bArr7 = new byte[i17];
        byte[] bArr8 = new byte[8];
        System.arraycopy(bArr6, 0, bArr7, 0, i17);
        System.arraycopy(bArr6, i17, bArr8, 0, 8);
        if (!f(bArr7, bArr8)) {
            throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
        }
        if (i17 - ((bArr7[0] & 255) + 1) <= 7) {
            int i18 = bArr7[0];
            byte[] bArr9 = new byte[i18];
            System.arraycopy(bArr7, 1, bArr9, 0, i18);
            return bArr9;
        }
        throw new InvalidCipherTextException("too many pad bytes (" + (i17 - ((bArr7[0] & 255) + 1)) + ee.a.f26979d);
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] d(byte[] bArr, int i10, int i11) {
        if (!this.f25601e) {
            throw new IllegalStateException("Not initialized for wrapping");
        }
        int i12 = i11 + 1;
        int i13 = i12 % 8;
        int i14 = i13 != 0 ? (8 - i13) + i12 : i12;
        byte[] bArr2 = new byte[i14];
        bArr2[0] = (byte) i11;
        System.arraycopy(bArr, i10, bArr2, 1, i11);
        int i15 = (i14 - i11) - 1;
        byte[] bArr3 = new byte[i15];
        if (i15 > 0) {
            this.f25602f.nextBytes(bArr3);
            System.arraycopy(bArr3, 0, bArr2, i12, i15);
        }
        byte[] bArrE = e(bArr2);
        int length = bArrE.length + i14;
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr2, 0, bArr4, 0, i14);
        System.arraycopy(bArrE, 0, bArr4, i14, bArrE.length);
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr4, 0, bArr5, 0, length);
        int iC = length / this.f25597a.c();
        if (length % this.f25597a.c() != 0) {
            throw new IllegalStateException("Not multiple of block length");
        }
        this.f25597a.a(true, this.f25599c);
        for (int i16 = 0; i16 < iC; i16++) {
            int iC2 = this.f25597a.c() * i16;
            this.f25597a.d(bArr5, iC2, bArr5, iC2);
        }
        byte[] bArr6 = this.f25600d;
        int length2 = bArr6.length + length;
        byte[] bArr7 = new byte[length2];
        System.arraycopy(bArr6, 0, bArr7, 0, bArr6.length);
        System.arraycopy(bArr5, 0, bArr7, this.f25600d.length, length);
        byte[] bArr8 = new byte[length2];
        int i17 = 0;
        while (i17 < length2) {
            int i18 = i17 + 1;
            bArr8[i17] = bArr7[length2 - i18];
            i17 = i18;
        }
        this.f25597a.a(true, new np.v1(this.f25598b, f25596i));
        for (int i19 = 0; i19 < iC + 1; i19++) {
            int iC3 = this.f25597a.c() * i19;
            this.f25597a.d(bArr8, iC3, bArr8, iC3);
        }
        return bArr8;
    }

    public final byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.f25603g.update(bArr, 0, bArr.length);
        this.f25603g.c(this.f25604h, 0);
        System.arraycopy(this.f25604h, 0, bArr2, 0, 8);
        return bArr2;
    }

    public final boolean f(byte[] bArr, byte[] bArr2) {
        return org.bouncycastle.util.a.I(e(bArr), bArr2);
    }
}
