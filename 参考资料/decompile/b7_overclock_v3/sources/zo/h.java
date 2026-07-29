package zo;

import java.lang.reflect.Array;
import np.n1;
import np.x1;

/* JADX INFO: loaded from: classes5.dex */
public class h implements org.bouncycastle.crypto.v, org.bouncycastle.util.m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f59289s = 32;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f59290t = {0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f59291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f59292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f59293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f59294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[][] f59295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f59296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f59298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public org.bouncycastle.crypto.f f59299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f59300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f59301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f59302l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public short[] f59303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public short[] f59304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f59305o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f59306p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public byte[] f59307q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f59308r;

    public h() {
        this.f59291a = new byte[32];
        this.f59292b = new byte[32];
        this.f59293c = new byte[32];
        this.f59294d = new byte[32];
        this.f59295e = (byte[][]) Array.newInstance((Class<?>) byte.class, 4, 32);
        this.f59296f = new byte[32];
        this.f59299i = new cp.z();
        this.f59301k = new byte[32];
        this.f59302l = new byte[8];
        this.f59303m = new short[16];
        this.f59304n = new short[16];
        this.f59305o = new byte[32];
        this.f59306p = new byte[32];
        this.f59307q = new byte[32];
        this.f59308r = new byte[32];
        byte[] bArrJ = cp.z.j("D-A");
        this.f59300j = bArrJ;
        this.f59299i.a(true, new x1(null, bArrJ));
        reset();
    }

    public h(h hVar) {
        this.f59291a = new byte[32];
        this.f59292b = new byte[32];
        this.f59293c = new byte[32];
        this.f59294d = new byte[32];
        this.f59295e = (byte[][]) Array.newInstance((Class<?>) byte.class, 4, 32);
        this.f59296f = new byte[32];
        this.f59299i = new cp.z();
        this.f59301k = new byte[32];
        this.f59302l = new byte[8];
        this.f59303m = new short[16];
        this.f59304n = new short[16];
        this.f59305o = new byte[32];
        this.f59306p = new byte[32];
        this.f59307q = new byte[32];
        this.f59308r = new byte[32];
        i(hVar);
    }

    public h(byte[] bArr) {
        this.f59291a = new byte[32];
        this.f59292b = new byte[32];
        this.f59293c = new byte[32];
        this.f59294d = new byte[32];
        this.f59295e = (byte[][]) Array.newInstance((Class<?>) byte.class, 4, 32);
        this.f59296f = new byte[32];
        this.f59299i = new cp.z();
        this.f59301k = new byte[32];
        this.f59302l = new byte[8];
        this.f59303m = new short[16];
        this.f59304n = new short[16];
        this.f59305o = new byte[32];
        this.f59306p = new byte[32];
        this.f59307q = new byte[32];
        this.f59308r = new byte[32];
        byte[] bArrP = org.bouncycastle.util.a.p(bArr);
        this.f59300j = bArrP;
        this.f59299i.a(true, new x1(null, bArrP));
        reset();
    }

    public final byte[] a(byte[] bArr) {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f59302l[i10] = (byte) (bArr[i10] ^ bArr[i10 + 8]);
        }
        System.arraycopy(bArr, 8, bArr, 0, 24);
        System.arraycopy(this.f59302l, 0, bArr, 24, 8);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "GOST3411";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        o();
        byte[] bArr2 = this.f59291a;
        System.arraycopy(bArr2, 0, bArr, i10, bArr2.length);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new h(this);
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 32;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        h hVar = (h) mVar;
        byte[] bArr = hVar.f59300j;
        this.f59300j = bArr;
        this.f59299i.a(true, new x1(null, bArr));
        reset();
        byte[] bArr2 = hVar.f59291a;
        System.arraycopy(bArr2, 0, this.f59291a, 0, bArr2.length);
        byte[] bArr3 = hVar.f59292b;
        System.arraycopy(bArr3, 0, this.f59292b, 0, bArr3.length);
        byte[] bArr4 = hVar.f59293c;
        System.arraycopy(bArr4, 0, this.f59293c, 0, bArr4.length);
        byte[] bArr5 = hVar.f59294d;
        System.arraycopy(bArr5, 0, this.f59294d, 0, bArr5.length);
        byte[][] bArr6 = hVar.f59295e;
        System.arraycopy(bArr6[1], 0, this.f59295e[1], 0, bArr6[1].length);
        byte[][] bArr7 = hVar.f59295e;
        System.arraycopy(bArr7[2], 0, this.f59295e[2], 0, bArr7[2].length);
        byte[][] bArr8 = hVar.f59295e;
        System.arraycopy(bArr8[3], 0, this.f59295e[3], 0, bArr8[3].length);
        byte[] bArr9 = hVar.f59296f;
        System.arraycopy(bArr9, 0, this.f59296f, 0, bArr9.length);
        this.f59297g = hVar.f59297g;
        this.f59298h = hVar.f59298h;
    }

    public final void k(byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, int i11) {
        this.f59299i.a(true, new n1(bArr));
        this.f59299i.d(bArr3, i11, bArr2, i10);
    }

    public final byte[] l(byte[] bArr) {
        for (int i10 = 0; i10 < 8; i10++) {
            byte[] bArr2 = this.f59301k;
            int i11 = i10 * 4;
            bArr2[i11] = bArr[i10];
            bArr2[i11 + 1] = bArr[i10 + 8];
            bArr2[i11 + 2] = bArr[i10 + 16];
            bArr2[i11 + 3] = bArr[i10 + 24];
        }
        return this.f59301k;
    }

    public final void m(byte[] bArr, short[] sArr) {
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            int i11 = i10 * 2;
            sArr[i10] = (short) ((bArr[i11] & 255) | ((bArr[i11 + 1] << 8) & 65280));
        }
    }

    public final void n(short[] sArr, byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            int i11 = i10 * 2;
            bArr[i11 + 1] = (byte) (sArr[i10] >> 8);
            bArr[i11] = (byte) sArr[i10];
        }
    }

    public final void o() {
        org.bouncycastle.util.o.F(this.f59298h * 8, this.f59292b, 0);
        while (this.f59297g != 0) {
            update((byte) 0);
        }
        q(this.f59292b, 0);
        q(this.f59294d, 0);
    }

    public final void p(byte[] bArr) {
        m(bArr, this.f59303m);
        short[] sArr = this.f59304n;
        short[] sArr2 = this.f59303m;
        sArr[15] = (short) (((((sArr2[0] ^ sArr2[1]) ^ sArr2[2]) ^ sArr2[3]) ^ sArr2[12]) ^ sArr2[15]);
        System.arraycopy(sArr2, 1, sArr, 0, 15);
        n(this.f59304n, bArr);
    }

    public void q(byte[] bArr, int i10) {
        System.arraycopy(bArr, i10, this.f59293c, 0, 32);
        System.arraycopy(this.f59291a, 0, this.f59306p, 0, 32);
        System.arraycopy(this.f59293c, 0, this.f59307q, 0, 32);
        for (int i11 = 0; i11 < 32; i11++) {
            this.f59308r[i11] = (byte) (this.f59306p[i11] ^ this.f59307q[i11]);
        }
        k(l(this.f59308r), this.f59305o, 0, this.f59291a, 0);
        for (int i12 = 1; i12 < 4; i12++) {
            byte[] bArrA = a(this.f59306p);
            for (int i13 = 0; i13 < 32; i13++) {
                this.f59306p[i13] = (byte) (bArrA[i13] ^ this.f59295e[i12][i13]);
            }
            this.f59307q = a(a(this.f59307q));
            for (int i14 = 0; i14 < 32; i14++) {
                this.f59308r[i14] = (byte) (this.f59306p[i14] ^ this.f59307q[i14]);
            }
            int i15 = i12 * 8;
            k(l(this.f59308r), this.f59305o, i15, this.f59291a, i15);
        }
        for (int i16 = 0; i16 < 12; i16++) {
            p(this.f59305o);
        }
        for (int i17 = 0; i17 < 32; i17++) {
            byte[] bArr2 = this.f59305o;
            bArr2[i17] = (byte) (bArr2[i17] ^ this.f59293c[i17]);
        }
        p(this.f59305o);
        for (int i18 = 0; i18 < 32; i18++) {
            byte[] bArr3 = this.f59305o;
            bArr3[i18] = (byte) (this.f59291a[i18] ^ bArr3[i18]);
        }
        for (int i19 = 0; i19 < 61; i19++) {
            p(this.f59305o);
        }
        byte[] bArr4 = this.f59305o;
        byte[] bArr5 = this.f59291a;
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
    }

    public final void r(byte[] bArr) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = this.f59294d;
            if (i10 == bArr2.length) {
                return;
            }
            int i12 = (bArr2[i10] & 255) + (bArr[i10] & 255) + i11;
            bArr2[i10] = (byte) i12;
            i11 = i12 >>> 8;
            i10++;
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59298h = 0L;
        this.f59297g = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f59291a;
            if (i10 >= bArr.length) {
                break;
            }
            bArr[i10] = 0;
            i10++;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr2 = this.f59292b;
            if (i11 >= bArr2.length) {
                break;
            }
            bArr2[i11] = 0;
            i11++;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr3 = this.f59293c;
            if (i12 >= bArr3.length) {
                break;
            }
            bArr3[i12] = 0;
            i12++;
        }
        int i13 = 0;
        while (true) {
            byte[][] bArr4 = this.f59295e;
            if (i13 >= bArr4[1].length) {
                break;
            }
            bArr4[1][i13] = 0;
            i13++;
        }
        int i14 = 0;
        while (true) {
            byte[][] bArr5 = this.f59295e;
            if (i14 >= bArr5[3].length) {
                break;
            }
            bArr5[3][i14] = 0;
            i14++;
        }
        int i15 = 0;
        while (true) {
            byte[] bArr6 = this.f59294d;
            if (i15 >= bArr6.length) {
                break;
            }
            bArr6[i15] = 0;
            i15++;
        }
        int i16 = 0;
        while (true) {
            byte[] bArr7 = this.f59296f;
            if (i16 >= bArr7.length) {
                byte[] bArr8 = f59290t;
                System.arraycopy(bArr8, 0, this.f59295e[2], 0, bArr8.length);
                return;
            } else {
                bArr7[i16] = 0;
                i16++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        byte[] bArr = this.f59296f;
        int i10 = this.f59297g;
        int i11 = i10 + 1;
        this.f59297g = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            r(bArr);
            q(this.f59296f, 0);
            this.f59297g = 0;
        }
        this.f59298h++;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        while (this.f59297g != 0 && i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        while (true) {
            byte[] bArr2 = this.f59296f;
            if (i11 <= bArr2.length) {
                break;
            }
            System.arraycopy(bArr, i10, bArr2, 0, bArr2.length);
            r(this.f59296f);
            q(this.f59296f, 0);
            byte[] bArr3 = this.f59296f;
            i10 += bArr3.length;
            i11 -= bArr3.length;
            this.f59298h += (long) bArr3.length;
        }
        while (i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
    }
}
