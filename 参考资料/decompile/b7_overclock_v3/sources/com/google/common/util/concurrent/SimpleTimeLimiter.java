package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    private SimpleTimeLimiter(ExecutorService executorService) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T callWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit, boolean z10) throws Exception {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<T> futureSubmit = this.executor.submit(callable);
        try {
            if (!z10) {
                return (T) Uninterruptibles.getUninterruptibly(futureSubmit, j10, timeUnit);
            }
            try {
                return futureSubmit.get(j10, timeUnit);
            } catch (InterruptedException e10) {
                futureSubmit.cancel(true);
                throw e10;
            }
        } catch (ExecutionException e11) {
            throw throwCause(e11, true);
        } catch (TimeoutException e12) {
            futureSubmit.cancel(true);
            throw new UncheckedTimeoutException(e12);
        }
    }

    private static void checkPositiveTimeout(long j10) {
        Preconditions.checkArgument(j10 > 0, "timeout must be positive: %s", j10);
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    private static boolean declaresInterruptedEx(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> cls) {
        HashSet hashSetNewHashSet = Sets.newHashSet();
        for (Method method : cls.getMethods()) {
            if (declaresInterruptedEx(method)) {
                hashSetNewHashSet.add(method);
            }
        }
        return hashSetNewHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Exception throwCause(Exception exc, boolean z10) throws Exception {
        Throwable cause = exc.getCause();
        if (cause == null) {
            throw exc;
        }
        if (z10) {
            cause.setStackTrace((StackTraceElement[]) ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw ((Exception) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw exc;
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable th2) throws ExecutionException {
        if (th2 instanceof Error) {
            throw new ExecutionError((Error) th2);
        }
        if (!(th2 instanceof RuntimeException)) {
            throw new ExecutionException(th2);
        }
        throw new UncheckedExecutionException(th2);
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable th2) {
        if (!(th2 instanceof Error)) {
            throw new UncheckedExecutionException(th2);
        }
        throw new ExecutionError((Error) th2);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<T> futureSubmit = this.executor.submit(callable);
        try {
            return (T) Uninterruptibles.getUninterruptibly(futureSubmit, j10, timeUnit);
        } catch (ExecutionException e10) {
            wrapAndThrowExecutionExceptionOrError(e10.getCause());
            throw new AssertionError();
        } catch (TimeoutException e11) {
            futureSubmit.cancel(true);
            throw e11;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(final T t10, Class<T> cls, final long j10, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(t10);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        final Set<Method> setFindInterruptibleMethods = findInterruptibleMethods(cls);
        return (T) newProxy(cls, new InvocationHandler() { // from class: com.google.common.util.concurrent.SimpleTimeLimiter.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, final Method method, final Object[] objArr) throws Throwable {
                return SimpleTimeLimiter.this.callWithTimeout(new Callable<Object>() { // from class: com.google.common.util.concurrent.SimpleTimeLimiter.1.1
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        try {
                            return method.invoke(t10, objArr);
                        } catch (InvocationTargetException e10) {
                            throw SimpleTimeLimiter.throwCause(e10, false);
                        }
                    }
                }, j10, timeUnit, setFindInterruptibleMethods.contains(method));
            }
        });
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<?> futureSubmit = this.executor.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(futureSubmit, j10, timeUnit);
        } catch (ExecutionException e10) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e10.getCause());
            throw new AssertionError();
        } catch (TimeoutException e11) {
            futureSubmit.cancel(true);
            throw e11;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j10, TimeUnit timeUnit) throws Throwable {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<?> futureSubmit = this.executor.submit(runnable);
        try {
            futureSubmit.get(j10, timeUnit);
        } catch (InterruptedException e10) {
            e = e10;
            futureSubmit.cancel(true);
            throw e;
        } catch (ExecutionException e11) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e11.getCause());
            throw new AssertionError();
        } catch (TimeoutException e12) {
            e = e12;
            futureSubmit.cancel(true);
            throw e;
        }
    }

    private static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callWithTimeout(Callable<T> callable, long j10, TimeUnit timeUnit) throws Throwable {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j10);
        Future<T> futureSubmit = this.executor.submit(callable);
        try {
            return futureSubmit.get(j10, timeUnit);
        } catch (InterruptedException e10) {
            e = e10;
            futureSubmit.cancel(true);
            throw e;
        } catch (ExecutionException e11) {
            wrapAndThrowExecutionExceptionOrError(e11.getCause());
            throw new AssertionError();
        } catch (TimeoutException e12) {
            e = e12;
            futureSubmit.cancel(true);
            throw e;
        }
    }
}
