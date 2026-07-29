package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(serializable = true)
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        public final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // com.google.common.base.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    public class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {

        @NullableDecl
        public final C lowerBound;

        @NullableDecl
        public final C upperBound;

        @NullableDecl
        public transient SortedMap<C, V> wholeRow;

        public TreeRow(TreeBasedTable treeBasedTable, R r10) {
            this(r10, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        public int compare(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return rangeContains(obj) && super.containsKey(obj);
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (backingRowMap() != null) {
                return backingRowMap().firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c10) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c10)));
            return new TreeRow(this.rowKey, this.lowerBound, c10);
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (backingRowMap() != null) {
                return backingRowMap().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.Row
        public void maintainEmptyInvariant() {
            if (wholeRow() == null || !this.wholeRow.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.rowKey);
            this.wholeRow = null;
            this.backingRowMap = null;
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public V put(C c10, V v10) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c10)));
            return (V) super.put(c10, v10);
        }

        public boolean rangeContains(@NullableDecl Object obj) {
            C c10;
            C c11;
            return obj != null && ((c10 = this.lowerBound) == null || compare(c10, obj) <= 0) && ((c11 = this.upperBound) == null || compare(c11, obj) > 0);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c10, C c11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c10)) && rangeContains(Preconditions.checkNotNull(c11)));
            return new TreeRow(this.rowKey, c10, c11);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c10) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c10)));
            return new TreeRow(this.rowKey, c10, this.upperBound);
        }

        public SortedMap<C, V> wholeRow() {
            SortedMap<C, V> sortedMap = this.wholeRow;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.rowKey))) {
                this.wholeRow = (SortedMap) TreeBasedTable.this.backingMap.get(this.rowKey);
            }
            return this.wholeRow;
        }

        public TreeRow(R r10, @NullableDecl C c10, @NullableDecl C c11) {
            super(r10);
            this.lowerBound = c10;
            this.upperBound = c11;
            Preconditions.checkArgument(c10 == null || c11 == null || compare(c10, c11) <= 0);
        }

        @Override // com.google.common.collect.StandardTable.Row
        public SortedMap<C, V> backingRowMap() {
            return (SortedMap) super.backingRowMap();
        }

        @Override // com.google.common.collect.StandardTable.Row
        public SortedMap<C, V> computeBackingRowMap() {
            SortedMap<C, V> sortedMapWholeRow = wholeRow();
            if (sortedMapWholeRow == null) {
                return null;
            }
            C c10 = this.lowerBound;
            if (c10 != null) {
                sortedMapWholeRow = sortedMapWholeRow.tailMap(c10);
            }
            C c11 = this.upperBound;
            return c11 != null ? sortedMapWholeRow.headMap(c11) : sortedMapWholeRow;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet(this);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        final Comparator<? super C> comparatorColumnComparator = columnComparator();
        final UnmodifiableIterator unmodifiableIteratorMergeSorted = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new Function<Map<C, V>, Iterator<C>>() { // from class: com.google.common.collect.TreeBasedTable.1
            @Override // com.google.common.base.Function
            public Iterator<C> apply(Map<C, V> map) {
                return map.keySet().iterator();
            }
        }), comparatorColumnComparator);
        return new AbstractIterator<C>() { // from class: com.google.common.collect.TreeBasedTable.2

            @NullableDecl
            public C lastValue;

            @Override // com.google.common.collect.AbstractIterator
            public C computeNext() {
                while (unmodifiableIteratorMergeSorted.hasNext()) {
                    C c10 = (C) unmodifiableIteratorMergeSorted.next();
                    C c11 = this.lastValue;
                    if (!(c11 != null && comparatorColumnComparator.compare(c10, c11) == 0)) {
                        this.lastValue = c10;
                        return c10;
                    }
                }
                this.lastValue = null;
                return endOfData();
            }
        };
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<C, V> row(R r10) {
        return new TreeRow(this, r10);
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
