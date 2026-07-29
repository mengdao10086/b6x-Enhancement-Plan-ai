package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f33097a;

    public g(Throwable th2) {
        this.f33097a = th2;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        EmptyDisposable.error(this.f33097a, dVar);
    }
}
