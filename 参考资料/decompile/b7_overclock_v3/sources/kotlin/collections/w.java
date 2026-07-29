package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;

/* JADX INFO: loaded from: classes5.dex */
public class w extends v {
    @bk.f
    @kotlin.v0(version = "1.2")
    public static final <T> void g0(List<T> list, T t10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        Collections.fill(list, t10);
    }

    @bk.f
    @kotlin.v0(version = "1.2")
    public static final <T> void h0(List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        Collections.shuffle(list);
    }

    @bk.f
    @kotlin.v0(version = "1.2")
    public static final <T> void i0(List<T> list, Random random) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        Collections.shuffle(list, random);
    }

    public static final <T extends Comparable<? super T>> void j0(@yt.k List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @kotlin.t0(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    public static final <T> void k0(List<T> list, ik.p<? super T, ? super T, Integer> comparison) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparison, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @kotlin.t0(expression = "this.sortWith(comparator)", imports = {}))
    public static final <T> void l0(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    public static final <T> void m0(@yt.k List<T> list, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
