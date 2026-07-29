package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
abstract class AbstractNavigableMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {

    public final class DescendingMap extends Maps.DescendingMap<K, V> {
        private DescendingMap() {
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return AbstractNavigableMap.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public NavigableMap<K, V> forward() {
            return AbstractNavigableMap.this;
        }
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> ceilingEntry(K k10) {
        return tailMap(k10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k10) {
        return (K) Maps.keyOrNull(ceilingEntry(k10));
    }

    public abstract Iterator<Map.Entry<K, V>> descendingEntryIterator();

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.getNext(entryIterator(), null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> floorEntry(K k10) {
        return headMap(k10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k10) {
        return (K) Maps.keyOrNull(floorEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k10) {
        return headMap(k10, false);
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> higherEntry(K k10) {
        return tailMap(k10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k10) {
        return (K) Maps.keyOrNull(higherEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.getNext(descendingEntryIterator(), null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> lowerEntry(K k10) {
        return headMap(k10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k10) {
        return (K) Maps.keyOrNull(lowerEntry(k10));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new Maps.NavigableKeySet(this);
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entryIterator());
    }

    @Override // java.util.NavigableMap
    @NullableDecl
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingEntryIterator());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k10, K k11) {
        return subMap(k10, true, k11, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k10) {
        return tailMap(k10, true);
    }
}
