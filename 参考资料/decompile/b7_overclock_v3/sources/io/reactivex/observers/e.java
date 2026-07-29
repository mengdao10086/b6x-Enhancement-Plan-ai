package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e<T> implements l0<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f35289a = new AtomicReference<>();

    public void a() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.f35289a);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f35289a.get() == DisposableHelper.DISPOSED;
    }

    @Override // xi.l0
    public final void onSubscribe(@bj.e io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.d(this.f35289a, bVar, getClass())) {
            a();
        }
    }
}
