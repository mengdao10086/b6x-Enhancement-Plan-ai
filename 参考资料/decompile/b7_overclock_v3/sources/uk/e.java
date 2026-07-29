package uk;

import com.umeng.analytics.pro.an;
import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.s0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.DurationUnit;
import kotlin.v0;
import kotlinx.coroutines.o1;
import qk.v;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1484:1\n38#1:1485\n38#1:1486\n38#1:1487\n38#1:1488\n38#1:1489\n672#1,2:1490\n689#1,2:1499\n163#2,6:1492\n1#3:1498\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1485\n40#1:1486\n458#1:1487\n478#1:1488\n651#1:1489\n968#1:1490,2\n1059#1:1499,2\n1010#1:1492,6\n*E\n"})
@v0(version = "1.6")
@c2(markerClass = {k.class})
@hk.f
public final class e implements Comparable<e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f52169b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f52170c = k(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f52171d = g.j(4611686018427387903L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f52172e = g.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f52173a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @bk.f
        public static /* synthetic */ void A(double d10) {
        }

        @bk.f
        public static /* synthetic */ void B(int i10) {
        }

        @bk.f
        public static /* synthetic */ void C(long j10) {
        }

        @bk.f
        public static /* synthetic */ void G(double d10) {
        }

        @bk.f
        public static /* synthetic */ void H(int i10) {
        }

        @bk.f
        public static /* synthetic */ void I(long j10) {
        }

        @bk.f
        public static /* synthetic */ void N(double d10) {
        }

        @bk.f
        public static /* synthetic */ void O(int i10) {
        }

        @bk.f
        public static /* synthetic */ void P(long j10) {
        }

        @bk.f
        public static /* synthetic */ void T(double d10) {
        }

        @bk.f
        public static /* synthetic */ void U(int i10) {
        }

        @bk.f
        public static /* synthetic */ void V(long j10) {
        }

        @bk.f
        public static /* synthetic */ void h(double d10) {
        }

        @bk.f
        public static /* synthetic */ void i(int i10) {
        }

        @bk.f
        public static /* synthetic */ void j(long j10) {
        }

        @bk.f
        public static /* synthetic */ void n(double d10) {
        }

        @bk.f
        public static /* synthetic */ void o(int i10) {
        }

        @bk.f
        public static /* synthetic */ void p(long j10) {
        }

        @bk.f
        public static /* synthetic */ void u(double d10) {
        }

        @bk.f
        public static /* synthetic */ void v(int i10) {
        }

        @bk.f
        public static /* synthetic */ void w(long j10) {
        }

        public final long D(double d10) {
            return g.l0(d10, DurationUnit.MINUTES);
        }

        public final long E(int i10) {
            return g.m0(i10, DurationUnit.MINUTES);
        }

        public final long F(long j10) {
            return g.n0(j10, DurationUnit.MINUTES);
        }

        public final long J() {
            return e.f52172e;
        }

        public final long K(double d10) {
            return g.l0(d10, DurationUnit.NANOSECONDS);
        }

        public final long L(int i10) {
            return g.m0(i10, DurationUnit.NANOSECONDS);
        }

        public final long M(long j10) {
            return g.n0(j10, DurationUnit.NANOSECONDS);
        }

        public final long Q(double d10) {
            return g.l0(d10, DurationUnit.SECONDS);
        }

        public final long R(int i10) {
            return g.m0(i10, DurationUnit.SECONDS);
        }

        public final long S(long j10) {
            return g.n0(j10, DurationUnit.SECONDS);
        }

        public final long W() {
            return e.f52170c;
        }

        @kotlin.k(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long X(double d10) {
            return g.l0(d10, DurationUnit.HOURS);
        }

        @kotlin.k(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long Y(int i10) {
            return g.m0(i10, DurationUnit.HOURS);
        }

        @kotlin.k(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long Z(long j10) {
            return g.n0(j10, DurationUnit.HOURS);
        }

        @k
        public final double a(double d10, @yt.k DurationUnit sourceUnit, @yt.k DurationUnit targetUnit) {
            f0.p(sourceUnit, "sourceUnit");
            f0.p(targetUnit, "targetUnit");
            return i.a(d10, sourceUnit, targetUnit);
        }

        @kotlin.k(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long a0(double d10) {
            return g.l0(d10, DurationUnit.MICROSECONDS);
        }

        @kotlin.k(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long b(double d10) {
            return g.l0(d10, DurationUnit.DAYS);
        }

        @kotlin.k(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long b0(int i10) {
            return g.m0(i10, DurationUnit.MICROSECONDS);
        }

        @kotlin.k(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long c(int i10) {
            return g.m0(i10, DurationUnit.DAYS);
        }

        @kotlin.k(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long c0(long j10) {
            return g.n0(j10, DurationUnit.MICROSECONDS);
        }

        @kotlin.k(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long d(long j10) {
            return g.n0(j10, DurationUnit.DAYS);
        }

        @kotlin.k(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long d0(double d10) {
            return g.l0(d10, DurationUnit.MILLISECONDS);
        }

        public final long e(double d10) {
            return g.l0(d10, DurationUnit.DAYS);
        }

        @kotlin.k(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long e0(int i10) {
            return g.m0(i10, DurationUnit.MILLISECONDS);
        }

        public final long f(int i10) {
            return g.m0(i10, DurationUnit.DAYS);
        }

        @kotlin.k(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long f0(long j10) {
            return g.n0(j10, DurationUnit.MILLISECONDS);
        }

        public final long g(long j10) {
            return g.n0(j10, DurationUnit.DAYS);
        }

        @kotlin.k(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long g0(double d10) {
            return g.l0(d10, DurationUnit.MINUTES);
        }

        @kotlin.k(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long h0(int i10) {
            return g.m0(i10, DurationUnit.MINUTES);
        }

        @kotlin.k(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long i0(long j10) {
            return g.n0(j10, DurationUnit.MINUTES);
        }

        @kotlin.k(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long j0(double d10) {
            return g.l0(d10, DurationUnit.NANOSECONDS);
        }

        public final long k(double d10) {
            return g.l0(d10, DurationUnit.HOURS);
        }

        @kotlin.k(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long k0(int i10) {
            return g.m0(i10, DurationUnit.NANOSECONDS);
        }

        public final long l(int i10) {
            return g.m0(i10, DurationUnit.HOURS);
        }

        @kotlin.k(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long l0(long j10) {
            return g.n0(j10, DurationUnit.NANOSECONDS);
        }

        public final long m(long j10) {
            return g.n0(j10, DurationUnit.HOURS);
        }

        public final long m0(@yt.k String value) {
            f0.p(value, "value");
            try {
                return g.f0(value, false);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e10);
            }
        }

        public final long n0(@yt.k String value) {
            f0.p(value, "value");
            try {
                return g.f0(value, true);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e10);
            }
        }

        @yt.l
        public final e o0(@yt.k String value) {
            f0.p(value, "value");
            try {
                return e.h(g.f0(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @yt.l
        public final e p0(@yt.k String value) {
            f0.p(value, "value");
            try {
                return e.h(g.f0(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final long q() {
            return e.f52171d;
        }

        @kotlin.k(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long q0(double d10) {
            return g.l0(d10, DurationUnit.SECONDS);
        }

        public final long r(double d10) {
            return g.l0(d10, DurationUnit.MICROSECONDS);
        }

        @kotlin.k(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long r0(int i10) {
            return g.m0(i10, DurationUnit.SECONDS);
        }

        public final long s(int i10) {
            return g.m0(i10, DurationUnit.MICROSECONDS);
        }

        @kotlin.k(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @v0(version = "1.5")
        @kotlin.l(errorSince = "1.8", warningSince = "1.6")
        @k
        public final long s0(long j10) {
            return g.n0(j10, DurationUnit.SECONDS);
        }

        public final long t(long j10) {
            return g.n0(j10, DurationUnit.MICROSECONDS);
        }

        public final long x(double d10) {
            return g.l0(d10, DurationUnit.MILLISECONDS);
        }

        public final long y(int i10) {
            return g.m0(i10, DurationUnit.MILLISECONDS);
        }

        public final long z(long j10) {
            return g.n0(j10, DurationUnit.MILLISECONDS);
        }
    }

    public /* synthetic */ e(long j10) {
        this.f52173a = j10;
    }

    @kotlin.k(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @kotlin.t0(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void A() {
    }

    public static final double B(long j10) {
        return o0(j10, DurationUnit.MILLISECONDS);
    }

    @kotlin.k(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @kotlin.t0(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void D() {
    }

    public static final double E(long j10) {
        return o0(j10, DurationUnit.MINUTES);
    }

    @kotlin.k(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @kotlin.t0(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void F() {
    }

    public static final double G(long j10) {
        return o0(j10, DurationUnit.NANOSECONDS);
    }

    @kotlin.k(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @kotlin.t0(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void H() {
    }

    public static final double I(long j10) {
        return o0(j10, DurationUnit.SECONDS);
    }

    public static final long J(long j10) {
        return r0(j10, DurationUnit.DAYS);
    }

    public static final long K(long j10) {
        return r0(j10, DurationUnit.HOURS);
    }

    public static final long L(long j10) {
        return r0(j10, DurationUnit.MICROSECONDS);
    }

    public static final long M(long j10) {
        return (b0(j10) && a0(j10)) ? Y(j10) : r0(j10, DurationUnit.MILLISECONDS);
    }

    public static final long N(long j10) {
        return r0(j10, DurationUnit.MINUTES);
    }

    public static final long O(long j10) {
        long jY = Y(j10);
        if (c0(j10)) {
            return jY;
        }
        if (jY > o1.f38919f) {
            return Long.MAX_VALUE;
        }
        if (jY < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return g.d0(jY);
    }

    public static final long P(long j10) {
        return r0(j10, DurationUnit.SECONDS);
    }

    @s0
    public static /* synthetic */ void Q() {
    }

    public static final int R(long j10) {
        if (d0(j10)) {
            return 0;
        }
        return (int) (N(j10) % ((long) 60));
    }

    @s0
    public static /* synthetic */ void S() {
    }

    public static final int T(long j10) {
        if (d0(j10)) {
            return 0;
        }
        return (int) (b0(j10) ? g.d0(Y(j10) % ((long) 1000)) : Y(j10) % ((long) 1000000000));
    }

    @s0
    public static /* synthetic */ void U() {
    }

    public static final int V(long j10) {
        if (d0(j10)) {
            return 0;
        }
        return (int) (P(j10) % ((long) 60));
    }

    public static final DurationUnit W(long j10) {
        return c0(j10) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public static final int X(long j10) {
        return ((int) j10) & 1;
    }

    public static final long Y(long j10) {
        return j10 >> 1;
    }

    public static int Z(long j10) {
        return com.flydigi.data.bean.a.a(j10);
    }

    public static final boolean a0(long j10) {
        return !d0(j10);
    }

    public static final boolean b0(long j10) {
        return (((int) j10) & 1) == 1;
    }

    public static final boolean c0(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean d0(long j10) {
        return j10 == f52171d || j10 == f52172e;
    }

    public static final boolean e0(long j10) {
        return j10 < 0;
    }

    public static final long f(long j10, long j11, long j12) {
        long jE0 = g.e0(j12);
        long j13 = j11 + jE0;
        if (!new qk.p(-4611686018426L, g.f52179d).p(j13)) {
            return g.j(v.K(j13, -4611686018427387903L, 4611686018427387903L));
        }
        return g.l(g.d0(j13) + (j12 - g.d0(jE0)));
    }

    public static final boolean f0(long j10) {
        return j10 > 0;
    }

    public static final void g(long j10, StringBuilder sb2, int i10, int i11, int i12, String str, boolean z10) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append('.');
            String strU3 = StringsKt__StringsKt.U3(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = strU3.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strU3.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z10 || i15 >= 3) {
                sb2.append((CharSequence) strU3, 0, ((i15 + 2) / 3) * 3);
                f0.o(sb2, "this.append(value, startIndex, endIndex)");
            } else {
                sb2.append((CharSequence) strU3, 0, i15);
                f0.o(sb2, "this.append(value, startIndex, endIndex)");
            }
        }
        sb2.append(str);
    }

    public static final long g0(long j10, long j11) {
        return h0(j10, x0(j11));
    }

    public static final /* synthetic */ e h(long j10) {
        return new e(j10);
    }

    public static final long h0(long j10, long j11) {
        if (d0(j10)) {
            if (a0(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (d0(j11)) {
            return j11;
        }
        if ((((int) j10) & 1) != (((int) j11) & 1)) {
            return b0(j10) ? f(j10, Y(j10), Y(j11)) : f(j10, Y(j11), Y(j10));
        }
        long jY = Y(j10) + Y(j11);
        return c0(j10) ? g.m(jY) : g.k(jY);
    }

    public static final long i0(long j10, double d10) {
        int iK0 = nk.d.K0(d10);
        if (((double) iK0) == d10) {
            return j0(j10, iK0);
        }
        DurationUnit durationUnitW = W(j10);
        return g.l0(o0(j10, durationUnitW) * d10, durationUnitW);
    }

    public static int j(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return f0.u(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return e0(j10) ? -i10 : i10;
    }

    public static final long j0(long j10, int i10) {
        if (d0(j10)) {
            if (i10 != 0) {
                return i10 > 0 ? j10 : x0(j10);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i10 == 0) {
            return f52170c;
        }
        long jY = Y(j10);
        long j11 = i10;
        long j12 = jY * j11;
        if (!c0(j10)) {
            return j12 / j11 == jY ? g.j(v.L(j12, new qk.p(-4611686018427387903L, 4611686018427387903L))) : nk.d.V(jY) * nk.d.U(i10) > 0 ? f52171d : f52172e;
        }
        if (new qk.p(-2147483647L, 2147483647L).p(jY)) {
            return g.l(j12);
        }
        if (j12 / j11 == jY) {
            return g.m(j12);
        }
        long jE0 = g.e0(jY);
        long j13 = jE0 * j11;
        long jE02 = g.e0((jY - g.d0(jE0)) * j11) + j13;
        return (j13 / j11 != jE0 || (jE02 ^ j13) < 0) ? nk.d.V(jY) * nk.d.U(i10) > 0 ? f52171d : f52172e : g.j(v.L(jE02, new qk.p(-4611686018427387903L, 4611686018427387903L)));
    }

    public static long k(long j10) {
        if (f.d()) {
            if (c0(j10)) {
                if (!new qk.p(-4611686018426999999L, g.f52177b).p(Y(j10))) {
                    throw new AssertionError(Y(j10) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new qk.p(-4611686018427387903L, 4611686018427387903L).p(Y(j10))) {
                    throw new AssertionError(Y(j10) + " ms is out of milliseconds range");
                }
                if (new qk.p(-4611686018426L, g.f52179d).p(Y(j10))) {
                    throw new AssertionError(Y(j10) + " ms is denormalized");
                }
            }
        }
        return j10;
    }

    public static final <T> T k0(long j10, @yt.k ik.p<? super Long, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.r0(Long.valueOf(P(j10)), Integer.valueOf(T(j10)));
    }

    public static final double l(long j10, long j11) {
        DurationUnit durationUnit = (DurationUnit) uj.h.X(W(j10), W(j11));
        return o0(j10, durationUnit) / o0(j11, durationUnit);
    }

    public static final <T> T l0(long j10, @yt.k ik.q<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.A(Long.valueOf(N(j10)), Integer.valueOf(V(j10)), Integer.valueOf(T(j10)));
    }

    public static final long m(long j10, double d10) {
        int iK0 = nk.d.K0(d10);
        if ((((double) iK0) == d10) && iK0 != 0) {
            return n(j10, iK0);
        }
        DurationUnit durationUnitW = W(j10);
        return g.l0(o0(j10, durationUnitW) / d10, durationUnitW);
    }

    public static final <T> T m0(long j10, @yt.k ik.r<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.N(Long.valueOf(K(j10)), Integer.valueOf(R(j10)), Integer.valueOf(V(j10)), Integer.valueOf(T(j10)));
    }

    public static final long n(long j10, int i10) {
        if (i10 == 0) {
            if (f0(j10)) {
                return f52171d;
            }
            if (e0(j10)) {
                return f52172e;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (c0(j10)) {
            return g.l(Y(j10) / ((long) i10));
        }
        if (d0(j10)) {
            return j0(j10, nk.d.U(i10));
        }
        long j11 = i10;
        long jY = Y(j10) / j11;
        if (!new qk.p(-4611686018426L, g.f52179d).p(jY)) {
            return g.j(jY);
        }
        return g.l(g.d0(jY) + (g.d0(Y(j10) - (jY * j11)) / j11));
    }

    public static final <T> T n0(long j10, @yt.k ik.s<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        f0.p(action, "action");
        return action.w0(Long.valueOf(J(j10)), Integer.valueOf(s(j10)), Integer.valueOf(R(j10)), Integer.valueOf(V(j10)), Integer.valueOf(T(j10)));
    }

    public static boolean o(long j10, Object obj) {
        return (obj instanceof e) && j10 == ((e) obj).y0();
    }

    public static final double o0(long j10, @yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        if (j10 == f52171d) {
            return Double.POSITIVE_INFINITY;
        }
        if (j10 == f52172e) {
            return Double.NEGATIVE_INFINITY;
        }
        return i.a(Y(j10), W(j10), unit);
    }

    public static final boolean p(long j10, long j11) {
        return j10 == j11;
    }

    public static final int p0(long j10, @yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        return (int) v.K(r0(j10, unit), -2147483648L, 2147483647L);
    }

    public static final long q(long j10) {
        return e0(j10) ? x0(j10) : j10;
    }

    @yt.k
    public static final String q0(long j10) {
        StringBuilder sb2 = new StringBuilder();
        if (e0(j10)) {
            sb2.append('-');
        }
        sb2.append("PT");
        long jQ = q(j10);
        long jK = K(jQ);
        int iR = R(jQ);
        int iV = V(jQ);
        int iT = T(jQ);
        if (d0(j10)) {
            jK = 9999999999999L;
        }
        boolean z10 = true;
        boolean z11 = jK != 0;
        boolean z12 = (iV == 0 && iT == 0) ? false : true;
        if (iR == 0 && (!z12 || !z11)) {
            z10 = false;
        }
        if (z11) {
            sb2.append(jK);
            sb2.append('H');
        }
        if (z10) {
            sb2.append(iR);
            sb2.append('M');
        }
        if (z12 || (!z11 && !z10)) {
            g(j10, sb2, iV, iT, 9, i1.a.R4, true);
        }
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @s0
    public static /* synthetic */ void r() {
    }

    public static final long r0(long j10, @yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        if (j10 == f52171d) {
            return Long.MAX_VALUE;
        }
        if (j10 == f52172e) {
            return Long.MIN_VALUE;
        }
        return i.b(Y(j10), W(j10), unit);
    }

    public static final int s(long j10) {
        if (d0(j10)) {
            return 0;
        }
        return (int) (K(j10) % ((long) 24));
    }

    @kotlin.k(message = "Use inWholeMilliseconds property instead.", replaceWith = @kotlin.t0(expression = "this.inWholeMilliseconds", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static final long s0(long j10) {
        return M(j10);
    }

    @kotlin.k(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @kotlin.t0(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void t() {
    }

    @kotlin.k(message = "Use inWholeNanoseconds property instead.", replaceWith = @kotlin.t0(expression = "this.inWholeNanoseconds", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static final long t0(long j10) {
        return O(j10);
    }

    public static final double u(long j10) {
        return o0(j10, DurationUnit.DAYS);
    }

    @yt.k
    public static String u0(long j10) {
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f52171d) {
            return "Infinity";
        }
        if (j10 == f52172e) {
            return "-Infinity";
        }
        boolean zE0 = e0(j10);
        StringBuilder sb2 = new StringBuilder();
        if (zE0) {
            sb2.append('-');
        }
        long jQ = q(j10);
        long J = J(jQ);
        int iS = s(jQ);
        int iR = R(jQ);
        int iV = V(jQ);
        int iT = T(jQ);
        int i10 = 0;
        boolean z10 = J != 0;
        boolean z11 = iS != 0;
        boolean z12 = iR != 0;
        boolean z13 = (iV == 0 && iT == 0) ? false : true;
        if (z10) {
            sb2.append(J);
            sb2.append('d');
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(zc.f.f58383m);
            }
            sb2.append(iS);
            sb2.append('h');
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(zc.f.f58383m);
            }
            sb2.append(iR);
            sb2.append('m');
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(zc.f.f58383m);
            }
            if (iV != 0 || z10 || z11 || z12) {
                g(j10, sb2, iV, iT, 9, an.aB, false);
            } else if (iT >= 1000000) {
                g(j10, sb2, iT / 1000000, iT % 1000000, 6, "ms", false);
            } else if (iT >= 1000) {
                g(j10, sb2, iT / 1000, iT % 1000, 3, "us", false);
            } else {
                sb2.append(iT);
                sb2.append("ns");
            }
            i10 = i13;
        }
        if (zE0 && i10 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @kotlin.k(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @kotlin.t0(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void v() {
    }

    @yt.k
    public static final String v0(long j10, @yt.k DurationUnit unit, int i10) {
        f0.p(unit, "unit");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i10).toString());
        }
        double dO0 = o0(j10, unit);
        if (Double.isInfinite(dO0)) {
            return String.valueOf(dO0);
        }
        return f.b(dO0, v.B(i10, 12)) + j.h(unit);
    }

    public static final double w(long j10) {
        return o0(j10, DurationUnit.HOURS);
    }

    public static /* synthetic */ String w0(long j10, DurationUnit durationUnit, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return v0(j10, durationUnit, i10);
    }

    @kotlin.k(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @kotlin.t0(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void x() {
    }

    public static final long x0(long j10) {
        return g.i(-Y(j10), ((int) j10) & 1);
    }

    public static final double y(long j10) {
        return o0(j10, DurationUnit.MICROSECONDS);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(e eVar) {
        return i(eVar.y0());
    }

    public boolean equals(Object obj) {
        return o(this.f52173a, obj);
    }

    public int hashCode() {
        return Z(this.f52173a);
    }

    public int i(long j10) {
        return j(this.f52173a, j10);
    }

    @yt.k
    public String toString() {
        return u0(this.f52173a);
    }

    public final /* synthetic */ long y0() {
        return this.f52173a;
    }
}
