package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import uh.a;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient ObjectCountHashMap<E> backingMap;
    public transient long size;

    public abstract class Itr<T> implements Iterator<T> {
        public int entryIndex;
        public int expectedModCount;
        public int toRemove = -1;

        public Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            return this.entryIndex >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tResult = result(this.entryIndex);
            int i10 = this.entryIndex;
            this.toRemove = i10;
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i10);
            return tResult;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        public abstract T result(int i10);
    }

    public AbstractMapBasedMultiset(int i10) {
        init(i10);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int count = Serialization.readCount(objectInputStream);
        init(3);
        Serialization.populateMultiset(this, objectInputStream, count);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e10, int i10) {
        if (i10 == 0) {
            return count(e10);
        }
        Preconditions.checkArgument(i10 > 0, "occurrences cannot be negative: %s", i10);
        int iIndexOf = this.backingMap.indexOf(e10);
        if (iIndexOf == -1) {
            this.backingMap.put(e10, i10);
            this.size += (long) i10;
            return 0;
        }
        int value = this.backingMap.getValue(iIndexOf);
        long j10 = i10;
        long j11 = ((long) value) + j10;
        Preconditions.checkArgument(j11 <= 2147483647L, "too many occurrences: %s", j11);
        this.backingMap.setValue(iIndexOf, (int) j11);
        this.size += j10;
        return value;
    }

    public void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int iFirstIndex = this.backingMap.firstIndex();
        while (iFirstIndex >= 0) {
            multiset.add(this.backingMap.getKey(iFirstIndex), this.backingMap.getValue(iFirstIndex));
            iFirstIndex = this.backingMap.nextIndex(iFirstIndex);
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.clear();
        this.size = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@NullableDecl Object obj) {
        return this.backingMap.get(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int distinctElements() {
        return this.backingMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public E result(int i10) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i10);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public Multiset.Entry<E> result(int i10) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i10);
            }
        };
    }

    public abstract void init(int i10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i10) {
        if (i10 == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i10 > 0, "occurrences cannot be negative: %s", i10);
        int iIndexOf = this.backingMap.indexOf(obj);
        if (iIndexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(iIndexOf);
        if (value > i10) {
            this.backingMap.setValue(iIndexOf, value - i10);
        } else {
            this.backingMap.removeEntry(iIndexOf);
            i10 = value;
        }
        this.size -= (long) i10;
        return value;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e10, int i10) {
        CollectPreconditions.checkNonnegative(i10, a.C);
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int iRemove = i10 == 0 ? objectCountHashMap.remove(e10) : objectCountHashMap.put(e10, i10);
        this.size += (long) (i10 - iRemove);
        return iRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@NullableDecl E e10, int i10, int i11) {
        CollectPreconditions.checkNonnegative(i10, "oldCount");
        CollectPreconditions.checkNonnegative(i11, "newCount");
        int iIndexOf = this.backingMap.indexOf(e10);
        if (iIndexOf == -1) {
            if (i10 != 0) {
                return false;
            }
            if (i11 > 0) {
                this.backingMap.put(e10, i11);
                this.size += (long) i11;
            }
            return true;
        }
        if (this.backingMap.getValue(iIndexOf) != i10) {
            return false;
        }
        if (i11 == 0) {
            this.backingMap.removeEntry(iIndexOf);
            this.size -= (long) i10;
        } else {
            this.backingMap.setValue(iIndexOf, i11);
            this.size += (long) (i11 - i10);
        }
        return true;
    }
}
