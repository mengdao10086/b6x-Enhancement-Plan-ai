package com.google.common.util.concurrent;

import al.o;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes7.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
abstract class AggregateFutureState {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2);

        public abstract int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState);
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        public final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
        public final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            o.a(this.seenExceptionsUpdater, aggregateFutureState, set, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.seenExceptions == set) {
                    aggregateFutureState.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            int i10;
            synchronized (aggregateFutureState) {
                AggregateFutureState.access$310(aggregateFutureState);
                i10 = aggregateFutureState.remaining;
            }
            return i10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AtomicHelper synchronizedAtomicHelper;
        Throwable th2 = null;
        Object[] objArr = 0;
        try {
            synchronizedAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
        } catch (Throwable th3) {
            synchronizedAtomicHelper = new SynchronizedAtomicHelper();
            th2 = th3;
        }
        ATOMIC_HELPER = synchronizedAtomicHelper;
        if (th2 != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }

    public AggregateFutureState(int i10) {
        this.remaining = i10;
    }

    public static /* synthetic */ int access$310(AggregateFutureState aggregateFutureState) {
        int i10 = aggregateFutureState.remaining;
        aggregateFutureState.remaining = i10 - 1;
        return i10;
    }

    public abstract void addInitialException(Set<Throwable> set);

    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> setNewConcurrentHashSet = Sets.newConcurrentHashSet();
        addInitialException(setNewConcurrentHashSet);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, setNewConcurrentHashSet);
        return this.seenExceptions;
    }
}
