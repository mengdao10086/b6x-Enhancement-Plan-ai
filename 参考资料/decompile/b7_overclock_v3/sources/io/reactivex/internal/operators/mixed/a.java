package io.reactivex.internal.operators.mixed;

import bj.d;
import io.reactivex.internal.disposables.DisposableHelper;
import xi.l0;
import xi.t;
import xi.y;

/* JADX INFO: loaded from: classes5.dex */
@d
public final class a<T> implements l0<T>, t<T>, xi.d, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0<? super y<T>> f34105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.reactivex.disposables.b f34106b;

    public a(l0<? super y<T>> l0Var) {
        this.f34105a = l0Var;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f34106b.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f34106b.isDisposed();
    }

    @Override // xi.t
    public void onComplete() {
        this.f34105a.onSuccess(y.a());
    }

    @Override // xi.l0
    public void onError(Throwable th2) {
        this.f34105a.onSuccess(y.b(th2));
    }

    @Override // xi.l0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f34106b, bVar)) {
            this.f34106b = bVar;
            this.f34105a.onSubscribe(this);
        }
    }

    @Override // xi.l0
    public void onSuccess(T t10) {
        this.f34105a.onSuccess(y.c(t10));
    }
}
