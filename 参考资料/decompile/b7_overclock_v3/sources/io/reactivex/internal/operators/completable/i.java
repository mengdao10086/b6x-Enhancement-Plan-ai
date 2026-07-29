package io.reactivex.internal.operators.completable;

/* JADX INFO: loaded from: classes5.dex */
public final class i extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dj.a f33099a;

    public i(dj.a aVar) {
        this.f33099a = aVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        io.reactivex.disposables.b bVarB = io.reactivex.disposables.c.b();
        dVar.onSubscribe(bVarB);
        try {
            this.f33099a.run();
            if (bVarB.isDisposed()) {
                return;
            }
            dVar.onComplete();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            if (bVarB.isDisposed()) {
                kj.a.Y(th2);
            } else {
                dVar.onError(th2);
            }
        }
    }
}
