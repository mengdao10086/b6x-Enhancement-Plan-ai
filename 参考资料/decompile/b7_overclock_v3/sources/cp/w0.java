package cp;

import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class w0 implements org.bouncycastle.crypto.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.f f25720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public np.n1 f25721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f25725f = null;

    public w0(org.bouncycastle.crypto.f fVar) {
        byte[] bArr = {-90, 89, 89, -90};
        this.f25723d = bArr;
        this.f25724e = bArr;
        this.f25720a = fVar;
    }

    @Override // org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f25722c = z10;
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        if (kVar instanceof np.n1) {
            this.f25721b = (np.n1) kVar;
            this.f25724e = this.f25723d;
        } else if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            this.f25724e = v1Var.a();
            this.f25721b = (np.n1) v1Var.b();
            if (this.f25724e.length != 4) {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
        }
    }

    @Override // org.bouncycastle.crypto.l0
    public String b() {
        return this.f25720a.b();
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArrF;
        if (this.f25722c) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int i12 = i11 / 8;
        if (i12 * 8 != i11) {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        if (i12 <= 1) {
            throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        byte[] bArr3 = new byte[i11];
        if (i12 == 2) {
            this.f25720a.a(false, this.f25721b);
            int iC = 0;
            while (iC < i11) {
                this.f25720a.d(bArr2, iC, bArr3, iC);
                iC += this.f25720a.c();
            }
            byte[] bArr4 = new byte[8];
            this.f25725f = bArr4;
            System.arraycopy(bArr3, 0, bArr4, 0, bArr4.length);
            byte[] bArr5 = this.f25725f;
            int length = i11 - bArr5.length;
            bArrF = new byte[length];
            System.arraycopy(bArr3, bArr5.length, bArrF, 0, length);
        } else {
            bArrF = f(bArr, i10, i11);
        }
        int i13 = 4;
        byte[] bArr6 = new byte[4];
        byte[] bArr7 = new byte[4];
        System.arraycopy(this.f25725f, 0, bArr6, 0, 4);
        System.arraycopy(this.f25725f, 4, bArr7, 0, 4);
        int iA = org.bouncycastle.util.o.a(bArr7, 0);
        boolean zI = org.bouncycastle.util.a.I(bArr6, this.f25724e);
        int length2 = bArrF.length;
        if (iA <= length2 - 8) {
            zI = false;
        }
        if (iA > length2) {
            zI = false;
        }
        int i14 = length2 - iA;
        if (i14 >= 8 || i14 < 0) {
            zI = false;
        } else {
            i13 = i14;
        }
        byte[] bArr8 = new byte[i13];
        System.arraycopy(bArrF, bArrF.length - i13, bArr8, 0, i13);
        if (!org.bouncycastle.util.a.I(bArr8, new byte[i13])) {
            zI = false;
        }
        if (!zI) {
            throw new InvalidCipherTextException("checksum failed");
        }
        byte[] bArr9 = new byte[iA];
        System.arraycopy(bArrF, 0, bArr9, 0, iA);
        return bArr9;
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] d(byte[] bArr, int i10, int i11) {
        if (!this.f25722c) {
            throw new IllegalStateException("not set for wrapping");
        }
        byte[] bArr2 = new byte[8];
        byte[] bArrK = org.bouncycastle.util.o.k(i11);
        byte[] bArr3 = this.f25724e;
        int iC = 0;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArrK, 0, bArr2, this.f25724e.length, bArrK.length);
        byte[] bArr4 = new byte[i11];
        System.arraycopy(bArr, i10, bArr4, 0, i11);
        byte[] bArrE = e(bArr4);
        if (bArrE.length != 8) {
            v0 v0Var = new v0(this.f25720a);
            v0Var.a(true, new np.v1(this.f25721b, bArr2));
            return v0Var.d(bArrE, 0, bArrE.length);
        }
        int length = bArrE.length + 8;
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr2, 0, bArr5, 0, 8);
        System.arraycopy(bArrE, 0, bArr5, 8, bArrE.length);
        this.f25720a.a(true, this.f25721b);
        while (iC < length) {
            this.f25720a.d(bArr5, iC, bArr5, iC);
            iC += this.f25720a.c();
        }
        return bArr5;
    }

    public final byte[] e(byte[] bArr) {
        int length = bArr.length;
        int i10 = (8 - (length % 8)) % 8;
        byte[] bArr2 = new byte[length + i10];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        if (i10 != 0) {
            System.arraycopy(new byte[i10], 0, bArr2, length, i10);
        }
        return bArr2;
    }

    public final byte[] f(byte[] bArr, int i10, int i11) {
        int i12 = i11 - 8;
        byte[] bArr2 = new byte[i12];
        byte[] bArr3 = new byte[8];
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr, i10, bArr3, 0, 8);
        System.arraycopy(bArr, i10 + 8, bArr2, 0, i12);
        this.f25720a.a(false, this.f25721b);
        int i13 = (i11 / 8) - 1;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = i13; i15 >= 1; i15--) {
                System.arraycopy(bArr3, 0, bArr4, 0, 8);
                int i16 = (i15 - 1) * 8;
                System.arraycopy(bArr2, i16, bArr4, 8, 8);
                int i17 = (i13 * i14) + i15;
                int i18 = 1;
                while (i17 != 0) {
                    int i19 = 8 - i18;
                    bArr4[i19] = (byte) (((byte) i17) ^ bArr4[i19]);
                    i17 >>>= 8;
                    i18++;
                }
                this.f25720a.d(bArr4, 0, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr3, 0, 8);
                System.arraycopy(bArr4, 8, bArr2, i16, 8);
            }
        }
        this.f25725f = bArr3;
        return bArr2;
    }
}
