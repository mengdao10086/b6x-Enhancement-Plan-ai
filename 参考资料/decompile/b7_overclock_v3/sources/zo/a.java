package zo;

import android.R;

/* JADX INFO: loaded from: classes5.dex */
public class a implements org.bouncycastle.crypto.v {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long[] f59133m = {7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[][] f59134n = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, 12, 0, 5, 2, 15, 13, 10, 14, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, 13, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, 13}, new byte[]{2, 12, 6, 10, 0, 11, 8, 3, 4, 13, 7, 5, 15, 14, 1, 9}, new byte[]{12, 5, 1, 15, 14, 13, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{13, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10}, new byte[]{6, 15, 14, 9, 11, 3, 0, 8, 12, 2, 13, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, 13, 0}, new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f59135o = 12;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f59136p = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f59137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f59139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f59140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f59141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f59142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long[] f59144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long[] f59145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f59146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f59147k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f59148l;

    public a() {
        this(512);
    }

    public a(int i10) {
        this.f59137a = 64;
        this.f59138b = 0;
        this.f59139c = null;
        this.f59140d = null;
        this.f59141e = null;
        this.f59142f = null;
        this.f59143g = 0;
        this.f59144h = new long[16];
        this.f59145i = null;
        this.f59146j = 0L;
        this.f59147k = 0L;
        this.f59148l = 0L;
        if (i10 < 8 || i10 > 512 || i10 % 8 != 0) {
            throw new IllegalArgumentException("BLAKE2b digest bit length must be a multiple of 8 and not greater than 512");
        }
        this.f59142f = new byte[128];
        this.f59138b = 0;
        this.f59137a = i10 / 8;
        k();
    }

    public a(a aVar) {
        this.f59137a = 64;
        this.f59138b = 0;
        this.f59139c = null;
        this.f59140d = null;
        this.f59141e = null;
        this.f59142f = null;
        this.f59143g = 0;
        this.f59144h = new long[16];
        this.f59145i = null;
        this.f59146j = 0L;
        this.f59147k = 0L;
        this.f59148l = 0L;
        this.f59143g = aVar.f59143g;
        this.f59142f = org.bouncycastle.util.a.p(aVar.f59142f);
        this.f59138b = aVar.f59138b;
        this.f59141e = org.bouncycastle.util.a.p(aVar.f59141e);
        this.f59137a = aVar.f59137a;
        this.f59145i = org.bouncycastle.util.a.t(aVar.f59145i);
        this.f59140d = org.bouncycastle.util.a.p(aVar.f59140d);
        this.f59139c = org.bouncycastle.util.a.p(aVar.f59139c);
        this.f59146j = aVar.f59146j;
        this.f59147k = aVar.f59147k;
        this.f59148l = aVar.f59148l;
    }

    public a(byte[] bArr) {
        this.f59137a = 64;
        this.f59138b = 0;
        this.f59139c = null;
        this.f59140d = null;
        this.f59141e = null;
        this.f59143g = 0;
        this.f59144h = new long[16];
        this.f59145i = null;
        this.f59146j = 0L;
        this.f59147k = 0L;
        this.f59148l = 0L;
        this.f59142f = new byte[128];
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.f59141e = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            if (bArr.length > 64) {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
            this.f59138b = bArr.length;
            System.arraycopy(bArr, 0, this.f59142f, 0, bArr.length);
            this.f59143g = 128;
        }
        this.f59137a = 64;
        k();
    }

    public a(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3) {
        this.f59137a = 64;
        this.f59138b = 0;
        this.f59139c = null;
        this.f59140d = null;
        this.f59141e = null;
        this.f59143g = 0;
        this.f59144h = new long[16];
        this.f59145i = null;
        this.f59146j = 0L;
        this.f59147k = 0L;
        this.f59148l = 0L;
        this.f59142f = new byte[128];
        if (i10 < 1 || i10 > 64) {
            throw new IllegalArgumentException("Invalid digest length (required: 1 - 64)");
        }
        this.f59137a = i10;
        if (bArr2 != null) {
            if (bArr2.length != 16) {
                throw new IllegalArgumentException("salt length must be exactly 16 bytes");
            }
            byte[] bArr4 = new byte[16];
            this.f59139c = bArr4;
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        }
        if (bArr3 != null) {
            if (bArr3.length != 16) {
                throw new IllegalArgumentException("personalization length must be exactly 16 bytes");
            }
            byte[] bArr5 = new byte[16];
            this.f59140d = bArr5;
            System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        }
        if (bArr != null) {
            byte[] bArr6 = new byte[bArr.length];
            this.f59141e = bArr6;
            System.arraycopy(bArr, 0, bArr6, 0, bArr.length);
            if (bArr.length > 64) {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
            this.f59138b = bArr.length;
            System.arraycopy(bArr, 0, this.f59142f, 0, bArr.length);
            this.f59143g = 128;
        }
        k();
    }

    public final void a(long j10, long j11, int i10, int i11, int i12, int i13) {
        long[] jArr = this.f59144h;
        jArr[i10] = jArr[i10] + jArr[i11] + j10;
        jArr[i13] = org.bouncycastle.util.l.f(jArr[i13] ^ jArr[i10], 32);
        long[] jArr2 = this.f59144h;
        jArr2[i12] = jArr2[i12] + jArr2[i13];
        jArr2[i11] = org.bouncycastle.util.l.f(jArr2[i11] ^ jArr2[i12], 24);
        long[] jArr3 = this.f59144h;
        jArr3[i10] = jArr3[i10] + jArr3[i11] + j11;
        jArr3[i13] = org.bouncycastle.util.l.f(jArr3[i13] ^ jArr3[i10], 16);
        long[] jArr4 = this.f59144h;
        jArr4[i12] = jArr4[i12] + jArr4[i13];
        jArr4[i11] = org.bouncycastle.util.l.f(jArr4[i11] ^ jArr4[i12], 63);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "BLAKE2b";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        long[] jArr;
        int i11;
        this.f59148l = -1L;
        long j10 = this.f59146j;
        int i12 = this.f59143g;
        long j11 = j10 + ((long) i12);
        this.f59146j = j11;
        if (i12 > 0 && j11 == 0) {
            this.f59147k++;
        }
        j(this.f59142f, 0);
        org.bouncycastle.util.a.d0(this.f59142f, (byte) 0);
        org.bouncycastle.util.a.k0(this.f59144h, 0L);
        int i13 = 0;
        while (true) {
            jArr = this.f59145i;
            if (i13 >= jArr.length || (i11 = i13 * 8) >= this.f59137a) {
                break;
            }
            byte[] bArrI = org.bouncycastle.util.o.I(jArr[i13]);
            int i14 = this.f59137a;
            if (i11 < i14 - 8) {
                System.arraycopy(bArrI, 0, bArr, i11 + i10, 8);
            } else {
                System.arraycopy(bArrI, 0, bArr, i10 + i11, i14 - i11);
            }
            i13++;
        }
        org.bouncycastle.util.a.k0(jArr, 0L);
        reset();
        return this.f59137a;
    }

    public void d() {
        byte[] bArr = this.f59141e;
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
            org.bouncycastle.util.a.d0(this.f59142f, (byte) 0);
        }
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 128;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59137a;
    }

    public void i() {
        byte[] bArr = this.f59139c;
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
        }
    }

    public final void j(byte[] bArr, int i10) {
        l();
        long[] jArr = new long[16];
        int i11 = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            jArr[i12] = org.bouncycastle.util.o.v(bArr, (i12 * 8) + i10);
        }
        for (int i13 = 0; i13 < f59135o; i13++) {
            byte[][] bArr2 = f59134n;
            a(jArr[bArr2[i13][0]], jArr[bArr2[i13][1]], 0, 4, 8, 12);
            a(jArr[bArr2[i13][2]], jArr[bArr2[i13][3]], 1, 5, 9, 13);
            a(jArr[bArr2[i13][4]], jArr[bArr2[i13][5]], 2, 6, 10, 14);
            a(jArr[bArr2[i13][6]], jArr[bArr2[i13][7]], 3, 7, 11, 15);
            a(jArr[bArr2[i13][8]], jArr[bArr2[i13][9]], 0, 5, 10, 15);
            a(jArr[bArr2[i13][10]], jArr[bArr2[i13][11]], 1, 6, 11, 12);
            a(jArr[bArr2[i13][12]], jArr[bArr2[i13][13]], 2, 7, 8, 13);
            a(jArr[bArr2[i13][14]], jArr[bArr2[i13][15]], 3, 4, 9, 14);
        }
        while (true) {
            long[] jArr2 = this.f59145i;
            if (i11 >= jArr2.length) {
                return;
            }
            long j10 = jArr2[i11];
            long[] jArr3 = this.f59144h;
            jArr2[i11] = (j10 ^ jArr3[i11]) ^ jArr3[i11 + 8];
            i11++;
        }
    }

    public final void k() {
        if (this.f59145i == null) {
            long[] jArr = {jArr[0] ^ ((long) ((this.f59137a | (this.f59138b << 8)) | R.attr.theme)), jArr[1], jArr[2], jArr[3], jArr[4], jArr[5], 0, 0};
            this.f59145i = jArr;
            long[] jArr2 = f59133m;
            byte[] bArr = this.f59139c;
            if (bArr != null) {
                jArr[4] = jArr[4] ^ org.bouncycastle.util.o.v(bArr, 0);
                long[] jArr3 = this.f59145i;
                jArr3[5] = jArr3[5] ^ org.bouncycastle.util.o.v(this.f59139c, 8);
            }
            long[] jArr4 = this.f59145i;
            jArr4[6] = jArr2[6];
            jArr4[7] = jArr2[7];
            byte[] bArr2 = this.f59140d;
            if (bArr2 != null) {
                jArr4[6] = org.bouncycastle.util.o.v(bArr2, 0) ^ jArr4[6];
                long[] jArr5 = this.f59145i;
                jArr5[7] = jArr5[7] ^ org.bouncycastle.util.o.v(this.f59140d, 8);
            }
        }
    }

    public final void l() {
        long[] jArr = this.f59145i;
        System.arraycopy(jArr, 0, this.f59144h, 0, jArr.length);
        long[] jArr2 = f59133m;
        System.arraycopy(jArr2, 0, this.f59144h, this.f59145i.length, 4);
        long[] jArr3 = this.f59144h;
        jArr3[12] = this.f59146j ^ jArr2[4];
        jArr3[13] = this.f59147k ^ jArr2[5];
        jArr3[14] = this.f59148l ^ jArr2[6];
        jArr3[15] = jArr2[7];
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59143g = 0;
        this.f59148l = 0L;
        this.f59146j = 0L;
        this.f59147k = 0L;
        this.f59145i = null;
        org.bouncycastle.util.a.d0(this.f59142f, (byte) 0);
        byte[] bArr = this.f59141e;
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.f59142f, 0, bArr.length);
            this.f59143g = 128;
        }
        k();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        int i10 = this.f59143g;
        if (128 - i10 != 0) {
            this.f59142f[i10] = b10;
            this.f59143g = i10 + 1;
            return;
        }
        long j10 = this.f59146j + 128;
        this.f59146j = j10;
        if (j10 == 0) {
            this.f59147k++;
        }
        j(this.f59142f, 0);
        org.bouncycastle.util.a.d0(this.f59142f, (byte) 0);
        this.f59142f[0] = b10;
        this.f59143g = 1;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        int i12;
        if (bArr == null || i11 == 0) {
            return;
        }
        int i13 = this.f59143g;
        if (i13 != 0) {
            i12 = 128 - i13;
            if (i12 >= i11) {
                System.arraycopy(bArr, i10, this.f59142f, i13, i11);
                this.f59143g += i11;
            }
            System.arraycopy(bArr, i10, this.f59142f, i13, i12);
            long j10 = this.f59146j + 128;
            this.f59146j = j10;
            if (j10 == 0) {
                this.f59147k++;
            }
            j(this.f59142f, 0);
            this.f59143g = 0;
            org.bouncycastle.util.a.d0(this.f59142f, (byte) 0);
        } else {
            i12 = 0;
        }
        int i14 = i11 + i10;
        int i15 = i14 - 128;
        int i16 = i10 + i12;
        while (i16 < i15) {
            long j11 = this.f59146j + 128;
            this.f59146j = j11;
            if (j11 == 0) {
                this.f59147k++;
            }
            j(bArr, i16);
            i16 += 128;
        }
        i11 = i14 - i16;
        System.arraycopy(bArr, i16, this.f59142f, 0, i11);
        this.f59143g += i11;
    }
}
