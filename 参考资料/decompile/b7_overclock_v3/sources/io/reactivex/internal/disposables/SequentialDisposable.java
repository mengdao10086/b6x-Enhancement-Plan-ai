package io.reactivex.internal.disposables;

import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class SequentialDisposable extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public boolean a(b bVar) {
        return DisposableHelper.replace(this, bVar);
    }

    public boolean b(b bVar) {
        return DisposableHelper.set(this, bVar);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public SequentialDisposable(b bVar) {
        lazySet(bVar);
    }
}
