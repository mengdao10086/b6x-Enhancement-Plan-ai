package uj;

import java.util.Comparator;
import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public class i extends h {
    @v0(version = "1.4")
    public static final <T> T A0(T t10, @yt.k T[] other, @yt.k Comparator<? super T> comparator) {
        f0.p(other, "other");
        f0.p(comparator, "comparator");
        for (T t11 : other) {
            if (comparator.compare(t10, t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @v0(version = "1.1")
    public static final <T> T B0(T t10, T t11, T t12, @yt.k Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return (T) C0(t10, C0(t11, t12, comparator), comparator);
    }

    @v0(version = "1.1")
    public static final <T> T C0(T t10, T t11, @yt.k Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return comparator.compare(t10, t11) <= 0 ? t10 : t11;
    }

    @v0(version = "1.4")
    public static final <T> T D0(T t10, @yt.k T[] other, @yt.k Comparator<? super T> comparator) {
        f0.p(other, "other");
        f0.p(comparator, "comparator");
        for (T t11 : other) {
            if (comparator.compare(t10, t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @v0(version = "1.1")
    public static final <T> T y0(T t10, T t11, T t12, @yt.k Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return (T) z0(t10, z0(t11, t12, comparator), comparator);
    }

    @v0(version = "1.1")
    public static final <T> T z0(T t10, T t11, @yt.k Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return comparator.compare(t10, t11) >= 0 ? t10 : t11;
    }
}
