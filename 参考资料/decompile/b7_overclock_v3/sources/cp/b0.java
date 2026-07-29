package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class b0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f25188g = {-4, -18, -35, 17, i1.a.A7, pq.b.f46992i, 49, 22, -5, -60, -6, i1.a.B7, 35, i1.a.f31699s7, 4, 77, -23, 119, -16, -37, -109, rc.a.f48414f0, -103, -70, 23, 54, -15, -69, 20, i1.a.f31750y7, 95, i1.a.f31675p7, -7, 24, 101, 90, -30, 92, -17, rc.a.V, -127, 28, 60, 66, -117, 1, -114, 79, 5, -124, 2, -82, -29, 106, -113, -96, 6, 11, -19, -104, 127, -44, -45, 31, -21, 52, rc.a.f48412d0, 81, -22, -56, 72, -85, -14, 42, 104, -94, -3, 58, i1.a.f31759z7, -52, -75, pq.b.f46994k, 14, 86, 8, 12, 118, 18, -65, 114, 19, 71, -100, -73, 93, -121, 21, -95, -106, rc.a.f48409a0, 16, 123, -102, i1.a.f31714u7, -13, -111, tc.a.f51065w, pq.b.f46991h, -99, -98, -78, -79, 50, 117, 25, 61, -1, 53, -118, 126, 109, 84, i1.a.f31707t7, -128, i1.a.f31691r7, -67, 13, 87, -33, -11, rc.a.W, -87, 62, -88, 67, i1.a.f31723v7, -41, 121, -42, -10, 124, 34, -71, 3, -32, 15, -20, -34, 122, -108, -80, rp.u.f49086t, -36, -24, 40, jt.l.f36951s, 78, 51, 10, 74, -89, -105, jt.l.f36952t, 115, 30, 0, 98, 68, 26, -72, 56, -126, 100, -97, rc.a.Y, 65, -83, 69, 70, -110, rc.a.Z, 94, 85, 47, -116, -93, -91, 125, 105, -43, -107, 59, 7, o5.b.f42741j, -77, 64, -122, -84, 29, -9, jt.l.f36949q, 55, 107, -28, -120, i1.a.E7, -25, -119, -31, 27, -125, 73, 76, okio.w0.f44229a, -8, -2, -115, 83, -86, -112, i1.a.f31732w7, i1.a.f31659n7, -123, 97, 32, pq.b.f46993j, 103, -92, rc.a.f48413e0, rc.a.f48411c0, 9, 91, i1.a.f31741x7, -101, rc.a.X, -48, -66, -27, 108, 82, 89, -90, 116, -46, -26, -12, -76, i1.a.f31667o7, -47, 102, -81, i1.a.f31683q7, 57, 75, 99, -74};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f25189h = {-91, rc.a.f48413e0, 50, -113, 14, jt.l.f36949q, 56, i1.a.f31667o7, 84, -26, -98, 57, 85, 126, 82, -111, 100, 3, 87, 90, 28, jt.l.f36952t, 7, 24, rc.a.V, 114, -88, -47, rc.a.f48409a0, i1.a.f31707t7, -92, okio.w0.f44229a, -32, rc.a.Z, -115, 12, -126, -22, -82, -76, -102, 99, 73, -27, 66, -28, 21, -73, -56, 6, pq.b.f46994k, -99, 65, 117, 25, i1.a.f31723v7, -86, -4, 77, -65, 42, 115, -124, -43, i1.a.f31691r7, -81, rc.a.f48411c0, -122, -89, -79, -78, 91, 70, -45, -97, -3, -44, 15, -100, 47, -101, 67, -17, i1.a.E7, 121, -74, 83, 127, i1.a.f31675p7, -16, 35, -25, rc.a.X, 94, -75, 30, -94, -33, -90, -2, -84, 34, -7, -30, 74, rp.u.f49086t, 53, i1.a.f31732w7, -18, tc.a.f51065w, 5, 107, 81, -31, 89, -93, -14, pq.b.f46993j, 86, 17, 106, -119, -108, 101, -116, -69, 119, 60, 123, 40, -85, -46, 49, -34, -60, 95, -52, i1.a.A7, 118, rc.a.f48412d0, -72, i1.a.f31659n7, rc.a.f48414f0, 54, -37, 105, -77, 20, -107, -66, 98, -95, 59, 22, 102, -23, 92, 108, 109, -83, 55, 97, 75, -71, -29, -70, -15, -96, -123, -125, i1.a.B7, 71, i1.a.f31699s7, -80, 51, -6, -106, pq.b.f46991h, pq.b.f46992i, i1.a.f31683q7, -10, jt.l.f36951s, -1, 93, -87, -114, 23, 27, -105, 125, -20, o5.b.f42741j, -9, 31, -5, 124, 9, 13, 122, 103, 69, -121, -36, -24, 79, 29, 78, 4, -21, -8, -13, 62, 61, -67, -118, -120, -35, i1.a.f31750y7, 11, 19, -104, 2, -109, -128, -112, -48, rc.a.W, 52, i1.a.f31741x7, -19, -12, i1.a.f31759z7, -103, 16, 68, 64, -110, 58, 1, rc.a.Y, 18, 26, 72, 104, -11, -127, -117, i1.a.f31714u7, -42, 32, 10, 8, 0, 76, -41, 116};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25190i = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25195e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25191a = {-108, 32, -123, 16, i1.a.f31683q7, i1.a.f31667o7, 1, -5, 1, i1.a.f31667o7, i1.a.f31683q7, 16, -123, 32, -108, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25192b = 32;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25193c = 32 / 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[][] f25194d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[][] f25196f = o();

    public static byte[][] o() {
        byte[][] bArr = new byte[256][];
        for (int i10 = 0; i10 < 256; i10++) {
            bArr[i10] = new byte[256];
            for (int i11 = 0; i11 < 256; i11++) {
                bArr[i10][i11] = s((byte) i10, (byte) i11);
            }
        }
        return bArr;
    }

    public static byte s(byte b10, byte b11) {
        byte b12 = 0;
        for (byte b13 = 0; b13 < 8 && b10 != 0 && b11 != 0; b13 = (byte) (b13 + 1)) {
            if ((b11 & 1) != 0) {
                b12 = (byte) (b12 ^ b10);
            }
            byte b14 = (byte) (b10 & 128);
            b10 = (byte) (b10 << 1);
            if (b14 != 0) {
                b10 = (byte) (b10 ^ i1.a.f31691r7);
            }
            b11 = (byte) (b11 >> 1);
        }
        return b12;
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (kVar instanceof np.n1) {
            this.f25195e = z10;
            n(((np.n1) kVar).a());
        } else {
            if (kVar == null) {
                return;
            }
            throw new IllegalArgumentException("invalid parameter passed to GOST3412_2015 init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "GOST3412_2015";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        if (this.f25194d == null) {
            throw new IllegalStateException("GOST3412_2015 engine not initialised");
        }
        if (i10 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        g(bArr, i10, bArr2, i11);
        return 16;
    }

    public final void e(byte[] bArr, int i10) {
        org.bouncycastle.util.a.n(bArr);
        bArr[15] = (byte) i10;
        h(bArr);
    }

    public final void f(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrI = i(bArr, bArr2);
        l(bArrI, bArr3);
        System.arraycopy(bArr2, 0, bArr3, 0, this.f25193c);
        System.arraycopy(bArrI, 0, bArr2, 0, this.f25193c);
    }

    public final void g(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[][] bArr3;
        byte[] bArrP = new byte[16];
        System.arraycopy(bArr, i10, bArrP, 0, 16);
        int i12 = 9;
        if (this.f25195e) {
            for (int i13 = 0; i13 < 9; i13++) {
                bArrP = org.bouncycastle.util.a.P(i(this.f25194d[i13], bArrP), 16);
            }
            l(bArrP, this.f25194d[9]);
        } else {
            while (true) {
                bArr3 = this.f25194d;
                if (i12 <= 0) {
                    break;
                }
                bArrP = org.bouncycastle.util.a.P(m(bArr3[i12], bArrP), 16);
                i12--;
            }
            l(bArrP, bArr3[0]);
        }
        System.arraycopy(bArrP, 0, bArr2, i11, 16);
    }

    public final void h(byte[] bArr) {
        for (int i10 = 0; i10 < 16; i10++) {
            j(bArr);
        }
    }

    public final byte[] i(byte[] bArr, byte[] bArr2) {
        byte[] bArrP = org.bouncycastle.util.a.P(bArr, bArr.length);
        l(bArrP, bArr2);
        k(bArrP);
        h(bArrP);
        return bArrP;
    }

    public final void j(byte[] bArr) {
        byte bT = t(bArr);
        System.arraycopy(bArr, 0, bArr, 1, 15);
        bArr[0] = bT;
    }

    public final void k(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = f25188g[u(bArr[i10])];
        }
    }

    public final void l(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    public final byte[] m(byte[] bArr, byte[] bArr2) {
        byte[] bArrP = org.bouncycastle.util.a.P(bArr, bArr.length);
        l(bArrP, bArr2);
        p(bArrP);
        r(bArrP);
        return bArrP;
    }

    public final void n(byte[] bArr) {
        int i10;
        if (bArr.length != this.f25192b) {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        this.f25194d = new byte[10][];
        for (int i11 = 0; i11 < 10; i11++) {
            this.f25194d[i11] = new byte[this.f25193c];
        }
        int i12 = this.f25193c;
        byte[] bArr2 = new byte[i12];
        byte[] bArr3 = new byte[i12];
        int i13 = 0;
        while (true) {
            i10 = this.f25193c;
            if (i13 >= i10) {
                break;
            }
            byte[][] bArr4 = this.f25194d;
            byte[] bArr5 = bArr4[0];
            byte b10 = bArr[i13];
            bArr2[i13] = b10;
            bArr5[i13] = b10;
            byte[] bArr6 = bArr4[1];
            byte b11 = bArr[i10 + i13];
            bArr3[i13] = b11;
            bArr6[i13] = b11;
            i13++;
        }
        byte[] bArr7 = new byte[i10];
        for (int i14 = 1; i14 < 5; i14++) {
            for (int i15 = 1; i15 <= 8; i15++) {
                e(bArr7, ((i14 - 1) * 8) + i15);
                f(bArr7, bArr2, bArr3);
            }
            int i16 = i14 * 2;
            System.arraycopy(bArr2, 0, this.f25194d[i16], 0, this.f25193c);
            System.arraycopy(bArr3, 0, this.f25194d[i16 + 1], 0, this.f25193c);
        }
    }

    public final void p(byte[] bArr) {
        for (int i10 = 0; i10 < 16; i10++) {
            q(bArr);
        }
    }

    public final void q(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 1, bArr2, 0, 15);
        bArr2[15] = bArr[0];
        byte bT = t(bArr2);
        System.arraycopy(bArr, 1, bArr, 0, 15);
        bArr[15] = bT;
    }

    public final void r(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = f25189h[u(bArr[i10])];
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }

    public final byte t(byte[] bArr) {
        byte b10 = bArr[15];
        for (int i10 = 14; i10 >= 0; i10--) {
            b10 = (byte) (b10 ^ this.f25196f[u(bArr[i10])][u(this.f25191a[i10])]);
        }
        return b10;
    }

    public final int u(byte b10) {
        return b10 & 255;
    }
}
