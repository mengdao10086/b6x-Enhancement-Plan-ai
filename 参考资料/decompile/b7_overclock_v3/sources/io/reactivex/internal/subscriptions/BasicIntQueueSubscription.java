package io.reactivex.internal.subscriptions;

import fj.l;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements l<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // fj.o
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // fj.o
    public final boolean offer(T t10, T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
