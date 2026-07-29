package io.reactivex.internal.observers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingObserver<T> extends AtomicReference<b> implements g0<T>, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f33021a = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(f33021a);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // xi.g0
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        this.queue.offer(NotificationLite.error(th2));
    }

    @Override // xi.g0
    public void onNext(T t10) {
        this.queue.offer(NotificationLite.next(t10));
    }

    @Override // xi.g0
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
