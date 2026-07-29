package zo;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends l implements g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f59206l = 20;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f59207m = 1518500249;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f59208n = 1859775393;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f59209o = -1894007588;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f59210p = -899497514;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f59215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f59216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59217k;

    public c0() {
        this.f59216j = new int[80];
        reset();
    }

    public c0(c0 c0Var) {
        super(c0Var);
        this.f59216j = new int[80];
        q(c0Var);
    }

    public c0(byte[] bArr) {
        super(bArr);
        this.f59216j = new int[80];
        this.f59211e = org.bouncycastle.util.o.a(bArr, 16);
        this.f59212f = org.bouncycastle.util.o.a(bArr, 20);
        this.f59213g = org.bouncycastle.util.o.a(bArr, 24);
        this.f59214h = org.bouncycastle.util.o.a(bArr, 28);
        this.f59215i = org.bouncycastle.util.o.a(bArr, 32);
        this.f59217k = org.bouncycastle.util.o.a(bArr, 36);
        for (int i10 = 0; i10 != this.f59217k; i10++) {
            this.f59216j[i10] = org.bouncycastle.util.o.a(bArr, (i10 * 4) + 40);
        }
    }

    @Override // zo.g
    public byte[] a() {
        byte[] bArr = new byte[(this.f59217k * 4) + 40];
        super.m(bArr);
        org.bouncycastle.util.o.h(this.f59211e, bArr, 16);
        org.bouncycastle.util.o.h(this.f59212f, bArr, 20);
        org.bouncycastle.util.o.h(this.f59213g, bArr, 24);
        org.bouncycastle.util.o.h(this.f59214h, bArr, 28);
        org.bouncycastle.util.o.h(this.f59215i, bArr, 32);
        org.bouncycastle.util.o.h(this.f59217k, bArr, 36);
        for (int i10 = 0; i10 != this.f59217k; i10++) {
            org.bouncycastle.util.o.h(this.f59216j[i10], bArr, (i10 * 4) + 40);
        }
        return bArr;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return et.e.f27137f;
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        l();
        org.bouncycastle.util.o.h(this.f59211e, bArr, i10);
        org.bouncycastle.util.o.h(this.f59212f, bArr, i10 + 4);
        org.bouncycastle.util.o.h(this.f59213g, bArr, i10 + 8);
        org.bouncycastle.util.o.h(this.f59214h, bArr, i10 + 12);
        org.bouncycastle.util.o.h(this.f59215i, bArr, i10 + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new c0(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 20;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        c0 c0Var = (c0) mVar;
        super.k(c0Var);
        q(c0Var);
    }

    @Override // zo.l
    public void n() {
        for (int i10 = 16; i10 < 80; i10++) {
            int[] iArr = this.f59216j;
            int i11 = ((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16];
            iArr[i10] = (i11 >>> 31) | (i11 << 1);
        }
        int iT = this.f59211e;
        int iT2 = this.f59212f;
        int i12 = this.f59213g;
        int i13 = this.f59214h;
        int i14 = this.f59215i;
        int i15 = 0;
        int i16 = 0;
        while (i15 < 4) {
            int i17 = i16 + 1;
            int iR = i14 + ((iT << 5) | (iT >>> 27)) + r(iT2, i12, i13) + this.f59216j[i16] + 1518500249;
            int i18 = (iT2 >>> 2) | (iT2 << 30);
            int i19 = i17 + 1;
            int iR2 = i13 + ((iR << 5) | (iR >>> 27)) + r(iT, i18, i12) + this.f59216j[i17] + 1518500249;
            int i20 = (iT >>> 2) | (iT << 30);
            int i21 = i19 + 1;
            int iR3 = i12 + ((iR2 << 5) | (iR2 >>> 27)) + r(iR, i20, i18) + this.f59216j[i19] + 1518500249;
            i14 = (iR >>> 2) | (iR << 30);
            int i22 = i21 + 1;
            iT2 = i18 + ((iR3 << 5) | (iR3 >>> 27)) + r(iR2, i14, i20) + this.f59216j[i21] + 1518500249;
            i13 = (iR2 >>> 2) | (iR2 << 30);
            iT = i20 + ((iT2 << 5) | (iT2 >>> 27)) + r(iR3, i13, i14) + this.f59216j[i22] + 1518500249;
            i12 = (iR3 >>> 2) | (iR3 << 30);
            i15++;
            i16 = i22 + 1;
        }
        int i23 = 0;
        while (i23 < 4) {
            int i24 = i16 + 1;
            int iT3 = i14 + ((iT << 5) | (iT >>> 27)) + t(iT2, i12, i13) + this.f59216j[i16] + 1859775393;
            int i25 = (iT2 >>> 2) | (iT2 << 30);
            int i26 = i24 + 1;
            int iT4 = i13 + ((iT3 << 5) | (iT3 >>> 27)) + t(iT, i25, i12) + this.f59216j[i24] + 1859775393;
            int i27 = (iT >>> 2) | (iT << 30);
            int i28 = i26 + 1;
            int iT5 = i12 + ((iT4 << 5) | (iT4 >>> 27)) + t(iT3, i27, i25) + this.f59216j[i26] + 1859775393;
            i14 = (iT3 >>> 2) | (iT3 << 30);
            int i29 = i28 + 1;
            iT2 = i25 + ((iT5 << 5) | (iT5 >>> 27)) + t(iT4, i14, i27) + this.f59216j[i28] + 1859775393;
            i13 = (iT4 >>> 2) | (iT4 << 30);
            iT = i27 + ((iT2 << 5) | (iT2 >>> 27)) + t(iT5, i13, i14) + this.f59216j[i29] + 1859775393;
            i12 = (iT5 >>> 2) | (iT5 << 30);
            i23++;
            i16 = i29 + 1;
        }
        int i30 = 0;
        while (i30 < 4) {
            int iS = i14 + (((((iT << 5) | (iT >>> 27)) + s(iT2, i12, i13)) + this.f59216j[i16]) - 1894007588);
            int iS2 = i13 + (((((iS << 5) | (iS >>> 27)) + s(iT, r2, i12)) + this.f59216j[r12]) - 1894007588);
            int iS3 = i12 + (((((iS2 << 5) | (iS2 >>> 27)) + s(iS, r1, r2)) + this.f59216j[r13]) - 1894007588);
            i14 = (iS >>> 2) | (iS << 30);
            iT2 = ((iT2 >>> 2) | (iT2 << 30)) + (((((iS3 << 5) | (iS3 >>> 27)) + s(iS2, i14, r1)) + this.f59216j[r12]) - 1894007588);
            i13 = (iS2 >>> 2) | (iS2 << 30);
            iT = ((iT >>> 2) | (iT << 30)) + (((((iT2 << 5) | (iT2 >>> 27)) + s(iS3, i13, i14)) + this.f59216j[r13]) - 1894007588);
            i12 = (iS3 >>> 2) | (iS3 << 30);
            i30++;
            i16 = i16 + 1 + 1 + 1 + 1 + 1;
        }
        int i31 = 0;
        while (i31 <= 3) {
            int iT6 = i14 + (((((iT << 5) | (iT >>> 27)) + t(iT2, i12, i13)) + this.f59216j[i16]) - 899497514);
            int iT7 = i13 + (((((iT6 << 5) | (iT6 >>> 27)) + t(iT, r2, i12)) + this.f59216j[r11]) - 899497514);
            int iT8 = i12 + (((((iT7 << 5) | (iT7 >>> 27)) + t(iT6, r1, r2)) + this.f59216j[r12]) - 899497514);
            i14 = (iT6 >>> 2) | (iT6 << 30);
            iT2 = ((iT2 >>> 2) | (iT2 << 30)) + (((((iT8 << 5) | (iT8 >>> 27)) + t(iT7, i14, r1)) + this.f59216j[r11]) - 899497514);
            i13 = (iT7 >>> 2) | (iT7 << 30);
            iT = ((iT >>> 2) | (iT << 30)) + (((((iT2 << 5) | (iT2 >>> 27)) + t(iT8, i13, i14)) + this.f59216j[r12]) - 899497514);
            i12 = (iT8 >>> 2) | (iT8 << 30);
            i31++;
            i16 = i16 + 1 + 1 + 1 + 1 + 1;
        }
        this.f59211e += iT;
        this.f59212f += iT2;
        this.f59213g += i12;
        this.f59214h += i13;
        this.f59215i += i14;
        this.f59217k = 0;
        for (int i32 = 0; i32 < 16; i32++) {
            this.f59216j[i32] = 0;
        }
    }

    @Override // zo.l
    public void o(long j10) {
        if (this.f59217k > 14) {
            n();
        }
        int[] iArr = this.f59216j;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) j10;
    }

    @Override // zo.l
    public void p(byte[] bArr, int i10) {
        int i11 = bArr[i10] << 24;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 16);
        int i14 = i12 + 1;
        int i15 = (bArr[i14 + 1] & 255) | i13 | ((bArr[i14] & 255) << 8);
        int[] iArr = this.f59216j;
        int i16 = this.f59217k;
        iArr[i16] = i15;
        int i17 = i16 + 1;
        this.f59217k = i17;
        if (i17 == 16) {
            n();
        }
    }

    public final void q(c0 c0Var) {
        this.f59211e = c0Var.f59211e;
        this.f59212f = c0Var.f59212f;
        this.f59213g = c0Var.f59213g;
        this.f59214h = c0Var.f59214h;
        this.f59215i = c0Var.f59215i;
        int[] iArr = c0Var.f59216j;
        System.arraycopy(iArr, 0, this.f59216j, 0, iArr.length);
        this.f59217k = c0Var.f59217k;
    }

    public final int r(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    @Override // zo.l, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59211e = 1732584193;
        this.f59212f = -271733879;
        this.f59213g = -1732584194;
        this.f59214h = 271733878;
        this.f59215i = -1009589776;
        this.f59217k = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f59216j;
            if (i10 == iArr.length) {
                return;
            }
            iArr[i10] = 0;
            i10++;
        }
    }

    public final int s(int i10, int i11, int i12) {
        return (i10 & i12) | (i10 & i11) | (i11 & i12);
    }

    public final int t(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }
}
