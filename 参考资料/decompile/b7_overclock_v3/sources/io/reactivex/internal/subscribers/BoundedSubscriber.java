package io.reactivex.internal.subscribers;

import bu.e;
import dj.a;
import dj.g;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.f;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class BoundedSubscriber<T> extends AtomicReference<e> implements o<T>, e, b, f {
    private static final long serialVersionUID = -7251123623727029452L;
    public final int bufferSize;
    public int consumed;
    public final int limit;
    public final a onComplete;
    public final g<? super Throwable> onError;
    public final g<? super T> onNext;
    public final g<? super e> onSubscribe;

    public BoundedSubscriber(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super e> gVar3, int i10) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
        this.bufferSize = i10;
        this.limit = i10 - (i10 >> 2);
    }

    @Override // io.reactivex.observers.f
    public boolean a() {
        return this.onError != Functions.f32984f;
    }

    @Override // bu.e
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // bu.d
    public void onComplete() {
        e eVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (eVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        e eVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (eVar == subscriptionHelper) {
            kj.a.Y(th2);
            return;
        }
        lazySet(subscriptionHelper);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(new CompositeException(th2, th3));
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t10);
            int i10 = this.consumed + 1;
            if (i10 == this.limit) {
                this.consumed = 0;
                get().request(this.limit);
            } else {
                this.consumed = i10;
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            get().cancel();
            onError(th2);
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(e eVar) {
        if (SubscriptionHelper.setOnce(this, eVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                eVar.cancel();
                onError(th2);
            }
        }
    }

    @Override // bu.e
    public void request(long j10) {
        get().request(j10);
    }
}
