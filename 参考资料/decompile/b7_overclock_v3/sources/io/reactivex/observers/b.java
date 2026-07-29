package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements xi.d, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f35286a = new AtomicReference<>();

    public void a() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.f35286a);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f35286a.get() == DisposableHelper.DISPOSED;
    }

    @Override // xi.d
    public final void onSubscribe(@bj.e io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.d(this.f35286a, bVar, getClass())) {
            a();
        }
    }
}
