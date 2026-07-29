package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
@Deprecated
public abstract class AbstractCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements CheckedFuture<V, X> {
    public AbstractCheckedFuture(ListenableFuture<V> listenableFuture) {
        super(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    @CanIgnoreReturnValue
    public V checkedGet() throws Exception {
        try {
            return get();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw mapException(e10);
        } catch (CancellationException e11) {
            e = e11;
            throw mapException(e);
        } catch (ExecutionException e12) {
            e = e12;
            throw mapException(e);
        }
    }

    public abstract X mapException(Exception exc);

    @Override // com.google.common.util.concurrent.CheckedFuture
    @CanIgnoreReturnValue
    public V checkedGet(long j10, TimeUnit timeUnit) throws Exception {
        try {
            return get(j10, timeUnit);
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw mapException(e10);
        } catch (CancellationException e11) {
            e = e11;
            throw mapException(e);
        } catch (ExecutionException e12) {
            e = e12;
            throw mapException(e);
        }
    }
}
