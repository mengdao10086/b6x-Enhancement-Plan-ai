package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    public AbstractSortedSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public abstract SortedSet<V> createCollection();

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k10, Collection<V> collection) {
        return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.WrappedNavigableSet(k10, (NavigableSet) collection, null) : new AbstractMapBasedMultimap.WrappedSortedSet(k10, (SortedSet) collection, null);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return collection instanceof NavigableSet ? Sets.unmodifiableNavigableSet((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createUnmodifiableEmptyCollection() {
        return (SortedSet<V>) unmodifiableCollectionSubclass((Collection) createCollection());
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public SortedSet<V> get(@NullableDecl K k10) {
        return (SortedSet) super.get((Object) k10);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public SortedSet<V> removeAll(@NullableDecl Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public SortedSet<V> replaceValues(@NullableDecl K k10, Iterable<? extends V> iterable) {
        return (SortedSet) super.replaceValues((Object) k10, (Iterable) iterable);
    }
}
