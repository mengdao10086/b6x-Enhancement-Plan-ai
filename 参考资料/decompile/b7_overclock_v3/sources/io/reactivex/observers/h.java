package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.t;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h<T> implements t<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f35292a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ej.b f35293b = new ej.b();

    public final void a(@bj.e io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "resource is null");
        this.f35293b.b(bVar);
    }

    public void b() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        if (DisposableHelper.dispose(this.f35292a)) {
            this.f35293b.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f35292a.get());
    }

    @Override // xi.t
    public final void onSubscribe(@bj.e io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.d(this.f35292a, bVar, getClass())) {
            b();
        }
    }
}
