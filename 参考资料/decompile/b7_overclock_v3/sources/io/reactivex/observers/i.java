package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i<T> implements g0<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f35294a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ej.b f35295b = new ej.b();

    public final void a(@bj.e io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "resource is null");
        this.f35295b.b(bVar);
    }

    public void b() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        if (DisposableHelper.dispose(this.f35294a)) {
            this.f35295b.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f35294a.get());
    }

    @Override // xi.g0
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.d(this.f35294a, bVar, getClass())) {
            b();
        }
    }
}
