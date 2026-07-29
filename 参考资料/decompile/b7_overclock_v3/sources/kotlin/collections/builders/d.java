package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import jk.h;
import kotlin.collections.f;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class d<E> extends f<E> implements Set<E>, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final MapBuilder<E, ?> f37711a;

    public d(@k MapBuilder<E, ?> backing) {
        f0.p(backing, "backing");
        this.f37711a = backing;
    }

    @Override // kotlin.collections.f
    public int a() {
        return this.f37711a.size();
    }

    @Override // kotlin.collections.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@k Collection<? extends E> elements) {
        f0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f37711a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f37711a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f37711a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @k
    public Iterator<E> iterator() {
        return this.f37711a.J();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f37711a.Q(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f37711a.p();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f37711a.p();
        return super.retainAll(elements);
    }
}
