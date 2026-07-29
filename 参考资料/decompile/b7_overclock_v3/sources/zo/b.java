package zo;

/* JADX INFO: loaded from: classes5.dex */
public class b implements org.bouncycastle.crypto.v {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f59160s = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[][] f59161t = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, 12, 0, 5, 2, 15, 13, 10, 14, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, 13, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, 13}, new byte[]{2, 12, 6, 10, 0, 11, 8, 3, 4, 13, 7, 5, 15, 14, 1, 9}, new byte[]{12, 5, 1, 15, 14, 13, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{13, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10}, new byte[]{6, 15, 14, 9, 11, 3, 0, 8, 12, 2, 13, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, 13, 0}};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f59162u = 10;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f59163v = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f59164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f59166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f59167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f59168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f59172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f59175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f59176m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f59177n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f59178o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f59179p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f59180q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f59181r;

    public b() {
        this(256);
    }

    public b(int i10) {
        this.f59164a = 32;
        this.f59165b = 0;
        this.f59166c = null;
        this.f59167d = null;
        this.f59168e = null;
        this.f59169f = 1;
        this.f59170g = 1;
        this.f59171h = 0;
        this.f59172i = 0L;
        this.f59173j = 0;
        this.f59174k = 0;
        this.f59175l = null;
        this.f59176m = 0;
        this.f59177n = new int[16];
        this.f59178o = null;
        this.f59179p = 0;
        this.f59180q = 0;
        this.f59181r = 0;
        if (i10 < 8 || i10 > 256 || i10 % 8 != 0) {
            throw new IllegalArgumentException("BLAKE2s digest bit length must be a multiple of 8 and not greater than 256");
        }
        this.f59164a = i10 / 8;
        k(null, null, null);
    }

    public b(int i10, int i11, long j10) {
        this.f59165b = 0;
        this.f59166c = null;
        this.f59167d = null;
        this.f59168e = null;
        this.f59175l = null;
        this.f59176m = 0;
        this.f59177n = new int[16];
        this.f59178o = null;
        this.f59179p = 0;
        this.f59180q = 0;
        this.f59181r = 0;
        this.f59164a = i10;
        this.f59172i = j10;
        this.f59169f = 0;
        this.f59170g = 0;
        this.f59171h = i11;
        this.f59174k = i11;
        this.f59173j = 0;
        k(null, null, null);
    }

    public b(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, long j10) {
        this.f59165b = 0;
        this.f59166c = null;
        this.f59167d = null;
        this.f59168e = null;
        this.f59169f = 1;
        this.f59170g = 1;
        this.f59171h = 0;
        this.f59173j = 0;
        this.f59174k = 0;
        this.f59175l = null;
        this.f59176m = 0;
        this.f59177n = new int[16];
        this.f59178o = null;
        this.f59179p = 0;
        this.f59180q = 0;
        this.f59181r = 0;
        this.f59164a = i10;
        this.f59172i = j10;
        k(bArr2, bArr3, bArr);
    }

    public b(b bVar) {
        this.f59164a = 32;
        this.f59165b = 0;
        this.f59166c = null;
        this.f59167d = null;
        this.f59168e = null;
        this.f59169f = 1;
        this.f59170g = 1;
        this.f59171h = 0;
        this.f59172i = 0L;
        this.f59173j = 0;
        this.f59174k = 0;
        this.f59175l = null;
        this.f59176m = 0;
        this.f59177n = new int[16];
        this.f59178o = null;
        this.f59179p = 0;
        this.f59180q = 0;
        this.f59181r = 0;
        this.f59176m = bVar.f59176m;
        this.f59175l = org.bouncycastle.util.a.p(bVar.f59175l);
        this.f59165b = bVar.f59165b;
        this.f59168e = org.bouncycastle.util.a.p(bVar.f59168e);
        this.f59164a = bVar.f59164a;
        this.f59177n = org.bouncycastle.util.a.s(this.f59177n);
        this.f59178o = org.bouncycastle.util.a.s(bVar.f59178o);
        this.f59179p = bVar.f59179p;
        this.f59180q = bVar.f59180q;
        this.f59181r = bVar.f59181r;
        this.f59166c = org.bouncycastle.util.a.p(bVar.f59166c);
        this.f59167d = org.bouncycastle.util.a.p(bVar.f59167d);
        this.f59169f = bVar.f59169f;
        this.f59170g = bVar.f59170g;
        this.f59171h = bVar.f59171h;
        this.f59172i = bVar.f59172i;
        this.f59173j = bVar.f59173j;
        this.f59174k = bVar.f59174k;
    }

    public b(byte[] bArr) {
        this.f59164a = 32;
        this.f59165b = 0;
        this.f59166c = null;
        this.f59167d = null;
        this.f59168e = null;
        this.f59169f = 1;
        this.f59170g = 1;
        this.f59171h = 0;
        this.f59172i = 0L;
        this.f59173j = 0;
        this.f59174k = 0;
        this.f59175l = null;
        this.f59176m = 0;
        this.f59177n = new int[16];
        this.f59178o = null;
        this.f59179p = 0;
        this.f59180q = 0;
        this.f59181r = 0;
        k(null, null, bArr);
    }

    public b(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3) {
        this.f59164a = 32;
        this.f59165b = 0;
        this.f59166c = null;
        this.f59167d = null;
        this.f59168e = null;
        this.f59169f = 1;
        this.f59170g = 1;
        this.f59171h = 0;
        this.f59172i = 0L;
        this.f59173j = 0;
        this.f59174k = 0;
        this.f59175l = null;
        this.f59176m = 0;
        this.f59177n = new int[16];
        this.f59178o = null;
        this.f59179p = 0;
        this.f59180q = 0;
        this.f59181r = 0;
        if (i10 < 1 || i10 > 32) {
            throw new IllegalArgumentException("Invalid digest length (required: 1 - 32)");
        }
        this.f59164a = i10;
        k(bArr2, bArr3, bArr);
    }

    public final void a(int i10, int i11, int i12, int i13, int i14, int i15) {
        int[] iArr = this.f59177n;
        iArr[i12] = iArr[i12] + iArr[i13] + i10;
        iArr[i15] = m(iArr[i15] ^ iArr[i12], 16);
        int[] iArr2 = this.f59177n;
        iArr2[i14] = iArr2[i14] + iArr2[i15];
        iArr2[i13] = m(iArr2[i13] ^ iArr2[i14], 12);
        int[] iArr3 = this.f59177n;
        iArr3[i12] = iArr3[i12] + iArr3[i13] + i11;
        iArr3[i15] = m(iArr3[i15] ^ iArr3[i12], 8);
        int[] iArr4 = this.f59177n;
        iArr4[i14] = iArr4[i14] + iArr4[i15];
        iArr4[i13] = m(iArr4[i13] ^ iArr4[i14], 7);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "BLAKE2s";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        int[] iArr;
        int i11;
        this.f59181r = -1;
        int i12 = this.f59179p;
        int i13 = this.f59176m;
        int i14 = i12 + i13;
        this.f59179p = i14;
        if (i14 < 0 && i13 > (-i14)) {
            this.f59180q++;
        }
        j(this.f59175l, 0);
        org.bouncycastle.util.a.d0(this.f59175l, (byte) 0);
        org.bouncycastle.util.a.h0(this.f59177n, 0);
        int i15 = 0;
        while (true) {
            iArr = this.f59178o;
            if (i15 >= iArr.length || (i11 = i15 * 4) >= this.f59164a) {
                break;
            }
            byte[] bArrP = org.bouncycastle.util.o.p(iArr[i15]);
            int i16 = this.f59164a;
            if (i11 < i16 - 4) {
                System.arraycopy(bArrP, 0, bArr, i11 + i10, 4);
            } else {
                System.arraycopy(bArrP, 0, bArr, i10 + i11, i16 - i11);
            }
            i15++;
        }
        org.bouncycastle.util.a.h0(iArr, 0);
        reset();
        return this.f59164a;
    }

    public void d() {
        byte[] bArr = this.f59168e;
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
            org.bouncycastle.util.a.d0(this.f59175l, (byte) 0);
        }
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59164a;
    }

    public void i() {
        byte[] bArr = this.f59166c;
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
        }
    }

    public final void j(byte[] bArr, int i10) {
        l();
        int[] iArr = new int[16];
        int i11 = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            iArr[i12] = org.bouncycastle.util.o.r(bArr, (i12 * 4) + i10);
        }
        for (int i13 = 0; i13 < 10; i13++) {
            byte[][] bArr2 = f59161t;
            a(iArr[bArr2[i13][0]], iArr[bArr2[i13][1]], 0, 4, 8, 12);
            a(iArr[bArr2[i13][2]], iArr[bArr2[i13][3]], 1, 5, 9, 13);
            a(iArr[bArr2[i13][4]], iArr[bArr2[i13][5]], 2, 6, 10, 14);
            a(iArr[bArr2[i13][6]], iArr[bArr2[i13][7]], 3, 7, 11, 15);
            a(iArr[bArr2[i13][8]], iArr[bArr2[i13][9]], 0, 5, 10, 15);
            a(iArr[bArr2[i13][10]], iArr[bArr2[i13][11]], 1, 6, 11, 12);
            a(iArr[bArr2[i13][12]], iArr[bArr2[i13][13]], 2, 7, 8, 13);
            a(iArr[bArr2[i13][14]], iArr[bArr2[i13][15]], 3, 4, 9, 14);
        }
        while (true) {
            int[] iArr2 = this.f59178o;
            if (i11 >= iArr2.length) {
                return;
            }
            int i14 = iArr2[i11];
            int[] iArr3 = this.f59177n;
            iArr2[i11] = (i14 ^ iArr3[i11]) ^ iArr3[i11 + 8];
            i11++;
        }
    }

    public final void k(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f59175l = new byte[64];
        if (bArr3 != null && bArr3.length > 0) {
            if (bArr3.length > 32) {
                throw new IllegalArgumentException("Keys > 32 bytes are not supported");
            }
            byte[] bArr4 = new byte[bArr3.length];
            this.f59168e = bArr4;
            System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            this.f59165b = bArr3.length;
            System.arraycopy(bArr3, 0, this.f59175l, 0, bArr3.length);
            this.f59176m = 64;
        }
        if (this.f59178o == null) {
            this.f59178o = new int[]{iArr[0] ^ ((this.f59164a | (this.f59165b << 8)) | ((this.f59169f << 16) | (this.f59170g << 24))), iArr[1] ^ this.f59171h, ((int) j) ^ iArr[2], ((i | (this.f59173j << 16)) | (this.f59174k << 24)) ^ i, iArr[4], iArr[5], 0, 0};
            int[] iArr = f59160s;
            long j10 = this.f59172i;
            int i10 = (int) (j10 >> 32);
            int i11 = iArr[3];
            if (bArr != null) {
                if (bArr.length != 8) {
                    throw new IllegalArgumentException("Salt length must be exactly 8 bytes");
                }
                byte[] bArr5 = new byte[8];
                this.f59166c = bArr5;
                System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
                int[] iArr2 = this.f59178o;
                iArr2[4] = iArr2[4] ^ org.bouncycastle.util.o.r(bArr, 0);
                int[] iArr3 = this.f59178o;
                iArr3[5] = org.bouncycastle.util.o.r(bArr, 4) ^ iArr3[5];
            }
            int[] iArr4 = this.f59178o;
            iArr4[6] = iArr[6];
            iArr4[7] = iArr[7];
            if (bArr2 != null) {
                if (bArr2.length != 8) {
                    throw new IllegalArgumentException("Personalization length must be exactly 8 bytes");
                }
                byte[] bArr6 = new byte[8];
                this.f59167d = bArr6;
                System.arraycopy(bArr2, 0, bArr6, 0, bArr2.length);
                int[] iArr5 = this.f59178o;
                iArr5[6] = iArr5[6] ^ org.bouncycastle.util.o.r(bArr2, 0);
                int[] iArr6 = this.f59178o;
                iArr6[7] = org.bouncycastle.util.o.r(bArr2, 4) ^ iArr6[7];
            }
        }
    }

    public final void l() {
        int[] iArr = this.f59178o;
        System.arraycopy(iArr, 0, this.f59177n, 0, iArr.length);
        int[] iArr2 = f59160s;
        System.arraycopy(iArr2, 0, this.f59177n, this.f59178o.length, 4);
        int[] iArr3 = this.f59177n;
        iArr3[12] = this.f59179p ^ iArr2[4];
        iArr3[13] = this.f59180q ^ iArr2[5];
        iArr3[14] = this.f59181r ^ iArr2[6];
        iArr3[15] = iArr2[7];
    }

    public final int m(int i10, int i11) {
        return (i10 << (32 - i11)) | (i10 >>> i11);
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59176m = 0;
        this.f59181r = 0;
        this.f59179p = 0;
        this.f59180q = 0;
        this.f59178o = null;
        org.bouncycastle.util.a.d0(this.f59175l, (byte) 0);
        byte[] bArr = this.f59168e;
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.f59175l, 0, bArr.length);
            this.f59176m = 64;
        }
        k(this.f59166c, this.f59167d, this.f59168e);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        int i10 = this.f59176m;
        if (64 - i10 != 0) {
            this.f59175l[i10] = b10;
            this.f59176m = i10 + 1;
            return;
        }
        int i11 = this.f59179p + 64;
        this.f59179p = i11;
        if (i11 == 0) {
            this.f59180q++;
        }
        j(this.f59175l, 0);
        org.bouncycastle.util.a.d0(this.f59175l, (byte) 0);
        this.f59175l[0] = b10;
        this.f59176m = 1;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        int i12;
        if (bArr == null || i11 == 0) {
            return;
        }
        int i13 = this.f59176m;
        if (i13 != 0) {
            i12 = 64 - i13;
            if (i12 >= i11) {
                System.arraycopy(bArr, i10, this.f59175l, i13, i11);
                this.f59176m += i11;
            }
            System.arraycopy(bArr, i10, this.f59175l, i13, i12);
            int i14 = this.f59179p + 64;
            this.f59179p = i14;
            if (i14 == 0) {
                this.f59180q++;
            }
            j(this.f59175l, 0);
            this.f59176m = 0;
            org.bouncycastle.util.a.d0(this.f59175l, (byte) 0);
        } else {
            i12 = 0;
        }
        int i15 = i11 + i10;
        int i16 = i15 - 64;
        int i17 = i10 + i12;
        while (i17 < i16) {
            int i18 = this.f59179p + 64;
            this.f59179p = i18;
            if (i18 == 0) {
                this.f59180q++;
            }
            j(bArr, i17);
            i17 += 64;
        }
        i11 = i15 - i17;
        System.arraycopy(bArr, i17, this.f59175l, 0, i11);
        this.f59176m += i11;
    }
}
