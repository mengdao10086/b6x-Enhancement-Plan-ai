package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -8612022020200669122L;
    public final xi.g0<? super T> downstream;
    public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(xi.g0<? super T> g0Var) {
        this.downstream = g0Var;
    }

    public void a(io.reactivex.disposables.b bVar) {
        DisposableHelper.set(this, bVar);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // xi.g0
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        dispose();
        this.downstream.onError(th2);
    }

    @Override // xi.g0
    public void onNext(T t10) {
        this.downstream.onNext(t10);
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }
}
