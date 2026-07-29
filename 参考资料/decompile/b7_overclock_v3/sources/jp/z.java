package jp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class z implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f36820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f36821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36826g;

    public z(org.bouncycastle.crypto.f fVar) {
        this.f36823d = fVar;
        int iC = fVar.c();
        this.f36825f = iC;
        this.f36820a = new byte[iC];
        this.f36821b = new byte[iC];
        this.f36822c = new byte[iC];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        this.f36826g = z10;
        reset();
        this.f36823d.a(true, kVar);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36823d.b() + "/OpenPGPCFB";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36823d.c();
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        return this.f36826g ? f(bArr, i10, bArr2, i11) : e(bArr, i10, bArr2, i11);
    }

    public final int e(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12;
        int i13;
        int i14;
        int i15 = this.f36825f;
        if (i10 + i15 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + i15 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i16 = this.f36824e;
        int i17 = 2;
        int i18 = 0;
        if (i16 > i15) {
            byte b10 = bArr[i10];
            this.f36821b[i15 - 2] = b10;
            bArr2[i11] = g(b10, i15 - 2);
            byte b11 = bArr[i10 + 1];
            byte[] bArr3 = this.f36821b;
            int i19 = this.f36825f;
            bArr3[i19 - 1] = b11;
            bArr2[i11 + 1] = g(b11, i19 - 1);
            this.f36823d.d(this.f36821b, 0, this.f36822c, 0);
            while (i17 < this.f36825f) {
                byte b12 = bArr[i10 + i17];
                int i20 = i17 - 2;
                this.f36821b[i20] = b12;
                bArr2[i11 + i17] = g(b12, i20);
                i17++;
            }
        } else {
            if (i16 == 0) {
                this.f36823d.d(this.f36821b, 0, this.f36822c, 0);
                while (true) {
                    i14 = this.f36825f;
                    if (i18 >= i14) {
                        break;
                    }
                    int i21 = i10 + i18;
                    this.f36821b[i18] = bArr[i21];
                    bArr2[i18] = g(bArr[i21], i18);
                    i18++;
                }
                i13 = this.f36824e + i14;
            } else if (i16 == i15) {
                this.f36823d.d(this.f36821b, 0, this.f36822c, 0);
                byte b13 = bArr[i10];
                byte b14 = bArr[i10 + 1];
                bArr2[i11] = g(b13, 0);
                bArr2[i11 + 1] = g(b14, 1);
                byte[] bArr4 = this.f36821b;
                System.arraycopy(bArr4, 2, bArr4, 0, this.f36825f - 2);
                byte[] bArr5 = this.f36821b;
                int i22 = this.f36825f;
                bArr5[i22 - 2] = b13;
                bArr5[i22 - 1] = b14;
                this.f36823d.d(bArr5, 0, this.f36822c, 0);
                while (true) {
                    i12 = this.f36825f;
                    if (i17 >= i12) {
                        break;
                    }
                    byte b15 = bArr[i10 + i17];
                    int i23 = i17 - 2;
                    this.f36821b[i23] = b15;
                    bArr2[i11 + i17] = g(b15, i23);
                    i17++;
                }
                i13 = this.f36824e + i12;
            }
            this.f36824e = i13;
        }
        return this.f36825f;
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12;
        int i13 = this.f36825f;
        if (i10 + i13 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + i13 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i14 = this.f36824e;
        int i15 = 2;
        int i16 = 0;
        if (i14 > i13) {
            byte[] bArr3 = this.f36821b;
            int i17 = i13 - 2;
            byte bG = g(bArr[i10], i13 - 2);
            bArr2[i11] = bG;
            bArr3[i17] = bG;
            byte[] bArr4 = this.f36821b;
            int i18 = this.f36825f;
            int i19 = i18 - 1;
            byte bG2 = g(bArr[i10 + 1], i18 - 1);
            bArr2[i11 + 1] = bG2;
            bArr4[i19] = bG2;
            this.f36823d.d(this.f36821b, 0, this.f36822c, 0);
            while (i15 < this.f36825f) {
                byte[] bArr5 = this.f36821b;
                int i20 = i15 - 2;
                byte bG3 = g(bArr[i10 + i15], i20);
                bArr2[i11 + i15] = bG3;
                bArr5[i20] = bG3;
                i15++;
            }
        } else {
            if (i14 != 0) {
                if (i14 == i13) {
                    this.f36823d.d(this.f36821b, 0, this.f36822c, 0);
                    bArr2[i11] = g(bArr[i10], 0);
                    bArr2[i11 + 1] = g(bArr[i10 + 1], 1);
                    byte[] bArr6 = this.f36821b;
                    System.arraycopy(bArr6, 2, bArr6, 0, this.f36825f - 2);
                    System.arraycopy(bArr2, i11, this.f36821b, this.f36825f - 2, 2);
                    this.f36823d.d(this.f36821b, 0, this.f36822c, 0);
                    while (true) {
                        i12 = this.f36825f;
                        if (i15 >= i12) {
                            break;
                        }
                        byte[] bArr7 = this.f36821b;
                        int i21 = i15 - 2;
                        byte bG4 = g(bArr[i10 + i15], i21);
                        bArr2[i11 + i15] = bG4;
                        bArr7[i21] = bG4;
                        i15++;
                    }
                }
            } else {
                this.f36823d.d(this.f36821b, 0, this.f36822c, 0);
                while (true) {
                    i12 = this.f36825f;
                    if (i16 >= i12) {
                        break;
                    }
                    byte[] bArr8 = this.f36821b;
                    byte bG5 = g(bArr[i10 + i16], i16);
                    bArr2[i11 + i16] = bG5;
                    bArr8[i16] = bG5;
                    i16++;
                }
            }
            this.f36824e += i12;
        }
        return this.f36825f;
    }

    public final byte g(byte b10, int i10) {
        return (byte) (b10 ^ this.f36822c[i10]);
    }

    public org.bouncycastle.crypto.f h() {
        return this.f36823d;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        this.f36824e = 0;
        byte[] bArr = this.f36820a;
        byte[] bArr2 = this.f36821b;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f36823d.reset();
    }
}
