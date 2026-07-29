package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import jk.h;
import kotlin.collections.f;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class SetBuilder<E> extends f<E> implements Set<E>, Serializable, h {

    @k
    private final MapBuilder<E, ?> backing;

    public SetBuilder(@k MapBuilder<E, ?> backing) {
        f0.p(backing, "backing");
        this.backing = backing;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.backing.I()) {
            return new SerializedCollection(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.f
    public int a() {
        return this.backing.size();
    }

    @Override // kotlin.collections.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        return this.backing.m(e10) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@k Collection<? extends E> elements) {
        f0.p(elements, "elements");
        this.backing.p();
        return super.addAll(elements);
    }

    @k
    public final Set<E> b() {
        this.backing.o();
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.backing.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.backing.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @k
    public Iterator<E> iterator() {
        return this.backing.J();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.backing.Q(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.backing.p();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@k Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.backing.p();
        return super.retainAll(elements);
    }

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int i10) {
        this(new MapBuilder(i10));
    }
}
