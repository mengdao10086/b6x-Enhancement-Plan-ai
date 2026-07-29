package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class e1 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25264c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f25265d = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, i1.a.f31683q7, 40, -5, rc.a.f48412d0, 5, rc.a.f48411c0, 103, -102, 118, 42, -66, 4, i1.a.f31691r7, -86, 68, 19, rc.a.Y, 73, -122, 6, -103, -100, 66, jt.l.f36951s, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, i1.a.A7, -84, 98, -28, -77, 28, -87, i1.a.f31723v7, 8, -24, -107, -128, -33, -108, -6, 117, -113, okio.w0.f44229a, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, pq.b.f46993j, 100, i1.a.B7, -117, -8, -21, 15, 75, pq.b.f46994k, 86, -99, 53, 30, rc.a.W, 14, 94, 99, o5.b.f42741j, -47, -94, rc.a.X, 34, 124, 59, 1, rc.a.V, tc.a.f51065w, -121, -44, 0, 70, 87, -97, -45, rc.a.Z, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, i1.a.f31714u7, 56, -75, -93, -9, -14, i1.a.f31759z7, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, jt.l.f36949q, -11, -116, -79, -29, 29, -10, -30, rc.a.f48414f0, -126, 102, i1.a.f31732w7, jt.l.f36952t, i1.a.f31667o7, rc.a.f48409a0, 35, -85, 13, 83, 78, pq.b.f46991h, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, rp.u.f49086t, 127, 17, i1.a.E7, 92, 65, 31, 16, 90, i1.a.f31659n7, 10, i1.a.f31675p7, 49, -120, -91, i1.a.f31750y7, 123, -67, rc.a.f48413e0, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, i1.a.f31699s7, pq.b.f46992i, i1.a.f31707t7, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, i1.a.f31741x7, 57, 72};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f25266e = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f25267f = {-1548633402, 1453994832, 1736282519, -1301273892};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f25268a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f25269b;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("invalid parameter passed to SM4 init - " + kVar.getClass().getName());
        }
        byte[] bArrA = ((np.n1) kVar).a();
        if (bArrA.length != 16) {
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        this.f25269b = m(z10, bArrA);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "SM4";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        if (this.f25269b == null) {
            throw new IllegalStateException("SM4 not initialised");
        }
        if (i10 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f25268a[0] = org.bouncycastle.util.o.a(bArr, i10);
        this.f25268a[1] = org.bouncycastle.util.o.a(bArr, i10 + 4);
        this.f25268a[2] = org.bouncycastle.util.o.a(bArr, i10 + 8);
        this.f25268a[3] = org.bouncycastle.util.o.a(bArr, i10 + 12);
        for (int i12 = 0; i12 < 32; i12 += 4) {
            int[] iArr = this.f25268a;
            iArr[0] = e(iArr, this.f25269b[i12]);
            int[] iArr2 = this.f25268a;
            iArr2[1] = f(iArr2, this.f25269b[i12 + 1]);
            int[] iArr3 = this.f25268a;
            iArr3[2] = g(iArr3, this.f25269b[i12 + 2]);
            int[] iArr4 = this.f25268a;
            iArr4[3] = h(iArr4, this.f25269b[i12 + 3]);
        }
        org.bouncycastle.util.o.h(this.f25268a[3], bArr2, i11);
        org.bouncycastle.util.o.h(this.f25268a[2], bArr2, i11 + 4);
        org.bouncycastle.util.o.h(this.f25268a[1], bArr2, i11 + 8);
        org.bouncycastle.util.o.h(this.f25268a[0], bArr2, i11 + 12);
        return 16;
    }

    public final int e(int[] iArr, int i10) {
        return k((iArr[3] ^ (iArr[1] ^ iArr[2])) ^ i10) ^ iArr[0];
    }

    public final int f(int[] iArr, int i10) {
        return k((iArr[0] ^ (iArr[2] ^ iArr[3])) ^ i10) ^ iArr[1];
    }

    public final int g(int[] iArr, int i10) {
        return k((iArr[1] ^ (iArr[3] ^ iArr[0])) ^ i10) ^ iArr[2];
    }

    public final int h(int[] iArr, int i10) {
        return k((iArr[2] ^ (iArr[0] ^ iArr[1])) ^ i10) ^ iArr[3];
    }

    public final int i(int i10) {
        return n(i10, 24) ^ (((n(i10, 2) ^ i10) ^ n(i10, 10)) ^ n(i10, 18));
    }

    public final int j(int i10) {
        return n(i10, 23) ^ (n(i10, 13) ^ i10);
    }

    public final int k(int i10) {
        return i(o(i10));
    }

    public final int l(int i10) {
        return j(o(i10));
    }

    public final int[] m(boolean z10, byte[] bArr) {
        int[] iArr = new int[32];
        int[] iArr2 = {org.bouncycastle.util.o.a(bArr, 0), org.bouncycastle.util.o.a(bArr, 4), org.bouncycastle.util.o.a(bArr, 8), org.bouncycastle.util.o.a(bArr, 12)};
        int i10 = iArr2[0];
        int[] iArr3 = f25267f;
        int[] iArr4 = {i10 ^ iArr3[0], iArr2[1] ^ iArr3[1], iArr2[2] ^ iArr3[2], iArr2[3] ^ iArr3[3]};
        if (z10) {
            int i11 = iArr4[0];
            int i12 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr5 = f25266e;
            iArr[0] = i11 ^ l(i12 ^ iArr5[0]);
            iArr[1] = iArr4[1] ^ l(((iArr4[2] ^ iArr4[3]) ^ iArr[0]) ^ iArr5[1]);
            iArr[2] = iArr4[2] ^ l(((iArr4[3] ^ iArr[0]) ^ iArr[1]) ^ iArr5[2]);
            iArr[3] = iArr4[3] ^ l(((iArr[0] ^ iArr[1]) ^ iArr[2]) ^ iArr5[3]);
            for (int i13 = 4; i13 < 32; i13++) {
                iArr[i13] = iArr[i13 - 4] ^ l(((iArr[i13 - 3] ^ iArr[i13 - 2]) ^ iArr[i13 - 1]) ^ f25266e[i13]);
            }
        } else {
            int i14 = iArr4[0];
            int i15 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr6 = f25266e;
            iArr[31] = i14 ^ l(i15 ^ iArr6[0]);
            iArr[30] = iArr4[1] ^ l(((iArr4[2] ^ iArr4[3]) ^ iArr[31]) ^ iArr6[1]);
            iArr[29] = iArr4[2] ^ l(((iArr4[3] ^ iArr[31]) ^ iArr[30]) ^ iArr6[2]);
            iArr[28] = iArr4[3] ^ l(((iArr[31] ^ iArr[30]) ^ iArr[29]) ^ iArr6[3]);
            for (int i16 = 27; i16 >= 0; i16--) {
                iArr[i16] = iArr[i16 + 4] ^ l(((iArr[i16 + 3] ^ iArr[i16 + 2]) ^ iArr[i16 + 1]) ^ f25266e[31 - i16]);
            }
        }
        return iArr;
    }

    public final int n(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    public final int o(int i10) {
        byte[] bArr = f25265d;
        return (bArr[i10 & 255] & 255) | ((bArr[(i10 >> 24) & 255] & 255) << 24) | ((bArr[(i10 >> 16) & 255] & 255) << 16) | ((bArr[(i10 >> 8) & 255] & 255) << 8);
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
