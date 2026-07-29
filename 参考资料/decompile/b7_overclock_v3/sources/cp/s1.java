package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class s1 implements org.bouncycastle.crypto.k0, org.bouncycastle.util.m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f25649h = {62, 114, 91, 71, i1.a.f31732w7, -32, 0, 51, 4, -47, 84, -104, 9, -71, 109, i1.a.f31741x7, 123, 27, -7, 50, -81, -99, 106, -91, -72, rc.a.f48413e0, -4, 29, 8, 83, 3, -112, 77, 78, -124, -103, -28, i1.a.f31759z7, i1.a.E7, -111, -35, -74, -123, 72, -117, rc.a.f48409a0, pq.b.f46992i, -84, i1.a.f31750y7, i1.a.f31675p7, -8, 30, 115, 67, 105, i1.a.f31707t7, -75, -67, -3, 57, 99, 32, -44, 56, 118, 125, -78, -89, i1.a.A7, -19, 87, i1.a.f31699s7, -13, rc.a.f48412d0, -69, 20, rc.a.V, 6, 85, -101, -29, -17, 94, 49, 79, 127, 90, -92, 13, -126, 81, 73, 95, -70, o5.b.f42741j, 28, 74, 22, -43, 23, -88, -110, rc.a.W, 31, -116, -1, i1.a.f31659n7, -82, rc.a.f48414f0, 1, -45, -83, 59, 75, i1.a.B7, 70, -21, i1.a.f31723v7, -34, -102, -113, -121, -41, 58, -128, pq.b.f46991h, 47, -56, -79, -76, 55, -9, 10, 34, 19, 40, 124, -52, 60, -119, i1.a.f31714u7, i1.a.f31691r7, -106, 86, 7, -65, 126, -16, 11, rc.a.f48411c0, -105, 82, 53, 65, 121, 97, -90, 76, 16, -2, rp.u.f49086t, rc.a.Y, -107, -120, -118, -80, -93, -5, i1.a.f31667o7, 24, -108, -14, -31, -27, -23, 93, -48, -36, 17, 102, 100, 92, -20, 89, 66, 117, 18, -11, 116, -100, -86, 35, 14, -122, -85, -66, 42, 2, -25, 103, -26, 68, -94, 108, i1.a.f31683q7, -109, -97, -15, -10, -6, 54, -46, jt.l.f36951s, 104, -98, 98, pq.b.f46993j, 21, 61, -42, 64, -60, -30, 15, -114, -125, 119, 107, rc.a.X, 5, okio.w0.f44229a, 12, jt.l.f36949q, -22, pq.b.f46994k, -73, -95, -24, -87, 101, -115, rc.a.Z, 26, -37, -127, -77, -96, -12, 69, 122, 25, -33, -18, tc.a.f51065w, 52, jt.l.f36952t};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f25650i = {85, i1.a.f31683q7, 99, pq.b.f46993j, 59, -56, 71, -122, -97, 60, i1.a.B7, 91, rc.a.f48409a0, -86, -3, 119, -116, i1.a.f31699s7, -108, 12, -90, 26, 19, 0, -29, -88, 22, 114, 64, -7, -8, 66, 68, rc.a.Y, 104, -106, -127, i1.a.E7, 69, 62, 16, 118, i1.a.f31707t7, -89, -117, 57, 67, -31, 58, -75, 86, 42, i1.a.f31667o7, 109, -77, 5, 34, 102, -65, -36, 11, -6, 98, 72, -35, 32, 17, 6, 54, i1.a.f31723v7, i1.a.f31675p7, i1.a.A7, -10, rc.a.Z, 82, -69, 105, -11, -44, -121, 127, -124, 76, -46, -100, 87, -92, rp.u.f49086t, 79, -102, -33, -2, -42, -115, 122, -21, rc.a.f48411c0, 83, i1.a.f31659n7, 92, -95, 20, 23, -5, 35, -43, 125, jt.l.f36949q, 103, 115, 8, 9, -18, -73, pq.b.f46994k, okio.w0.f44229a, 97, -78, 25, -114, 78, -27, 75, -109, -113, 93, -37, -87, -83, -15, -82, rc.a.f48414f0, i1.a.f31741x7, 13, -4, -12, rc.a.f48413e0, 70, pq.b.f46992i, 29, -105, -24, -47, -23, 77, 55, -91, 117, 94, -125, -98, -85, -126, -99, -71, 28, -32, i1.a.f31750y7, 73, -119, 1, -74, -67, o5.b.f42741j, rc.a.W, -94, 95, 56, tc.a.f51065w, -103, 21, -112, jt.l.f36951s, -72, -107, -28, -48, -111, i1.a.f31714u7, i1.a.f31759z7, -19, 15, -76, pq.b.f46991h, -96, -52, -16, 2, 74, 121, i1.a.f31691r7, -34, -93, -17, -22, 81, -26, 107, 24, -20, 27, rc.a.f48412d0, -128, -9, 116, -25, -1, rc.a.V, 90, 106, 84, 30, 65, 49, -110, 53, -60, 51, 7, 10, -70, 126, 14, 52, -120, -79, -104, 124, -13, 61, jt.l.f36952t, 108, 123, i1.a.f31732w7, -45, 31, 50, 101, 4, 40, 100, -66, -123, -101, 47, 89, -118, -41, -80, rc.a.X, -84, -81, 18, 3, -30, -14};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final short[] f25651j = {17623, 9916, 25195, 4958, 22409, 13794, 28981, 2479, 19832, 12051, 27588, 6897, 24102, 15437, 30874, 18348};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f25652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f25653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f25654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f25656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s1 f25658g;

    public s1() {
        this.f25652a = new int[16];
        this.f25653b = new int[2];
        this.f25654c = new int[4];
        this.f25656e = new byte[4];
    }

    public s1(s1 s1Var) {
        this.f25652a = new int[16];
        this.f25653b = new int[2];
        this.f25654c = new int[4];
        this.f25656e = new byte[4];
        i(s1Var);
    }

    public static int k(int i10) {
        return r(i10, 24) ^ (((r(i10, 2) ^ i10) ^ r(i10, 10)) ^ r(i10, 18));
    }

    public static int l(int i10) {
        return r(i10, 30) ^ (((r(i10, 8) ^ i10) ^ r(i10, 14)) ^ r(i10, 22));
    }

    public static int o(byte b10, short s10, byte b11) {
        return ((b10 & 255) << 23) | ((s10 & kotlin.v1.f38215d) << 8) | (b11 & 255);
    }

    public static int p(byte b10, byte b11, byte b12, byte b13) {
        return ((b10 & 255) << 24) | ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255);
    }

    public static int q(int i10, int i11) {
        return ((i10 >>> (31 - i11)) | (i10 << i11)) & Integer.MAX_VALUE;
    }

    public static int r(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public static void s(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >> 24);
        bArr[i11 + 1] = (byte) (i10 >> 16);
        bArr[i11 + 2] = (byte) (i10 >> 8);
        bArr[i11 + 3] = (byte) i10;
    }

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        byte[] bArrA;
        if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            bArrA = v1Var.a();
            kVar = v1Var.b();
        } else {
            bArrA = null;
        }
        byte[] bArrA2 = kVar instanceof np.n1 ? ((np.n1) kVar).a() : null;
        this.f25655d = 0;
        this.f25657f = 0;
        w(bArrA2, bArrA);
        this.f25658g = (s1) d();
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "Zuc-128";
    }

    public final int c(int i10, int i11) {
        int i12 = i10 + i11;
        return (Integer.MAX_VALUE & i12) + (i12 >>> 31);
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new s1(this);
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (this.f25658g == null) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            bArr2[i13 + i12] = f(bArr[i13 + i10]);
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public byte f(byte b10) {
        if (this.f25655d == 0) {
            u();
        }
        byte[] bArr = this.f25656e;
        int i10 = this.f25655d;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        this.f25655d = (i10 + 1) % 4;
        return b11;
    }

    public final void g() {
        int[] iArr = this.f25654c;
        int[] iArr2 = this.f25652a;
        iArr[0] = ((iArr2[15] & 2147450880) << 1) | (iArr2[14] & 65535);
        iArr[1] = ((iArr2[11] & 65535) << 16) | (iArr2[9] >>> 15);
        iArr[2] = ((iArr2[7] & 65535) << 16) | (iArr2[5] >>> 15);
        iArr[3] = (iArr2[0] >>> 15) | ((iArr2[2] & 65535) << 16);
    }

    public int h() {
        int[] iArr = this.f25654c;
        int i10 = iArr[0];
        int[] iArr2 = this.f25653b;
        int i11 = (i10 ^ iArr2[0]) + iArr2[1];
        int i12 = iArr2[0] + iArr[1];
        int i13 = iArr[2] ^ iArr2[1];
        int iK = k((i12 << 16) | (i13 >>> 16));
        int iL = l((i13 << 16) | (i12 >>> 16));
        int[] iArr3 = this.f25653b;
        byte[] bArr = f25649h;
        byte b10 = bArr[iK >>> 24];
        byte[] bArr2 = f25650i;
        iArr3[0] = p(b10, bArr2[(iK >>> 16) & 255], bArr[(iK >>> 8) & 255], bArr2[iK & 255]);
        this.f25653b[1] = p(bArr[iL >>> 24], bArr2[(iL >>> 16) & 255], bArr[(iL >>> 8) & 255], bArr2[iL & 255]);
        return i11;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        s1 s1Var = (s1) mVar;
        int[] iArr = s1Var.f25652a;
        int[] iArr2 = this.f25652a;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = s1Var.f25653b;
        int[] iArr4 = this.f25653b;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        int[] iArr5 = s1Var.f25654c;
        int[] iArr6 = this.f25654c;
        System.arraycopy(iArr5, 0, iArr6, 0, iArr6.length);
        byte[] bArr = s1Var.f25656e;
        byte[] bArr2 = this.f25656e;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f25655d = s1Var.f25655d;
        this.f25657f = s1Var.f25657f;
        this.f25658g = s1Var;
    }

    public final void m(int i10) {
        int[] iArr = this.f25652a;
        int iC = c(c(c(c(c(c(iArr[0], q(iArr[0], 8)), q(this.f25652a[4], 20)), q(this.f25652a[10], 21)), q(this.f25652a[13], 17)), q(this.f25652a[15], 15)), i10);
        int[] iArr2 = this.f25652a;
        iArr2[0] = iArr2[1];
        iArr2[1] = iArr2[2];
        iArr2[2] = iArr2[3];
        iArr2[3] = iArr2[4];
        iArr2[4] = iArr2[5];
        iArr2[5] = iArr2[6];
        iArr2[6] = iArr2[7];
        iArr2[7] = iArr2[8];
        iArr2[8] = iArr2[9];
        iArr2[9] = iArr2[10];
        iArr2[10] = iArr2[11];
        iArr2[11] = iArr2[12];
        iArr2[12] = iArr2[13];
        iArr2[13] = iArr2[14];
        iArr2[14] = iArr2[15];
        iArr2[15] = iC;
    }

    public final void n() {
        int[] iArr = this.f25652a;
        int iC = c(c(c(c(c(iArr[0], q(iArr[0], 8)), q(this.f25652a[4], 20)), q(this.f25652a[10], 21)), q(this.f25652a[13], 17)), q(this.f25652a[15], 15));
        int[] iArr2 = this.f25652a;
        iArr2[0] = iArr2[1];
        iArr2[1] = iArr2[2];
        iArr2[2] = iArr2[3];
        iArr2[3] = iArr2[4];
        iArr2[4] = iArr2[5];
        iArr2[5] = iArr2[6];
        iArr2[6] = iArr2[7];
        iArr2[7] = iArr2[8];
        iArr2[8] = iArr2[9];
        iArr2[9] = iArr2[10];
        iArr2[10] = iArr2[11];
        iArr2[11] = iArr2[12];
        iArr2[12] = iArr2[13];
        iArr2[13] = iArr2[14];
        iArr2[14] = iArr2[15];
        iArr2[15] = iC;
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        s1 s1Var = this.f25658g;
        if (s1Var != null) {
            i(s1Var);
        }
    }

    public int t() {
        return 2047;
    }

    public final void u() {
        s(v(), this.f25656e, 0);
    }

    public int v() {
        int i10 = this.f25657f;
        this.f25657f = i10 + 1;
        if (i10 >= t()) {
            throw new IllegalStateException("Too much data processed by singleKey/IV");
        }
        g();
        int iH = h() ^ this.f25654c[3];
        n();
        return iH;
    }

    public final void w(byte[] bArr, byte[] bArr2) {
        x(this.f25652a, bArr, bArr2);
        int[] iArr = this.f25653b;
        iArr[0] = 0;
        iArr[1] = 0;
        int i10 = 32;
        while (true) {
            g();
            if (i10 <= 0) {
                h();
                n();
                return;
            } else {
                m(h() >>> 1);
                i10--;
            }
        }
    }

    public void x(int[] iArr, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("A key of 16 bytes is needed");
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("An IV of 16 bytes is needed");
        }
        int[] iArr2 = this.f25652a;
        byte b10 = bArr[0];
        short[] sArr = f25651j;
        iArr2[0] = o(b10, sArr[0], bArr2[0]);
        this.f25652a[1] = o(bArr[1], sArr[1], bArr2[1]);
        this.f25652a[2] = o(bArr[2], sArr[2], bArr2[2]);
        this.f25652a[3] = o(bArr[3], sArr[3], bArr2[3]);
        this.f25652a[4] = o(bArr[4], sArr[4], bArr2[4]);
        this.f25652a[5] = o(bArr[5], sArr[5], bArr2[5]);
        this.f25652a[6] = o(bArr[6], sArr[6], bArr2[6]);
        this.f25652a[7] = o(bArr[7], sArr[7], bArr2[7]);
        this.f25652a[8] = o(bArr[8], sArr[8], bArr2[8]);
        this.f25652a[9] = o(bArr[9], sArr[9], bArr2[9]);
        this.f25652a[10] = o(bArr[10], sArr[10], bArr2[10]);
        this.f25652a[11] = o(bArr[11], sArr[11], bArr2[11]);
        this.f25652a[12] = o(bArr[12], sArr[12], bArr2[12]);
        this.f25652a[13] = o(bArr[13], sArr[13], bArr2[13]);
        this.f25652a[14] = o(bArr[14], sArr[14], bArr2[14]);
        this.f25652a[15] = o(bArr[15], sArr[15], bArr2[15]);
    }
}
