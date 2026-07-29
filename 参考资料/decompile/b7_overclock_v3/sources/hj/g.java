package hj;

import io.reactivex.internal.subscribers.InnerQueuedSubscriber;

/* JADX INFO: loaded from: classes5.dex */
public interface g<T> {
    void a(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void b();

    void c(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t10);

    void d(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th2);
}
