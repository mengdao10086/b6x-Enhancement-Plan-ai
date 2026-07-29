package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "UnsignedKt")
public final class b2 {
    @s0
    public static final int a(double d10) {
        if (Double.isNaN(d10) || d10 <= f(0)) {
            return 0;
        }
        if (d10 >= f(-1)) {
            return -1;
        }
        return d10 <= 2.147483647E9d ? l1.j((int) d10) : l1.j(l1.j((int) (d10 - ((double) Integer.MAX_VALUE))) + l1.j(Integer.MAX_VALUE));
    }

    @s0
    public static final long b(double d10) {
        if (Double.isNaN(d10) || d10 <= j(0L)) {
            return 0L;
        }
        if (d10 >= j(-1L)) {
            return -1L;
        }
        return d10 < 9.223372036854776E18d ? p1.j((long) d10) : p1.j(p1.j((long) (d10 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @s0
    public static final int c(int i10, int i11) {
        return kotlin.jvm.internal.f0.t(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    @s0
    public static final int d(int i10, int i11) {
        return l1.j((int) ((((long) i10) & 4294967295L) / (((long) i11) & 4294967295L)));
    }

    @s0
    public static final int e(int i10, int i11) {
        return l1.j((int) ((((long) i10) & 4294967295L) % (((long) i11) & 4294967295L)));
    }

    @s0
    public static final double f(int i10) {
        return ((double) (Integer.MAX_VALUE & i10)) + (((double) ((i10 >>> 31) << 30)) * ((double) 2));
    }

    @s0
    public static final int g(long j10, long j11) {
        return kotlin.jvm.internal.f0.u(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    @s0
    public static final long h(long j10, long j11) {
        if (j11 < 0) {
            return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) < 0 ? p1.j(0L) : p1.j(1L);
        }
        if (j10 >= 0) {
            return p1.j(j10 / j11);
        }
        long j12 = ((j10 >>> 1) / j11) << 1;
        return p1.j(j12 + ((long) (Long.compare(p1.j(j10 - (j12 * j11)) ^ Long.MIN_VALUE, p1.j(j11) ^ Long.MIN_VALUE) < 0 ? 0 : 1)));
    }

    @s0
    public static final long i(long j10, long j11) {
        if (j11 < 0) {
            return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) < 0 ? j10 : p1.j(j10 - j11);
        }
        if (j10 >= 0) {
            return p1.j(j10 % j11);
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if (Long.compare(p1.j(j12) ^ Long.MIN_VALUE, p1.j(j11) ^ Long.MIN_VALUE) < 0) {
            j11 = 0;
        }
        return p1.j(j12 - j11);
    }

    @s0
    public static final double j(long j10) {
        return ((j10 >>> 11) * ((double) 2048)) + (j10 & 2047);
    }

    @yt.k
    public static final String k(long j10) {
        return l(j10, 10);
    }

    @yt.k
    public static final String l(long j10, int i10) {
        if (j10 >= 0) {
            String string = Long.toString(j10, kotlin.text.b.a(i10));
            kotlin.jvm.internal.f0.o(string, "toString(this, checkRadix(radix))");
            return string;
        }
        long j11 = i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb2 = new StringBuilder();
        String string2 = Long.toString(j12, kotlin.text.b.a(i10));
        kotlin.jvm.internal.f0.o(string2, "toString(this, checkRadix(radix))");
        sb2.append(string2);
        String string3 = Long.toString(j13, kotlin.text.b.a(i10));
        kotlin.jvm.internal.f0.o(string3, "toString(this, checkRadix(radix))");
        sb2.append(string3);
        return sb2.toString();
    }
}
