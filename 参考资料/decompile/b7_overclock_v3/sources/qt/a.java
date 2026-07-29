package qt;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<K, V, C extends Collection<V>> implements Map<K, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<K, C> f47620a;

    public a(Map<K, C> map) {
        this.f47620a = map;
    }

    public synchronized boolean a(V v10) {
        Iterator<C> it2 = this.f47620a.values().iterator();
        while (it2.hasNext()) {
            if (it2.next().contains(v10)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean b(K k10, V v10) {
        C c10 = this.f47620a.get(k10);
        if (c10 == null) {
            return false;
        }
        return c10.contains(v10);
    }

    public synchronized int c() {
        int size;
        size = 0;
        Iterator<C> it2 = this.f47620a.values().iterator();
        while (it2.hasNext()) {
            size += it2.next().size();
        }
        return size;
    }

    @Override // java.util.Map
    public synchronized void clear() {
        this.f47620a.clear();
    }

    @Override // java.util.Map
    public synchronized boolean containsKey(Object obj) {
        return this.f47620a.containsKey(obj);
    }

    @Override // java.util.Map
    public synchronized boolean containsValue(Object obj) {
        return this.f47620a.containsValue(obj);
    }

    public synchronized int d(K k10) {
        C c10 = this.f47620a.get(k10);
        if (c10 == null) {
            return 0;
        }
        return c10.size();
    }

    public abstract C e();

    @Override // java.util.Map
    public synchronized Set<Map.Entry<K, C>> entrySet() {
        return this.f47620a.entrySet();
    }

    @Override // java.util.Map
    public synchronized boolean equals(Object obj) {
        return this.f47620a.equals(obj);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized C get(Object obj) {
        return this.f47620a.get(obj);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized C put(K k10, C c10) {
        return this.f47620a.put(k10, c10);
    }

    @Override // java.util.Map
    public synchronized int hashCode() {
        return this.f47620a.hashCode();
    }

    @Override // java.util.Map
    public synchronized boolean isEmpty() {
        return this.f47620a.isEmpty();
    }

    public synchronized int j(K k10, V v10) {
        C cE;
        cE = this.f47620a.get(k10);
        if (cE == null) {
            cE = e();
            this.f47620a.put(k10, (C) cE);
        }
        cE.add(v10);
        return cE.size();
    }

    public synchronized boolean k(K k10, Collection<V> collection) {
        C cE;
        cE = this.f47620a.get(k10);
        if (cE == null) {
            cE = e();
            this.f47620a.put(k10, (C) cE);
        }
        return cE.addAll(collection);
    }

    @Override // java.util.Map
    public synchronized Set<K> keySet() {
        return this.f47620a.keySet();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public synchronized C remove(Object obj) {
        return this.f47620a.remove(obj);
    }

    public synchronized boolean m(K k10, V v10) {
        C c10 = this.f47620a.get(k10);
        if (c10 == null) {
            return false;
        }
        boolean zRemove = c10.remove(v10);
        if (c10.isEmpty()) {
            this.f47620a.remove(k10);
        }
        return zRemove;
    }

    public synchronized C n() {
        C c10;
        c10 = (C) e();
        Iterator<C> it2 = this.f47620a.values().iterator();
        while (it2.hasNext()) {
            c10.addAll(it2.next());
        }
        return c10;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends C> map) {
        this.f47620a.putAll(map);
    }

    @Override // java.util.Map
    public synchronized int size() {
        return this.f47620a.size();
    }

    @Override // java.util.Map
    public synchronized Collection<C> values() {
        return this.f47620a.values();
    }
}
