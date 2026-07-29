package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import ee.a;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class Iterators {

    public static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        public static final UnmodifiableListIterator<Object> EMPTY = new ArrayItr(new Object[0], 0, 0, 0);
        private final T[] array;
        private final int offset;

        public ArrayItr(T[] tArr, int i10, int i11, int i12) {
            super(i11, i12);
            this.array = tArr;
            this.offset = i10;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public T get(int i10) {
            return this.array[this.offset + i10];
        }
    }

    public static class ConcatenatedIterator<T> implements Iterator<T> {
        private Iterator<? extends T> iterator = Iterators.emptyIterator();

        @NullableDecl
        private Deque<Iterator<? extends Iterator<? extends T>>> metaIterators;

        @NullableDecl
        private Iterator<? extends T> toRemove;
        private Iterator<? extends Iterator<? extends T>> topMetaIterator;

        public ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> it2) {
            this.topMetaIterator = (Iterator) Preconditions.checkNotNull(it2);
        }

        @NullableDecl
        private Iterator<? extends Iterator<? extends T>> getTopMetaIterator() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it2 = this.topMetaIterator;
                if (it2 != null && it2.hasNext()) {
                    return this.topMetaIterator;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.metaIterators;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.topMetaIterator = this.metaIterators.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) Preconditions.checkNotNull(this.iterator)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> topMetaIterator = getTopMetaIterator();
                this.topMetaIterator = topMetaIterator;
                if (topMetaIterator == null) {
                    return false;
                }
                Iterator<? extends T> next = topMetaIterator.next();
                this.iterator = next;
                if (next instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) next;
                    this.iterator = concatenatedIterator.iterator;
                    if (this.metaIterators == null) {
                        this.metaIterators = new ArrayDeque();
                    }
                    this.metaIterators.addFirst(this.topMetaIterator);
                    if (concatenatedIterator.metaIterators != null) {
                        while (!concatenatedIterator.metaIterators.isEmpty()) {
                            this.metaIterators.addFirst(concatenatedIterator.metaIterators.removeLast());
                        }
                    }
                    this.topMetaIterator = concatenatedIterator.topMetaIterator;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it2 = this.iterator;
            this.toRemove = it2;
            return it2.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove != null);
            this.toRemove.remove();
            this.toRemove = null;
        }
    }

    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    }

    public static class MergingIterator<T> extends UnmodifiableIterator<T> {
        public final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.queue = new PriorityQueue(2, new Comparator<PeekingIterator<T>>() { // from class: com.google.common.collect.Iterators.MergingIterator.1
                @Override // java.util.Comparator
                public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                    return comparator.compare(peekingIterator.peek(), peekingIterator2.peek());
                }
            });
            for (Iterator<? extends T> it2 : iterable) {
                if (it2.hasNext()) {
                    this.queue.add(Iterators.peekingIterator(it2));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            PeekingIterator<T> peekingIteratorRemove = this.queue.remove();
            T next = peekingIteratorRemove.next();
            if (peekingIteratorRemove.hasNext()) {
                this.queue.add(peekingIteratorRemove);
            }
            return next;
        }
    }

    public static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean hasPeeked;
        private final Iterator<? extends E> iterator;

        @NullableDecl
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> it2) {
            this.iterator = (Iterator) Preconditions.checkNotNull(it2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E e10 = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return e10;
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return this.peekedElement;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }
    }

    private Iterators() {
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it2) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it2);
        boolean zAdd = false;
        while (it2.hasNext()) {
            zAdd |= collection.add(it2.next());
        }
        return zAdd;
    }

    @CanIgnoreReturnValue
    public static int advance(Iterator<?> it2, int i10) {
        Preconditions.checkNotNull(it2);
        int i11 = 0;
        Preconditions.checkArgument(i10 >= 0, "numberToAdvance must be nonnegative");
        while (i11 < i10 && it2.hasNext()) {
            it2.next();
            i11++;
        }
        return i11;
    }

    public static <T> boolean all(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            if (!predicate.apply(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterator<T> it2, Predicate<? super T> predicate) {
        return indexOf(it2, predicate) != -1;
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> it2) {
        Preconditions.checkNotNull(it2);
        return new Enumeration<T>() { // from class: com.google.common.collect.Iterators.11
            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return it2.hasNext();
            }

            @Override // java.util.Enumeration
            public T nextElement() {
                return (T) it2.next();
            }
        };
    }

    public static <T> ListIterator<T> cast(Iterator<T> it2) {
        return (ListIterator) it2;
    }

    public static void checkNonnegative(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IndexOutOfBoundsException("position (" + i10 + ") must not be negative");
    }

    public static void clear(Iterator<?> it2) {
        Preconditions.checkNotNull(it2);
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it2, Iterator<? extends T> it3) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        return concat(consumingForArray(it2, it3));
    }

    public static <T> Iterator<T> concatNoDefensiveCopy(Iterator<? extends T>... itArr) {
        for (Iterator it2 : (Iterator[]) Preconditions.checkNotNull(itArr)) {
            Preconditions.checkNotNull(it2);
        }
        return concat(consumingForArray(itArr));
    }

    private static <T> Iterator<T> consumingForArray(final T... tArr) {
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.3
            public int index = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < tArr.length;
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = tArr;
                int i10 = this.index;
                T t10 = (T) objArr[i10];
                objArr[i10] = null;
                this.index = i10 + 1;
                return t10;
            }
        };
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> it2) {
        Preconditions.checkNotNull(it2);
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.8
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t10 = (T) it2.next();
                it2.remove();
                return t10;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    public static boolean contains(Iterator<?> it2, @NullableDecl Object obj) {
        if (obj == null) {
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it2.hasNext()) {
            if (obj.equals(it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterator<T>() { // from class: com.google.common.collect.Iterators.2
            public Iterator<T> iterator = Iterators.emptyModifiableIterator();

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator.hasNext() || iterable.iterator().hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                if (!this.iterator.hasNext()) {
                    Iterator<T> it2 = iterable.iterator();
                    this.iterator = it2;
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return this.iterator.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.iterator.remove();
            }
        };
    }

    public static boolean elementsEqual(Iterator<?> it2, Iterator<?> it3) {
        while (it2.hasNext()) {
            if (!it3.hasNext() || !Objects.equal(it2.next(), it3.next())) {
                return false;
            }
        }
        return !it3.hasNext();
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    public static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return (UnmodifiableListIterator<T>) ArrayItr.EMPTY;
    }

    public static <T> Iterator<T> emptyModifiableIterator() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> it2, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>() { // from class: com.google.common.collect.Iterators.5
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.common.collect.AbstractIterator
            public T computeNext() {
                while (it2.hasNext()) {
                    T t10 = (T) it2.next();
                    if (predicate.apply(t10)) {
                        return t10;
                    }
                }
                return endOfData();
            }
        };
    }

    public static <T> T find(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... tArr) {
        return forArray(tArr, 0, tArr.length, 0);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.10
            @Override // java.util.Iterator
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override // java.util.Iterator
            public T next() {
                return (T) enumeration.nextElement();
            }
        };
    }

    public static int frequency(Iterator<?> it2, @NullableDecl Object obj) {
        int i10 = 0;
        while (contains(it2, obj)) {
            i10++;
        }
        return i10;
    }

    public static <T> T get(Iterator<T> it2, int i10) {
        checkNonnegative(i10);
        int iAdvance = advance(it2, i10);
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new IndexOutOfBoundsException("position (" + i10 + ") must be less than the number of elements that remained (" + iAdvance + a.f26979d);
    }

    public static <T> T getLast(Iterator<T> it2) {
        T next;
        do {
            next = it2.next();
        } while (it2.hasNext());
        return next;
    }

    @NullableDecl
    public static <T> T getNext(Iterator<? extends T> it2, @NullableDecl T t10) {
        return it2.hasNext() ? it2.next() : t10;
    }

    public static <T> T getOnlyElement(Iterator<T> it2) {
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append(next);
        for (int i10 = 0; i10 < 4 && it2.hasNext(); i10++) {
            sb2.append(", ");
            sb2.append(it2.next());
        }
        if (it2.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append('>');
        throw new IllegalArgumentException(sb2.toString());
    }

    public static <T> int indexOf(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i10 = 0;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> Iterator<T> limit(final Iterator<T> it2, final int i10) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkArgument(i10 >= 0, "limit is negative");
        return new Iterator<T>() { // from class: com.google.common.collect.Iterators.7
            private int count;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.count < i10 && it2.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.count++;
                return (T) it2.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                it2.remove();
            }
        };
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> it2, int i10) {
        return partitionImpl(it2, i10, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> it2, int i10) {
        return partitionImpl(it2, i10, false);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> it2, final int i10, final boolean z10) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkArgument(i10 > 0);
        return new UnmodifiableIterator<List<T>>() { // from class: com.google.common.collect.Iterators.4
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            @Override // java.util.Iterator
            public List<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = new Object[i10];
                int i11 = 0;
                while (i11 < i10 && it2.hasNext()) {
                    objArr[i11] = it2.next();
                    i11++;
                }
                for (int i12 = i11; i12 < i10; i12++) {
                    objArr[i12] = null;
                }
                List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
                return (z10 || i11 == i10) ? listUnmodifiableList : listUnmodifiableList.subList(0, i11);
            }
        };
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> it2) {
        return it2 instanceof PeekingImpl ? (PeekingImpl) it2 : new PeekingImpl(it2);
    }

    @NullableDecl
    public static <T> T pollNext(Iterator<T> it2) {
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        it2.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterator<?> it2, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z10 = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z10 = false;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                it2.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterator<?> it2, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z10 = false;
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@NullableDecl final T t10) {
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.9
            public boolean done;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.done;
            }

            @Override // java.util.Iterator
            public T next() {
                if (this.done) {
                    throw new NoSuchElementException();
                }
                this.done = true;
                return (T) t10;
            }
        };
    }

    public static int size(Iterator<?> it2) {
        long j10 = 0;
        while (it2.hasNext()) {
            it2.next();
            j10++;
        }
        return Ints.saturatedCast(j10);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterator<? extends T> it2, Class<T> cls) {
        return (T[]) Iterables.toArray(Lists.newArrayList(it2), cls);
    }

    public static String toString(Iterator<?> it2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z10 = true;
        while (it2.hasNext()) {
            if (!z10) {
                sb2.append(", ");
            }
            z10 = false;
            sb2.append(it2.next());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it2, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new TransformedIterator<F, T>(it2) { // from class: com.google.common.collect.Iterators.6
            @Override // com.google.common.collect.TransformedIterator
            public T transform(F f10) {
                return (T) function.apply(f10);
            }
        };
    }

    public static <T> Optional<T> tryFind(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<? extends T> it2) {
        Preconditions.checkNotNull(it2);
        return it2 instanceof UnmodifiableIterator ? (UnmodifiableIterator) it2 : new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                return (T) it2.next();
            }
        };
    }

    public static <T> UnmodifiableListIterator<T> forArray(T[] tArr, int i10, int i11, int i12) {
        Preconditions.checkArgument(i11 >= 0);
        Preconditions.checkPositionIndexes(i10, i10 + i11, tArr.length);
        Preconditions.checkPositionIndex(i12, i11);
        return i11 == 0 ? emptyListIterator() : new ArrayItr(tArr, i10, i11, i12);
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList(tArr));
    }

    @NullableDecl
    public static <T> T getLast(Iterator<? extends T> it2, @NullableDecl T t10) {
        return it2.hasNext() ? (T) getLast(it2) : t10;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        return concat(consumingForArray(it2, it3, it4));
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> it2, Class<T> cls) {
        return filter(it2, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.checkNotNull(peekingIterator);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(unmodifiableIterator);
    }

    @NullableDecl
    public static <T> T get(Iterator<? extends T> it2, int i10, @NullableDecl T t10) {
        checkNonnegative(i10);
        advance(it2, i10);
        return (T) getNext(it2, t10);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @NullableDecl
    public static <T> T find(Iterator<? extends T> it2, Predicate<? super T> predicate, @NullableDecl T t10) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t10;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4, Iterator<? extends T> it5) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        Preconditions.checkNotNull(it5);
        return concat(consumingForArray(it2, it3, it4, it5));
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterator<? extends T> it2, @NullableDecl T t10) {
        return it2.hasNext() ? (T) getOnlyElement(it2) : t10;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... itArr) {
        return concatNoDefensiveCopy((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> it2) {
        return new ConcatenatedIterator(it2);
    }
}
