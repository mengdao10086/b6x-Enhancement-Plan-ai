package uk;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f52174a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ThreadLocal<DecimalFormat>[] f52175b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal<>();
        }
        f52175b = threadLocalArr;
    }

    public static final DecimalFormat a(int i10) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i10 > 0) {
            decimalFormat.setMinimumFractionDigits(i10);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @yt.k
    public static final String b(double d10, int i10) {
        DecimalFormat decimalFormatA;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f52175b;
        if (i10 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i10];
            DecimalFormat decimalFormatA2 = threadLocal.get();
            if (decimalFormatA2 == null) {
                decimalFormatA2 = a(i10);
                threadLocal.set(decimalFormatA2);
            } else {
                f0.o(decimalFormatA2, "get() ?: default().also(this::set)");
            }
            decimalFormatA = decimalFormatA2;
        } else {
            decimalFormatA = a(i10);
        }
        String str = decimalFormatA.format(d10);
        f0.o(str, "format.format(value)");
        return str;
    }

    @yt.k
    public static final String c(double d10, int i10) {
        DecimalFormat decimalFormatA = a(0);
        decimalFormatA.setMaximumFractionDigits(i10);
        String str = decimalFormatA.format(d10);
        f0.o(str, "createFormatForDecimals(… }\n        .format(value)");
        return str;
    }

    public static final boolean d() {
        return f52174a;
    }
}
