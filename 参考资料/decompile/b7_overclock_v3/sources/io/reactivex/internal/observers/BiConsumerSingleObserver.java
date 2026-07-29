package io.reactivex.internal.observers;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<b> implements l0<T>, b {
    private static final long serialVersionUID = 4943102778943297569L;
    public final dj.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(dj.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
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
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.a(null, th2);
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
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.a(t10, null);
        } catch (Throwable th2) {
            a.b(th2);
            kj.a.Y(th2);
        }
    }
}
