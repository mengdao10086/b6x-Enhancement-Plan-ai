package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,471:1\n1726#2,3:472\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n*L\n61#1:472,3\n*E\n"})
public final class h<T> implements Collection<T>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final T[] f37714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f37715b;

    public h(@yt.k T[] values, boolean z10) {
        kotlin.jvm.internal.f0.p(values, "values");
        this.f37714a = values;
        this.f37715b = z10;
    }

    public int a() {
        return this.f37714a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @yt.k
    public final T[] b() {
        return this.f37714a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return ArraysKt___ArraysKt.T8(this.f37714a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@yt.k Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it2 = elements.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean d() {
        return this.f37715b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f37714a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.h.a(this.f37714a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    @yt.k
    public final Object[] toArray() {
        return s.h(this.f37714a, this.f37715b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(this, array);
    }
}
