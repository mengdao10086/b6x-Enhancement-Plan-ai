package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
public final class EmptyList implements List, Serializable, RandomAccess, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final EmptyList f37667a = new EmptyList();
    private static final long serialVersionUID = -7390468764508069838L;

    private EmptyList() {
    }

    private final Object readResolve() {
        return f37667a;
    }

    public void a(int i10, Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return d((Void) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@yt.k Collection elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.isEmpty();
    }

    public boolean d(@yt.k Void element) {
        kotlin.jvm.internal.f0.p(element, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@yt.l Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return o((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator iterator() {
        return b0.f37692a;
    }

    @Override // java.util.List
    @yt.k
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Void get(int i10) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i10 + '.');
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return p((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    @yt.k
    public ListIterator listIterator() {
        return b0.f37692a;
    }

    public int m() {
        return 0;
    }

    public int o(@yt.k Void element) {
        kotlin.jvm.internal.f0.p(element, "element");
        return -1;
    }

    public int p(@yt.k Void element) {
        kotlin.jvm.internal.f0.p(element, "element");
        return -1;
    }

    public Void q(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void r(int i10, Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return m();
    }

    @Override // java.util.List
    @yt.k
    public List subList(int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.t.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(this, array);
    }

    @yt.k
    public String toString() {
        return okhttp3.u.f43953p;
    }

    @Override // java.util.List
    @yt.k
    public ListIterator listIterator(int i10) {
        if (i10 == 0) {
            return b0.f37692a;
        }
        throw new IndexOutOfBoundsException("Index: " + i10);
    }
}
