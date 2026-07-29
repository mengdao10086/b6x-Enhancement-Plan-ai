package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super Throwable> f33093b;

    public final class a implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33094a;

        public a(xi.d dVar) {
            this.f33094a = dVar;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            try {
                e.this.f33093b.accept(null);
                this.f33094a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33094a.onError(th2);
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            try {
                e.this.f33093b.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f33094a.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33094a.onSubscribe(bVar);
        }
    }

    public e(xi.g gVar, dj.g<? super Throwable> gVar2) {
        this.f33092a = gVar;
        this.f33093b = gVar2;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33092a.a(new a(dVar));
    }
}
