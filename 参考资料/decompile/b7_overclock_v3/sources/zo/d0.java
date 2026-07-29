package zo;

/* JADX INFO: loaded from: classes5.dex */
public class d0 extends l implements g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f59244o = 28;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f59245p = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f59250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f59253l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f59254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f59255n;

    public d0() {
        this.f59254m = new int[64];
        reset();
    }

    public d0(d0 d0Var) {
        super(d0Var);
        this.f59254m = new int[64];
        w(d0Var);
    }

    public d0(byte[] bArr) {
        super(bArr);
        this.f59254m = new int[64];
        this.f59246e = org.bouncycastle.util.o.a(bArr, 16);
        this.f59247f = org.bouncycastle.util.o.a(bArr, 20);
        this.f59248g = org.bouncycastle.util.o.a(bArr, 24);
        this.f59249h = org.bouncycastle.util.o.a(bArr, 28);
        this.f59250i = org.bouncycastle.util.o.a(bArr, 32);
        this.f59251j = org.bouncycastle.util.o.a(bArr, 36);
        this.f59252k = org.bouncycastle.util.o.a(bArr, 40);
        this.f59253l = org.bouncycastle.util.o.a(bArr, 44);
        this.f59255n = org.bouncycastle.util.o.a(bArr, 48);
        for (int i10 = 0; i10 != this.f59255n; i10++) {
            this.f59254m[i10] = org.bouncycastle.util.o.a(bArr, (i10 * 4) + 52);
        }
    }

    @Override // zo.g
    public byte[] a() {
        byte[] bArr = new byte[(this.f59255n * 4) + 52];
        super.m(bArr);
        org.bouncycastle.util.o.h(this.f59246e, bArr, 16);
        org.bouncycastle.util.o.h(this.f59247f, bArr, 20);
        org.bouncycastle.util.o.h(this.f59248g, bArr, 24);
        org.bouncycastle.util.o.h(this.f59249h, bArr, 28);
        org.bouncycastle.util.o.h(this.f59250i, bArr, 32);
        org.bouncycastle.util.o.h(this.f59251j, bArr, 36);
        org.bouncycastle.util.o.h(this.f59252k, bArr, 40);
        org.bouncycastle.util.o.h(this.f59253l, bArr, 44);
        org.bouncycastle.util.o.h(this.f59255n, bArr, 48);
        for (int i10 = 0; i10 != this.f59255n; i10++) {
            org.bouncycastle.util.o.h(this.f59254m[i10], bArr, (i10 * 4) + 52);
        }
        return bArr;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return et.e.f27138g;
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        l();
        org.bouncycastle.util.o.h(this.f59246e, bArr, i10);
        org.bouncycastle.util.o.h(this.f59247f, bArr, i10 + 4);
        org.bouncycastle.util.o.h(this.f59248g, bArr, i10 + 8);
        org.bouncycastle.util.o.h(this.f59249h, bArr, i10 + 12);
        org.bouncycastle.util.o.h(this.f59250i, bArr, i10 + 16);
        org.bouncycastle.util.o.h(this.f59251j, bArr, i10 + 20);
        org.bouncycastle.util.o.h(this.f59252k, bArr, i10 + 24);
        reset();
        return 28;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new d0(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 28;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        w((d0) mVar);
    }

    @Override // zo.l
    public void n() {
        for (int i10 = 16; i10 <= 63; i10++) {
            int[] iArr = this.f59254m;
            int iV = v(iArr[i10 - 2]);
            int[] iArr2 = this.f59254m;
            iArr[i10] = iV + iArr2[i10 - 7] + u(iArr2[i10 - 15]) + this.f59254m[i10 - 16];
        }
        int iS = this.f59246e;
        int iS2 = this.f59247f;
        int iS3 = this.f59248g;
        int iS4 = this.f59249h;
        int i11 = this.f59250i;
        int i12 = this.f59251j;
        int i13 = this.f59252k;
        int i14 = this.f59253l;
        int i15 = 0;
        for (int i16 = 0; i16 < 8; i16++) {
            int iT = t(i11) + q(i11, i12, i13);
            int[] iArr3 = f59245p;
            int i17 = i14 + iT + iArr3[i15] + this.f59254m[i15];
            int i18 = iS4 + i17;
            int iS5 = i17 + s(iS) + r(iS, iS2, iS3);
            int i19 = i15 + 1;
            int iT2 = i13 + t(i18) + q(i18, i11, i12) + iArr3[i19] + this.f59254m[i19];
            int i20 = iS3 + iT2;
            int iS6 = iT2 + s(iS5) + r(iS5, iS, iS2);
            int i21 = i19 + 1;
            int iT3 = i12 + t(i20) + q(i20, i18, i11) + iArr3[i21] + this.f59254m[i21];
            int i22 = iS2 + iT3;
            int iS7 = iT3 + s(iS6) + r(iS6, iS5, iS);
            int i23 = i21 + 1;
            int iT4 = i11 + t(i22) + q(i22, i20, i18) + iArr3[i23] + this.f59254m[i23];
            int i24 = iS + iT4;
            int iS8 = iT4 + s(iS7) + r(iS7, iS6, iS5);
            int i25 = i23 + 1;
            int iT5 = i18 + t(i24) + q(i24, i22, i20) + iArr3[i25] + this.f59254m[i25];
            i14 = iS5 + iT5;
            iS4 = iT5 + s(iS8) + r(iS8, iS7, iS6);
            int i26 = i25 + 1;
            int iT6 = i20 + t(i14) + q(i14, i24, i22) + iArr3[i26] + this.f59254m[i26];
            i13 = iS6 + iT6;
            iS3 = iT6 + s(iS4) + r(iS4, iS8, iS7);
            int i27 = i26 + 1;
            int iT7 = i22 + t(i13) + q(i13, i14, i24) + iArr3[i27] + this.f59254m[i27];
            i12 = iS7 + iT7;
            iS2 = iT7 + s(iS3) + r(iS3, iS4, iS8);
            int i28 = i27 + 1;
            int iT8 = i24 + t(i12) + q(i12, i13, i14) + iArr3[i28] + this.f59254m[i28];
            i11 = iS8 + iT8;
            iS = iT8 + s(iS2) + r(iS2, iS3, iS4);
            i15 = i28 + 1;
        }
        this.f59246e += iS;
        this.f59247f += iS2;
        this.f59248g += iS3;
        this.f59249h += iS4;
        this.f59250i += i11;
        this.f59251j += i12;
        this.f59252k += i13;
        this.f59253l += i14;
        this.f59255n = 0;
        for (int i29 = 0; i29 < 16; i29++) {
            this.f59254m[i29] = 0;
        }
    }

    @Override // zo.l
    public void o(long j10) {
        if (this.f59255n > 14) {
            n();
        }
        int[] iArr = this.f59254m;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) (j10 & (-1));
    }

    @Override // zo.l
    public void p(byte[] bArr, int i10) {
        int i11 = bArr[i10] << 24;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 16);
        int i14 = i12 + 1;
        int i15 = (bArr[i14 + 1] & 255) | i13 | ((bArr[i14] & 255) << 8);
        int[] iArr = this.f59254m;
        int i16 = this.f59255n;
        iArr[i16] = i15;
        int i17 = i16 + 1;
        this.f59255n = i17;
        if (i17 == 16) {
            n();
        }
    }

    public final int q(int i10, int i11, int i12) {
        return ((~i10) & i12) ^ (i11 & i10);
    }

    public final int r(int i10, int i11, int i12) {
        return ((i10 & i12) ^ (i10 & i11)) ^ (i11 & i12);
    }

    @Override // zo.l, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59246e = -1056596264;
        this.f59247f = 914150663;
        this.f59248g = 812702999;
        this.f59249h = -150054599;
        this.f59250i = -4191439;
        this.f59251j = 1750603025;
        this.f59252k = 1694076839;
        this.f59253l = -1090891868;
        this.f59255n = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f59254m;
            if (i10 == iArr.length) {
                return;
            }
            iArr[i10] = 0;
            i10++;
        }
    }

    public final int s(int i10) {
        return ((i10 << 10) | (i10 >>> 22)) ^ (((i10 >>> 2) | (i10 << 30)) ^ ((i10 >>> 13) | (i10 << 19)));
    }

    public final int t(int i10) {
        return ((i10 << 7) | (i10 >>> 25)) ^ (((i10 >>> 6) | (i10 << 26)) ^ ((i10 >>> 11) | (i10 << 21)));
    }

    public final int u(int i10) {
        return (i10 >>> 3) ^ (((i10 >>> 7) | (i10 << 25)) ^ ((i10 >>> 18) | (i10 << 14)));
    }

    public final int v(int i10) {
        return (i10 >>> 10) ^ (((i10 >>> 17) | (i10 << 15)) ^ ((i10 >>> 19) | (i10 << 13)));
    }

    public final void w(d0 d0Var) {
        super.k(d0Var);
        this.f59246e = d0Var.f59246e;
        this.f59247f = d0Var.f59247f;
        this.f59248g = d0Var.f59248g;
        this.f59249h = d0Var.f59249h;
        this.f59250i = d0Var.f59250i;
        this.f59251j = d0Var.f59251j;
        this.f59252k = d0Var.f59252k;
        this.f59253l = d0Var.f59253l;
        int[] iArr = d0Var.f59254m;
        System.arraycopy(iArr, 0, this.f59254m, 0, iArr.length);
        this.f59255n = d0Var.f59255n;
    }
}
