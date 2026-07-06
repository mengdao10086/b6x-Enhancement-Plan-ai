package a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ha<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ha<K, V>.b f6291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ha<K, V>.c f1143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ha<K, V>.e f1144a;

    public final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6292a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f1146b = false;
        public int c;

        public a(int i) {
            this.f6292a = i;
            this.b = ha.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) ha.this.b(this.c, this.f6292a);
            this.c++;
            this.f1146b = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f1146b) {
                throw new IllegalStateException();
            }
            int i = this.c - 1;
            this.c = i;
            this.b--;
            this.f1146b = false;
            ha.this.h(i);
        }
    }

    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iD = ha.this.d();
            for (Map.Entry<K, V> entry : collection) {
                ha.this.g(entry.getKey(), entry.getValue());
            }
            return iD != ha.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            ha.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iE = ha.this.e(entry.getKey());
            if (iE < 0) {
                return false;
            }
            return ea.c(ha.this.b(iE, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return ha.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = ha.this.d() - 1; iD >= 0; iD--) {
                Object objB = ha.this.b(iD, 0);
                Object objB2 = ha.this.b(iD, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return ha.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return ha.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            ha.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return ha.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return ha.j(ha.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return ha.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = ha.this.d() - 1; iD >= 0; iD--) {
                Object objB = ha.this.b(iD, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return ha.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = ha.this.e(obj);
            if (iE < 0) {
                return false;
            }
            ha.this.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return ha.o(ha.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return ha.p(ha.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return ha.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return ha.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ha.this.r(tArr, 0);
        }
    }

    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6295a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f1148b = false;
        public int b = -1;

        public d() {
            this.f6295a = ha.this.d() - 1;
        }

        public Map.Entry<K, V> a() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.b++;
            this.f1148b = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f1148b) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return ea.c(entry.getKey(), ha.this.b(this.b, 0)) && ea.c(entry.getValue(), ha.this.b(this.b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f1148b) {
                return (K) ha.this.b(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f1148b) {
                return (V) ha.this.b(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.f6295a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f1148b) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = ha.this.b(this.b, 0);
            Object objB2 = ha.this.b(this.b, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f1148b) {
                throw new IllegalStateException();
            }
            ha.this.h(this.b);
            this.b--;
            this.f6295a--;
            this.f1148b = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f1148b) {
                return (V) ha.this.i(this.b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            ha.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return ha.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return ha.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iF = ha.this.f(obj);
            if (iF < 0) {
                return false;
            }
            ha.this.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iD = ha.this.d();
            int i = 0;
            boolean z = false;
            while (i < iD) {
                if (collection.contains(ha.this.b(i, 1))) {
                    ha.this.h(i);
                    i--;
                    iD--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iD = ha.this.d();
            int i = 0;
            boolean z = false;
            while (i < iD) {
                if (!collection.contains(ha.this.b(i, 1))) {
                    ha.this.h(i);
                    i--;
                    iD--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return ha.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return ha.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ha.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i);

    public abstract V i(int i, V v);

    public Set<Map.Entry<K, V>> l() {
        if (this.f6291a == null) {
            this.f6291a = new b();
        }
        return this.f6291a;
    }

    public Set<K> m() {
        if (this.f1143a == null) {
            this.f1143a = new c();
        }
        return this.f1143a;
    }

    public Collection<V> n() {
        if (this.f1144a == null) {
            this.f1144a = new e();
        }
        return this.f1144a;
    }

    public Object[] q(int i) {
        int iD = d();
        Object[] objArr = new Object[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i) {
        int iD = d();
        if (tArr.length < iD) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iD));
        }
        for (int i2 = 0; i2 < iD; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > iD) {
            tArr[iD] = null;
        }
        return tArr;
    }
}
