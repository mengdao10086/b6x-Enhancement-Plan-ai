package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class c<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final MapBuilder<K, V> f37710a;

    public c(@k MapBuilder<K, V> backing) {
        f0.p(backing, "backing");
        this.f37710a = backing;
    }

    @Override // kotlin.collections.f
    public int a() {
        return this.f37710a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@k Collection<? extends Map.Entry<K, V>> elements) {
        f0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f37710a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        return this.f37710a.r(elements);
    }

    @Override // kotlin.collections.builders.a
    public boolean d(@k Map.Entry<? extends K, ? extends V> element) {
        f0.p(element, "element");
        return this.f37710a.t(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f37710a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @k
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f37710a.x();
    }

    @Override // kotlin.collections.builders.a
    public boolean l(@k Map.Entry element) {
        f0.p(element, "element");
        return this.f37710a.O(element);
    }

    @Override // kotlin.collections.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean add(@k Map.Entry<K, V> element) {
        f0.p(element, "element");
        throw new UnsupportedOperationException();
    }

    @k
    public final MapBuilder<K, V> o() {
        return this.f37710a;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f37710a.p();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f37710a.p();
        return super.retainAll(elements);
    }
}
