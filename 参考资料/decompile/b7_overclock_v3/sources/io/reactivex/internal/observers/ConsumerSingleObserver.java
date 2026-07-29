package io.reactivex.internal.observers;

import dj.g;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.f;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<b> implements l0<T>, b, f {
    private static final long serialVersionUID = -7012088219455310787L;
    public final g<? super Throwable> onError;
    public final g<? super T> onSuccess;

    public ConsumerSingleObserver(g<? super T> gVar, g<? super Throwable> gVar2) {
        this.onSuccess = gVar;
        this.onError = gVar2;
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // xi.l0
    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            a.b(th3);
            kj.a.Y(new CompositeException(th2, th3));
        }
    }

    @Override // xi.l0
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // xi.l0
    public void onSuccess(T t10) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t10);
        } catch (Throwable th2) {
            a.b(th2);
            kj.a.Y(th2);
        }
    }
}
