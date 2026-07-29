package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import ee.a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public final class Collections2 {

    public static class FilteredCollection<E> extends AbstractCollection<E> {
        public final Predicate<? super E> predicate;
        public final Collection<E> unfiltered;

        public FilteredCollection(Collection<E> collection, Predicate<? super E> predicate) {
            this.unfiltered = collection;
            this.predicate = predicate;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e10) {
            Preconditions.checkArgument(this.predicate.apply(e10));
            return this.unfiltered.add(e10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it2 = collection.iterator();
            while (it2.hasNext()) {
                Preconditions.checkArgument(this.predicate.apply(it2.next()));
            }
            return this.unfiltered.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (Collections2.safeContains(this.unfiltered, obj)) {
                return this.predicate.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Collections2.containsAllImpl(this, collection);
        }

        public FilteredCollection<E> createCombined(Predicate<? super E> predicate) {
            return new FilteredCollection<>(this.unfiltered, Predicates.and(this.predicate, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.unfiltered.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it2 = this.unfiltered.iterator();
            boolean z10 = false;
            while (it2.hasNext()) {
                E next = it2.next();
                if (this.predicate.apply(next) && collection.contains(next)) {
                    it2.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it2 = this.unfiltered.iterator();
            boolean z10 = false;
            while (it2.hasNext()) {
                E next = it2.next();
                if (this.predicate.apply(next) && !collection.contains(next)) {
                    it2.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it2 = this.unfiltered.iterator();
            int i10 = 0;
            while (it2.hasNext()) {
                if (this.predicate.apply(it2.next())) {
                    i10++;
                }
            }
            return i10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    public static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        public final Comparator<? super E> comparator;
        public final ImmutableList<E> inputList;
        public final int size;

        public OrderedPermutationCollection(Iterable<E> iterable, Comparator<? super E> comparator) {
            ImmutableList<E> immutableListSortedCopyOf = ImmutableList.sortedCopyOf(comparator, iterable);
            this.inputList = immutableListSortedCopyOf;
            this.comparator = comparator;
            this.size = calculateSize(immutableListSortedCopyOf, comparator);
        }

        private static <E> int calculateSize(List<E> list, Comparator<? super E> comparator) {
            int i10 = 1;
            int iSaturatedMultiply = 1;
            int i11 = 1;
            while (i10 < list.size()) {
                if (comparator.compare(list.get(i10 - 1), list.get(i10)) < 0) {
                    iSaturatedMultiply = IntMath.saturatedMultiply(iSaturatedMultiply, IntMath.binomial(i10, i11));
                    i11 = 0;
                    if (iSaturatedMultiply == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                i10++;
                i11++;
            }
            return IntMath.saturatedMultiply(iSaturatedMultiply, IntMath.binomial(i10, i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.inputList, this.comparator);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.inputList + a.f26979d;
        }
    }

    public static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        public final Comparator<? super E> comparator;

        @NullableDecl
        public List<E> nextPermutation;

        public OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator) {
            this.nextPermutation = Lists.newArrayList(list);
            this.comparator = comparator;
        }

        public void calculateNextPermutation() {
            int iFindNextJ = findNextJ();
            if (iFindNextJ == -1) {
                this.nextPermutation = null;
                return;
            }
            Collections.swap(this.nextPermutation, iFindNextJ, findNextL(iFindNextJ));
            Collections.reverse(this.nextPermutation.subList(iFindNextJ + 1, this.nextPermutation.size()));
        }

        public int findNextJ() {
            for (int size = this.nextPermutation.size() - 2; size >= 0; size--) {
                if (this.comparator.compare(this.nextPermutation.get(size), this.nextPermutation.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        public int findNextL(int i10) {
            E e10 = this.nextPermutation.get(i10);
            for (int size = this.nextPermutation.size() - 1; size > i10; size--) {
                if (this.comparator.compare(e10, this.nextPermutation.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            List<E> list = this.nextPermutation;
            if (list == null) {
                return endOfData();
            }
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) list);
            calculateNextPermutation();
            return immutableListCopyOf;
        }
    }

    public static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        public final ImmutableList<E> inputList;

        public PermutationCollection(ImmutableList<E> immutableList) {
            this.inputList = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.inputList);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.inputList + a.f26979d;
        }
    }

    public static class PermutationIterator<E> extends AbstractIterator<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f21218c;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21219j;
        public final List<E> list;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int[] f21220o;

        public PermutationIterator(List<E> list) {
            this.list = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.f21218c = iArr;
            int[] iArr2 = new int[size];
            this.f21220o = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.f21219j = Integer.MAX_VALUE;
        }

        public void calculateNextPermutation() {
            int size = this.list.size() - 1;
            this.f21219j = size;
            if (size == -1) {
                return;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.f21218c;
                int i11 = this.f21219j;
                int i12 = iArr[i11] + this.f21220o[i11];
                if (i12 < 0) {
                    switchDirection();
                } else if (i12 != i11 + 1) {
                    Collections.swap(this.list, (i11 - iArr[i11]) + i10, (i11 - i12) + i10);
                    this.f21218c[this.f21219j] = i12;
                    return;
                } else {
                    if (i11 == 0) {
                        return;
                    }
                    i10++;
                    switchDirection();
                }
            }
        }

        public void switchDirection() {
            int[] iArr = this.f21220o;
            int i10 = this.f21219j;
            iArr[i10] = -iArr[i10];
            this.f21219j = i10 - 1;
        }

        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            if (this.f21219j <= 0) {
                return endOfData();
            }
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.list);
            calculateNextPermutation();
            return immutableListCopyOf;
        }
    }

    public static class TransformedCollection<F, T> extends AbstractCollection<T> {
        public final Collection<F> fromCollection;
        public final Function<? super F, ? extends T> function;

        public TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(collection);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.fromCollection.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.fromCollection.size();
        }
    }

    private Collections2() {
    }

    public static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    public static boolean containsAllImpl(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it2 = collection2.iterator();
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    private static <E> ObjectCountHashMap<E> counts(Collection<E> collection) {
        ObjectCountHashMap<E> objectCountHashMap = new ObjectCountHashMap<>();
        for (E e10 : collection) {
            objectCountHashMap.put(e10, objectCountHashMap.get(e10) + 1);
        }
        return objectCountHashMap;
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof FilteredCollection ? ((FilteredCollection) collection).createCombined(predicate) : new FilteredCollection((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPermutation(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        ObjectCountHashMap objectCountHashMapCounts = counts(list);
        ObjectCountHashMap objectCountHashMapCounts2 = counts(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (objectCountHashMapCounts.getValue(i10) != objectCountHashMapCounts2.get(objectCountHashMapCounts.getKey(i10))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder newStringBuilderForCollection(int i10) {
        CollectPreconditions.checkNonnegative(i10, "size");
        return new StringBuilder((int) Math.min(((long) i10) * 8, 1073741824L));
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new PermutationCollection(ImmutableList.copyOf((Collection) collection));
    }

    public static boolean safeContains(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean safeRemove(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String toStringImpl(Collection<?> collection) {
        StringBuilder sbNewStringBuilderForCollection = newStringBuilderForCollection(collection.size());
        sbNewStringBuilderForCollection.append('[');
        boolean z10 = true;
        for (Object obj : collection) {
            if (!z10) {
                sbNewStringBuilderForCollection.append(", ");
            }
            z10 = false;
            if (obj == collection) {
                sbNewStringBuilderForCollection.append("(this Collection)");
            } else {
                sbNewStringBuilderForCollection.append(obj);
            }
        }
        sbNewStringBuilderForCollection.append(']');
        return sbNewStringBuilderForCollection.toString();
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection(iterable, comparator);
    }
}
