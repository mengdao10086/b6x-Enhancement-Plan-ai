package io.reactivex.internal.subscriptions;

import bj.f;
import bu.d;
import fj.l;

/* JADX INFO: loaded from: classes5.dex */
public enum EmptySubscription implements l<Object> {
    INSTANCE;

    public static void complete(d<?> dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onComplete();
    }

    public static void error(Throwable th2, d<?> dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onError(th2);
    }

    @Override // bu.e
    public void cancel() {
    }

    @Override // fj.o
    public void clear() {
    }

    @Override // fj.o
    public boolean isEmpty() {
        return true;
    }

    @Override // fj.o
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // fj.o
    @f
    public Object poll() {
        return null;
    }

    @Override // bu.e
    public void request(long j10) {
        SubscriptionHelper.validate(j10);
    }

    @Override // fj.k
    public int requestFusion(int i10) {
        return i10 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // fj.o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
