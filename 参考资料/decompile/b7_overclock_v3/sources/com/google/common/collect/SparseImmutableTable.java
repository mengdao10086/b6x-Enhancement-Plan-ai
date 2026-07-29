package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import i1.a;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@Immutable(containerOf = {"R", "C", a.X4})
@GwtCompatible
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap immutableMapIndexMap = Maps.indexMap(immutableSet);
        LinkedHashMap linkedHashMapNewLinkedHashMap = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> it2 = immutableSet.iterator();
        while (it2.hasNext()) {
            linkedHashMapNewLinkedHashMap.put(it2.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMapNewLinkedHashMap2 = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> it3 = immutableSet2.iterator();
        while (it3.hasNext()) {
            linkedHashMapNewLinkedHashMap2.put(it3.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i10 = 0; i10 < immutableList.size(); i10++) {
            Table.Cell<R, C, V> cell = immutableList.get(i10);
            R rowKey = cell.getRowKey();
            C columnKey = cell.getColumnKey();
            V value = cell.getValue();
            iArr[i10] = ((Integer) immutableMapIndexMap.get(rowKey)).intValue();
            Map map = (Map) linkedHashMapNewLinkedHashMap.get(rowKey);
            iArr2[i10] = map.size();
            checkNoDuplicate(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) linkedHashMapNewLinkedHashMap2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.Builder builder = new ImmutableMap.Builder(linkedHashMapNewLinkedHashMap.size());
        for (Map.Entry entry : linkedHashMapNewLinkedHashMap.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = builder.build();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(linkedHashMapNewLinkedHashMap2.size());
        for (Map.Entry entry2 : linkedHashMapNewLinkedHashMap2.entrySet()) {
            builder2.put(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = builder2.build();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap immutableMapIndexMap = Maps.indexMap(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        UnmodifiableIterator<Table.Cell<R, C, V>> it2 = cellSet().iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            iArr[i10] = ((Integer) immutableMapIndexMap.get(it2.next().getColumnKey())).intValue();
            i10++;
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public Table.Cell<R, C, V> getCell(int i10) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[i10]);
        ImmutableMap<C, V> value = entry.getValue();
        Map.Entry<C, V> entry2 = value.entrySet().asList().get(this.cellColumnInRowIndices[i10]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i10) {
        ImmutableMap<C, V> immutableMap = this.rowMap.values().asList().get(this.cellRowIndices[i10]);
        return immutableMap.values().asList().get(this.cellColumnInRowIndices[i10]);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }
}
