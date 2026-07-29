package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    public final Predicate<? super K> keyPredicate;
    public final Multimap<K, V> unfiltered;

    public static class AddRejectingList<K, V> extends ForwardingList<V> {
        public final K key;

        public AddRejectingList(K k10) {
            this.key = k10;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V v10) {
            add(0, v10);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i10, V v10) {
            Preconditions.checkPositionIndex(i10, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        @CanIgnoreReturnValue
        public boolean addAll(int i10, Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            Preconditions.checkPositionIndex(i10, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public List<V> delegate() {
            return Collections.emptyList();
        }
    }

    public class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        public Entries() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (FilteredKeyMultimap.this.unfiltered.containsKey(entry.getKey()) && FilteredKeyMultimap.this.keyPredicate.apply((Object) entry.getKey())) {
                return FilteredKeyMultimap.this.unfiltered.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return Collections2.filter(FilteredKeyMultimap.this.unfiltered.entries(), FilteredKeyMultimap.this.entryPredicate());
        }
    }

    public FilteredKeyMultimap(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(multimap);
        this.keyPredicate = (Predicate) Preconditions.checkNotNull(predicate);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        if (this.unfiltered.containsKey(obj)) {
            return this.keyPredicate.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        return new Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return Maps.keyPredicateOnEntries(this.keyPredicate);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(K k10) {
        return this.keyPredicate.apply(k10) ? this.unfiltered.get(k10) : this.unfiltered instanceof SetMultimap ? new AddRejectingSet(k10) : new AddRejectingList(k10);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(Object obj) {
        return containsKey(obj) ? this.unfiltered.removeAll(obj) : unmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        Iterator<Collection<V>> it2 = asMap().values().iterator();
        int size = 0;
        while (it2.hasNext()) {
            size += it2.next().size();
        }
        return size;
    }

    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Collection<V> unmodifiableEmptyCollection() {
        return this.unfiltered instanceof SetMultimap ? ImmutableSet.of() : ImmutableList.of();
    }

    public static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        public final K key;

        public AddRejectingSet(K k10) {
            this.key = k10;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V v10) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }
}
