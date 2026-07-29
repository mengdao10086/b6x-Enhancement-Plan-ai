package za;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
import za.h1;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 {
    public static final int O = 0;
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;
    public static final int S = 4;
    public static final int T = 5;
    public static final int U = 6;
    public static final int V = 7;
    public static final int W = 9;
    public static final int X = 10;
    public static final int Y = 11;
    public static final int Z = 12;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f58149a0 = 13;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f58150b0 = 14;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f58151c0 = 15;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f58152d0 = 16;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final l1 f58153e0 = W(new l1[0]);
    public final int A;
    public final long B;
    public final int C;
    public final long D;
    public final long E;
    public final long F;
    public final long G;
    public final long H;
    public final int I;
    public final int J;
    public final int K;
    public final List<a> L;
    public final List<a> M;
    public final long[] N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f58154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f58155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<long[]> f58156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f58157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f58158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f58159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f58160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f58161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f58162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f58163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f58164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f58165l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f58166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f58167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f58168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f58169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<b> f58170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<b> f58171r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f58172s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f58173t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f58174u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f58175v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f58176w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f58177x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f58178y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f58179z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1.b f58180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Exception f58181b;

        public a(h1.b bVar, Exception exc) {
            this.f58180a = bVar;
            this.f58181b = exc;
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f58180a.equals(aVar.f58180a)) {
                return this.f58181b.equals(aVar.f58181b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f58180a.hashCode() * 31) + this.f58181b.hashCode();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1.b f58182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        public final Format f58183b;

        public b(h1.b bVar, @g.p0 Format format) {
            this.f58182a = bVar;
            this.f58183b = format;
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f58182a.equals(bVar.f58182a)) {
                return false;
            }
            Format format = this.f58183b;
            Format format2 = bVar.f58183b;
            return format != null ? format.equals(format2) : format2 == null;
        }

        public int hashCode() {
            int iHashCode = this.f58182a.hashCode() * 31;
            Format format = this.f58183b;
            return iHashCode + (format != null ? format.hashCode() : 0);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1.b f58184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f58185b;

        public c(h1.b bVar, int i10) {
            this.f58184a = bVar;
            this.f58185b = i10;
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f58185b != cVar.f58185b) {
                return false;
            }
            return this.f58184a.equals(cVar.f58184a);
        }

        public int hashCode() {
            return (this.f58184a.hashCode() * 31) + this.f58185b;
        }
    }

    public l1(int i10, long[] jArr, List<c> list, List<long[]> list2, long j10, int i11, int i12, int i13, int i14, long j11, int i15, int i16, int i17, int i18, int i19, long j12, int i20, List<b> list3, List<b> list4, long j13, long j14, long j15, long j16, long j17, long j18, int i21, int i22, int i23, long j19, int i24, long j20, long j21, long j22, long j23, long j24, int i25, int i26, int i27, List<a> list5, List<a> list6) {
        this.f58154a = i10;
        this.N = jArr;
        this.f58155b = Collections.unmodifiableList(list);
        this.f58156c = Collections.unmodifiableList(list2);
        this.f58157d = j10;
        this.f58158e = i11;
        this.f58159f = i12;
        this.f58160g = i13;
        this.f58161h = i14;
        this.f58162i = j11;
        this.f58163j = i15;
        this.f58164k = i16;
        this.f58165l = i17;
        this.f58166m = i18;
        this.f58167n = i19;
        this.f58168o = j12;
        this.f58169p = i20;
        this.f58170q = Collections.unmodifiableList(list3);
        this.f58171r = Collections.unmodifiableList(list4);
        this.f58172s = j13;
        this.f58173t = j14;
        this.f58174u = j15;
        this.f58175v = j16;
        this.f58176w = j17;
        this.f58177x = j18;
        this.f58178y = i21;
        this.f58179z = i22;
        this.A = i23;
        this.B = j19;
        this.C = i24;
        this.D = j20;
        this.E = j21;
        this.F = j22;
        this.G = j23;
        this.H = j24;
        this.I = i25;
        this.J = i26;
        this.K = i27;
        this.L = Collections.unmodifiableList(list5);
        this.M = Collections.unmodifiableList(list6);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static za.l1 W(za.l1... r66) {
        /*
            Method dump skipped, instruction units count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: za.l1.W(za.l1[]):za.l1");
    }

    public float A() {
        return 1.0f / e();
    }

    public float B() {
        return 1.0f / H();
    }

    public float C() {
        return 1.0f / K();
    }

    public int D() {
        long j10 = this.f58174u;
        if (j10 == 0) {
            return -1;
        }
        return (int) (this.f58175v / j10);
    }

    public int E() {
        long j10 = this.f58172s;
        if (j10 == 0) {
            return -1;
        }
        return (int) (this.f58173t / j10);
    }

    public long F() {
        return this.f58158e == 0 ? ya.g.f56663b : U() / ((long) this.f58158e);
    }

    public long G(long j10) {
        if (this.f58156c.isEmpty()) {
            return ya.g.f56663b;
        }
        int i10 = 0;
        while (i10 < this.f58156c.size() && this.f58156c.get(i10)[0] <= j10) {
            i10++;
        }
        if (i10 == 0) {
            return this.f58156c.get(0)[1];
        }
        if (i10 == this.f58156c.size()) {
            List<long[]> list = this.f58156c;
            return list.get(list.size() - 1)[1];
        }
        int i11 = i10 - 1;
        long j11 = this.f58156c.get(i11)[0];
        long j12 = this.f58156c.get(i11)[1];
        long j13 = this.f58156c.get(i10)[0];
        long j14 = this.f58156c.get(i10)[1];
        long j15 = j13 - j11;
        if (j15 == 0) {
            return j12;
        }
        return j12 + ((long) ((j14 - j12) * ((j10 - j11) / j15)));
    }

    public float H() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.K * 1000.0f) / jR;
    }

    public int I(long j10) {
        int i10 = 0;
        for (c cVar : this.f58155b) {
            if (cVar.f58184a.f58099a > j10) {
                break;
            }
            i10 = cVar.f58185b;
        }
        return i10;
    }

    public long J(int i10) {
        return this.N[i10];
    }

    public float K() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.f58167n * 1000.0f) / jR;
    }

    public float L() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return S() / jQ;
    }

    public float M() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return T() / jQ;
    }

    public long N() {
        long j10 = 0;
        for (int i10 = 0; i10 < 16; i10++) {
            j10 += this.N[i10];
        }
        return j10;
    }

    public long O() {
        return J(2);
    }

    public long P() {
        return J(4) + J(7);
    }

    public long Q() {
        return R() + U();
    }

    public long R() {
        return J(3);
    }

    public long S() {
        return J(6);
    }

    public long T() {
        return J(5);
    }

    public long U() {
        return J(2) + J(6) + J(5);
    }

    public float V() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return U() / jQ;
    }

    public float a() {
        int i10 = this.f58159f;
        int i11 = this.f58154a;
        int i12 = this.f58158e;
        int i13 = i10 - (i11 - i12);
        if (i12 == 0) {
            return 0.0f;
        }
        return i13 / i12;
    }

    public float b() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.H * 1000.0f) / jR;
    }

    public float c() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.G * 1000.0f) / jR;
    }

    public float d() {
        int i10 = this.f58158e;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.f58160g / i10;
    }

    public float e() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.J * 1000.0f) / jR;
    }

    public float f() {
        int i10 = this.f58158e;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.I / i10;
    }

    public float g() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return O() / jQ;
    }

    public int h() {
        long j10 = this.f58176w;
        if (j10 == 0) {
            return -1;
        }
        return (int) (this.f58177x / j10);
    }

    public int i() {
        long j10 = this.E;
        if (j10 == 0) {
            return -1;
        }
        return (int) ((this.F * 8000) / j10);
    }

    public long j() {
        return this.f58154a == 0 ? ya.g.f56663b : N() / ((long) this.f58154a);
    }

    public int k() {
        int i10 = this.C;
        if (i10 == 0) {
            return -1;
        }
        return (int) (this.D / ((long) i10));
    }

    public int l() {
        int i10 = this.f58179z;
        if (i10 == 0) {
            return -1;
        }
        return (int) (this.B / ((long) i10));
    }

    public int m() {
        int i10 = this.f58178y;
        if (i10 == 0) {
            return -1;
        }
        return this.A / i10;
    }

    public long n() {
        int i10 = this.f58163j;
        return i10 == 0 ? ya.g.f56663b : this.f58162i / ((long) i10);
    }

    public float o() {
        int i10 = this.f58158e;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.K / i10;
    }

    public float p() {
        int i10 = this.f58158e;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.f58165l / i10;
    }

    public float q() {
        int i10 = this.f58158e;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.f58164k / i10;
    }

    public long r() {
        return this.f58158e == 0 ? ya.g.f56663b : P() / ((long) this.f58158e);
    }

    public long s() {
        return this.f58158e == 0 ? ya.g.f56663b : Q() / ((long) this.f58158e);
    }

    public long t() {
        return this.f58158e == 0 ? ya.g.f56663b : R() / ((long) this.f58158e);
    }

    public float u() {
        int i10 = this.f58158e;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.f58167n / i10;
    }

    public long v() {
        return this.f58158e == 0 ? ya.g.f56663b : S() / ((long) this.f58158e);
    }

    public float w() {
        int i10 = this.f58158e;
        if (i10 == 0) {
            return 0.0f;
        }
        return this.f58166m / i10;
    }

    public long x() {
        return this.f58158e == 0 ? ya.g.f56663b : T() / ((long) this.f58158e);
    }

    public long y() {
        return this.f58167n == 0 ? ya.g.f56663b : (J(6) + J(7)) / ((long) this.f58167n);
    }

    public long z() {
        return this.f58166m == 0 ? ya.g.f56663b : T() / ((long) this.f58166m);
    }
}
