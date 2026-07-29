package kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.m0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\n_SequencesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,172:1\n1415#2,14:173\n1821#2,14:187\n*S KotlinDebug\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n*L\n89#1:173,14\n126#1:187,14\n*E\n"})
public class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object A(m mVar, Comparator comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        return SequencesKt___SequencesKt.I1(mVar, comparator);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable B(m mVar) {
        f0.p(mVar, "<this>");
        return SequencesKt___SequencesKt.U1(mVar);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double C(m mVar) {
        f0.p(mVar, "<this>");
        return SequencesKt___SequencesKt.V1(mVar);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float D(m mVar) {
        f0.p(mVar, "<this>");
        return SequencesKt___SequencesKt.W1(mVar);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T E(m<? extends T> mVar, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
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
    public static final /* synthetic */ Object F(m mVar, Comparator comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        return SequencesKt___SequencesKt.a2(mVar, comparator);
    }

    @hk.h(name = "sumOfBigDecimal")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> BigDecimal G(m<? extends T> mVar, ik.l<? super T, ? extends BigDecimal> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(it2.next()));
            f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "sumOfBigInteger")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> BigInteger H(m<? extends T> mVar, ik.l<? super T, ? extends BigInteger> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(it2.next()));
            f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> SortedSet<T> I(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return (SortedSet) SequencesKt___SequencesKt.a3(mVar, new TreeSet());
    }

    @yt.k
    public static final <T> SortedSet<T> J(@yt.k m<? extends T> mVar, @yt.k Comparator<? super T> comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.a3(mVar, new TreeSet(comparator));
    }

    @yt.k
    public static final <R> m<R> u(@yt.k m<?> mVar, @yt.k final Class<R> klass) {
        f0.p(mVar, "<this>");
        f0.p(klass, "klass");
        m<R> mVarP0 = SequencesKt___SequencesKt.p0(mVar, new ik.l<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesJvmKt$filterIsInstance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.l Object obj) {
                return Boolean.valueOf(klass.isInstance(obj));
            }
        });
        f0.n(mVarP0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return mVarP0;
    }

    @yt.k
    public static final <C extends Collection<? super R>, R> C v(@yt.k m<?> mVar, @yt.k C destination, @yt.k Class<R> klass) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(klass, "klass");
        for (Object obj : mVar) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable w(m mVar) {
        f0.p(mVar, "<this>");
        return SequencesKt___SequencesKt.C1(mVar);
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double x(m mVar) {
        f0.p(mVar, "<this>");
        return SequencesKt___SequencesKt.D1(mVar);
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float y(m mVar) {
        f0.p(mVar, "<this>");
        return SequencesKt___SequencesKt.E1(mVar);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T z(m<? extends T> mVar, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
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
}
