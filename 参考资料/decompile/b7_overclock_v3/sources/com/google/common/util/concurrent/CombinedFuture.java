package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        public AsyncCallableInterruptibleTask(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            this.callable = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(ListenableFuture<V> listenableFuture) {
            CombinedFuture.this.setFuture(listenableFuture);
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;

        public CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            this.callable = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v10) {
            CombinedFuture.this.set(v10);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        public boolean thrownByExecute = true;

        public CombinedFutureInterruptibleTask(Executor executor) {
            this.listenerExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T t10, Throwable th2) {
            if (th2 == null) {
                setValue(t10);
                return;
            }
            if (th2 instanceof ExecutionException) {
                CombinedFuture.this.setException(th2.getCause());
            } else if (th2 instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
            } else {
                CombinedFuture.this.setException(th2);
            }
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e10) {
                if (this.thrownByExecute) {
                    CombinedFuture.this.setException(e10);
                }
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return CombinedFuture.this.isDone();
        }

        public abstract void setValue(T t10);
    }

    public final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
        private CombinedFutureInterruptibleTask task;

        public CombinedFutureRunningState(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z10, CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
            super(immutableCollection, z10, false);
            this.task = combinedFutureInterruptibleTask;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void collectOneValue(boolean z10, int i10, @NullableDecl Object obj) {
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void handleAllCompleted() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.execute();
            } else {
                Preconditions.checkState(CombinedFuture.this.isDone());
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void interruptTask() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.interruptTask();
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.task = null;
        }
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z10, Executor executor, AsyncCallable<V> asyncCallable) {
        init(new CombinedFutureRunningState(immutableCollection, z10, new AsyncCallableInterruptibleTask(asyncCallable, executor)));
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z10, Executor executor, Callable<V> callable) {
        init(new CombinedFutureRunningState(immutableCollection, z10, new CallableInterruptibleTask(callable, executor)));
    }
}
