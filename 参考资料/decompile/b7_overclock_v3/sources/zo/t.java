package zo;

/* JADX INFO: loaded from: classes5.dex */
public class t extends l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f59485k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f59486l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f59487m = 7;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f59488n = 11;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f59489o = 19;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f59490p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f59491q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f59492r = 9;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f59493s = 13;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f59494t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f59495u = 9;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f59496v = 11;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f59497w = 15;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f59502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59503j;

    public t() {
        this.f59502i = new int[16];
        reset();
    }

    public t(t tVar) {
        super(tVar);
        this.f59502i = new int[16];
        t(tVar);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "MD4";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        l();
        v(this.f59498e, bArr, i10);
        v(this.f59499f, bArr, i10 + 4);
        v(this.f59500g, bArr, i10 + 8);
        v(this.f59501h, bArr, i10 + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new t(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 16;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        t((t) mVar);
    }

    @Override // zo.l
    public void n() {
        int i10 = this.f59498e;
        int i11 = this.f59499f;
        int i12 = this.f59500g;
        int i13 = this.f59501h;
        int iU = u(i10 + q(i11, i12, i13) + this.f59502i[0], 3);
        int iU2 = u(i13 + q(iU, i11, i12) + this.f59502i[1], 7);
        int iU3 = u(i12 + q(iU2, iU, i11) + this.f59502i[2], 11);
        int iU4 = u(i11 + q(iU3, iU2, iU) + this.f59502i[3], 19);
        int iU5 = u(iU + q(iU4, iU3, iU2) + this.f59502i[4], 3);
        int iU6 = u(iU2 + q(iU5, iU4, iU3) + this.f59502i[5], 7);
        int iU7 = u(iU3 + q(iU6, iU5, iU4) + this.f59502i[6], 11);
        int iU8 = u(iU4 + q(iU7, iU6, iU5) + this.f59502i[7], 19);
        int iU9 = u(iU5 + q(iU8, iU7, iU6) + this.f59502i[8], 3);
        int iU10 = u(iU6 + q(iU9, iU8, iU7) + this.f59502i[9], 7);
        int iU11 = u(iU7 + q(iU10, iU9, iU8) + this.f59502i[10], 11);
        int iU12 = u(iU8 + q(iU11, iU10, iU9) + this.f59502i[11], 19);
        int iU13 = u(iU9 + q(iU12, iU11, iU10) + this.f59502i[12], 3);
        int iU14 = u(iU10 + q(iU13, iU12, iU11) + this.f59502i[13], 7);
        int iU15 = u(iU11 + q(iU14, iU13, iU12) + this.f59502i[14], 11);
        int iU16 = u(iU12 + q(iU15, iU14, iU13) + this.f59502i[15], 19);
        int iU17 = u(iU13 + r(iU16, iU15, iU14) + this.f59502i[0] + 1518500249, 3);
        int iU18 = u(iU14 + r(iU17, iU16, iU15) + this.f59502i[4] + 1518500249, 5);
        int iU19 = u(iU15 + r(iU18, iU17, iU16) + this.f59502i[8] + 1518500249, 9);
        int iU20 = u(iU16 + r(iU19, iU18, iU17) + this.f59502i[12] + 1518500249, 13);
        int iU21 = u(iU17 + r(iU20, iU19, iU18) + this.f59502i[1] + 1518500249, 3);
        int iU22 = u(iU18 + r(iU21, iU20, iU19) + this.f59502i[5] + 1518500249, 5);
        int iU23 = u(iU19 + r(iU22, iU21, iU20) + this.f59502i[9] + 1518500249, 9);
        int iU24 = u(iU20 + r(iU23, iU22, iU21) + this.f59502i[13] + 1518500249, 13);
        int iU25 = u(iU21 + r(iU24, iU23, iU22) + this.f59502i[2] + 1518500249, 3);
        int iU26 = u(iU22 + r(iU25, iU24, iU23) + this.f59502i[6] + 1518500249, 5);
        int iU27 = u(iU23 + r(iU26, iU25, iU24) + this.f59502i[10] + 1518500249, 9);
        int iU28 = u(iU24 + r(iU27, iU26, iU25) + this.f59502i[14] + 1518500249, 13);
        int iU29 = u(iU25 + r(iU28, iU27, iU26) + this.f59502i[3] + 1518500249, 3);
        int iU30 = u(iU26 + r(iU29, iU28, iU27) + this.f59502i[7] + 1518500249, 5);
        int iU31 = u(iU27 + r(iU30, iU29, iU28) + this.f59502i[11] + 1518500249, 9);
        int iU32 = u(iU28 + r(iU31, iU30, iU29) + this.f59502i[15] + 1518500249, 13);
        int iU33 = u(iU29 + s(iU32, iU31, iU30) + this.f59502i[0] + 1859775393, 3);
        int iU34 = u(iU30 + s(iU33, iU32, iU31) + this.f59502i[8] + 1859775393, 9);
        int iU35 = u(iU31 + s(iU34, iU33, iU32) + this.f59502i[4] + 1859775393, 11);
        int iU36 = u(iU32 + s(iU35, iU34, iU33) + this.f59502i[12] + 1859775393, 15);
        int iU37 = u(iU33 + s(iU36, iU35, iU34) + this.f59502i[2] + 1859775393, 3);
        int iU38 = u(iU34 + s(iU37, iU36, iU35) + this.f59502i[10] + 1859775393, 9);
        int iU39 = u(iU35 + s(iU38, iU37, iU36) + this.f59502i[6] + 1859775393, 11);
        int iU40 = u(iU36 + s(iU39, iU38, iU37) + this.f59502i[14] + 1859775393, 15);
        int iU41 = u(iU37 + s(iU40, iU39, iU38) + this.f59502i[1] + 1859775393, 3);
        int iU42 = u(iU38 + s(iU41, iU40, iU39) + this.f59502i[9] + 1859775393, 9);
        int iU43 = u(iU39 + s(iU42, iU41, iU40) + this.f59502i[5] + 1859775393, 11);
        int iU44 = u(iU40 + s(iU43, iU42, iU41) + this.f59502i[13] + 1859775393, 15);
        int iU45 = u(iU41 + s(iU44, iU43, iU42) + this.f59502i[3] + 1859775393, 3);
        int iU46 = u(iU42 + s(iU45, iU44, iU43) + this.f59502i[11] + 1859775393, 9);
        int iU47 = u(iU43 + s(iU46, iU45, iU44) + this.f59502i[7] + 1859775393, 11);
        int iU48 = u(iU44 + s(iU47, iU46, iU45) + this.f59502i[15] + 1859775393, 15);
        this.f59498e += iU45;
        this.f59499f += iU48;
        this.f59500g += iU47;
        this.f59501h += iU46;
        this.f59503j = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f59502i;
            if (i14 == iArr.length) {
                return;
            }
            iArr[i14] = 0;
            i14++;
        }
    }

    @Override // zo.l
    public void o(long j10) {
        if (this.f59503j > 14) {
            n();
        }
        int[] iArr = this.f59502i;
        iArr[14] = (int) ((-1) & j10);
        iArr[15] = (int) (j10 >>> 32);
    }

    @Override // zo.l
    public void p(byte[] bArr, int i10) {
        int[] iArr = this.f59502i;
        int i11 = this.f59503j;
        int i12 = i11 + 1;
        this.f59503j = i12;
        iArr[i11] = ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        if (i12 == 16) {
            n();
        }
    }

    public final int q(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    public final int r(int i10, int i11, int i12) {
        return (i10 & i12) | (i10 & i11) | (i11 & i12);
    }

    @Override // zo.l, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59498e = 1732584193;
        this.f59499f = -271733879;
        this.f59500g = -1732584194;
        this.f59501h = 271733878;
        this.f59503j = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f59502i;
            if (i10 == iArr.length) {
                return;
            }
            iArr[i10] = 0;
            i10++;
        }
    }

    public final int s(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public final void t(t tVar) {
        super.k(tVar);
        this.f59498e = tVar.f59498e;
        this.f59499f = tVar.f59499f;
        this.f59500g = tVar.f59500g;
        this.f59501h = tVar.f59501h;
        int[] iArr = tVar.f59502i;
        System.arraycopy(iArr, 0, this.f59502i, 0, iArr.length);
        this.f59503j = tVar.f59503j;
    }

    public final int u(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public final void v(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 3] = (byte) (i10 >>> 24);
    }
}
