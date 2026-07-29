package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f33966b;

    public final class a implements xi.t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33967a;

        public a(xi.t<? super T> tVar) {
            this.f33967a = tVar;
        }

        @Override // xi.t
        public void onComplete() {
            try {
                i.this.f33966b.run();
                this.f33967a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33967a.onError(th2);
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            try {
                i.this.f33966b.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f33967a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33967a.onSubscribe(bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                i.this.f33966b.run();
                this.f33967a.onSuccess(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33967a.onError(th2);
            }
        }
    }

    public i(xi.w<T> wVar, dj.a aVar) {
        this.f33965a = wVar;
        this.f33966b = aVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33965a.a(new a(tVar));
    }
}
