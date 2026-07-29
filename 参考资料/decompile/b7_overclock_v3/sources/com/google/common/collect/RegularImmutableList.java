package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableList<E> extends ImmutableList<E> {
    public static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);

    @VisibleForTesting
    public final transient Object[] array;
    private final transient int size;

    public RegularImmutableList(Object[] objArr, int i10) {
        this.array = objArr;
        this.size = i10;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i10) {
        System.arraycopy(this.array, 0, objArr, i10, this.size);
        return i10 + this.size;
    }

    @Override // java.util.List
    public E get(int i10) {
        Preconditions.checkElementIndex(i10, this.size);
        return (E) this.array[i10];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
