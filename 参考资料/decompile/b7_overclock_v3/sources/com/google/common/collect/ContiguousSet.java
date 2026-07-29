package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    public final DiscreteDomain<C> domain;

    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Beta
    public static ContiguousSet<Integer> closed(int i10, int i11) {
        return create(Range.closed(Integer.valueOf(i10), Integer.valueOf(i11)), DiscreteDomain.integers());
    }

    @Beta
    public static ContiguousSet<Integer> closedOpen(int i10, int i11) {
        return create(Range.closedOpen(Integer.valueOf(i10), Integer.valueOf(i11)), DiscreteDomain.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            Range<C> rangeIntersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
            if (!range.hasUpperBound()) {
                rangeIntersection = rangeIntersection.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            return rangeIntersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(rangeIntersection, discreteDomain);
        } catch (NoSuchElementException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> headSetImpl(C c10, boolean z10);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> subSetImpl(C c10, boolean z10, C c11, boolean z11);

    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> tailSetImpl(C c10, boolean z10);

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    @Beta
    public static ContiguousSet<Long> closed(long j10, long j11) {
        return create(Range.closed(Long.valueOf(j10), Long.valueOf(j11)), DiscreteDomain.longs());
    }

    @Beta
    public static ContiguousSet<Long> closedOpen(long j10, long j11) {
        return create(Range.closedOpen(Long.valueOf(j10), Long.valueOf(j11)), DiscreteDomain.longs());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> headSet(C c10) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c10), false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c10, C c11) {
        Preconditions.checkNotNull(c10);
        Preconditions.checkNotNull(c11);
        Preconditions.checkArgument(comparator().compare(c10, c11) <= 0);
        return subSetImpl((Comparable) c10, true, (Comparable) c11, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> tailSet(C c10) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c10), true);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> headSet(C c10, boolean z10) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c10), z10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c10, boolean z10) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c10), z10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> subSet(C c10, boolean z10, C c11, boolean z11) {
        Preconditions.checkNotNull(c10);
        Preconditions.checkNotNull(c11);
        Preconditions.checkArgument(comparator().compare(c10, c11) <= 0);
        return subSetImpl((Comparable) c10, z10, (Comparable) c11, z11);
    }
}
