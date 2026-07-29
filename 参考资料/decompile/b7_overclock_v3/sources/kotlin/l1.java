package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.5")
@c2(markerClass = {s.class})
@hk.f
public final class l1 implements Comparable<l1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f37983b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f37984c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f37985d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37986e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f37987f = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37988a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @bk.g
    @s0
    public /* synthetic */ l1(int i10) {
        this.f37988a = i10;
    }

    @bk.f
    public static final int A(int i10, byte b10) {
        return j(i10 - j(b10 & 255));
    }

    @bk.f
    public static final long B(int i10, long j10) {
        return p1.j(p1.j(((long) i10) & 4294967295L) - j10);
    }

    @bk.f
    public static final int D(int i10, int i11) {
        return j(i10 - i11);
    }

    @bk.f
    public static final int E(int i10, short s10) {
        return j(i10 - j(s10 & v1.f38215d));
    }

    @bk.f
    public static final byte F(int i10, byte b10) {
        return h1.j((byte) bk.r.a(i10, j(b10 & 255)));
    }

    @bk.f
    public static final long G(int i10, long j10) {
        return bk.t.a(p1.j(((long) i10) & 4294967295L), j10);
    }

    @bk.f
    public static final int H(int i10, int i11) {
        return bk.r.a(i10, i11);
    }

    @bk.f
    public static final short I(int i10, short s10) {
        return v1.j((short) bk.r.a(i10, j(s10 & v1.f38215d)));
    }

    @bk.f
    public static final int J(int i10, int i11) {
        return j(i10 | i11);
    }

    @bk.f
    public static final int K(int i10, byte b10) {
        return j(i10 + j(b10 & 255));
    }

    @bk.f
    public static final long L(int i10, long j10) {
        return p1.j(p1.j(((long) i10) & 4294967295L) + j10);
    }

    @bk.f
    public static final int M(int i10, int i11) {
        return j(i10 + i11);
    }

    @bk.f
    public static final int N(int i10, short s10) {
        return j(i10 + j(s10 & v1.f38215d));
    }

    @bk.f
    public static final qk.y O(int i10, int i11) {
        return new qk.y(i10, i11, null);
    }

    @bk.f
    @v0(version = "1.7")
    @q
    public static final qk.y P(int i10, int i11) {
        return qk.d0.V(i10, i11);
    }

    @bk.f
    public static final int Q(int i10, byte b10) {
        return bk.r.a(i10, j(b10 & 255));
    }

    @bk.f
    public static final long R(int i10, long j10) {
        return bk.t.a(p1.j(((long) i10) & 4294967295L), j10);
    }

    @bk.f
    public static final int S(int i10, int i11) {
        return b2.e(i10, i11);
    }

    @bk.f
    public static final int T(int i10, short s10) {
        return bk.r.a(i10, j(s10 & v1.f38215d));
    }

    @bk.f
    public static final int U(int i10, int i11) {
        return j(i10 << i11);
    }

    @bk.f
    public static final int V(int i10, int i11) {
        return j(i10 >>> i11);
    }

    @bk.f
    public static final int W(int i10, byte b10) {
        return j(i10 * j(b10 & 255));
    }

    @bk.f
    public static final long X(int i10, long j10) {
        return p1.j(p1.j(((long) i10) & 4294967295L) * j10);
    }

    @bk.f
    public static final int Y(int i10, int i11) {
        return j(i10 * i11);
    }

    @bk.f
    public static final int Z(int i10, short s10) {
        return j(i10 * j(s10 & v1.f38215d));
    }

    @bk.f
    public static final byte a0(int i10) {
        return (byte) i10;
    }

    @bk.f
    public static final double b0(int i10) {
        return b2.f(i10);
    }

    @bk.f
    public static final int c(int i10, int i11) {
        return j(i10 & i11);
    }

    @bk.f
    public static final float c0(int i10) {
        return (float) b2.f(i10);
    }

    public static final /* synthetic */ l1 d(int i10) {
        return new l1(i10);
    }

    @bk.f
    public static final int d0(int i10) {
        return i10;
    }

    @bk.f
    public static final int e(int i10, byte b10) {
        return Integer.compare(i10 ^ Integer.MIN_VALUE, j(b10 & 255) ^ Integer.MIN_VALUE);
    }

    @bk.f
    public static final long e0(int i10) {
        return ((long) i10) & 4294967295L;
    }

    @bk.f
    public static final int f(int i10, long j10) {
        return Long.compare(p1.j(((long) i10) & 4294967295L) ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
    }

    @bk.f
    public static final short f0(int i10) {
        return (short) i10;
    }

    @yt.k
    public static String g0(int i10) {
        return String.valueOf(((long) i10) & 4294967295L);
    }

    @bk.f
    public static int h(int i10, int i11) {
        return b2.c(i10, i11);
    }

    @bk.f
    public static final byte h0(int i10) {
        return h1.j((byte) i10);
    }

    @bk.f
    public static final int i(int i10, short s10) {
        return Integer.compare(i10 ^ Integer.MIN_VALUE, j(s10 & v1.f38215d) ^ Integer.MIN_VALUE);
    }

    @bk.f
    public static final int i0(int i10) {
        return i10;
    }

    @bk.g
    @s0
    public static int j(int i10) {
        return i10;
    }

    @bk.f
    public static final long j0(int i10) {
        return p1.j(((long) i10) & 4294967295L);
    }

    @bk.f
    public static final int k(int i10) {
        return j(i10 - 1);
    }

    @bk.f
    public static final short k0(int i10) {
        return v1.j((short) i10);
    }

    @bk.f
    public static final int l(int i10, byte b10) {
        return f1.a(i10, j(b10 & 255));
    }

    @bk.f
    public static final long m(int i10, long j10) {
        return g1.a(p1.j(((long) i10) & 4294967295L), j10);
    }

    @bk.f
    public static final int m0(int i10, int i11) {
        return j(i10 ^ i11);
    }

    @bk.f
    public static final int n(int i10, int i11) {
        return b2.d(i10, i11);
    }

    @bk.f
    public static final int o(int i10, short s10) {
        return f1.a(i10, j(s10 & v1.f38215d));
    }

    public static boolean p(int i10, Object obj) {
        return (obj instanceof l1) && i10 == ((l1) obj).l0();
    }

    public static final boolean q(int i10, int i11) {
        return i10 == i11;
    }

    @bk.f
    public static final int r(int i10, byte b10) {
        return f1.a(i10, j(b10 & 255));
    }

    @bk.f
    public static final long s(int i10, long j10) {
        return g1.a(p1.j(((long) i10) & 4294967295L), j10);
    }

    @bk.f
    public static final int t(int i10, int i11) {
        return f1.a(i10, i11);
    }

    @bk.f
    public static final int u(int i10, short s10) {
        return f1.a(i10, j(s10 & v1.f38215d));
    }

    @s0
    public static /* synthetic */ void v() {
    }

    public static int w(int i10) {
        return i10;
    }

    @bk.f
    public static final int x(int i10) {
        return j(i10 + 1);
    }

    @bk.f
    public static final int y(int i10) {
        return j(~i10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(l1 l1Var) {
        return b2.c(l0(), l1Var.l0());
    }

    public boolean equals(Object obj) {
        return p(this.f37988a, obj);
    }

    @bk.f
    public final int g(int i10) {
        return b2.c(l0(), i10);
    }

    public int hashCode() {
        return w(this.f37988a);
    }

    public final /* synthetic */ int l0() {
        return this.f37988a;
    }

    @yt.k
    public String toString() {
        return g0(this.f37988a);
    }
}
