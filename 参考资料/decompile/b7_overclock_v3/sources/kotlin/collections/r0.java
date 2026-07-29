package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMapsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
public class r0 extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f37738a = 1073741824;

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <K, V> Map<K, V> d(@yt.k Map<K, V> builder) {
        kotlin.jvm.internal.f0.p(builder, "builder");
        return ((MapBuilder) builder).o();
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final <K, V> Map<K, V> e(int i10, ik.l<? super Map<K, V>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Map mapH = h(i10);
        builderAction.i(mapH);
        return d(mapH);
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final <K, V> Map<K, V> f(ik.l<? super Map<K, V>, z1> builderAction) {
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        Map mapG = g();
        builderAction.i(mapG);
        return d(mapG);
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <K, V> Map<K, V> g() {
        return new MapBuilder();
    }

    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <K, V> Map<K, V> h(int i10) {
        return new MapBuilder(i10);
    }

    public static final <K, V> V i(@yt.k ConcurrentMap<K, V> concurrentMap, K k10, @yt.k ik.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(concurrentMap, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v10 = concurrentMap.get(k10);
        if (v10 != null) {
            return v10;
        }
        V vO = defaultValue.o();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k10, vO);
        return vPutIfAbsent == null ? vO : vPutIfAbsent;
    }

    @kotlin.s0
    public static final int j(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @yt.k
    public static final <K, V> Map<K, V> k(@yt.k Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.f0.p(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.f(), pair.h());
        kotlin.jvm.internal.f0.o(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <K, V> SortedMap<K, V> l(@yt.k Comparator<? super K> comparator, @yt.k Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        s0.y0(treeMap, pairs);
        return treeMap;
    }

    @yt.k
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m(@yt.k Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        s0.y0(treeMap, pairs);
        return treeMap;
    }

    @bk.f
    public static final Properties n(Map<String, String> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @yt.k
    public static final <K, V> Map<K, V> o(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.f0.o(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    @bk.f
    public static final <K, V> Map<K, V> p(Map<K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return o(map);
    }

    @yt.k
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> q(@yt.k Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return new TreeMap(map);
    }

    @yt.k
    public static final <K, V> SortedMap<K, V> r(@yt.k Map<? extends K, ? extends V> map, @yt.k Comparator<? super K> comparator) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
