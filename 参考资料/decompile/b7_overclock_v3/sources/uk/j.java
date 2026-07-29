package uk;

import com.umeng.analytics.pro.an;
import kotlin.jvm.internal.f0;
import kotlin.time.DurationUnit;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public class j extends i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52181a;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f52181a = iArr;
        }
    }

    @v0(version = "1.5")
    @yt.k
    public static final DurationUnit f(char c10, boolean z10) {
        if (!z10) {
            if (c10 == 'D') {
                return DurationUnit.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c10);
        }
        if (c10 == 'H') {
            return DurationUnit.HOURS;
        }
        if (c10 == 'M') {
            return DurationUnit.MINUTES;
        }
        if (c10 == 'S') {
            return DurationUnit.SECONDS;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c10);
    }

    @v0(version = "1.5")
    @yt.k
    public static final DurationUnit g(@yt.k String shortName) {
        f0.p(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return DurationUnit.MICROSECONDS;
                                }
                            } else if (shortName.equals("ns")) {
                                return DurationUnit.NANOSECONDS;
                            }
                        } else if (shortName.equals("ms")) {
                            return DurationUnit.MILLISECONDS;
                        }
                    } else if (shortName.equals(an.aB)) {
                        return DurationUnit.SECONDS;
                    }
                } else if (shortName.equals(m0.k.f40564b)) {
                    return DurationUnit.MINUTES;
                }
            } else if (shortName.equals("h")) {
                return DurationUnit.HOURS;
            }
        } else if (shortName.equals("d")) {
            return DurationUnit.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }

    @v0(version = "1.3")
    @yt.k
    public static final String h(@yt.k DurationUnit durationUnit) {
        f0.p(durationUnit, "<this>");
        switch (a.f52181a[durationUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return an.aB;
            case 5:
                return m0.k.f40564b;
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }
}
