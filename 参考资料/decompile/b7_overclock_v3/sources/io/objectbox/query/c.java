package io.objectbox.query;

import io.objectbox.exception.DbException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class c<E> implements List<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ii.a<E> f32858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f32859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<E> f32860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f32861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f32862e;

    public class a implements ListIterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32863a;

        public a(int i10) {
            this.f32863a = i10;
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f32863a < c.this.f32861d;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f32863a > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            int i10 = this.f32863a;
            c cVar = c.this;
            if (i10 >= cVar.f32861d) {
                throw new NoSuchElementException();
            }
            E e10 = (E) cVar.get(i10);
            this.f32863a++;
            return e10;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f32863a;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i10 = this.f32863a;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f32863a = i11;
            return (E) c.this.get(i11);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f32863a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException();
        }
    }

    public c(ii.a<E> aVar, long[] jArr, boolean z10) {
        if (aVar == null || jArr == null) {
            throw new NullPointerException("Illegal null parameters passed");
        }
        this.f32858a = aVar;
        this.f32859b = jArr;
        int length = jArr.length;
        this.f32861d = length;
        if (!z10) {
            this.f32860c = null;
            return;
        }
        this.f32860c = new ArrayList(length);
        for (int i10 = 0; i10 < this.f32861d; i10++) {
            this.f32860c.add(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        for (int i10 = 0; i10 < this.f32861d; i10++) {
            get(i10);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void b() {
        if (this.f32860c == null) {
            throw new DbException("This operation only works with cached lazy lists");
        }
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        g();
        return this.f32860c.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        g();
        return this.f32860c.containsAll(collection);
    }

    public int d() {
        return this.f32862e;
    }

    public boolean e() {
        return this.f32862e == this.f32861d;
    }

    public void g() {
        if (this.f32862e != this.f32861d) {
            b();
            this.f32858a.w().C2(new Runnable() { // from class: io.objectbox.query.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f32856a.f();
                }
            });
        }
    }

    @Override // java.util.List
    @Nullable
    public E get(int i10) {
        E eG;
        if (i10 < 0 || i10 > this.f32861d) {
            throw new IndexOutOfBoundsException("Illegal cursor location " + i10);
        }
        List<E> list = this.f32860c;
        if (list == null) {
            synchronized (this) {
                eG = this.f32858a.g(this.f32859b[i10]);
            }
            return eG;
        }
        E eG2 = list.get(i10);
        if (eG2 == null) {
            eG2 = this.f32858a.g(this.f32859b[i10]);
            synchronized (this) {
                E e10 = this.f32860c.get(i10);
                if (e10 == null) {
                    this.f32860c.set(i10, eG2);
                    this.f32862e++;
                } else {
                    eG2 = e10;
                }
            }
        }
        return eG2;
    }

    public E i(int i10) {
        List<E> list = this.f32860c;
        if (list != null) {
            return list.get(i10);
        }
        return null;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        g();
        return this.f32860c.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f32861d == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a(0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        g();
        return this.f32860c.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new a(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f32861d;
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        b();
        for (int i12 = i10; i12 < i11; i12++) {
            get(i12);
        }
        return this.f32860c.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        g();
        return this.f32860c.toArray();
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new a(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        g();
        return (T[]) this.f32860c.toArray(tArr);
    }
}
