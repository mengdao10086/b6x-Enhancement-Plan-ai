package io.reactivex.internal.subscriptions;

import bu.e;
import ee.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class BooleanSubscription extends AtomicBoolean implements e {
    private static final long serialVersionUID = -8127758972444290902L;

    public boolean a() {
        return get();
    }

    @Override // bu.e
    public void cancel() {
        lazySet(true);
    }

    @Override // bu.e
    public void request(long j10) {
        SubscriptionHelper.validate(j10);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + a.f26979d;
    }
}
