package io.reactivex.internal.subscribers;

import bu.e;
import dj.a;
import dj.g;
import dj.r;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<e> implements o<T>, b {
    private static final long serialVersionUID = -4403180040475402120L;
    public boolean done;
    public final a onComplete;
    public final g<? super Throwable> onError;
    public final r<? super T> onNext;

    public ForEachWhileSubscriber(r<? super T> rVar, g<? super Throwable> gVar, a aVar) {
        this.onNext = rVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // bu.d
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.done) {
            kj.a.Y(th2);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(new CompositeException(th2, th3));
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.a(t10)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            dispose();
            onError(th2);
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(e eVar) {
        SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
    }
}
