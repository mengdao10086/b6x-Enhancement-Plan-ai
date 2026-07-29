package zo;

import okio.w0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class o implements org.bouncycastle.crypto.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f59386a = 32;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[][] f59387b = {new byte[]{99, 124, 119, 123, -14, 107, pq.b.f46991h, i1.a.f31699s7, jt.l.f36949q, 1, 103, rc.a.f48411c0, -2, -41, -85, 118}, new byte[]{i1.a.f31732w7, -126, i1.a.f31723v7, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, i1.a.f31667o7}, new byte[]{-73, -3, -109, rc.a.Y, 54, w0.f44229a, -9, -52, 52, -91, -27, -15, pq.b.f46993j, i1.a.f31659n7, 49, 21}, new byte[]{4, i1.a.f31714u7, 35, i1.a.f31691r7, 24, -106, 5, -102, 7, 18, -128, -30, -21, rc.a.Z, -78, 117}, new byte[]{9, -125, rc.a.f48412d0, 26, 27, pq.b.f46992i, 90, -96, 82, 59, -42, -77, rc.a.f48409a0, -29, 47, -124}, new byte[]{83, -47, 0, -19, 32, -4, -79, 91, 106, i1.a.f31741x7, -66, 57, 74, 76, o5.b.f42741j, i1.a.A7}, new byte[]{-48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, jt.l.f36951s, 60, -97, -88}, new byte[]{81, -93, 64, -113, -110, -99, 56, -11, rp.u.f49086t, -74, i1.a.B7, rc.a.V, 16, -1, -13, -46}, new byte[]{i1.a.f31750y7, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115}, new byte[]{jt.l.f36952t, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37}, new byte[]{-32, 50, 58, 10, 73, 6, rc.a.W, 92, i1.a.f31683q7, -45, -84, 98, -111, -107, -28, 121}, new byte[]{-25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8}, new byte[]{-70, tc.a.f51065w, rc.a.X, rc.a.f48414f0, 28, -90, -76, i1.a.f31707t7, -24, -35, 116, 31, 75, -67, -117, -118}, new byte[]{pq.b.f46994k, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, i1.a.f31675p7, 29, -98}, new byte[]{-31, -8, -104, 17, 105, i1.a.E7, -114, -108, -101, 30, -121, -23, i1.a.f31759z7, 85, 40, -33}, new byte[]{-116, -95, -119, 13, -65, -26, 66, 104, 65, -103, rc.a.f48413e0, 15, -80, 84, -69, 22}};

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrD = d(j(k(bArr)));
        n(bArrD, bArr2);
        return bArrD;
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = i10 + 1;
            int i13 = i11 * 4;
            int i14 = i13 + 1;
            int i15 = i13 + 2;
            int i16 = i13 + 3;
            bArr2[i10] = (byte) ((((l(bArr[i13]) ^ l(bArr[i14])) ^ bArr[i14]) ^ bArr[i15]) ^ bArr[i16]);
            int i17 = i12 + 1;
            bArr2[i12] = (byte) ((((bArr[i13] ^ l(bArr[i14])) ^ l(bArr[i15])) ^ bArr[i15]) ^ bArr[i16]);
            int i18 = i17 + 1;
            bArr2[i17] = (byte) ((((bArr[i13] ^ bArr[i14]) ^ l(bArr[i15])) ^ l(bArr[i16])) ^ bArr[i16]);
            i10 = i18 + 1;
            bArr2[i18] = (byte) ((((bArr[i13] ^ l(bArr[i13])) ^ bArr[i14]) ^ bArr[i15]) ^ l(bArr[i16]));
        }
        return bArr2;
    }

    public static byte i(byte b10) {
        return f59387b[(b10 & 255) >>> 4][b10 & 15];
    }

    public static byte[] j(byte[] bArr) {
        return new byte[]{bArr[0], bArr[5], bArr[10], bArr[15], bArr[4], bArr[9], bArr[14], bArr[3], bArr[8], bArr[13], bArr[2], bArr[7], bArr[12], bArr[1], bArr[6], bArr[11]};
    }

    public static byte[] k(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        bArr2[0] = i(bArr[0]);
        bArr2[1] = i(bArr[1]);
        bArr2[2] = i(bArr[2]);
        bArr2[3] = i(bArr[3]);
        bArr2[4] = i(bArr[4]);
        bArr2[5] = i(bArr[5]);
        bArr2[6] = i(bArr[6]);
        bArr2[7] = i(bArr[7]);
        bArr2[8] = i(bArr[8]);
        bArr2[9] = i(bArr[9]);
        bArr2[10] = i(bArr[10]);
        bArr2[11] = i(bArr[11]);
        bArr2[12] = i(bArr[12]);
        bArr2[13] = i(bArr[13]);
        bArr2[14] = i(bArr[14]);
        bArr2[15] = i(bArr[15]);
        return bArr2;
    }

    public static byte l(byte b10) {
        int i10 = b10 >>> 7;
        int i11 = b10 << 1;
        if (i10 > 0) {
            i11 ^= 27;
        }
        return (byte) (i11 & 255);
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, int i10) {
        byte[] bArr3 = new byte[16];
        int i11 = 0;
        while (i11 < 16) {
            bArr3[i11] = (byte) (bArr2[i10] ^ bArr[i11]);
            i11++;
            i10++;
        }
        return bArr3;
    }

    public static void n(byte[] bArr, byte[] bArr2) {
        bArr[0] = (byte) (bArr[0] ^ bArr2[15]);
        bArr[1] = (byte) (bArr[1] ^ bArr2[14]);
        bArr[2] = (byte) (bArr[2] ^ bArr2[13]);
        bArr[3] = (byte) (bArr[3] ^ bArr2[12]);
        bArr[4] = (byte) (bArr[4] ^ bArr2[11]);
        bArr[5] = (byte) (bArr[5] ^ bArr2[10]);
        bArr[6] = (byte) (bArr[6] ^ bArr2[9]);
        bArr[7] = (byte) (bArr[7] ^ bArr2[8]);
        bArr[8] = (byte) (bArr2[7] ^ bArr[8]);
        bArr[9] = (byte) (bArr2[6] ^ bArr[9]);
        bArr[10] = (byte) (bArr2[5] ^ bArr[10]);
        bArr[11] = (byte) (bArr2[4] ^ bArr[11]);
        bArr[12] = (byte) (bArr2[3] ^ bArr[12]);
        bArr[13] = (byte) (bArr2[2] ^ bArr[13]);
        bArr[14] = (byte) (bArr2[1] ^ bArr[14]);
        bArr[15] = (byte) (bArr2[0] ^ bArr[15]);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 32;
    }
}
