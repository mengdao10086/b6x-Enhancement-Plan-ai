package io.reactivex.internal.observers;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.f;
import java.util.concurrent.atomic.AtomicReference;
import kj.a;
import xi.d;

/* JADX INFO: loaded from: classes5.dex */
public final class EmptyCompletableObserver extends AtomicReference<b> implements d, b, f {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // io.reactivex.observers.f
    public boolean a() {
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // xi.d, xi.t
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // xi.d
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        a.Y(new OnErrorNotImplementedException(th2));
    }

    @Override // xi.d
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
