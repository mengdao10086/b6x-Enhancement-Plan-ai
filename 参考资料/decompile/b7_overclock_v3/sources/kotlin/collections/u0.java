package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\n_Maps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,594:1\n96#1,5:595\n111#1,5:600\n152#1,3:605\n143#1:608\n215#1:609\n216#1:611\n144#1:612\n215#1:613\n216#1:615\n1#2:610\n1#2:614\n1940#3,14:616\n1963#3,14:630\n2310#3,14:644\n2333#3,14:658\n1864#3,3:672\n*S KotlinDebug\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n76#1:595,5\n89#1:600,5\n125#1:605,3\n135#1:608\n135#1:609\n135#1:611\n135#1:612\n143#1:613\n143#1:615\n135#1:610\n230#1:616,14\n241#1:630,14\n390#1:644,14\n401#1:658,14\n574#1:672,3\n*E\n"})
public class u0 extends t0 {
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> Float A1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = selector.i((Object) it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i((Object) it2.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R> R B1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R> R C1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (comparator.compare(rI, rI2) > 0) {
                rI = (Object) rI2;
            }
        }
        return rI;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> Map.Entry<K, V> D1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.i4(map.entrySet(), comparator);
    }

    @hk.h(name = "minWithOrThrow")
    @bk.f
    @kotlin.v0(version = "1.7")
    public static final <K, V> Map.Entry<K, V> E1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.j4(map.entrySet(), comparator);
    }

    public static final <K, V> boolean F1(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean G1(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V, M extends Map<? extends K, ? extends V>> M H1(@yt.k M m10, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, z1> action) {
        kotlin.jvm.internal.f0.p(m10, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Iterator<Map.Entry<K, V>> it2 = m10.entrySet().iterator();
        while (it2.hasNext()) {
            action.i(it2.next());
        }
        return m10;
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <K, V, M extends Map<? extends K, ? extends V>> M I1(@yt.k M m10, @yt.k ik.p<? super Integer, ? super Map.Entry<? extends K, ? extends V>, z1> action) {
        kotlin.jvm.internal.f0.p(m10, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Iterator<T> it2 = m10.entrySet().iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            a0.c cVar = (Object) it2.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            action.r0(Integer.valueOf(i10), cVar);
            i10 = i11;
        }
        return m10;
    }

    @yt.k
    public static final <K, V> List<Pair<K, V>> J1(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        if (map.size() == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.E();
        }
        Map.Entry<? extends K, ? extends V> next = it2.next();
        if (!it2.hasNext()) {
            return s.k(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it2.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it2.hasNext());
        return arrayList;
    }

    public static final <K, V> boolean P0(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            if (!predicate.i(it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean Q0(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean R0(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @bk.f
    public static final <K, V> Iterable<Map.Entry<K, V>> S0(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.entrySet();
    }

    @yt.k
    public static final <K, V> kotlin.sequences.m<Map.Entry<K, V>> T0(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return CollectionsKt___CollectionsKt.v1(map.entrySet());
    }

    @bk.f
    public static final <K, V> int U0(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.size();
    }

    public static final <K, V> int V0(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            if (predicate.i(it2.next()).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @bk.f
    @kotlin.v0(version = "1.5")
    public static final <K, V, R> R W0(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        R rI;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
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
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @bk.f
    @kotlin.v0(version = "1.5")
    public static final <K, V, R> R X0(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                return rI;
            }
        }
        return null;
    }

    @yt.k
    public static final <K, V, R> List<R> Y0(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            x.n0(arrayList, transform.i(it2.next()));
        }
        return arrayList;
    }

    @hk.h(name = "flatMapSequence")
    @kotlin.m0
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <K, V, R> List<R> Z0(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            x.o0(arrayList, transform.i(it2.next()));
        }
        return arrayList;
    }

    @hk.h(name = "flatMapSequenceTo")
    @kotlin.m0
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <K, V, R, C extends Collection<? super R>> C a1(@yt.k Map<? extends K, ? extends V> map, @yt.k C destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            x.o0(destination, transform.i(it2.next()));
        }
        return destination;
    }

    @yt.k
    public static final <K, V, R, C extends Collection<? super R>> C b1(@yt.k Map<? extends K, ? extends V> map, @yt.k C destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            x.n0(destination, transform.i(it2.next()));
        }
        return destination;
    }

    @bk.e
    public static final <K, V> void c1(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, z1> action) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            action.i(it2.next());
        }
    }

    @yt.k
    public static final <K, V, R> List<R> d1(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add(transform.i(it2.next()));
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V, R> List<R> e1(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                arrayList.add(rI);
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V, R, C extends Collection<? super R>> C f1(@yt.k Map<? extends K, ? extends V> map, @yt.k C destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            R rI = transform.i(it2.next());
            if (rI != null) {
                destination.add(rI);
            }
        }
        return destination;
    }

    @yt.k
    public static final <K, V, R, C extends Collection<? super R>> C g1(@yt.k Map<? extends K, ? extends V> map, @yt.k C destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            destination.add(transform.i(it2.next()));
        }
        return destination;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> h1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it2.next();
            if (it2.hasNext()) {
                R rI = selector.i(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it2.next();
                    R rI2 = selector.i(entry3);
                    if (rI.compareTo(rI2) < 0) {
                        entry2 = entry3;
                        rI = rI2;
                    }
                } while (it2.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @hk.h(name = "maxByOrThrow")
    @bk.f
    @kotlin.v0(version = "1.7")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> i1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it2.next();
        if (it2.hasNext()) {
            R rI = selector.i(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it2.next();
                R rI2 = selector.i(entry2);
                if (rI.compareTo(rI2) < 0) {
                    entry = entry2;
                    rI = rI2;
                }
            } while (it2.hasNext());
        }
        return entry;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> double j1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i((Object) it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i((Object) it2.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> float k1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i((Object) it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i((Object) it2.next()).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R extends Comparable<? super R>> R l1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R extends Comparable<? super R>> R m1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> Double n1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.i((Object) it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i((Object) it2.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> Float o1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float fFloatValue = selector.i((Object) it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i((Object) it2.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R> R p1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R> R q1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (comparator.compare(rI, rI2) < 0) {
                rI = (Object) rI2;
            }
        }
        return rI;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> Map.Entry<K, V> r1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.Q3(map.entrySet(), comparator);
    }

    @hk.h(name = "maxWithOrThrow")
    @bk.f
    @kotlin.v0(version = "1.7")
    public static final <K, V> Map.Entry<K, V> s1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.R3(map.entrySet(), comparator);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> t1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it2.next();
            if (it2.hasNext()) {
                R rI = selector.i(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it2.next();
                    R rI2 = selector.i(entry3);
                    if (rI.compareTo(rI2) > 0) {
                        entry2 = entry3;
                        rI = rI2;
                    }
                } while (it2.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @hk.h(name = "minByOrThrow")
    @bk.f
    @kotlin.v0(version = "1.7")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> u1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it2.next();
        if (it2.hasNext()) {
            R rI = selector.i(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it2.next();
                R rI2 = selector.i(entry2);
                if (rI.compareTo(rI2) > 0) {
                    entry = entry2;
                    rI = rI2;
                }
            } while (it2.hasNext());
        }
        return entry;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> double v1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i((Object) it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i((Object) it2.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> float w1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i((Object) it2.next()).floatValue();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i((Object) it2.next()).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R extends Comparable<? super R>> R x1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V, R extends Comparable<? super R>> R y1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R rI = selector.i((Object) it2.next());
        while (it2.hasNext()) {
            R rI2 = selector.i((Object) it2.next());
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <K, V> Double z1(Map<? extends K, ? extends V> map, ik.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.i((Object) it2.next()).doubleValue();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i((Object) it2.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }
}
