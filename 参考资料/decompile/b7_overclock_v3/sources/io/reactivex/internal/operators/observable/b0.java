package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class b0<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super io.reactivex.disposables.b> f34438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.a f34439c;

    public b0(xi.z<T> zVar, dj.g<? super io.reactivex.disposables.b> gVar, dj.a aVar) {
        super(zVar);
        this.f34438b = gVar;
        this.f34439c = aVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new gj.g(g0Var, this.f34438b, this.f34439c));
    }
}
