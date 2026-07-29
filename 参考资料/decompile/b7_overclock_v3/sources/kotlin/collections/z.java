package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\n_CollectionsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1963#2,14:169\n2333#2,14:183\n*S KotlinDebug\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n*L\n89#1:169,14\n126#1:183,14\n*E\n"})
public class z extends y {
    @yt.k
    public static final <R> List<R> a1(@yt.k Iterable<?> iterable, @yt.k Class<R> klass) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(klass, "klass");
        return (List) b1(iterable, new ArrayList(), klass);
    }

    @yt.k
    public static final <C extends Collection<? super R>, R> C b1(@yt.k Iterable<?> iterable, @yt.k C destination, @yt.k Class<R> klass) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable c1(Iterable iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return CollectionsKt___CollectionsKt.K3(iterable);
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double d1(Iterable iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return CollectionsKt___CollectionsKt.L3(iterable);
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float e1(Iterable iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return CollectionsKt___CollectionsKt.M3(iterable);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T f1(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (it2.hasNext()) {
            R rI = selector.i(next);
            do {
                T next2 = it2.next();
                R rI2 = selector.i(next2);
                if (rI.compareTo(rI2) < 0) {
                    next = next2;
                    rI = rI2;
                }
            } while (it2.hasNext());
        }
        return (T) next;
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object g1(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return CollectionsKt___CollectionsKt.Q3(iterable, comparator);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable h1(Iterable iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return CollectionsKt___CollectionsKt.c4(iterable);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double i1(Iterable iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return CollectionsKt___CollectionsKt.d4(iterable);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float j1(Iterable iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return CollectionsKt___CollectionsKt.e4(iterable);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T k1(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (it2.hasNext()) {
            R rI = selector.i(next);
            do {
                T next2 = it2.next();
                R rI2 = selector.i(next2);
                if (rI.compareTo(rI2) > 0) {
                    next = next2;
                    rI = rI2;
                }
            } while (it2.hasNext());
        }
        return (T) next;
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object l1(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return CollectionsKt___CollectionsKt.i4(iterable, comparator);
    }

    public static final <T> void m1(@yt.k List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        Collections.reverse(list);
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> BigDecimal n1(Iterable<? extends T> iterable, ik.l<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(it2.next()));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> BigInteger o1(Iterable<? extends T> iterable, ik.l<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(it2.next()));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> SortedSet<T> p1(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return (SortedSet) CollectionsKt___CollectionsKt.L5(iterable, new TreeSet());
    }

    @yt.k
    public static final <T> SortedSet<T> q1(@yt.k Iterable<? extends T> iterable, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.L5(iterable, new TreeSet(comparator));
    }
}
