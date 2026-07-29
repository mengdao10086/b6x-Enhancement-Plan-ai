package io.reactivex.disposables;

import bj.e;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(T t10) {
        super(io.reactivex.internal.functions.a.g(t10, "value is null"));
    }

    public abstract void a(@e T t10);

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return get() == null;
    }
}
