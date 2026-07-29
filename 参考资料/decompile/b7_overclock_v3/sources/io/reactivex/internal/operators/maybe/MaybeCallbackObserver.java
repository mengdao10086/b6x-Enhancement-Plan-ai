package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b, io.reactivex.observers.f {
    private static final long serialVersionUID = -6076952298809384986L;
    public final dj.a onComplete;
    public final dj.g<? super Throwable> onError;
    public final dj.g<? super T> onSuccess;

    public MaybeCallbackObserver(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.observers.f
    public boolean a() {
        return this.onError != Functions.f32984f;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xi.t
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }

    @Override // xi.t
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(new CompositeException(th2, th3));
        }
    }

    @Override // xi.t
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // xi.t
    public void onSuccess(T t10) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t10);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }
}
