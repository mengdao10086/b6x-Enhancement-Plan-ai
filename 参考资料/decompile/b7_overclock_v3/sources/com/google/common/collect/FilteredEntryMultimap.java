package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    public final Predicate<? super Map.Entry<K, V>> predicate;
    public final Multimap<K, V> unfiltered;

    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        public AsMap() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new Maps.EntrySet<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl.1
                        public final Iterator<Map.Entry<K, Collection<V>>> backingIterator;

                        {
                            this.backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        }

                        @Override // com.google.common.collect.AbstractIterator
                        public Map.Entry<K, Collection<V>> computeNext() {
                            while (this.backingIterator.hasNext()) {
                                Map.Entry<K, Collection<V>> next = this.backingIterator.next();
                                K key = next.getKey();
                                Collection collectionFilterCollection = FilteredEntryMultimap.filterCollection(next.getValue(), new ValuePredicate(key));
                                if (!collectionFilterCollection.isEmpty()) {
                                    return Maps.immutableEntry(key, collectionFilterCollection);
                                }
                            }
                            return endOfData();
                        }
                    };
                }

                @Override // com.google.common.collect.Maps.EntrySet
                public Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.in(collection));
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Iterators.size(iterator());
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<K> createKeySet() {
            return new Maps.KeySet<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1KeySetImpl
                @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(@NullableDecl Object obj) {
                    return AsMap.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<Collection<V>> createValues() {
            return new Maps.Values<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1ValuesImpl
                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean remove(@NullableDecl Object obj) {
                    if (!(obj instanceof Collection)) {
                        return false;
                    }
                    Collection collection = (Collection) obj;
                    Iterator<Map.Entry<K, Collection<V>>> it2 = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<K, Collection<V>> next = it2.next();
                        Collection collectionFilterCollection = FilteredEntryMultimap.filterCollection(next.getValue(), new ValuePredicate(next.getKey()));
                        if (!collectionFilterCollection.isEmpty() && collection.equals(collectionFilterCollection)) {
                            if (collectionFilterCollection.size() == next.getValue().size()) {
                                it2.remove();
                                return true;
                            }
                            collectionFilterCollection.clear();
                            return true;
                        }
                    }
                    return false;
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(@NullableDecl Object obj) {
            Collection<V> collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> collectionFilterCollection = FilteredEntryMultimap.filterCollection(collection, new ValuePredicate(obj));
            if (collectionFilterCollection.isEmpty()) {
                return null;
            }
            return collectionFilterCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(@NullableDecl Object obj) {
            Collection<V> collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            Iterator<V> it2 = collection.iterator();
            while (it2.hasNext()) {
                V next = it2.next();
                if (FilteredEntryMultimap.this.satisfies(obj, next)) {
                    it2.remove();
                    arrayListNewArrayList.add(next);
                }
            }
            if (arrayListNewArrayList.isEmpty()) {
                return null;
            }
            return FilteredEntryMultimap.this.unfiltered instanceof SetMultimap ? Collections.unmodifiableSet(Sets.newLinkedHashSet(arrayListNewArrayList)) : Collections.unmodifiableList(arrayListNewArrayList);
        }
    }

    public class Keys extends Multimaps.Keys<K, V> {
        public Keys() {
            super(FilteredEntryMultimap.this);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<K>> entrySet() {
            return new Multisets.EntrySet<K>() { // from class: com.google.common.collect.FilteredEntryMultimap.Keys.1
                private boolean removeEntriesIf(final Predicate<? super Multiset.Entry<K>> predicate) {
                    return FilteredEntryMultimap.this.removeEntriesIf(new Predicate<Map.Entry<K, Collection<V>>>() { // from class: com.google.common.collect.FilteredEntryMultimap.Keys.1.1
                        @Override // com.google.common.base.Predicate
                        public boolean apply(Map.Entry<K, Collection<V>> entry) {
                            return predicate.apply(Multisets.immutableEntry(entry.getKey(), entry.getValue().size()));
                        }
                    });
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Multiset.Entry<K>> iterator() {
                    return Keys.this.entryIterator();
                }

                @Override // com.google.common.collect.Multisets.EntrySet
                public Multiset<K> multiset() {
                    return Keys.this;
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection<?> collection) {
                    return removeEntriesIf(Predicates.in(collection));
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return FilteredEntryMultimap.this.keySet().size();
                }
            };
        }

        @Override // com.google.common.collect.Multimaps.Keys, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@NullableDecl Object obj, int i10) {
            CollectPreconditions.checkNonnegative(i10, "occurrences");
            if (i10 == 0) {
                return count(obj);
            }
            Collection<V> collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            int i11 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator<V> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (FilteredEntryMultimap.this.satisfies(obj, it2.next()) && (i11 = i11 + 1) <= i10) {
                    it2.remove();
                }
            }
            return i11;
        }
    }

    public final class ValuePredicate implements Predicate<V> {
        private final K key;

        public ValuePredicate(K k10) {
            this.key = k10;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl V v10) {
            return FilteredEntryMultimap.this.satisfies(this.key, v10);
        }
    }

    public FilteredEntryMultimap(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(multimap);
        this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
    }

    public static <E> Collection<E> filterCollection(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof Set ? Sets.filter((Set) collection, predicate) : Collections2.filter(collection, predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean satisfies(K k10, V v10) {
        return this.predicate.apply(Maps.immutableEntry(k10, v10));
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return asMap().get(obj) != null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return new AsMap();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        return filterCollection(this.unfiltered.entries(), this.predicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return new Keys();
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
        return this.predicate;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(K k10) {
        return filterCollection(this.unfiltered.get(k10), new ValuePredicate(k10));
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(@NullableDecl Object obj) {
        return (Collection) MoreObjects.firstNonNull(asMap().remove(obj), unmodifiableEmptyCollection());
    }

    public boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator<Map.Entry<K, Collection<V>>> it2 = this.unfiltered.asMap().entrySet().iterator();
        boolean z10 = false;
        while (it2.hasNext()) {
            Map.Entry<K, Collection<V>> next = it2.next();
            K key = next.getKey();
            Collection collectionFilterCollection = filterCollection(next.getValue(), new ValuePredicate(key));
            if (!collectionFilterCollection.isEmpty() && predicate.apply(Maps.immutableEntry(key, collectionFilterCollection))) {
                if (collectionFilterCollection.size() == next.getValue().size()) {
                    it2.remove();
                } else {
                    collectionFilterCollection.clear();
                }
                z10 = true;
            }
        }
        return z10;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Collection<V> unmodifiableEmptyCollection() {
        return this.unfiltered instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }
}
