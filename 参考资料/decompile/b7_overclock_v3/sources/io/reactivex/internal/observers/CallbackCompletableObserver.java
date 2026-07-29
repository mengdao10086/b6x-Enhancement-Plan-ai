package io.reactivex.internal.observers;

import dj.a;
import dj.g;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.f;
import java.util.concurrent.atomic.AtomicReference;
import xi.d;

/* JADX INFO: loaded from: classes5.dex */
public final class CallbackCompletableObserver extends AtomicReference<b> implements d, b, g<Throwable>, f {
    private static final long serialVersionUID = -4361286194466301354L;
    public final a onComplete;
    public final g<? super Throwable> onError;

    public CallbackCompletableObserver(a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.observers.f
    public boolean a() {
        return this.onError != this;
    }

    @Override // dj.g
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th2) {
        kj.a.Y(new OnErrorNotImplementedException(th2));
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
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // xi.d
    public void onError(Throwable th2) {
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(th3);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // xi.d
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public CallbackCompletableObserver(g<? super Throwable> gVar, a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }
}
