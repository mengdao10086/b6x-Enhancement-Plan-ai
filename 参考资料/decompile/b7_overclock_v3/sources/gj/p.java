package gj;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class p<T> implements xi.d, bu.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.d<? super T> f29614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.reactivex.disposables.b f29615b;

    public p(bu.d<? super T> dVar) {
        this.f29614a = dVar;
    }

    @Override // bu.e
    public void cancel() {
        this.f29615b.dispose();
    }

    @Override // xi.d, xi.t
    public void onComplete() {
        this.f29614a.onComplete();
    }

    @Override // xi.d
    public void onError(Throwable th2) {
        this.f29614a.onError(th2);
    }

    @Override // xi.d
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f29615b, bVar)) {
            this.f29615b = bVar;
            this.f29614a.onSubscribe(this);
        }
    }

    @Override // bu.e
    public void request(long j10) {
    }
}
