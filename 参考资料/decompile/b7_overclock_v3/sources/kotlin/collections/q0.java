package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n330#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n*L\n24#1:105,6\n*E\n"})
public class q0 {
    @hk.h(name = "getOrImplicitDefaultNullable")
    @kotlin.s0
    public static final <K, V> V a(@yt.k Map<K, ? extends V> map, K k10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        if (map instanceof n0) {
            return (V) ((n0) map).i(k10);
        }
        V v10 = map.get(k10);
        if (v10 != null || map.containsKey(k10)) {
            return v10;
        }
        throw new NoSuchElementException("Key " + k10 + " is missing in the map.");
    }

    @yt.k
    public static final <K, V> Map<K, V> b(@yt.k Map<K, ? extends V> map, @yt.k ik.l<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return map instanceof n0 ? b(((n0) map).f(), defaultValue) : new o0(map, defaultValue);
    }

    @hk.h(name = "withDefaultMutable")
    @yt.k
    public static final <K, V> Map<K, V> c(@yt.k Map<K, V> map, @yt.k ik.l<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return map instanceof w0 ? c(((w0) map).f(), defaultValue) : new x0(map, defaultValue);
    }
}
