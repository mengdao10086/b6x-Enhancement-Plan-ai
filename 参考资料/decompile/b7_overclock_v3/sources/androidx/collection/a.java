package androidx.collection;

import g.n0;
import g.p0;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a<K, V> extends l<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public k<K, V> f2800m;

    /* JADX INFO: renamed from: androidx.collection.a$a, reason: collision with other inner class name */
    public class C0035a extends k<K, V> {
        public C0035a() {
        }

        @Override // androidx.collection.k
        public void a() {
            a.this.clear();
        }

        @Override // androidx.collection.k
        public Object b(int i10, int i11) {
            return a.this.f2870b[(i10 << 1) + i11];
        }

        @Override // androidx.collection.k
        public Map<K, V> c() {
            return a.this;
        }

        @Override // androidx.collection.k
        public int d() {
            return a.this.f2871c;
        }

        @Override // androidx.collection.k
        public int e(Object obj) {
            return a.this.g(obj);
        }

        @Override // androidx.collection.k
        public int f(Object obj) {
            return a.this.j(obj);
        }

        @Override // androidx.collection.k
        public void g(K k10, V v10) {
            a.this.put(k10, v10);
        }

        @Override // androidx.collection.k
        public void h(int i10) {
            a.this.m(i10);
        }

        @Override // androidx.collection.k
        public V i(int i10, V v10) {
            return a.this.n(i10, v10);
        }
    }

    public a() {
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return q().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return q().m();
    }

    public boolean p(@n0 Collection<?> collection) {
        return k.j(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f2871c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final k<K, V> q() {
        if (this.f2800m == null) {
            this.f2800m = new C0035a();
        }
        return this.f2800m;
    }

    public boolean r(@n0 Collection<?> collection) {
        return k.o(this, collection);
    }

    public boolean s(@n0 Collection<?> collection) {
        return k.p(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return q().n();
    }

    public a(int i10) {
        super(i10);
    }

    public a(l lVar) {
        super(lVar);
    }
}
