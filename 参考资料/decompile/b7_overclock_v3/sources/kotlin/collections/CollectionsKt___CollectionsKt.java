package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.c2;
import kotlin.l1;
import kotlin.p1;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.z1;
import uj.g;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,3683:1\n288#1,2:3684\n518#1,7:3686\n533#1,6:3693\n857#1,2:3700\n788#1:3702\n1864#1,2:3703\n789#1,2:3705\n1866#1:3707\n791#1:3708\n1864#1,3:3709\n809#1,2:3712\n847#1,2:3714\n1253#1,4:3720\n1222#1,4:3724\n1238#1,4:3728\n1285#1,4:3732\n1446#1,5:3736\n1461#1,5:3741\n1502#1,3:3746\n1505#1,3:3756\n1520#1,3:3759\n1523#1,3:3769\n1620#1,3:3786\n1590#1,4:3789\n1579#1:3793\n1864#1,2:3794\n1866#1:3797\n1580#1:3798\n1864#1,3:3799\n1611#1:3802\n1855#1:3803\n1856#1:3805\n1612#1:3806\n1855#1,2:3807\n1864#1,3:3809\n2847#1,3:3812\n2850#1,6:3816\n2872#1,3:3822\n2875#1,7:3826\n857#1,2:3833\n819#1:3835\n847#1,2:3836\n819#1:3838\n847#1,2:3839\n819#1:3841\n847#1,2:3842\n3405#1,8:3848\n3433#1,7:3856\n3464#1,10:3863\n1#2:3699\n1#2:3796\n1#2:3804\n1#2:3815\n1#2:3825\n37#3,2:3716\n37#3,2:3718\n361#4,7:3749\n361#4,7:3762\n361#4,7:3772\n361#4,7:3779\n32#5,2:3844\n32#5,2:3846\n*S KotlinDebug\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n167#1:3684,2\n177#1:3686,7\n187#1:3693,6\n766#1:3700,2\n777#1:3702\n777#1:3703,2\n777#1:3705,2\n777#1:3707\n777#1:3708\n788#1:3709,3\n800#1:3712,2\n819#1:3714,2\n1180#1:3720,4\n1195#1:3724,4\n1209#1:3728,4\n1272#1:3732,4\n1360#1:3736,5\n1373#1:3741,5\n1477#1:3746,3\n1477#1:3756,3\n1490#1:3759,3\n1490#1:3769,3\n1549#1:3786,3\n1559#1:3789,4\n1569#1:3793\n1569#1:3794,2\n1569#1:3797\n1569#1:3798\n1579#1:3799,3\n1603#1:3802\n1603#1:3803\n1603#1:3805\n1603#1:3806\n1611#1:3807,2\n2645#1:3809,3\n2949#1:3812,3\n2949#1:3816,6\n2967#1:3822,3\n2967#1:3826,7\n3143#1:3833,2\n3151#1:3835\n3151#1:3836,2\n3161#1:3838\n3161#1:3839,2\n3171#1:3841\n3171#1:3842,2\n3394#1:3848,8\n3422#1:3856,7\n3451#1:3863,10\n1569#1:3796\n1603#1:3804\n2949#1:3815\n2967#1:3825\n1032#1:3716,2\n1075#1:3718,2\n1477#1:3749,7\n1490#1:3762,7\n1504#1:3772,7\n1522#1:3779,7\n3339#1:3844,2\n3381#1:3846,2\n*E\n"})
public class CollectionsKt___CollectionsKt extends z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,680:1\n3524#2:681\n*E\n"})
    public static final class a<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f37664a;

        public a(Iterable iterable) {
            this.f37664a = iterable;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<T> iterator() {
            return this.f37664a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    @kotlin.jvm.internal.t0({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1\n*L\n1#1,3683:1\n*E\n"})
    public static final class b<K, T> implements d0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable<T> f37665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, K> f37666b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Iterable<? extends T> iterable, ik.l<? super T, ? extends K> lVar) {
            this.f37665a = iterable;
            this.f37666b = lVar;
        }

        @Override // kotlin.collections.d0
        public K a(T t10) {
            return this.f37666b.i(t10);
        }

        @Override // kotlin.collections.d0
        @yt.k
        public Iterator<T> b() {
            return this.f37665a.iterator();
        }
    }

    @yt.k
    public static final <T, K, V, M extends Map<? super K, ? super V>> M A1(@yt.k Iterable<? extends T> iterable, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (T t10 : iterable) {
            destination.put(keySelector.i(t10), valueTransform.i(t10));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @yt.l
    public static final <T> T A2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : iterable) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T, R extends Comparable<? super R>> T A3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @yt.k
    public static final <T> List<T> A4(@yt.k Collection<? extends T> collection, @yt.k kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        x.o0(arrayList, elements);
        return arrayList;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> long A5(Iterable<? extends T> iterable, ik.l<? super T, Long> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        long jLongValue = 0;
        while (it2.hasNext()) {
            jLongValue += selector.i(it2.next()).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final <T, K, V, M extends Map<? super K, ? super V>> M B1(@yt.k Iterable<? extends T> iterable, @yt.k M destination, @yt.k ik.l<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            Pair<? extends K, ? extends V> pairI = transform.i(it2.next());
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @yt.l
    public static final <T> T B2(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T B3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @yt.k
    public static final <T> List<T> B4(@yt.k Collection<? extends T> collection, @yt.k T[] elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        x.p0(arrayList, elements);
        return arrayList;
    }

    @hk.h(name = "sumOfShort")
    public static final int B5(@yt.k Iterable<Short> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Short> it2 = iterable.iterator();
        int iShortValue = 0;
        while (it2.hasNext()) {
            iShortValue += it2.next().shortValue();
        }
        return iShortValue;
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final <K, V> Map<K, V> C1(@yt.k Iterable<? extends K> iterable, @yt.k ik.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(t.Y(iterable, 10)), 16));
        for (K k10 : iterable) {
            linkedHashMap.put(k10, valueSelector.i(k10));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <T, R> List<R> C2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            x.n0(arrayList, transform.i(it2.next()));
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> double C3(Iterable<? extends T> iterable, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(it2.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @bk.f
    public static final <T> List<T> C4(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return v4(iterable, t10);
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final <T> int C5(Iterable<? extends T> iterable, ik.l<? super T, l1> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            iJ = l1.j(iJ + selector.i(it2.next()).l0());
        }
        return iJ;
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M D1(@yt.k Iterable<? extends K> iterable, @yt.k M destination, @yt.k ik.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (K k10 : iterable) {
            destination.put(k10, valueSelector.i(k10));
        }
        return destination;
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> List<R> D2(Iterable<? extends T> iterable, ik.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            x.n0(arrayList, transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> float D3(Iterable<? extends T> iterable, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return fFloatValue;
    }

    @bk.f
    public static final <T> List<T> D4(Collection<? extends T> collection, T t10) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return z4(collection, t10);
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final <T> long D5(Iterable<? extends T> iterable, ik.l<? super T, p1> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            j10 = p1.j(j10 + selector.i(it2.next()).l0());
        }
        return j10;
    }

    @hk.h(name = "averageOfByte")
    public static final double E1(@yt.k Iterable<Byte> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Byte> it2 = iterable.iterator();
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

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C E2(Iterable<? extends T> iterable, C destination, ik.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            x.n0(destination, transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R E3(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final <T> T E4(Collection<? extends T> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return (T) F4(collection, Random.f38003a);
    }

    @yt.k
    public static final <T> List<T> E5(@yt.k Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return Q5(iterable);
            }
            if (i10 == 1) {
                return s.k(u2(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return CollectionsKt__CollectionsKt.Q(arrayList);
    }

    @hk.h(name = "averageOfDouble")
    public static final double F1(@yt.k Iterable<Double> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Double> it2 = iterable.iterator();
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

    @hk.h(name = "flatMapIndexedSequence")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> List<R> F2(Iterable<? extends T> iterable, ik.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            x.o0(arrayList, transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R F3(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @kotlin.v0(version = "1.3")
    public static final <T> T F4(@yt.k Collection<? extends T> collection, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) b2(collection, random.p(collection.size()));
    }

    @yt.k
    public static final <T> List<T> F5(@yt.k List<? extends T> list, int i10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int size = list.size();
        if (i10 >= size) {
            return Q5(list);
        }
        if (i10 == 1) {
            return s.k(k3(list));
        }
        ArrayList arrayList = new ArrayList(i10);
        if (list instanceof RandomAccess) {
            for (int i11 = size - i10; i11 < size; i11++) {
                arrayList.add(list.get(i11));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    @hk.h(name = "averageOfFloat")
    public static final double G1(@yt.k Iterable<Float> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Float> it2 = iterable.iterator();
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

    @hk.h(name = "flatMapIndexedSequenceTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C G2(Iterable<? extends T> iterable, C destination, ik.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            x.o0(destination, transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Double G3(Iterable<? extends T> iterable, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> T G4(Collection<? extends T> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return (T) H4(collection, Random.f38003a);
    }

    @yt.k
    public static final <T> List<T> G5(@yt.k List<? extends T> list, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.E();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!predicate.i(listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return CollectionsKt__CollectionsKt.E();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return Q5(list);
    }

    @hk.h(name = "averageOfInt")
    public static final double H1(@yt.k Iterable<Integer> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Integer> it2 = iterable.iterator();
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

    @hk.h(name = "flatMapSequence")
    @kotlin.m0
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> H2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            x.o0(arrayList, transform.i(it2.next()));
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Float H3(Iterable<? extends T> iterable, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T> T H4(@yt.k Collection<? extends T> collection, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) b2(collection, random.p(collection.size()));
    }

    @yt.k
    public static final <T> List<T> H5(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!predicate.i(t10).booleanValue()) {
                break;
            }
            arrayList.add(t10);
        }
        return arrayList;
    }

    @hk.h(name = "averageOfLong")
    public static final double I1(@yt.k Iterable<Long> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Long> it2 = iterable.iterator();
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

    @hk.h(name = "flatMapSequenceTo")
    @kotlin.m0
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R, C extends Collection<? super R>> C I2(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            x.o0(destination, transform.i(it2.next()));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R I3(Iterable<? extends T> iterable, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    public static final <S, T extends S> S I4(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it2.next();
        while (it2.hasNext()) {
            next = operation.r0(next, it2.next());
        }
        return next;
    }

    @yt.k
    public static final boolean[] I5(@yt.k Collection<Boolean> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            zArr[i10] = it2.next().booleanValue();
            i10++;
        }
        return zArr;
    }

    @hk.h(name = "averageOfShort")
    public static final double J1(@yt.k Iterable<Short> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Short> it2 = iterable.iterator();
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
    public static final <T, R, C extends Collection<? super R>> C J2(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            x.n0(destination, transform.i(it2.next()));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R J3(Iterable<? extends T> iterable, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    public static final <S, T extends S> S J4(@yt.k Iterable<? extends T> iterable, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
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
    public static final byte[] J5(@yt.k Collection<Byte> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            bArr[i10] = it2.next().byteValue();
            i10++;
        }
        return bArr;
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T> List<List<T>> K1(@yt.k Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return Y5(iterable, i10, i10, true);
    }

    public static final <T, R> R K2(@yt.k Iterable<? extends T> iterable, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            r10 = operation.r0(r10, it2.next());
        }
        return r10;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T extends Comparable<? super T>> T K3(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S K4(@yt.k Iterable<? extends T> iterable, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<? extends T> it2 = iterable.iterator();
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
    public static final char[] K5(@yt.k Collection<Character> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            cArr[i10] = it2.next().charValue();
            i10++;
        }
        return cArr;
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T, R> List<R> L1(@yt.k Iterable<? extends T> iterable, int i10, @yt.k ik.l<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        return Z5(iterable, i10, i10, true, transform);
    }

    public static final <T, R> R L2(@yt.k Iterable<? extends T> iterable, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            r10 = operation.A(Integer.valueOf(i10), r10, t10);
            i10 = i11;
        }
        return r10;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double L3(@yt.k Iterable<Double> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Double> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S L4(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<? extends T> it2 = iterable.iterator();
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
    public static final <T, C extends Collection<? super T>> C L5(@yt.k Iterable<? extends T> iterable, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            destination.add(it2.next());
        }
        return destination;
    }

    @bk.f
    public static final <T> T M1(List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.get(0);
    }

    public static final <T, R> R M2(@yt.k List<? extends T> list, R r10, @yt.k ik.p<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r10 = operation.r0(listIterator.previous(), r10);
            }
        }
        return r10;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float M3(@yt.k Iterable<Float> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Float> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it2.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <S, T extends S> S M4(@yt.k List<? extends T> list, @yt.k ik.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.r0(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @yt.k
    public static final double[] M5(@yt.k Collection<Double> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            dArr[i10] = it2.next().doubleValue();
            i10++;
        }
        return dArr;
    }

    @bk.f
    public static final <T> T N1(List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.get(1);
    }

    public static final <T, R> R N2(@yt.k List<? extends T> list, R r10, @yt.k ik.q<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r10 = operation.A(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r10);
            }
        }
        return r10;
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double N3(@yt.k Iterable<Double> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Double> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it2.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static final <S, T extends S> S N4(@yt.k List<? extends T> list, @yt.k ik.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.A(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @yt.k
    public static final float[] N5(@yt.k Collection<Float> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            fArr[i10] = it2.next().floatValue();
            i10++;
        }
        return fArr;
    }

    @bk.f
    public static final <T> T O1(List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.get(2);
    }

    @bk.e
    public static final <T> void O2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, z1> action) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            action.i(it2.next());
        }
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float O3(@yt.k Iterable<Float> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Float> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it2.next().floatValue());
        }
        return fFloatValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S O4(@yt.k List<? extends T> list, @yt.k ik.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.A(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @yt.k
    public static final <T> HashSet<T> O5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return (HashSet) L5(iterable, new HashSet(r0.j(t.Y(iterable, 12))));
    }

    @bk.f
    public static final <T> T P1(List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.get(3);
    }

    public static final <T> void P2(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super Integer, ? super T, z1> action) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            action.r0(Integer.valueOf(i10), t10);
            i10 = i11;
        }
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    @yt.k
    public static final <T extends Comparable<? super T>> T P3(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S P4(@yt.k List<? extends T> list, @yt.k ik.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.r0(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @yt.k
    public static final int[] P5(@yt.k Collection<Integer> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            iArr[i10] = it2.next().intValue();
            i10++;
        }
        return iArr;
    }

    @bk.f
    public static final <T> T Q1(List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.get(4);
    }

    @bk.f
    public static final <T> T Q2(List<? extends T> list, int i10, ik.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > CollectionsKt__CollectionsKt.G(list)) ? defaultValue.i(Integer.valueOf(i10)) : list.get(i10);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T> T Q3(@yt.k Iterable<? extends T> iterable, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = iterable.iterator();
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

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> Iterable<T> Q4(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    @yt.k
    public static final <T> List<T> Q5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.Q(S5(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (size != 1) {
            return T5(collection);
        }
        return s.k(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> boolean R1(@yt.k Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t10) : X2(iterable, t10) >= 0;
    }

    @yt.l
    public static final <T> T R2(@yt.k List<? extends T> list, int i10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (i10 < 0 || i10 > CollectionsKt__CollectionsKt.G(list)) {
            return null;
        }
        return list.get(i10);
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T> T R3(@yt.k Iterable<? extends T> iterable, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = iterable.iterator();
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

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> List<T> R4(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    @yt.k
    public static final long[] R5(@yt.k Collection<Long> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            jArr[i10] = it2.next().longValue();
            i10++;
        }
        return jArr;
    }

    public static final <T> int S1(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i10 = 0;
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            it2.next();
            i10++;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        return i10;
    }

    @yt.k
    public static final <T, K> Map<K, List<T>> S2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : iterable) {
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

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T, R extends Comparable<? super R>> T S3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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
    public static final <T> List<T> S4(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return Q5(iterable);
        }
        List<T> listS5 = S5(iterable);
        z.m1(listS5);
        return listS5;
    }

    @yt.k
    public static final <T> List<T> S5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof Collection ? T5((Collection) iterable) : (List) L5(iterable, new ArrayList());
    }

    public static final <T> int T1(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue() && (i10 = i10 + 1) < 0) {
                CollectionsKt__CollectionsKt.V();
            }
        }
        return i10;
    }

    @yt.k
    public static final <T, K, V> Map<K, List<V>> T2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : iterable) {
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

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T T3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> T4(@yt.k Iterable<? extends T> iterable, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iY = t.Y(iterable, 9);
        if (iY == 0) {
            return s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iY + 1);
        arrayList.add(r10);
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            r10 = operation.r0(r10, it2.next());
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> T5(@yt.k Collection<? extends T> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return new ArrayList(collection);
    }

    @bk.f
    public static final <T> int U1(Collection<? extends T> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        return collection.size();
    }

    @yt.k
    public static final <T, K, M extends Map<? super K, List<T>>> M U2(@yt.k Iterable<? extends T> iterable, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (T t10 : iterable) {
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

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> double U3(Iterable<? extends T> iterable, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(it2.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> U4(@yt.k Iterable<? extends T> iterable, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iY = t.Y(iterable, 9);
        if (iY == 0) {
            return s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iY + 1);
        arrayList.add(r10);
        int i10 = 0;
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            r10 = operation.A(Integer.valueOf(i10), r10, it2.next());
            arrayList.add(r10);
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final <T> Set<T> U5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) L5(iterable, new LinkedHashSet());
    }

    @yt.k
    public static final <T> List<T> V1(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return Q5(U5(iterable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T, K, V, M extends Map<? super K, List<V>>> M V2(@yt.k Iterable<? extends T> iterable, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (T t10 : iterable) {
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

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> float V3(Iterable<? extends T> iterable, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return fFloatValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <S, T extends S> List<S> V4(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.E();
        }
        S next = it2.next();
        ArrayList arrayList = new ArrayList(t.Y(iterable, 10));
        arrayList.add(next);
        while (it2.hasNext()) {
            next = operation.r0(next, it2.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    @yt.k
    public static final <T> Set<T> V5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return d1.r((Set) L5(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d1.k();
        }
        if (size != 1) {
            return (Set) L5(iterable, new LinkedHashSet(r0.j(collection.size())));
        }
        return c1.f(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @yt.k
    public static final <T, K> List<T> W1(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (hashSet.add(selector.i(t10))) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K> d0<T, K> W2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        return new b(iterable, keySelector);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R W3(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <S, T extends S> List<S> W4(@yt.k Iterable<? extends T> iterable, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.E();
        }
        S next = it2.next();
        ArrayList arrayList = new ArrayList(t.Y(iterable, 10));
        arrayList.add(next);
        int i10 = 1;
        while (it2.hasNext()) {
            next = operation.A(Integer.valueOf(i10), next, it2.next());
            arrayList.add(next);
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final short[] W5(@yt.k Collection<Short> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            sArr[i10] = it2.next().shortValue();
            i10++;
        }
        return sArr;
    }

    @yt.k
    public static final <T> List<T> X1(@yt.k Iterable<? extends T> iterable, int i10) {
        ArrayList arrayList;
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return Q5(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i10;
            if (size <= 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            if (size == 1) {
                return s.k(i3(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i10 < size2) {
                        arrayList.add(((List) iterable).get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t10 : iterable) {
            if (i11 >= i10) {
                arrayList.add(t10);
            } else {
                i11++;
            }
        }
        return CollectionsKt__CollectionsKt.Q(arrayList);
    }

    public static final <T> int X2(@yt.k Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (kotlin.jvm.internal.f0.g(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R X3(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> X4(@yt.k Iterable<? extends T> iterable, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iY = t.Y(iterable, 9);
        if (iY == 0) {
            return s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iY + 1);
        arrayList.add(r10);
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            r10 = operation.r0(r10, it2.next());
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.k
    public static final <T> Set<T> X5(@yt.k Iterable<? extends T> iterable, @yt.k Iterable<? extends T> other) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<T> setU5 = U5(iterable);
        x.n0(setU5, other);
        return setU5;
    }

    @yt.k
    public static final <T> List<T> Y1(@yt.k List<? extends T> list, int i10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (i10 >= 0) {
            return E5(list, qk.v.u(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static final <T> int Y2(@yt.k List<? extends T> list, T t10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.indexOf(t10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Double Y3(Iterable<? extends T> iterable, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.i(it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(it2.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> Y4(@yt.k Iterable<? extends T> iterable, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iY = t.Y(iterable, 9);
        if (iY == 0) {
            return s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iY + 1);
        arrayList.add(r10);
        int i10 = 0;
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            r10 = operation.A(Integer.valueOf(i10), r10, it2.next());
            arrayList.add(r10);
            i10++;
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T> List<List<T>> Y5(@yt.k Iterable<? extends T> iterable, int i10, int i11, boolean z10) {
        int iB;
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        SlidingWindowKt.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = SlidingWindowKt.b(iterable.iterator(), i10, i11, z10, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i11) + (size % i11 == 0 ? 0 : 1));
        int i12 = 0;
        while (true) {
            if (!(i12 >= 0 && i12 < size) || ((iB = qk.v.B(i10, size - i12)) < i10 && !z10)) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(iB);
            for (int i13 = 0; i13 < iB; i13++) {
                arrayList3.add(list.get(i13 + i12));
            }
            arrayList2.add(arrayList3);
            i12 += i11;
        }
        return arrayList2;
    }

    @yt.k
    public static final <T> List<T> Z1(@yt.k List<? extends T> list, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!predicate.i(listIterator.previous()).booleanValue()) {
                    return E5(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final <T> int Z2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (T t10 : iterable) {
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

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Float Z3(Iterable<? extends T> iterable, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = selector.i(it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(it2.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.3")
    public static final <T> void Z4(@yt.k List<T> list, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iG = CollectionsKt__CollectionsKt.G(list); iG > 0; iG--) {
            int iP = random.p(iG + 1);
            list.set(iP, list.set(iG, list.get(iP)));
        }
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T, R> List<R> Z5(@yt.k Iterable<? extends T> iterable, int i10, int i11, boolean z10, @yt.k ik.l<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        SlidingWindowKt.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = SlidingWindowKt.b(iterable.iterator(), i10, i11, z10, true);
            while (itB.hasNext()) {
                arrayList.add(transform.i((List) itB.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i11) + (size % i11 == 0 ? 0 : 1));
        v0 v0Var = new v0(list);
        int i12 = 0;
        while (true) {
            if (!(i12 >= 0 && i12 < size)) {
                break;
            }
            int iB = qk.v.B(i10, size - i12);
            if (!z10 && iB < i10) {
                break;
            }
            v0Var.b(i12, iB + i12);
            arrayList2.add(transform.i(v0Var));
            i12 += i11;
        }
        return arrayList2;
    }

    @yt.k
    public static final <T> List<T> a2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (T t10 : iterable) {
            if (z10) {
                arrayList.add(t10);
            } else if (!predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
                z10 = true;
            }
        }
        return arrayList;
    }

    public static final <T> int a3(@yt.k List<? extends T> list, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Iterator<? extends T> it2 = list.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R a4(Iterable<? extends T> iterable, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    public static final <T> T a5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) c5((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it2.next();
        if (it2.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static /* synthetic */ List a6(Iterable iterable, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return Y5(iterable, i10, i11, z10);
    }

    public static final <T> T b2(@yt.k Iterable<? extends T> iterable, final int i10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i10) : (T) d2(iterable, i10, new ik.l<Integer, T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final T b(int i11) {
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i10 + '.');
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ Object i(Integer num) {
                return b(num.intValue());
            }
        });
    }

    public static final <T> int b3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = -1;
        int i11 = 0;
        for (T t10 : iterable) {
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

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R b4(Iterable<? extends T> iterable, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
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

    public static final <T> T b5(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : iterable) {
            if (predicate.i(t11).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static /* synthetic */ List b6(Iterable iterable, int i10, int i11, boolean z10, ik.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return Z5(iterable, i10, i11, z10, lVar);
    }

    @bk.f
    public static final <T> T c2(List<? extends T> list, int i10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.get(i10);
    }

    public static final <T> int c3(@yt.k List<? extends T> list, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (predicate.i(listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T extends Comparable<? super T>> T c4(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<? extends T> it2 = iterable.iterator();
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

    public static final <T> T c5(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @yt.k
    public static final <T> Iterable<h0<T>> c6(@yt.k final Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return new i0(new ik.a<Iterator<? extends T>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<T> o() {
                return iterable.iterator();
            }
        });
    }

    public static final <T> T d2(@yt.k Iterable<? extends T> iterable, int i10, @yt.k ik.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i10 < 0 || i10 > CollectionsKt__CollectionsKt.G(list)) ? defaultValue.i(Integer.valueOf(i10)) : (T) list.get(i10);
        }
        if (i10 < 0) {
            return defaultValue.i(Integer.valueOf(i10));
        }
        int i11 = 0;
        for (T t10 : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return defaultValue.i(Integer.valueOf(i10));
    }

    @yt.k
    public static final <T> Set<T> d3(@yt.k Iterable<? extends T> iterable, @yt.k Iterable<? extends T> other) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<T> setU5 = U5(iterable);
        x.O0(setU5, other);
        return setU5;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double d4(@yt.k Iterable<Double> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Double> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @yt.l
    public static final <T> T d5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (it2.hasNext()) {
            return null;
        }
        return next;
    }

    @yt.k
    public static final <T, R> List<Pair<T, R>> d6(@yt.k Iterable<? extends T> iterable, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Iterator<? extends T> it2 = iterable.iterator();
        Iterator<? extends R> it3 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t.Y(iterable, 10), t.Y(other, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            arrayList.add(kotlin.d1.a(it2.next(), it3.next()));
        }
        return arrayList;
    }

    @bk.f
    public static final <T> T e2(List<? extends T> list, int i10, ik.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > CollectionsKt__CollectionsKt.G(list)) ? defaultValue.i(Integer.valueOf(i10)) : list.get(i10);
    }

    @yt.k
    public static final <T, A extends Appendable> A e3(@yt.k Iterable<? extends T> iterable, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : iterable) {
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

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float e4(@yt.k Iterable<Float> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Float> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it2.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @yt.l
    public static final <T> T e5(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        boolean z10 = false;
        T t10 = null;
        for (T t11 : iterable) {
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

    @yt.k
    public static final <T, R, V> List<V> e6(@yt.k Iterable<? extends T> iterable, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        Iterator<? extends R> it3 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t.Y(iterable, 10), t.Y(other, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            arrayList.add(transform.r0(it2.next(), it3.next()));
        }
        return arrayList;
    }

    @yt.l
    public static final <T> T f2(@yt.k Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) R2((List) iterable, i10);
        }
        if (i10 < 0) {
            return null;
        }
        int i11 = 0;
        for (T t10 : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return null;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double f4(@yt.k Iterable<Double> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Double> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it2.next().doubleValue());
        }
        return dDoubleValue;
    }

    @yt.l
    public static final <T> T f5(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @yt.k
    public static final <T, R> List<Pair<T, R>> f6(@yt.k Iterable<? extends T> iterable, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(iterable, 10), length));
        int i10 = 0;
        for (T t10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(t10, other[i10]));
            i10++;
        }
        return arrayList;
    }

    @bk.f
    public static final <T> T g2(List<? extends T> list, int i10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return (T) R2(list, i10);
    }

    @yt.k
    public static final <T> String g3(@yt.k Iterable<? extends T> iterable, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) e3(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float g4(@yt.k Iterable<Float> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Float> it2 = iterable.iterator();
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
    public static final <T> List<T> g5(@yt.k List<? extends T> list, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(list.get(it2.next().intValue()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T, R, V> List<V> g6(@yt.k Iterable<? extends T> iterable, @yt.k R[] other, @yt.k ik.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(iterable, 10), length));
        int i10 = 0;
        for (T t10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(t10, other[i10]));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> h2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ String h3(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
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
        return g3(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    @yt.k
    public static final <T extends Comparable<? super T>> T h4(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<? extends T> it2 = iterable.iterator();
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
    public static final <T> List<T> h5(@yt.k List<? extends T> list, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : Q5(list.subList(indices.a().intValue(), indices.e().intValue() + 1));
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T> List<Pair<T, T>> h6(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList();
        T next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            arrayList.add(kotlin.d1.a(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> i2(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (predicate.r0(Integer.valueOf(i10), t10).booleanValue()) {
                arrayList.add(t10);
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static final <T> T i3(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) k3((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it2.next();
        while (it2.hasNext()) {
            next = it2.next();
        }
        return next;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T> T i4(@yt.k Iterable<? extends T> iterable, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = iterable.iterator();
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

    public static final <T, R extends Comparable<? super R>> void i5(@yt.k List<T> list, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (list.size() > 1) {
            w.m0(list, new g.a(selector));
        }
    }

    @kotlin.v0(version = "1.2")
    @yt.k
    public static final <T, R> List<R> i6(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super T, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList();
        a0.c next = it2.next();
        while (it2.hasNext()) {
            T next2 = it2.next();
            arrayList.add(transform.r0(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C j2(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (T t10 : iterable) {
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

    public static final <T> T j3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : iterable) {
            if (predicate.i(t11).booleanValue()) {
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T> T j4(@yt.k Iterable<? extends T> iterable, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Iterator<? extends T> it2 = iterable.iterator();
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

    public static final <T, R extends Comparable<? super R>> void j5(@yt.k List<T> list, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (list.size() > 1) {
            w.m0(list, new g.c(selector));
        }
    }

    public static final /* synthetic */ <R> List<R> k2(Iterable<?> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            kotlin.jvm.internal.f0.y(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> T k3(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(CollectionsKt__CollectionsKt.G(list));
    }

    @yt.k
    public static final <T> List<T> k4(@yt.k Iterable<? extends T> iterable, @yt.k Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        Collection collectionQ0 = x.q0(elements);
        if (collectionQ0.isEmpty()) {
            return Q5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!collectionQ0.contains(t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final <T extends Comparable<? super T>> void k5(@yt.k List<T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        w.m0(list, uj.g.x());
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C l2(Iterable<?> iterable, C destination) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (Object obj : iterable) {
            kotlin.jvm.internal.f0.y(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T l3(@yt.k List<? extends T> list, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (predicate.i(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @yt.k
    public static final <T> List<T> l4(@yt.k Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList(t.Y(iterable, 10));
        boolean z10 = false;
        for (T t11 : iterable) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.f0.g(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(t11);
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> List<T> l5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listS5 = S5(iterable);
            w.j0(listS5);
            return listS5;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return Q5(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        m.v4((Comparable[]) array);
        return m.t(array);
    }

    @yt.k
    public static final <T> List<T> m2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final <T> int m3(@yt.k Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t10);
        }
        int i10 = -1;
        int i11 = 0;
        for (T t11 : iterable) {
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (kotlin.jvm.internal.f0.g(t10, t11)) {
                i10 = i11;
            }
            i11++;
        }
        return i10;
    }

    @yt.k
    public static final <T> List<T> m4(@yt.k Iterable<? extends T> iterable, @yt.k kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        List listC3 = SequencesKt___SequencesKt.c3(elements);
        if (listC3.isEmpty()) {
            return Q5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!listC3.contains(t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <T, R extends Comparable<? super R>> List<T> m5(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return p5(iterable, new g.a(selector));
    }

    @yt.k
    public static final <T> List<T> n2(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return (List) o2(iterable, new ArrayList());
    }

    public static final <T> int n3(@yt.k List<? extends T> list, T t10) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        return list.lastIndexOf(t10);
    }

    @yt.k
    public static final <T> List<T> n4(@yt.k Iterable<? extends T> iterable, @yt.k T[] elements) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements.length == 0) {
            return Q5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!ArraysKt___ArraysKt.T8(elements, t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <T, R extends Comparable<? super R>> List<T> n5(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return p5(iterable, new g.c(selector));
    }

    @yt.k
    public static final <C extends Collection<? super T>, T> C o2(@yt.k Iterable<? extends T> iterable, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (T t10 : iterable) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @yt.l
    public static final <T> T o3(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        while (it2.hasNext()) {
            next = it2.next();
        }
        return next;
    }

    @bk.f
    public static final <T> List<T> o4(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return l4(iterable, t10);
    }

    @yt.k
    public static final <T extends Comparable<? super T>> List<T> o5(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return p5(iterable, uj.g.x());
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C p2(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : iterable) {
            if (!predicate.i(t10).booleanValue()) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @yt.l
    public static final <T> T p3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        T t10 = null;
        for (T t11 : iterable) {
            if (predicate.i(t11).booleanValue()) {
                t10 = t11;
            }
        }
        return t10;
    }

    public static final <T> boolean p4(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> List<T> p5(@yt.k Iterable<? extends T> iterable, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listS5 = S5(iterable);
            w.m0(listS5, comparator);
            return listS5;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return Q5(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        m.I4(array, comparator);
        return m.t(array);
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C q2(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : iterable) {
            if (predicate.i(t10).booleanValue()) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @yt.l
    public static final <T> T q3(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T> boolean q4(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <T> Set<T> q5(@yt.k Iterable<? extends T> iterable, @yt.k Iterable<? extends T> other) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<T> setU5 = U5(iterable);
        x.E0(setU5, other);
        return setU5;
    }

    public static final <T> boolean r1(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (!predicate.i(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @bk.f
    public static final <T> T r2(Iterable<? extends T> iterable, ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : iterable) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @yt.l
    public static final <T> T r3(@yt.k List<? extends T> list, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (predicate.i(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, C extends Iterable<? extends T>> C r4(@yt.k C c10, @yt.k ik.l<? super T, z1> action) {
        kotlin.jvm.internal.f0.p(c10, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Iterator<T> it2 = c10.iterator();
        while (it2.hasNext()) {
            action.i(it2.next());
        }
        return c10;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> int r5(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Integer> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += selector.i(it2.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> boolean s1(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    @bk.f
    public static final <T> T s2(Iterable<? extends T> iterable, ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        T t10 = null;
        for (T t11 : iterable) {
            if (predicate.i(t11).booleanValue()) {
                t10 = t11;
            }
        }
        return t10;
    }

    @yt.k
    public static final <T, R> List<R> s3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(t.Y(iterable, 10));
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList.add(transform.i(it2.next()));
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, C extends Iterable<? extends T>> C s4(@yt.k C c10, @yt.k ik.p<? super Integer, ? super T, z1> action) {
        kotlin.jvm.internal.f0.p(c10, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int i10 = 0;
        for (T t10 : c10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            action.r0(Integer.valueOf(i10), t10);
            i10 = i11;
        }
        return c10;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> double s5(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it2.hasNext()) {
            dDoubleValue += selector.i(it2.next()).doubleValue();
        }
        return dDoubleValue;
    }

    public static final <T> boolean t1(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    @bk.f
    public static final <T> T t2(List<? extends T> list, ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (predicate.i(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    @yt.k
    public static final <T, R> List<R> t3(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(t.Y(iterable, 10));
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            arrayList.add(transform.r0(Integer.valueOf(i10), t10));
            i10 = i11;
        }
        return arrayList;
    }

    @yt.k
    public static final <T> Pair<List<T>, List<T>> t4(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t10 : iterable) {
            if (predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
            } else {
                arrayList2.add(t10);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @hk.h(name = "sumOfByte")
    public static final int t5(@yt.k Iterable<Byte> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Byte> it2 = iterable.iterator();
        int iByteValue = 0;
        while (it2.hasNext()) {
            iByteValue += it2.next().byteValue();
        }
        return iByteValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <T> Iterable<T> u1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable;
    }

    public static final <T> T u2(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) w2((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @yt.k
    public static final <T, R> List<R> u3(@yt.k Iterable<? extends T> iterable, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T t10 : iterable) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            R rR0 = transform.r0(Integer.valueOf(i10), t10);
            if (rR0 != null) {
                arrayList.add(rR0);
            }
            i10 = i11;
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> u4(@yt.k Iterable<? extends T> iterable, @yt.k Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (iterable instanceof Collection) {
            return y4((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        x.n0(arrayList, iterable);
        x.n0(arrayList, elements);
        return arrayList;
    }

    @hk.h(name = "sumOfDouble")
    public static final double u5(@yt.k Iterable<Double> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Double> it2 = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it2.hasNext()) {
            dDoubleValue += it2.next().doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final <T> kotlin.sequences.m<T> v1(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return new a(iterable);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T v2(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : iterable) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C v3(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
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
    public static final <T> List<T> v4(@yt.k Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return z4((Collection) iterable, t10);
        }
        ArrayList arrayList = new ArrayList();
        x.n0(arrayList, iterable);
        arrayList.add(t10);
        return arrayList;
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> double v5(Iterable<? extends T> iterable, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it2.hasNext()) {
            dDoubleValue += selector.i(it2.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final <T, K, V> Map<K, V> w1(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(t.Y(iterable, 10)), 16));
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            Pair<? extends K, ? extends V> pairI = transform.i(it2.next());
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    public static final <T> T w2(@yt.k List<? extends T> list) {
        kotlin.jvm.internal.f0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C w3(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int i10 = 0;
        for (T t10 : iterable) {
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
    public static final <T> List<T> w4(@yt.k Iterable<? extends T> iterable, @yt.k kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        ArrayList arrayList = new ArrayList();
        x.n0(arrayList, iterable);
        x.o0(arrayList, elements);
        return arrayList;
    }

    @hk.h(name = "sumOfFloat")
    public static final float w5(@yt.k Iterable<Float> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Float> it2 = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it2.hasNext()) {
            fFloatValue += it2.next().floatValue();
        }
        return fFloatValue;
    }

    @yt.k
    public static final <T, K> Map<K, T> x1(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(t.Y(iterable, 10)), 16));
        for (T t10 : iterable) {
            linkedHashMap.put(keySelector.i(t10), t10);
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.5")
    public static final <T, R> R x2(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> transform) {
        R rI;
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
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
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    @yt.k
    public static final <T, R> List<R> x3(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                arrayList.add(rI);
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> x4(@yt.k Iterable<? extends T> iterable, @yt.k T[] elements) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (iterable instanceof Collection) {
            return B4((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        x.n0(arrayList, iterable);
        x.p0(arrayList, elements);
        return arrayList;
    }

    @hk.h(name = "sumOfInt")
    public static final int x5(@yt.k Iterable<Integer> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Integer> it2 = iterable.iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += it2.next().intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final <T, K, V> Map<K, V> y1(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(t.Y(iterable, 10)), 16));
        for (T t10 : iterable) {
            linkedHashMap.put(keySelector.i(t10), valueTransform.i(t10));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.5")
    public static final <T, R> R y2(Iterable<? extends T> iterable, ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                return rI;
            }
        }
        return null;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C y3(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                destination.add(rI);
            }
        }
        return destination;
    }

    @yt.k
    public static final <T> List<T> y4(@yt.k Collection<? extends T> collection, @yt.k Iterable<? extends T> elements) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            x.n0(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> int y5(Iterable<? extends T> iterable, ik.l<? super T, Integer> selector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += selector.i(it2.next()).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final <T, K, M extends Map<? super K, ? super T>> M z1(@yt.k Iterable<? extends T> iterable, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (T t10 : iterable) {
            destination.put(keySelector.i(t10), t10);
        }
        return destination;
    }

    @yt.l
    public static final <T> T z2(@yt.k Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        return null;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C z3(@yt.k Iterable<? extends T> iterable, @yt.k C destination, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<? extends T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            destination.add(transform.i(it2.next()));
        }
        return destination;
    }

    @yt.k
    public static final <T> List<T> z4(@yt.k Collection<? extends T> collection, T t10) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    @hk.h(name = "sumOfLong")
    public static final long z5(@yt.k Iterable<Long> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<Long> it2 = iterable.iterator();
        long jLongValue = 0;
        while (it2.hasNext()) {
            jLongValue += it2.next().longValue();
        }
        return jLongValue;
    }
}
