package io.reactivex.internal.operators.completable;

/* JADX INFO: loaded from: classes5.dex */
public final class q extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.f f33114b;

    public q(xi.g gVar, xi.f fVar) {
        this.f33113a = gVar;
        this.f33114b = fVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        try {
            this.f33113a.a(this.f33114b.a(dVar));
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }
}
