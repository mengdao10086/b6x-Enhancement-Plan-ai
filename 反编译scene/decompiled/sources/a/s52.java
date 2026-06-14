package a;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class s52 extends r52 {
    public static final int a(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> b(d42<? extends K, ? extends V> d42Var) {
        f92.d(d42Var, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(d42Var.c(), d42Var.d());
        f92.c(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        f92.d(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        f92.c(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
