package kotlin.sequences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.c2;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.collections.d0;
import kotlin.collections.d1;
import kotlin.collections.h0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.l1;
import kotlin.m0;
import kotlin.p1;
import kotlin.v0;
import kotlin.z1;
import uj.g;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,3094:1\n179#1,2:3095\n316#1,7:3097\n1306#1,3:3105\n739#1,4:3108\n704#1,4:3112\n722#1,4:3116\n775#1,4:3120\n999#1,3:3124\n1002#1,3:3134\n1019#1,3:3137\n1022#1,3:3147\n1306#1,3:3164\n1295#1,2:3167\n1#2:3104\n361#3,7:3127\n361#3,7:3140\n361#3,7:3150\n361#3,7:3157\n*S KotlinDebug\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n87#1:3095,2\n99#1:3097,7\n458#1:3105,3\n658#1:3108,4\n674#1:3112,4\n689#1:3116,4\n760#1:3120,4\n970#1:3124,3\n970#1:3134,3\n985#1:3137,3\n985#1:3147,3\n1088#1:3164,3\n1126#1:3167,2\n970#1:3127,7\n985#1:3140,7\n1001#1:3150,7\n1021#1:3157,7\n*E\n"})
public class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,70:1\n2903#2:71\n*E\n"})
    public static final class a<T> implements Iterable<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f38035a;

        public a(m mVar) {
            this.f38035a = mVar;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<T> iterator() {
            return this.f38035a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    @t0({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt$groupingBy$1\n*L\n1#1,3094:1\n*E\n"})
    public static final class b<K, T> implements d0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<T> f38036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, K> f38037b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(m<? extends T> mVar, ik.l<? super T, ? extends K> lVar) {
            this.f38036a = mVar;
            this.f38037b = lVar;
        }

        @Override // kotlin.collections.d0
        public K a(T t10) {
            return this.f38037b.i(t10);
        }

        @Override // kotlin.collections.d0
        @yt.k
        public Iterator<T> b() {
            return this.f38036a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<T> f38038a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(m<? extends T> mVar) {
            this.f38038a = mVar;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<T> iterator() {
            List listD3 = SequencesKt___SequencesKt.d3(this.f38038a);
            kotlin.collections.w.j0(listD3);
            return listD3.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<T> f38039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super T> f38040b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(m<? extends T> mVar, Comparator<? super T> comparator) {
            this.f38039a = mVar;
            this.f38040b = comparator;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<T> iterator() {
            List listD3 = SequencesKt___SequencesKt.d3(this.f38039a);
            kotlin.collections.w.m0(listD3, this.f38040b);
            return listD3.iterator();
        }
    }

    @bk.f
    public static final <T> T A0(m<? extends T> mVar, ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        T t10 = null;
        for (T t11 : mVar) {
            if (predicate.i(t11).booleanValue()) {
                t10 = t11;
            }
        }
        return t10;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R> R A1(m<? extends T> mVar, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.k
    public static final <T, R> m<R> A2(@yt.k m<? extends T> mVar, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        return w2(mVar, r10, operation);
    }

    public static final <T> T B0(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R> R B1(m<? extends T> mVar, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.k
    public static final <T, R> m<R> B2(@yt.k m<? extends T> mVar, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        return x2(mVar, r10, operation);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T C0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        for (T t10 : mVar) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @v0(version = "1.4")
    @yt.l
    public static final <T extends Comparable<? super T>> T C1(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T C2(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it2.next();
        if (it2.hasNext()) {
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        return next;
    }

    @bk.f
    @v0(version = "1.5")
    public static final <T, R> R D0(m<? extends T> mVar, ik.l<? super T, ? extends R> transform) {
        R rI;
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        Iterator<? extends T> it2 = mVar.iterator();
        while (true) {
            if (!it2.hasNext()) {
                rI = null;
                break;
            }
            rI = transform.i(it2.next());
            if (rI != null) {
                break;
            }
        }
        if (rI != null) {
            return rI;
        }
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    @v0(version = "1.4")
    @yt.l
    public static final Double D1(@yt.k m<Double> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Double> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T D2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : mVar) {
            if (predicate.i(t11).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @bk.f
    @v0(version = "1.5")
    public static final <T, R> R E0(m<? extends T> mVar, ik.l<? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                return rI;
            }
        }
        return null;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Float E1(@yt.k m<Float> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Float> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it2.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @yt.l
    public static final <T> T E2(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (it2.hasNext()) {
            return null;
        }
        return next;
    }

    @yt.l
    public static final <T> T F0(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        return null;
    }

    @hk.h(name = "maxOrThrow")
    @v0(version = "1.7")
    public static final double F1(@yt.k m<Double> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Double> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it2.next().doubleValue());
        }
        return dDoubleValue;
    }

    @yt.l
    public static final <T> T F2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        boolean z10 = false;
        T t10 = null;
        for (T t11 : mVar) {
            if (predicate.i(t11).booleanValue()) {
                if (z10) {
                    return null;
                }
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @yt.l
    public static final <T> T G0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        for (T t10 : mVar) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    @hk.h(name = "maxOrThrow")
    @v0(version = "1.7")
    public static final float G1(@yt.k m<Float> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Float> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it2.next().floatValue());
        }
        return fFloatValue;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> m<T> G2(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return new c(mVar);
    }

    @yt.k
    public static final <T, R> m<R> H0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends m<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return new i(mVar, transform, SequencesKt___SequencesKt$flatMap$2.f38046c);
    }

    @hk.h(name = "maxOrThrow")
    @v0(version = "1.7")
    @yt.k
    public static final <T extends Comparable<? super T>> T H1(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @yt.k
    public static final <T, R extends Comparable<? super R>> m<T> H2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        return K2(mVar, new g.a(selector));
    }

    @hk.h(name = "flatMapIndexedIterable")
    @m0
    @v0(version = "1.4")
    @yt.k
    public static final <T, R> m<R> I0(@yt.k m<? extends T> mVar, @yt.k ik.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return SequencesKt__SequencesKt.h(mVar, transform, SequencesKt___SequencesKt$flatMapIndexed$1.f38047c);
    }

    @v0(version = "1.4")
    @yt.l
    public static final <T> T I1(@yt.k m<? extends T> mVar, @yt.k Comparator<? super T> comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @yt.k
    public static final <T, R extends Comparable<? super R>> m<T> I2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        return K2(mVar, new g.c(selector));
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C J0(m<? extends T> mVar, C destination, ik.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            kotlin.collections.x.n0(destination, transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return destination;
    }

    @hk.h(name = "maxWithOrThrow")
    @v0(version = "1.7")
    public static final <T> T J1(@yt.k m<? extends T> mVar, @yt.k Comparator<? super T> comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> m<T> J2(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return K2(mVar, uj.g.x());
    }

    public static final <T> boolean K(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            if (!predicate.i(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @hk.h(name = "flatMapIndexedSequence")
    @m0
    @v0(version = "1.4")
    @yt.k
    public static final <T, R> m<R> K0(@yt.k m<? extends T> mVar, @yt.k ik.p<? super Integer, ? super T, ? extends m<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return SequencesKt__SequencesKt.h(mVar, transform, SequencesKt___SequencesKt$flatMapIndexed$2.f38048c);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @v0(version = "1.4")
    @yt.l
    public static final <T, R extends Comparable<? super R>> T K1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        R rI = selector.i(next);
        do {
            T next2 = it2.next();
            R rI2 = selector.i(next2);
            next = next;
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                next = next2;
            }
        } while (it2.hasNext());
        return (T) next;
    }

    @yt.k
    public static final <T> m<T> K2(@yt.k m<? extends T> mVar, @yt.k Comparator<? super T> comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        return new d(mVar, comparator);
    }

    public static final <T> boolean L(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return mVar.iterator().hasNext();
    }

    @hk.h(name = "flatMapIndexedSequenceTo")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C L0(m<? extends T> mVar, C destination, ik.p<? super Integer, ? super T, ? extends m<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            kotlin.collections.x.o0(destination, transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @hk.h(name = "minByOrThrow")
    @v0(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T L1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        R rI = selector.i(next);
        do {
            T next2 = it2.next();
            R rI2 = selector.i(next2);
            next = next;
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                next = next2;
            }
        } while (it2.hasNext());
        return (T) next;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> int L2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Integer> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += selector.i(it2.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> boolean M(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @hk.h(name = "flatMapIterable")
    @m0
    @v0(version = "1.4")
    @yt.k
    public static final <T, R> m<R> M0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends Iterable<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return new i(mVar, transform, SequencesKt___SequencesKt$flatMap$1.f38045c);
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> double M1(m<? extends T> mVar, ik.l<? super T, Double> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(it2.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> double M2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Double> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it2.hasNext()) {
            dDoubleValue += selector.i(it2.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final <T> Iterable<T> N(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return new a(mVar);
    }

    @hk.h(name = "flatMapIterableTo")
    @m0
    @v0(version = "1.4")
    @yt.k
    public static final <T, R, C extends Collection<? super R>> C N0(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.l<? super T, ? extends Iterable<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            kotlin.collections.x.n0(destination, transform.i(it2.next()));
        }
        return destination;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> float N1(m<? extends T> mVar, ik.l<? super T, Float> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return fFloatValue;
    }

    @hk.h(name = "sumOfByte")
    public static final int N2(@yt.k m<Byte> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Byte> it2 = mVar.iterator();
        int iByteValue = 0;
        while (it2.hasNext()) {
            iByteValue += it2.next().byteValue();
        }
        return iByteValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <T> m<T> O(m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return mVar;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C O0(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.l<? super T, ? extends m<? extends R>> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            kotlin.collections.x.o0(destination, transform.i(it2.next()));
        }
        return destination;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R O1(m<? extends T> mVar, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "sumOfDouble")
    public static final double O2(@yt.k m<Double> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Double> it2 = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it2.hasNext()) {
            dDoubleValue += it2.next().doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final <T, K, V> Map<K, V> P(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            Pair<? extends K, ? extends V> pairI = transform.i(it2.next());
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    public static final <T, R> R P0(@yt.k m<? extends T> mVar, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            r10 = operation.r0(r10, it2.next());
        }
        return r10;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R P1(m<? extends T> mVar, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "sumOfDouble")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> double P2(m<? extends T> mVar, ik.l<? super T, Double> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it2.hasNext()) {
            dDoubleValue += selector.i(it2.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final <T, K> Map<K, T> Q(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends K> keySelector) {
        f0.p(mVar, "<this>");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            linkedHashMap.put(keySelector.i(t10), t10);
        }
        return linkedHashMap;
    }

    public static final <T, R> R Q0(@yt.k m<? extends T> mVar, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            r10 = operation.A(Integer.valueOf(i10), r10, t10);
            i10 = i11;
        }
        return r10;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> Double Q1(m<? extends T> mVar, ik.l<? super T, Double> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.i(it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(it2.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "sumOfFloat")
    public static final float Q2(@yt.k m<Float> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Float> it2 = mVar.iterator();
        float fFloatValue = 0.0f;
        while (it2.hasNext()) {
            fFloatValue += it2.next().floatValue();
        }
        return fFloatValue;
    }

    @yt.k
    public static final <T, K, V> Map<K, V> R(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        f0.p(mVar, "<this>");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            linkedHashMap.put(keySelector.i(t10), valueTransform.i(t10));
        }
        return linkedHashMap;
    }

    public static final <T> void R0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, z1> action) {
        f0.p(mVar, "<this>");
        f0.p(action, "action");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            action.i(it2.next());
        }
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> Float R1(m<? extends T> mVar, ik.l<? super T, Float> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "sumOfInt")
    public static final int R2(@yt.k m<Integer> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Integer> it2 = mVar.iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += it2.next().intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final <T, K, M extends Map<? super K, ? super T>> M S(@yt.k m<? extends T> mVar, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        for (T t10 : mVar) {
            destination.put(keySelector.i(t10), t10);
        }
        return destination;
    }

    public static final <T> void S0(@yt.k m<? extends T> mVar, @yt.k ik.p<? super Integer, ? super T, z1> action) {
        f0.p(mVar, "<this>");
        f0.p(action, "action");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            action.r0(Integer.valueOf(i10), t10);
            i10 = i11;
        }
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R> R S1(m<? extends T> mVar, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "sumOfInt")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> int S2(m<? extends T> mVar, ik.l<? super T, Integer> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += selector.i(it2.next()).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final <T, K, V, M extends Map<? super K, ? super V>> M T(@yt.k m<? extends T> mVar, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        for (T t10 : mVar) {
            destination.put(keySelector.i(t10), valueTransform.i(t10));
        }
        return destination;
    }

    @yt.k
    public static final <T, K> Map<K, List<T>> T0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends K> keySelector) {
        f0.p(mVar, "<this>");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            K kI = keySelector.i(t10);
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(t10);
        }
        return linkedHashMap;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R> R T1(m<? extends T> mVar, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "sumOfLong")
    public static final long T2(@yt.k m<Long> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Long> it2 = mVar.iterator();
        long jLongValue = 0;
        while (it2.hasNext()) {
            jLongValue += it2.next().longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final <T, K, V, M extends Map<? super K, ? super V>> M U(@yt.k m<? extends T> mVar, @yt.k M destination, @yt.k ik.l<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            Pair<? extends K, ? extends V> pairI = transform.i(it2.next());
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @yt.k
    public static final <T, K, V> Map<K, List<V>> U0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        f0.p(mVar, "<this>");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : mVar) {
            K kI = keySelector.i(t10);
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(t10));
        }
        return linkedHashMap;
    }

    @v0(version = "1.4")
    @yt.l
    public static final <T extends Comparable<? super T>> T U1(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @hk.h(name = "sumOfLong")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> long U2(m<? extends T> mVar, ik.l<? super T, Long> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        long jLongValue = 0;
        while (it2.hasNext()) {
            jLongValue += selector.i(it2.next()).longValue();
        }
        return jLongValue;
    }

    @v0(version = "1.3")
    @yt.k
    public static final <K, V> Map<K, V> V(@yt.k m<? extends K> mVar, @yt.k ik.l<? super K, ? extends V> valueSelector) {
        f0.p(mVar, "<this>");
        f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k10 : mVar) {
            linkedHashMap.put(k10, valueSelector.i(k10));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <T, K, M extends Map<? super K, List<T>>> M V0(@yt.k m<? extends T> mVar, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        for (T t10 : mVar) {
            K kI = keySelector.i(t10);
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(t10);
        }
        return destination;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Double V1(@yt.k m<Double> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Double> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "sumOfShort")
    public static final int V2(@yt.k m<Short> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Short> it2 = mVar.iterator();
        int iShortValue = 0;
        while (it2.hasNext()) {
            iShortValue += it2.next().shortValue();
        }
        return iShortValue;
    }

    @v0(version = "1.3")
    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M W(@yt.k m<? extends K> mVar, @yt.k M destination, @yt.k ik.l<? super K, ? extends V> valueSelector) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(valueSelector, "valueSelector");
        for (K k10 : mVar) {
            destination.put(k10, valueSelector.i(k10));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T, K, V, M extends Map<? super K, List<V>>> M W0(@yt.k m<? extends T> mVar, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        for (T t10 : mVar) {
            K kI = keySelector.i(t10);
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(t10));
        }
        return destination;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Float W1(@yt.k m<Float> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Float> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it2.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "sumOfUInt")
    @m0
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final <T> int W2(m<? extends T> mVar, ik.l<? super T, l1> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        int iJ = l1.j(0);
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            iJ = l1.j(iJ + selector.i(it2.next()).l0());
        }
        return iJ;
    }

    @hk.h(name = "averageOfByte")
    public static final double X(@yt.k m<Byte> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Byte> it2 = mVar.iterator();
        double dByteValue = 0.0d;
        int i10 = 0;
        while (it2.hasNext()) {
            dByteValue += (double) it2.next().byteValue();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i10);
    }

    @v0(version = "1.1")
    @yt.k
    public static final <T, K> d0<T, K> X0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends K> keySelector) {
        f0.p(mVar, "<this>");
        f0.p(keySelector, "keySelector");
        return new b(mVar, keySelector);
    }

    @hk.h(name = "minOrThrow")
    @v0(version = "1.7")
    public static final double X1(@yt.k m<Double> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Double> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it2.next().doubleValue());
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @m0
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final <T> long X2(m<? extends T> mVar, ik.l<? super T, p1> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        long j10 = p1.j(0L);
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            j10 = p1.j(j10 + selector.i(it2.next()).l0());
        }
        return j10;
    }

    @hk.h(name = "averageOfDouble")
    public static final double Y(@yt.k m<Double> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Double> it2 = mVar.iterator();
        double dDoubleValue = 0.0d;
        int i10 = 0;
        while (it2.hasNext()) {
            dDoubleValue += it2.next().doubleValue();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i10);
    }

    public static final <T> int Y0(@yt.k m<? extends T> mVar, T t10) {
        f0.p(mVar, "<this>");
        int i10 = 0;
        for (T t11 : mVar) {
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (f0.g(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @hk.h(name = "minOrThrow")
    @v0(version = "1.7")
    public static final float Y1(@yt.k m<Float> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Float> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it2.next().floatValue());
        }
        return fFloatValue;
    }

    @yt.k
    public static final <T> m<T> Y2(@yt.k m<? extends T> mVar, int i10) {
        f0.p(mVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? SequencesKt__SequencesKt.g() : mVar instanceof e ? ((e) mVar).a(i10) : new t(mVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @hk.h(name = "averageOfFloat")
    public static final double Z(@yt.k m<Float> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Float> it2 = mVar.iterator();
        double dFloatValue = 0.0d;
        int i10 = 0;
        while (it2.hasNext()) {
            dFloatValue += (double) it2.next().floatValue();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i10);
    }

    public static final <T> int Z0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        int i10 = 0;
        for (T t10 : mVar) {
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (predicate.i(t10).booleanValue()) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @hk.h(name = "minOrThrow")
    @v0(version = "1.7")
    @yt.k
    public static final <T extends Comparable<? super T>> T Z1(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @yt.k
    public static final <T> m<T> Z2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        return new u(mVar, predicate);
    }

    @hk.h(name = "averageOfInt")
    public static final double a0(@yt.k m<Integer> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Integer> it2 = mVar.iterator();
        double dIntValue = 0.0d;
        int i10 = 0;
        while (it2.hasNext()) {
            dIntValue += (double) it2.next().intValue();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i10);
    }

    public static final <T> int a1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        int i10 = -1;
        int i11 = 0;
        for (T t10 : mVar) {
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (predicate.i(t10).booleanValue()) {
                i10 = i11;
            }
            i11++;
        }
        return i10;
    }

    @v0(version = "1.4")
    @yt.l
    public static final <T> T a2(@yt.k m<? extends T> mVar, @yt.k Comparator<? super T> comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C a3(@yt.k m<? extends T> mVar, @yt.k C destination) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            destination.add(it2.next());
        }
        return destination;
    }

    @hk.h(name = "averageOfLong")
    public static final double b0(@yt.k m<Long> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Long> it2 = mVar.iterator();
        double dLongValue = 0.0d;
        int i10 = 0;
        while (it2.hasNext()) {
            dLongValue += it2.next().longValue();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i10);
    }

    @yt.k
    public static final <T, A extends Appendable> A b1(@yt.k m<? extends T> mVar, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super T, ? extends CharSequence> lVar) throws IOException {
        f0.p(mVar, "<this>");
        f0.p(buffer, "buffer");
        f0.p(separator, "separator");
        f0.p(prefix, "prefix");
        f0.p(postfix, "postfix");
        f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : mVar) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kotlin.text.n.b(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @hk.h(name = "minWithOrThrow")
    @v0(version = "1.7")
    public static final <T> T b2(@yt.k m<? extends T> mVar, @yt.k Comparator<? super T> comparator) {
        f0.p(mVar, "<this>");
        f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @yt.k
    public static final <T> HashSet<T> b3(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return (HashSet) a3(mVar, new HashSet());
    }

    @hk.h(name = "averageOfShort")
    public static final double c0(@yt.k m<Short> mVar) {
        f0.p(mVar, "<this>");
        Iterator<Short> it2 = mVar.iterator();
        double dShortValue = 0.0d;
        int i10 = 0;
        while (it2.hasNext()) {
            dShortValue += (double) it2.next().shortValue();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i10);
    }

    @yt.k
    public static final <T> m<T> c2(@yt.k final m<? extends T> mVar, @yt.k final Iterable<? extends T> elements) {
        f0.p(mVar, "<this>");
        f0.p(elements, "elements");
        return new m<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$3
            @Override // kotlin.sequences.m
            @yt.k
            public Iterator<T> iterator() {
                final Collection collectionQ0 = kotlin.collections.x.q0(elements);
                return collectionQ0.isEmpty() ? mVar.iterator() : SequencesKt___SequencesKt.u0(mVar, new ik.l<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$3$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Boolean i(T t10) {
                        return Boolean.valueOf(collectionQ0.contains(t10));
                    }
                }).iterator();
            }
        };
    }

    @yt.k
    public static final <T> List<T> c3(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return CollectionsKt__CollectionsKt.Q(d3(mVar));
    }

    @v0(version = "1.2")
    @yt.k
    public static final <T> m<List<T>> d0(@yt.k m<? extends T> mVar, int i10) {
        f0.p(mVar, "<this>");
        return g3(mVar, i10, i10, true);
    }

    @yt.k
    public static final <T> String d1(@yt.k m<? extends T> mVar, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super T, ? extends CharSequence> lVar) {
        f0.p(mVar, "<this>");
        f0.p(separator, "separator");
        f0.p(prefix, "prefix");
        f0.p(postfix, "postfix");
        f0.p(truncated, "truncated");
        String string = ((StringBuilder) b1(mVar, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.k
    public static final <T> m<T> d2(@yt.k final m<? extends T> mVar, final T t10) {
        f0.p(mVar, "<this>");
        return new m<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$1
            @Override // kotlin.sequences.m
            @yt.k
            public Iterator<T> iterator() {
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                m<T> mVar2 = mVar;
                final T t11 = t10;
                return SequencesKt___SequencesKt.p0(mVar2, new ik.l<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$1$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Boolean i(T t12) {
                        boolean z10 = true;
                        if (!booleanRef.element && f0.g(t12, t11)) {
                            booleanRef.element = true;
                            z10 = false;
                        }
                        return Boolean.valueOf(z10);
                    }
                }).iterator();
            }
        };
    }

    @yt.k
    public static final <T> List<T> d3(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return (List) a3(mVar, new ArrayList());
    }

    @v0(version = "1.2")
    @yt.k
    public static final <T, R> m<R> e0(@yt.k m<? extends T> mVar, int i10, @yt.k ik.l<? super List<? extends T>, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return h3(mVar, i10, i10, true, transform);
    }

    public static /* synthetic */ String e1(m mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return d1(mVar, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <T> m<T> e2(@yt.k final m<? extends T> mVar, @yt.k final m<? extends T> elements) {
        f0.p(mVar, "<this>");
        f0.p(elements, "elements");
        return new m<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$4
            @Override // kotlin.sequences.m
            @yt.k
            public Iterator<T> iterator() {
                final List listC3 = SequencesKt___SequencesKt.c3(elements);
                return listC3.isEmpty() ? mVar.iterator() : SequencesKt___SequencesKt.u0(mVar, new ik.l<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$4$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Boolean i(T t10) {
                        return Boolean.valueOf(listC3.contains(t10));
                    }
                }).iterator();
            }
        };
    }

    @yt.k
    public static final <T> Set<T> e3(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(it2.next());
        }
        return linkedHashSet;
    }

    public static final <T> boolean f0(@yt.k m<? extends T> mVar, T t10) {
        f0.p(mVar, "<this>");
        return Y0(mVar, t10) >= 0;
    }

    public static final <T> T f1(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it2.next();
        while (it2.hasNext()) {
            next = it2.next();
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> m<T> f2(@yt.k final m<? extends T> mVar, @yt.k final T[] elements) {
        f0.p(mVar, "<this>");
        f0.p(elements, "elements");
        return elements.length == 0 ? mVar : new m<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$2
            @Override // kotlin.sequences.m
            @yt.k
            public Iterator<T> iterator() {
                m<T> mVar2 = mVar;
                final T[] tArr = elements;
                return SequencesKt___SequencesKt.u0(mVar2, new ik.l<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$2$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Boolean i(T t10) {
                        return Boolean.valueOf(ArraysKt___ArraysKt.T8(tArr, t10));
                    }
                }).iterator();
            }
        };
    }

    @yt.k
    public static final <T> Set<T> f3(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return d1.r((Set) a3(mVar, new LinkedHashSet()));
    }

    public static final <T> int g0(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            it2.next();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        return i10;
    }

    public static final <T> T g1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : mVar) {
            if (predicate.i(t11).booleanValue()) {
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @bk.f
    public static final <T> m<T> g2(m<? extends T> mVar, T t10) {
        f0.p(mVar, "<this>");
        return d2(mVar, t10);
    }

    @v0(version = "1.2")
    @yt.k
    public static final <T> m<List<T>> g3(@yt.k m<? extends T> mVar, int i10, int i11, boolean z10) {
        f0.p(mVar, "<this>");
        return SlidingWindowKt.c(mVar, i10, i11, z10, false);
    }

    public static final <T> int h0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        Iterator<? extends T> it2 = mVar.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue() && (i10 = i10 + 1) < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        return i10;
    }

    public static final <T> int h1(@yt.k m<? extends T> mVar, T t10) {
        f0.p(mVar, "<this>");
        int i10 = -1;
        int i11 = 0;
        for (T t11 : mVar) {
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (f0.g(t10, t11)) {
                i10 = i11;
            }
            i11++;
        }
        return i10;
    }

    public static final <T> boolean h2(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return !mVar.iterator().hasNext();
    }

    @v0(version = "1.2")
    @yt.k
    public static final <T, R> m<R> h3(@yt.k m<? extends T> mVar, int i10, int i11, boolean z10, @yt.k ik.l<? super List<? extends T>, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return k1(SlidingWindowKt.c(mVar, i10, i11, z10, true), transform);
    }

    @yt.k
    public static final <T> m<T> i0(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return j0(mVar, new ik.l<T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$distinct$1
            @Override // ik.l
            public final T i(T t10) {
                return t10;
            }
        });
    }

    @yt.l
    public static final <T> T i1(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            next = it2.next();
        }
        return next;
    }

    public static final <T> boolean i2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ m i3(m mVar, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return g3(mVar, i10, i11, z10);
    }

    @yt.k
    public static final <T, K> m<T> j0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends K> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        return new kotlin.sequences.c(mVar, selector);
    }

    @yt.l
    public static final <T> T j1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        T t10 = null;
        for (T t11 : mVar) {
            if (predicate.i(t11).booleanValue()) {
                t10 = t11;
            }
        }
        return t10;
    }

    @v0(version = "1.1")
    @yt.k
    public static final <T> m<T> j2(@yt.k m<? extends T> mVar, @yt.k final ik.l<? super T, z1> action) {
        f0.p(mVar, "<this>");
        f0.p(action, "action");
        return k1(mVar, new ik.l<T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$onEach$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // ik.l
            public final T i(T t10) {
                action.i(t10);
                return t10;
            }
        });
    }

    public static /* synthetic */ m j3(m mVar, int i10, int i11, boolean z10, ik.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return h3(mVar, i10, i11, z10, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> m<T> k0(@yt.k m<? extends T> mVar, int i10) {
        f0.p(mVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? mVar : mVar instanceof e ? ((e) mVar).b(i10) : new kotlin.sequences.d(mVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <T, R> m<R> k1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return new w(mVar, transform);
    }

    @v0(version = "1.4")
    @yt.k
    public static final <T> m<T> k2(@yt.k m<? extends T> mVar, @yt.k final ik.p<? super Integer, ? super T, z1> action) {
        f0.p(mVar, "<this>");
        f0.p(action, "action");
        return l1(mVar, new ik.p<Integer, T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$onEachIndexed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public final T b(int i10, T t10) {
                action.r0(Integer.valueOf(i10), t10);
                return t10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ik.p
            public /* bridge */ /* synthetic */ Object r0(Integer num, Object obj) {
                return b(num.intValue(), obj);
            }
        });
    }

    @yt.k
    public static final <T> m<h0<T>> k3(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return new k(mVar);
    }

    @yt.k
    public static final <T> m<T> l0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        return new f(mVar, predicate);
    }

    @yt.k
    public static final <T, R> m<R> l1(@yt.k m<? extends T> mVar, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return new v(mVar, transform);
    }

    @yt.k
    public static final <T> Pair<List<T>, List<T>> l2(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t10 : mVar) {
            if (predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
            } else {
                arrayList2.add(t10);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @yt.k
    public static final <T, R> m<Pair<T, R>> l3(@yt.k m<? extends T> mVar, @yt.k m<? extends R> other) {
        f0.p(mVar, "<this>");
        f0.p(other, "other");
        return new l(mVar, other, new ik.p<T, R, Pair<? extends T, ? extends R>>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$zip$1
            @Override // ik.p
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Pair<T, R> r0(T t10, R r10) {
                return kotlin.d1.a(t10, r10);
            }
        });
    }

    public static final <T> T m0(@yt.k m<? extends T> mVar, final int i10) {
        f0.p(mVar, "<this>");
        return (T) n0(mVar, i10, new ik.l<Integer, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final T b(int i11) {
                throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + i10 + '.');
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ Object i(Integer num) {
                return b(num.intValue());
            }
        });
    }

    @yt.k
    public static final <T, R> m<R> m1(@yt.k m<? extends T> mVar, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return v0(new v(mVar, transform));
    }

    @yt.k
    public static final <T> m<T> m2(@yt.k m<? extends T> mVar, @yt.k Iterable<? extends T> elements) {
        f0.p(mVar, "<this>");
        f0.p(elements, "elements");
        return SequencesKt__SequencesKt.i(SequencesKt__SequencesKt.q(mVar, CollectionsKt___CollectionsKt.v1(elements)));
    }

    @yt.k
    public static final <T, R, V> m<V> m3(@yt.k m<? extends T> mVar, @yt.k m<? extends R> other, @yt.k ik.p<? super T, ? super R, ? extends V> transform) {
        f0.p(mVar, "<this>");
        f0.p(other, "other");
        f0.p(transform, "transform");
        return new l(mVar, other, transform);
    }

    public static final <T> T n0(@yt.k m<? extends T> mVar, int i10, @yt.k ik.l<? super Integer, ? extends T> defaultValue) {
        f0.p(mVar, "<this>");
        f0.p(defaultValue, "defaultValue");
        if (i10 < 0) {
            return defaultValue.i(Integer.valueOf(i10));
        }
        int i11 = 0;
        for (T t10 : mVar) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return defaultValue.i(Integer.valueOf(i10));
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C n1(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            R rR0 = transform.r0(Integer.valueOf(i10), t10);
            if (rR0 != null) {
                destination.add(rR0);
            }
            i10 = i11;
        }
        return destination;
    }

    @yt.k
    public static final <T> m<T> n2(@yt.k m<? extends T> mVar, T t10) {
        f0.p(mVar, "<this>");
        return SequencesKt__SequencesKt.i(SequencesKt__SequencesKt.q(mVar, SequencesKt__SequencesKt.q(t10)));
    }

    @v0(version = "1.2")
    @yt.k
    public static final <T> m<Pair<T, T>> n3(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return o3(mVar, new ik.p<T, T, Pair<? extends T, ? extends T>>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$1
            @Override // ik.p
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Pair<T, T> r0(T t10, T t11) {
                return kotlin.d1.a(t10, t11);
            }
        });
    }

    @yt.l
    public static final <T> T o0(@yt.k m<? extends T> mVar, int i10) {
        f0.p(mVar, "<this>");
        if (i10 < 0) {
            return null;
        }
        int i11 = 0;
        for (T t10 : mVar) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return null;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C o1(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            destination.add(transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return destination;
    }

    @yt.k
    public static final <T> m<T> o2(@yt.k m<? extends T> mVar, @yt.k m<? extends T> elements) {
        f0.p(mVar, "<this>");
        f0.p(elements, "elements");
        return SequencesKt__SequencesKt.i(SequencesKt__SequencesKt.q(mVar, elements));
    }

    @v0(version = "1.2")
    @yt.k
    public static final <T, R> m<R> o3(@yt.k m<? extends T> mVar, @yt.k ik.p<? super T, ? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return q.b(new SequencesKt___SequencesKt$zipWithNext$2(mVar, transform, null));
    }

    @yt.k
    public static final <T> m<T> p0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        return new h(mVar, true, predicate);
    }

    @yt.k
    public static final <T, R> m<R> p1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(transform, "transform");
        return v0(new w(mVar, transform));
    }

    @yt.k
    public static final <T> m<T> p2(@yt.k m<? extends T> mVar, @yt.k T[] elements) {
        f0.p(mVar, "<this>");
        f0.p(elements, "elements");
        return m2(mVar, kotlin.collections.m.t(elements));
    }

    @yt.k
    public static final <T> m<T> q0(@yt.k m<? extends T> mVar, @yt.k final ik.p<? super Integer, ? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        return new w(new h(new k(mVar), true, new ik.l<h0<? extends T>, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.k h0<? extends T> it2) {
                f0.p(it2, "it");
                return predicate.r0(Integer.valueOf(it2.e()), it2.f());
            }
        }), new ik.l<h0<? extends T>, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final T i(@yt.k h0<? extends T> it2) {
                f0.p(it2, "it");
                return it2.f();
            }
        });
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C q1(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.l<? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                destination.add(rI);
            }
        }
        return destination;
    }

    @bk.f
    public static final <T> m<T> q2(m<? extends T> mVar, T t10) {
        f0.p(mVar, "<this>");
        return n2(mVar, t10);
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C r0(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int i10 = 0;
        for (T t10 : mVar) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (predicate.r0(Integer.valueOf(i10), t10).booleanValue()) {
                destination.add(t10);
            }
            i10 = i11;
        }
        return destination;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C r1(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.l<? super T, ? extends R> transform) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        Iterator<? extends T> it2 = mVar.iterator();
        while (it2.hasNext()) {
            destination.add(transform.i(it2.next()));
        }
        return destination;
    }

    public static final <S, T extends S> S r2(@yt.k m<? extends T> mVar, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it2.next();
        while (it2.hasNext()) {
            next = operation.r0(next, it2.next());
        }
        return next;
    }

    public static final /* synthetic */ <R> m<R> s0(m<?> mVar) {
        f0.p(mVar, "<this>");
        f0.w();
        m<R> mVarP0 = p0(mVar, new ik.l<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterIsInstance$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.l Object obj) {
                f0.y(3, "R");
                return Boolean.valueOf(obj instanceof Object);
            }
        });
        f0.n(mVarP0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return mVarP0;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @v0(version = "1.4")
    @yt.l
    public static final <T, R extends Comparable<? super R>> T s1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        R rI = selector.i(next);
        do {
            T next2 = it2.next();
            R rI2 = selector.i(next2);
            next = next;
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                next = next2;
            }
        } while (it2.hasNext());
        return (T) next;
    }

    public static final <S, T extends S> S s2(@yt.k m<? extends T> mVar, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it2.next();
        int i10 = 1;
        while (it2.hasNext()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            next = operation.A(Integer.valueOf(i10), next, it2.next());
            i10 = i11;
        }
        return next;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C t0(m<?> mVar, C destination) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        for (Object obj : mVar) {
            f0.y(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @hk.h(name = "maxByOrThrow")
    @v0(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T t1(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        R rI = selector.i(next);
        do {
            T next2 = it2.next();
            R rI2 = selector.i(next2);
            next = next;
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                next = next2;
            }
        } while (it2.hasNext());
        return (T) next;
    }

    @v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S t2(@yt.k m<? extends T> mVar, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        S next = it2.next();
        int i10 = 1;
        while (it2.hasNext()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            next = operation.A(Integer.valueOf(i10), next, it2.next());
            i10 = i11;
        }
        return next;
    }

    @yt.k
    public static final <T> m<T> u0(@yt.k m<? extends T> mVar, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        return new h(mVar, false, predicate);
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> double u1(m<? extends T> mVar, ik.l<? super T, Double> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(it2.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S u2(@yt.k m<? extends T> mVar, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        S next = it2.next();
        while (it2.hasNext()) {
            next = operation.r0(next, it2.next());
        }
        return next;
    }

    @yt.k
    public static final <T> m<T> v0(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        m<T> mVarU0 = u0(mVar, new ik.l<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.l T t10) {
                return Boolean.valueOf(t10 == null);
            }
        });
        f0.n(mVarU0, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return mVarU0;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> float v1(m<? extends T> mVar, ik.l<? super T, Float> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return fFloatValue;
    }

    @yt.k
    public static final <T> m<T> v2(@yt.k final m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return k1(mVar, new ik.l<T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$requireNoNulls$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            public final T i(@yt.l T t10) {
                if (t10 != null) {
                    return t10;
                }
                throw new IllegalArgumentException("null element found in " + mVar + '.');
            }
        });
    }

    @yt.k
    public static final <C extends Collection<? super T>, T> C w0(@yt.k m<? extends T> mVar, @yt.k C destination) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        for (T t10 : mVar) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R w1(m<? extends T> mVar, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @v0(version = "1.4")
    @yt.k
    public static final <T, R> m<R> w2(@yt.k m<? extends T> mVar, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        return q.b(new SequencesKt___SequencesKt$runningFold$1(r10, mVar, operation, null));
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C x0(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        for (T t10 : mVar) {
            if (!predicate.i(t10).booleanValue()) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R x1(m<? extends T> mVar, ik.l<? super T, ? extends R> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i(it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i(it2.next());
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @v0(version = "1.4")
    @yt.k
    public static final <T, R> m<R> x2(@yt.k m<? extends T> mVar, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        return q.b(new SequencesKt___SequencesKt$runningFoldIndexed$1(r10, mVar, operation, null));
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C y0(@yt.k m<? extends T> mVar, @yt.k C destination, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        for (T t10 : mVar) {
            if (predicate.i(t10).booleanValue()) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> Double y1(m<? extends T> mVar, ik.l<? super T, Double> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.i(it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(it2.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.k
    public static final <S, T extends S> m<S> y2(@yt.k m<? extends T> mVar, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        return q.b(new SequencesKt___SequencesKt$runningReduce$1(mVar, operation, null));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @bk.f
    public static final <T> T z0(m<? extends T> mVar, ik.l<? super T, Boolean> predicate) {
        f0.p(mVar, "<this>");
        f0.p(predicate, "predicate");
        for (T t10 : mVar) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <T> Float z1(m<? extends T> mVar, ik.l<? super T, Float> selector) {
        f0.p(mVar, "<this>");
        f0.p(selector, "selector");
        Iterator<? extends T> it2 = mVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @v0(version = "1.4")
    @yt.k
    public static final <S, T extends S> m<S> z2(@yt.k m<? extends T> mVar, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        f0.p(mVar, "<this>");
        f0.p(operation, "operation");
        return q.b(new SequencesKt___SequencesKt$runningReduceIndexed$1(mVar, operation, null));
    }
}
