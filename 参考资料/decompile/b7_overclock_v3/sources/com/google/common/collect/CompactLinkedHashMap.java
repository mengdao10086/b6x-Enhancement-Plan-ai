package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i10) {
        return new CompactLinkedHashMap<>(i10);
    }

    private int getPredecessor(int i10) {
        return (int) (this.links[i10] >>> 32);
    }

    private void setPredecessor(int i10, int i11) {
        long[] jArr = this.links;
        jArr[i10] = (jArr[i10] & 4294967295L) | (((long) i11) << 32);
    }

    private void setSucceeds(int i10, int i11) {
        if (i10 == -2) {
            this.firstEntry = i11;
        } else {
            setSuccessor(i10, i11);
        }
        if (i11 == -2) {
            this.lastEntry = i10;
        } else {
            setPredecessor(i11, i10);
        }
    }

    private void setSuccessor(int i10, int i11) {
        long[] jArr = this.links;
        jArr[i10] = (jArr[i10] & (-4294967296L)) | (((long) i11) & 4294967295L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i10) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i10), getSuccessor(i10));
            setSucceeds(this.lastEntry, i10);
            setSucceeds(i10, -2);
            this.modCount++;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i10, int i11) {
        return i10 >= size() ? i11 : i10;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i10) {
        return (int) this.links[i10];
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i10, float f10) {
        super.init(i10, f10);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i10];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i10, K k10, V v10, int i11) {
        super.insertEntry(i10, k10, v10, i11);
        setSucceeds(this.lastEntry, i10);
        setSucceeds(i10, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i10) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i10), getSuccessor(i10));
        if (i10 < size) {
            setSucceeds(getPredecessor(size), i10);
            setSucceeds(i10, getSuccessor(size));
        }
        super.moveLastEntry(i10);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i10) {
        super.resizeEntries(i10);
        this.links = Arrays.copyOf(this.links, i10);
    }

    public CompactLinkedHashMap(int i10) {
        this(i10, 1.0f, false);
    }

    public CompactLinkedHashMap(int i10, float f10, boolean z10) {
        super(i10, f10);
        this.accessOrder = z10;
    }
}
