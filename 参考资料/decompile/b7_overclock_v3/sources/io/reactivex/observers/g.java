package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g implements xi.d, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f35290a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ej.b f35291b = new ej.b();

    public final void a(@bj.e io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "resource is null");
        this.f35291b.b(bVar);
    }

    public void b() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        if (DisposableHelper.dispose(this.f35290a)) {
            this.f35291b.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f35290a.get());
    }

    @Override // xi.d
    public final void onSubscribe(@bj.e io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.d(this.f35290a, bVar, getClass())) {
            b();
        }
    }
}
