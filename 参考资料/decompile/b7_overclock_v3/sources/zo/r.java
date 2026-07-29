package zo;

/* JADX INFO: loaded from: classes5.dex */
public abstract class r implements org.bouncycastle.crypto.v, org.bouncycastle.util.m, g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f59461o = 128;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long[] f59462p = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f59463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f59465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f59466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f59467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f59468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f59469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f59470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f59471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f59472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f59473k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f59474l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long[] f59475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f59476n;

    public r() {
        this.f59463a = new byte[8];
        this.f59475m = new long[80];
        this.f59464b = 0;
        reset();
    }

    public r(r rVar) {
        this.f59463a = new byte[8];
        this.f59475m = new long[80];
        r(rVar);
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 128;
    }

    public final long k(long j10, long j11, long j12) {
        return ((~j10) & j12) ^ (j11 & j10);
    }

    public final long l(long j10, long j11, long j12) {
        return ((j10 & j12) ^ (j10 & j11)) ^ (j11 & j12);
    }

    public final long m(long j10) {
        return (j10 >>> 7) ^ (((j10 << 63) | (j10 >>> 1)) ^ ((j10 << 56) | (j10 >>> 8)));
    }

    public final long n(long j10) {
        return (j10 >>> 6) ^ (((j10 << 45) | (j10 >>> 19)) ^ ((j10 << 3) | (j10 >>> 61)));
    }

    public final long o(long j10) {
        return ((j10 >>> 39) | (j10 << 25)) ^ (((j10 << 36) | (j10 >>> 28)) ^ ((j10 << 30) | (j10 >>> 34)));
    }

    public final long p(long j10) {
        return ((j10 >>> 41) | (j10 << 23)) ^ (((j10 << 50) | (j10 >>> 14)) ^ ((j10 << 46) | (j10 >>> 18)));
    }

    public final void q() {
        long j10 = this.f59465c;
        if (j10 > 2305843009213693951L) {
            this.f59466d += j10 >>> 61;
            this.f59465c = j10 & 2305843009213693951L;
        }
    }

    public void r(r rVar) {
        byte[] bArr = rVar.f59463a;
        System.arraycopy(bArr, 0, this.f59463a, 0, bArr.length);
        this.f59464b = rVar.f59464b;
        this.f59465c = rVar.f59465c;
        this.f59466d = rVar.f59466d;
        this.f59467e = rVar.f59467e;
        this.f59468f = rVar.f59468f;
        this.f59469g = rVar.f59469g;
        this.f59470h = rVar.f59470h;
        this.f59471i = rVar.f59471i;
        this.f59472j = rVar.f59472j;
        this.f59473k = rVar.f59473k;
        this.f59474l = rVar.f59474l;
        long[] jArr = rVar.f59475m;
        System.arraycopy(jArr, 0, this.f59475m, 0, jArr.length);
        this.f59476n = rVar.f59476n;
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59465c = 0L;
        this.f59466d = 0L;
        int i10 = 0;
        this.f59464b = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f59463a;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = 0;
            i11++;
        }
        this.f59476n = 0;
        while (true) {
            long[] jArr = this.f59475m;
            if (i10 == jArr.length) {
                return;
            }
            jArr[i10] = 0;
            i10++;
        }
    }

    public void s() {
        q();
        long j10 = this.f59465c << 3;
        long j11 = this.f59466d;
        byte b10 = -128;
        while (true) {
            update(b10);
            if (this.f59464b == 0) {
                w(j10, j11);
                v();
                return;
            }
            b10 = 0;
        }
    }

    public int t() {
        return (this.f59476n * 8) + 96;
    }

    public void u(byte[] bArr) {
        System.arraycopy(this.f59463a, 0, bArr, 0, this.f59464b);
        org.bouncycastle.util.o.h(this.f59464b, bArr, 8);
        org.bouncycastle.util.o.z(this.f59465c, bArr, 12);
        org.bouncycastle.util.o.z(this.f59466d, bArr, 20);
        org.bouncycastle.util.o.z(this.f59467e, bArr, 28);
        org.bouncycastle.util.o.z(this.f59468f, bArr, 36);
        org.bouncycastle.util.o.z(this.f59469g, bArr, 44);
        org.bouncycastle.util.o.z(this.f59470h, bArr, 52);
        org.bouncycastle.util.o.z(this.f59471i, bArr, 60);
        org.bouncycastle.util.o.z(this.f59472j, bArr, 68);
        org.bouncycastle.util.o.z(this.f59473k, bArr, 76);
        org.bouncycastle.util.o.z(this.f59474l, bArr, 84);
        org.bouncycastle.util.o.h(this.f59476n, bArr, 92);
        for (int i10 = 0; i10 < this.f59476n; i10++) {
            org.bouncycastle.util.o.z(this.f59475m[i10], bArr, (i10 * 8) + 96);
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        byte[] bArr = this.f59463a;
        int i10 = this.f59464b;
        int i11 = i10 + 1;
        this.f59464b = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            x(bArr, 0);
            this.f59464b = 0;
        }
        this.f59465c++;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        while (this.f59464b != 0 && i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        while (i11 > this.f59463a.length) {
            x(bArr, i10);
            byte[] bArr2 = this.f59463a;
            i10 += bArr2.length;
            i11 -= bArr2.length;
            this.f59465c += (long) bArr2.length;
        }
        while (i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
    }

    public void v() {
        q();
        for (int i10 = 16; i10 <= 79; i10++) {
            long[] jArr = this.f59475m;
            long jN = n(jArr[i10 - 2]);
            long[] jArr2 = this.f59475m;
            jArr[i10] = jN + jArr2[i10 - 7] + m(jArr2[i10 - 15]) + this.f59475m[i10 - 16];
        }
        long j10 = this.f59467e;
        long j11 = this.f59468f;
        long j12 = this.f59469g;
        long j13 = this.f59470h;
        long j14 = this.f59471i;
        long j15 = this.f59472j;
        long j16 = this.f59473k;
        long j17 = j15;
        long j18 = j13;
        int i11 = 0;
        long jO = j11;
        long j19 = j12;
        long j20 = j14;
        int i12 = 0;
        long j21 = this.f59474l;
        long j22 = j10;
        long j23 = j16;
        while (i12 < 10) {
            long j24 = j20;
            long jP = p(j20) + k(j20, j17, j23);
            long[] jArr3 = f59462p;
            int i13 = i11 + 1;
            long j25 = j21 + jP + jArr3[i11] + this.f59475m[i11];
            long j26 = j18 + j25;
            long jO2 = j25 + o(j22) + l(j22, jO, j19);
            int i14 = i13 + 1;
            long jP2 = j23 + p(j26) + k(j26, j24, j17) + jArr3[i13] + this.f59475m[i13];
            long j27 = j19 + jP2;
            long jO3 = jP2 + o(jO2) + l(jO2, j22, jO);
            int i15 = i14 + 1;
            long jP3 = j17 + p(j27) + k(j27, j26, j24) + jArr3[i14] + this.f59475m[i14];
            long j28 = jO + jP3;
            long jO4 = jP3 + o(jO3) + l(jO3, jO2, j22);
            int i16 = i15 + 1;
            long jP4 = j24 + p(j28) + k(j28, j27, j26) + jArr3[i15] + this.f59475m[i15];
            long j29 = j22 + jP4;
            long jO5 = jP4 + o(jO4) + l(jO4, jO3, jO2);
            int i17 = i16 + 1;
            long jP5 = j26 + p(j29) + k(j29, j28, j27) + jArr3[i16] + this.f59475m[i16];
            long j30 = jO2 + jP5;
            long jO6 = jP5 + o(jO5) + l(jO5, jO4, jO3);
            int i18 = i17 + 1;
            long jP6 = j27 + p(j30) + k(j30, j29, j28) + jArr3[i17] + this.f59475m[i17];
            long j31 = jO3 + jP6;
            long jO7 = jP6 + o(jO6) + l(jO6, jO5, jO4);
            j23 = j31;
            int i19 = i18 + 1;
            long jP7 = j28 + p(j31) + k(j31, j30, j29) + jArr3[i18] + this.f59475m[i18];
            long j32 = jO4 + jP7;
            j17 = j32;
            jO = jP7 + o(jO7) + l(jO7, jO6, jO5);
            long jP8 = j29 + p(j32) + k(j32, j23, j30) + jArr3[i19] + this.f59475m[i19];
            long jO8 = jP8 + o(jO) + l(jO, jO7, jO6);
            i12++;
            j20 = jO5 + jP8;
            j19 = jO7;
            j21 = j30;
            j18 = jO6;
            i11 = i19 + 1;
            j22 = jO8;
        }
        this.f59467e += j22;
        this.f59468f += jO;
        this.f59469g += j19;
        this.f59470h += j18;
        this.f59471i += j20;
        this.f59472j += j17;
        this.f59473k += j23;
        this.f59474l += j21;
        this.f59476n = 0;
        for (int i20 = 0; i20 < 16; i20++) {
            this.f59475m[i20] = 0;
        }
    }

    public void w(long j10, long j11) {
        if (this.f59476n > 14) {
            v();
        }
        long[] jArr = this.f59475m;
        jArr[14] = j11;
        jArr[15] = j10;
    }

    public void x(byte[] bArr, int i10) {
        this.f59475m[this.f59476n] = org.bouncycastle.util.o.d(bArr, i10);
        int i11 = this.f59476n + 1;
        this.f59476n = i11;
        if (i11 == 16) {
            v();
        }
    }

    public void y(byte[] bArr) {
        int iA = org.bouncycastle.util.o.a(bArr, 8);
        this.f59464b = iA;
        System.arraycopy(bArr, 0, this.f59463a, 0, iA);
        this.f59465c = org.bouncycastle.util.o.d(bArr, 12);
        this.f59466d = org.bouncycastle.util.o.d(bArr, 20);
        this.f59467e = org.bouncycastle.util.o.d(bArr, 28);
        this.f59468f = org.bouncycastle.util.o.d(bArr, 36);
        this.f59469g = org.bouncycastle.util.o.d(bArr, 44);
        this.f59470h = org.bouncycastle.util.o.d(bArr, 52);
        this.f59471i = org.bouncycastle.util.o.d(bArr, 60);
        this.f59472j = org.bouncycastle.util.o.d(bArr, 68);
        this.f59473k = org.bouncycastle.util.o.d(bArr, 76);
        this.f59474l = org.bouncycastle.util.o.d(bArr, 84);
        this.f59476n = org.bouncycastle.util.o.a(bArr, 92);
        for (int i10 = 0; i10 < this.f59476n; i10++) {
            this.f59475m[i10] = org.bouncycastle.util.o.d(bArr, (i10 * 8) + 96);
        }
    }
}
