package cp;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class b1 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f25197m = 14;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25198n = 64;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f25199o = {0, 0, 25, 1, 50, 2, 26, i1.a.f31707t7, 75, i1.a.f31714u7, 27, 104, 51, -18, -33, 3, 100, 4, -32, 14, 52, -115, -127, -17, 76, pq.b.f46993j, 8, -56, -8, 105, 28, i1.a.f31675p7, 125, i1.a.f31683q7, 29, -75, -7, -71, rc.a.Z, 106, 77, -28, -90, 114, -102, i1.a.f31723v7, 9, tc.a.f51065w, 101, 47, -118, 5, rc.a.V, 15, -31, rc.a.W, 18, -16, -126, 69, 53, -109, i1.a.B7, -114, -106, -113, -37, -67, 54, -48, i1.a.f31759z7, -108, 19, 92, -46, -15, 64, 70, -125, 56, 102, -35, -3, jt.l.f36949q, -65, 6, -117, 98, -77, rc.a.X, -30, -104, 34, -120, -111, 16, 126, pq.b.f46992i, 72, i1.a.f31691r7, -93, -74, 30, 66, 58, 107, 40, 84, -6, -123, 61, -70, rc.a.f48411c0, 121, 10, 21, -101, -97, 94, i1.a.f31732w7, 78, -44, -84, -27, -13, 115, -89, 87, -81, o5.b.f42741j, -88, jt.l.f36951s, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, rc.a.f48412d0, -41, 117, 122, -21, 22, 11, -11, 89, i1.a.f31741x7, 95, -80, -100, -87, 81, -96, 127, 12, -10, pq.b.f46991h, 23, -60, 73, -20, i1.a.f31659n7, 67, 31, rc.a.f48413e0, -92, 118, 123, -73, -52, -69, 62, 90, -5, jt.l.f36952t, -79, -122, 59, 82, -95, 108, -86, 85, rc.a.f48409a0, -99, -105, -78, -121, -112, 97, -66, -36, -4, rp.u.f49086t, -107, i1.a.A7, i1.a.f31750y7, 55, okio.w0.f44229a, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, 20, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, i1.a.E7, 35, 32, rc.a.f48414f0, -119, -76, 124, -72, rc.a.Y, 119, -103, -29, -91, 103, 74, -19, -34, i1.a.f31699s7, 49, -2, 24, 13, 99, -116, -128, i1.a.f31667o7, -9, pq.b.f46994k, 7};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f25200p = {0, 3, 5, 15, 17, 51, 85, -1, 26, rc.a.f48414f0, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, i1.a.f31659n7, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, rc.a.Y, 106, -66, i1.a.E7, pq.b.f46994k, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, pq.b.f46992i, -78, i1.a.f31750y7, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, tc.a.f51065w, -120, -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, -77, i1.a.f31759z7, 73, -37, 118, -102, -75, -60, 87, -7, 16, jt.l.f36949q, jt.l.f36951s, -16, 11, 29, rc.a.Z, 105, -69, -42, 97, -93, -2, 25, rc.a.f48411c0, 125, -121, -110, -83, -20, 47, pq.b.f46993j, -109, -82, -23, 32, jt.l.f36952t, -96, -5, 22, 58, 78, -46, 109, -73, i1.a.f31683q7, 93, -25, 50, 86, -6, 21, okio.w0.f44229a, 65, i1.a.f31691r7, 94, -30, 61, 71, i1.a.f31723v7, 64, i1.a.f31667o7, 91, -19, rc.a.f48412d0, 116, -100, -65, i1.a.B7, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, rp.u.f49086t, -33, 122, -114, -119, -128, -101, -74, i1.a.f31675p7, o5.b.f42741j, -24, 35, 101, -81, -22, rc.a.X, pq.b.f46991h, -79, -56, 67, i1.a.f31699s7, 84, -4, 31, rc.a.V, 99, -91, -12, 7, 9, 27, rc.a.f48413e0, 119, -103, -80, i1.a.f31741x7, 70, i1.a.f31732w7, 69, i1.a.A7, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, i1.a.f31707t7, 81, -13, 14, 18, 54, 90, -18, rc.a.f48409a0, 123, -115, -116, -113, -118, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, rc.a.W, 108, -76, i1.a.f31714u7, 82, -10, 1, 3, 5, 15, 17, 51, 85, -1, 26, rc.a.f48414f0, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, i1.a.f31659n7, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, rc.a.Y, 106, -66, i1.a.E7, pq.b.f46994k, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, pq.b.f46992i, -78, i1.a.f31750y7, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, tc.a.f51065w, -120, -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, -77, i1.a.f31759z7, 73, -37, 118, -102, -75, -60, 87, -7, 16, jt.l.f36949q, jt.l.f36951s, -16, 11, 29, rc.a.Z, 105, -69, -42, 97, -93, -2, 25, rc.a.f48411c0, 125, -121, -110, -83, -20, 47, pq.b.f46993j, -109, -82, -23, 32, jt.l.f36952t, -96, -5, 22, 58, 78, -46, 109, -73, i1.a.f31683q7, 93, -25, 50, 86, -6, 21, okio.w0.f44229a, 65, i1.a.f31691r7, 94, -30, 61, 71, i1.a.f31723v7, 64, i1.a.f31667o7, 91, -19, rc.a.f48412d0, 116, -100, -65, i1.a.B7, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, rp.u.f49086t, -33, 122, -114, -119, -128, -101, -74, i1.a.f31675p7, o5.b.f42741j, -24, 35, 101, -81, -22, rc.a.X, pq.b.f46991h, -79, -56, 67, i1.a.f31699s7, 84, -4, 31, rc.a.V, 99, -91, -12, 7, 9, 27, rc.a.f48413e0, 119, -103, -80, i1.a.f31741x7, 70, i1.a.f31732w7, 69, i1.a.A7, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, i1.a.f31707t7, 81, -13, 14, 18, 54, 90, -18, rc.a.f48409a0, 123, -115, -116, -113, -118, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, rc.a.W, 108, -76, i1.a.f31714u7, 82, -10, 1};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte[] f25201q = {99, 124, 119, 123, -14, 107, pq.b.f46991h, i1.a.f31699s7, jt.l.f36949q, 1, 103, rc.a.f48411c0, -2, -41, -85, 118, i1.a.f31732w7, -126, i1.a.f31723v7, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, i1.a.f31667o7, -73, -3, -109, rc.a.Y, 54, okio.w0.f44229a, -9, -52, 52, -91, -27, -15, pq.b.f46993j, i1.a.f31659n7, 49, 21, 4, i1.a.f31714u7, 35, i1.a.f31691r7, 24, -106, 5, -102, 7, 18, -128, -30, -21, rc.a.Z, -78, 117, 9, -125, rc.a.f48412d0, 26, 27, pq.b.f46992i, 90, -96, 82, 59, -42, -77, rc.a.f48409a0, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, i1.a.f31741x7, -66, 57, 74, 76, o5.b.f42741j, i1.a.A7, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, jt.l.f36951s, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, rp.u.f49086t, -74, i1.a.B7, rc.a.V, 16, -1, -13, -46, i1.a.f31750y7, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, jt.l.f36952t, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, rc.a.W, 92, i1.a.f31683q7, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, tc.a.f51065w, rc.a.X, rc.a.f48414f0, 28, -90, -76, i1.a.f31707t7, -24, -35, 116, 31, 75, -67, -117, -118, pq.b.f46994k, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, i1.a.f31675p7, 29, -98, -31, -8, -104, 17, 105, i1.a.E7, -114, -108, -101, 30, -121, -23, i1.a.f31759z7, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, rc.a.f48413e0, 15, -80, 84, -69, 22};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte[] f25202r = {82, 9, 106, -43, jt.l.f36949q, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, i1.a.f31741x7, 84, 123, -108, 50, -90, i1.a.f31683q7, 35, 61, -18, 76, -107, 11, 66, -6, i1.a.f31691r7, 78, 8, rc.a.f48414f0, -95, 102, 40, i1.a.E7, rc.a.W, -78, 118, 91, -94, 73, 109, -117, -47, rc.a.X, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, pq.b.f46994k, 72, jt.l.f36951s, -3, -19, -71, i1.a.B7, 94, 21, 70, 87, -89, -115, -99, -124, -112, i1.a.f31659n7, -85, 0, -116, rp.u.f49086t, -45, 10, -9, -28, o5.b.f42741j, 5, -72, -77, 69, 6, -48, rc.a.f48412d0, 30, -113, i1.a.f31732w7, okio.w0.f44229a, 15, 2, i1.a.f31675p7, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, i1.a.A7, i1.a.f31759z7, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, pq.b.f46992i, 71, -15, 26, pq.b.f46993j, 29, rc.a.f48409a0, i1.a.f31699s7, -119, pq.b.f46991h, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, i1.a.f31707t7, -46, 121, 32, -102, -37, i1.a.f31667o7, -2, tc.a.f51065w, i1.a.f31750y7, 90, -12, 31, -35, -88, 51, -120, 7, i1.a.f31714u7, 49, -79, 18, 16, 89, rc.a.Z, -128, -20, 95, jt.l.f36952t, 81, 127, -87, 25, -75, 74, 13, rc.a.f48413e0, -27, 122, -97, -109, i1.a.f31723v7, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, rc.a.f48411c0, 4, 126, -70, 119, -42, rc.a.Y, -31, 105, 20, 99, 85, rc.a.V, 12, 125};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f25203s = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, rc.c.f48463k0, 53, 106, 212, 179, 125, 250, 239, 197, 145};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static byte[][] f25204t = {new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 32}, new byte[]{0, 8, 24, 32}};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static byte[][] f25205u = {new byte[]{0, 24, 16, 8}, new byte[]{0, 32, 24, 16}, new byte[]{0, 40, 32, 24}, new byte[]{0, jt.l.f36949q, 40, 24}, new byte[]{0, 56, 40, 32}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f25207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[][] f25210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f25211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f25212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f25213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f25214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f25215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f25216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f25217l;

    public b1() {
        this(128);
    }

    public b1(int i10) {
        if (i10 == 128) {
            this.f25206a = 32;
            this.f25207b = 4294967295L;
            this.f25216k = f25204t[0];
            this.f25217l = f25205u[0];
        } else if (i10 == 160) {
            this.f25206a = 40;
            this.f25207b = 1099511627775L;
            this.f25216k = f25204t[1];
            this.f25217l = f25205u[1];
        } else if (i10 == 192) {
            this.f25206a = 48;
            this.f25207b = 281474976710655L;
            this.f25216k = f25204t[2];
            this.f25217l = f25205u[2];
        } else if (i10 == 224) {
            this.f25206a = 56;
            this.f25207b = 72057594037927935L;
            this.f25216k = f25204t[3];
            this.f25217l = f25205u[3];
        } else {
            if (i10 != 256) {
                throw new IllegalArgumentException("unknown blocksize to Rijndael");
            }
            this.f25206a = 64;
            this.f25207b = -1L;
            this.f25216k = f25204t[4];
            this.f25217l = f25205u[4];
        }
        this.f25209d = i10;
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            this.f25210e = m(((np.n1) kVar).a());
            this.f25215j = z10;
        } else {
            throw new IllegalArgumentException("invalid parameter passed to Rijndael init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "Rijndael";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f25206a / 2;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (this.f25210e == null) {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
        int i12 = this.f25206a;
        if ((i12 / 2) + i10 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if ((i12 / 2) + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        boolean z10 = this.f25215j;
        v(bArr, i10);
        long[][] jArr = this.f25210e;
        if (z10) {
            l(jArr);
        } else {
            k(jArr);
        }
        t(bArr2, i11);
        return this.f25206a / 2;
    }

    public final void e() {
        long jS = 0;
        long jS2 = 0;
        long jS3 = 0;
        long jS4 = 0;
        for (int i10 = 0; i10 < this.f25206a; i10 += 8) {
            int i11 = (int) ((this.f25211f >> i10) & 255);
            int i12 = (int) ((this.f25212g >> i10) & 255);
            int i13 = (int) ((this.f25213h >> i10) & 255);
            long j10 = jS4;
            int i14 = (int) ((this.f25214i >> i10) & 255);
            int i15 = -1;
            int i16 = i11 != 0 ? f25199o[i11 & 255] & 255 : -1;
            int i17 = i12 != 0 ? f25199o[i12 & 255] & 255 : -1;
            int i18 = i13 != 0 ? f25199o[i13 & 255] & 255 : -1;
            if (i14 != 0) {
                i15 = f25199o[i14 & 255] & 255;
            }
            jS |= ((long) ((((s(i16) ^ q(i17)) ^ r(i18)) ^ p(i15)) & 255)) << i10;
            jS2 |= ((long) ((((s(i17) ^ q(i18)) ^ r(i15)) ^ p(i16)) & 255)) << i10;
            jS3 |= ((long) ((((s(i18) ^ q(i15)) ^ r(i16)) ^ p(i17)) & 255)) << i10;
            jS4 = j10 | (((long) ((((s(i15) ^ q(i16)) ^ r(i17)) ^ p(i18)) & 255)) << i10);
        }
        this.f25211f = jS;
        this.f25212g = jS2;
        this.f25213h = jS3;
        this.f25214i = jS4;
    }

    public final void f(long[] jArr) {
        this.f25211f ^= jArr[0];
        this.f25212g ^= jArr[1];
        this.f25213h ^= jArr[2];
        this.f25214i ^= jArr[3];
    }

    public final void g() {
        long jN = 0;
        long jN2 = 0;
        long jN3 = 0;
        long jN4 = 0;
        for (int i10 = 0; i10 < this.f25206a; i10 += 8) {
            int i11 = (int) ((this.f25211f >> i10) & 255);
            int i12 = (int) ((this.f25212g >> i10) & 255);
            int i13 = (int) ((this.f25213h >> i10) & 255);
            int i14 = (int) ((this.f25214i >> i10) & 255);
            jN |= ((long) ((((n(i11) ^ o(i12)) ^ i13) ^ i14) & 255)) << i10;
            jN2 |= ((long) ((((n(i12) ^ o(i13)) ^ i14) ^ i11) & 255)) << i10;
            jN3 |= ((long) ((((n(i13) ^ o(i14)) ^ i11) ^ i12) & 255)) << i10;
            jN4 |= ((long) ((((n(i14) ^ o(i11)) ^ i12) ^ i13) & 255)) << i10;
        }
        this.f25211f = jN;
        this.f25212g = jN2;
        this.f25213h = jN3;
        this.f25214i = jN4;
    }

    public final void h(byte[] bArr) {
        this.f25212g = u(this.f25212g, bArr[1]);
        this.f25213h = u(this.f25213h, bArr[2]);
        this.f25214i = u(this.f25214i, bArr[3]);
    }

    public final void i(byte[] bArr) {
        this.f25211f = j(this.f25211f, bArr);
        this.f25212g = j(this.f25212g, bArr);
        this.f25213h = j(this.f25213h, bArr);
        this.f25214i = j(this.f25214i, bArr);
    }

    public final long j(long j10, byte[] bArr) {
        long j11 = 0;
        for (int i10 = 0; i10 < this.f25206a; i10 += 8) {
            j11 |= ((long) (bArr[(int) ((j10 >> i10) & 255)] & 255)) << i10;
        }
        return j11;
    }

    public final void k(long[][] jArr) {
        f(jArr[this.f25208c]);
        i(f25202r);
        h(this.f25217l);
        for (int i10 = this.f25208c - 1; i10 > 0; i10--) {
            f(jArr[i10]);
            e();
            i(f25202r);
            h(this.f25217l);
        }
        f(jArr[0]);
    }

    public final void l(long[][] jArr) {
        f(jArr[0]);
        for (int i10 = 1; i10 < this.f25208c; i10++) {
            i(f25201q);
            h(this.f25216k);
            g();
            f(jArr[i10]);
        }
        i(f25201q);
        h(this.f25216k);
        f(jArr[this.f25208c]);
    }

    public final long[][] m(byte[] bArr) {
        int i10;
        int i11;
        int i12 = 8;
        int length = bArr.length * 8;
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, 4, 64);
        long[][] jArr = (long[][]) Array.newInstance((Class<?>) long.class, 15, 4);
        int i13 = 4;
        if (length == 128) {
            i10 = 4;
        } else if (length == 160) {
            i10 = 5;
        } else if (length == 192) {
            i10 = 6;
        } else if (length == 224) {
            i10 = 7;
        } else {
            if (length != 256) {
                throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
            }
            i10 = 8;
        }
        this.f25208c = length >= this.f25209d ? i10 + 6 : (this.f25206a / 8) + 6;
        char c10 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i14 < bArr.length) {
            bArr2[i14 % 4][i14 / 4] = bArr[i15];
            i14++;
            i15++;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < i10 && i17 < (this.f25208c + 1) * (this.f25206a / 8)) {
            int i18 = 0;
            while (i18 < i13) {
                int i19 = this.f25206a;
                long[] jArr2 = jArr[i17 / (i19 / 8)];
                jArr2[i18] = (((long) (bArr2[i18][i16] & 255)) << ((i17 * 8) % i19)) | jArr2[i18];
                i18++;
                i13 = 4;
            }
            i16++;
            i17++;
            i13 = 4;
        }
        int i20 = 0;
        while (i17 < (this.f25208c + 1) * (this.f25206a / i12)) {
            int i21 = 0;
            while (i21 < 4) {
                byte[] bArr3 = bArr2[i21];
                i21++;
                bArr3[c10] = (byte) (bArr3[c10] ^ f25201q[bArr2[i21 % 4][i10 - 1] & 255]);
            }
            byte[] bArr4 = bArr2[c10];
            int i22 = i20 + 1;
            bArr4[c10] = (byte) (f25203s[i20] ^ bArr4[c10]);
            int i23 = 1;
            if (i10 <= 6) {
                while (i23 < i10) {
                    for (int i24 = 0; i24 < 4; i24++) {
                        byte[] bArr5 = bArr2[i24];
                        bArr5[i23] = (byte) (bArr5[i23] ^ bArr2[i24][i23 - 1]);
                    }
                    i23++;
                }
            } else {
                while (true) {
                    i11 = 4;
                    if (i23 >= 4) {
                        break;
                    }
                    int i25 = 0;
                    while (i25 < i11) {
                        byte[] bArr6 = bArr2[i25];
                        bArr6[i23] = (byte) (bArr6[i23] ^ bArr2[i25][i23 - 1]);
                        i25++;
                        i11 = 4;
                    }
                    i23++;
                }
                for (int i26 = 0; i26 < 4; i26++) {
                    byte[] bArr7 = bArr2[i26];
                    bArr7[4] = (byte) (bArr7[4] ^ f25201q[bArr2[i26][3] & 255]);
                }
                int i27 = 5;
                while (i27 < i10) {
                    int i28 = 0;
                    while (i28 < i11) {
                        byte[] bArr8 = bArr2[i28];
                        bArr8[i27] = (byte) (bArr8[i27] ^ bArr2[i28][i27 - 1]);
                        i28++;
                        i11 = 4;
                    }
                    i27++;
                    i11 = 4;
                }
            }
            int i29 = 0;
            while (i29 < i10 && i17 < (this.f25208c + 1) * (this.f25206a / i12)) {
                for (int i30 = 0; i30 < 4; i30++) {
                    int i31 = this.f25206a;
                    long[] jArr3 = jArr[i17 / (i31 / 8)];
                    jArr3[i30] = (((long) (bArr2[i30][i29] & 255)) << ((i17 * 8) % i31)) | jArr3[i30];
                }
                i29++;
                i17++;
                i12 = 8;
            }
            i20 = i22;
            c10 = 0;
            i12 = 8;
        }
        return jArr;
    }

    public final byte n(int i10) {
        if (i10 != 0) {
            return f25200p[(f25199o[i10] & 255) + 25];
        }
        return (byte) 0;
    }

    public final byte o(int i10) {
        if (i10 != 0) {
            return f25200p[(f25199o[i10] & 255) + 1];
        }
        return (byte) 0;
    }

    public final byte p(int i10) {
        if (i10 >= 0) {
            return f25200p[i10 + 199];
        }
        return (byte) 0;
    }

    public final byte q(int i10) {
        if (i10 >= 0) {
            return f25200p[i10 + 104];
        }
        return (byte) 0;
    }

    public final byte r(int i10) {
        if (i10 >= 0) {
            return f25200p[i10 + mb.e.f41061s1];
        }
        return (byte) 0;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }

    public final byte s(int i10) {
        if (i10 >= 0) {
            return f25200p[i10 + 223];
        }
        return (byte) 0;
    }

    public final void t(byte[] bArr, int i10) {
        for (int i11 = 0; i11 != this.f25206a; i11 += 8) {
            int i12 = i10 + 1;
            bArr[i10] = (byte) (this.f25211f >> i11);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (this.f25212g >> i11);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (this.f25213h >> i11);
            i10 = i14 + 1;
            bArr[i14] = (byte) (this.f25214i >> i11);
        }
    }

    public final long u(long j10, int i10) {
        return ((j10 << (this.f25206a - i10)) | (j10 >>> i10)) & this.f25207b;
    }

    public final void v(byte[] bArr, int i10) {
        this.f25211f = bArr[i10] & 255;
        this.f25212g = bArr[r0] & 255;
        this.f25213h = bArr[r8] & 255;
        int i11 = i10 + 1 + 1 + 1 + 1;
        this.f25214i = bArr[r0] & 255;
        for (int i12 = 8; i12 != this.f25206a; i12 += 8) {
            int i13 = i11 + 1;
            this.f25211f |= ((long) (bArr[i11] & 255)) << i12;
            int i14 = i13 + 1;
            this.f25212g |= ((long) (bArr[i13] & 255)) << i12;
            int i15 = i14 + 1;
            this.f25213h |= ((long) (bArr[i14] & 255)) << i12;
            i11 = i15 + 1;
            this.f25214i |= ((long) (bArr[i15] & 255)) << i12;
        }
    }
}
