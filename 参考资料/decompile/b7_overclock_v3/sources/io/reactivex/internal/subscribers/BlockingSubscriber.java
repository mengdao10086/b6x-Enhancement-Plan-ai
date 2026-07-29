package io.reactivex.internal.subscribers;

import bu.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingSubscriber<T> extends AtomicReference<e> implements o<T>, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f35235a = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue) {
        this.queue = queue;
    }

    public boolean a() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // bu.e
    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(f35235a);
        }
    }

    @Override // bu.d
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        this.queue.offer(NotificationLite.error(th2));
    }

    @Override // bu.d
    public void onNext(T t10) {
        this.queue.offer(NotificationLite.next(t10));
    }

    @Override // xi.o, bu.d
    public void onSubscribe(e eVar) {
        if (SubscriptionHelper.setOnce(this, eVar)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    @Override // bu.e
    public void request(long j10) {
        get().request(j10);
    }
}
