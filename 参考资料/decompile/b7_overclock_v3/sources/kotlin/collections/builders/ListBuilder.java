package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import jk.f;
import kotlin.collections.i;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class ListBuilder<E> extends kotlin.collections.d<E> implements List<E>, RandomAccess, Serializable, jk.e {

    @k
    private E[] array;

    @l
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;

    @l
    private final ListBuilder<E> root;

    @t0({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1#2:430\n*E\n"})
    public static final class a<E> implements ListIterator<E>, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final ListBuilder<E> f37693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37695c;

        public a(@k ListBuilder<E> list, int i10) {
            f0.p(list, "list");
            this.f37693a = list;
            this.f37694b = i10;
            this.f37695c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            ListBuilder<E> listBuilder = this.f37693a;
            int i10 = this.f37694b;
            this.f37694b = i10 + 1;
            listBuilder.add(i10, e10);
            this.f37695c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f37694b < ((ListBuilder) this.f37693a).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f37694b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f37694b >= ((ListBuilder) this.f37693a).length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f37694b;
            this.f37694b = i10 + 1;
            this.f37695c = i10;
            return (E) ((ListBuilder) this.f37693a).array[((ListBuilder) this.f37693a).offset + this.f37695c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f37694b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i10 = this.f37694b;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f37694b = i11;
            this.f37695c = i11;
            return (E) ((ListBuilder) this.f37693a).array[((ListBuilder) this.f37693a).offset + this.f37695c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f37694b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i10 = this.f37695c;
            if (!(i10 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f37693a.remove(i10);
            this.f37694b = this.f37695c;
            this.f37695c = -1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            int i10 = this.f37695c;
            if (!(i10 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f37693a.set(i10, e10);
        }
    }

    public ListBuilder(E[] eArr, int i10, int i11, boolean z10, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i10;
        this.length = i11;
        this.isReadOnly = z10;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (x()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public final int A(int i10, int i11, Collection<? extends E> collection, boolean z10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int iA = listBuilder.A(i10, i11, collection, z10);
            this.length -= iA;
            return iA;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.array[i14]) == z10) {
                E[] eArr = this.array;
                i12++;
                eArr[i13 + i10] = eArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        E[] eArr2 = this.array;
        m.c1(eArr2, eArr2, i10 + i13, i11 + i10, this.length);
        E[] eArr3 = this.array;
        int i16 = this.length;
        b.g(eArr3, i16 - i15, i16);
        this.length -= i15;
        return i15;
    }

    @Override // kotlin.collections.d
    public int a() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        r();
        p(this.offset + this.length, e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@k Collection<? extends E> elements) {
        f0.p(elements, "elements");
        r();
        int size = elements.size();
        o(this.offset + this.length, elements, size);
        return size > 0;
    }

    @Override // kotlin.collections.d
    public E b(int i10) {
        r();
        kotlin.collections.b.f37685a.b(i10, this.length);
        return y(this.offset + i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        r();
        z(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@l Object obj) {
        return obj == this || ((obj instanceof List) && t((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        kotlin.collections.b.f37685a.b(i10, this.length);
        return this.array[this.offset + i10];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return b.i(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (f0.g(this.array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @k
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (f0.g(this.array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @k
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    public final void o(int i10, Collection<? extends E> collection, int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.o(i10, collection, i11);
            this.array = this.backing.array;
            this.length += i11;
        } else {
            w(i10, i11);
            Iterator<? extends E> it2 = collection.iterator();
            for (int i12 = 0; i12 < i11; i12++) {
                this.array[i10 + i12] = it2.next();
            }
        }
    }

    public final void p(int i10, E e10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder == null) {
            w(i10, 1);
            this.array[i10] = e10;
        } else {
            listBuilder.p(i10, e10);
            this.array = this.backing.array;
            this.length++;
        }
    }

    @k
    public final List<E> q() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        r();
        this.isReadOnly = true;
        return this;
    }

    public final void r() {
        if (x()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        r();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        r();
        return A(this.offset, this.length, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        r();
        return A(this.offset, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.d, java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        r();
        kotlin.collections.b.f37685a.b(i10, this.length);
        E[] eArr = this.array;
        int i11 = this.offset;
        E e11 = eArr[i11 + i10];
        eArr[i11 + i10] = e10;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.List
    @k
    public List<E> subList(int i10, int i11) {
        kotlin.collections.b.f37685a.d(i10, i11, this.length);
        E[] eArr = this.array;
        int i12 = this.offset + i10;
        int i13 = i11 - i10;
        boolean z10 = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i12, i13, z10, this, listBuilder == null ? this : listBuilder);
    }

    public final boolean t(List<?> list) {
        return b.h(this.array, this.offset, this.length, list);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @k
    public <T> T[] toArray(@k T[] destination) {
        f0.p(destination, "destination");
        int length = destination.length;
        int i10 = this.length;
        if (length < i10) {
            E[] eArr = this.array;
            int i11 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i11, i10 + i11, destination.getClass());
            f0.o(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.array;
        int i12 = this.offset;
        m.c1(eArr2, destination, 0, i12, i10 + i12);
        int length2 = destination.length;
        int i13 = this.length;
        if (length2 > i13) {
            destination[i13] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @k
    public String toString() {
        return b.j(this.array, this.offset, this.length);
    }

    public final void u(int i10) {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.array;
        if (i10 > eArr.length) {
            this.array = (E[]) b.e(this.array, i.f37718d.a(eArr.length, i10));
        }
    }

    public final void v(int i10) {
        u(this.length + i10);
    }

    public final void w(int i10, int i11) {
        v(i11);
        E[] eArr = this.array;
        m.c1(eArr, eArr, i10 + i11, i10, this.offset + this.length);
        this.length += i11;
    }

    public final boolean x() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    public final E y(int i10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.y(i10);
        }
        E[] eArr = this.array;
        E e10 = eArr[i10];
        m.c1(eArr, eArr, i10, i10 + 1, this.offset + this.length);
        b.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e10;
    }

    public final void z(int i10, int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.z(i10, i11);
        } else {
            E[] eArr = this.array;
            m.c1(eArr, eArr, i10, i10 + i11, this.length);
            E[] eArr2 = this.array;
            int i12 = this.length;
            b.g(eArr2, i12 - i11, i12);
        }
        this.length -= i11;
    }

    @Override // java.util.AbstractList, java.util.List
    @k
    public ListIterator<E> listIterator(int i10) {
        kotlin.collections.b.f37685a.c(i10, this.length);
        return new a(this, i10);
    }

    @Override // kotlin.collections.d, java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        r();
        kotlin.collections.b.f37685a.c(i10, this.length);
        p(this.offset + i10, e10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @k Collection<? extends E> elements) {
        f0.p(elements, "elements");
        r();
        kotlin.collections.b.f37685a.c(i10, this.length);
        int size = elements.size();
        o(this.offset + i10, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @k
    public Object[] toArray() {
        E[] eArr = this.array;
        int i10 = this.offset;
        return m.M1(eArr, i10, this.length + i10);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i10) {
        this(b.d(i10), 0, 0, false, null, null);
    }
}
