package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.c2;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,793:1\n392#1:803\n403#1:808\n500#1,6:813\n525#1,6:819\n1#2:794\n1238#3,4:795\n1238#3,4:799\n1238#3,4:804\n1238#3,4:809\n*S KotlinDebug\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n442#1:803\n457#1:808\n515#1:813,6\n540#1:819,6\n392#1:795,4\n403#1:799,4\n442#1:804,4\n457#1:809,4\n*E\n"})
public class s0 extends r0 {
    @yt.k
    public static final <K, V> Map<K, V> A(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.i(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @bk.f
    public static final <K, V> void A0(Map<K, V> map, K k10, V v10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        map.put(k10, v10);
    }

    @yt.k
    public static final <K, V> Map<K, V> B(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super K, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.i(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V> Map<K, V> B0(@yt.k Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k0(C0(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z();
        }
        if (size != 1) {
            return C0(iterable, new LinkedHashMap(r0.j(collection.size())));
        }
        return r0.k(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    @yt.k
    public static final <K, V> Map<K, V> C(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.i(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M C0(@yt.k Iterable<? extends Pair<? extends K, ? extends V>> iterable, @yt.k M destination) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        w0(destination, iterable);
        return destination;
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M D(@yt.k Map<? extends K, ? extends V> map, @yt.k M destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.i(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V> Map<K, V> D0(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? J0(map) : r0.o(map) : z();
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M E(@yt.k Map<? extends K, ? extends V> map, @yt.k M destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.i(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M E0(@yt.k Map<? extends K, ? extends V> map, @yt.k M destination) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        destination.putAll(map);
        return destination;
    }

    @yt.k
    public static final <K, V> Map<K, V> F(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super V, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.i(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V> Map<K, V> F0(@yt.k kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> mVar) {
        kotlin.jvm.internal.f0.p(mVar, "<this>");
        return k0(G0(mVar, new LinkedHashMap()));
    }

    @bk.f
    public static final <K, V> V G(Map<? extends K, ? extends V> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.get(k10);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M G0(@yt.k kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> mVar, @yt.k M destination) {
        kotlin.jvm.internal.f0.p(mVar, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        x0(destination, mVar);
        return destination;
    }

    @bk.f
    public static final <K, V> V H(Map<K, ? extends V> map, K k10, ik.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v10 = map.get(k10);
        return v10 == null ? defaultValue.o() : v10;
    }

    @yt.k
    public static final <K, V> Map<K, V> H0(@yt.k Pair<? extends K, ? extends V>[] pairArr) {
        kotlin.jvm.internal.f0.p(pairArr, "<this>");
        int length = pairArr.length;
        return length != 0 ? length != 1 ? I0(pairArr, new LinkedHashMap(r0.j(pairArr.length))) : r0.k(pairArr[0]) : z();
    }

    public static final <K, V> V I(@yt.k Map<K, ? extends V> map, K k10, @yt.k ik.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v10 = map.get(k10);
        return (v10 != null || map.containsKey(k10)) ? v10 : defaultValue.o();
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M I0(@yt.k Pair<? extends K, ? extends V>[] pairArr, @yt.k M destination) {
        kotlin.jvm.internal.f0.p(pairArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        y0(destination, pairArr);
        return destination;
    }

    public static final <K, V> V J(@yt.k Map<K, V> map, K k10, @yt.k ik.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v10 = map.get(k10);
        if (v10 != null) {
            return v10;
        }
        V vO = defaultValue.o();
        map.put(k10, vO);
        return vO;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V> Map<K, V> J0(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return new LinkedHashMap(map);
    }

    @kotlin.v0(version = "1.1")
    public static final <K, V> V K(@yt.k Map<K, ? extends V> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return (V) q0.a(map, k10);
    }

    @bk.f
    public static final <K, V> Pair<K, V> K0(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.f0.p(entry, "<this>");
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <K, V> HashMap<K, V> L() {
        return new HashMap<>();
    }

    @yt.k
    public static final <K, V> HashMap<K, V> M(@yt.k Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(r0.j(pairs.length));
        y0(map, pairs);
        return map;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Lik/a<+TR;>;)TR; */
    @bk.f
    @kotlin.v0(version = "1.3")
    public static final Object N(Map map, ik.a defaultValue) {
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return map.isEmpty() ? defaultValue.o() : map;
    }

    @bk.f
    public static final <K, V> boolean O(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return !map.isEmpty();
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final <K, V> boolean P(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @bk.f
    public static final <K, V> Iterator<Map.Entry<K, V>> Q(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <K, V> LinkedHashMap<K, V> R() {
        return new LinkedHashMap<>();
    }

    @yt.k
    public static final <K, V> LinkedHashMap<K, V> S(@yt.k Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        return (LinkedHashMap) I0(pairs, new LinkedHashMap(r0.j(pairs.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, R> Map<R, V> T(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r0.j(map.size()));
        Iterator<T> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Object) it2.next();
            linkedHashMap.put(transform.i(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, R, M extends Map<? super R, ? super V>> M U(@yt.k Map<? extends K, ? extends V> map, @yt.k M destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<T> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Object) it2.next();
            destination.put(transform.i(entry), entry.getValue());
        }
        return destination;
    }

    @bk.f
    public static final <K, V> Map<K, V> V() {
        return z();
    }

    @yt.k
    public static final <K, V> Map<K, V> W(@yt.k Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        return pairs.length > 0 ? I0(pairs, new LinkedHashMap(r0.j(pairs.length))) : z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, R> Map<K, R> X(@yt.k Map<? extends K, ? extends V> map, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r0.j(map.size()));
        Iterator<T> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Object) it2.next();
            linkedHashMap.put(entry.getKey(), transform.i(entry));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, R, M extends Map<? super K, ? super R>> M Y(@yt.k Map<? extends K, ? extends V> map, @yt.k M destination, @yt.k ik.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        Iterator<T> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Object) it2.next();
            destination.put(entry.getKey(), transform.i(entry));
        }
        return destination;
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V> Map<K, V> Z(@yt.k Map<? extends K, ? extends V> map, @yt.k Iterable<? extends K> keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        Map mapJ0 = J0(map);
        x.E0(mapJ0.keySet(), keys);
        return k0(mapJ0);
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V> Map<K, V> a0(@yt.k Map<? extends K, ? extends V> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        Map mapJ0 = J0(map);
        mapJ0.remove(k10);
        return k0(mapJ0);
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V> Map<K, V> b0(@yt.k Map<? extends K, ? extends V> map, @yt.k kotlin.sequences.m<? extends K> keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        Map mapJ0 = J0(map);
        x.G0(mapJ0.keySet(), keys);
        return k0(mapJ0);
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <K, V> Map<K, V> c0(@yt.k Map<? extends K, ? extends V> map, @yt.k K[] keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        Map mapJ0 = J0(map);
        x.H0(mapJ0.keySet(), keys);
        return k0(mapJ0);
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <K, V> void d0(Map<K, V> map, Iterable<? extends K> keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        x.E0(map.keySet(), keys);
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <K, V> void e0(Map<K, V> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        map.remove(k10);
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <K, V> void f0(Map<K, V> map, kotlin.sequences.m<? extends K> keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        x.G0(map.keySet(), keys);
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <K, V> void g0(Map<K, V> map, K[] keys) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(keys, "keys");
        x.H0(map.keySet(), keys);
    }

    @hk.h(name = "mutableIterator")
    @bk.f
    public static final <K, V> Iterator<Map.Entry<K, V>> h0(Map<K, V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @bk.f
    @kotlin.v0(version = "1.1")
    public static final <K, V> Map<K, V> i0() {
        return new LinkedHashMap();
    }

    @yt.k
    public static final <K, V> Map<K, V> j0(@yt.k Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r0.j(pairs.length));
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V> Map<K, V> k0(@yt.k Map<K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : r0.o(map) : z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <K, V> Map<K, V> l0(Map<K, ? extends V> map) {
        return map == 0 ? z() : map;
    }

    @yt.k
    public static final <K, V> Map<K, V> m0(@yt.k Map<? extends K, ? extends V> map, @yt.k Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        if (map.isEmpty()) {
            return B0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        w0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V> Map<K, V> n0(@yt.k Map<? extends K, ? extends V> map, @yt.k Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V> Map<K, V> o0(@yt.k Map<? extends K, ? extends V> map, @yt.k Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pair, "pair");
        if (map.isEmpty()) {
            return r0.k(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.f(), pair.h());
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V> Map<K, V> p0(@yt.k Map<? extends K, ? extends V> map, @yt.k kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        x0(linkedHashMap, pairs);
        return k0(linkedHashMap);
    }

    @yt.k
    public static final <K, V> Map<K, V> q0(@yt.k Map<? extends K, ? extends V> map, @yt.k Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        if (map.isEmpty()) {
            return H0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @bk.f
    public static final <K, V> void r0(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        w0(map, pairs);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.6")
    public static final <K, V> Map<K, V> s(int i10, @kotlin.b ik.l<? super Map<K, V>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Map mapH = r0.h(i10);
        builderAction.i(mapH);
        return r0.d(mapH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <K, V> void s0(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(map2, "map");
        map.putAll(map2);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.6")
    public static final <K, V> Map<K, V> t(@kotlin.b ik.l<? super Map<K, V>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Map mapG = r0.g();
        builderAction.i(mapG);
        return r0.d(mapG);
    }

    @bk.f
    public static final <K, V> void t0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pair, "pair");
        map.put(pair.f(), pair.h());
    }

    @bk.f
    public static final <K, V> K u(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.f0.p(entry, "<this>");
        return entry.getKey();
    }

    @bk.f
    public static final <K, V> void u0(Map<? super K, ? super V> map, kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        x0(map, pairs);
    }

    @bk.f
    public static final <K, V> V v(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.f0.p(entry, "<this>");
        return entry.getValue();
    }

    @bk.f
    public static final <K, V> void v0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        y0(map, pairs);
    }

    @bk.f
    public static final <K, V> boolean w(Map<? extends K, ? extends V> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.containsKey(k10);
    }

    public static final <K, V> void w0(@yt.k Map<? super K, ? super V> map, @yt.k Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    @bk.f
    public static final <K> boolean x(Map<? extends K, ?> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.containsKey(k10);
    }

    public static final <K, V> void x0(@yt.k Map<? super K, ? super V> map, @yt.k kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    @bk.f
    public static final <K, V> boolean y(Map<K, ? extends V> map, V v10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return map.containsValue(v10);
    }

    public static final <K, V> void y0(@yt.k Map<? super K, ? super V> map, @yt.k Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    @yt.k
    public static final <K, V> Map<K, V> z() {
        EmptyMap emptyMap = EmptyMap.f37668a;
        kotlin.jvm.internal.f0.n(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @bk.f
    public static final <K, V> V z0(Map<? extends K, V> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return (V) kotlin.jvm.internal.w0.k(map).remove(k10);
    }
}
