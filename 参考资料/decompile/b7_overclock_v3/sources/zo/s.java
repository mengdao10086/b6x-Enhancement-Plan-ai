package zo;

import okio.w0;

/* JADX INFO: loaded from: classes5.dex */
public class s implements org.bouncycastle.crypto.v, org.bouncycastle.util.m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f59477g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f59478h = {rc.a.f48409a0, rc.a.f48414f0, 67, i1.a.f31723v7, -94, i1.a.f31659n7, 124, 1, 61, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, i1.a.f31667o7, i1.a.f31714u7, 115, -116, -104, -109, rc.a.f48411c0, i1.a.E7, rp.u.f49086t, 76, -126, i1.a.f31732w7, 30, -101, 87, 60, -3, -44, -32, 22, 103, 66, pq.b.f46991h, 24, -118, 23, -27, 18, -66, 78, -60, -42, i1.a.B7, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, w0.f44229a, -108, i1.a.f31683q7, 16, -119, 11, 34, 95, rc.a.V, -128, 127, 93, -102, 90, -112, 50, rc.a.Z, 53, 62, -52, -25, -65, -9, -105, 3, -1, 25, jt.l.f36949q, -77, 72, -91, -75, -47, -41, 94, -110, 42, -84, 86, -86, i1.a.f31707t7, 79, -72, 56, -46, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, pq.b.f46994k, 89, 100, pq.b.f46993j, -121, 32, -122, 91, i1.a.A7, 101, -26, rc.a.f48413e0, -88, 2, 27, jt.l.f36952t, rc.a.X, -83, -82, -80, -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 85, 71, -93, 35, -35, 81, -81, 58, i1.a.f31691r7, 92, -7, i1.a.f31759z7, -70, i1.a.f31699s7, -22, rc.a.Y, rc.a.f48412d0, 83, 13, pq.b.f46992i, -123, 40, -124, 9, -45, -33, i1.a.f31750y7, -12, 65, -127, 77, 82, 106, -36, 55, -56, 108, i1.a.f31675p7, -85, -6, rc.a.W, -31, 123, 8, 12, -67, -79, 74, tc.a.f51065w, -120, -107, -117, -29, 99, -24, 109, -23, i1.a.f31741x7, -43, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, o5.b.f42741j, -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, jt.l.f36951s, -76, -113, -19, 31, 26, -37, -103, -115, 51, -97, 17, -125, 20};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f59479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f59481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f59482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f59483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59484f;

    public s() {
        this.f59479a = new byte[48];
        this.f59481c = new byte[16];
        this.f59483e = new byte[16];
        reset();
    }

    public s(s sVar) {
        this.f59479a = new byte[48];
        this.f59481c = new byte[16];
        this.f59483e = new byte[16];
        a(sVar);
    }

    public final void a(s sVar) {
        byte[] bArr = sVar.f59479a;
        System.arraycopy(bArr, 0, this.f59479a, 0, bArr.length);
        this.f59480b = sVar.f59480b;
        byte[] bArr2 = sVar.f59481c;
        System.arraycopy(bArr2, 0, this.f59481c, 0, bArr2.length);
        this.f59482d = sVar.f59482d;
        byte[] bArr3 = sVar.f59483e;
        System.arraycopy(bArr3, 0, this.f59483e, 0, bArr3.length);
        this.f59484f = sVar.f59484f;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "MD2";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        int length = this.f59481c.length;
        int i11 = this.f59482d;
        byte b10 = (byte) (length - i11);
        while (true) {
            byte[] bArr2 = this.f59481c;
            if (i11 >= bArr2.length) {
                l(bArr2);
                k(this.f59481c);
                k(this.f59483e);
                System.arraycopy(this.f59479a, this.f59480b, bArr, i10, 16);
                reset();
                return 16;
            }
            bArr2[i11] = b10;
            i11++;
        }
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new s(this);
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 16;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        a((s) mVar);
    }

    public void k(byte[] bArr) {
        for (int i10 = 0; i10 < 16; i10++) {
            byte[] bArr2 = this.f59479a;
            bArr2[i10 + 16] = bArr[i10];
            bArr2[i10 + 32] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 18; i12++) {
            for (int i13 = 0; i13 < 48; i13++) {
                byte[] bArr3 = this.f59479a;
                byte b10 = (byte) (f59478h[i11] ^ bArr3[i13]);
                bArr3[i13] = b10;
                i11 = b10 & 255;
            }
            i11 = (i11 + i12) % 256;
        }
    }

    public void l(byte[] bArr) {
        byte b10 = this.f59483e[15];
        for (int i10 = 0; i10 < 16; i10++) {
            byte[] bArr2 = this.f59483e;
            bArr2[i10] = (byte) (f59478h[(b10 ^ bArr[i10]) & 255] ^ bArr2[i10]);
            b10 = bArr2[i10];
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59480b = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f59479a;
            if (i10 == bArr.length) {
                break;
            }
            bArr[i10] = 0;
            i10++;
        }
        this.f59482d = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = this.f59481c;
            if (i11 == bArr2.length) {
                break;
            }
            bArr2[i11] = 0;
            i11++;
        }
        this.f59484f = 0;
        int i12 = 0;
        while (true) {
            byte[] bArr3 = this.f59483e;
            if (i12 == bArr3.length) {
                return;
            }
            bArr3[i12] = 0;
            i12++;
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        byte[] bArr = this.f59481c;
        int i10 = this.f59482d;
        int i11 = i10 + 1;
        this.f59482d = i11;
        bArr[i10] = b10;
        if (i11 == 16) {
            l(bArr);
            k(this.f59481c);
            this.f59482d = 0;
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        while (this.f59482d != 0 && i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        while (i11 > 16) {
            System.arraycopy(bArr, i10, this.f59481c, 0, 16);
            l(this.f59481c);
            k(this.f59481c);
            i11 -= 16;
            i10 += 16;
        }
        while (i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
    }
}
