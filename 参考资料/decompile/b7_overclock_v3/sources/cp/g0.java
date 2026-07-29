package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class g0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25299b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25300c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25301d = 65537;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25302a = null;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            this.f25302a = h(z10, ((np.n1) kVar).a());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to IDEA init - " + kVar.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "IDEA";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = this.f25302a;
        if (iArr == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        }
        if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        i(iArr, bArr, i10, bArr2, i11);
        return 8;
    }

    public int e(int i10) {
        return (0 - i10) & 65535;
    }

    public final int f(byte[] bArr, int i10) {
        return ((bArr[i10] << 8) & 65280) + (bArr[i10 + 1] & 255);
    }

    public final int[] g(byte[] bArr) {
        int i10;
        int[] iArr = new int[52];
        int i11 = 0;
        if (bArr.length < 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        while (true) {
            if (i11 >= 8) {
                break;
            }
            iArr[i11] = f(bArr, i11 * 2);
            i11++;
        }
        for (i10 = 8; i10 < 52; i10++) {
            int i12 = i10 & 7;
            if (i12 < 6) {
                iArr[i10] = (((iArr[i10 - 7] & 127) << 9) | (iArr[i10 - 6] >> 7)) & 65535;
            } else if (i12 == 6) {
                iArr[i10] = (((iArr[i10 - 7] & 127) << 9) | (iArr[i10 - 14] >> 7)) & 65535;
            } else {
                iArr[i10] = (((iArr[i10 - 15] & 127) << 9) | (iArr[i10 - 14] >> 7)) & 65535;
            }
        }
        return iArr;
    }

    public final int[] h(boolean z10, byte[] bArr) {
        return z10 ? g(bArr) : j(g(bArr));
    }

    public final void i(int[] iArr, byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iF = f(bArr, i10);
        int iF2 = f(bArr, i10 + 2);
        int iF3 = f(bArr, i10 + 4);
        int iF4 = f(bArr, i10 + 6);
        int i12 = 0;
        int i13 = iF3;
        int i14 = iF2;
        int i15 = iF;
        int i16 = 0;
        while (i12 < 8) {
            int i17 = i16 + 1;
            int iK = k(i15, iArr[i16]);
            int i18 = i17 + 1;
            int i19 = (i14 + iArr[i17]) & 65535;
            int i20 = i18 + 1;
            int i21 = (i13 + iArr[i18]) & 65535;
            int i22 = i20 + 1;
            int iK2 = k(iF4, iArr[i20]);
            int i23 = i22 + 1;
            int iK3 = k(i21 ^ iK, iArr[i22]);
            int iK4 = k(((i19 ^ iK2) + iK3) & 65535, iArr[i23]);
            int i24 = (iK3 + iK4) & 65535;
            iF4 = iK2 ^ i24;
            i13 = i24 ^ i19;
            i12++;
            i14 = i21 ^ iK4;
            i15 = iK ^ iK4;
            i16 = i23 + 1;
        }
        int i25 = i16 + 1;
        m(k(i15, iArr[i16]), bArr2, i11);
        int i26 = i25 + 1;
        m(i13 + iArr[i25], bArr2, i11 + 2);
        m(i14 + iArr[i26], bArr2, i11 + 4);
        m(k(iF4, iArr[i26 + 1]), bArr2, i11 + 6);
    }

    public final int[] j(int[] iArr) {
        int[] iArr2 = new int[52];
        int iL = l(iArr[0]);
        int i10 = 1;
        int iE = e(iArr[1]);
        int iE2 = e(iArr[2]);
        iArr2[51] = l(iArr[3]);
        iArr2[50] = iE2;
        iArr2[49] = iE;
        int i11 = 48;
        iArr2[48] = iL;
        int i12 = 4;
        while (i10 < 8) {
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            int i15 = i13 + 1;
            int i16 = i11 - 1;
            iArr2[i16] = iArr[i13];
            int i17 = i16 - 1;
            iArr2[i17] = i14;
            int i18 = i15 + 1;
            int iL2 = l(iArr[i15]);
            int i19 = i18 + 1;
            int iE3 = e(iArr[i18]);
            int i20 = i19 + 1;
            int iE4 = e(iArr[i19]);
            int i21 = i17 - 1;
            iArr2[i21] = l(iArr[i20]);
            int i22 = i21 - 1;
            iArr2[i22] = iE3;
            int i23 = i22 - 1;
            iArr2[i23] = iE4;
            i11 = i23 - 1;
            iArr2[i11] = iL2;
            i10++;
            i12 = i20 + 1;
        }
        int i24 = i12 + 1;
        int i25 = iArr[i12];
        int i26 = i24 + 1;
        int i27 = i11 - 1;
        iArr2[i27] = iArr[i24];
        int i28 = i27 - 1;
        iArr2[i28] = i25;
        int i29 = i26 + 1;
        int iL3 = l(iArr[i26]);
        int i30 = i29 + 1;
        int iE5 = e(iArr[i29]);
        int i31 = i30 + 1;
        int iE6 = e(iArr[i30]);
        int i32 = i28 - 1;
        iArr2[i32] = l(iArr[i31]);
        int i33 = i32 - 1;
        iArr2[i33] = iE6;
        int i34 = i33 - 1;
        iArr2[i34] = iE5;
        iArr2[i34 - 1] = iL3;
        return iArr2;
    }

    public final int k(int i10, int i11) {
        int i12;
        if (i10 == 0) {
            i12 = f25301d - i11;
        } else if (i11 == 0) {
            i12 = f25301d - i10;
        } else {
            int i13 = i10 * i11;
            int i14 = i13 & 65535;
            int i15 = i13 >>> 16;
            i12 = (i14 - i15) + (i14 < i15 ? 1 : 0);
        }
        return i12 & 65535;
    }

    public final int l(int i10) {
        if (i10 < 2) {
            return i10;
        }
        int i11 = f25301d / i10;
        int i12 = f25301d % i10;
        int i13 = 1;
        while (i12 != 1) {
            int i14 = i10 / i12;
            i10 %= i12;
            i13 = (i13 + (i14 * i11)) & 65535;
            if (i10 == 1) {
                return i13;
            }
            int i15 = i12 / i10;
            i12 %= i10;
            i11 = (i11 + (i15 * i13)) & 65535;
        }
        return (1 - i11) & 65535;
    }

    public final void m(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >>> 8);
        bArr[i11 + 1] = (byte) i10;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
