package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class EmptySet implements Set, Serializable, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final EmptySet f37669a = new EmptySet();
    private static final long serialVersionUID = 3406603774387020532L;

    private EmptySet() {
    }

    private final Object readResolve() {
        return f37669a;
    }

    public boolean a(Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(@yt.k Void element) {
        kotlin.jvm.internal.f0.p(element, "element");
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return b((Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@yt.k Collection elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements.isEmpty();
    }

    public int d() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(@yt.l Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator iterator() {
        return b0.f37692a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.t.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(this, array);
    }

    @yt.k
    public String toString() {
        return okhttp3.u.f43953p;
    }
}
