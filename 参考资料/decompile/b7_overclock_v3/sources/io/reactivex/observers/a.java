package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> implements g0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public io.reactivex.disposables.b f35285a;

    public final void a() {
        io.reactivex.disposables.b bVar = this.f35285a;
        this.f35285a = DisposableHelper.DISPOSED;
        bVar.dispose();
    }

    public void b() {
    }

    @Override // xi.g0
    public final void onSubscribe(@bj.e io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.f(this.f35285a, bVar, getClass())) {
            this.f35285a = bVar;
            b();
        }
    }
}
