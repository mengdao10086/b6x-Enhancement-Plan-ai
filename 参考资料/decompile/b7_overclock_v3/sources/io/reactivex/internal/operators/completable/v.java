package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;

/* JADX INFO: loaded from: classes5.dex */
public final class v extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super Throwable> f33124b;

    public final class a implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33125a;

        public a(xi.d dVar) {
            this.f33125a = dVar;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.f33125a.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            try {
                if (v.this.f33124b.a(th2)) {
                    this.f33125a.onComplete();
                } else {
                    this.f33125a.onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f33125a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33125a.onSubscribe(bVar);
        }
    }

    public v(xi.g gVar, dj.r<? super Throwable> rVar) {
        this.f33123a = gVar;
        this.f33124b = rVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33123a.a(new a(dVar));
    }
}
