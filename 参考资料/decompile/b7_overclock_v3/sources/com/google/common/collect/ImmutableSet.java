package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    public static final int MAX_TABLE_SIZE = 1073741824;

    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient ImmutableList<E> asList;

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        private int hashCode;

        @VisibleForTesting
        @NullableDecl
        public Object[] hashTable;

        public Builder() {
            super(4);
        }

        private void addDeduping(E e10) {
            int length = this.hashTable.length - 1;
            int iHashCode = e10.hashCode();
            int iSmear = Hashing.smear(iHashCode);
            while (true) {
                int i10 = iSmear & length;
                Object[] objArr = this.hashTable;
                Object obj = objArr[i10];
                if (obj == null) {
                    objArr[i10] = e10;
                    this.hashCode += iHashCode;
                    super.add((Object) e10);
                    return;
                } else if (obj.equals(e10)) {
                    return;
                } else {
                    iSmear = i10 + 1;
                }
            }
        }

        public Builder(int i10) {
            super(i10);
            this.hashTable = new Object[ImmutableSet.chooseTableSize(i10)];
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            ImmutableSet<E> immutableSetConstruct;
            int i10 = this.size;
            if (i10 == 0) {
                return ImmutableSet.of();
            }
            if (i10 == 1) {
                return ImmutableSet.of(this.contents[0]);
            }
            if (this.hashTable == null || ImmutableSet.chooseTableSize(i10) != this.hashTable.length) {
                immutableSetConstruct = ImmutableSet.construct(this.size, this.contents);
                this.size = immutableSetConstruct.size();
            } else {
                Object[] objArrCopyOf = ImmutableSet.shouldTrim(this.size, this.contents.length) ? Arrays.copyOf(this.contents, this.size) : this.contents;
                immutableSetConstruct = new RegularImmutableSet<>(objArrCopyOf, this.hashCode, this.hashTable, r5.length - 1, this.size);
            }
            this.forceCopy = true;
            this.hashTable = null;
            return immutableSetConstruct;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (this.hashTable != null) {
                Iterator<? extends E> it2 = iterable.iterator();
                while (it2.hasNext()) {
                    add((Object) it2.next());
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e10) {
            Preconditions.checkNotNull(e10);
            if (this.hashTable != null && ImmutableSet.chooseTableSize(this.size) <= this.hashTable.length) {
                addDeduping(e10);
                return this;
            }
            this.hashTable = null;
            super.add((Object) e10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it2) {
            Preconditions.checkNotNull(it2);
            while (it2.hasNext()) {
                add((Object) it2.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            if (this.hashTable != null) {
                for (E e10 : eArr) {
                    add((Object) e10);
                }
            } else {
                super.add((Object[]) eArr);
            }
            return this;
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i10) {
        CollectPreconditions.checkNonnegative(i10, "expectedSize");
        return new Builder<>(i10);
    }

    @VisibleForTesting
    static int chooseTableSize(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= CUTOFF) {
            Preconditions.checkArgument(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * DESIRED_LOAD_FACTOR < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i10, Object... objArr) {
        if (i10 == 0) {
            return of();
        }
        if (i10 == 1) {
            return of(objArr[0]);
        }
        int iChooseTableSize = chooseTableSize(i10);
        Object[] objArr2 = new Object[iChooseTableSize];
        int i11 = iChooseTableSize - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object objCheckElementNotNull = ObjectArrays.checkElementNotNull(objArr[i14], i14);
            int iHashCode = objCheckElementNotNull.hashCode();
            int iSmear = Hashing.smear(iHashCode);
            while (true) {
                int i15 = iSmear & i11;
                Object obj = objArr2[i15];
                if (obj == null) {
                    objArr[i13] = objCheckElementNotNull;
                    objArr2[i15] = objCheckElementNotNull;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj.equals(objCheckElementNotNull)) {
                    break;
                }
                iSmear++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            return new SingletonImmutableSet(objArr[0], i12);
        }
        if (chooseTableSize(i13) < iChooseTableSize / 2) {
            return construct(i13, objArr);
        }
        if (shouldTrim(i13, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new RegularImmutableSet(objArr, i12, objArr2, i11, i13);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListCreateAsList = createAsList();
        this.asList = immutableListCreateAsList;
        return immutableListCreateAsList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e10) {
        return new SingletonImmutableSet(e10);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11) {
        return construct(2, e10, e11);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12) {
        return construct(3, e10, e11, e12);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13) {
        return construct(4, e10, e11, e12, e13);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13, E e14) {
        return construct(5, e10, e11, e12, e13, e14);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it2) {
        if (!it2.hasNext()) {
            return of();
        }
        E next = it2.next();
        if (!it2.hasNext()) {
            return of((Object) next);
        }
        return new Builder().add((Object) next).addAll((Iterator) it2).build();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
