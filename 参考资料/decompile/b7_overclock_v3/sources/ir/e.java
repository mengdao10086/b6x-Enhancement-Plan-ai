package ir;

import ir.f;
import ir.i;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f35653i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f35654j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f35655k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f35656l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f35657m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f35658n = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f35659o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f35660p = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qr.b f35661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ir.f f35662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ir.f f35663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f35664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f35665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35666f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public mr.a f35667g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f35668h = null;

    public class a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f35669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f35670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f35671c;

        public a(int i10, int i11, byte[] bArr) {
            this.f35669a = i10;
            this.f35670b = i11;
            this.f35671c = bArr;
        }

        @Override // ir.g
        public i a(int i10) {
            int i11;
            int i12 = this.f35670b;
            byte[] bArr = new byte[i12];
            byte[] bArr2 = new byte[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < this.f35669a; i14++) {
                int i15 = ((i14 ^ i10) - 1) >> 31;
                int i16 = 0;
                while (true) {
                    i11 = this.f35670b;
                    if (i16 < i11) {
                        byte b10 = bArr[i16];
                        byte[] bArr3 = this.f35671c;
                        bArr[i16] = (byte) (b10 ^ (bArr3[i13 + i16] & i15));
                        bArr2[i16] = (byte) ((bArr3[(i11 + i13) + i16] & i15) ^ bArr2[i16]);
                        i16++;
                    }
                }
                i13 += i11 * 2;
            }
            return d(bArr, bArr2);
        }

        @Override // ir.a, ir.g
        public i b(int i10) {
            int i11 = this.f35670b;
            byte[] bArr = new byte[i11];
            byte[] bArr2 = new byte[i11];
            int i12 = i10 * i11 * 2;
            int i13 = 0;
            while (true) {
                int i14 = this.f35670b;
                if (i13 >= i14) {
                    return d(bArr, bArr2);
                }
                byte[] bArr3 = this.f35671c;
                bArr[i13] = bArr3[i12 + i13];
                bArr2[i13] = bArr3[i14 + i12 + i13];
                i13++;
            }
        }

        @Override // ir.g
        public int c() {
            return this.f35669a;
        }

        public final i d(byte[] bArr, byte[] bArr2) {
            e eVar = e.this;
            return eVar.i(eVar.n(new BigInteger(1, bArr)), e.this.n(new BigInteger(1, bArr2)));
        }
    }

    public static abstract class b extends e {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public BigInteger[] f35673q;

        public b(int i10, int i11, int i12, int i13) {
            super(J(i10, i11, i12, i13));
            this.f35673q = null;
        }

        public static qr.b J(int i10, int i11, int i12, int i13) {
            if (i11 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            if (i12 == 0) {
                if (i13 == 0) {
                    return qr.c.a(new int[]{0, i11, i10});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            }
            if (i12 <= i11) {
                throw new IllegalArgumentException("k2 must be > k1");
            }
            if (i13 > i12) {
                return qr.c.a(new int[]{0, i11, i12, i13, i10});
            }
            throw new IllegalArgumentException("k3 must be > k2");
        }

        public static BigInteger L(SecureRandom secureRandom, int i10) {
            BigInteger bigIntegerF;
            do {
                bigIntegerF = org.bouncycastle.util.b.f(i10, secureRandom);
            } while (bigIntegerF.signum() <= 0);
            return bigIntegerF;
        }

        public static BigInteger M(int i10, int[] iArr, BigInteger bigInteger) {
            return new o(bigInteger).J(i10, iArr).o0();
        }

        @Override // ir.e
        public boolean B(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= v();
        }

        @Override // ir.e
        public ir.f F(SecureRandom secureRandom) {
            return n(org.bouncycastle.util.b.f(v(), secureRandom));
        }

        @Override // ir.e
        public ir.f G(SecureRandom secureRandom) {
            int iV = v();
            return n(L(secureRandom, iV)).k(n(L(secureRandom, iV)));
        }

        public synchronized BigInteger[] K() {
            if (this.f35673q == null) {
                this.f35673q = x.i(this);
            }
            return this.f35673q;
        }

        public boolean N() {
            return this.f35664d != null && this.f35665e != null && this.f35663c.i() && (this.f35662b.j() || this.f35662b.i());
        }

        public ir.f O(ir.f fVar) {
            ir.f fVarA;
            f.a aVar = (f.a) fVar;
            boolean zX = aVar.x();
            if (zX && aVar.y() != 0) {
                return null;
            }
            int iV = v();
            if ((iV & 1) != 0) {
                ir.f fVarW = aVar.w();
                if (zX || fVarW.p().a(fVarW).a(fVar).j()) {
                    return fVarW;
                }
                return null;
            }
            if (fVar.j()) {
                return fVar;
            }
            ir.f fVarN = n(ir.d.f35646a);
            Random random = new Random();
            do {
                ir.f fVarN2 = n(new BigInteger(iV, random));
                ir.f fVarA2 = fVar;
                fVarA = fVarN;
                for (int i10 = 1; i10 < iV; i10++) {
                    ir.f fVarP = fVarA2.p();
                    fVarA = fVarA.p().a(fVarP.k(fVarN2));
                    fVarA2 = fVarP.a(fVar);
                }
                if (!fVarA2.j()) {
                    return null;
                }
            } while (fVarA.p().a(fVarA).j());
            return fVarA;
        }

        @Override // ir.e
        public i h(BigInteger bigInteger, BigInteger bigInteger2) {
            ir.f fVarN = n(bigInteger);
            ir.f fVarN2 = n(bigInteger2);
            int iS = s();
            if (iS == 5 || iS == 6) {
                if (!fVarN.j()) {
                    fVarN2 = fVarN2.d(fVarN).a(fVarN);
                } else if (!fVarN2.p().equals(q())) {
                    throw new IllegalArgumentException();
                }
            }
            return i(fVarN, fVarN2);
        }

        @Override // ir.e
        public i l(int i10, BigInteger bigInteger) {
            ir.f fVarA;
            ir.f fVarN = n(bigInteger);
            if (fVarN.j()) {
                fVarA = q().o();
            } else {
                ir.f fVarO = O(fVarN.p().h().k(q()).a(o()).a(fVarN));
                if (fVarO != null) {
                    if (fVarO.u() != (i10 == 1)) {
                        fVarO = fVarO.b();
                    }
                    int iS = s();
                    fVarA = (iS == 5 || iS == 6) ? fVarO.a(fVarN) : fVarO.k(fVarN);
                } else {
                    fVarA = null;
                }
            }
            if (fVarA != null) {
                return i(fVarN, fVarA);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    public static abstract class c extends e {
        public c(BigInteger bigInteger) {
            super(qr.c.b(bigInteger));
        }

        public static BigInteger J(SecureRandom secureRandom, BigInteger bigInteger) {
            BigInteger bigIntegerF;
            do {
                bigIntegerF = org.bouncycastle.util.b.f(bigInteger.bitLength(), secureRandom);
            } while (bigIntegerF.compareTo(bigInteger) >= 0);
            return bigIntegerF;
        }

        public static BigInteger K(SecureRandom secureRandom, BigInteger bigInteger) {
            while (true) {
                BigInteger bigIntegerF = org.bouncycastle.util.b.f(bigInteger.bitLength(), secureRandom);
                if (bigIntegerF.signum() > 0 && bigIntegerF.compareTo(bigInteger) < 0) {
                    return bigIntegerF;
                }
            }
        }

        @Override // ir.e
        public boolean B(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(u().e()) < 0;
        }

        @Override // ir.e
        public ir.f F(SecureRandom secureRandom) {
            BigInteger bigIntegerE = u().e();
            return n(J(secureRandom, bigIntegerE)).k(n(J(secureRandom, bigIntegerE)));
        }

        @Override // ir.e
        public ir.f G(SecureRandom secureRandom) {
            BigInteger bigIntegerE = u().e();
            return n(K(secureRandom, bigIntegerE)).k(n(K(secureRandom, bigIntegerE)));
        }

        @Override // ir.e
        public i l(int i10, BigInteger bigInteger) {
            ir.f fVarN = n(bigInteger);
            ir.f fVarO = fVarN.p().a(this.f35662b).k(fVarN).a(this.f35663c).o();
            if (fVarO == null) {
                throw new IllegalArgumentException("Invalid point compression");
            }
            if (fVarO.u() != (i10 == 1)) {
                fVarO = fVarO.n();
            }
            return i(fVarN, fVarO);
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f35674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public mr.a f35675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f35676c;

        public d(int i10, mr.a aVar, h hVar) {
            this.f35674a = i10;
            this.f35675b = aVar;
            this.f35676c = hVar;
        }

        public e a() {
            if (!e.this.H(this.f35674a)) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            e eVarD = e.this.d();
            if (eVarD == e.this) {
                throw new IllegalStateException("implementation returned current curve");
            }
            synchronized (eVarD) {
                eVarD.f35666f = this.f35674a;
                eVarD.f35667g = this.f35675b;
                eVarD.f35668h = this.f35676c;
            }
            return eVarD;
        }

        public d b(int i10) {
            this.f35674a = i10;
            return this;
        }

        public d c(mr.a aVar) {
            this.f35675b = aVar;
            return this;
        }

        public d d(h hVar) {
            this.f35676c = hVar;
            return this;
        }
    }

    /* JADX INFO: renamed from: ir.e$e, reason: collision with other inner class name */
    public static class C0401e extends b {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f35678w = 6;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f35679r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f35680s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f35681t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f35682u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public i.d f35683v;

        /* JADX INFO: renamed from: ir.e$e$a */
        public class a extends ir.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f35684a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f35685b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long[] f35686c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int[] f35687d;

            public a(int i10, int i11, long[] jArr, int[] iArr) {
                this.f35684a = i10;
                this.f35685b = i11;
                this.f35686c = jArr;
                this.f35687d = iArr;
            }

            @Override // ir.g
            public i a(int i10) {
                int i11;
                long[] jArrE = rr.o.E(this.f35685b);
                long[] jArrE2 = rr.o.E(this.f35685b);
                int i12 = 0;
                for (int i13 = 0; i13 < this.f35684a; i13++) {
                    long j10 = ((i13 ^ i10) - 1) >> 31;
                    int i14 = 0;
                    while (true) {
                        i11 = this.f35685b;
                        if (i14 < i11) {
                            long j11 = jArrE[i14];
                            long[] jArr = this.f35686c;
                            jArrE[i14] = j11 ^ (jArr[i12 + i14] & j10);
                            jArrE2[i14] = jArrE2[i14] ^ (jArr[(i11 + i12) + i14] & j10);
                            i14++;
                        }
                    }
                    i12 += i11 * 2;
                }
                return d(jArrE, jArrE2);
            }

            @Override // ir.a, ir.g
            public i b(int i10) {
                long[] jArrE = rr.o.E(this.f35685b);
                long[] jArrE2 = rr.o.E(this.f35685b);
                int i11 = i10 * this.f35685b * 2;
                int i12 = 0;
                while (true) {
                    int i13 = this.f35685b;
                    if (i12 >= i13) {
                        return d(jArrE, jArrE2);
                    }
                    long[] jArr = this.f35686c;
                    jArrE[i12] = jArr[i11 + i12];
                    jArrE2[i12] = jArr[i13 + i11 + i12];
                    i12++;
                }
            }

            @Override // ir.g
            public int c() {
                return this.f35684a;
            }

            public final i d(long[] jArr, long[] jArr2) {
                return C0401e.this.i(new f.c(C0401e.this.f35679r, this.f35687d, new o(jArr)), new f.c(C0401e.this.f35679r, this.f35687d, new o(jArr2)));
            }
        }

        public C0401e(int i10, int i11, int i12, int i13, ir.f fVar, ir.f fVar2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i10, i11, i12, i13);
            this.f35679r = i10;
            this.f35680s = i11;
            this.f35681t = i12;
            this.f35682u = i13;
            this.f35664d = bigInteger;
            this.f35665e = bigInteger2;
            this.f35683v = new i.d(this, null, null);
            this.f35662b = fVar;
            this.f35663c = fVar2;
            this.f35666f = 6;
        }

        public C0401e(int i10, int i11, int i12, int i13, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i10, i11, i12, i13, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public C0401e(int i10, int i11, int i12, int i13, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i10, i11, i12, i13);
            this.f35679r = i10;
            this.f35680s = i11;
            this.f35681t = i12;
            this.f35682u = i13;
            this.f35664d = bigInteger3;
            this.f35665e = bigInteger4;
            this.f35683v = new i.d(this, null, null);
            this.f35662b = n(bigInteger);
            this.f35663c = n(bigInteger2);
            this.f35666f = 6;
        }

        public C0401e(int i10, int i11, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i10, i11, 0, 0, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public C0401e(int i10, int i11, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i10, i11, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        @Override // ir.e
        public boolean H(int i10) {
            return i10 == 0 || i10 == 1 || i10 == 6;
        }

        public int Q() {
            return this.f35680s;
        }

        public int R() {
            return this.f35681t;
        }

        public int S() {
            return this.f35682u;
        }

        public int T() {
            return this.f35679r;
        }

        public boolean U() {
            return this.f35681t == 0 && this.f35682u == 0;
        }

        @Override // ir.e
        public e d() {
            return new C0401e(this.f35679r, this.f35680s, this.f35681t, this.f35682u, this.f35662b, this.f35663c, this.f35664d, this.f35665e);
        }

        @Override // ir.e
        public g f(i[] iVarArr, int i10, int i11) {
            int i12 = (this.f35679r + 63) >>> 6;
            int[] iArr = U() ? new int[]{this.f35680s} : new int[]{this.f35680s, this.f35681t, this.f35682u};
            long[] jArr = new long[i11 * i12 * 2];
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                i iVar = iVarArr[i10 + i14];
                ((f.c) iVar.n()).f35701j.j(jArr, i13);
                int i15 = i13 + i12;
                ((f.c) iVar.o()).f35701j.j(jArr, i15);
                i13 = i15 + i12;
            }
            return new a(i11, i12, jArr, iArr);
        }

        @Override // ir.e
        public h g() {
            return N() ? new c0() : super.g();
        }

        @Override // ir.e
        public i i(ir.f fVar, ir.f fVar2) {
            return new i.d(this, fVar, fVar2);
        }

        @Override // ir.e
        public i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
            return new i.d(this, fVar, fVar2, fVarArr);
        }

        @Override // ir.e
        public ir.f n(BigInteger bigInteger) {
            return new f.c(this.f35679r, this.f35680s, this.f35681t, this.f35682u, bigInteger);
        }

        @Override // ir.e
        public int v() {
            return this.f35679r;
        }

        @Override // ir.e
        public i w() {
            return this.f35683v;
        }
    }

    public static class f extends c {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f35689t = 4;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public BigInteger f35690q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public BigInteger f35691r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public i.e f35692s;

        public f(BigInteger bigInteger, BigInteger bigInteger2, ir.f fVar, ir.f fVar2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f35690q = bigInteger;
            this.f35691r = bigInteger2;
            this.f35692s = new i.e(this, null, null);
            this.f35662b = fVar;
            this.f35663c = fVar2;
            this.f35664d = bigInteger3;
            this.f35665e = bigInteger4;
            this.f35666f = 4;
        }

        public f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, null, null);
        }

        public f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.f35690q = bigInteger;
            this.f35691r = f.d.w(bigInteger);
            this.f35692s = new i.e(this, null, null);
            this.f35662b = n(bigInteger2);
            this.f35663c = n(bigInteger3);
            this.f35664d = bigInteger4;
            this.f35665e = bigInteger5;
            this.f35666f = 4;
        }

        @Override // ir.e
        public i A(i iVar) {
            int iS;
            return (this == iVar.i() || s() != 2 || iVar.v() || !((iS = iVar.i().s()) == 2 || iS == 3 || iS == 4)) ? super.A(iVar) : new i.e(this, n(iVar.f35707b.v()), n(iVar.f35708c.v()), new ir.f[]{n(iVar.f35709d[0].v())});
        }

        @Override // ir.e
        public boolean H(int i10) {
            return i10 == 0 || i10 == 1 || i10 == 2 || i10 == 4;
        }

        public BigInteger L() {
            return this.f35690q;
        }

        @Override // ir.e
        public e d() {
            return new f(this.f35690q, this.f35691r, this.f35662b, this.f35663c, this.f35664d, this.f35665e);
        }

        @Override // ir.e
        public i i(ir.f fVar, ir.f fVar2) {
            return new i.e(this, fVar, fVar2);
        }

        @Override // ir.e
        public i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
            return new i.e(this, fVar, fVar2, fVarArr);
        }

        @Override // ir.e
        public ir.f n(BigInteger bigInteger) {
            return new f.d(this.f35690q, this.f35691r, bigInteger);
        }

        @Override // ir.e
        public int v() {
            return this.f35690q.bitLength();
        }

        @Override // ir.e
        public i w() {
            return this.f35692s;
        }
    }

    public e(qr.b bVar) {
        this.f35661a = bVar;
    }

    public static int[] p() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    public i A(i iVar) {
        if (this == iVar.i()) {
            return iVar;
        }
        if (iVar.v()) {
            return w();
        }
        i iVarB = iVar.B();
        return h(iVarB.q().v(), iVarB.r().v());
    }

    public abstract boolean B(BigInteger bigInteger);

    public void C(i[] iVarArr) {
        D(iVarArr, 0, iVarArr.length, null);
    }

    public void D(i[] iVarArr, int i10, int i11, ir.f fVar) {
        c(iVarArr, i10, i11);
        int iS = s();
        if (iS == 0 || iS == 5) {
            if (fVar != null) {
                throw new IllegalArgumentException("'iso' not valid for affine coordinates");
            }
            return;
        }
        ir.f[] fVarArr = new ir.f[i11];
        int[] iArr = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = i10 + i13;
            i iVar = iVarArr[i14];
            if (iVar != null && (fVar != null || !iVar.w())) {
                fVarArr[i12] = iVar.s(0);
                iArr[i12] = i14;
                i12++;
            }
        }
        if (i12 == 0) {
            return;
        }
        ir.c.r(fVarArr, 0, i12, fVar);
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = iArr[i15];
            iVarArr[i16] = iVarArr[i16].C(fVarArr[i15]);
        }
    }

    public q E(i iVar, String str, p pVar) {
        Hashtable hashtable;
        q qVarA;
        a(iVar);
        synchronized (iVar) {
            hashtable = iVar.f35710e;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                iVar.f35710e = hashtable;
            }
        }
        synchronized (hashtable) {
            q qVar = (q) hashtable.get(str);
            qVarA = pVar.a(qVar);
            if (qVarA != qVar) {
                hashtable.put(str, qVarA);
            }
        }
        return qVarA;
    }

    public abstract ir.f F(SecureRandom secureRandom);

    public abstract ir.f G(SecureRandom secureRandom);

    public boolean H(int i10) {
        return i10 == 0;
    }

    public i I(BigInteger bigInteger, BigInteger bigInteger2) {
        i iVarH = h(bigInteger, bigInteger2);
        if (iVarH.x()) {
            return iVarH;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public void a(i iVar) {
        if (iVar == null || this != iVar.i()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    public void b(i[] iVarArr) {
        c(iVarArr, 0, iVarArr.length);
    }

    public void c(i[] iVarArr, int i10, int i11) {
        if (iVarArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        if (i10 < 0 || i11 < 0 || i10 > iVarArr.length - i11) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            i iVar = iVarArr[i10 + i12];
            if (iVar != null && this != iVar.i()) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
    }

    public abstract e d();

    public synchronized d e() {
        return new d(this.f35666f, this.f35667g, this.f35668h);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof e) && m((e) obj));
    }

    public g f(i[] iVarArr, int i10, int i11) {
        int iV = (v() + 7) >>> 3;
        byte[] bArr = new byte[i11 * iV * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i iVar = iVarArr[i10 + i13];
            byte[] byteArray = iVar.n().v().toByteArray();
            byte[] byteArray2 = iVar.o().v().toByteArray();
            int i14 = 1;
            int i15 = byteArray.length > iV ? 1 : 0;
            int length = byteArray.length - i15;
            if (byteArray2.length <= iV) {
                i14 = 0;
            }
            int length2 = byteArray2.length - i14;
            int i16 = i12 + iV;
            System.arraycopy(byteArray, i15, bArr, i16 - length, length);
            i12 = i16 + iV;
            System.arraycopy(byteArray2, i14, bArr, i12 - length2, length2);
        }
        return new a(i11, iV, bArr);
    }

    public h g() {
        mr.a aVar = this.f35667g;
        return aVar instanceof mr.d ? new n(this, (mr.d) aVar) : new z();
    }

    public i h(BigInteger bigInteger, BigInteger bigInteger2) {
        return i(n(bigInteger), n(bigInteger2));
    }

    public int hashCode() {
        return (u().hashCode() ^ org.bouncycastle.util.j.e(o().v().hashCode(), 8)) ^ org.bouncycastle.util.j.e(q().v().hashCode(), 16);
    }

    public abstract i i(ir.f fVar, ir.f fVar2);

    public abstract i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr);

    public i k(byte[] bArr) {
        i iVarW;
        int iV = (v() + 7) / 8;
        byte b10 = bArr[0];
        if (b10 != 0) {
            if (b10 == 2 || b10 == 3) {
                if (bArr.length != iV + 1) {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                iVarW = l(b10 & 1, org.bouncycastle.util.b.j(bArr, 1, iV));
                if (!iVarW.u(true, true)) {
                    throw new IllegalArgumentException("Invalid point");
                }
            } else if (b10 != 4) {
                if (b10 != 6 && b10 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b10, 16));
                }
                if (bArr.length != (iV * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
                BigInteger bigIntegerJ = org.bouncycastle.util.b.j(bArr, 1, iV);
                BigInteger bigIntegerJ2 = org.bouncycastle.util.b.j(bArr, iV + 1, iV);
                if (bigIntegerJ2.testBit(0) != (b10 == 7)) {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                iVarW = I(bigIntegerJ, bigIntegerJ2);
            } else {
                if (bArr.length != (iV * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }
                iVarW = I(org.bouncycastle.util.b.j(bArr, 1, iV), org.bouncycastle.util.b.j(bArr, iV + 1, iV));
            }
        } else {
            if (bArr.length != 1) {
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            }
            iVarW = w();
        }
        if (b10 == 0 || !iVarW.v()) {
            return iVarW;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public abstract i l(int i10, BigInteger bigInteger);

    public boolean m(e eVar) {
        return this == eVar || (eVar != null && u().equals(eVar.u()) && o().v().equals(eVar.o().v()) && q().v().equals(eVar.q().v()));
    }

    public abstract ir.f n(BigInteger bigInteger);

    public ir.f o() {
        return this.f35662b;
    }

    public ir.f q() {
        return this.f35663c;
    }

    public BigInteger r() {
        return this.f35665e;
    }

    public int s() {
        return this.f35666f;
    }

    public mr.a t() {
        return this.f35667g;
    }

    public qr.b u() {
        return this.f35661a;
    }

    public abstract int v();

    public abstract i w();

    public h x() {
        if (this.f35668h == null) {
            this.f35668h = g();
        }
        return this.f35668h;
    }

    public BigInteger y() {
        return this.f35664d;
    }

    public q z(i iVar, String str) {
        Hashtable hashtable;
        q qVar;
        a(iVar);
        synchronized (iVar) {
            hashtable = iVar.f35710e;
        }
        if (hashtable == null) {
            return null;
        }
        synchronized (hashtable) {
            qVar = (q) hashtable.get(str);
        }
        return qVar;
    }
}
