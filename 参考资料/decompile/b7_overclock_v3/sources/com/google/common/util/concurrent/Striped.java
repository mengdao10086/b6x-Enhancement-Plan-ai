package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() { // from class: com.google.common.util.concurrent.Striped.5
        @Override // com.google.common.base.Supplier
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    };
    private static final Supplier<ReadWriteLock> WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() { // from class: com.google.common.util.concurrent.Striped.6
        @Override // com.google.common.base.Supplier
        public ReadWriteLock get() {
            return new WeakSafeReadWriteLock();
        }
    };

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i10) {
            return (L) this.array[i10];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.array.length;
        }

        private CompactStriped(int i10, Supplier<L> supplier) {
            super(i10);
            int i11 = 0;
            Preconditions.checkArgument(i10 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
            while (true) {
                Object[] objArr = this.array;
                if (i11 >= objArr.length) {
                    return;
                }
                objArr[i11] = supplier.get();
                i11++;
            }
        }
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        public final ConcurrentMap<Integer, L> locks;
        public final int size;
        public final Supplier<L> supplier;

        public LargeLazyStriped(int i10, Supplier<L> supplier) {
            super(i10);
            int i11 = this.mask;
            this.size = i11 == -1 ? Integer.MAX_VALUE : i11 + 1;
            this.supplier = supplier;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i10) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i10, size());
            }
            L l10 = this.locks.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10;
            }
            L l11 = this.supplier.get();
            return (L) MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i10), l11), l11);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    public static class PaddedLock extends ReentrantLock {
        public long unused1;
        public long unused2;
        public long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        public long unused1;
        public long unused2;
        public long unused3;

        public PaddedSemaphore(int i10) {
            super(i10, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        public final int mask;

        public PowerOfTwoStriped(int i10) {
            super();
            Preconditions.checkArgument(i10 > 0, "Stripes must be positive");
            this.mask = i10 > 1073741824 ? -1 : Striped.ceilToPowerOfTwo(i10) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        public final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        public final ReferenceQueue<L> queue;
        public final int size;
        public final Supplier<L> supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            public final int index;

            public ArrayReference(L l10, int i10, ReferenceQueue<L> referenceQueue) {
                super(l10, referenceQueue);
                this.index = i10;
            }
        }

        public SmallLazyStriped(int i10, Supplier<L> supplier) {
            super(i10);
            this.queue = new ReferenceQueue<>();
            int i11 = this.mask;
            int i12 = i11 == -1 ? Integer.MAX_VALUE : i11 + 1;
            this.size = i12;
            this.locks = new AtomicReferenceArray<>(i12);
            this.supplier = supplier;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> referencePoll = this.queue.poll();
                if (referencePoll == null) {
                    return;
                }
                ArrayReference<? extends L> arrayReference = (ArrayReference) referencePoll;
                this.locks.compareAndSet(arrayReference.index, arrayReference, null);
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i10) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i10, size());
            }
            ArrayReference<? extends L> arrayReference = this.locks.get(i10);
            L l10 = arrayReference == null ? null : arrayReference.get();
            if (l10 != null) {
                return l10;
            }
            L l11 = this.supplier.get();
            ArrayReference<? extends L> arrayReference2 = new ArrayReference<>(l11, i10, this.queue);
            while (!this.locks.compareAndSet(i10, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(i10);
                L l12 = arrayReference == null ? null : arrayReference.get();
                if (l12 != null) {
                    return l12;
                }
            }
            drainQueue();
            return l11;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        public Condition delegate() {
            return this.delegate;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        public Lock delegate() {
            return this.delegate;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i10) {
        return 1 << IntMath.log2(i10, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int i10, Supplier<L> supplier) {
        return new CompactStriped(i10, supplier);
    }

    private static <L> Striped<L> lazy(int i10, Supplier<L> supplier) {
        return i10 < 1024 ? new SmallLazyStriped(i10, supplier) : new LargeLazyStriped(i10, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i10) {
        return lazy(i10, new Supplier<Lock>() { // from class: com.google.common.util.concurrent.Striped.2
            @Override // com.google.common.base.Supplier
            public Lock get() {
                return new ReentrantLock(false);
            }
        });
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i10) {
        return lazy(i10, WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i10, final int i11) {
        return lazy(i10, new Supplier<Semaphore>() { // from class: com.google.common.util.concurrent.Striped.4
            @Override // com.google.common.base.Supplier
            public Semaphore get() {
                return new Semaphore(i11, false);
            }
        });
    }

    public static Striped<Lock> lock(int i10) {
        return custom(i10, new Supplier<Lock>() { // from class: com.google.common.util.concurrent.Striped.1
            @Override // com.google.common.base.Supplier
            public Lock get() {
                return new PaddedLock();
            }
        });
    }

    public static Striped<ReadWriteLock> readWriteLock(int i10) {
        return custom(i10, READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> semaphore(int i10, final int i11) {
        return custom(i10, new Supplier<Semaphore>() { // from class: com.google.common.util.concurrent.Striped.3
            @Override // com.google.common.base.Supplier
            public Semaphore get() {
                return new PaddedSemaphore(i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int smear(int i10) {
        int i11 = i10 ^ ((i10 >>> 20) ^ (i10 >>> 12));
        return (i11 >>> 4) ^ ((i11 >>> 7) ^ i11);
    }

    public Iterable<L> bulkGet(Iterable<?> iterable) {
        Object[] array = Iterables.toArray(iterable, Object.class);
        if (array.length == 0) {
            return ImmutableList.of();
        }
        int[] iArr = new int[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            iArr[i10] = indexFor(array[i10]);
        }
        Arrays.sort(iArr);
        int i11 = iArr[0];
        array[0] = getAt(i11);
        for (int i12 = 1; i12 < array.length; i12++) {
            int i13 = iArr[i12];
            if (i13 == i11) {
                array[i12] = array[i12 - 1];
            } else {
                array[i12] = getAt(i13);
                i11 = i13;
            }
        }
        return Collections.unmodifiableList(Arrays.asList(array));
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i10);

    public abstract int indexFor(Object obj);

    public abstract int size();

    private Striped() {
    }
}
