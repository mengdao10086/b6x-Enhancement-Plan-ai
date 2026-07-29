package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @MonotonicNonNullDecl
    private transient int[] predecessor;

    @MonotonicNonNullDecl
    private transient int[] successor;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i10) {
        return new CompactLinkedHashSet<>(i10);
    }

    private void succeeds(int i10, int i11) {
        if (i10 == -2) {
            this.firstEntry = i11;
        } else {
            this.successor[i10] = i11;
        }
        if (i11 == -2) {
            this.lastEntry = i10;
        } else {
            this.predecessor[i11] = i10;
        }
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int i10, int i11) {
        return i10 == size() ? i11 : i10;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int i10) {
        return this.successor[i10];
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int i10, float f10) {
        super.init(i10, f10);
        int[] iArr = new int[i10];
        this.predecessor = iArr;
        this.successor = new int[i10];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.successor, -1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int i10, E e10, int i11) {
        super.insertEntry(i10, e10, i11);
        succeeds(this.lastEntry, i10);
        succeeds(i10, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveEntry(int i10) {
        int size = size() - 1;
        super.moveEntry(i10);
        succeeds(this.predecessor[i10], this.successor[i10]);
        if (size != i10) {
            succeeds(this.predecessor[size], i10);
            succeeds(i10, this.successor[size]);
        }
        this.predecessor[size] = -1;
        this.successor[size] = -1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int i10) {
        super.resizeEntries(i10);
        int[] iArr = this.predecessor;
        int length = iArr.length;
        this.predecessor = Arrays.copyOf(iArr, i10);
        this.successor = Arrays.copyOf(this.successor, i10);
        if (length < i10) {
            Arrays.fill(this.predecessor, length, i10, -1);
            Arrays.fill(this.successor, length, i10, -1);
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public CompactLinkedHashSet(int i10) {
        super(i10);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> compactLinkedHashSetCreateWithExpectedSize = createWithExpectedSize(collection.size());
        compactLinkedHashSetCreateWithExpectedSize.addAll(collection);
        return compactLinkedHashSetCreateWithExpectedSize;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.toArrayImpl(this, tArr);
    }

    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> compactLinkedHashSetCreateWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(compactLinkedHashSetCreateWithExpectedSize, eArr);
        return compactLinkedHashSetCreateWithExpectedSize;
    }
}
