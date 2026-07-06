package a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e9<K, V> extends i9<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<K, h9<K, V>> f5979a = new HashMap<>();

    @Override // a.i9
    public h9<K, V> c(K k) {
        return this.f5979a.get(k);
    }

    public boolean contains(K k) {
        return this.f5979a.containsKey(k);
    }

    @Override // a.i9
    public V g(K k) {
        V v = (V) super.g(k);
        this.f5979a.remove(k);
        return v;
    }

    public Map.Entry<K, V> h(K k) {
        if (contains(k)) {
            return this.f5979a.get(k).b;
        }
        return null;
    }

    public V i(K k, V v) {
        h9<K, V> h9VarC = c(k);
        if (h9VarC != null) {
            return h9VarC.f1139b;
        }
        this.f5979a.put(k, f(k, v));
        return null;
    }
}
