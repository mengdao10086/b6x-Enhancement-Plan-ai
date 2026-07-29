package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class e<V> extends kotlin.collections.c<V> implements Collection<V>, jk.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final MapBuilder<?, V> f37712a;

    public e(@k MapBuilder<?, V> backing) {
        f0.p(backing, "backing");
        this.f37712a = backing;
    }

    @Override // kotlin.collections.c
    public int a() {
        return this.f37712a.size();
    }

    @Override // kotlin.collections.c, java.util.AbstractCollection, java.util.Collection
    public boolean add(V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(@k Collection<? extends V> elements) {
        f0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @k
    public final MapBuilder<?, V> b() {
        return this.f37712a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f37712a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f37712a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f37712a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @k
    public Iterator<V> iterator() {
        return this.f37712a.W();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f37712a.T(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f37712a.p();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f37712a.p();
        return super.retainAll(elements);
    }
}
