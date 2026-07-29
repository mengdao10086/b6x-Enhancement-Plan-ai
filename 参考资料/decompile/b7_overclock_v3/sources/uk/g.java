package uk;

import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.time.DurationUnit;
import kotlin.v0;
import qk.v;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1484:1\n1436#1,6:1486\n1439#1,3:1492\n1436#1,6:1495\n1436#1,6:1501\n1439#1,3:1510\n1#2:1485\n1726#3,3:1507\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1360#1:1486,6\n1394#1:1492,3\n1397#1:1495,6\n1400#1:1501,6\n1436#1:1510,3\n1425#1:1507,3\n*E\n"})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f52176a = 1000000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f52177b = 4611686018426999999L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f52178c = 4611686018427387903L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f52179d = 4611686018426L;

    public static final long A(int i10) {
        return m0(i10, DurationUnit.MICROSECONDS);
    }

    public static final long B(long j10) {
        return n0(j10, DurationUnit.MICROSECONDS);
    }

    @kotlin.k(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void C(double d10) {
    }

    @kotlin.k(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void D(int i10) {
    }

    @kotlin.k(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void E(long j10) {
    }

    public static final long F(double d10) {
        return l0(d10, DurationUnit.MILLISECONDS);
    }

    public static final long G(int i10) {
        return m0(i10, DurationUnit.MILLISECONDS);
    }

    public static final long H(long j10) {
        return n0(j10, DurationUnit.MILLISECONDS);
    }

    @kotlin.k(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void I(double d10) {
    }

    @kotlin.k(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void J(int i10) {
    }

    @kotlin.k(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void K(long j10) {
    }

    public static final long L(double d10) {
        return l0(d10, DurationUnit.MINUTES);
    }

    public static final long M(int i10) {
        return m0(i10, DurationUnit.MINUTES);
    }

    public static final long N(long j10) {
        return n0(j10, DurationUnit.MINUTES);
    }

    @kotlin.k(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void O(double d10) {
    }

    @kotlin.k(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void P(int i10) {
    }

    @kotlin.k(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void Q(long j10) {
    }

    public static final long R(double d10) {
        return l0(d10, DurationUnit.NANOSECONDS);
    }

    public static final long S(int i10) {
        return m0(i10, DurationUnit.NANOSECONDS);
    }

    public static final long T(long j10) {
        return n0(j10, DurationUnit.NANOSECONDS);
    }

    @kotlin.k(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void U(double d10) {
    }

    @kotlin.k(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void V(int i10) {
    }

    @kotlin.k(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void W(long j10) {
    }

    public static final long X(double d10) {
        return l0(d10, DurationUnit.SECONDS);
    }

    public static final long Y(int i10) {
        return m0(i10, DurationUnit.SECONDS);
    }

    public static final long Z(long j10) {
        return n0(j10, DurationUnit.SECONDS);
    }

    @kotlin.k(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void a0(double d10) {
    }

    @kotlin.k(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void b0(int i10) {
    }

    @kotlin.k(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void c0(long j10) {
    }

    public static final long d0(long j10) {
        return j10 * ((long) 1000000);
    }

    public static final long e0(long j10) {
        return j10 / ((long) 1000000);
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x00a6 A[EDGE_INSN: B:170:0x00a6->B:49:0x00a6 BREAK  A[LOOP:1: B:36:0x006c->B:47:0x0098], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098 A[LOOP:1: B:36:0x006c->B:47:0x0098, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long f0(java.lang.String r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.g.f0(java.lang.String, boolean):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long g0(java.lang.String r9) {
        /*
            int r0 = r9.length()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L18
            char r5 = r9.charAt(r4)
            java.lang.String r6 = "+-"
            boolean r5 = kotlin.text.StringsKt__StringsKt.V2(r6, r5, r4, r2, r1)
            if (r5 == 0) goto L18
            r5 = 1
            goto L19
        L18:
            r5 = 0
        L19:
            int r0 = r0 - r5
            r6 = 16
            if (r0 <= r6) goto L6e
            qk.m r0 = new qk.m
            int r6 = kotlin.text.StringsKt__StringsKt.j3(r9)
            r0.<init>(r5, r6)
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L36
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L36
        L34:
            r0 = 1
            goto L5b
        L36:
            java.util.Iterator r0 = r0.iterator()
        L3a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L34
            r5 = r0
            kotlin.collections.k0 r5 = (kotlin.collections.k0) r5
            int r5 = r5.b()
            qk.c r6 = new qk.c
            r7 = 48
            r8 = 57
            r6.<init>(r7, r8)
            char r5 = r9.charAt(r5)
            boolean r5 = r6.p(r5)
            if (r5 != 0) goto L3a
            r0 = 0
        L5b:
            if (r0 == 0) goto L6e
            char r9 = r9.charAt(r4)
            r0 = 45
            if (r9 != r0) goto L68
            r0 = -9223372036854775808
            goto L6d
        L68:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L6d:
            return r0
        L6e:
            java.lang.String r0 = "+"
            boolean r0 = kotlin.text.u.v2(r9, r0, r4, r2, r1)
            if (r0 == 0) goto L7a
            java.lang.String r9 = kotlin.text.StringsKt___StringsKt.B6(r9, r3)
        L7a:
            long r0 = java.lang.Long.parseLong(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.g.g0(java.lang.String):long");
    }

    public static final int h0(String str, int i10, ik.l<? super Character, Boolean> lVar) {
        while (i10 < str.length() && lVar.i(Character.valueOf(str.charAt(i10))).booleanValue()) {
            i10++;
        }
        return i10;
    }

    public static final long i(long j10, int i10) {
        return e.k((j10 << 1) + ((long) i10));
    }

    public static final String i0(String str, int i10, ik.l<? super Character, Boolean> lVar) {
        int i11 = i10;
        while (i11 < str.length() && lVar.i(Character.valueOf(str.charAt(i11))).booleanValue()) {
            i11++;
        }
        f0.n(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, i11);
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final long j(long j10) {
        return e.k((j10 << 1) + 1);
    }

    @c2(markerClass = {k.class})
    @bk.f
    @v0(version = "1.6")
    public static final long j0(double d10, long j10) {
        return e.i0(j10, d10);
    }

    public static final long k(long j10) {
        return new qk.p(-4611686018426L, f52179d).p(j10) ? l(d0(j10)) : j(v.K(j10, -4611686018427387903L, 4611686018427387903L));
    }

    @c2(markerClass = {k.class})
    @bk.f
    @v0(version = "1.6")
    public static final long k0(int i10, long j10) {
        return e.j0(j10, i10);
    }

    public static final long l(long j10) {
        return e.k(j10 << 1);
    }

    @c2(markerClass = {k.class})
    @v0(version = "1.6")
    public static final long l0(double d10, @yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        double dA = i.a(d10, unit, DurationUnit.NANOSECONDS);
        if (!(!Double.isNaN(dA))) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long jM0 = nk.d.M0(dA);
        return new qk.p(-4611686018426999999L, f52177b).p(jM0) ? l(jM0) : k(nk.d.M0(i.a(d10, unit, DurationUnit.MILLISECONDS)));
    }

    public static final long m(long j10) {
        return new qk.p(-4611686018426999999L, f52177b).p(j10) ? l(j10) : j(e0(j10));
    }

    @c2(markerClass = {k.class})
    @v0(version = "1.6")
    public static final long m0(int i10, @yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        return unit.compareTo(DurationUnit.SECONDS) <= 0 ? l(i.c(i10, unit, DurationUnit.NANOSECONDS)) : n0(i10, unit);
    }

    public static final long n(double d10) {
        return l0(d10, DurationUnit.DAYS);
    }

    @c2(markerClass = {k.class})
    @v0(version = "1.6")
    public static final long n0(long j10, @yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long jC = i.c(f52177b, durationUnit, unit);
        return new qk.p(-jC, jC).p(j10) ? l(i.c(j10, unit, durationUnit)) : j(v.K(i.b(j10, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    public static final long o(int i10) {
        return m0(i10, DurationUnit.DAYS);
    }

    public static final long p(long j10) {
        return n0(j10, DurationUnit.DAYS);
    }

    @kotlin.k(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void q(double d10) {
    }

    @kotlin.k(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void r(int i10) {
    }

    @kotlin.k(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void s(long j10) {
    }

    public static final long t(double d10) {
        return l0(d10, DurationUnit.HOURS);
    }

    public static final long u(int i10) {
        return m0(i10, DurationUnit.HOURS);
    }

    public static final long v(long j10) {
        return n0(j10, DurationUnit.HOURS);
    }

    @kotlin.k(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void w(double d10) {
    }

    @kotlin.k(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void x(int i10) {
    }

    @kotlin.k(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.t0(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @v0(version = "1.3")
    @kotlin.l(errorSince = "1.8", warningSince = "1.5")
    @k
    public static /* synthetic */ void y(long j10) {
    }

    public static final long z(double d10) {
        return l0(d10, DurationUnit.MICROSECONDS);
    }
}
