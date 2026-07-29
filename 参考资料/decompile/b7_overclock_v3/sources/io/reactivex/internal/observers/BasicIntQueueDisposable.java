package io.reactivex.internal.observers;

import fj.j;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements j<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // fj.o
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // fj.o
    public final boolean offer(T t10, T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
