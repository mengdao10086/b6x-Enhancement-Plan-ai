package fp;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f28544e = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f28545f = 128;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f28546g = 128;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f28547h = 64;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f28548i = 72;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f28549j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f28550k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f28551l = 16777216;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f28552m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f28553n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f28554o = 4294967295L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f28555p = new byte[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public np.b f28556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b[] f28557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f28558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28559d;

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f28560b = 128;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f28561a;

        public b() {
            this.f28561a = new long[128];
        }

        public b f() {
            org.bouncycastle.util.a.k0(this.f28561a, 0L);
            return this;
        }

        public final void g(b bVar) {
            System.arraycopy(bVar.f28561a, 0, this.f28561a, 0, 128);
        }

        public void h(byte[] bArr) {
            if (bArr.length < 1024) {
                throw new IllegalArgumentException("input shorter than blocksize");
            }
            org.bouncycastle.util.o.w(bArr, 0, this.f28561a);
        }

        public void i(byte[] bArr) {
            if (bArr.length < 1024) {
                throw new IllegalArgumentException("output shorter than blocksize");
            }
            org.bouncycastle.util.o.H(this.f28561a, bArr, 0);
        }

        public final void j(b bVar, b bVar2) {
            long[] jArr = this.f28561a;
            long[] jArr2 = bVar.f28561a;
            long[] jArr3 = bVar2.f28561a;
            for (int i10 = 0; i10 < 128; i10++) {
                jArr[i10] = jArr2[i10] ^ jArr3[i10];
            }
        }

        public final void k(b bVar) {
            long[] jArr = this.f28561a;
            long[] jArr2 = bVar.f28561a;
            for (int i10 = 0; i10 < 128; i10++) {
                jArr[i10] = jArr[i10] ^ jArr2[i10];
            }
        }

        public final void l(b bVar, b bVar2) {
            long[] jArr = this.f28561a;
            long[] jArr2 = bVar.f28561a;
            long[] jArr3 = bVar2.f28561a;
            for (int i10 = 0; i10 < 128; i10++) {
                jArr[i10] = jArr[i10] ^ (jArr2[i10] ^ jArr3[i10]);
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f28562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f28563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f28564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f28565d;

        public c() {
            this.f28562a = new b();
            this.f28563b = new b();
            this.f28564c = new b();
            this.f28565d = new b();
        }

        public final void d() {
            for (int i10 = 0; i10 < 8; i10++) {
                int i11 = i10 * 16;
                a.C(this.f28563b, i11, i11 + 1, i11 + 2, i11 + 3, i11 + 4, i11 + 5, i11 + 6, i11 + 7, i11 + 8, i11 + 9, i11 + 10, i11 + 11, i11 + 12, i11 + 13, i11 + 14, i11 + 15);
            }
            for (int i12 = 0; i12 < 8; i12++) {
                int i13 = i12 * 2;
                a.C(this.f28563b, i13, i13 + 1, i13 + 16, i13 + 17, i13 + 32, i13 + 33, i13 + 48, i13 + 49, i13 + 64, i13 + 65, i13 + 80, i13 + 81, i13 + 96, i13 + 97, i13 + 112, i13 + 113);
            }
        }

        public final void e(b bVar, b bVar2) {
            this.f28563b.g(bVar);
            d();
            bVar2.j(bVar, this.f28563b);
        }

        public final void f(b bVar, b bVar2, b bVar3) {
            this.f28562a.j(bVar, bVar2);
            this.f28563b.g(this.f28562a);
            d();
            bVar3.j(this.f28562a, this.f28563b);
        }

        public final void g(b bVar, b bVar2, b bVar3) {
            this.f28562a.j(bVar, bVar2);
            this.f28563b.g(this.f28562a);
            d();
            bVar3.l(this.f28562a, this.f28563b);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f28567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f28568c;
    }

    public static void A(long[] jArr, int i10, int i11, int i12, int i13) {
        long j10 = jArr[i10];
        long j11 = jArr[i11];
        long j12 = j10 + j11 + ((j10 & 4294967295L) * 2 * (4294967295L & j11));
        long jF = org.bouncycastle.util.l.f(jArr[i12] ^ j12, i13);
        jArr[i10] = j12;
        jArr[i12] = jF;
    }

    public static void C(b bVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25) {
        long[] jArr = bVar.f28561a;
        a(jArr, i10, i14, i18, i22);
        a(jArr, i11, i15, i19, i23);
        a(jArr, i12, i16, i20, i24);
        a(jArr, i13, i17, i21, i25);
        a(jArr, i10, i15, i20, i25);
        a(jArr, i11, i16, i21, i22);
        a(jArr, i12, i17, i18, i23);
        a(jArr, i13, i14, i19, i24);
    }

    public static void a(long[] jArr, int i10, int i11, int i12, int i13) {
        A(jArr, i10, i11, i13, 32);
        A(jArr, i12, i13, i11, 24);
        A(jArr, i10, i11, i13, 16);
        A(jArr, i12, i13, i11, 63);
    }

    public static void c(byte[] bArr, org.bouncycastle.crypto.s sVar, byte[] bArr2) {
        if (bArr2 == null) {
            sVar.update(f28555p, 0, 4);
            return;
        }
        org.bouncycastle.util.o.m(bArr2.length, bArr, 0);
        sVar.update(bArr, 0, 4);
        sVar.update(bArr2, 0, bArr2.length);
    }

    public static int q(d dVar) {
        return (dVar.f28566a == 0 && dVar.f28568c == 0) ? 2 : 0;
    }

    public final void B() {
        if (this.f28557b == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f28557b;
            if (i10 >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i10];
            if (bVar != null) {
                bVar.f();
            }
            i10++;
        }
    }

    public final void d(byte[] bArr, byte[] bArr2, int i10, int i11) {
        b bVar = this.f28557b[this.f28559d - 1];
        for (int i12 = 1; i12 < this.f28556a.e(); i12++) {
            int i13 = this.f28559d;
            bVar.k(this.f28557b[(i12 * i13) + (i13 - 1)]);
        }
        bVar.i(bArr);
        r(bArr, bArr2, i10, i11);
    }

    public final void e(np.b bVar) {
        int iF = bVar.f();
        if (iF < bVar.e() * 8) {
            iF = bVar.e() * 8;
        }
        int iE = iF / (bVar.e() * 4);
        this.f28558c = iE;
        this.f28559d = iE * 4;
        u(iE * bVar.e() * 4);
    }

    public final void f(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[72];
        System.arraycopy(bArr2, 0, bArr3, 0, 64);
        bArr3[64] = 1;
        for (int i10 = 0; i10 < this.f28556a.e(); i10++) {
            org.bouncycastle.util.o.m(i10, bArr2, 68);
            org.bouncycastle.util.o.m(i10, bArr3, 68);
            r(bArr2, bArr, 0, 1024);
            this.f28557b[(this.f28559d * i10) + 0].h(bArr);
            r(bArr3, bArr, 0, 1024);
            this.f28557b[(this.f28559d * i10) + 1].h(bArr);
        }
    }

    public final void g() {
        c cVar = new c();
        d dVar = new d();
        for (int i10 = 0; i10 < this.f28556a.d(); i10++) {
            dVar.f28566a = i10;
            for (int i11 = 0; i11 < 4; i11++) {
                dVar.f28568c = i11;
                for (int i12 = 0; i12 < this.f28556a.e(); i12++) {
                    dVar.f28567b = i12;
                    h(cVar, dVar);
                }
            }
        }
    }

    public final void h(c cVar, d dVar) {
        b bVar;
        b bVar2;
        boolean zX = x(dVar);
        int iQ = q(dVar);
        int i10 = (dVar.f28567b * this.f28559d) + (dVar.f28568c * this.f28558c) + iQ;
        int iM = m(i10);
        if (zX) {
            b bVarF = cVar.f28564c.f();
            b bVarF2 = cVar.f28565d.f();
            t(cVar, dVar, bVarF2, bVarF);
            bVar = bVarF;
            bVar2 = bVarF2;
        } else {
            bVar = null;
            bVar2 = null;
        }
        boolean zY = y(dVar);
        int i11 = iQ;
        int i12 = i10;
        int i13 = iM;
        while (i11 < this.f28558c) {
            long jN = n(cVar, i11, bVar, bVar2, i13, zX);
            int iP = p(dVar, jN);
            int iO = o(dVar, i11, jN, iP == dVar.f28567b);
            b[] bVarArr = this.f28557b;
            b bVar3 = bVarArr[i13];
            b bVar4 = bVarArr[(this.f28559d * iP) + iO];
            b bVar5 = bVarArr[i12];
            if (zY) {
                cVar.g(bVar3, bVar4, bVar5);
            } else {
                cVar.f(bVar3, bVar4, bVar5);
            }
            i11++;
            i13 = i12;
            i12++;
        }
    }

    public int i(byte[] bArr, byte[] bArr2) {
        return j(bArr, bArr2, 0, bArr2.length);
    }

    public int j(byte[] bArr, byte[] bArr2, int i10, int i11) {
        if (i11 < 4) {
            throw new IllegalStateException("output length less than 4");
        }
        byte[] bArr3 = new byte[1024];
        v(bArr3, bArr, i11);
        g();
        d(bArr3, bArr2, i10, i11);
        B();
        return i11;
    }

    public int k(char[] cArr, byte[] bArr) {
        return i(this.f28556a.c().convert(cArr), bArr);
    }

    public int l(char[] cArr, byte[] bArr, int i10, int i11) {
        return j(this.f28556a.c().convert(cArr), bArr, i10, i11);
    }

    public final int m(int i10) {
        return i10 % this.f28559d == 0 ? (i10 + r0) - 1 : i10 - 1;
    }

    public final long n(c cVar, int i10, b bVar, b bVar2, int i11, boolean z10) {
        if (!z10) {
            return this.f28557b[i11].f28561a[0];
        }
        int i12 = i10 % 128;
        if (i12 == 0) {
            z(cVar, bVar2, bVar);
        }
        return bVar.f28561a[i12];
    }

    public final int o(d dVar, int i10, long j10, boolean z10) {
        int i11;
        int i12;
        int i13 = dVar.f28566a;
        int i14 = 0;
        int i15 = dVar.f28568c;
        if (i13 != 0) {
            int i16 = this.f28558c;
            int i17 = this.f28559d;
            int i18 = ((i15 + 1) * i16) % i17;
            int i19 = i17 - i16;
            if (z10) {
                i11 = (i19 + i10) - 1;
            } else {
                i11 = i19 + (i10 != 0 ? 0 : -1);
            }
            i14 = i18;
            i12 = i11;
        } else if (z10) {
            i12 = ((i15 * this.f28558c) + i10) - 1;
        } else {
            i12 = (i15 * this.f28558c) + (i10 != 0 ? 0 : -1);
        }
        long j11 = j10 & 4294967295L;
        return ((int) (((long) i14) + (((long) (i12 - 1)) - ((((long) i12) * ((j11 * j11) >>> 32)) >>> 32)))) % this.f28559d;
    }

    public final int p(d dVar, long j10) {
        int iE = (int) ((j10 >>> 32) % ((long) this.f28556a.e()));
        return (dVar.f28566a == 0 && dVar.f28568c == 0) ? dVar.f28567b : iE;
    }

    public final void r(byte[] bArr, byte[] bArr2, int i10, int i11) {
        byte[] bArr3 = new byte[4];
        org.bouncycastle.util.o.m(i11, bArr3, 0);
        if (i11 <= 64) {
            zo.a aVar = new zo.a(i11 * 8);
            aVar.update(bArr3, 0, 4);
            aVar.update(bArr, 0, bArr.length);
            aVar.c(bArr2, i10);
            return;
        }
        zo.a aVar2 = new zo.a(512);
        byte[] bArr4 = new byte[64];
        aVar2.update(bArr3, 0, 4);
        aVar2.update(bArr, 0, bArr.length);
        aVar2.c(bArr4, 0);
        System.arraycopy(bArr4, 0, bArr2, i10, 32);
        int i12 = i10 + 32;
        int i13 = 2;
        int i14 = ((i11 + 31) / 32) - 2;
        while (i13 <= i14) {
            aVar2.update(bArr4, 0, 64);
            aVar2.c(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr2, i12, 32);
            i13++;
            i12 += 32;
        }
        zo.a aVar3 = new zo.a((i11 - (i14 * 32)) * 8);
        aVar3.update(bArr4, 0, 64);
        aVar3.c(bArr2, i12);
    }

    public void s(np.b bVar) {
        this.f28556a = bVar;
        if (bVar.e() < 1) {
            throw new IllegalStateException("lanes must be greater than 1");
        }
        if (bVar.e() > 16777216) {
            throw new IllegalStateException("lanes must be less than 16777216");
        }
        if (bVar.f() >= bVar.e() * 2) {
            if (bVar.d() < 1) {
                throw new IllegalStateException("iterations is less than: 1");
            }
            e(bVar);
        } else {
            throw new IllegalStateException("memory is less than: " + (bVar.e() * 2) + " expected " + (bVar.e() * 2));
        }
    }

    public final void t(c cVar, d dVar, b bVar, b bVar2) {
        bVar.f28561a[0] = w(dVar.f28566a);
        bVar.f28561a[1] = w(dVar.f28567b);
        bVar.f28561a[2] = w(dVar.f28568c);
        bVar.f28561a[3] = w(this.f28557b.length);
        bVar.f28561a[4] = w(this.f28556a.d());
        bVar.f28561a[5] = w(this.f28556a.i());
        if (dVar.f28566a == 0 && dVar.f28568c == 0) {
            z(cVar, bVar, bVar2);
        }
    }

    public final void u(int i10) {
        this.f28557b = new b[i10];
        int i11 = 0;
        while (true) {
            b[] bVarArr = this.f28557b;
            if (i11 >= bVarArr.length) {
                return;
            }
            bVarArr[i11] = new b();
            i11++;
        }
    }

    public final void v(byte[] bArr, byte[] bArr2, int i10) {
        zo.a aVar = new zo.a(512);
        org.bouncycastle.util.o.o(new int[]{this.f28556a.e(), i10, this.f28556a.f(), this.f28556a.d(), this.f28556a.j(), this.f28556a.i()}, bArr, 0);
        aVar.update(bArr, 0, 24);
        c(bArr, aVar, bArr2);
        c(bArr, aVar, this.f28556a.g());
        c(bArr, aVar, this.f28556a.h());
        c(bArr, aVar, this.f28556a.b());
        byte[] bArr3 = new byte[72];
        aVar.c(bArr3, 0);
        f(bArr, bArr3);
    }

    public final long w(int i10) {
        return ((long) i10) & 4294967295L;
    }

    public final boolean x(d dVar) {
        if (this.f28556a.i() != 1) {
            return this.f28556a.i() == 2 && dVar.f28566a == 0 && dVar.f28568c < 2;
        }
        return true;
    }

    public final boolean y(d dVar) {
        return (dVar.f28566a == 0 || this.f28556a.j() == 16) ? false : true;
    }

    public final void z(c cVar, b bVar, b bVar2) {
        long[] jArr = bVar.f28561a;
        jArr[6] = jArr[6] + 1;
        cVar.e(bVar, bVar2);
        cVar.e(bVar2, bVar2);
    }
}
