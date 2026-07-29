package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    @Beta
    public class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.1
                private Map.Entry<K, V> nextOrNull;
                private Map.Entry<K, V> toRemove = null;

                {
                    this.nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.nextOrNull != null;
                }

                @Override // java.util.Iterator
                public void remove() {
                    CollectPreconditions.checkRemove(this.toRemove != null);
                    StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                    this.toRemove = null;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    try {
                        Map.Entry<K, V> entry = this.nextOrNull;
                        this.toRemove = entry;
                        this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        return entry;
                    } catch (Throwable th2) {
                        this.toRemove = this.nextOrNull;
                        this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        throw th2;
                    }
                }
            };
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }
    }

    @Beta
    public class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet() {
            super(ForwardingNavigableMap.this);
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k10) {
        return delegate().ceilingEntry(k10);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k10) {
        return delegate().ceilingKey(k10);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract NavigableMap<K, V> delegate();

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k10) {
        return delegate().floorEntry(k10);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k10) {
        return delegate().floorKey(k10);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k10, boolean z10) {
        return delegate().headMap(k10, z10);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k10) {
        return delegate().higherEntry(k10);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k10) {
        return delegate().higherKey(k10);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k10) {
        return delegate().lowerEntry(k10);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k10) {
        return delegate().lowerKey(k10);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public Map.Entry<K, V> standardCeilingEntry(K k10) {
        return tailMap(k10, true).firstEntry();
    }

    public K standardCeilingKey(K k10) {
        return (K) Maps.keyOrNull(ceilingEntry(k10));
    }

    @Beta
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        Map.Entry<K, V> entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardFloorEntry(K k10) {
        return headMap(k10, true).lastEntry();
    }

    public K standardFloorKey(K k10) {
        return (K) Maps.keyOrNull(floorEntry(k10));
    }

    public SortedMap<K, V> standardHeadMap(K k10) {
        return headMap(k10, false);
    }

    public Map.Entry<K, V> standardHigherEntry(K k10) {
        return tailMap(k10, false).firstEntry();
    }

    public K standardHigherKey(K k10) {
        return (K) Maps.keyOrNull(higherEntry(k10));
    }

    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        Map.Entry<K, V> entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardLowerEntry(K k10) {
        return headMap(k10, false).lastEntry();
    }

    public K standardLowerKey(K k10) {
        return (K) Maps.keyOrNull(lowerEntry(k10));
    }

    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingSortedMap
    public SortedMap<K, V> standardSubMap(K k10, K k11) {
        return subMap(k10, true, k11, false);
    }

    public SortedMap<K, V> standardTailMap(K k10) {
        return tailMap(k10, true);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
        return delegate().subMap(k10, z10, k11, z11);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k10, boolean z10) {
        return delegate().tailMap(k10, z10);
    }
}
