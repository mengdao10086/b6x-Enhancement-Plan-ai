package o;

import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.util.HashMap;
import java.util.Map;
import o.b;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<K, b.c<K, V>> f42677e = new HashMap<>();

    @Override // o.b
    @p0
    public b.c<K, V> b(K k10) {
        return this.f42677e.get(k10);
    }

    public boolean contains(K k10) {
        return this.f42677e.containsKey(k10);
    }

    @Override // o.b
    public V g(@n0 K k10, @n0 V v10) {
        b.c<K, V> cVarB = b(k10);
        if (cVarB != null) {
            return cVarB.f42683b;
        }
        this.f42677e.put(k10, f(k10, v10));
        return null;
    }

    @Override // o.b
    public V i(@n0 K k10) {
        V v10 = (V) super.i(k10);
        this.f42677e.remove(k10);
        return v10;
    }

    @p0
    public Map.Entry<K, V> j(K k10) {
        if (contains(k10)) {
            return this.f42677e.get(k10).f42685d;
        }
        return null;
    }
}
