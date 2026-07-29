package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class m implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25548g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25549h = 255;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f25550i = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f25551j = {pq.b.f46994k, -126, rc.a.f48412d0, -20, -77, rc.a.Z, i1.a.f31667o7, -27, -28, -123, 87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 69, 25, -91, rc.a.V, -19, 14, 79, 78, 29, 101, -110, -67, -122, -72, -81, -113, 124, -21, 31, i1.a.f31759z7, 62, jt.l.f36949q, -36, 95, 94, i1.a.f31699s7, 11, 26, -90, -31, 57, i1.a.f31732w7, -43, 71, 93, 61, i1.a.E7, 1, 90, -42, 81, 86, 108, 77, -117, 13, -102, 102, -5, -52, -80, rc.a.f48413e0, 116, 18, rc.a.f48411c0, 32, -16, -79, -124, -103, -33, 76, i1.a.f31741x7, i1.a.f31683q7, 52, 126, 118, 5, 109, -73, -87, 49, -47, 23, 4, -41, 20, o5.b.f42741j, 58, 97, -34, 27, 17, 28, 50, 15, -100, 22, 83, 24, -14, 34, -2, 68, i1.a.A7, -78, i1.a.f31691r7, -75, 122, -111, rc.a.W, 8, -24, -88, jt.l.f36952t, -4, 105, jt.l.f36951s, -86, -48, -96, 125, -95, -119, 98, -105, 84, 91, 30, -107, -32, -1, 100, -46, 16, -60, 0, 72, -93, -9, 117, -37, -118, 3, -26, i1.a.B7, 9, okio.w0.f44229a, -35, -108, -121, 92, -125, 2, i1.a.f31750y7, 74, -112, 51, 115, 103, -10, -13, -99, 127, -65, -30, 82, -101, i1.a.f31659n7, rc.a.Y, -56, 55, i1.a.f31707t7, 59, -127, -106, pq.b.f46991h, 75, 19, -66, 99, rc.a.f48414f0, -23, 121, -89, -116, -97, pq.b.f46992i, rp.u.f49086t, -114, rc.a.f48409a0, -11, -7, -74, 47, -3, -76, 89, tc.a.f51065w, -104, 6, 106, -25, 70, pq.b.f46993j, -70, -44, rc.a.X, -85, 66, -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, 64, 40, -45, 123, -69, i1.a.f31723v7, 67, i1.a.f31675p7, 21, -29, -83, -12, 119, i1.a.f31714u7, -128, -98};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f25554c = new int[96];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25555d = new int[8];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f25556e = new int[12];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f25557f = new int[4];

    public static void h(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 2;
        int i14 = i11 + 0;
        int i15 = i11 + 1;
        int i16 = 32 - i10;
        iArr2[i13] = (iArr[i14] << i10) | (iArr[i15] >>> i16);
        int i17 = i12 + 3;
        int i18 = i11 + 2;
        iArr2[i17] = (iArr[i15] << i10) | (iArr[i18] >>> i16);
        int i19 = i12 + 0;
        int i20 = i11 + 3;
        iArr2[i19] = (iArr[i18] << i10) | (iArr[i20] >>> i16);
        int i21 = i12 + 1;
        iArr2[i21] = (iArr[i20] << i10) | (iArr[i14] >>> i16);
        iArr[i14] = iArr2[i13];
        iArr[i15] = iArr2[i17];
        iArr[i18] = iArr2[i19];
        iArr[i20] = iArr2[i21];
    }

    public static void i(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 2;
        int i14 = i11 + 1;
        int i15 = i10 - 32;
        int i16 = i11 + 2;
        int i17 = 64 - i10;
        iArr2[i13] = (iArr[i14] << i15) | (iArr[i16] >>> i17);
        int i18 = i12 + 3;
        int i19 = i11 + 3;
        iArr2[i18] = (iArr[i16] << i15) | (iArr[i19] >>> i17);
        int i20 = i12 + 0;
        int i21 = i11 + 0;
        iArr2[i20] = (iArr[i19] << i15) | (iArr[i21] >>> i17);
        int i22 = i12 + 1;
        iArr2[i22] = (iArr[i14] >>> i17) | (iArr[i21] << i15);
        iArr[i21] = iArr2[i13];
        iArr[i14] = iArr2[i18];
        iArr[i16] = iArr2[i20];
        iArr[i19] = iArr2[i22];
    }

    public static int l(int i10, int i11) {
        return (i10 << i11) + (i10 >>> (32 - i11));
    }

    public static int o(int i10, int i11) {
        return (i10 >>> i11) + (i10 << (32 - i11));
    }

    public static void p(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 0;
        int i14 = i11 + 0;
        int i15 = i11 + 1;
        int i16 = 32 - i10;
        iArr2[i13] = (iArr[i14] << i10) | (iArr[i15] >>> i16);
        int i17 = i12 + 1;
        int i18 = i11 + 2;
        iArr2[i17] = (iArr[i15] << i10) | (iArr[i18] >>> i16);
        int i19 = i12 + 2;
        int i20 = i11 + 3;
        iArr2[i19] = (iArr[i18] << i10) | (iArr[i20] >>> i16);
        int i21 = i12 + 3;
        iArr2[i21] = (iArr[i20] << i10) | (iArr[i14] >>> i16);
        iArr[i14] = iArr2[i13];
        iArr[i15] = iArr2[i17];
        iArr[i18] = iArr2[i19];
        iArr[i20] = iArr2[i21];
    }

    public static void q(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 0;
        int i14 = i11 + 1;
        int i15 = i10 - 32;
        int i16 = i11 + 2;
        int i17 = 64 - i10;
        iArr2[i13] = (iArr[i14] << i15) | (iArr[i16] >>> i17);
        int i18 = i12 + 1;
        int i19 = i11 + 3;
        iArr2[i18] = (iArr[i16] << i15) | (iArr[i19] >>> i17);
        int i20 = i12 + 2;
        int i21 = i11 + 0;
        iArr2[i20] = (iArr[i19] << i15) | (iArr[i21] >>> i17);
        int i22 = i12 + 3;
        iArr2[i22] = (iArr[i14] >>> i17) | (iArr[i21] << i15);
        iArr[i21] = iArr2[i13];
        iArr[i14] = iArr2[i18];
        iArr[i16] = iArr2[i20];
        iArr[i19] = iArr2[i22];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("only simple KeyParameter expected.");
        }
        u(z10, ((np.n1) kVar).a());
        this.f25552a = true;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "Camellia";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException {
        if (!this.f25552a) {
            throw new IllegalStateException("Camellia is not initialized");
        }
        if (i10 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 16 <= bArr2.length) {
            return this.f25553b ? m(bArr, i10, bArr2, i11) : n(bArr, i10, bArr2, i11);
        }
        throw new OutputLengthException("output buffer too short");
    }

    public final int e(byte[] bArr, int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            i11 = (i11 << 8) + (bArr[i12 + i10] & 255);
        }
        return i11;
    }

    public final void f(int[] iArr, int[] iArr2, int i10) {
        int i11 = iArr[0] ^ iArr2[i10 + 0];
        int iT = t(i11 & 255) | (s((i11 >>> 8) & 255) << 8) | (r((i11 >>> 16) & 255) << 16);
        byte[] bArr = f25551j;
        int i12 = ((bArr[(i11 >>> 24) & 255] & 255) << 24) | iT;
        int i13 = iArr[1] ^ iArr2[i10 + 1];
        int iL = l((r((i13 >>> 24) & 255) << 24) | (bArr[i13 & 255] & 255) | (t((i13 >>> 8) & 255) << 8) | (s((i13 >>> 16) & 255) << 16), 8);
        int i14 = i12 ^ iL;
        int iL2 = l(iL, 8) ^ i14;
        int iO = o(i14, 8) ^ iL2;
        iArr[2] = (l(iL2, 16) ^ iO) ^ iArr[2];
        iArr[3] = l(iO, 8) ^ iArr[3];
        int i15 = iArr[2] ^ iArr2[i10 + 2];
        int iT2 = ((bArr[(i15 >>> 24) & 255] & 255) << 24) | t(i15 & 255) | (s((i15 >>> 8) & 255) << 8) | (r((i15 >>> 16) & 255) << 16);
        int i16 = iArr2[i10 + 3] ^ iArr[3];
        int iL3 = l((r((i16 >>> 24) & 255) << 24) | (bArr[i16 & 255] & 255) | (t((i16 >>> 8) & 255) << 8) | (s((i16 >>> 16) & 255) << 16), 8);
        int i17 = iT2 ^ iL3;
        int iL4 = l(iL3, 8) ^ i17;
        int iO2 = o(i17, 8) ^ iL4;
        iArr[0] = (l(iL4, 16) ^ iO2) ^ iArr[0];
        iArr[1] = iArr[1] ^ l(iO2, 8);
    }

    public final void g(int[] iArr, int[] iArr2, int i10) {
        iArr[1] = iArr[1] ^ l(iArr[0] & iArr2[i10 + 0], 1);
        iArr[0] = iArr[0] ^ (iArr2[i10 + 1] | iArr[1]);
        iArr[2] = iArr[2] ^ (iArr2[i10 + 3] | iArr[3]);
        iArr[3] = l(iArr2[i10 + 2] & iArr[2], 1) ^ iArr[3];
    }

    public final void j(int i10, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[(3 - i12) + i11] = (byte) i10;
            i10 >>>= 8;
        }
    }

    public final byte k(byte b10, int i10) {
        return (byte) (((b10 & 255) >>> (8 - i10)) | (b10 << i10));
    }

    public final int m(byte[] bArr, int i10, byte[] bArr2, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            this.f25557f[i12] = e(bArr, (i12 * 4) + i10);
            int[] iArr = this.f25557f;
            iArr[i12] = iArr[i12] ^ this.f25555d[i12];
        }
        f(this.f25557f, this.f25554c, 0);
        f(this.f25557f, this.f25554c, 4);
        f(this.f25557f, this.f25554c, 8);
        g(this.f25557f, this.f25556e, 0);
        f(this.f25557f, this.f25554c, 12);
        f(this.f25557f, this.f25554c, 16);
        f(this.f25557f, this.f25554c, 20);
        g(this.f25557f, this.f25556e, 4);
        f(this.f25557f, this.f25554c, 24);
        f(this.f25557f, this.f25554c, 28);
        f(this.f25557f, this.f25554c, 32);
        int[] iArr2 = this.f25557f;
        int i13 = iArr2[2];
        int[] iArr3 = this.f25555d;
        iArr2[2] = iArr3[4] ^ i13;
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        j(iArr2[2], bArr2, i11);
        j(this.f25557f[3], bArr2, i11 + 4);
        j(this.f25557f[0], bArr2, i11 + 8);
        j(this.f25557f[1], bArr2, i11 + 12);
        return 16;
    }

    public final int n(byte[] bArr, int i10, byte[] bArr2, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            this.f25557f[i12] = e(bArr, (i12 * 4) + i10);
            int[] iArr = this.f25557f;
            iArr[i12] = iArr[i12] ^ this.f25555d[i12];
        }
        f(this.f25557f, this.f25554c, 0);
        f(this.f25557f, this.f25554c, 4);
        f(this.f25557f, this.f25554c, 8);
        g(this.f25557f, this.f25556e, 0);
        f(this.f25557f, this.f25554c, 12);
        f(this.f25557f, this.f25554c, 16);
        f(this.f25557f, this.f25554c, 20);
        g(this.f25557f, this.f25556e, 4);
        f(this.f25557f, this.f25554c, 24);
        f(this.f25557f, this.f25554c, 28);
        f(this.f25557f, this.f25554c, 32);
        g(this.f25557f, this.f25556e, 8);
        f(this.f25557f, this.f25554c, 36);
        f(this.f25557f, this.f25554c, 40);
        f(this.f25557f, this.f25554c, 44);
        int[] iArr2 = this.f25557f;
        int i13 = iArr2[2];
        int[] iArr3 = this.f25555d;
        iArr2[2] = i13 ^ iArr3[4];
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        j(iArr2[2], bArr2, i11);
        j(this.f25557f[3], bArr2, i11 + 4);
        j(this.f25557f[0], bArr2, i11 + 8);
        j(this.f25557f[1], bArr2, i11 + 12);
        return 16;
    }

    public final int r(int i10) {
        return k(f25551j[i10], 1) & 255;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }

    public final int s(int i10) {
        return k(f25551j[i10], 7) & 255;
    }

    public final int t(int i10) {
        return f25551j[k((byte) i10, 1) & 255] & 255;
    }

    public final void u(boolean z10, byte[] bArr) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        int length = bArr.length;
        if (length != 16) {
            if (length == 24) {
                iArr[0] = e(bArr, 0);
                iArr[1] = e(bArr, 4);
                iArr[2] = e(bArr, 8);
                iArr[3] = e(bArr, 12);
                iArr[4] = e(bArr, 16);
                iArr[5] = e(bArr, 20);
                iArr[6] = ~iArr[4];
                iArr[7] = ~iArr[5];
            } else {
                if (length != 32) {
                    throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
                }
                iArr[0] = e(bArr, 0);
                iArr[1] = e(bArr, 4);
                iArr[2] = e(bArr, 8);
                iArr[3] = e(bArr, 12);
                iArr[4] = e(bArr, 16);
                iArr[5] = e(bArr, 20);
                iArr[6] = e(bArr, 24);
                iArr[7] = e(bArr, 28);
            }
            this.f25553b = false;
        } else {
            this.f25553b = true;
            iArr[0] = e(bArr, 0);
            iArr[1] = e(bArr, 4);
            iArr[2] = e(bArr, 8);
            iArr[3] = e(bArr, 12);
            iArr[7] = 0;
            iArr[6] = 0;
            iArr[5] = 0;
            iArr[4] = 0;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            iArr2[i10] = iArr[i10] ^ iArr[i10 + 4];
        }
        f(iArr2, f25550i, 0);
        for (int i11 = 0; i11 < 4; i11++) {
            iArr2[i11] = iArr2[i11] ^ iArr[i11];
        }
        f(iArr2, f25550i, 4);
        if (this.f25553b) {
            int[] iArr5 = this.f25555d;
            if (z10) {
                iArr5[0] = iArr[0];
                iArr5[1] = iArr[1];
                iArr5[2] = iArr[2];
                iArr5[3] = iArr[3];
                p(15, iArr, 0, this.f25554c, 4);
                p(30, iArr, 0, this.f25554c, 12);
                p(15, iArr, 0, iArr4, 0);
                int[] iArr6 = this.f25554c;
                iArr6[18] = iArr4[2];
                iArr6[19] = iArr4[3];
                p(17, iArr, 0, this.f25556e, 4);
                p(17, iArr, 0, this.f25554c, 24);
                p(17, iArr, 0, this.f25554c, 32);
                int[] iArr7 = this.f25554c;
                iArr7[0] = iArr2[0];
                iArr7[1] = iArr2[1];
                iArr7[2] = iArr2[2];
                iArr7[3] = iArr2[3];
                p(15, iArr2, 0, iArr7, 8);
                p(15, iArr2, 0, this.f25556e, 0);
                p(15, iArr2, 0, iArr4, 0);
                int[] iArr8 = this.f25554c;
                iArr8[16] = iArr4[0];
                iArr8[17] = iArr4[1];
                p(15, iArr2, 0, iArr8, 20);
                q(34, iArr2, 0, this.f25554c, 28);
                p(17, iArr2, 0, this.f25555d, 4);
                return;
            }
            iArr5[4] = iArr[0];
            iArr5[5] = iArr[1];
            iArr5[6] = iArr[2];
            iArr5[7] = iArr[3];
            h(15, iArr, 0, this.f25554c, 28);
            h(30, iArr, 0, this.f25554c, 20);
            h(15, iArr, 0, iArr4, 0);
            int[] iArr9 = this.f25554c;
            iArr9[16] = iArr4[0];
            iArr9[17] = iArr4[1];
            h(17, iArr, 0, this.f25556e, 0);
            h(17, iArr, 0, this.f25554c, 8);
            h(17, iArr, 0, this.f25554c, 0);
            int[] iArr10 = this.f25554c;
            iArr10[34] = iArr2[0];
            iArr10[35] = iArr2[1];
            iArr10[32] = iArr2[2];
            iArr10[33] = iArr2[3];
            h(15, iArr2, 0, iArr10, 24);
            h(15, iArr2, 0, this.f25556e, 4);
            h(15, iArr2, 0, iArr4, 0);
            int[] iArr11 = this.f25554c;
            iArr11[18] = iArr4[2];
            iArr11[19] = iArr4[3];
            h(15, iArr2, 0, iArr11, 12);
            i(34, iArr2, 0, this.f25554c, 4);
            p(17, iArr2, 0, this.f25555d, 0);
            return;
        }
        for (int i12 = 0; i12 < 4; i12++) {
            iArr3[i12] = iArr2[i12] ^ iArr[i12 + 4];
        }
        f(iArr3, f25550i, 8);
        int[] iArr12 = this.f25555d;
        if (z10) {
            iArr12[0] = iArr[0];
            iArr12[1] = iArr[1];
            iArr12[2] = iArr[2];
            iArr12[3] = iArr[3];
            q(45, iArr, 0, this.f25554c, 16);
            p(15, iArr, 0, this.f25556e, 4);
            p(17, iArr, 0, this.f25554c, 32);
            q(34, iArr, 0, this.f25554c, 44);
            p(15, iArr, 4, this.f25554c, 4);
            p(15, iArr, 4, this.f25556e, 0);
            p(30, iArr, 4, this.f25554c, 24);
            q(34, iArr, 4, this.f25554c, 36);
            p(15, iArr2, 0, this.f25554c, 8);
            p(30, iArr2, 0, this.f25554c, 20);
            int[] iArr13 = this.f25556e;
            iArr13[8] = iArr2[1];
            iArr13[9] = iArr2[2];
            iArr13[10] = iArr2[3];
            iArr13[11] = iArr2[0];
            q(49, iArr2, 0, this.f25554c, 40);
            int[] iArr14 = this.f25554c;
            iArr14[0] = iArr3[0];
            iArr14[1] = iArr3[1];
            iArr14[2] = iArr3[2];
            iArr14[3] = iArr3[3];
            p(30, iArr3, 0, iArr14, 12);
            p(30, iArr3, 0, this.f25554c, 28);
            q(51, iArr3, 0, this.f25555d, 4);
            return;
        }
        iArr12[4] = iArr[0];
        iArr12[5] = iArr[1];
        iArr12[6] = iArr[2];
        iArr12[7] = iArr[3];
        i(45, iArr, 0, this.f25554c, 28);
        h(15, iArr, 0, this.f25556e, 4);
        h(17, iArr, 0, this.f25554c, 12);
        i(34, iArr, 0, this.f25554c, 0);
        h(15, iArr, 4, this.f25554c, 40);
        h(15, iArr, 4, this.f25556e, 8);
        h(30, iArr, 4, this.f25554c, 20);
        i(34, iArr, 4, this.f25554c, 8);
        h(15, iArr2, 0, this.f25554c, 36);
        h(30, iArr2, 0, this.f25554c, 24);
        int[] iArr15 = this.f25556e;
        iArr15[2] = iArr2[1];
        iArr15[3] = iArr2[2];
        iArr15[0] = iArr2[3];
        iArr15[1] = iArr2[0];
        i(49, iArr2, 0, this.f25554c, 4);
        int[] iArr16 = this.f25554c;
        iArr16[46] = iArr3[0];
        iArr16[47] = iArr3[1];
        iArr16[44] = iArr3[2];
        iArr16[45] = iArr3[3];
        h(30, iArr3, 0, iArr16, 32);
        h(30, iArr3, 0, this.f25554c, 16);
        q(51, iArr3, 0, this.f25555d, 0);
    }
}
