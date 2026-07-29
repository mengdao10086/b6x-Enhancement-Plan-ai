package uk;

import kotlin.jvm.internal.t0;
import kotlin.time.DurationUnit;
import uk.e;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,75:1\n74#1:76\n74#1:77\n74#1:78\n74#1:79\n74#1:80\n74#1:81\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n15#1:76\n18#1:77\n36#1:78\n45#1:79\n52#1:80\n56#1:81\n*E\n"})
public final class l {
    public static final long a(long j10, long j11, long j12) {
        if (!e.d0(j11) || (j10 ^ j12) >= 0) {
            return j10;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    public static final boolean b(long j10) {
        return ((j10 - 1) | 1) == Long.MAX_VALUE;
    }

    public static final long c(long j10, long j11) {
        long jO = e.O(j11);
        if (((j10 - 1) | 1) == Long.MAX_VALUE) {
            return a(j10, j11, jO);
        }
        if ((1 | (jO - 1)) == Long.MAX_VALUE) {
            return d(j10, j11);
        }
        long j12 = j10 + jO;
        return ((j10 ^ j12) & (jO ^ j12)) < 0 ? j10 < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j12;
    }

    public static final long d(long j10, long j11) {
        long jN = e.n(j11, 2);
        return (((e.O(jN) - 1) | 1) > Long.MAX_VALUE ? 1 : (((e.O(jN) - 1) | 1) == Long.MAX_VALUE ? 0 : -1)) == 0 ? (long) (j10 + e.o0(j11, DurationUnit.NANOSECONDS)) : c(c(j10, jN), e.g0(j11, jN));
    }

    public static final long e(long j10, long j11) {
        return ((1 | (j11 - 1)) > Long.MAX_VALUE ? 1 : ((1 | (j11 - 1)) == Long.MAX_VALUE ? 0 : -1)) == 0 ? e.x0(g.n0(j11, DurationUnit.DAYS)) : f(j10, j11);
    }

    public static final long f(long j10, long j11) {
        long j12 = j10 - j11;
        if (((j12 ^ j10) & (~(j12 ^ j11))) >= 0) {
            e.a aVar = e.f52169b;
            return g.n0(j12, DurationUnit.NANOSECONDS);
        }
        long j13 = 1000000;
        long j14 = (j10 / j13) - (j11 / j13);
        long j15 = (j10 % j13) - (j11 % j13);
        e.a aVar2 = e.f52169b;
        return e.h0(g.n0(j14, DurationUnit.MILLISECONDS), g.n0(j15, DurationUnit.NANOSECONDS));
    }

    public static final long g(long j10, long j11) {
        if (((j11 - 1) | 1) == Long.MAX_VALUE) {
            return j10 == j11 ? e.f52169b.W() : e.x0(g.n0(j11, DurationUnit.DAYS));
        }
        return (1 | (j10 - 1)) == Long.MAX_VALUE ? g.n0(j10, DurationUnit.DAYS) : f(j10, j11);
    }
}
