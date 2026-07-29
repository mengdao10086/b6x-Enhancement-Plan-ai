package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {

    @NullableDecl
    public F function;

    @NullableDecl
    public ListenableFuture<? extends I> inputFuture;

    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, @NullableDecl I i10) throws Exception {
            ListenableFuture<? extends O> listenableFutureApply = asyncFunction.apply(i10);
            Preconditions.checkNotNull(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        public TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(@NullableDecl O o10) {
            set(o10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @NullableDecl
        public O doTransform(Function<? super I, ? extends O> function, @NullableDecl I i10) {
            return function.apply(i10);
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f10) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.function = (F) Preconditions.checkNotNull(f10);
    }

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @NullableDecl
    @ForOverride
    public abstract T doTransform(F f10, @NullableDecl I i10) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f10 = this.function;
        String strPendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f10 != null) {
            return str + "function=[" + f10 + "]";
        }
        if (strPendingToString == null) {
            return null;
        }
        return str + strPendingToString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f10 = this.function;
        if ((isCancelled() | (listenableFuture == null)) || (f10 == null)) {
            return;
        }
        this.inputFuture = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object objDoTransform = doTransform(f10, Futures.getDone(listenableFuture));
                this.function = null;
                setResult(objDoTransform);
            } catch (Throwable th2) {
                try {
                    setException(th2);
                } finally {
                    this.function = null;
                }
            }
        } catch (Error e10) {
            setException(e10);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e11) {
            setException(e11);
        } catch (ExecutionException e12) {
            setException(e12.getCause());
        }
    }

    @ForOverride
    public abstract void setResult(@NullableDecl T t10);

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function);
        listenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, transformFuture));
        return transformFuture;
    }
}
