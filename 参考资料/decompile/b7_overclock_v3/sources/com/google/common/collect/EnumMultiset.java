package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import uh.a;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    public abstract class Itr<T> implements Iterator<T> {
        public int index = 0;
        public int toRemove = -1;

        public Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.index < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i10 = this.index;
                if (iArr[i10] > 0) {
                    return true;
                }
                this.index = i10 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tOutput = output(this.index);
            int i10 = this.index;
            this.toRemove = i10;
            this.index = i10 + 1;
            return tOutput;
        }

        public abstract T output(int i10);

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove >= 0);
            if (EnumMultiset.this.counts[this.toRemove] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.this.size -= (long) EnumMultiset.this.counts[this.toRemove];
                EnumMultiset.this.counts[this.toRemove] = 0;
            }
            this.toRemove = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        Preconditions.checkArgument(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i10 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i10 - 1;
        return i10;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    private boolean isActuallyE(@NullableDecl Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r52 = (Enum) obj;
        int iOrdinal = r52.ordinal();
        E[] eArr = this.enumConstants;
        return iOrdinal < eArr.length && eArr[iOrdinal] == r52;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        Serialization.populateMultiset(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    public void checkIsE(@NullableDecl Object obj) {
        Preconditions.checkNotNull(obj);
        if (isActuallyE(obj)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.type + " but got " + obj);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<E> elementIterator() {
        return new EnumMultiset<E>.Itr<E>() { // from class: com.google.common.collect.EnumMultiset.1
            @Override // com.google.common.collect.EnumMultiset.Itr
            public E output(int i10) {
                return (E) EnumMultiset.this.enumConstants[i10];
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.EnumMultiset.2
            @Override // com.google.common.collect.EnumMultiset.Itr
            public Multiset.Entry<E> output(final int i10) {
                return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.EnumMultiset.2.1
                    @Override // com.google.common.collect.Multiset.Entry
                    public int getCount() {
                        return EnumMultiset.this.counts[i10];
                    }

                    @Override // com.google.common.collect.Multiset.Entry
                    public E getElement() {
                        return (E) EnumMultiset.this.enumConstants[i10];
                    }
                };
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i10) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r12 = (Enum) obj;
        CollectPreconditions.checkNonnegative(i10, "occurrences");
        if (i10 == 0) {
            return count(obj);
        }
        int iOrdinal = r12.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[iOrdinal];
        if (i11 == 0) {
            return 0;
        }
        if (i11 <= i10) {
            iArr[iOrdinal] = 0;
            this.distinctElements--;
            this.size -= (long) i11;
        } else {
            iArr[iOrdinal] = i11 - i10;
            this.size -= (long) i10;
        }
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it2 = iterable.iterator();
        Preconditions.checkArgument(it2.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it2.next().getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e10, int i10) {
        checkIsE(e10);
        CollectPreconditions.checkNonnegative(i10, "occurrences");
        if (i10 == 0) {
            return count(e10);
        }
        int iOrdinal = e10.ordinal();
        int i11 = this.counts[iOrdinal];
        long j10 = i10;
        long j11 = ((long) i11) + j10;
        Preconditions.checkArgument(j11 <= 2147483647L, "too many occurrences: %s", j11);
        this.counts[iOrdinal] = (int) j11;
        if (i11 == 0) {
            this.distinctElements++;
        }
        this.size += j10;
        return i11;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e10, int i10) {
        checkIsE(e10);
        CollectPreconditions.checkNonnegative(i10, a.C);
        int iOrdinal = e10.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[iOrdinal];
        iArr[iOrdinal] = i10;
        this.size += (long) (i10 - i11);
        if (i11 == 0 && i10 > 0) {
            this.distinctElements++;
        } else if (i11 > 0 && i10 == 0) {
            this.distinctElements--;
        }
        return i11;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> enumMultisetCreate = create(cls);
        Iterables.addAll(enumMultisetCreate, iterable);
        return enumMultisetCreate;
    }
}
