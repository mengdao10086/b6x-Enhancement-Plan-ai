package io.reactivex.internal.observers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements g0<T> {
    private static final long serialVersionUID = -266195175408988651L;
    public b upstream;

    public DeferredScalarObserver(g0<? super R> g0Var) {
        super(g0Var);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // xi.g0
    public void onComplete() {
        T t10 = this.value;
        if (t10 == null) {
            a();
        } else {
            this.value = null;
            b(t10);
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        this.value = null;
        e(th2);
    }

    @Override // xi.g0
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
