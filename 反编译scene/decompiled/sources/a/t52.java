package a;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class t52 extends s52 {
    public static final <K, V> Map<K, V> d() {
        l52 l52Var = l52.f6676a;
        if (l52Var != null) {
            return l52Var;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <K, V> LinkedHashMap<K, V> e(d42<? extends K, ? extends V>... d42VarArr) {
        f92.d(d42VarArr, "pairs");
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>(s52.a(d42VarArr.length));
        l(d42VarArr, linkedHashMap);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> f(d42<? extends K, ? extends V>... d42VarArr) {
        f92.d(d42VarArr, "pairs");
        if (d42VarArr.length <= 0) {
            return d();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(s52.a(d42VarArr.length));
        l(d42VarArr, linkedHashMap);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> g(Map<K, ? extends V> map) {
        f92.d(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        return size != 0 ? size != 1 ? map : s52.c(map) : d();
    }

    public static final <K, V> void h(Map<? super K, ? super V> map, Iterable<? extends d42<? extends K, ? extends V>> iterable) {
        f92.d(map, "$this$putAll");
        f92.d(iterable, "pairs");
        for (d42<? extends K, ? extends V> d42Var : iterable) {
            map.put(d42Var.a(), d42Var.b());
        }
    }

    public static final <K, V> void i(Map<? super K, ? super V> map, d42<? extends K, ? extends V>[] d42VarArr) {
        f92.d(map, "$this$putAll");
        f92.d(d42VarArr, "pairs");
        for (d42<? extends K, ? extends V> d42Var : d42VarArr) {
            map.put(d42Var.a(), d42Var.b());
        }
    }

    public static final <K, V> Map<K, V> j(Iterable<? extends d42<? extends K, ? extends V>> iterable) {
        f92.d(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            k(iterable, linkedHashMap);
            return g(linkedHashMap);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size == 1) {
            return s52.b(iterable instanceof List ? (d42<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(s52.a(collection.size()));
        k(iterable, linkedHashMap2);
        return linkedHashMap2;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M k(Iterable<? extends d42<? extends K, ? extends V>> iterable, M m) {
        f92.d(iterable, "$this$toMap");
        f92.d(m, "destination");
        h(m, iterable);
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M l(d42<? extends K, ? extends V>[] d42VarArr, M m) {
        f92.d(d42VarArr, "$this$toMap");
        f92.d(m, "destination");
        i(m, d42VarArr);
        return m;
    }

    public static final <K, V> Map<K, V> m(Map<? extends K, ? extends V> map) {
        f92.d(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }
}
