package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements b {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    public FutureDisposable(Future<?> future, boolean z10) {
        super(future);
        this.allowInterrupt = z10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.allowInterrupt);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
