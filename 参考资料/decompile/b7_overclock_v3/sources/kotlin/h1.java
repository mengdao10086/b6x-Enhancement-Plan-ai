package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.5")
@c2(markerClass = {s.class})
@hk.f
public final class h1 implements Comparable<h1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f37773b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f37774c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f37775d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37776e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f37777f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f37778a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @bk.g
    @s0
    public /* synthetic */ h1(byte b10) {
        this.f37778a = b10;
    }

    @bk.f
    public static final int A(byte b10, byte b11) {
        return l1.j(l1.j(b10 & 255) - l1.j(b11 & 255));
    }

    @bk.f
    public static final long B(byte b10, long j10) {
        return p1.j(p1.j(((long) b10) & 255) - j10);
    }

    @bk.f
    public static final int D(byte b10, int i10) {
        return l1.j(l1.j(b10 & 255) - i10);
    }

    @bk.f
    public static final int E(byte b10, short s10) {
        return l1.j(l1.j(b10 & 255) - l1.j(s10 & v1.f38215d));
    }

    @bk.f
    public static final byte F(byte b10, byte b11) {
        return j((byte) bk.r.a(l1.j(b10 & 255), l1.j(b11 & 255)));
    }

    @bk.f
    public static final long G(byte b10, long j10) {
        return bk.t.a(p1.j(((long) b10) & 255), j10);
    }

    @bk.f
    public static final int H(byte b10, int i10) {
        return bk.r.a(l1.j(b10 & 255), i10);
    }

    @bk.f
    public static final short I(byte b10, short s10) {
        return v1.j((short) bk.r.a(l1.j(b10 & 255), l1.j(s10 & v1.f38215d)));
    }

    @bk.f
    public static final byte J(byte b10, byte b11) {
        return j((byte) (b10 | b11));
    }

    @bk.f
    public static final int K(byte b10, byte b11) {
        return l1.j(l1.j(b10 & 255) + l1.j(b11 & 255));
    }

    @bk.f
    public static final long L(byte b10, long j10) {
        return p1.j(p1.j(((long) b10) & 255) + j10);
    }

    @bk.f
    public static final int M(byte b10, int i10) {
        return l1.j(l1.j(b10 & 255) + i10);
    }

    @bk.f
    public static final int N(byte b10, short s10) {
        return l1.j(l1.j(b10 & 255) + l1.j(s10 & v1.f38215d));
    }

    @bk.f
    public static final qk.y O(byte b10, byte b11) {
        return new qk.y(l1.j(b10 & 255), l1.j(b11 & 255), null);
    }

    @bk.f
    @v0(version = "1.7")
    @q
    public static final qk.y P(byte b10, byte b11) {
        return qk.d0.V(l1.j(b10 & 255), l1.j(b11 & 255));
    }

    @bk.f
    public static final int Q(byte b10, byte b11) {
        return bk.r.a(l1.j(b10 & 255), l1.j(b11 & 255));
    }

    @bk.f
    public static final long R(byte b10, long j10) {
        return bk.t.a(p1.j(((long) b10) & 255), j10);
    }

    @bk.f
    public static final int S(byte b10, int i10) {
        return bk.r.a(l1.j(b10 & 255), i10);
    }

    @bk.f
    public static final int T(byte b10, short s10) {
        return bk.r.a(l1.j(b10 & 255), l1.j(s10 & v1.f38215d));
    }

    @bk.f
    public static final int U(byte b10, byte b11) {
        return l1.j(l1.j(b10 & 255) * l1.j(b11 & 255));
    }

    @bk.f
    public static final long V(byte b10, long j10) {
        return p1.j(p1.j(((long) b10) & 255) * j10);
    }

    @bk.f
    public static final int W(byte b10, int i10) {
        return l1.j(l1.j(b10 & 255) * i10);
    }

    @bk.f
    public static final int X(byte b10, short s10) {
        return l1.j(l1.j(b10 & 255) * l1.j(s10 & v1.f38215d));
    }

    @bk.f
    public static final byte Y(byte b10) {
        return b10;
    }

    @bk.f
    public static final double Z(byte b10) {
        return b10 & 255;
    }

    @bk.f
    public static final float a0(byte b10) {
        return b10 & 255;
    }

    @bk.f
    public static final int b0(byte b10) {
        return b10 & 255;
    }

    @bk.f
    public static final byte c(byte b10, byte b11) {
        return j((byte) (b10 & b11));
    }

    @bk.f
    public static final long c0(byte b10) {
        return ((long) b10) & 255;
    }

    public static final /* synthetic */ h1 d(byte b10) {
        return new h1(b10);
    }

    @bk.f
    public static final short d0(byte b10) {
        return (short) (b10 & 255);
    }

    @yt.k
    public static String e0(byte b10) {
        return String.valueOf(b10 & 255);
    }

    @bk.f
    public static int f(byte b10, byte b11) {
        return kotlin.jvm.internal.f0.t(b10 & 255, b11 & 255);
    }

    @bk.f
    public static final byte f0(byte b10) {
        return b10;
    }

    @bk.f
    public static final int g(byte b10, long j10) {
        return Long.compare(p1.j(((long) b10) & 255) ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
    }

    @bk.f
    public static final int g0(byte b10) {
        return l1.j(b10 & 255);
    }

    @bk.f
    public static final int h(byte b10, int i10) {
        return Integer.compare(l1.j(b10 & 255) ^ Integer.MIN_VALUE, i10 ^ Integer.MIN_VALUE);
    }

    @bk.f
    public static final long h0(byte b10) {
        return p1.j(((long) b10) & 255);
    }

    @bk.f
    public static final int i(byte b10, short s10) {
        return kotlin.jvm.internal.f0.t(b10 & 255, s10 & v1.f38215d);
    }

    @bk.f
    public static final short i0(byte b10) {
        return v1.j((short) (b10 & 255));
    }

    @bk.g
    @s0
    public static byte j(byte b10) {
        return b10;
    }

    @bk.f
    public static final byte k(byte b10) {
        return j((byte) (b10 - 1));
    }

    @bk.f
    public static final byte k0(byte b10, byte b11) {
        return j((byte) (b10 ^ b11));
    }

    @bk.f
    public static final int l(byte b10, byte b11) {
        return f1.a(l1.j(b10 & 255), l1.j(b11 & 255));
    }

    @bk.f
    public static final long m(byte b10, long j10) {
        return g1.a(p1.j(((long) b10) & 255), j10);
    }

    @bk.f
    public static final int n(byte b10, int i10) {
        return f1.a(l1.j(b10 & 255), i10);
    }

    @bk.f
    public static final int o(byte b10, short s10) {
        return f1.a(l1.j(b10 & 255), l1.j(s10 & v1.f38215d));
    }

    public static boolean p(byte b10, Object obj) {
        return (obj instanceof h1) && b10 == ((h1) obj).j0();
    }

    public static final boolean q(byte b10, byte b11) {
        return b10 == b11;
    }

    @bk.f
    public static final int r(byte b10, byte b11) {
        return f1.a(l1.j(b10 & 255), l1.j(b11 & 255));
    }

    @bk.f
    public static final long s(byte b10, long j10) {
        return g1.a(p1.j(((long) b10) & 255), j10);
    }

    @bk.f
    public static final int t(byte b10, int i10) {
        return f1.a(l1.j(b10 & 255), i10);
    }

    @bk.f
    public static final int u(byte b10, short s10) {
        return f1.a(l1.j(b10 & 255), l1.j(s10 & v1.f38215d));
    }

    @s0
    public static /* synthetic */ void v() {
    }

    public static int w(byte b10) {
        return b10;
    }

    @bk.f
    public static final byte x(byte b10) {
        return j((byte) (b10 + 1));
    }

    @bk.f
    public static final byte y(byte b10) {
        return j((byte) (~b10));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h1 h1Var) {
        return kotlin.jvm.internal.f0.t(j0() & 255, h1Var.j0() & 255);
    }

    @bk.f
    public final int e(byte b10) {
        return kotlin.jvm.internal.f0.t(j0() & 255, b10 & 255);
    }

    public boolean equals(Object obj) {
        return p(this.f37778a, obj);
    }

    public int hashCode() {
        return w(this.f37778a);
    }

    public final /* synthetic */ byte j0() {
        return this.f37778a;
    }

    @yt.k
    public String toString() {
        return e0(this.f37778a);
    }
}
