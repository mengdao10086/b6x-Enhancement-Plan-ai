package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.5")
@c2(markerClass = {s.class})
@hk.f
public final class p1 implements Comparable<p1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f37992b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f37993c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f37994d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37995e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f37996f = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f37997a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @bk.g
    @s0
    public /* synthetic */ p1(long j10) {
        this.f37997a = j10;
    }

    @bk.f
    public static final long A(long j10, byte b10) {
        return j(j10 - j(((long) b10) & 255));
    }

    @bk.f
    public static final long B(long j10, long j11) {
        return j(j10 - j11);
    }

    @bk.f
    public static final long D(long j10, int i10) {
        return j(j10 - j(((long) i10) & 4294967295L));
    }

    @bk.f
    public static final long E(long j10, short s10) {
        return j(j10 - j(((long) s10) & dm.g.f26388t));
    }

    @bk.f
    public static final byte F(long j10, byte b10) {
        return h1.j((byte) bk.t.a(j10, j(((long) b10) & 255)));
    }

    @bk.f
    public static final long G(long j10, long j11) {
        return bk.t.a(j10, j11);
    }

    @bk.f
    public static final int H(long j10, int i10) {
        return l1.j((int) bk.t.a(j10, j(((long) i10) & 4294967295L)));
    }

    @bk.f
    public static final short I(long j10, short s10) {
        return v1.j((short) bk.t.a(j10, j(((long) s10) & dm.g.f26388t)));
    }

    @bk.f
    public static final long J(long j10, long j11) {
        return j(j10 | j11);
    }

    @bk.f
    public static final long K(long j10, byte b10) {
        return j(j10 + j(((long) b10) & 255));
    }

    @bk.f
    public static final long L(long j10, long j11) {
        return j(j10 + j11);
    }

    @bk.f
    public static final long M(long j10, int i10) {
        return j(j10 + j(((long) i10) & 4294967295L));
    }

    @bk.f
    public static final long N(long j10, short s10) {
        return j(j10 + j(((long) s10) & dm.g.f26388t));
    }

    @bk.f
    public static final qk.b0 O(long j10, long j11) {
        return new qk.b0(j10, j11, null);
    }

    @bk.f
    @v0(version = "1.7")
    @q
    public static final qk.b0 P(long j10, long j11) {
        return qk.d0.X(j10, j11);
    }

    @bk.f
    public static final long Q(long j10, byte b10) {
        return bk.t.a(j10, j(((long) b10) & 255));
    }

    @bk.f
    public static final long R(long j10, long j11) {
        return b2.i(j10, j11);
    }

    @bk.f
    public static final long S(long j10, int i10) {
        return bk.t.a(j10, j(((long) i10) & 4294967295L));
    }

    @bk.f
    public static final long T(long j10, short s10) {
        return bk.t.a(j10, j(((long) s10) & dm.g.f26388t));
    }

    @bk.f
    public static final long U(long j10, int i10) {
        return j(j10 << i10);
    }

    @bk.f
    public static final long V(long j10, int i10) {
        return j(j10 >>> i10);
    }

    @bk.f
    public static final long W(long j10, byte b10) {
        return j(j10 * j(((long) b10) & 255));
    }

    @bk.f
    public static final long X(long j10, long j11) {
        return j(j10 * j11);
    }

    @bk.f
    public static final long Y(long j10, int i10) {
        return j(j10 * j(((long) i10) & 4294967295L));
    }

    @bk.f
    public static final long Z(long j10, short s10) {
        return j(j10 * j(((long) s10) & dm.g.f26388t));
    }

    @bk.f
    public static final byte a0(long j10) {
        return (byte) j10;
    }

    @bk.f
    public static final double b0(long j10) {
        return b2.j(j10);
    }

    @bk.f
    public static final long c(long j10, long j11) {
        return j(j10 & j11);
    }

    @bk.f
    public static final float c0(long j10) {
        return (float) b2.j(j10);
    }

    public static final /* synthetic */ p1 d(long j10) {
        return new p1(j10);
    }

    @bk.f
    public static final int d0(long j10) {
        return (int) j10;
    }

    @bk.f
    public static final int e(long j10, byte b10) {
        return Long.compare(j10 ^ Long.MIN_VALUE, j(((long) b10) & 255) ^ Long.MIN_VALUE);
    }

    @bk.f
    public static final long e0(long j10) {
        return j10;
    }

    @bk.f
    public static final short f0(long j10) {
        return (short) j10;
    }

    @bk.f
    public static int g(long j10, long j11) {
        return b2.g(j10, j11);
    }

    @yt.k
    public static String g0(long j10) {
        return b2.k(j10);
    }

    @bk.f
    public static final int h(long j10, int i10) {
        return Long.compare(j10 ^ Long.MIN_VALUE, j(((long) i10) & 4294967295L) ^ Long.MIN_VALUE);
    }

    @bk.f
    public static final byte h0(long j10) {
        return h1.j((byte) j10);
    }

    @bk.f
    public static final int i(long j10, short s10) {
        return Long.compare(j10 ^ Long.MIN_VALUE, j(((long) s10) & dm.g.f26388t) ^ Long.MIN_VALUE);
    }

    @bk.f
    public static final int i0(long j10) {
        return l1.j((int) j10);
    }

    @bk.g
    @s0
    public static long j(long j10) {
        return j10;
    }

    @bk.f
    public static final long j0(long j10) {
        return j10;
    }

    @bk.f
    public static final long k(long j10) {
        return j(j10 - 1);
    }

    @bk.f
    public static final short k0(long j10) {
        return v1.j((short) j10);
    }

    @bk.f
    public static final long l(long j10, byte b10) {
        return g1.a(j10, j(((long) b10) & 255));
    }

    @bk.f
    public static final long m(long j10, long j11) {
        return b2.h(j10, j11);
    }

    @bk.f
    public static final long m0(long j10, long j11) {
        return j(j10 ^ j11);
    }

    @bk.f
    public static final long n(long j10, int i10) {
        return g1.a(j10, j(((long) i10) & 4294967295L));
    }

    @bk.f
    public static final long o(long j10, short s10) {
        return g1.a(j10, j(((long) s10) & dm.g.f26388t));
    }

    public static boolean p(long j10, Object obj) {
        return (obj instanceof p1) && j10 == ((p1) obj).l0();
    }

    public static final boolean q(long j10, long j11) {
        return j10 == j11;
    }

    @bk.f
    public static final long r(long j10, byte b10) {
        return g1.a(j10, j(((long) b10) & 255));
    }

    @bk.f
    public static final long s(long j10, long j11) {
        return g1.a(j10, j11);
    }

    @bk.f
    public static final long t(long j10, int i10) {
        return g1.a(j10, j(((long) i10) & 4294967295L));
    }

    @bk.f
    public static final long u(long j10, short s10) {
        return g1.a(j10, j(((long) s10) & dm.g.f26388t));
    }

    @s0
    public static /* synthetic */ void v() {
    }

    public static int w(long j10) {
        return com.flydigi.data.bean.a.a(j10);
    }

    @bk.f
    public static final long x(long j10) {
        return j(j10 + 1);
    }

    @bk.f
    public static final long y(long j10) {
        return j(~j10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(p1 p1Var) {
        return b2.g(l0(), p1Var.l0());
    }

    public boolean equals(Object obj) {
        return p(this.f37997a, obj);
    }

    @bk.f
    public final int f(long j10) {
        return b2.g(l0(), j10);
    }

    public int hashCode() {
        return w(this.f37997a);
    }

    public final /* synthetic */ long l0() {
        return this.f37997a;
    }

    @yt.k
    public String toString() {
        return g0(this.f37997a);
    }
}
