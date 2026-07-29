package zo;

/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f59402a = 32;

    public static abstract class a implements org.bouncycastle.crypto.v, org.bouncycastle.crypto.m0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f59403i = 8192;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final byte[] f59404j = {7};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final byte[] f59405k = {11};

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final byte[] f59406l = {-1, -1, 6};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final byte[] f59407m = {3, 0, 0, 0, 0, 0, 0, 0};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f59408a = new byte[1];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f59409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f59410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f59411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f59412e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f59413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f59414g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f59415h;

        public a(int i10, int i11, int i12) {
            this.f59409b = new c(i10, i11);
            this.f59410c = new c(i10, i11);
            this.f59411d = i10 >> 2;
            a(null);
        }

        public static byte[] i(long j10) {
            byte b10;
            if (j10 != 0) {
                b10 = 1;
                long j11 = j10;
                while (true) {
                    j11 >>= 8;
                    if (j11 == 0) {
                        break;
                    }
                    b10 = (byte) (b10 + 1);
                }
            } else {
                b10 = 0;
            }
            byte[] bArr = new byte[b10 + 1];
            bArr[b10] = b10;
            for (int i10 = 0; i10 < b10; i10++) {
                bArr[i10] = (byte) (j10 >> (((b10 - i10) - 1) * 8));
            }
            return bArr;
        }

        public final void a(byte[] bArr) {
            int length = bArr == null ? 0 : bArr.length;
            byte[] bArrI = i(length);
            byte[] bArrP = bArr == null ? new byte[bArrI.length + length] : org.bouncycastle.util.a.P(bArr, bArrI.length + length);
            this.f59412e = bArrP;
            System.arraycopy(bArrI, 0, bArrP, length, bArrI.length);
        }

        @Override // org.bouncycastle.crypto.s
        public int c(byte[] bArr, int i10) {
            return f(bArr, i10, h());
        }

        public void d(b bVar) {
            a(bVar.b());
            reset();
        }

        @Override // org.bouncycastle.crypto.m0
        public int e(byte[] bArr, int i10, int i11) {
            if (!this.f59413f) {
                n();
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Invalid output length");
            }
            this.f59409b.l(bArr, i10, i11);
            return i11;
        }

        @Override // org.bouncycastle.crypto.m0
        public int f(byte[] bArr, int i10, int i11) {
            if (this.f59413f) {
                throw new IllegalStateException(zo.d.f59218q);
            }
            int iE = e(bArr, i10, i11);
            reset();
            return iE;
        }

        @Override // org.bouncycastle.crypto.v
        public int g() {
            return this.f59409b.f59420b;
        }

        @Override // org.bouncycastle.crypto.s
        public int h() {
            return this.f59411d >> 1;
        }

        public final void j(byte[] bArr, int i10, int i11) {
            if (this.f59413f) {
                throw new IllegalStateException("attempt to absorb while squeezing");
            }
            c cVar = this.f59414g == 0 ? this.f59409b : this.f59410c;
            int i12 = 8192 - this.f59415h;
            if (i12 >= i11) {
                cVar.d(bArr, i10, i11);
                this.f59415h += i11;
                return;
            }
            if (i12 > 0) {
                cVar.d(bArr, i10, i12);
                this.f59415h += i12;
            }
            while (i12 < i11) {
                if (this.f59415h == 8192) {
                    l(true);
                }
                int iMin = Math.min(i11 - i12, 8192);
                this.f59410c.d(bArr, i10 + i12, iMin);
                this.f59415h += iMin;
                i12 += iMin;
            }
        }

        public final void k() {
            l(false);
            byte[] bArrI = i(this.f59414g);
            this.f59409b.d(bArrI, 0, bArrI.length);
            c cVar = this.f59409b;
            byte[] bArr = f59406l;
            cVar.d(bArr, 0, bArr.length);
            this.f59409b.k();
        }

        public final void l(boolean z10) {
            if (this.f59414g == 0) {
                c cVar = this.f59409b;
                byte[] bArr = f59407m;
                cVar.d(bArr, 0, bArr.length);
            } else {
                c cVar2 = this.f59410c;
                byte[] bArr2 = f59405k;
                cVar2.d(bArr2, 0, bArr2.length);
                int i10 = this.f59411d;
                byte[] bArr3 = new byte[i10];
                this.f59410c.l(bArr3, 0, i10);
                this.f59409b.d(bArr3, 0, this.f59411d);
                this.f59410c.j();
            }
            if (z10) {
                this.f59414g++;
            }
            this.f59415h = 0;
        }

        public final void m() {
            this.f59409b.d(f59404j, 0, 1);
            this.f59409b.k();
        }

        public final void n() {
            byte[] bArr = this.f59412e;
            j(bArr, 0, bArr.length);
            if (this.f59414g == 0) {
                m();
            } else {
                k();
            }
        }

        @Override // org.bouncycastle.crypto.s
        public void reset() {
            this.f59409b.j();
            this.f59410c.j();
            this.f59414g = 0;
            this.f59415h = 0;
            this.f59413f = false;
        }

        @Override // org.bouncycastle.crypto.s
        public void update(byte b10) {
            byte[] bArr = this.f59408a;
            bArr[0] = b10;
            update(bArr, 0, 1);
        }

        @Override // org.bouncycastle.crypto.s
        public void update(byte[] bArr, int i10, int i11) {
            j(bArr, i10, i11);
        }
    }

    public static class b implements org.bouncycastle.crypto.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f59416a;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public byte[] f59417a;

            public b a() {
                b bVar = new b();
                byte[] bArr = this.f59417a;
                if (bArr != null) {
                    bVar.f59416a = bArr;
                }
                return bVar;
            }

            public a b(byte[] bArr) {
                this.f59417a = org.bouncycastle.util.a.p(bArr);
                return this;
            }
        }

        public byte[] b() {
            return org.bouncycastle.util.a.p(this.f59416a);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static long[] f59418g = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f59419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f59420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f59421c = new long[25];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f59422d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f59423e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f59424f;

        public c(int i10, int i11) {
            int i12 = (1600 - (i10 << 1)) >> 3;
            this.f59420b = i12;
            this.f59419a = i11;
            this.f59422d = new byte[i12];
            j();
        }

        public final void a(byte[] bArr, int i10) {
            int i11 = this.f59420b >> 3;
            for (int i12 = 0; i12 < i11; i12++) {
                long[] jArr = this.f59421c;
                jArr[i12] = jArr[i12] ^ org.bouncycastle.util.o.v(bArr, i10);
                i10 += 8;
            }
            c();
        }

        public final void b() {
            org.bouncycastle.util.o.G(this.f59421c, 0, this.f59420b >> 3, this.f59422d, 0);
        }

        public final void c() {
            c cVar = this;
            long[] jArr = cVar.f59421c;
            long j10 = jArr[0];
            char c10 = 1;
            long j11 = jArr[1];
            long j12 = jArr[2];
            long j13 = jArr[3];
            long j14 = jArr[4];
            long j15 = jArr[5];
            long j16 = jArr[6];
            long j17 = jArr[7];
            long j18 = jArr[8];
            long j19 = jArr[9];
            long j20 = jArr[10];
            long j21 = jArr[11];
            long j22 = jArr[12];
            long j23 = jArr[13];
            long j24 = jArr[14];
            long j25 = jArr[15];
            long j26 = jArr[16];
            long j27 = jArr[17];
            long j28 = jArr[18];
            long j29 = jArr[19];
            long j30 = jArr[20];
            long j31 = jArr[21];
            long j32 = jArr[22];
            long j33 = jArr[23];
            long j34 = jArr[24];
            int length = f59418g.length - cVar.f59419a;
            int i10 = 0;
            while (i10 < cVar.f59419a) {
                long j35 = (((j10 ^ j15) ^ j20) ^ j25) ^ j30;
                long j36 = (((j11 ^ j16) ^ j21) ^ j26) ^ j31;
                long j37 = (((j12 ^ j17) ^ j22) ^ j27) ^ j32;
                long j38 = (((j13 ^ j18) ^ j23) ^ j28) ^ j33;
                long j39 = (((j14 ^ j19) ^ j24) ^ j29) ^ j34;
                long j40 = ((j36 << c10) | (j36 >>> (-1))) ^ j39;
                long j41 = ((j37 << c10) | (j37 >>> (-1))) ^ j35;
                long j42 = ((j38 << c10) | (j38 >>> (-1))) ^ j36;
                long j43 = ((j39 << c10) | (j39 >>> (-1))) ^ j37;
                long j44 = ((j35 << c10) | (j35 >>> (-1))) ^ j38;
                long j45 = j10 ^ j40;
                long j46 = j15 ^ j40;
                long j47 = j20 ^ j40;
                long j48 = j25 ^ j40;
                long j49 = j30 ^ j40;
                long j50 = j11 ^ j41;
                long j51 = j16 ^ j41;
                long j52 = j21 ^ j41;
                long j53 = j26 ^ j41;
                long j54 = j31 ^ j41;
                long j55 = j12 ^ j42;
                long j56 = j17 ^ j42;
                long j57 = j22 ^ j42;
                long j58 = j27 ^ j42;
                long j59 = j32 ^ j42;
                long j60 = j13 ^ j43;
                long j61 = j18 ^ j43;
                long j62 = j23 ^ j43;
                long j63 = j28 ^ j43;
                long j64 = j33 ^ j43;
                long j65 = j14 ^ j44;
                long j66 = j19 ^ j44;
                long j67 = j24 ^ j44;
                long j68 = j29 ^ j44;
                long j69 = j34 ^ j44;
                long j70 = (j50 << c10) | (j50 >>> 63);
                long j71 = (j51 << 44) | (j51 >>> 20);
                long j72 = (j66 << 20) | (j66 >>> 44);
                long j73 = (j59 << 61) | (j59 >>> 3);
                int i11 = length;
                long j74 = (j67 << 39) | (j67 >>> 25);
                long j75 = (j49 << 18) | (j49 >>> 46);
                long j76 = (j55 << 62) | (j55 >>> 2);
                long j77 = (j57 << 43) | (j57 >>> 21);
                long j78 = (j62 << 25) | (j62 >>> 39);
                long j79 = (j68 << 8) | (j68 >>> 56);
                long j80 = (j64 << 56) | (j64 >>> 8);
                long j81 = (j48 << 41) | (j48 >>> 23);
                long j82 = (j65 << 27) | (j65 >>> 37);
                long j83 = (j69 << 14) | (j69 >>> 50);
                long j84 = (j54 << 2) | (j54 >>> 62);
                long j85 = (j61 << 55) | (j61 >>> 9);
                long j86 = (j53 << 45) | (j53 >>> 19);
                long j87 = (j46 << 36) | (j46 >>> 28);
                long j88 = (j60 << 28) | (j60 >>> 36);
                long j89 = (j63 << 21) | (j63 >>> 43);
                long j90 = (j58 << 15) | (j58 >>> 49);
                long j91 = (j52 << 10) | (j52 >>> 54);
                long j92 = (j56 << 6) | (j56 >>> 58);
                long j93 = (j47 << 3) | (j47 >>> 61);
                long j94 = ((~j71) & j77) ^ j45;
                long j95 = ((~j77) & j89) ^ j71;
                j12 = j77 ^ ((~j89) & j83);
                long j96 = ((~j83) & j45) ^ j89;
                long j97 = ((~j45) & j71) ^ j83;
                long j98 = j88 ^ ((~j72) & j93);
                long j99 = ((~j93) & j86) ^ j72;
                long j100 = ((~j86) & j73) ^ j93;
                long j101 = j86 ^ ((~j73) & j88);
                long j102 = ((~j88) & j72) ^ j73;
                j20 = j70 ^ ((~j92) & j78);
                long j103 = ((~j78) & j79) ^ j92;
                long j104 = ((~j79) & j75) ^ j78;
                long j105 = j79 ^ ((~j75) & j70);
                long j106 = ((~j70) & j92) ^ j75;
                long j107 = j82 ^ ((~j87) & j91);
                long j108 = ((~j91) & j90) ^ j87;
                long j109 = j91 ^ ((~j90) & j80);
                long j110 = ((~j80) & j82) ^ j90;
                long j111 = ((~j82) & j87) ^ j80;
                j30 = j76 ^ ((~j85) & j74);
                long j112 = ((~j74) & j81) ^ j85;
                long j113 = ((~j81) & j84) ^ j74;
                long j114 = j81 ^ ((~j84) & j76);
                long j115 = ((~j76) & j85) ^ j84;
                long j116 = j94 ^ f59418g[i11 + i10];
                i10++;
                j15 = j98;
                j22 = j104;
                j21 = j103;
                j23 = j105;
                j32 = j113;
                j31 = j112;
                j18 = j101;
                j26 = j108;
                j34 = j115;
                j10 = j116;
                j27 = j109;
                j11 = j95;
                c10 = 1;
                j33 = j114;
                j25 = j107;
                jArr = jArr;
                cVar = this;
                length = i11;
                j13 = j96;
                j14 = j97;
                j28 = j110;
                j24 = j106;
                j17 = j100;
                j16 = j99;
                j19 = j102;
                j29 = j111;
            }
            long[] jArr2 = jArr;
            jArr2[0] = j10;
            jArr2[1] = j11;
            jArr2[2] = j12;
            jArr2[3] = j13;
            jArr2[4] = j14;
            jArr2[5] = j15;
            jArr2[6] = j16;
            jArr2[7] = j17;
            jArr2[8] = j18;
            jArr2[9] = j19;
            jArr2[10] = j20;
            jArr2[11] = j21;
            jArr2[12] = j22;
            jArr2[13] = j23;
            jArr2[14] = j24;
            jArr2[15] = j25;
            jArr2[16] = j26;
            jArr2[17] = j27;
            jArr2[18] = j28;
            jArr2[19] = j29;
            jArr2[20] = j30;
            jArr2[21] = j31;
            jArr2[22] = j32;
            jArr2[23] = j33;
            jArr2[24] = j34;
        }

        public final void d(byte[] bArr, int i10, int i11) {
            int i12;
            if (this.f59424f) {
                throw new IllegalStateException("attempt to absorb while squeezing");
            }
            int i13 = 0;
            while (i13 < i11) {
                int i14 = this.f59423e;
                if (i14 != 0 || i13 > i11 - this.f59420b) {
                    int iMin = Math.min(this.f59420b - i14, i11 - i13);
                    System.arraycopy(bArr, i10 + i13, this.f59422d, this.f59423e, iMin);
                    int i15 = this.f59423e + iMin;
                    this.f59423e = i15;
                    i13 += iMin;
                    if (i15 == this.f59420b) {
                        a(this.f59422d, 0);
                        this.f59423e = 0;
                    }
                } else {
                    do {
                        a(bArr, i10 + i13);
                        i12 = this.f59420b;
                        i13 += i12;
                    } while (i13 <= i11 - i12);
                }
            }
        }

        public final void j() {
            org.bouncycastle.util.a.k0(this.f59421c, 0L);
            org.bouncycastle.util.a.d0(this.f59422d, (byte) 0);
            this.f59423e = 0;
            this.f59424f = false;
        }

        public final void k() {
            int i10 = this.f59423e;
            while (true) {
                int i11 = this.f59420b;
                if (i10 >= i11) {
                    byte[] bArr = this.f59422d;
                    int i12 = i11 - 1;
                    bArr[i12] = (byte) (bArr[i12] ^ 128);
                    a(bArr, 0);
                    b();
                    this.f59423e = this.f59420b;
                    this.f59424f = true;
                    return;
                }
                this.f59422d[i10] = 0;
                i10++;
            }
        }

        public final void l(byte[] bArr, int i10, int i11) {
            if (!this.f59424f) {
                k();
            }
            int i12 = 0;
            while (i12 < i11) {
                if (this.f59423e == 0) {
                    c();
                    b();
                    this.f59423e = this.f59420b;
                }
                int iMin = Math.min(this.f59423e, i11 - i12);
                System.arraycopy(this.f59422d, this.f59420b - this.f59423e, bArr, i10 + i12, iMin);
                this.f59423e -= iMin;
                i12 += iMin;
            }
        }
    }

    public static class d extends a {
        public d() {
            this(32);
        }

        public d(int i10) {
            super(128, 12, i10);
        }

        @Override // org.bouncycastle.crypto.s
        public String b() {
            return "KangarooTwelve";
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ int c(byte[] bArr, int i10) {
            return super.c(bArr, i10);
        }

        @Override // zo.p.a
        public /* bridge */ /* synthetic */ void d(b bVar) {
            super.d(bVar);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.m0
        public /* bridge */ /* synthetic */ int e(byte[] bArr, int i10, int i11) {
            return super.e(bArr, i10, i11);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.m0
        public /* bridge */ /* synthetic */ int f(byte[] bArr, int i10, int i11) {
            return super.f(bArr, i10, i11);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.v
        public /* bridge */ /* synthetic */ int g() {
            return super.g();
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ int h() {
            return super.h();
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ void update(byte b10) {
            super.update(b10);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i10, int i11) {
            super.update(bArr, i10, i11);
        }
    }

    public static class e extends a {
        public e() {
            this(32);
        }

        public e(int i10) {
            super(256, 14, i10);
        }

        @Override // org.bouncycastle.crypto.s
        public String b() {
            return "MarsupilamiFourteen";
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ int c(byte[] bArr, int i10) {
            return super.c(bArr, i10);
        }

        @Override // zo.p.a
        public /* bridge */ /* synthetic */ void d(b bVar) {
            super.d(bVar);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.m0
        public /* bridge */ /* synthetic */ int e(byte[] bArr, int i10, int i11) {
            return super.e(bArr, i10, i11);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.m0
        public /* bridge */ /* synthetic */ int f(byte[] bArr, int i10, int i11) {
            return super.f(bArr, i10, i11);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.v
        public /* bridge */ /* synthetic */ int g() {
            return super.g();
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ int h() {
            return super.h();
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ void update(byte b10) {
            super.update(b10);
        }

        @Override // zo.p.a, org.bouncycastle.crypto.s
        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i10, int i11) {
            super.update(bArr, i10, i11);
        }
    }
}
