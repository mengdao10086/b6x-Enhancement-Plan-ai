package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public final class n1 implements org.bouncycastle.crypto.f {
    public static final int A = 1;
    public static final int B = 1;
    public static final int C = 0;
    public static final int D = 1;
    public static final int E = 361;
    public static final int F = 180;
    public static final int G = 90;
    public static final int H = 333;
    public static final int I = 16;
    public static final int J = 16;
    public static final int K = 16;
    public static final int L = 256;
    public static final int M = 0;
    public static final int N = 4;
    public static final int O = 8;
    public static final int P = 40;
    public static final int Q = 33686018;
    public static final int R = 16843009;
    public static final int S = 9;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[][] f25561j = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, -128, tc.a.f51065w, -28, -35, -47, 56, 13, i1.a.f31707t7, 53, -104, 24, -9, -20, 108, 67, 117, 55, rc.a.Y, -6, 19, -108, 72, -14, -48, -117, jt.l.f36949q, -124, 84, -33, 35, 25, 91, 61, 89, -13, -82, -94, -126, 99, 1, -125, rc.a.f48414f0, i1.a.E7, 81, -101, 124, -90, -21, -91, -66, 22, 12, -29, 97, i1.a.f31667o7, -116, 58, -11, 115, rc.a.f48412d0, rc.a.X, 11, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, 28, 30, -41, -5, i1.a.f31691r7, -114, -75, -23, i1.a.A7, -65, -70, -22, 119, 57, -81, 51, i1.a.f31723v7, 98, pq.b.f46993j, -127, 121, 9, -83, rc.a.W, i1.a.f31750y7, -7, i1.a.f31659n7, -27, i1.a.f31699s7, -71, 77, 68, 8, -122, -25, -95, 29, -86, -19, 6, pq.b.f46994k, -78, -46, 65, 123, -96, 17, 49, i1.a.f31683q7, rc.a.Z, -112, 32, -10, jt.l.f36952t, -1, -106, 92, -79, -85, -98, -100, 82, 27, 95, -109, 10, -17, -111, -123, 73, -18, rc.a.f48413e0, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, i1.a.f31759z7, i1.a.f31741x7, 47, -4, -105, 5, 122, -84, 127, -43, 26, 75, 14, -89, 90, 40, 20, okio.w0.f44229a, rc.a.f48409a0, -120, 60, 76, 2, -72, i1.a.B7, -80, 23, 85, 31, -118, 125, 87, i1.a.f31714u7, -115, 116, -73, -60, -97, 114, 126, 21, 34, 18, o5.b.f42741j, 7, -103, 52, pq.b.f46992i, jt.l.f36951s, -34, 104, 101, rp.u.f49086t, -37, -8, -56, -88, rc.a.f48411c0, 64, -36, -2, 50, -92, i1.a.f31732w7, 16, rc.a.V, -16, -45, 93, 15, 0, pq.b.f46991h, -99, 54, 66, 74, 94, i1.a.f31675p7, -32}, new byte[]{117, -13, i1.a.f31707t7, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, i1.a.f31659n7, -3, 55, pq.b.f46993j, -15, -31, jt.l.f36949q, 15, -8, 27, -121, -6, 6, okio.w0.f44229a, 94, -70, -82, 91, -118, 0, rp.u.f49086t, -99, 109, i1.a.f31675p7, -79, 14, -128, 93, -46, -43, -96, -124, 7, 20, -75, -112, rc.a.f48412d0, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, jt.l.f36952t, 98, -106, 108, 66, -9, 16, 124, 40, rc.a.Z, -116, 19, -107, -100, i1.a.f31714u7, rc.a.W, 70, 59, pq.b.f46994k, i1.a.f31732w7, -29, -123, i1.a.f31741x7, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, i1.a.f31691r7, -52, 3, pq.b.f46991h, 8, -65, 64, -25, rc.a.f48411c0, -30, 121, 12, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, i1.a.B7, 122, 23, 102, -108, -95, 29, 61, -16, -34, -77, 11, 114, -89, 28, -17, -47, 83, 62, -113, 51, rc.a.Y, 95, -20, 118, 42, 73, -127, -120, -18, rc.a.V, -60, 26, -21, i1.a.E7, i1.a.f31699s7, 57, -103, i1.a.f31750y7, -83, 49, -117, 1, 24, 35, -35, 31, 78, rc.a.f48413e0, -7, 72, 79, -14, 101, -114, tc.a.f51065w, 92, o5.b.f42741j, 25, -115, -27, -104, 87, 103, 127, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, i1.a.f31759z7, -23, 104, 68, -32, 77, 67, 105, rc.a.f48409a0, rc.a.f48414f0, -84, 21, 89, -88, 10, -98, pq.b.f46992i, 71, -33, 52, 53, 106, i1.a.A7, -36, 34, i1.a.f31723v7, i1.a.f31667o7, -101, -119, -44, -19, -85, 18, -94, 13, 82, -69, 2, 47, -87, -41, 97, 30, -76, jt.l.f36951s, 4, -10, i1.a.f31683q7, 22, rc.a.X, -122, 86, 85, 9, -66, -111}};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25562k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25563l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f25564m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25565n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f25566o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f25567p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f25568q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f25569r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f25570s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f25571t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f25572u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f25573v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f25574w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f25575x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f25576y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f25577z = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f25583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f25584g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25578a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f25579b = new int[256];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f25580c = new int[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25581d = new int[256];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f25582e = new int[256];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25585h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f25586i = null;

    public n1() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i10 = 0; i10 < 256; i10++) {
            byte[][] bArr = f25561j;
            int i11 = bArr[0][i10] & 255;
            iArr[0] = i11;
            iArr2[0] = j(i11) & 255;
            iArr3[0] = k(i11) & 255;
            int i12 = bArr[1][i10] & 255;
            iArr[1] = i12;
            iArr2[1] = j(i12) & 255;
            iArr3[1] = k(i12) & 255;
            this.f25579b[i10] = iArr[1] | (iArr2[1] << 8) | (iArr3[1] << 16) | (iArr3[1] << 24);
            this.f25580c[i10] = iArr3[0] | (iArr3[0] << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            this.f25581d[i10] = (iArr3[1] << 24) | iArr2[1] | (iArr3[1] << 8) | (iArr[1] << 16);
            this.f25582e[i10] = iArr2[0] | (iArr[0] << 8) | (iArr3[0] << 16) | (iArr2[0] << 24);
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + kVar.getClass().getName());
        }
        this.f25578a = z10;
        byte[] bArrA = ((np.n1) kVar).a();
        this.f25586i = bArrA;
        int length = bArrA.length * 8;
        if (length != 128 && length != 192 && length != 256) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        this.f25585h = bArrA.length / 8;
        t(bArrA);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "Twofish";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (this.f25586i == null) {
            throw new IllegalStateException("Twofish not initialised");
        }
        if (i10 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.f25578a) {
            s(bArr, i10, bArr2, i11);
            return 16;
        }
        r(bArr, i10, bArr2, i11);
        return 16;
    }

    public final int e(int i10, int[] iArr) {
        int i11;
        int i12;
        int iN = n(i10);
        int iO = o(i10);
        int iP = p(i10);
        int iQ = q(i10);
        int i13 = iArr[0];
        int i14 = iArr[1];
        int i15 = iArr[2];
        int i16 = iArr[3];
        int i17 = this.f25585h & 3;
        if (i17 != 0) {
            if (i17 == 1) {
                int[] iArr2 = this.f25579b;
                byte[][] bArr = f25561j;
                i11 = (iArr2[(bArr[0][iN] & 255) ^ n(i13)] ^ this.f25580c[(bArr[0][iO] & 255) ^ o(i13)]) ^ this.f25581d[(bArr[1][iP] & 255) ^ p(i13)];
                i12 = this.f25582e[(bArr[1][iQ] & 255) ^ q(i13)];
                return i11 ^ i12;
            }
            if (i17 != 2) {
                if (i17 != 3) {
                    return 0;
                }
            }
            int[] iArr3 = this.f25579b;
            byte[][] bArr2 = f25561j;
            i11 = (iArr3[(bArr2[0][(bArr2[0][iN] & 255) ^ n(i14)] & 255) ^ n(i13)] ^ this.f25580c[(bArr2[0][(bArr2[1][iO] & 255) ^ o(i14)] & 255) ^ o(i13)]) ^ this.f25581d[(bArr2[1][(bArr2[0][iP] & 255) ^ p(i14)] & 255) ^ p(i13)];
            i12 = this.f25582e[(bArr2[1][(bArr2[1][iQ] & 255) ^ q(i14)] & 255) ^ q(i13)];
            return i11 ^ i12;
        }
        byte[][] bArr3 = f25561j;
        iN = (bArr3[1][iN] & 255) ^ n(i16);
        iO = (bArr3[0][iO] & 255) ^ o(i16);
        iP = (bArr3[0][iP] & 255) ^ p(i16);
        iQ = (bArr3[1][iQ] & 255) ^ q(i16);
        byte[][] bArr4 = f25561j;
        iN = (bArr4[1][iN] & 255) ^ n(i15);
        iO = (bArr4[1][iO] & 255) ^ o(i15);
        iP = (bArr4[0][iP] & 255) ^ p(i15);
        iQ = (bArr4[0][iQ] & 255) ^ q(i15);
        int[] iArr32 = this.f25579b;
        byte[][] bArr22 = f25561j;
        i11 = (iArr32[(bArr22[0][(bArr22[0][iN] & 255) ^ n(i14)] & 255) ^ n(i13)] ^ this.f25580c[(bArr22[0][(bArr22[1][iO] & 255) ^ o(i14)] & 255) ^ o(i13)]) ^ this.f25581d[(bArr22[1][(bArr22[0][iP] & 255) ^ p(i14)] & 255) ^ p(i13)];
        i12 = this.f25582e[(bArr22[1][(bArr22[1][iQ] & 255) ^ q(i14)] & 255) ^ q(i13)];
        return i11 ^ i12;
    }

    public final int f(int i10) {
        int[] iArr = this.f25584g;
        return iArr[(((i10 >>> 24) & 255) * 2) + 513] ^ ((iArr[((i10 & 255) * 2) + 0] ^ iArr[(((i10 >>> 8) & 255) * 2) + 1]) ^ iArr[(((i10 >>> 16) & 255) * 2) + 512]);
    }

    public final int g(int i10) {
        int[] iArr = this.f25584g;
        return iArr[(((i10 >>> 16) & 255) * 2) + 513] ^ ((iArr[(((i10 >>> 24) & 255) * 2) + 0] ^ iArr[((i10 & 255) * 2) + 1]) ^ iArr[(((i10 >>> 8) & 255) * 2) + 512]);
    }

    public final int h(int i10) {
        return ((i10 & 1) != 0 ? 180 : 0) ^ (i10 >> 1);
    }

    public final int i(int i10) {
        return ((i10 >> 2) ^ ((i10 & 2) != 0 ? 180 : 0)) ^ ((i10 & 1) != 0 ? 90 : 0);
    }

    public final int j(int i10) {
        return i10 ^ i(i10);
    }

    public final int k(int i10) {
        return i(i10) ^ (h(i10) ^ i10);
    }

    public final int l(int i10, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            i11 = m(i11);
        }
        int iM = i10 ^ i11;
        for (int i13 = 0; i13 < 4; i13++) {
            iM = m(iM);
        }
        return iM;
    }

    public final int m(int i10) {
        int i11 = (i10 >>> 24) & 255;
        int i12 = ((i11 << 1) ^ ((i11 & 128) != 0 ? 333 : 0)) & 255;
        int i13 = ((i11 >>> 1) ^ ((i11 & 1) != 0 ? 166 : 0)) ^ i12;
        return ((((i10 << 8) ^ (i13 << 24)) ^ (i12 << 16)) ^ (i13 << 8)) ^ i11;
    }

    public final int n(int i10) {
        return i10 & 255;
    }

    public final int o(int i10) {
        return (i10 >>> 8) & 255;
    }

    public final int p(int i10) {
        return (i10 >>> 16) & 255;
    }

    public final int q(int i10) {
        return (i10 >>> 24) & 255;
    }

    public final void r(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iR = org.bouncycastle.util.o.r(bArr, i10) ^ this.f25583f[4];
        int iR2 = org.bouncycastle.util.o.r(bArr, i10 + 4) ^ this.f25583f[5];
        int iR3 = org.bouncycastle.util.o.r(bArr, i10 + 8) ^ this.f25583f[6];
        int iR4 = org.bouncycastle.util.o.r(bArr, i10 + 12) ^ this.f25583f[7];
        int i12 = 39;
        int i13 = 0;
        while (i13 < 16) {
            int iF = f(iR);
            int iG = g(iR2);
            int i14 = i12 - 1;
            int i15 = iR4 ^ (((iG * 2) + iF) + this.f25583f[i12]);
            int i16 = iF + iG;
            int i17 = i14 - 1;
            iR3 = org.bouncycastle.util.j.e(iR3, 1) ^ (i16 + this.f25583f[i14]);
            iR4 = org.bouncycastle.util.j.f(i15, 1);
            int iF2 = f(iR3);
            int iG2 = g(iR4);
            int i18 = i17 - 1;
            int i19 = iR2 ^ (((iG2 * 2) + iF2) + this.f25583f[i17]);
            iR = org.bouncycastle.util.j.e(iR, 1) ^ ((iF2 + iG2) + this.f25583f[i18]);
            iR2 = org.bouncycastle.util.j.f(i19, 1);
            i13 += 2;
            i12 = i18 - 1;
        }
        org.bouncycastle.util.o.m(this.f25583f[0] ^ iR3, bArr2, i11);
        org.bouncycastle.util.o.m(iR4 ^ this.f25583f[1], bArr2, i11 + 4);
        org.bouncycastle.util.o.m(this.f25583f[2] ^ iR, bArr2, i11 + 8);
        org.bouncycastle.util.o.m(this.f25583f[3] ^ iR2, bArr2, i11 + 12);
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        byte[] bArr = this.f25586i;
        if (bArr != null) {
            t(bArr);
        }
    }

    public final void s(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12 = 0;
        int iR = org.bouncycastle.util.o.r(bArr, i10) ^ this.f25583f[0];
        int iR2 = org.bouncycastle.util.o.r(bArr, i10 + 4) ^ this.f25583f[1];
        int iR3 = org.bouncycastle.util.o.r(bArr, i10 + 8) ^ this.f25583f[2];
        int iR4 = org.bouncycastle.util.o.r(bArr, i10 + 12) ^ this.f25583f[3];
        int i13 = 8;
        while (i12 < 16) {
            int iF = f(iR);
            int iG = g(iR2);
            int i14 = i13 + 1;
            iR3 = org.bouncycastle.util.j.f(iR3 ^ ((iF + iG) + this.f25583f[i13]), 1);
            int i15 = iF + (iG * 2);
            int i16 = i14 + 1;
            iR4 = org.bouncycastle.util.j.e(iR4, 1) ^ (i15 + this.f25583f[i14]);
            int iF2 = f(iR3);
            int iG2 = g(iR4);
            int i17 = i16 + 1;
            iR = org.bouncycastle.util.j.f(iR ^ ((iF2 + iG2) + this.f25583f[i16]), 1);
            iR2 = org.bouncycastle.util.j.e(iR2, 1) ^ ((iF2 + (iG2 * 2)) + this.f25583f[i17]);
            i12 += 2;
            i13 = i17 + 1;
        }
        org.bouncycastle.util.o.m(this.f25583f[4] ^ iR3, bArr2, i11);
        org.bouncycastle.util.o.m(iR4 ^ this.f25583f[5], bArr2, i11 + 4);
        org.bouncycastle.util.o.m(this.f25583f[6] ^ iR, bArr2, i11 + 8);
        org.bouncycastle.util.o.m(this.f25583f[7] ^ iR2, bArr2, i11 + 12);
    }

    public final void t(byte[] bArr) {
        int iN;
        int iO;
        int iP;
        int iQ;
        int iP2;
        int iO2;
        int iN2;
        int iQ2;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.f25583f = new int[40];
        for (int i10 = 0; i10 < this.f25585h; i10++) {
            int i11 = i10 * 8;
            iArr[i10] = org.bouncycastle.util.o.r(bArr, i11);
            iArr2[i10] = org.bouncycastle.util.o.r(bArr, i11 + 4);
            iArr3[(this.f25585h - 1) - i10] = l(iArr[i10], iArr2[i10]);
        }
        for (int i12 = 0; i12 < 20; i12++) {
            int i13 = Q * i12;
            int iE = e(i13, iArr);
            int iE2 = org.bouncycastle.util.j.e(e(i13 + 16843009, iArr2), 8);
            int i14 = iE + iE2;
            int[] iArr4 = this.f25583f;
            int i15 = i12 * 2;
            iArr4[i15] = i14;
            int i16 = i14 + iE2;
            iArr4[i15 + 1] = (i16 << 9) | (i16 >>> 23);
        }
        int i17 = iArr3[0];
        int i18 = iArr3[1];
        int i19 = 2;
        int i20 = iArr3[2];
        int i21 = iArr3[3];
        this.f25584g = new int[1024];
        int i22 = 0;
        while (i22 < 256) {
            int i23 = this.f25585h & 3;
            if (i23 != 0) {
                if (i23 == 1) {
                    int[] iArr5 = this.f25584g;
                    int i24 = i22 * 2;
                    int[] iArr6 = this.f25579b;
                    byte[][] bArr2 = f25561j;
                    iArr5[i24] = iArr6[(bArr2[0][i22] & 255) ^ n(i17)];
                    this.f25584g[i24 + 1] = this.f25580c[(bArr2[0][i22] & 255) ^ o(i17)];
                    this.f25584g[i24 + 512] = this.f25581d[(bArr2[1][i22] & 255) ^ p(i17)];
                    this.f25584g[i24 + 513] = this.f25582e[(bArr2[1][i22] & 255) ^ q(i17)];
                } else if (i23 == i19) {
                    iQ2 = i22;
                    iN2 = iQ2;
                    iO2 = iN2;
                    iP2 = iO2;
                    int[] iArr7 = this.f25584g;
                    int i25 = i22 * 2;
                    int[] iArr8 = this.f25579b;
                    byte[][] bArr3 = f25561j;
                    iArr7[i25] = iArr8[(bArr3[0][(bArr3[0][iN2] & 255) ^ n(i18)] & 255) ^ n(i17)];
                    this.f25584g[i25 + 1] = this.f25580c[(bArr3[0][(bArr3[1][iO2] & 255) ^ o(i18)] & 255) ^ o(i17)];
                    this.f25584g[i25 + 512] = this.f25581d[(bArr3[1][(bArr3[0][iP2] & 255) ^ p(i18)] & 255) ^ p(i17)];
                    this.f25584g[i25 + 513] = this.f25582e[(bArr3[1][(bArr3[1][iQ2] & 255) ^ q(i18)] & 255) ^ q(i17)];
                } else if (i23 == 3) {
                    iQ = i22;
                    iN = iQ;
                    iO = iN;
                    iP = iO;
                }
                i22++;
                i19 = 2;
            } else {
                byte[][] bArr4 = f25561j;
                iN = (bArr4[1][i22] & 255) ^ n(i21);
                iO = (bArr4[0][i22] & 255) ^ o(i21);
                iP = (bArr4[0][i22] & 255) ^ p(i21);
                iQ = (bArr4[1][i22] & 255) ^ q(i21);
            }
            byte[][] bArr5 = f25561j;
            iN2 = (bArr5[1][iN] & 255) ^ n(i20);
            iO2 = (bArr5[1][iO] & 255) ^ o(i20);
            iP2 = (bArr5[0][iP] & 255) ^ p(i20);
            iQ2 = (bArr5[0][iQ] & 255) ^ q(i20);
            int[] iArr72 = this.f25584g;
            int i252 = i22 * 2;
            int[] iArr82 = this.f25579b;
            byte[][] bArr32 = f25561j;
            iArr72[i252] = iArr82[(bArr32[0][(bArr32[0][iN2] & 255) ^ n(i18)] & 255) ^ n(i17)];
            this.f25584g[i252 + 1] = this.f25580c[(bArr32[0][(bArr32[1][iO2] & 255) ^ o(i18)] & 255) ^ o(i17)];
            this.f25584g[i252 + 512] = this.f25581d[(bArr32[1][(bArr32[0][iP2] & 255) ^ p(i18)] & 255) ^ p(i17)];
            this.f25584g[i252 + 513] = this.f25582e[(bArr32[1][(bArr32[1][iQ2] & 255) ^ q(i18)] & 255) ^ q(i17)];
            i22++;
            i19 = 2;
        }
    }
}
