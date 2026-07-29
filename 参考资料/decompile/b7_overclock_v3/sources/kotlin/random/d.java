package kotlin.random;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;
import qk.m;
import qk.p;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
public final class d {
    @v0(version = "1.3")
    @k
    public static final Random a(int i10) {
        return new XorWowRandom(i10, i10 >> 31);
    }

    @v0(version = "1.3")
    @k
    public static final Random b(long j10) {
        return new XorWowRandom((int) j10, (int) (j10 >> 32));
    }

    @k
    public static final String c(@k Object from, @k Object until) {
        f0.p(from, "from");
        f0.p(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void d(double d10, double d11) {
        if (!(d11 > d10)) {
            throw new IllegalArgumentException(c(Double.valueOf(d10), Double.valueOf(d11)).toString());
        }
    }

    public static final void e(int i10, int i11) {
        if (!(i11 > i10)) {
            throw new IllegalArgumentException(c(Integer.valueOf(i10), Integer.valueOf(i11)).toString());
        }
    }

    public static final void f(long j10, long j11) {
        if (!(j11 > j10)) {
            throw new IllegalArgumentException(c(Long.valueOf(j10), Long.valueOf(j11)).toString());
        }
    }

    public static final int g(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    @v0(version = "1.3")
    public static final int h(@k Random random, @k m range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (!range.isEmpty()) {
            return range.j() < Integer.MAX_VALUE ? random.q(range.g(), range.j() + 1) : range.g() > Integer.MIN_VALUE ? random.q(range.g() - 1, range.j()) + 1 : random.o();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @v0(version = "1.3")
    public static final long i(@k Random random, @k p range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (!range.isEmpty()) {
            return range.j() < Long.MAX_VALUE ? random.u(range.g(), range.j() + 1) : range.g() > Long.MIN_VALUE ? random.u(range.g() - 1, range.j()) + 1 : random.r();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int j(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
