package ya;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.source.ads.a;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f57231a = new a();

    public class a extends x1 {
        @Override // ya.x1
        public int b(Object obj) {
            return -1;
        }

        @Override // ya.x1
        public b g(int i10, b bVar, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // ya.x1
        public int i() {
            return 0;
        }

        @Override // ya.x1
        public Object m(int i10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // ya.x1
        public c o(int i10, c cVar, long j10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // ya.x1
        public int q() {
            return 0;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.p0
        public Object f57232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        public Object f57233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f57234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f57235d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f57236e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.android.exoplayer2.source.ads.a f57237f = com.google.android.exoplayer2.source.ads.a.f17544l;

        public int a(int i10) {
            return this.f57237f.f17548d[i10].f17551a;
        }

        public long b(int i10, int i11) {
            a.C0181a c0181a = this.f57237f.f17548d[i10];
            return c0181a.f17551a != -1 ? c0181a.f17554d[i11] : g.f56663b;
        }

        public int c() {
            return this.f57237f.f17546b;
        }

        public int d(long j10) {
            return this.f57237f.a(j10, this.f57235d);
        }

        public int e(long j10) {
            return this.f57237f.b(j10, this.f57235d);
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return hd.u0.c(this.f57232a, bVar.f57232a) && hd.u0.c(this.f57233b, bVar.f57233b) && this.f57234c == bVar.f57234c && this.f57235d == bVar.f57235d && this.f57236e == bVar.f57236e && hd.u0.c(this.f57237f, bVar.f57237f);
        }

        public long f(int i10) {
            return this.f57237f.f17547c[i10];
        }

        public long g() {
            return this.f57237f.f17549e;
        }

        @g.p0
        public Object h() {
            return this.f57237f.f17545a;
        }

        public int hashCode() {
            Object obj = this.f57232a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f57233b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f57234c) * 31;
            long j10 = this.f57235d;
            int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f57236e;
            return ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f57237f.hashCode();
        }

        public long i() {
            return g.d(this.f57235d);
        }

        public long j() {
            return this.f57235d;
        }

        public int k(int i10) {
            return this.f57237f.f17548d[i10].c();
        }

        public int l(int i10, int i11) {
            return this.f57237f.f17548d[i10].d(i11);
        }

        public long m() {
            return g.d(this.f57236e);
        }

        public long n() {
            return this.f57236e;
        }

        public boolean o(int i10) {
            return !this.f57237f.f17548d[i10].e();
        }

        public b p(@g.p0 Object obj, @g.p0 Object obj2, int i10, long j10, long j11) {
            return q(obj, obj2, i10, j10, j11, com.google.android.exoplayer2.source.ads.a.f17544l);
        }

        public b q(@g.p0 Object obj, @g.p0 Object obj2, int i10, long j10, long j11, com.google.android.exoplayer2.source.ads.a aVar) {
            this.f57232a = obj;
            this.f57233b = obj2;
            this.f57234c = i10;
            this.f57235d = j10;
            this.f57236e = j11;
            this.f57237f = aVar;
            return this;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final Object f57238r = new Object();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final v0 f57239s = new v0.c().z("com.google.android.exoplayer2.Timeline").F(Uri.EMPTY).a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        @Deprecated
        public Object f57241b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public Object f57243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f57244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f57245f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f57246g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f57247h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f57248i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Deprecated
        public boolean f57249j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @g.p0
        public v0.f f57250k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f57251l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f57252m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f57253n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f57254o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f57255p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f57256q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f57240a = f57238r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public v0 f57242c = f57239s;

        public long a() {
            return hd.u0.j0(this.f57246g);
        }

        public long b() {
            return g.d(this.f57254o);
        }

        public long c() {
            return this.f57254o;
        }

        public long d() {
            return g.d(this.f57255p);
        }

        public long e() {
            return this.f57255p;
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !c.class.equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return hd.u0.c(this.f57240a, cVar.f57240a) && hd.u0.c(this.f57242c, cVar.f57242c) && hd.u0.c(this.f57243d, cVar.f57243d) && hd.u0.c(this.f57250k, cVar.f57250k) && this.f57244e == cVar.f57244e && this.f57245f == cVar.f57245f && this.f57246g == cVar.f57246g && this.f57247h == cVar.f57247h && this.f57248i == cVar.f57248i && this.f57251l == cVar.f57251l && this.f57254o == cVar.f57254o && this.f57255p == cVar.f57255p && this.f57252m == cVar.f57252m && this.f57253n == cVar.f57253n && this.f57256q == cVar.f57256q;
        }

        public long f() {
            return g.d(this.f57256q);
        }

        public long g() {
            return this.f57256q;
        }

        public boolean h() {
            hd.a.i(this.f57249j == (this.f57250k != null));
            return this.f57250k != null;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f57240a.hashCode()) * 31) + this.f57242c.hashCode()) * 31;
            Object obj = this.f57243d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            v0.f fVar = this.f57250k;
            int iHashCode3 = (iHashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 31;
            long j10 = this.f57244e;
            int i10 = (iHashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f57245f;
            int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f57246g;
            int i12 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f57247h ? 1 : 0)) * 31) + (this.f57248i ? 1 : 0)) * 31) + (this.f57251l ? 1 : 0)) * 31;
            long j13 = this.f57254o;
            int i13 = (i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            long j14 = this.f57255p;
            int i14 = (((((i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.f57252m) * 31) + this.f57253n) * 31;
            long j15 = this.f57256q;
            return i14 + ((int) (j15 ^ (j15 >>> 32)));
        }

        public c i(Object obj, @g.p0 v0 v0Var, @g.p0 Object obj2, long j10, long j11, long j12, boolean z10, boolean z11, @g.p0 v0.f fVar, long j13, long j14, int i10, int i11, long j15) {
            v0.g gVar;
            this.f57240a = obj;
            this.f57242c = v0Var != null ? v0Var : f57239s;
            this.f57241b = (v0Var == null || (gVar = v0Var.f57132b) == null) ? null : gVar.f57190h;
            this.f57243d = obj2;
            this.f57244e = j10;
            this.f57245f = j11;
            this.f57246g = j12;
            this.f57247h = z10;
            this.f57248i = z11;
            this.f57249j = fVar != null;
            this.f57250k = fVar;
            this.f57254o = j13;
            this.f57255p = j14;
            this.f57252m = i10;
            this.f57253n = i11;
            this.f57256q = j15;
            this.f57251l = false;
            return this;
        }
    }

    public int a(boolean z10) {
        return r() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z10) {
        if (r()) {
            return -1;
        }
        return q() - 1;
    }

    public final int d(int i10, b bVar, c cVar, int i11, boolean z10) {
        int i12 = f(i10, bVar).f57234c;
        if (n(i12, cVar).f57253n != i10) {
            return i10 + 1;
        }
        int iE = e(i12, i11, z10);
        if (iE == -1) {
            return -1;
        }
        return n(iE, cVar).f57252m;
    }

    public int e(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == c(z10)) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == c(z10) ? a(z10) : i10 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        if (x1Var.q() != q() || x1Var.i() != i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i10 = 0; i10 < q(); i10++) {
            if (!n(i10, cVar).equals(x1Var.n(i10, cVar2))) {
                return false;
            }
        }
        for (int i11 = 0; i11 < i(); i11++) {
            if (!g(i11, bVar, true).equals(x1Var.g(i11, bVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public final b f(int i10, b bVar) {
        return g(i10, bVar, false);
    }

    public abstract b g(int i10, b bVar, boolean z10);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int iQ = 217 + q();
        for (int i10 = 0; i10 < q(); i10++) {
            iQ = (iQ * 31) + n(i10, cVar).hashCode();
        }
        int i11 = (iQ * 31) + i();
        for (int i12 = 0; i12 < i(); i12++) {
            i11 = (i11 * 31) + g(i12, bVar, true).hashCode();
        }
        return i11;
    }

    public abstract int i();

    public final Pair<Object, Long> j(c cVar, b bVar, int i10, long j10) {
        return (Pair) hd.a.g(k(cVar, bVar, i10, j10, 0L));
    }

    @g.p0
    public final Pair<Object, Long> k(c cVar, b bVar, int i10, long j10, long j11) {
        hd.a.c(i10, 0, q());
        o(i10, cVar, j11);
        if (j10 == g.f56663b) {
            j10 = cVar.c();
            if (j10 == g.f56663b) {
                return null;
            }
        }
        int i11 = cVar.f57252m;
        long jG = cVar.g() + j10;
        long j12 = g(i11, bVar, true).j();
        while (j12 != g.f56663b && jG >= j12 && i11 < cVar.f57253n) {
            jG -= j12;
            i11++;
            j12 = g(i11, bVar, true).j();
        }
        return Pair.create(hd.a.g(bVar.f57233b), Long.valueOf(jG));
    }

    public int l(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == a(z10)) {
                return -1;
            }
            return i10 - 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == a(z10) ? c(z10) : i10 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i10);

    public final c n(int i10, c cVar) {
        return o(i10, cVar, 0L);
    }

    public abstract c o(int i10, c cVar, long j10);

    @Deprecated
    public final c p(int i10, c cVar, boolean z10) {
        return o(i10, cVar, 0L);
    }

    public abstract int q();

    public final boolean r() {
        return q() == 0;
    }

    public final boolean s(int i10, b bVar, c cVar, int i11, boolean z10) {
        return d(i10, bVar, cVar, i11, z10) == -1;
    }
}
