package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.5")
@c2(markerClass = {s.class})
@hk.f
public final class v1 implements Comparable<v1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f38213b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final short f38214c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final short f38215d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38216e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38217f = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f38218a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @bk.g
    @s0
    public /* synthetic */ v1(short s10) {
        this.f38218a = s10;
    }

    @bk.f
    public static final int A(short s10, byte b10) {
        return l1.j(l1.j(s10 & f38215d) - l1.j(b10 & 255));
    }

    @bk.f
    public static final long B(short s10, long j10) {
        return p1.j(p1.j(((long) s10) & dm.g.f26388t) - j10);
    }

    @bk.f
    public static final int D(short s10, int i10) {
        return l1.j(l1.j(s10 & f38215d) - i10);
    }

    @bk.f
    public static final int E(short s10, short s11) {
        return l1.j(l1.j(s10 & f38215d) - l1.j(s11 & f38215d));
    }

    @bk.f
    public static final byte F(short s10, byte b10) {
        return h1.j((byte) bk.r.a(l1.j(s10 & f38215d), l1.j(b10 & 255)));
    }

    @bk.f
    public static final long G(short s10, long j10) {
        return bk.t.a(p1.j(((long) s10) & dm.g.f26388t), j10);
    }

    @bk.f
    public static final int H(short s10, int i10) {
        return bk.r.a(l1.j(s10 & f38215d), i10);
    }

    @bk.f
    public static final short I(short s10, short s11) {
        return j((short) bk.r.a(l1.j(s10 & f38215d), l1.j(s11 & f38215d)));
    }

    @bk.f
    public static final short J(short s10, short s11) {
        return j((short) (s10 | s11));
    }

    @bk.f
    public static final int K(short s10, byte b10) {
        return l1.j(l1.j(s10 & f38215d) + l1.j(b10 & 255));
    }

    @bk.f
    public static final long L(short s10, long j10) {
        return p1.j(p1.j(((long) s10) & dm.g.f26388t) + j10);
    }

    @bk.f
    public static final int M(short s10, int i10) {
        return l1.j(l1.j(s10 & f38215d) + i10);
    }

    @bk.f
    public static final int N(short s10, short s11) {
        return l1.j(l1.j(s10 & f38215d) + l1.j(s11 & f38215d));
    }

    @bk.f
    public static final qk.y O(short s10, short s11) {
        return new qk.y(l1.j(s10 & f38215d), l1.j(s11 & f38215d), null);
    }

    @bk.f
    @v0(version = "1.7")
    @q
    public static final qk.y P(short s10, short s11) {
        return qk.d0.V(l1.j(s10 & f38215d), l1.j(s11 & f38215d));
    }

    @bk.f
    public static final int Q(short s10, byte b10) {
        return bk.r.a(l1.j(s10 & f38215d), l1.j(b10 & 255));
    }

    @bk.f
    public static final long R(short s10, long j10) {
        return bk.t.a(p1.j(((long) s10) & dm.g.f26388t), j10);
    }

    @bk.f
    public static final int S(short s10, int i10) {
        return bk.r.a(l1.j(s10 & f38215d), i10);
    }

    @bk.f
    public static final int T(short s10, short s11) {
        return bk.r.a(l1.j(s10 & f38215d), l1.j(s11 & f38215d));
    }

    @bk.f
    public static final int U(short s10, byte b10) {
        return l1.j(l1.j(s10 & f38215d) * l1.j(b10 & 255));
    }

    @bk.f
    public static final long V(short s10, long j10) {
        return p1.j(p1.j(((long) s10) & dm.g.f26388t) * j10);
    }

    @bk.f
    public static final int W(short s10, int i10) {
        return l1.j(l1.j(s10 & f38215d) * i10);
    }

    @bk.f
    public static final int X(short s10, short s11) {
        return l1.j(l1.j(s10 & f38215d) * l1.j(s11 & f38215d));
    }

    @bk.f
    public static final byte Y(short s10) {
        return (byte) s10;
    }

    @bk.f
    public static final double Z(short s10) {
        return s10 & f38215d;
    }

    @bk.f
    public static final float a0(short s10) {
        return s10 & f38215d;
    }

    @bk.f
    public static final int b0(short s10) {
        return s10 & f38215d;
    }

    @bk.f
    public static final short c(short s10, short s11) {
        return j((short) (s10 & s11));
    }

    @bk.f
    public static final long c0(short s10) {
        return ((long) s10) & dm.g.f26388t;
    }

    public static final /* synthetic */ v1 d(short s10) {
        return new v1(s10);
    }

    @bk.f
    public static final short d0(short s10) {
        return s10;
    }

    @bk.f
    public static final int e(short s10, byte b10) {
        return kotlin.jvm.internal.f0.t(s10 & f38215d, b10 & 255);
    }

    @yt.k
    public static String e0(short s10) {
        return String.valueOf(s10 & f38215d);
    }

    @bk.f
    public static final int f(short s10, long j10) {
        return Long.compare(p1.j(((long) s10) & dm.g.f26388t) ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
    }

    @bk.f
    public static final byte f0(short s10) {
        return h1.j((byte) s10);
    }

    @bk.f
    public static final int g(short s10, int i10) {
        return Integer.compare(l1.j(s10 & f38215d) ^ Integer.MIN_VALUE, i10 ^ Integer.MIN_VALUE);
    }

    @bk.f
    public static final int g0(short s10) {
        return l1.j(s10 & f38215d);
    }

    @bk.f
    public static final long h0(short s10) {
        return p1.j(((long) s10) & dm.g.f26388t);
    }

    @bk.f
    public static int i(short s10, short s11) {
        return kotlin.jvm.internal.f0.t(s10 & f38215d, s11 & f38215d);
    }

    @bk.f
    public static final short i0(short s10) {
        return s10;
    }

    @bk.g
    @s0
    public static short j(short s10) {
        return s10;
    }

    @bk.f
    public static final short k(short s10) {
        return j((short) (s10 - 1));
    }

    @bk.f
    public static final short k0(short s10, short s11) {
        return j((short) (s10 ^ s11));
    }

    @bk.f
    public static final int l(short s10, byte b10) {
        return f1.a(l1.j(s10 & f38215d), l1.j(b10 & 255));
    }

    @bk.f
    public static final long m(short s10, long j10) {
        return g1.a(p1.j(((long) s10) & dm.g.f26388t), j10);
    }

    @bk.f
    public static final int n(short s10, int i10) {
        return f1.a(l1.j(s10 & f38215d), i10);
    }

    @bk.f
    public static final int o(short s10, short s11) {
        return f1.a(l1.j(s10 & f38215d), l1.j(s11 & f38215d));
    }

    public static boolean p(short s10, Object obj) {
        return (obj instanceof v1) && s10 == ((v1) obj).j0();
    }

    public static final boolean q(short s10, short s11) {
        return s10 == s11;
    }

    @bk.f
    public static final int r(short s10, byte b10) {
        return f1.a(l1.j(s10 & f38215d), l1.j(b10 & 255));
    }

    @bk.f
    public static final long s(short s10, long j10) {
        return g1.a(p1.j(((long) s10) & dm.g.f26388t), j10);
    }

    @bk.f
    public static final int t(short s10, int i10) {
        return f1.a(l1.j(s10 & f38215d), i10);
    }

    @bk.f
    public static final int u(short s10, short s11) {
        return f1.a(l1.j(s10 & f38215d), l1.j(s11 & f38215d));
    }

    @s0
    public static /* synthetic */ void v() {
    }

    public static int w(short s10) {
        return s10;
    }

    @bk.f
    public static final short x(short s10) {
        return j((short) (s10 + 1));
    }

    @bk.f
    public static final short y(short s10) {
        return j((short) (~s10));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(v1 v1Var) {
        return kotlin.jvm.internal.f0.t(j0() & f38215d, v1Var.j0() & f38215d);
    }

    public boolean equals(Object obj) {
        return p(this.f38218a, obj);
    }

    @bk.f
    public final int h(short s10) {
        return kotlin.jvm.internal.f0.t(j0() & f38215d, s10 & f38215d);
    }

    public int hashCode() {
        return w(this.f38218a);
    }

    public final /* synthetic */ short j0() {
        return this.f38218a;
    }

    @yt.k
    public String toString() {
        return e0(this.f38218a);
    }
}
