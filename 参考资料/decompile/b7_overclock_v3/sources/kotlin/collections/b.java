package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nAbstractList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n350#2,7:158\n378#2,7:165\n*S KotlinDebug\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n*L\n27#1:158,7\n29#1:165,7\n*E\n"})
@kotlin.v0(version = "1.1")
public abstract class b<E> extends AbstractCollection<E> implements List<E>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f37685a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final void a(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("startIndex: " + i10 + ", endIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i10 + " > endIndex: " + i11);
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void d(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
        }

        public final boolean e(@yt.k Collection<?> c10, @yt.k Collection<?> other) {
            kotlin.jvm.internal.f0.p(c10, "c");
            kotlin.jvm.internal.f0.p(other, "other");
            if (c10.size() != other.size()) {
                return false;
            }
            Iterator<?> it2 = other.iterator();
            Iterator<?> it3 = c10.iterator();
            while (it3.hasNext()) {
                if (!kotlin.jvm.internal.f0.g(it3.next(), it2.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(@yt.k Collection<?> c10) {
            kotlin.jvm.internal.f0.p(c10, "c");
            Iterator<?> it2 = c10.iterator();
            int iHashCode = 1;
            while (it2.hasNext()) {
                Object next = it2.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.b$b, reason: collision with other inner class name */
    public class C0429b implements Iterator<E>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37686a;

        public C0429b() {
        }

        public final int a() {
            return this.f37686a;
        }

        public final void b(int i10) {
            this.f37686a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f37686a < b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            int i10 = this.f37686a;
            this.f37686a = i10 + 1;
            return bVar.get(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends b<E>.C0429b implements ListIterator<E>, jk.a {
        public c(int i10) {
            super();
            b.f37685a.c(i10, b.this.size());
            b(i10);
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            b(a() - 1);
            return bVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d<E> extends b<E> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final b<E> f37689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f37690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f37691d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@yt.k b<? extends E> list, int i10, int i11) {
            kotlin.jvm.internal.f0.p(list, "list");
            this.f37689b = list;
            this.f37690c = i10;
            b.f37685a.d(i10, i11, list.size());
            this.f37691d = i11 - i10;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37691d;
        }

        @Override // kotlin.collections.b, java.util.List
        public E get(int i10) {
            b.f37685a.b(i10, this.f37691d);
            return this.f37689b.get(this.f37690c + i10);
        }
    }

    @Override // kotlin.collections.AbstractCollection
    public abstract int a();

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@yt.l Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f37685a.e(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i10);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f37685a.f(this);
    }

    @Override // java.util.List
    public int indexOf(E e10) {
        Iterator<E> it2 = iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            if (kotlin.jvm.internal.f0.g(it2.next(), e10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<E> iterator() {
        return new C0429b();
    }

    @Override // java.util.List
    public int lastIndexOf(E e10) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.f0.g(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @yt.k
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @yt.k
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    @yt.k
    public ListIterator<E> listIterator(int i10) {
        return new c(i10);
    }
}
