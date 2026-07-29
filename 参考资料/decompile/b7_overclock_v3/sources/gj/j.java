package gj;

import io.reactivex.internal.observers.InnerQueuedObserver;

/* JADX INFO: loaded from: classes5.dex */
public interface j<T> {
    void b();

    void c(InnerQueuedObserver<T> innerQueuedObserver, Throwable th2);

    void d(InnerQueuedObserver<T> innerQueuedObserver);

    void f(InnerQueuedObserver<T> innerQueuedObserver, T t10);
}
