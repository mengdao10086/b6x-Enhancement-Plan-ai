package o5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final g f42743a = new g();

    @hk.m
    public static final int a(int i10, int i11) {
        boolean z10 = (i10 < 0 || i11 <= 0) && (i10 > 0 || i11 >= 0);
        long jAbs = Math.abs(i10);
        long jAbs2 = Math.abs(i11);
        long j10 = 0;
        long j11 = 1;
        int i12 = (int) jAbs2;
        if (jAbs < jAbs2) {
            return 0;
        }
        while (true) {
            long j12 = jAbs2 << 1;
            if (j12 >= jAbs) {
                break;
            }
            j11 <<= 1;
            jAbs2 = j12;
        }
        while (jAbs >= i12) {
            jAbs -= jAbs2;
            j10 += j11;
            while (jAbs2 > jAbs) {
                jAbs2 >>= 1;
                j11 >>= 1;
            }
        }
        if (!z10) {
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j10;
        }
        long j13 = -j10;
        if (j13 < 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j13;
    }

    @hk.m
    @yt.k
    public static final BigDecimal b(double d10, double d11) {
        BigDecimal bigDecimalDivide = BigDecimal.valueOf(d10).divide(BigDecimal.valueOf(d11));
        f0.o(bigDecimalDivide, "valueOf(val1).divide(BigDecimal.valueOf(val2))");
        return bigDecimalDivide;
    }

    @hk.m
    @yt.k
    public static final BigDecimal c(long j10, long j11) {
        BigDecimal bigDecimalDivide = BigDecimal.valueOf(j10).divide(BigDecimal.valueOf(j11));
        f0.o(bigDecimalDivide, "valueOf(val1).divide(BigDecimal.valueOf(val2))");
        return bigDecimalDivide;
    }

    @hk.m
    @yt.k
    public static final BigDecimal d(double d10, double d11) {
        BigDecimal bigDecimalMultiply = BigDecimal.valueOf(d10).multiply(BigDecimal.valueOf(d11));
        f0.o(bigDecimalMultiply, "valueOf(val1).multiply(BigDecimal.valueOf(val2))");
        return bigDecimalMultiply;
    }

    @hk.m
    @yt.k
    public static final BigDecimal e(long j10, long j11) {
        BigDecimal bigDecimalMultiply = BigDecimal.valueOf(j10).multiply(BigDecimal.valueOf(j11));
        f0.o(bigDecimalMultiply, "valueOf(val1).multiply(BigDecimal.valueOf(val2))");
        return bigDecimalMultiply;
    }

    @hk.m
    public static final int f(long j10, long j11) {
        return BigDecimal.valueOf(j10).multiply(BigDecimal.valueOf(100L)).divide(BigDecimal.valueOf(j11), RoundingMode.CEILING).intValue();
    }

    @hk.m
    public static final int g(long j10, long j11) {
        return BigDecimal.valueOf(j10).multiply(BigDecimal.valueOf(j11)).divide(BigDecimal.valueOf(100L)).intValue();
    }
}
