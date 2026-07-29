package ss;

import fp.d0;
import np.n1;
import np.o1;
import org.bouncycastle.crypto.m0;
import zo.e0;
import zo.h0;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f50450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f50452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f50453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f50454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f50455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f50456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f50457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f50458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f50459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f50460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f50461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f50462m;

    public static class a extends k {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final byte[] f50463n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final org.bouncycastle.crypto.s f50464o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final byte[] f50465p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final ip.k f50466q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final d0 f50467r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final byte[] f50468s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final org.bouncycastle.crypto.s f50469t;

        public a(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15) {
            d0 d0Var;
            super(z10, i10, i11, i12, i13, i14, i15);
            this.f50463n = new byte[64];
            e0 e0Var = new e0();
            this.f50464o = e0Var;
            if (i10 == 32) {
                this.f50469t = new h0();
                this.f50466q = new ip.k(new h0());
                d0Var = new d0(new h0());
            } else {
                this.f50469t = new e0();
                this.f50466q = new ip.k(new e0());
                d0Var = new d0(new e0());
            }
            this.f50467r = d0Var;
            this.f50465p = new byte[e0Var.h()];
            this.f50468s = new byte[this.f50466q.d()];
        }

        @Override // ss.k
        public byte[] a(byte[] bArr, ss.a aVar, byte[] bArr2) {
            byte[] bArrJ = j(aVar);
            if (this.f50450a) {
                bArr2 = i(org.bouncycastle.util.a.B(bArr, bArrJ), bArr2);
            }
            this.f50464o.update(bArr, 0, bArr.length);
            this.f50464o.update(this.f50463n, 0, 64 - bArr.length);
            this.f50464o.update(bArrJ, 0, bArrJ.length);
            this.f50464o.update(bArr2, 0, bArr2.length);
            this.f50464o.c(this.f50465p, 0);
            return org.bouncycastle.util.a.W(this.f50465p, 0, this.f50451b);
        }

        @Override // ss.k
        public byte[] b(byte[] bArr, ss.a aVar, byte[] bArr2, byte[] bArr3) {
            byte[] bArrB = org.bouncycastle.util.a.B(bArr2, bArr3);
            byte[] bArrJ = j(aVar);
            if (this.f50450a) {
                bArrB = i(org.bouncycastle.util.a.B(bArr, bArrJ), bArrB);
            }
            this.f50464o.update(bArr, 0, bArr.length);
            this.f50464o.update(this.f50463n, 0, 64 - this.f50451b);
            this.f50464o.update(bArrJ, 0, bArrJ.length);
            this.f50464o.update(bArrB, 0, bArrB.length);
            this.f50464o.c(this.f50465p, 0);
            return org.bouncycastle.util.a.W(this.f50465p, 0, this.f50451b);
        }

        @Override // ss.k
        public d c(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            int i10 = ((this.f50458i * this.f50459j) + 7) / 8;
            int i11 = this.f50460k;
            int i12 = i11 / this.f50457h;
            int i13 = i11 - i12;
            int i14 = (i12 + 7) / 8;
            int i15 = (i13 + 7) / 8;
            byte[] bArr5 = new byte[this.f50469t.h()];
            this.f50469t.update(bArr, 0, bArr.length);
            this.f50469t.update(bArr2, 0, bArr2.length);
            this.f50469t.update(bArr3, 0, bArr3.length);
            this.f50469t.update(bArr4, 0, bArr4.length);
            this.f50469t.c(bArr5, 0);
            byte[] bArrH = h(org.bouncycastle.util.a.C(bArr, bArr2, bArr5), new byte[i10 + i14 + i15]);
            byte[] bArr6 = new byte[8];
            System.arraycopy(bArrH, i10, bArr6, 8 - i15, i15);
            long jD = org.bouncycastle.util.o.d(bArr6, 0) & ((-1) >>> (64 - i13));
            byte[] bArr7 = new byte[4];
            System.arraycopy(bArrH, i15 + i10, bArr7, 4 - i14, i14);
            return new d(jD, org.bouncycastle.util.o.a(bArr7, 0) & ((-1) >>> (32 - i12)), org.bouncycastle.util.a.W(bArrH, 0, i10));
        }

        @Override // ss.k
        public byte[] d(byte[] bArr, ss.a aVar) {
            int length = bArr.length;
            this.f50464o.update(bArr, 0, bArr.length);
            byte[] bArrJ = j(aVar);
            this.f50464o.update(bArrJ, 0, bArrJ.length);
            this.f50464o.c(this.f50465p, 0);
            return org.bouncycastle.util.a.W(this.f50465p, 0, length);
        }

        @Override // ss.k
        public byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.f50466q.a(new n1(bArr));
            this.f50466q.update(bArr2, 0, bArr2.length);
            this.f50466q.update(bArr3, 0, bArr3.length);
            this.f50466q.c(this.f50468s, 0);
            return org.bouncycastle.util.a.W(this.f50468s, 0, this.f50451b);
        }

        @Override // ss.k
        public byte[] f(byte[] bArr, ss.a aVar, byte[] bArr2) {
            byte[] bArrJ = j(aVar);
            if (this.f50450a) {
                bArr2 = i(org.bouncycastle.util.a.B(bArr, bArrJ), bArr2);
            }
            this.f50464o.update(bArr, 0, bArr.length);
            this.f50464o.update(this.f50463n, 0, 64 - this.f50451b);
            this.f50464o.update(bArrJ, 0, bArrJ.length);
            this.f50464o.update(bArr2, 0, bArr2.length);
            this.f50464o.c(this.f50465p, 0);
            return org.bouncycastle.util.a.W(this.f50465p, 0, this.f50451b);
        }

        public byte[] h(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.f50467r.a(new o1(bArr));
            this.f50467r.b(bArr3, 0, length);
            for (int i10 = 0; i10 < bArr2.length; i10++) {
                bArr3[i10] = (byte) (bArr3[i10] ^ bArr2[i10]);
            }
            return bArr3;
        }

        public byte[] i(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            d0 d0Var = new d0(new e0());
            d0Var.a(new o1(bArr));
            d0Var.b(bArr3, 0, length);
            for (int i10 = 0; i10 < bArr2.length; i10++) {
                bArr3[i10] = (byte) (bArr3[i10] ^ bArr2[i10]);
            }
            return bArr3;
        }

        public final byte[] j(ss.a aVar) {
            byte[] bArr = new byte[22];
            System.arraycopy(aVar.f50426a, 3, bArr, 0, 1);
            System.arraycopy(aVar.f50426a, 8, bArr, 1, 8);
            System.arraycopy(aVar.f50426a, 19, bArr, 9, 1);
            System.arraycopy(aVar.f50426a, 20, bArr, 10, 12);
            return bArr;
        }
    }

    public static class b extends k {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final m0 f50470n;

        public b(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15) {
            super(z10, i10, i11, i12, i13, i14, i15);
            this.f50470n = new j0(256);
        }

        @Override // ss.k
        public byte[] a(byte[] bArr, ss.a aVar, byte[] bArr2) {
            if (this.f50450a) {
                bArr2 = h(bArr, aVar, bArr2);
            }
            int i10 = this.f50451b;
            byte[] bArr3 = new byte[i10];
            this.f50470n.update(bArr, 0, bArr.length);
            m0 m0Var = this.f50470n;
            byte[] bArr4 = aVar.f50426a;
            m0Var.update(bArr4, 0, bArr4.length);
            this.f50470n.update(bArr2, 0, bArr2.length);
            this.f50470n.f(bArr3, 0, i10);
            return bArr3;
        }

        @Override // ss.k
        public byte[] b(byte[] bArr, ss.a aVar, byte[] bArr2, byte[] bArr3) {
            byte[] bArrB = org.bouncycastle.util.a.B(bArr2, bArr3);
            if (this.f50450a) {
                bArrB = h(bArr, aVar, bArrB);
            }
            int i10 = this.f50451b;
            byte[] bArr4 = new byte[i10];
            this.f50470n.update(bArr, 0, bArr.length);
            m0 m0Var = this.f50470n;
            byte[] bArr5 = aVar.f50426a;
            m0Var.update(bArr5, 0, bArr5.length);
            this.f50470n.update(bArrB, 0, bArrB.length);
            this.f50470n.f(bArr4, 0, i10);
            return bArr4;
        }

        @Override // ss.k
        public d c(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            int i10 = ((this.f50458i * this.f50459j) + 7) / 8;
            int i11 = this.f50460k;
            int i12 = i11 / this.f50457h;
            int i13 = i11 - i12;
            int i14 = (i12 + 7) / 8;
            int i15 = (i13 + 7) / 8;
            int i16 = i10 + i14 + i15;
            byte[] bArr5 = new byte[i16];
            this.f50470n.update(bArr, 0, bArr.length);
            this.f50470n.update(bArr2, 0, bArr2.length);
            this.f50470n.update(bArr3, 0, bArr3.length);
            this.f50470n.update(bArr4, 0, bArr4.length);
            this.f50470n.f(bArr5, 0, i16);
            byte[] bArr6 = new byte[8];
            System.arraycopy(bArr5, i10, bArr6, 8 - i15, i15);
            long jD = org.bouncycastle.util.o.d(bArr6, 0) & ((-1) >>> (64 - i13));
            byte[] bArr7 = new byte[4];
            System.arraycopy(bArr5, i15 + i10, bArr7, 4 - i14, i14);
            return new d(jD, org.bouncycastle.util.o.a(bArr7, 0) & ((-1) >>> (32 - i12)), org.bouncycastle.util.a.W(bArr5, 0, i10));
        }

        @Override // ss.k
        public byte[] d(byte[] bArr, ss.a aVar) {
            this.f50470n.update(bArr, 0, bArr.length);
            m0 m0Var = this.f50470n;
            byte[] bArr2 = aVar.f50426a;
            m0Var.update(bArr2, 0, bArr2.length);
            int i10 = this.f50451b;
            byte[] bArr3 = new byte[i10];
            this.f50470n.f(bArr3, 0, i10);
            return bArr3;
        }

        @Override // ss.k
        public byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.f50470n.update(bArr, 0, bArr.length);
            this.f50470n.update(bArr2, 0, bArr2.length);
            this.f50470n.update(bArr3, 0, bArr3.length);
            int i10 = this.f50451b;
            byte[] bArr4 = new byte[i10];
            this.f50470n.f(bArr4, 0, i10);
            return bArr4;
        }

        @Override // ss.k
        public byte[] f(byte[] bArr, ss.a aVar, byte[] bArr2) {
            if (this.f50450a) {
                bArr2 = h(bArr, aVar, bArr2);
            }
            int i10 = this.f50451b;
            byte[] bArr3 = new byte[i10];
            this.f50470n.update(bArr, 0, bArr.length);
            m0 m0Var = this.f50470n;
            byte[] bArr4 = aVar.f50426a;
            m0Var.update(bArr4, 0, bArr4.length);
            this.f50470n.update(bArr2, 0, bArr2.length);
            this.f50470n.f(bArr3, 0, i10);
            return bArr3;
        }

        public byte[] h(byte[] bArr, ss.a aVar, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.f50470n.update(bArr, 0, bArr.length);
            m0 m0Var = this.f50470n;
            byte[] bArr4 = aVar.f50426a;
            m0Var.update(bArr4, 0, bArr4.length);
            this.f50470n.f(bArr3, 0, length);
            for (int i10 = 0; i10 < bArr2.length; i10++) {
                bArr3[i10] = (byte) (bArr3[i10] ^ bArr2[i10]);
            }
            return bArr3;
        }
    }

    public k(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f50451b = i10;
        if (i11 == 16) {
            this.f50453d = 4;
            this.f50455f = (i10 * 8) / 4;
            if (i10 <= 8) {
                this.f50456g = 2;
            } else if (i10 <= 136) {
                this.f50456g = 3;
            } else {
                if (i10 > 256) {
                    throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
                }
                this.f50456g = 4;
            }
        } else {
            if (i11 != 256) {
                throw new IllegalArgumentException("wots_w assumed 16 or 256");
            }
            this.f50453d = 8;
            this.f50455f = (i10 * 8) / 8;
            if (i10 <= 1) {
                this.f50456g = 1;
            } else {
                if (i10 > 256) {
                    throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
                }
                this.f50456g = 2;
            }
        }
        this.f50452c = i11;
        this.f50454e = this.f50455f + this.f50456g;
        this.f50450a = z10;
        this.f50457h = i12;
        this.f50458i = i13;
        this.f50459j = i14;
        this.f50460k = i15;
        this.f50461l = i15 / i12;
        this.f50462m = 1 << i13;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        byte[] bArrP = org.bouncycastle.util.a.p(bArr);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArrP[i10] = (byte) (bArrP[i10] ^ bArr2[i10]);
        }
        return bArrP;
    }

    public abstract byte[] a(byte[] bArr, ss.a aVar, byte[] bArr2);

    public abstract byte[] b(byte[] bArr, ss.a aVar, byte[] bArr2, byte[] bArr3);

    public abstract d c(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public abstract byte[] d(byte[] bArr, ss.a aVar);

    public abstract byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public abstract byte[] f(byte[] bArr, ss.a aVar, byte[] bArr2);
}
