package cp;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class f implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[][] f25270b = {jt.h.d("517cc1b727220a94fe13abe8fa9a6ee0"), jt.h.d("6db14acc9e21c820ff28b1d5ef5de2b0"), jt.h.d("db92371d2126e9700324977504e8c90e")};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f25271c = {99, 124, 119, 123, -14, 107, pq.b.f46991h, i1.a.f31699s7, jt.l.f36949q, 1, 103, rc.a.f48411c0, -2, -41, -85, 118, i1.a.f31732w7, -126, i1.a.f31723v7, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, i1.a.f31667o7, -73, -3, -109, rc.a.Y, 54, okio.w0.f44229a, -9, -52, 52, -91, -27, -15, pq.b.f46993j, i1.a.f31659n7, 49, 21, 4, i1.a.f31714u7, 35, i1.a.f31691r7, 24, -106, 5, -102, 7, 18, -128, -30, -21, rc.a.Z, -78, 117, 9, -125, rc.a.f48412d0, 26, 27, pq.b.f46992i, 90, -96, 82, 59, -42, -77, rc.a.f48409a0, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, i1.a.f31741x7, -66, 57, 74, 76, o5.b.f42741j, i1.a.A7, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, jt.l.f36951s, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, rp.u.f49086t, -74, i1.a.B7, rc.a.V, 16, -1, -13, -46, i1.a.f31750y7, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, jt.l.f36952t, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, rc.a.W, 92, i1.a.f31683q7, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, tc.a.f51065w, rc.a.X, rc.a.f48414f0, 28, -90, -76, i1.a.f31707t7, -24, -35, 116, 31, 75, -67, -117, -118, pq.b.f46994k, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, i1.a.f31675p7, 29, -98, -31, -8, -104, 17, 105, i1.a.E7, -114, -108, -101, 30, -121, -23, i1.a.f31759z7, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, rc.a.f48413e0, 15, -80, 84, -69, 22};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f25272d = {-30, 78, 84, -4, -108, i1.a.f31683q7, 74, -52, 98, 13, 106, 70, 60, 77, -117, -47, 94, -6, 100, i1.a.f31741x7, -76, -105, -66, rc.a.f48411c0, rp.u.f49086t, 119, rc.a.f48414f0, 3, -45, 25, 89, i1.a.f31675p7, 29, 6, 65, 107, 85, -16, -103, 105, -22, -100, 24, -82, 99, -33, -25, -69, 0, 115, 102, -5, -106, 76, -123, -28, 58, 9, 69, -86, 15, -18, 16, -21, rc.a.f48413e0, 127, -12, rc.a.f48409a0, -84, i1.a.A7, -83, -111, -115, tc.a.f51065w, -56, -107, -7, 47, i1.a.f31759z7, i1.a.f31750y7, 8, 122, -120, 56, 92, -125, 42, 40, 71, -37, -72, i1.a.f31714u7, -109, -92, 18, 83, -1, -121, 14, 49, 54, rc.a.V, o5.b.f42741j, 72, 1, -114, 55, 116, 50, i1.a.f31732w7, -23, -79, -73, -85, 12, -41, -60, 86, 66, rc.a.Y, 7, -104, jt.l.f36952t, i1.a.E7, -74, -71, 17, 64, -20, 32, -116, -67, -96, i1.a.f31723v7, -124, 4, 73, 35, -15, 79, jt.l.f36951s, 31, 19, -36, i1.a.f31659n7, i1.a.f31667o7, -98, 87, -29, i1.a.f31691r7, 123, 101, 59, 2, -113, 62, -24, rc.a.X, -110, -27, 21, -35, -3, 23, -87, -65, -44, -102, 126, i1.a.f31699s7, 57, 103, -2, 118, -99, 67, -89, -31, -48, -11, 104, -14, 27, 52, pq.b.f46994k, 5, -93, -118, -43, 121, -122, -88, jt.l.f36949q, i1.a.f31707t7, 81, 75, 30, -90, rc.a.Z, -10, 53, -46, pq.b.f46992i, rc.a.W, 22, -126, 95, i1.a.B7, -26, 117, -94, -17, rc.a.f48412d0, -78, 28, -97, 93, pq.b.f46991h, -128, 10, 114, 68, -101, 108, -112, 11, 91, 51, 125, 90, 82, -13, 97, -95, -9, -80, -42, okio.w0.f44229a, 124, 109, -19, 20, -32, -91, 61, 34, -77, -8, -119, -34, pq.b.f46993j, 26, -81, -70, -75, -127};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f25273e = {82, 9, 106, -43, jt.l.f36949q, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, i1.a.f31741x7, 84, 123, -108, 50, -90, i1.a.f31683q7, 35, 61, -18, 76, -107, 11, 66, -6, i1.a.f31691r7, 78, 8, rc.a.f48414f0, -95, 102, 40, i1.a.E7, rc.a.W, -78, 118, 91, -94, 73, 109, -117, -47, rc.a.X, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, pq.b.f46994k, 72, jt.l.f36951s, -3, -19, -71, i1.a.B7, 94, 21, 70, 87, -89, -115, -99, -124, -112, i1.a.f31659n7, -85, 0, -116, rp.u.f49086t, -45, 10, -9, -28, o5.b.f42741j, 5, -72, -77, 69, 6, -48, rc.a.f48412d0, 30, -113, i1.a.f31732w7, okio.w0.f44229a, 15, 2, i1.a.f31675p7, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, i1.a.A7, i1.a.f31759z7, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, pq.b.f46992i, 71, -15, 26, pq.b.f46993j, 29, rc.a.f48409a0, i1.a.f31699s7, -119, pq.b.f46991h, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, i1.a.f31707t7, -46, 121, 32, -102, -37, i1.a.f31667o7, -2, tc.a.f51065w, i1.a.f31750y7, 90, -12, 31, -35, -88, 51, -120, 7, i1.a.f31714u7, 49, -79, 18, 16, 89, rc.a.Z, -128, -20, 95, jt.l.f36952t, 81, 127, -87, 25, -75, 74, 13, rc.a.f48413e0, -27, 122, -97, -109, i1.a.f31723v7, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, rc.a.f48411c0, 4, 126, -70, 119, -42, rc.a.Y, -31, 105, 20, 99, 85, rc.a.V, 12, 125};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f25274f = {jt.l.f36949q, 104, -103, 27, -121, -71, rc.a.V, tc.a.f51065w, jt.l.f36951s, 57, -37, -31, 114, 9, 98, 60, 62, 126, 94, -114, -15, -96, -52, -93, 42, 29, -5, -74, -42, 32, -60, -115, -127, 101, -11, -119, i1.a.f31741x7, -99, 119, i1.a.f31707t7, 87, 67, 86, 23, -44, 64, 26, 77, i1.a.f31667o7, 99, 108, -29, -73, -56, 100, 106, 83, -86, 56, -104, 12, -12, -101, -19, 127, 34, 118, -81, -35, 58, 11, o5.b.f42741j, 103, -120, 6, i1.a.f31691r7, 53, 13, 1, -117, -116, i1.a.f31683q7, -26, 95, 2, rc.a.W, 117, -109, 102, 30, -27, -30, 84, i1.a.f31659n7, 16, i1.a.f31759z7, 122, -24, 8, rc.a.f48412d0, 18, -105, 50, -85, -76, rc.a.Z, 10, 35, -33, -17, i1.a.f31732w7, i1.a.E7, -72, -6, -36, 49, 107, -47, -83, 25, 73, -67, 81, -106, -18, -28, -88, 65, i1.a.B7, -1, i1.a.f31750y7, 85, -122, 54, -66, 97, 82, -8, -69, 14, -126, 72, 105, -102, -32, 71, -98, 92, 4, 75, 52, 21, 121, rc.a.Y, -89, -34, rc.a.f48409a0, -82, -110, -41, -124, -23, -46, -70, 93, -13, i1.a.f31699s7, -80, -65, -92, 59, pq.b.f46993j, 68, 70, rc.a.f48411c0, -4, -21, pq.b.f46991h, -43, -10, 20, -2, 124, pq.b.f46994k, 90, 125, -3, 47, 24, -125, 22, -91, -111, 31, 5, -107, 116, -87, i1.a.f31675p7, 91, 74, -123, 109, 19, 7, 79, 78, 69, -78, 15, i1.a.f31723v7, 28, -90, rp.u.f49086t, -20, 115, -112, 123, i1.a.A7, 89, -113, -95, -7, rc.a.f48413e0, -14, -79, 0, -108, 55, -97, -48, rc.a.f48414f0, -100, pq.b.f46992i, 40, okio.w0.f44229a, -128, -16, 61, -45, rc.a.X, -118, -75, -25, 66, -77, i1.a.f31714u7, -22, -9, 76, 17, 51, 3, -94, -84, jt.l.f36952t};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25275g = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[][] f25276a;

    public static void e(byte[] bArr) {
        byte b10 = bArr[0];
        byte b11 = bArr[1];
        byte b12 = bArr[2];
        byte b13 = bArr[3];
        byte b14 = bArr[4];
        byte b15 = bArr[5];
        byte b16 = bArr[6];
        byte b17 = bArr[7];
        byte b18 = bArr[8];
        byte b19 = bArr[9];
        byte b20 = bArr[10];
        byte b21 = bArr[11];
        byte b22 = bArr[12];
        byte b23 = bArr[13];
        byte b24 = bArr[14];
        byte b25 = bArr[15];
        bArr[0] = (byte) ((((((b13 ^ b14) ^ b16) ^ b18) ^ b19) ^ b23) ^ b24);
        bArr[1] = (byte) ((((((b12 ^ b15) ^ b17) ^ b18) ^ b19) ^ b22) ^ b25);
        bArr[2] = (byte) ((((((b11 ^ b14) ^ b16) ^ b20) ^ b21) ^ b22) ^ b25);
        bArr[3] = (byte) ((((((b10 ^ b15) ^ b17) ^ b20) ^ b21) ^ b23) ^ b24);
        int i10 = b10 ^ b12;
        bArr[4] = (byte) (((((i10 ^ b15) ^ b18) ^ b21) ^ b24) ^ b25);
        int i11 = b11 ^ b13;
        bArr[5] = (byte) (((((i11 ^ b14) ^ b19) ^ b20) ^ b24) ^ b25);
        bArr[6] = (byte) (((((i10 ^ b17) ^ b19) ^ b20) ^ b22) ^ b23);
        bArr[7] = (byte) (((((i11 ^ b16) ^ b18) ^ b21) ^ b22) ^ b23);
        int i12 = b10 ^ b11;
        bArr[8] = (byte) (((((i12 ^ b14) ^ b17) ^ b20) ^ b23) ^ b25);
        bArr[9] = (byte) (((((i12 ^ b15) ^ b16) ^ b21) ^ b22) ^ b24);
        int i13 = b12 ^ b13;
        bArr[10] = (byte) (((((i13 ^ b15) ^ b16) ^ b18) ^ b23) ^ b25);
        bArr[11] = (byte) (((((i13 ^ b14) ^ b17) ^ b19) ^ b22) ^ b24);
        int i14 = b11 ^ b12;
        bArr[12] = (byte) (((((i14 ^ b16) ^ b17) ^ b19) ^ b21) ^ b22);
        int i15 = b10 ^ b13;
        bArr[13] = (byte) (((((i15 ^ b16) ^ b17) ^ b18) ^ b20) ^ b23);
        bArr[14] = (byte) (((((i15 ^ b14) ^ b15) ^ b19) ^ b21) ^ b24);
        bArr[15] = (byte) (((((i14 ^ b14) ^ b15) ^ b18) ^ b20) ^ b25);
    }

    public static void f(byte[] bArr, byte[] bArr2) {
        q(bArr, bArr2);
        m(bArr);
        e(bArr);
    }

    public static void g(byte[] bArr, byte[] bArr2) {
        q(bArr, bArr2);
        l(bArr);
        e(bArr);
    }

    public static byte h(byte b10) {
        return f25271c[b10 & 255];
    }

    public static byte i(byte b10) {
        return f25272d[b10 & 255];
    }

    public static byte j(byte b10) {
        return f25273e[b10 & 255];
    }

    public static byte k(byte b10) {
        return f25274f[b10 & 255];
    }

    public static void l(byte[] bArr) {
        bArr[0] = h(bArr[0]);
        bArr[1] = i(bArr[1]);
        bArr[2] = j(bArr[2]);
        bArr[3] = k(bArr[3]);
        bArr[4] = h(bArr[4]);
        bArr[5] = i(bArr[5]);
        bArr[6] = j(bArr[6]);
        bArr[7] = k(bArr[7]);
        bArr[8] = h(bArr[8]);
        bArr[9] = i(bArr[9]);
        bArr[10] = j(bArr[10]);
        bArr[11] = k(bArr[11]);
        bArr[12] = h(bArr[12]);
        bArr[13] = i(bArr[13]);
        bArr[14] = j(bArr[14]);
        bArr[15] = k(bArr[15]);
    }

    public static void m(byte[] bArr) {
        bArr[0] = j(bArr[0]);
        bArr[1] = k(bArr[1]);
        bArr[2] = h(bArr[2]);
        bArr[3] = i(bArr[3]);
        bArr[4] = j(bArr[4]);
        bArr[5] = k(bArr[5]);
        bArr[6] = h(bArr[6]);
        bArr[7] = i(bArr[7]);
        bArr[8] = j(bArr[8]);
        bArr[9] = k(bArr[9]);
        bArr[10] = h(bArr[10]);
        bArr[11] = i(bArr[11]);
        bArr[12] = j(bArr[12]);
        bArr[13] = k(bArr[13]);
        bArr[14] = h(bArr[14]);
        bArr[15] = i(bArr[15]);
    }

    public static byte[][] n(boolean z10, byte[] bArr) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i10 = (length >>> 3) - 2;
        byte[][] bArr2 = f25270b;
        byte[] bArr3 = bArr2[i10];
        byte[] bArr4 = bArr2[(i10 + 1) % 3];
        byte[] bArr5 = bArr2[(i10 + 2) % 3];
        byte[] bArr6 = new byte[16];
        byte[] bArr7 = new byte[16];
        System.arraycopy(bArr, 0, bArr6, 0, 16);
        System.arraycopy(bArr, 16, bArr7, 0, length - 16);
        byte[] bArr8 = new byte[16];
        byte[] bArr9 = new byte[16];
        byte[] bArr10 = new byte[16];
        byte[] bArr11 = new byte[16];
        System.arraycopy(bArr6, 0, bArr8, 0, 16);
        System.arraycopy(bArr8, 0, bArr9, 0, 16);
        g(bArr9, bArr3);
        q(bArr9, bArr7);
        System.arraycopy(bArr9, 0, bArr10, 0, 16);
        f(bArr10, bArr4);
        q(bArr10, bArr8);
        System.arraycopy(bArr10, 0, bArr11, 0, 16);
        g(bArr11, bArr5);
        q(bArr11, bArr9);
        int i11 = (i10 * 2) + 12;
        byte[][] bArr12 = (byte[][]) Array.newInstance((Class<?>) byte.class, i11 + 1, 16);
        o(bArr12[0], bArr8, bArr9, 19);
        o(bArr12[1], bArr9, bArr10, 19);
        o(bArr12[2], bArr10, bArr11, 19);
        o(bArr12[3], bArr11, bArr8, 19);
        o(bArr12[4], bArr8, bArr9, 31);
        o(bArr12[5], bArr9, bArr10, 31);
        o(bArr12[6], bArr10, bArr11, 31);
        o(bArr12[7], bArr11, bArr8, 31);
        o(bArr12[8], bArr8, bArr9, 67);
        o(bArr12[9], bArr9, bArr10, 67);
        o(bArr12[10], bArr10, bArr11, 67);
        o(bArr12[11], bArr11, bArr8, 67);
        o(bArr12[12], bArr8, bArr9, 97);
        if (i11 > 12) {
            o(bArr12[13], bArr9, bArr10, 97);
            o(bArr12[14], bArr10, bArr11, 97);
            if (i11 > 14) {
                o(bArr12[15], bArr11, bArr8, 97);
                o(bArr12[16], bArr8, bArr9, 109);
            }
        }
        if (!z10) {
            p(bArr12);
            for (int i12 = 1; i12 < i11; i12++) {
                e(bArr12[i12]);
            }
        }
        return bArr12;
    }

    public static void o(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        int i13 = 8 - i12;
        int i14 = bArr3[15 - i11] & 255;
        int i15 = 0;
        while (i15 < 16) {
            int i16 = bArr3[(i15 - i11) & 15] & 255;
            bArr[i15] = (byte) (((i14 << i13) | (i16 >>> i12)) ^ (bArr2[i15] & 255));
            i15++;
            i14 = i16;
        }
    }

    public static void p(byte[][] bArr) {
        int length = bArr.length;
        int i10 = length / 2;
        int i11 = length - 1;
        for (int i12 = 0; i12 < i10; i12++) {
            byte[] bArr2 = bArr[i12];
            int i13 = i11 - i12;
            bArr[i12] = bArr[i13];
            bArr[i13] = bArr2;
        }
    }

    public static void q(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < 16; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (kVar instanceof np.n1) {
            this.f25276a = n(z10, ((np.n1) kVar).a());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ARIA init - " + kVar.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "ARIA";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        if (this.f25276a == null) {
            throw new IllegalStateException("ARIA engine not initialised");
        }
        if (i10 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 > bArr2.length - 16) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, i10, bArr3, 0, 16);
        int length = this.f25276a.length - 3;
        int i12 = 0;
        while (i12 < length) {
            int i13 = i12 + 1;
            g(bArr3, this.f25276a[i12]);
            f(bArr3, this.f25276a[i13]);
            i12 = i13 + 1;
        }
        int i14 = i12 + 1;
        g(bArr3, this.f25276a[i12]);
        q(bArr3, this.f25276a[i14]);
        m(bArr3);
        q(bArr3, this.f25276a[i14 + 1]);
        System.arraycopy(bArr3, 0, bArr2, i11, 16);
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
