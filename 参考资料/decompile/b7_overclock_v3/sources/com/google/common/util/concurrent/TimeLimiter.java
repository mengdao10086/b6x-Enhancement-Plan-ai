package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public interface TimeLimiter {
    @CanIgnoreReturnValue
    <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) throws ExecutionException, TimeoutException;

    @CanIgnoreReturnValue
    <T> T callWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException;

    <T> T newProxy(T t10, Class<T> cls, long j10, TimeUnit timeUnit);

    void runUninterruptiblyWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) throws TimeoutException;

    void runWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException;
}
