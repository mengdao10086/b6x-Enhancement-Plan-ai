package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final float DEFAULT_LOAD_FACTOR = 1.0f;
    public static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;

    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient long[] entries;

    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySetView;

    @MonotonicNonNullDecl
    private transient Set<K> keySetView;

    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient Object[] keys;
    public transient float loadFactor;
    public transient int modCount;
    private transient int size;

    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient Object[] values;

    @MonotonicNonNullDecl
    private transient Collection<V> valuesView;

    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        public EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iIndexOf = CompactHashMap.this.indexOf(entry.getKey());
            return iIndexOf != -1 && Objects.equal(CompactHashMap.this.values[iIndexOf], entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iIndexOf = CompactHashMap.this.indexOf(entry.getKey());
            if (iIndexOf == -1 || !Objects.equal(CompactHashMap.this.values[iIndexOf], entry.getValue())) {
                return false;
            }
            CompactHashMap.this.removeEntry(iIndexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public abstract class Itr<T> implements Iterator<T> {
        public int currentIndex;
        public int expectedModCount;
        public int indexToRemove;

        private Itr() {
            this.expectedModCount = CompactHashMap.this.modCount;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T getOutput(int i10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.currentIndex;
            this.indexToRemove = i10;
            T output = getOutput(i10);
            this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
            return output;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            this.expectedModCount++;
            CompactHashMap.this.removeEntry(this.indexToRemove);
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }
    }

    public class KeySetView extends AbstractSet<K> {
        public KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int iIndexOf = CompactHashMap.this.indexOf(obj);
            if (iIndexOf == -1) {
                return false;
            }
            CompactHashMap.this.removeEntry(iIndexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public final class MapEntry extends AbstractMapEntry<K, V> {

        @NullableDecl
        private final K key;
        private int lastKnownIndex;

        public MapEntry(int i10) {
            this.key = (K) CompactHashMap.this.keys[i10];
            this.lastKnownIndex = i10;
        }

        private void updateLastKnownIndex() {
            int i10 = this.lastKnownIndex;
            if (i10 == -1 || i10 >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            updateLastKnownIndex();
            int i10 = this.lastKnownIndex;
            if (i10 == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[i10];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v10) {
            updateLastKnownIndex();
            int i10 = this.lastKnownIndex;
            if (i10 == -1) {
                CompactHashMap.this.put(this.key, v10);
                return null;
            }
            Object[] objArr = CompactHashMap.this.values;
            V v11 = (V) objArr[i10];
            objArr[i10] = v10;
            return v11;
        }
    }

    public class ValuesView extends AbstractCollection<V> {
        public ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public CompactHashMap() {
        init(3, 1.0f);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i10) {
        return new CompactHashMap<>(i10);
    }

    private static int getHash(long j10) {
        return (int) (j10 >>> 32);
    }

    private static int getNext(long j10) {
        return (int) j10;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@NullableDecl Object obj) {
        int iSmearedHash = Hashing.smearedHash(obj);
        int next = this.table[hashTableMask() & iSmearedHash];
        while (next != -1) {
            long j10 = this.entries[next];
            if (getHash(j10) == iSmearedHash && Objects.equal(obj, this.keys[next])) {
                return next;
            }
            next = getNext(j10);
        }
        return -1;
    }

    private static long[] newEntries(int i10) {
        long[] jArr = new long[i10];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i10) {
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int i10 = objectInputStream.readInt();
        while (true) {
            i10--;
            if (i10 < 0) {
                return;
            } else {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeEntry(int i10) {
        return remove(this.keys[i10], getHash(this.entries[i10]));
    }

    private void resizeMeMaybe(int i10) {
        int length = this.entries.length;
        if (i10 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                resizeEntries(iMax);
            }
        }
    }

    private void resizeTable(int i10) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i11 = ((int) (i10 * this.loadFactor)) + 1;
        int[] iArrNewTable = newTable(i10);
        long[] jArr = this.entries;
        int length = iArrNewTable.length - 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            int hash = getHash(jArr[i12]);
            int i13 = hash & length;
            int i14 = iArrNewTable[i13];
            iArrNewTable[i13] = i12;
            jArr[i12] = (((long) hash) << 32) | (((long) i14) & 4294967295L);
        }
        this.threshold = i11;
        this.table = iArrNewTable;
    }

    private static long swapNext(long j10, int i10) {
        return (j10 & HASH_MASK) | (((long) i10) & 4294967295L);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        for (int i10 = 0; i10 < this.size; i10++) {
            objectOutputStream.writeObject(this.keys[i10]);
            objectOutputStream.writeObject(this.values[i10]);
        }
    }

    public void accessEntry(int i10) {
    }

    public int adjustAfterRemove(int i10, int i11) {
        return i10 - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i10 = 0; i10 < this.size; i10++) {
            if (Objects.equal(obj, this.values[i10])) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    public Set<K> createKeySet() {
        return new KeySetView();
    }

    public Collection<V> createValues() {
        return new ValuesView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setCreateEntrySet = createEntrySet();
        this.entrySetView = setCreateEntrySet;
        return setCreateEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            @Override // com.google.common.collect.CompactHashMap.Itr
            public Map.Entry<K, V> getOutput(int i10) {
                return new MapEntry(i10);
            }
        };
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int iIndexOf = indexOf(obj);
        accessEntry(iIndexOf);
        if (iIndexOf == -1) {
            return null;
        }
        return (V) this.values[iIndexOf];
    }

    public int getSuccessor(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.size) {
            return i11;
        }
        return -1;
    }

    public void init(int i10, float f10) {
        Preconditions.checkArgument(i10 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f10 > 0.0f, "Illegal load factor");
        int iClosedTableSize = Hashing.closedTableSize(i10, f10);
        this.table = newTable(iClosedTableSize);
        this.loadFactor = f10;
        this.keys = new Object[i10];
        this.values = new Object[i10];
        this.entries = newEntries(i10);
        this.threshold = Math.max(1, (int) (iClosedTableSize * f10));
    }

    public void insertEntry(int i10, @NullableDecl K k10, @NullableDecl V v10, int i11) {
        this.entries[i10] = (((long) i11) << 32) | 4294967295L;
        this.keys[i10] = k10;
        this.values[i10] = v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.keySetView = setCreateKeySet;
        return setCreateKeySet;
    }

    public Iterator<K> keySetIterator() {
        return new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            public K getOutput(int i10) {
                return (K) CompactHashMap.this.keys[i10];
            }
        };
    }

    public void moveLastEntry(int i10) {
        int size = size() - 1;
        if (i10 >= size) {
            this.keys[i10] = null;
            this.values[i10] = null;
            this.entries[i10] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i10] = objArr[size];
        Object[] objArr2 = this.values;
        objArr2[i10] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        long[] jArr = this.entries;
        long j10 = jArr[size];
        jArr[i10] = j10;
        jArr[size] = -1;
        int hash = getHash(j10) & hashTableMask();
        int[] iArr = this.table;
        int i11 = iArr[hash];
        if (i11 == size) {
            iArr[hash] = i10;
            return;
        }
        while (true) {
            long j11 = this.entries[i11];
            int next = getNext(j11);
            if (next == size) {
                this.entries[i11] = swapNext(j11, i10);
                return;
            }
            i11 = next;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k10, @NullableDecl V v10) {
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int iSmearedHash = Hashing.smearedHash(k10);
        int iHashTableMask = hashTableMask() & iSmearedHash;
        int i10 = this.size;
        int[] iArr = this.table;
        int i11 = iArr[iHashTableMask];
        if (i11 == -1) {
            iArr[iHashTableMask] = i10;
        } else {
            while (true) {
                long j10 = jArr[i11];
                if (getHash(j10) == iSmearedHash && Objects.equal(k10, objArr[i11])) {
                    V v11 = (V) objArr2[i11];
                    objArr2[i11] = v10;
                    accessEntry(i11);
                    return v11;
                }
                int next = getNext(j10);
                if (next == -1) {
                    jArr[i11] = swapNext(j10, i10);
                    break;
                }
                i11 = next;
            }
        }
        if (i10 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i12 = i10 + 1;
        resizeMeMaybe(i12);
        insertEntry(i10, k10, v10, iSmearedHash);
        this.size = i12;
        if (i10 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    public void resizeEntries(int i10) {
        this.keys = Arrays.copyOf(this.keys, i10);
        this.values = Arrays.copyOf(this.values, i10);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
        if (i10 > length) {
            Arrays.fill(jArrCopyOf, length, i10, -1L);
        }
        this.entries = jArrCopyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public void trimToSize() {
        int i10 = this.size;
        if (i10 < this.entries.length) {
            resizeEntries(i10);
        }
        int iMax = Math.max(1, Integer.highestOneBit((int) (i10 / this.loadFactor)));
        if (iMax < 1073741824 && ((double) i10) / ((double) iMax) > this.loadFactor) {
            iMax <<= 1;
        }
        if (iMax < this.table.length) {
            resizeTable(iMax);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.valuesView = collectionCreateValues;
        return collectionCreateValues;
    }

    public Iterator<V> valuesIterator() {
        return new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            public V getOutput(int i10) {
                return (V) CompactHashMap.this.values[i10];
            }
        };
    }

    @NullableDecl
    private V remove(@NullableDecl Object obj, int i10) {
        int iHashTableMask = hashTableMask() & i10;
        int i11 = this.table[iHashTableMask];
        if (i11 == -1) {
            return null;
        }
        int i12 = -1;
        while (true) {
            if (getHash(this.entries[i11]) == i10 && Objects.equal(obj, this.keys[i11])) {
                V v10 = (V) this.values[i11];
                if (i12 == -1) {
                    this.table[iHashTableMask] = getNext(this.entries[i11]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i12] = swapNext(jArr[i12], getNext(jArr[i11]));
                }
                moveLastEntry(i11);
                this.size--;
                this.modCount++;
                return v10;
            }
            int next = getNext(this.entries[i11]);
            if (next == -1) {
                return null;
            }
            i12 = i11;
            i11 = next;
        }
    }

    public CompactHashMap(int i10) {
        this(i10, 1.0f);
    }

    public CompactHashMap(int i10, float f10) {
        init(i10, f10);
    }
}
