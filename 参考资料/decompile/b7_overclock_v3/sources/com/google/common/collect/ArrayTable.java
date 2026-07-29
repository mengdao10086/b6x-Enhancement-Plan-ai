package com.google.common.collect;

import com.blankj.utilcode.util.i0;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible(emulated = true)
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;

    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.ColumnMap columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.RowMap rowMap;

    public static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.keyIndex.containsKey(obj);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) { // from class: com.google.common.collect.ArrayTable.ArrayMap.2
                @Override // com.google.common.collect.AbstractIndexedListIterator
                public Map.Entry<K, V> get(int i10) {
                    return ArrayMap.this.getEntry(i10);
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object obj) {
            Integer num = this.keyIndex.get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public Map.Entry<K, V> getEntry(final int i10) {
            Preconditions.checkElementIndex(i10, size());
            return new AbstractMapEntry<K, V>() { // from class: com.google.common.collect.ArrayTable.ArrayMap.1
                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public K getKey() {
                    return (K) ArrayMap.this.getKey(i10);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V getValue() {
                    return (V) ArrayMap.this.getValue(i10);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V setValue(V v10) {
                    return (V) ArrayMap.this.setValue(i10, v10);
                }
            };
        }

        public K getKey(int i10) {
            return this.keyIndex.keySet().asList().get(i10);
        }

        public abstract String getKeyRole();

        @NullableDecl
        public abstract V getValue(int i10);

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k10, V v10) {
            Integer num = this.keyIndex.get(k10);
            if (num != null) {
                return setValue(num.intValue(), v10);
            }
            throw new IllegalArgumentException(getKeyRole() + i0.f11861z + k10 + " not in " + this.keyIndex.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @NullableDecl
        public abstract V setValue(int i10, V v10);

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.keyIndex.size();
        }

        private ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.keyIndex = immutableMap;
        }
    }

    public class Column extends ArrayMap<R, V> {
        public final int columnIndex;

        public Column(int i10) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = i10;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V getValue(int i10) {
            return (V) ArrayTable.this.at(i10, this.columnIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V setValue(int i10, V v10) {
            return (V) ArrayTable.this.set(i10, this.columnIndex, v10);
        }
    }

    public class ColumnMap extends ArrayMap<C, Map<R, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Column";
        }

        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<R, V> getValue(int i10) {
            return new Column(i10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        public Map<R, V> put(C c10, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<R, V> setValue(int i10, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public class Row extends ArrayMap<C, V> {
        public final int rowIndex;

        public Row(int i10) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = i10;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V getValue(int i10) {
            return (V) ArrayTable.this.at(this.rowIndex, i10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V setValue(int i10, V v10) {
            return (V) ArrayTable.this.set(this.rowIndex, i10, v10);
        }
    }

    public class RowMap extends ArrayMap<R, Map<C, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Row";
        }

        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<C, V> getValue(int i10) {
            return new Row(i10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        public Map<C, V> put(R r10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<C, V> setValue(int i10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> immutableListCopyOf = ImmutableList.copyOf(iterable);
        this.rowList = immutableListCopyOf;
        ImmutableList<C> immutableListCopyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = immutableListCopyOf2;
        Preconditions.checkArgument(immutableListCopyOf.isEmpty() == immutableListCopyOf2.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(immutableListCopyOf);
        this.columnKeyToIndex = Maps.indexMap(immutableListCopyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableListCopyOf.size(), immutableListCopyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Table.Cell<R, C, V> getCell(int i10) {
        return new Tables.AbstractCell<R, C, V>(i10) { // from class: com.google.common.collect.ArrayTable.2
            public final int columnIndex;
            public final int rowIndex;
            public final /* synthetic */ int val$index;

            {
                this.val$index = i10;
                this.rowIndex = i10 / ArrayTable.this.columnList.size();
                this.columnIndex = i10 % ArrayTable.this.columnList.size();
            }

            @Override // com.google.common.collect.Table.Cell
            public C getColumnKey() {
                return (C) ArrayTable.this.columnList.get(this.columnIndex);
            }

            @Override // com.google.common.collect.Table.Cell
            public R getRowKey() {
                return (R) ArrayTable.this.rowList.get(this.rowIndex);
            }

            @Override // com.google.common.collect.Table.Cell
            public V getValue() {
                return (V) ArrayTable.this.at(this.rowIndex, this.columnIndex);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i10) {
        return at(i10 / this.columnList.size(), i10 % this.columnList.size());
    }

    public V at(int i10, int i11) {
        Preconditions.checkElementIndex(i10, this.rowList.size());
        Preconditions.checkElementIndex(i11, this.columnList.size());
        return this.array[i10][i11];
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) { // from class: com.google.common.collect.ArrayTable.1
            @Override // com.google.common.collect.AbstractIndexedListIterator
            public Table.Cell<R, C, V> get(int i10) {
                return ArrayTable.this.getCell(i10);
            }
        };
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c10) {
        Preconditions.checkNotNull(c10);
        Integer num = this.columnKeyToIndex.get(c10);
        return num == null ? ImmutableMap.of() : new Column(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap columnMap = this.columnMap;
        if (columnMap != null) {
            return columnMap;
        }
        ArrayTable<R, C, V>.ColumnMap columnMap2 = new ColumnMap();
        this.columnMap = columnMap2;
        return columnMap2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        for (V[] vArr : this.array) {
            for (V v10 : vArr) {
                if (Objects.equal(obj, v10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public V erase(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r10, C c10, @NullableDecl V v10) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(c10);
        Integer num = this.rowKeyToIndex.get(r10);
        Preconditions.checkArgument(num != null, "Row %s not in %s", r10, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c10);
        Preconditions.checkArgument(num2 != null, "Column %s not in %s", c10, this.columnList);
        return set(num.intValue(), num2.intValue(), v10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r10) {
        Preconditions.checkNotNull(r10);
        Integer num = this.rowKeyToIndex.get(r10);
        return num == null ? ImmutableMap.of() : new Row(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap rowMap = this.rowMap;
        if (rowMap != null) {
            return rowMap;
        }
        ArrayTable<R, C, V>.RowMap rowMap2 = new RowMap();
        this.rowMap = rowMap2;
        return rowMap2;
    }

    @CanIgnoreReturnValue
    public V set(int i10, int i11, @NullableDecl V v10) {
        Preconditions.checkElementIndex(i10, this.rowList.size());
        Preconditions.checkElementIndex(i11, this.columnList.size());
        V[][] vArr = this.array;
        V v11 = vArr[i10][i11];
        vArr[i10][i11] = v10;
        return v11;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i10], 0, vArr[i10], 0, vArr2[i10].length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<V> valuesIterator() {
        return new AbstractIndexedListIterator<V>(size()) { // from class: com.google.common.collect.ArrayTable.3
            @Override // com.google.common.collect.AbstractIndexedListIterator
            public V get(int i10) {
                return (V) ArrayTable.this.getValue(i10);
            }
        };
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i10], 0, vArr[i10], 0, vArr2[i10].length);
        }
    }
}
