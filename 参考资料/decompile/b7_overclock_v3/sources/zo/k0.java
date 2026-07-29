package zo;

/* JADX INFO: loaded from: classes5.dex */
public class k0 extends l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f59333i = 32;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f59334j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f59335k = new int[64];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f59336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f59337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f59339h;

    static {
        int i10;
        int i11 = 0;
        while (true) {
            if (i11 >= 16) {
                break;
            }
            f59335k[i11] = (2043430169 >>> (32 - i11)) | (2043430169 << i11);
            i11++;
        }
        for (i10 = 16; i10 < 64; i10++) {
            int i12 = i10 % 32;
            f59335k[i10] = (2055708042 >>> (32 - i12)) | (2055708042 << i12);
        }
    }

    public k0() {
        this.f59336e = new int[8];
        this.f59337f = new int[16];
        this.f59339h = new int[68];
        reset();
    }

    public k0(k0 k0Var) {
        super(k0Var);
        this.f59336e = new int[8];
        this.f59337f = new int[16];
        this.f59339h = new int[68];
        w(k0Var);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "SM3";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        l();
        org.bouncycastle.util.o.j(this.f59336e, bArr, i10);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new k0(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 32;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        k0 k0Var = (k0) mVar;
        super.k(k0Var);
        w(k0Var);
    }

    @Override // zo.l
    public void n() {
        int i10;
        int i11 = 0;
        while (true) {
            if (i11 >= 16) {
                break;
            }
            this.f59339h[i11] = this.f59337f[i11];
            i11++;
        }
        for (int i12 = 16; i12 < 68; i12++) {
            int[] iArr = this.f59339h;
            int i13 = iArr[i12 - 3];
            int i14 = iArr[i12 - 13];
            iArr[i12] = (v(((i13 >>> 17) | (i13 << 15)) ^ (iArr[i12 - 16] ^ iArr[i12 - 9])) ^ ((i14 >>> 25) | (i14 << 7))) ^ this.f59339h[i12 - 6];
        }
        int[] iArr2 = this.f59336e;
        int i15 = iArr2[0];
        int i16 = iArr2[1];
        int i17 = iArr2[2];
        int i18 = iArr2[3];
        int iU = iArr2[4];
        int i19 = iArr2[5];
        int i20 = iArr2[6];
        int i21 = iArr2[7];
        int i22 = i20;
        int i23 = 0;
        for (i10 = 16; i23 < i10; i10 = 16) {
            int i24 = (i15 << 12) | (i15 >>> 20);
            int i25 = i24 + iU + f59335k[i23];
            int i26 = (i25 << 7) | (i25 >>> 25);
            int[] iArr3 = this.f59339h;
            int i27 = iArr3[i23];
            int i28 = i27 ^ iArr3[i23 + 4];
            int iQ = q(i15, i16, i17) + i18;
            int iS = s(iU, i19, i22) + i21 + i26 + i27;
            int i29 = (i16 << 9) | (i16 >>> 23);
            int i30 = (i19 << 19) | (i19 >>> 13);
            i23++;
            i19 = iU;
            iU = u(iS);
            i18 = i17;
            i17 = i29;
            i21 = i22;
            i22 = i30;
            i16 = i15;
            i15 = iQ + (i26 ^ i24) + i28;
        }
        int i31 = i21;
        int iU2 = iU;
        int i32 = i22;
        int i33 = i18;
        int i34 = i17;
        int i35 = i16;
        int i36 = i15;
        int i37 = 16;
        while (i37 < 64) {
            int i38 = (i36 << 12) | (i36 >>> 20);
            int i39 = i38 + iU2 + f59335k[i37];
            int i40 = (i39 << 7) | (i39 >>> 25);
            int[] iArr4 = this.f59339h;
            int i41 = iArr4[i37];
            int i42 = i41 ^ iArr4[i37 + 4];
            int iR = r(i36, i35, i34) + i33;
            int iT = t(iU2, i19, i32) + i31 + i40 + i41;
            int i43 = (i19 << 19) | (i19 >>> 13);
            i37++;
            i19 = iU2;
            iU2 = u(iT);
            i33 = i34;
            i34 = (i35 >>> 23) | (i35 << 9);
            i35 = i36;
            i36 = iR + (i40 ^ i38) + i42;
            i31 = i32;
            i32 = i43;
        }
        int[] iArr5 = this.f59336e;
        iArr5[0] = i36 ^ iArr5[0];
        iArr5[1] = iArr5[1] ^ i35;
        iArr5[2] = iArr5[2] ^ i34;
        iArr5[3] = iArr5[3] ^ i33;
        iArr5[4] = iArr5[4] ^ iU2;
        iArr5[5] = iArr5[5] ^ i19;
        iArr5[6] = i32 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i31;
        this.f59338g = 0;
    }

    @Override // zo.l
    public void o(long j10) {
        int i10 = this.f59338g;
        if (i10 > 14) {
            this.f59337f[i10] = 0;
            this.f59338g = i10 + 1;
            n();
        }
        while (true) {
            int i11 = this.f59338g;
            if (i11 >= 14) {
                int[] iArr = this.f59337f;
                int i12 = i11 + 1;
                this.f59338g = i12;
                iArr[i11] = (int) (j10 >>> 32);
                this.f59338g = i12 + 1;
                iArr[i12] = (int) j10;
                return;
            }
            this.f59337f[i11] = 0;
            this.f59338g = i11 + 1;
        }
    }

    @Override // zo.l
    public void p(byte[] bArr, int i10) {
        int i11 = (bArr[i10] & 255) << 24;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 16);
        int i14 = i12 + 1;
        int i15 = (bArr[i14 + 1] & 255) | i13 | ((bArr[i14] & 255) << 8);
        int[] iArr = this.f59337f;
        int i16 = this.f59338g;
        iArr[i16] = i15;
        int i17 = i16 + 1;
        this.f59338g = i17;
        if (i17 >= 16) {
            n();
        }
    }

    public final int q(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public final int r(int i10, int i11, int i12) {
        return (i10 & i12) | (i10 & i11) | (i11 & i12);
    }

    @Override // zo.l, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        int[] iArr = this.f59336e;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.f59338g = 0;
    }

    public final int s(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public final int t(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    public final int u(int i10) {
        return (i10 ^ ((i10 << 9) | (i10 >>> 23))) ^ ((i10 << 17) | (i10 >>> 15));
    }

    public final int v(int i10) {
        return (i10 ^ ((i10 << 15) | (i10 >>> 17))) ^ ((i10 << 23) | (i10 >>> 9));
    }

    public final void w(k0 k0Var) {
        int[] iArr = k0Var.f59336e;
        int[] iArr2 = this.f59336e;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = k0Var.f59337f;
        int[] iArr4 = this.f59337f;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.f59338g = k0Var.f59338g;
    }
}
