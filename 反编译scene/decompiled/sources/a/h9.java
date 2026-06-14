package a;

import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h9<K, V> implements Map.Entry<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h9<K, V> f6287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final K f1138a;
    public h9<K, V> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final V f1139b;

    public h9(K k, V v) {
        this.f1138a = k;
        this.f1139b = v;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h9)) {
            return false;
        }
        h9 h9Var = (h9) obj;
        return this.f1138a.equals(h9Var.f1138a) && this.f1139b.equals(h9Var.f1139b);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.f1138a;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.f1139b;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return this.f1138a.hashCode() ^ this.f1139b.hashCode();
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public String toString() {
        return this.f1138a + "=" + this.f1139b;
    }
}
