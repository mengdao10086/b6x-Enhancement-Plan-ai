package io.reactivex.internal.subscriptions;

import bj.f;
import bu.d;
import fj.l;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35246a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f35247b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f35248c = 2;
    private static final long serialVersionUID = -3830916580126663321L;
    public final d<? super T> subscriber;
    public final T value;

    public ScalarSubscription(d<? super T> dVar, T t10) {
        this.subscriber = dVar;
        this.value = t10;
    }

    public boolean a() {
        return get() == 2;
    }

    @Override // bu.e
    public void cancel() {
        lazySet(2);
    }

    @Override // fj.o
    public void clear() {
        lazySet(1);
    }

    @Override // fj.o
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // fj.o
    public boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // fj.o
    @f
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // bu.e
    public void request(long j10) {
        if (SubscriptionHelper.validate(j10) && compareAndSet(0, 1)) {
            d<? super T> dVar = this.subscriber;
            dVar.onNext(this.value);
            if (get() != 2) {
                dVar.onComplete();
            }
        }
    }

    @Override // fj.k
    public int requestFusion(int i10) {
        return i10 & 1;
    }

    @Override // fj.o
    public boolean offer(T t10, T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
