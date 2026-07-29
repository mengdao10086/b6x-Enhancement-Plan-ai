package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.v0(version = "1.1")
public abstract class e<K, V> extends java.util.AbstractMap<K, V> implements Map<K, V>, jk.g {
    public abstract Set a();

    public /* bridge */ Set<Object> b() {
        return super.keySet();
    }

    public /* bridge */ int d() {
        return super.size();
    }

    public /* bridge */ Collection<Object> e() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @yt.l
    public abstract V put(K k10, V v10);

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) e();
    }
}
