package androidx.collection;

import g.p0;
import hb.u;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public k<K, V>.b f2845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public k<K, V>.c f2846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public k<K, V>.e f2847c;

    public final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2851d = false;

        public a(int i10) {
            this.f2848a = i10;
            this.f2849b = k.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2850c < this.f2849b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t10 = (T) k.this.b(this.f2850c, this.f2848a);
            this.f2850c++;
            this.f2851d = true;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2851d) {
                throw new IllegalStateException();
            }
            int i10 = this.f2850c - 1;
            this.f2850c = i10;
            this.f2849b--;
            this.f2851d = false;
            k.this.h(i10);
        }
    }

    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iD = k.this.d();
            for (Map.Entry<K, V> entry : collection) {
                k.this.g(entry.getKey(), entry.getValue());
            }
            return iD != k.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            k.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iE = k.this.e(entry.getKey());
            if (iE < 0) {
                return false;
            }
            return g.c(k.this.b(iE, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!contains(it2.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return k.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = k.this.d() - 1; iD >= 0; iD--) {
                Object objB = k.this.b(iD, 0);
                Object objB2 = k.this.b(iD, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return k.this.d() == 0;
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
            return k.this.d();
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
        public boolean add(K k10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            k.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return k.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return k.j(k.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return k.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = k.this.d() - 1; iD >= 0; iD--) {
                Object objB = k.this.b(iD, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return k.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = k.this.e(obj);
            if (iE < 0) {
                return false;
            }
            k.this.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return k.o(k.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return k.p(k.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return k.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return k.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) k.this.r(tArr, 0);
        }
    }

    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2855a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2857c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2856b = -1;

        public d() {
            this.f2855a = k.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2856b++;
            this.f2857c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f2857c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return g.c(entry.getKey(), k.this.b(this.f2856b, 0)) && g.c(entry.getValue(), k.this.b(this.f2856b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f2857c) {
                return (K) k.this.b(this.f2856b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f2857c) {
                return (V) k.this.b(this.f2856b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2856b < this.f2855a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f2857c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = k.this.b(this.f2856b, 0);
            Object objB2 = k.this.b(this.f2856b, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2857c) {
                throw new IllegalStateException();
            }
            k.this.h(this.f2856b);
            this.f2856b--;
            this.f2855a--;
            this.f2857c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (this.f2857c) {
                return (V) k.this.i(this.f2856b, v10);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + u.f30904o + getValue();
        }
    }

    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            k.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return k.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!contains(it2.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return k.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iF = k.this.f(obj);
            if (iF < 0) {
                return false;
            }
            k.this.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iD = k.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < iD) {
                if (collection.contains(k.this.b(i10, 1))) {
                    k.this.h(i10);
                    i10--;
                    iD--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iD = k.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < iD) {
                if (!collection.contains(k.this.b(i10, 1))) {
                    k.this.h(i10);
                    i10--;
                    iD--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public int size() {
            return k.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return k.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) k.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!map.containsKey(it2.next())) {
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
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            map.remove(it2.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i10, int i11);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k10, V v10);

    public abstract void h(int i10);

    public abstract V i(int i10, V v10);

    public Set<Map.Entry<K, V>> l() {
        if (this.f2845a == null) {
            this.f2845a = new b();
        }
        return this.f2845a;
    }

    public Set<K> m() {
        if (this.f2846b == null) {
            this.f2846b = new c();
        }
        return this.f2846b;
    }

    public Collection<V> n() {
        if (this.f2847c == null) {
            this.f2847c = new e();
        }
        return this.f2847c;
    }

    public Object[] q(int i10) {
        int iD = d();
        Object[] objArr = new Object[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            objArr[i11] = b(i11, i10);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i10) {
        int iD = d();
        if (tArr.length < iD) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iD));
        }
        for (int i11 = 0; i11 < iD; i11++) {
            tArr[i11] = b(i11, i10);
        }
        if (tArr.length > iD) {
            tArr[iD] = null;
        }
        return tArr;
    }
}
