package a;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ba<K, V> extends ia<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ha<K, V> f5686a;

    public ba() {
    }

    public ba(int i) {
        super(i);
    }

    public ba(ia iaVar) {
        super(iaVar);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public final ha<K, V> n() {
        if (this.f5686a == null) {
            this.f5686a = new aa(this);
        }
        return this.f5686a;
    }

    public boolean o(Collection<?> collection) {
        return ha.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(((ia) this).f6390a + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }
}
