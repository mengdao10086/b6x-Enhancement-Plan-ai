package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());

    @NullableDecl
    private AggregateFuture<InputT, OutputT>.RunningState runningState;

    public abstract class RunningState extends AggregateFutureState implements Runnable {
        private final boolean allMustSucceed;
        private final boolean collectsValues;
        private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

        public RunningState(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z10, boolean z11) {
            super(immutableCollection.size());
            this.futures = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
            this.allMustSucceed = z10;
            this.collectsValues = z11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decrementCountAndMaybeComplete() {
            int iDecrementRemainingAndGet = decrementRemainingAndGet();
            Preconditions.checkState(iDecrementRemainingAndGet >= 0, "Less than 0 remaining futures");
            if (iDecrementRemainingAndGet == 0) {
                processCompleted();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void handleException(java.lang.Throwable r6) {
            /*
                r5 = this;
                com.google.common.base.Preconditions.checkNotNull(r6)
                boolean r0 = r5.allMustSucceed
                r1 = 1
                if (r0 == 0) goto L1d
                com.google.common.util.concurrent.AggregateFuture r0 = com.google.common.util.concurrent.AggregateFuture.this
                boolean r0 = r0.setException(r6)
                if (r0 == 0) goto L14
                r5.releaseResourcesAfterFailure()
                goto L1e
            L14:
                java.util.Set r2 = r5.getOrInitSeenExceptions()
                boolean r2 = com.google.common.util.concurrent.AggregateFuture.access$400(r2, r6)
                goto L1f
            L1d:
                r0 = 0
            L1e:
                r2 = 1
            L1f:
                boolean r3 = r6 instanceof java.lang.Error
                boolean r4 = r5.allMustSucceed
                r0 = r0 ^ r1
                r0 = r0 & r4
                r0 = r0 & r2
                r0 = r0 | r3
                if (r0 == 0) goto L39
                if (r3 == 0) goto L2e
                java.lang.String r0 = "Input Future failed with Error"
                goto L30
            L2e:
                java.lang.String r0 = "Got more than one input Future failure. Logging failures after the first"
            L30:
                java.util.logging.Logger r1 = com.google.common.util.concurrent.AggregateFuture.access$500()
                java.util.logging.Level r2 = java.util.logging.Level.SEVERE
                r1.log(r2, r0, r6)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AggregateFuture.RunningState.handleException(java.lang.Throwable):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleOneInputDone(int i10, Future<? extends InputT> future) {
            Preconditions.checkState(this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (this.allMustSucceed) {
                    if (future.isCancelled()) {
                        AggregateFuture.this.runningState = null;
                        AggregateFuture.this.cancel(false);
                    } else {
                        Object done = Futures.getDone(future);
                        if (this.collectsValues) {
                            collectOneValue(this.allMustSucceed, i10, done);
                        }
                    }
                } else if (this.collectsValues && !future.isCancelled()) {
                    collectOneValue(this.allMustSucceed, i10, Futures.getDone(future));
                }
            } catch (ExecutionException e10) {
                handleException(e10.getCause());
            } catch (Throwable th2) {
                handleException(th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init() {
            if (this.futures.isEmpty()) {
                handleAllCompleted();
                return;
            }
            if (!this.allMustSucceed) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
                while (it2.hasNext()) {
                    it2.next().addListener(this, MoreExecutors.directExecutor());
                }
                return;
            }
            final int i10 = 0;
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it3 = this.futures.iterator();
            while (it3.hasNext()) {
                final ListenableFuture<? extends InputT> next = it3.next();
                next.addListener(new Runnable() { // from class: com.google.common.util.concurrent.AggregateFuture.RunningState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            RunningState.this.handleOneInputDone(i10, next);
                        } finally {
                            RunningState.this.decrementCountAndMaybeComplete();
                        }
                    }
                }, MoreExecutors.directExecutor());
                i10++;
            }
        }

        private void processCompleted() {
            if (this.collectsValues & (!this.allMustSucceed)) {
                int i10 = 0;
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
                while (it2.hasNext()) {
                    handleOneInputDone(i10, it2.next());
                    i10++;
                }
            }
            handleAllCompleted();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState
        public final void addInitialException(Set<Throwable> set) {
            if (AggregateFuture.this.isCancelled()) {
                return;
            }
            AggregateFuture.addCausalChain(set, AggregateFuture.this.tryInternalFastPathGetFailure());
        }

        public abstract void collectOneValue(boolean z10, int i10, @NullableDecl InputT inputt);

        public abstract void handleAllCompleted();

        public void interruptTask() {
        }

        @ForOverride
        @OverridingMethodsMustInvokeSuper
        public void releaseResourcesAfterFailure() {
            this.futures = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            decrementCountAndMaybeComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean addCausalChain(Set<Throwable> set, Throwable th2) {
        while (th2 != null) {
            if (!set.add(th2)) {
                return false;
            }
            th2 = th2.getCause();
        }
        return true;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.runningState;
        if (runningState != null) {
            this.runningState = null;
            ImmutableCollection immutableCollection = ((RunningState) runningState).futures;
            boolean zWasInterrupted = wasInterrupted();
            if (zWasInterrupted) {
                runningState.interruptTask();
            }
            if (isCancelled() && (immutableCollection != null)) {
                UnmodifiableIterator it2 = immutableCollection.iterator();
                while (it2.hasNext()) {
                    ((ListenableFuture) it2.next()).cancel(zWasInterrupted);
                }
            }
        }
    }

    public final void init(AggregateFuture<InputT, OutputT>.RunningState runningState) {
        this.runningState = runningState;
        runningState.init();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ImmutableCollection immutableCollection;
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.runningState;
        if (runningState == null || (immutableCollection = ((RunningState) runningState).futures) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }
}
