package zo;

/* JADX INFO: loaded from: classes5.dex */
public class y extends l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f59539k = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f59544i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59545j;

    public y() {
        this.f59544i = new int[16];
        reset();
    }

    public y(y yVar) {
        super(yVar);
        this.f59544i = new int[16];
        z(yVar);
    }

    public final int A(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public final int B(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    public final int C(int i10, int i11, int i12) {
        return (i10 | (~i11)) ^ i12;
    }

    public final int D(int i10, int i11, int i12) {
        return (i10 & i12) | (i11 & (~i12));
    }

    public final void E(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 3] = (byte) (i10 >>> 24);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "RIPEMD128";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        l();
        E(this.f59540e, bArr, i10);
        E(this.f59541f, bArr, i10 + 4);
        E(this.f59542g, bArr, i10 + 8);
        E(this.f59543h, bArr, i10 + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new y(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 16;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        z((y) mVar);
    }

    @Override // zo.l
    public void n() {
        int i10 = this.f59540e;
        int i11 = this.f59541f;
        int i12 = this.f59542g;
        int i13 = this.f59543h;
        int iQ = q(i10, i11, i12, i13, this.f59544i[0], 11);
        int iQ2 = q(i13, iQ, i11, i12, this.f59544i[1], 14);
        int iQ3 = q(i12, iQ2, iQ, i11, this.f59544i[2], 15);
        int iQ4 = q(i11, iQ3, iQ2, iQ, this.f59544i[3], 12);
        int iQ5 = q(iQ, iQ4, iQ3, iQ2, this.f59544i[4], 5);
        int iQ6 = q(iQ2, iQ5, iQ4, iQ3, this.f59544i[5], 8);
        int iQ7 = q(iQ3, iQ6, iQ5, iQ4, this.f59544i[6], 7);
        int iQ8 = q(iQ4, iQ7, iQ6, iQ5, this.f59544i[7], 9);
        int iQ9 = q(iQ5, iQ8, iQ7, iQ6, this.f59544i[8], 11);
        int iQ10 = q(iQ6, iQ9, iQ8, iQ7, this.f59544i[9], 13);
        int iQ11 = q(iQ7, iQ10, iQ9, iQ8, this.f59544i[10], 14);
        int iQ12 = q(iQ8, iQ11, iQ10, iQ9, this.f59544i[11], 15);
        int iQ13 = q(iQ9, iQ12, iQ11, iQ10, this.f59544i[12], 6);
        int iQ14 = q(iQ10, iQ13, iQ12, iQ11, this.f59544i[13], 7);
        int iQ15 = q(iQ11, iQ14, iQ13, iQ12, this.f59544i[14], 9);
        int iQ16 = q(iQ12, iQ15, iQ14, iQ13, this.f59544i[15], 8);
        int iR = r(iQ13, iQ16, iQ15, iQ14, this.f59544i[7], 7);
        int iR2 = r(iQ14, iR, iQ16, iQ15, this.f59544i[4], 6);
        int iR3 = r(iQ15, iR2, iR, iQ16, this.f59544i[13], 8);
        int iR4 = r(iQ16, iR3, iR2, iR, this.f59544i[1], 13);
        int iR5 = r(iR, iR4, iR3, iR2, this.f59544i[10], 11);
        int iR6 = r(iR2, iR5, iR4, iR3, this.f59544i[6], 9);
        int iR7 = r(iR3, iR6, iR5, iR4, this.f59544i[15], 7);
        int iR8 = r(iR4, iR7, iR6, iR5, this.f59544i[3], 15);
        int iR9 = r(iR5, iR8, iR7, iR6, this.f59544i[12], 7);
        int iR10 = r(iR6, iR9, iR8, iR7, this.f59544i[0], 12);
        int iR11 = r(iR7, iR10, iR9, iR8, this.f59544i[9], 15);
        int iR12 = r(iR8, iR11, iR10, iR9, this.f59544i[5], 9);
        int iR13 = r(iR9, iR12, iR11, iR10, this.f59544i[2], 11);
        int iR14 = r(iR10, iR13, iR12, iR11, this.f59544i[14], 7);
        int iR15 = r(iR11, iR14, iR13, iR12, this.f59544i[11], 13);
        int iR16 = r(iR12, iR15, iR14, iR13, this.f59544i[8], 12);
        int iS = s(iR13, iR16, iR15, iR14, this.f59544i[3], 11);
        int iS2 = s(iR14, iS, iR16, iR15, this.f59544i[10], 13);
        int iS3 = s(iR15, iS2, iS, iR16, this.f59544i[14], 6);
        int iS4 = s(iR16, iS3, iS2, iS, this.f59544i[4], 7);
        int iS5 = s(iS, iS4, iS3, iS2, this.f59544i[9], 14);
        int iS6 = s(iS2, iS5, iS4, iS3, this.f59544i[15], 9);
        int iS7 = s(iS3, iS6, iS5, iS4, this.f59544i[8], 13);
        int iS8 = s(iS4, iS7, iS6, iS5, this.f59544i[1], 15);
        int iS9 = s(iS5, iS8, iS7, iS6, this.f59544i[2], 14);
        int iS10 = s(iS6, iS9, iS8, iS7, this.f59544i[7], 8);
        int iS11 = s(iS7, iS10, iS9, iS8, this.f59544i[0], 13);
        int iS12 = s(iS8, iS11, iS10, iS9, this.f59544i[6], 6);
        int iS13 = s(iS9, iS12, iS11, iS10, this.f59544i[13], 5);
        int iS14 = s(iS10, iS13, iS12, iS11, this.f59544i[11], 12);
        int iS15 = s(iS11, iS14, iS13, iS12, this.f59544i[5], 7);
        int iS16 = s(iS12, iS15, iS14, iS13, this.f59544i[12], 5);
        int iT = t(iS13, iS16, iS15, iS14, this.f59544i[1], 11);
        int iT2 = t(iS14, iT, iS16, iS15, this.f59544i[9], 12);
        int iT3 = t(iS15, iT2, iT, iS16, this.f59544i[11], 14);
        int iT4 = t(iS16, iT3, iT2, iT, this.f59544i[10], 15);
        int iT5 = t(iT, iT4, iT3, iT2, this.f59544i[0], 14);
        int iT6 = t(iT2, iT5, iT4, iT3, this.f59544i[8], 15);
        int iT7 = t(iT3, iT6, iT5, iT4, this.f59544i[12], 9);
        int iT8 = t(iT4, iT7, iT6, iT5, this.f59544i[4], 8);
        int iT9 = t(iT5, iT8, iT7, iT6, this.f59544i[13], 9);
        int iT10 = t(iT6, iT9, iT8, iT7, this.f59544i[3], 14);
        int iT11 = t(iT7, iT10, iT9, iT8, this.f59544i[7], 5);
        int iT12 = t(iT8, iT11, iT10, iT9, this.f59544i[15], 6);
        int iT13 = t(iT9, iT12, iT11, iT10, this.f59544i[14], 8);
        int iT14 = t(iT10, iT13, iT12, iT11, this.f59544i[5], 6);
        int iT15 = t(iT11, iT14, iT13, iT12, this.f59544i[6], 5);
        int iT16 = t(iT12, iT15, iT14, iT13, this.f59544i[2], 12);
        int iX = x(i10, i11, i12, i13, this.f59544i[5], 8);
        int iX2 = x(i13, iX, i11, i12, this.f59544i[14], 9);
        int iX3 = x(i12, iX2, iX, i11, this.f59544i[7], 9);
        int iX4 = x(i11, iX3, iX2, iX, this.f59544i[0], 11);
        int iX5 = x(iX, iX4, iX3, iX2, this.f59544i[9], 13);
        int iX6 = x(iX2, iX5, iX4, iX3, this.f59544i[2], 15);
        int iX7 = x(iX3, iX6, iX5, iX4, this.f59544i[11], 15);
        int iX8 = x(iX4, iX7, iX6, iX5, this.f59544i[4], 5);
        int iX9 = x(iX5, iX8, iX7, iX6, this.f59544i[13], 7);
        int iX10 = x(iX6, iX9, iX8, iX7, this.f59544i[6], 7);
        int iX11 = x(iX7, iX10, iX9, iX8, this.f59544i[15], 8);
        int iX12 = x(iX8, iX11, iX10, iX9, this.f59544i[8], 11);
        int iX13 = x(iX9, iX12, iX11, iX10, this.f59544i[1], 14);
        int iX14 = x(iX10, iX13, iX12, iX11, this.f59544i[10], 14);
        int iX15 = x(iX11, iX14, iX13, iX12, this.f59544i[3], 12);
        int iX16 = x(iX12, iX15, iX14, iX13, this.f59544i[12], 6);
        int iW = w(iX13, iX16, iX15, iX14, this.f59544i[6], 9);
        int iW2 = w(iX14, iW, iX16, iX15, this.f59544i[11], 13);
        int iW3 = w(iX15, iW2, iW, iX16, this.f59544i[3], 15);
        int iW4 = w(iX16, iW3, iW2, iW, this.f59544i[7], 7);
        int iW5 = w(iW, iW4, iW3, iW2, this.f59544i[0], 12);
        int iW6 = w(iW2, iW5, iW4, iW3, this.f59544i[13], 8);
        int iW7 = w(iW3, iW6, iW5, iW4, this.f59544i[5], 9);
        int iW8 = w(iW4, iW7, iW6, iW5, this.f59544i[10], 11);
        int iW9 = w(iW5, iW8, iW7, iW6, this.f59544i[14], 7);
        int iW10 = w(iW6, iW9, iW8, iW7, this.f59544i[15], 7);
        int iW11 = w(iW7, iW10, iW9, iW8, this.f59544i[8], 12);
        int iW12 = w(iW8, iW11, iW10, iW9, this.f59544i[12], 7);
        int iW13 = w(iW9, iW12, iW11, iW10, this.f59544i[4], 6);
        int iW14 = w(iW10, iW13, iW12, iW11, this.f59544i[9], 15);
        int iW15 = w(iW11, iW14, iW13, iW12, this.f59544i[1], 13);
        int iW16 = w(iW12, iW15, iW14, iW13, this.f59544i[2], 11);
        int iV = v(iW13, iW16, iW15, iW14, this.f59544i[15], 9);
        int iV2 = v(iW14, iV, iW16, iW15, this.f59544i[5], 7);
        int iV3 = v(iW15, iV2, iV, iW16, this.f59544i[1], 15);
        int iV4 = v(iW16, iV3, iV2, iV, this.f59544i[3], 11);
        int iV5 = v(iV, iV4, iV3, iV2, this.f59544i[7], 8);
        int iV6 = v(iV2, iV5, iV4, iV3, this.f59544i[14], 6);
        int iV7 = v(iV3, iV6, iV5, iV4, this.f59544i[6], 6);
        int iV8 = v(iV4, iV7, iV6, iV5, this.f59544i[9], 14);
        int iV9 = v(iV5, iV8, iV7, iV6, this.f59544i[11], 12);
        int iV10 = v(iV6, iV9, iV8, iV7, this.f59544i[8], 13);
        int iV11 = v(iV7, iV10, iV9, iV8, this.f59544i[12], 5);
        int iV12 = v(iV8, iV11, iV10, iV9, this.f59544i[2], 14);
        int iV13 = v(iV9, iV12, iV11, iV10, this.f59544i[10], 13);
        int iV14 = v(iV10, iV13, iV12, iV11, this.f59544i[0], 13);
        int iV15 = v(iV11, iV14, iV13, iV12, this.f59544i[4], 7);
        int iV16 = v(iV12, iV15, iV14, iV13, this.f59544i[13], 5);
        int iU = u(iV13, iV16, iV15, iV14, this.f59544i[8], 15);
        int iU2 = u(iV14, iU, iV16, iV15, this.f59544i[6], 5);
        int iU3 = u(iV15, iU2, iU, iV16, this.f59544i[4], 8);
        int iU4 = u(iV16, iU3, iU2, iU, this.f59544i[1], 11);
        int iU5 = u(iU, iU4, iU3, iU2, this.f59544i[3], 14);
        int iU6 = u(iU2, iU5, iU4, iU3, this.f59544i[11], 14);
        int iU7 = u(iU3, iU6, iU5, iU4, this.f59544i[15], 6);
        int iU8 = u(iU4, iU7, iU6, iU5, this.f59544i[0], 14);
        int iU9 = u(iU5, iU8, iU7, iU6, this.f59544i[5], 6);
        int iU10 = u(iU6, iU9, iU8, iU7, this.f59544i[12], 9);
        int iU11 = u(iU7, iU10, iU9, iU8, this.f59544i[2], 12);
        int iU12 = u(iU8, iU11, iU10, iU9, this.f59544i[13], 9);
        int iU13 = u(iU9, iU12, iU11, iU10, this.f59544i[9], 12);
        int iU14 = u(iU10, iU13, iU12, iU11, this.f59544i[7], 5);
        int iU15 = u(iU11, iU14, iU13, iU12, this.f59544i[10], 15);
        int iU16 = u(iU12, iU15, iU14, iU13, this.f59544i[14], 8);
        int i14 = iU14 + iT15 + this.f59541f;
        this.f59541f = this.f59542g + iT14 + iU13;
        this.f59542g = this.f59543h + iT13 + iU16;
        this.f59543h = this.f59540e + iT16 + iU15;
        this.f59540e = i14;
        this.f59545j = 0;
        int i15 = 0;
        while (true) {
            int[] iArr = this.f59544i;
            if (i15 == iArr.length) {
                return;
            }
            iArr[i15] = 0;
            i15++;
        }
    }

    @Override // zo.l
    public void o(long j10) {
        if (this.f59545j > 14) {
            n();
        }
        int[] iArr = this.f59544i;
        iArr[14] = (int) ((-1) & j10);
        iArr[15] = (int) (j10 >>> 32);
    }

    @Override // zo.l
    public void p(byte[] bArr, int i10) {
        int[] iArr = this.f59544i;
        int i11 = this.f59545j;
        int i12 = i11 + 1;
        this.f59545j = i12;
        iArr[i11] = ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        if (i12 == 16) {
            n();
        }
    }

    public final int q(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(i10 + A(i11, i12, i13) + i14, i15);
    }

    public final int r(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(i10 + B(i11, i12, i13) + i14 + 1518500249, i15);
    }

    @Override // zo.l, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59540e = 1732584193;
        this.f59541f = -271733879;
        this.f59542g = -1732584194;
        this.f59543h = 271733878;
        this.f59545j = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f59544i;
            if (i10 == iArr.length) {
                return;
            }
            iArr[i10] = 0;
            i10++;
        }
    }

    public final int s(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(i10 + C(i11, i12, i13) + i14 + 1859775393, i15);
    }

    public final int t(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(((i10 + D(i11, i12, i13)) + i14) - 1894007588, i15);
    }

    public final int u(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(i10 + A(i11, i12, i13) + i14, i15);
    }

    public final int v(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(i10 + B(i11, i12, i13) + i14 + 1836072691, i15);
    }

    public final int w(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(i10 + C(i11, i12, i13) + i14 + 1548603684, i15);
    }

    public final int x(int i10, int i11, int i12, int i13, int i14, int i15) {
        return y(i10 + D(i11, i12, i13) + i14 + 1352829926, i15);
    }

    public final int y(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public final void z(y yVar) {
        super.k(yVar);
        this.f59540e = yVar.f59540e;
        this.f59541f = yVar.f59541f;
        this.f59542g = yVar.f59542g;
        this.f59543h = yVar.f59543h;
        int[] iArr = yVar.f59544i;
        System.arraycopy(iArr, 0, this.f59544i, 0, iArr.length);
        this.f59545j = yVar.f59545j;
    }
}
