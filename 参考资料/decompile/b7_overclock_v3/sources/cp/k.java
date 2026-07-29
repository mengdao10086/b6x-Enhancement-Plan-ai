package cp;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends j {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f25406v = 12;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f25407w = 16;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f25408q = new int[48];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f25409r = new int[48];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f25410s = new int[192];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f25411t = new int[192];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int[] f25412u = new int[8];

    @Override // cp.j, org.bouncycastle.crypto.f
    public String b() {
        return "CAST6";
    }

    @Override // cp.j, org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // cp.j
    public int n(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = new int[4];
        q(g(bArr, i10), g(bArr, i10 + 4), g(bArr, i10 + 8), g(bArr, i10 + 12), iArr);
        e(iArr[0], bArr2, i11);
        e(iArr[1], bArr2, i11 + 4);
        e(iArr[2], bArr2, i11 + 8);
        e(iArr[3], bArr2, i11 + 12);
        return 16;
    }

    @Override // cp.j
    public int o(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = new int[4];
        r(g(bArr, i10), g(bArr, i10 + 4), g(bArr, i10 + 8), g(bArr, i10 + 12), iArr);
        e(iArr[0], bArr2, i11);
        e(iArr[1], bArr2, i11 + 4);
        e(iArr[2], bArr2, i11 + 8);
        e(iArr[3], bArr2, i11 + 12);
        return 16;
    }

    @Override // cp.j
    public void p(byte[] bArr) {
        int i10 = 1518500249;
        int i11 = 19;
        for (int i12 = 0; i12 < 24; i12++) {
            for (int i13 = 0; i13 < 8; i13++) {
                int i14 = (i12 * 8) + i13;
                this.f25411t[i14] = i10;
                i10 += 1859775393;
                this.f25410s[i14] = i11;
                i11 = (i11 + 17) & 31;
            }
        }
        byte[] bArr2 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i15 = 0; i15 < 8; i15++) {
            this.f25412u[i15] = g(bArr2, i15 * 4);
        }
        for (int i16 = 0; i16 < 12; i16++) {
            int i17 = i16 * 2;
            int i18 = i17 * 8;
            int[] iArr = this.f25412u;
            iArr[6] = iArr[6] ^ j(iArr[7], this.f25411t[i18], this.f25410s[i18]);
            int[] iArr2 = this.f25412u;
            int i19 = i18 + 1;
            iArr2[5] = iArr2[5] ^ k(iArr2[6], this.f25411t[i19], this.f25410s[i19]);
            int[] iArr3 = this.f25412u;
            int i20 = i18 + 2;
            iArr3[4] = iArr3[4] ^ l(iArr3[5], this.f25411t[i20], this.f25410s[i20]);
            int[] iArr4 = this.f25412u;
            int i21 = i18 + 3;
            iArr4[3] = j(iArr4[4], this.f25411t[i21], this.f25410s[i21]) ^ iArr4[3];
            int[] iArr5 = this.f25412u;
            int i22 = i18 + 4;
            iArr5[2] = k(iArr5[3], this.f25411t[i22], this.f25410s[i22]) ^ iArr5[2];
            int[] iArr6 = this.f25412u;
            int i23 = i18 + 5;
            iArr6[1] = l(iArr6[2], this.f25411t[i23], this.f25410s[i23]) ^ iArr6[1];
            int[] iArr7 = this.f25412u;
            int i24 = i18 + 6;
            iArr7[0] = iArr7[0] ^ j(iArr7[1], this.f25411t[i24], this.f25410s[i24]);
            int[] iArr8 = this.f25412u;
            int i25 = i18 + 7;
            iArr8[7] = k(iArr8[0], this.f25411t[i25], this.f25410s[i25]) ^ iArr8[7];
            int i26 = (i17 + 1) * 8;
            int[] iArr9 = this.f25412u;
            iArr9[6] = iArr9[6] ^ j(iArr9[7], this.f25411t[i26], this.f25410s[i26]);
            int[] iArr10 = this.f25412u;
            int i27 = i26 + 1;
            iArr10[5] = iArr10[5] ^ k(iArr10[6], this.f25411t[i27], this.f25410s[i27]);
            int[] iArr11 = this.f25412u;
            int i28 = i26 + 2;
            iArr11[4] = iArr11[4] ^ l(iArr11[5], this.f25411t[i28], this.f25410s[i28]);
            int[] iArr12 = this.f25412u;
            int i29 = i26 + 3;
            iArr12[3] = j(iArr12[4], this.f25411t[i29], this.f25410s[i29]) ^ iArr12[3];
            int[] iArr13 = this.f25412u;
            int i30 = i26 + 4;
            iArr13[2] = k(iArr13[3], this.f25411t[i30], this.f25410s[i30]) ^ iArr13[2];
            int[] iArr14 = this.f25412u;
            int i31 = i26 + 5;
            iArr14[1] = l(iArr14[2], this.f25411t[i31], this.f25410s[i31]) ^ iArr14[1];
            int[] iArr15 = this.f25412u;
            int i32 = i26 + 6;
            iArr15[0] = iArr15[0] ^ j(iArr15[1], this.f25411t[i32], this.f25410s[i32]);
            int[] iArr16 = this.f25412u;
            int i33 = i26 + 7;
            iArr16[7] = k(iArr16[0], this.f25411t[i33], this.f25410s[i33]) ^ iArr16[7];
            int[] iArr17 = this.f25408q;
            int i34 = i16 * 4;
            int[] iArr18 = this.f25412u;
            iArr17[i34] = iArr18[0] & 31;
            int i35 = i34 + 1;
            iArr17[i35] = iArr18[2] & 31;
            int i36 = i34 + 2;
            iArr17[i36] = iArr18[4] & 31;
            int i37 = i34 + 3;
            iArr17[i37] = iArr18[6] & 31;
            int[] iArr19 = this.f25409r;
            iArr19[i34] = iArr18[7];
            iArr19[i35] = iArr18[5];
            iArr19[i36] = iArr18[3];
            iArr19[i37] = iArr18[1];
        }
    }

    public final void q(int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15 = 0;
        while (true) {
            if (i15 >= 6) {
                break;
            }
            int i16 = (11 - i15) * 4;
            i12 ^= j(i13, this.f25409r[i16], this.f25408q[i16]);
            int i17 = i16 + 1;
            i11 ^= k(i12, this.f25409r[i17], this.f25408q[i17]);
            int i18 = i16 + 2;
            i10 ^= l(i11, this.f25409r[i18], this.f25408q[i18]);
            int i19 = i16 + 3;
            i13 ^= j(i10, this.f25409r[i19], this.f25408q[i19]);
            i15++;
        }
        for (i14 = 6; i14 < 12; i14++) {
            int i20 = (11 - i14) * 4;
            int i21 = i20 + 3;
            i13 ^= j(i10, this.f25409r[i21], this.f25408q[i21]);
            int i22 = i20 + 2;
            i10 ^= l(i11, this.f25409r[i22], this.f25408q[i22]);
            int i23 = i20 + 1;
            i11 ^= k(i12, this.f25409r[i23], this.f25408q[i23]);
            i12 ^= j(i13, this.f25409r[i20], this.f25408q[i20]);
        }
        iArr[0] = i10;
        iArr[1] = i11;
        iArr[2] = i12;
        iArr[3] = i13;
    }

    public final void r(int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15 = 0;
        while (true) {
            if (i15 >= 6) {
                break;
            }
            int i16 = i15 * 4;
            i12 ^= j(i13, this.f25409r[i16], this.f25408q[i16]);
            int i17 = i16 + 1;
            i11 ^= k(i12, this.f25409r[i17], this.f25408q[i17]);
            int i18 = i16 + 2;
            i10 ^= l(i11, this.f25409r[i18], this.f25408q[i18]);
            int i19 = i16 + 3;
            i13 ^= j(i10, this.f25409r[i19], this.f25408q[i19]);
            i15++;
        }
        for (i14 = 6; i14 < 12; i14++) {
            int i20 = i14 * 4;
            int i21 = i20 + 3;
            i13 ^= j(i10, this.f25409r[i21], this.f25408q[i21]);
            int i22 = i20 + 2;
            i10 ^= l(i11, this.f25409r[i22], this.f25408q[i22]);
            int i23 = i20 + 1;
            i11 ^= k(i12, this.f25409r[i23], this.f25408q[i23]);
            i12 ^= j(i13, this.f25409r[i20], this.f25408q[i20]);
        }
        iArr[0] = i10;
        iArr[1] = i11;
        iArr[2] = i12;
        iArr[3] = i13;
    }

    @Override // cp.j, org.bouncycastle.crypto.f
    public void reset() {
    }
}
