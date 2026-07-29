package cp;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f25218d = {99, 124, 119, 123, -14, 107, pq.b.f46991h, i1.a.f31699s7, jt.l.f36949q, 1, 103, rc.a.f48411c0, -2, -41, -85, 118, i1.a.f31732w7, -126, i1.a.f31723v7, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, i1.a.f31667o7, -73, -3, -109, rc.a.Y, 54, okio.w0.f44229a, -9, -52, 52, -91, -27, -15, pq.b.f46993j, i1.a.f31659n7, 49, 21, 4, i1.a.f31714u7, 35, i1.a.f31691r7, 24, -106, 5, -102, 7, 18, -128, -30, -21, rc.a.Z, -78, 117, 9, -125, rc.a.f48412d0, 26, 27, pq.b.f46992i, 90, -96, 82, 59, -42, -77, rc.a.f48409a0, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, i1.a.f31741x7, -66, 57, 74, 76, o5.b.f42741j, i1.a.A7, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, jt.l.f36951s, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, rp.u.f49086t, -74, i1.a.B7, rc.a.V, 16, -1, -13, -46, i1.a.f31750y7, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, jt.l.f36952t, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, rc.a.W, 92, i1.a.f31683q7, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, tc.a.f51065w, rc.a.X, rc.a.f48414f0, 28, -90, -76, i1.a.f31707t7, -24, -35, 116, 31, 75, -67, -117, -118, pq.b.f46994k, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, i1.a.f31675p7, 29, -98, -31, -8, -104, 17, 105, i1.a.E7, -114, -108, -101, 30, -121, -23, i1.a.f31759z7, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, rc.a.f48413e0, 15, -80, 84, -69, 22};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f25219e = {82, 9, 106, -43, jt.l.f36949q, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, i1.a.f31741x7, 84, 123, -108, 50, -90, i1.a.f31683q7, 35, 61, -18, 76, -107, 11, 66, -6, i1.a.f31691r7, 78, 8, rc.a.f48414f0, -95, 102, 40, i1.a.E7, rc.a.W, -78, 118, 91, -94, 73, 109, -117, -47, rc.a.X, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, pq.b.f46994k, 72, jt.l.f36951s, -3, -19, -71, i1.a.B7, 94, 21, 70, 87, -89, -115, -99, -124, -112, i1.a.f31659n7, -85, 0, -116, rp.u.f49086t, -45, 10, -9, -28, o5.b.f42741j, 5, -72, -77, 69, 6, -48, rc.a.f48412d0, 30, -113, i1.a.f31732w7, okio.w0.f44229a, 15, 2, i1.a.f31675p7, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, i1.a.A7, i1.a.f31759z7, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, pq.b.f46992i, 71, -15, 26, pq.b.f46993j, 29, rc.a.f48409a0, i1.a.f31699s7, -119, pq.b.f46991h, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, i1.a.f31707t7, -46, 121, 32, -102, -37, i1.a.f31667o7, -2, tc.a.f51065w, i1.a.f31750y7, 90, -12, 31, -35, -88, 51, -120, 7, i1.a.f31714u7, 49, -79, 18, 16, 89, rc.a.Z, -128, -20, 95, jt.l.f36952t, 81, 127, -87, 25, -75, 74, 13, rc.a.f48413e0, -27, 122, -97, -109, i1.a.f31723v7, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, rc.a.f48411c0, 4, 126, -70, 119, -42, rc.a.Y, -31, 105, 20, 99, 85, rc.a.V, 12, 125};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f25220f = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, rc.c.f48463k0, 53, 106, 212, 179, 125, 250, 239, 197, 145};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25221g = -2139062144;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25222h = 2139062143;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25223i = 27;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25224j = -1061109568;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25225k = 1061109567;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25226l = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[][] f25228b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25229c;

    public static int e(int i10) {
        return (((i10 & (-2139062144)) >>> 7) * 27) ^ ((2139062143 & i10) << 1);
    }

    public static int f(int i10) {
        int i11 = (1061109567 & i10) << 2;
        int i12 = i10 & (-1061109568);
        int i13 = i12 ^ (i12 >>> 1);
        return (i13 >>> 5) ^ (i11 ^ (i13 >>> 2));
    }

    public static int j(int i10) {
        int iL = l(i10, 8) ^ i10;
        int iE = i10 ^ e(iL);
        int iF = iL ^ f(iE);
        return iE ^ (iF ^ l(iF, 16));
    }

    public static int k(int i10) {
        int iL = l(i10, 8);
        int i11 = i10 ^ iL;
        return e(i11) ^ (iL ^ l(i11, 16));
    }

    public static int l(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    public static int m(int i10) {
        byte[] bArr = f25218d;
        return (bArr[(i10 >> 24) & 255] << 24) | (bArr[i10 & 255] & 255) | ((bArr[(i10 >> 8) & 255] & 255) << 8) | ((bArr[(i10 >> 16) & 255] & 255) << 16);
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            this.f25228b = i(((np.n1) kVar).a(), z10);
            this.f25229c = z10;
        } else {
            throw new IllegalArgumentException("invalid parameter passed to AES init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return m5.b.f40641c;
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[][] iArr = this.f25228b;
        if (iArr == null) {
            throw new IllegalStateException("AES engine not initialised");
        }
        if (i10 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 > bArr2.length - 16) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.f25229c) {
            h(bArr, i10, bArr2, i11, iArr);
        } else {
            g(bArr, i10, bArr2, i11, iArr);
        }
        return 16;
    }

    public final void g(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        int iR = org.bouncycastle.util.o.r(bArr, i10 + 0);
        int iR2 = org.bouncycastle.util.o.r(bArr, i10 + 4);
        int iR3 = org.bouncycastle.util.o.r(bArr, i10 + 8);
        int iR4 = org.bouncycastle.util.o.r(bArr, i10 + 12);
        int i12 = this.f25227a;
        int i13 = iR ^ iArr[i12][0];
        int i14 = iR2 ^ iArr[i12][1];
        int i15 = iR3 ^ iArr[i12][2];
        int i16 = i12 - 1;
        int i17 = iR4 ^ iArr[i12][3];
        while (true) {
            byte[] bArr3 = f25219e;
            int i18 = i13 & 255;
            if (i16 <= 1) {
                int iJ = j((((bArr3[i18] & 255) ^ ((bArr3[(i17 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i14 >> 24) & 255] << 24)) ^ iArr[i16][0];
                int iJ2 = j((((bArr3[i14 & 255] & 255) ^ ((bArr3[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i17 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i15 >> 24) & 255] << 24)) ^ iArr[i16][1];
                int iJ3 = j((((bArr3[i15 & 255] & 255) ^ ((bArr3[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i13 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i17 >> 24) & 255] << 24)) ^ iArr[i16][2];
                int iJ4 = j((((bArr3[i17 & 255] & 255) ^ ((bArr3[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i13 >> 24) & 255] << 24)) ^ iArr[i16][3];
                int i19 = ((((bArr3[iJ & 255] & 255) ^ ((bArr3[(iJ4 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iJ3 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iJ2 >> 24) & 255] << 24)) ^ iArr[0][0];
                int i20 = ((((bArr3[iJ2 & 255] & 255) ^ ((bArr3[(iJ >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iJ4 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iJ3 >> 24) & 255] << 24)) ^ iArr[0][1];
                int i21 = ((((bArr3[iJ3 & 255] & 255) ^ ((bArr3[(iJ2 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iJ >> 16) & 255] & 255) << 16)) ^ (bArr3[(iJ4 >> 24) & 255] << 24)) ^ iArr[0][2];
                int i22 = ((((bArr3[iJ4 & 255] & 255) ^ ((bArr3[(iJ3 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iJ2 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iJ >> 24) & 255] << 24)) ^ iArr[0][3];
                org.bouncycastle.util.o.m(i19, bArr2, i11 + 0);
                org.bouncycastle.util.o.m(i20, bArr2, i11 + 4);
                org.bouncycastle.util.o.m(i21, bArr2, i11 + 8);
                org.bouncycastle.util.o.m(i22, bArr2, i11 + 12);
                return;
            }
            int iJ5 = j((((bArr3[i18] & 255) ^ ((bArr3[(i17 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i14 >> 24) & 255] << 24)) ^ iArr[i16][0];
            int iJ6 = j((((bArr3[i14 & 255] & 255) ^ ((bArr3[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i17 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i15 >> 24) & 255] << 24)) ^ iArr[i16][1];
            int iJ7 = j((((bArr3[i15 & 255] & 255) ^ ((bArr3[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i13 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i17 >> 24) & 255] << 24)) ^ iArr[i16][2];
            int iJ8 = j((((bArr3[i17 & 255] & 255) ^ ((bArr3[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i13 >> 24) & 255] << 24));
            int i23 = i16 - 1;
            int i24 = iJ8 ^ iArr[i16][3];
            int iJ9 = j((((bArr3[iJ5 & 255] & 255) ^ ((bArr3[(i24 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iJ7 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iJ6 >> 24) & 255] << 24)) ^ iArr[i23][0];
            int iJ10 = j((((bArr3[iJ6 & 255] & 255) ^ ((bArr3[(iJ5 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i24 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iJ7 >> 24) & 255] << 24)) ^ iArr[i23][1];
            int iJ11 = j((((bArr3[iJ7 & 255] & 255) ^ ((bArr3[(iJ6 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iJ5 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i24 >> 24) & 255] << 24)) ^ iArr[i23][2];
            int iJ12 = j((((bArr3[i24 & 255] & 255) ^ ((bArr3[(iJ7 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iJ6 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iJ5 >> 24) & 255] << 24));
            int i25 = i23 - 1;
            i17 = iJ12 ^ iArr[i23][3];
            i13 = iJ9;
            i14 = iJ10;
            i15 = iJ11;
            i16 = i25;
        }
    }

    public final void h(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        int iR = org.bouncycastle.util.o.r(bArr, i10 + 0);
        int iR2 = org.bouncycastle.util.o.r(bArr, i10 + 4);
        int iR3 = org.bouncycastle.util.o.r(bArr, i10 + 8);
        int iR4 = org.bouncycastle.util.o.r(bArr, i10 + 12);
        int i12 = iR ^ iArr[0][0];
        int i13 = iR2 ^ iArr[0][1];
        int i14 = iR3 ^ iArr[0][2];
        int i15 = iR4 ^ iArr[0][3];
        int i16 = 1;
        while (i16 < this.f25227a - 1) {
            byte[] bArr3 = f25218d;
            int iK = k((((bArr3[i12 & 255] & 255) ^ ((bArr3[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i15 >> 24) & 255] << 24)) ^ iArr[i16][0];
            int iK2 = k((((bArr3[i13 & 255] & 255) ^ ((bArr3[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i12 >> 24) & 255] << 24)) ^ iArr[i16][1];
            int iK3 = k((((bArr3[i14 & 255] & 255) ^ ((bArr3[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i12 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i13 >> 24) & 255] << 24)) ^ iArr[i16][2];
            int iK4 = k((((bArr3[i15 & 255] & 255) ^ ((bArr3[(i12 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i13 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i14 >> 24) & 255] << 24));
            int i17 = i16 + 1;
            int i18 = iK4 ^ iArr[i16][3];
            int iK5 = k((((bArr3[iK & 255] & 255) ^ ((bArr3[(iK2 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iK3 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i18 >> 24) & 255] << 24)) ^ iArr[i17][0];
            int iK6 = k((((bArr3[iK2 & 255] & 255) ^ ((bArr3[(iK3 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i18 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iK >> 24) & 255] << 24)) ^ iArr[i17][1];
            int iK7 = k((((bArr3[iK3 & 255] & 255) ^ ((bArr3[(i18 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iK >> 16) & 255] & 255) << 16)) ^ (bArr3[(iK2 >> 24) & 255] << 24)) ^ iArr[i17][2];
            int iK8 = k((((bArr3[i18 & 255] & 255) ^ ((bArr3[(iK >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iK2 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iK3 >> 24) & 255] << 24));
            int i19 = i17 + 1;
            i15 = iK8 ^ iArr[i17][3];
            i12 = iK5;
            i13 = iK6;
            i14 = iK7;
            i16 = i19;
        }
        byte[] bArr4 = f25218d;
        int iK9 = k((((bArr4[i12 & 255] & 255) ^ ((bArr4[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i15 >> 24) & 255] << 24)) ^ iArr[i16][0];
        int iK10 = k((((bArr4[i13 & 255] & 255) ^ ((bArr4[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i12 >> 24) & 255] << 24)) ^ iArr[i16][1];
        int iK11 = k((((bArr4[i14 & 255] & 255) ^ ((bArr4[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i12 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i13 >> 24) & 255] << 24)) ^ iArr[i16][2];
        int iK12 = k((((bArr4[i15 & 255] & 255) ^ ((bArr4[(i12 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i13 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i14 >> 24) & 255] << 24));
        int i20 = i16 + 1;
        int i21 = iK12 ^ iArr[i16][3];
        int i22 = ((((bArr4[iK9 & 255] & 255) ^ ((bArr4[(iK10 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(iK11 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i21 >> 24) & 255] << 24)) ^ iArr[i20][0];
        int i23 = ((((bArr4[iK10 & 255] & 255) ^ ((bArr4[(iK11 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i21 >> 16) & 255] & 255) << 16)) ^ (bArr4[(iK9 >> 24) & 255] << 24)) ^ iArr[i20][1];
        int i24 = ((((bArr4[iK11 & 255] & 255) ^ ((bArr4[(i21 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(iK9 >> 16) & 255] & 255) << 16)) ^ (bArr4[(iK10 >> 24) & 255] << 24)) ^ iArr[i20][2];
        int i25 = ((((bArr4[i21 & 255] & 255) ^ ((bArr4[(iK9 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(iK10 >> 16) & 255] & 255) << 16)) ^ (bArr4[(iK11 >> 24) & 255] << 24)) ^ iArr[i20][3];
        org.bouncycastle.util.o.m(i22, bArr2, i11 + 0);
        org.bouncycastle.util.o.m(i23, bArr2, i11 + 4);
        org.bouncycastle.util.o.m(i24, bArr2, i11 + 8);
        org.bouncycastle.util.o.m(i25, bArr2, i11 + 12);
    }

    public final int[][] i(byte[] bArr, boolean z10) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i10 = length >>> 2;
        int i11 = i10 + 6;
        this.f25227a = i11;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i11 + 1, 4);
        int i12 = 8;
        char c10 = 3;
        if (i10 == 4) {
            int iR = org.bouncycastle.util.o.r(bArr, 0);
            iArr[0][0] = iR;
            int iR2 = org.bouncycastle.util.o.r(bArr, 4);
            iArr[0][1] = iR2;
            int iR3 = org.bouncycastle.util.o.r(bArr, 8);
            iArr[0][2] = iR3;
            int iR4 = org.bouncycastle.util.o.r(bArr, 12);
            iArr[0][3] = iR4;
            for (int i13 = 1; i13 <= 10; i13++) {
                iR ^= m(l(iR4, 8)) ^ f25220f[i13 - 1];
                iArr[i13][0] = iR;
                iR2 ^= iR;
                iArr[i13][1] = iR2;
                iR3 ^= iR2;
                iArr[i13][2] = iR3;
                iR4 ^= iR3;
                iArr[i13][3] = iR4;
            }
        } else if (i10 == 6) {
            int iR5 = org.bouncycastle.util.o.r(bArr, 0);
            iArr[0][0] = iR5;
            int iR6 = org.bouncycastle.util.o.r(bArr, 4);
            iArr[0][1] = iR6;
            int iR7 = org.bouncycastle.util.o.r(bArr, 8);
            iArr[0][2] = iR7;
            int iR8 = org.bouncycastle.util.o.r(bArr, 12);
            iArr[0][3] = iR8;
            int iR9 = org.bouncycastle.util.o.r(bArr, 16);
            int iR10 = org.bouncycastle.util.o.r(bArr, 20);
            int i14 = 1;
            int i15 = 1;
            while (true) {
                iArr[i14][0] = iR9;
                iArr[i14][1] = iR10;
                int iM = m(l(iR10, 8)) ^ i15;
                int i16 = i15 << 1;
                int i17 = iR5 ^ iM;
                iArr[i14][2] = i17;
                int i18 = iR6 ^ i17;
                iArr[i14][3] = i18;
                int i19 = iR7 ^ i18;
                int i20 = i14 + 1;
                iArr[i20][0] = i19;
                int i21 = iR8 ^ i19;
                iArr[i20][1] = i21;
                int i22 = iR9 ^ i21;
                iArr[i20][2] = i22;
                int i23 = iR10 ^ i22;
                iArr[i20][3] = i23;
                int iM2 = m(l(i23, 8)) ^ i16;
                i15 = i16 << 1;
                iR5 = i17 ^ iM2;
                int i24 = i14 + 2;
                iArr[i24][0] = iR5;
                iR6 = i18 ^ iR5;
                iArr[i24][1] = iR6;
                iR7 = i19 ^ iR6;
                iArr[i24][2] = iR7;
                iR8 = i21 ^ iR7;
                iArr[i24][3] = iR8;
                i14 += 3;
                if (i14 >= 13) {
                    break;
                }
                iR9 = i22 ^ iR8;
                iR10 = i23 ^ iR9;
            }
        } else {
            if (i10 != 8) {
                throw new IllegalStateException("Should never get here");
            }
            int iR11 = org.bouncycastle.util.o.r(bArr, 0);
            iArr[0][0] = iR11;
            int iR12 = org.bouncycastle.util.o.r(bArr, 4);
            iArr[0][1] = iR12;
            int iR13 = org.bouncycastle.util.o.r(bArr, 8);
            iArr[0][2] = iR13;
            int iR14 = org.bouncycastle.util.o.r(bArr, 12);
            iArr[0][3] = iR14;
            int iR15 = org.bouncycastle.util.o.r(bArr, 16);
            iArr[1][0] = iR15;
            int iR16 = org.bouncycastle.util.o.r(bArr, 20);
            iArr[1][1] = iR16;
            int iR17 = org.bouncycastle.util.o.r(bArr, 24);
            iArr[1][2] = iR17;
            int iR18 = org.bouncycastle.util.o.r(bArr, 28);
            iArr[1][3] = iR18;
            int i25 = 1;
            int i26 = 2;
            while (true) {
                int iM3 = m(l(iR18, i12)) ^ i25;
                i25 <<= 1;
                iR11 ^= iM3;
                iArr[i26][0] = iR11;
                iR12 ^= iR11;
                iArr[i26][1] = iR12;
                iR13 ^= iR12;
                iArr[i26][2] = iR13;
                iR14 ^= iR13;
                iArr[i26][c10] = iR14;
                int i27 = i26 + 1;
                if (i27 >= 15) {
                    break;
                }
                iR15 ^= m(iR14);
                iArr[i27][0] = iR15;
                iR16 ^= iR15;
                iArr[i27][1] = iR16;
                iR17 ^= iR16;
                iArr[i27][2] = iR17;
                iR18 ^= iR17;
                iArr[i27][3] = iR18;
                i26 = i27 + 1;
                i12 = 8;
                c10 = 3;
            }
        }
        if (!z10) {
            for (int i28 = 1; i28 < this.f25227a; i28++) {
                for (int i29 = 0; i29 < 4; i29++) {
                    iArr[i28][i29] = j(iArr[i28][i29]);
                }
            }
        }
        return iArr;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
