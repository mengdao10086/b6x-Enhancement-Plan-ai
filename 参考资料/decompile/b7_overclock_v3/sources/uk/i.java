package uk;

import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.time.DurationUnit;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52180a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f52180a = iArr;
        }
    }

    @v0(version = "1.3")
    public static final double a(double d10, @yt.k DurationUnit sourceUnit, @yt.k DurationUnit targetUnit) {
        f0.p(sourceUnit, "sourceUnit");
        f0.p(targetUnit, "targetUnit");
        long jConvert = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        return jConvert > 0 ? d10 * jConvert : d10 / sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
    }

    @v0(version = "1.5")
    public static final long b(long j10, @yt.k DurationUnit sourceUnit, @yt.k DurationUnit targetUnit) {
        f0.p(sourceUnit, "sourceUnit");
        f0.p(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j10, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @v0(version = "1.5")
    public static final long c(long j10, @yt.k DurationUnit sourceUnit, @yt.k DurationUnit targetUnit) {
        f0.p(sourceUnit, "sourceUnit");
        f0.p(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j10, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @c2(markerClass = {k.class})
    @v0(version = "1.8")
    @yt.k
    public static final DurationUnit d(@yt.k TimeUnit timeUnit) {
        f0.p(timeUnit, "<this>");
        switch (a.f52180a[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @c2(markerClass = {k.class})
    @v0(version = "1.8")
    @yt.k
    public static final TimeUnit e(@yt.k DurationUnit durationUnit) {
        f0.p(durationUnit, "<this>");
        return durationUnit.getTimeUnit$kotlin_stdlib();
    }
}
