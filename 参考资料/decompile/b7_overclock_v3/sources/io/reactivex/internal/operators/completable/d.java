package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f33087b;

    public static final class a implements xi.d, io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0 f33089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f33091d;

        public a(xi.d dVar, h0 h0Var) {
            this.f33088a = dVar;
            this.f33089b = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33091d = true;
            this.f33089b.f(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33091d;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            if (this.f33091d) {
                return;
            }
            this.f33088a.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            if (this.f33091d) {
                kj.a.Y(th2);
            } else {
                this.f33088a.onError(th2);
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33090c, bVar)) {
                this.f33090c = bVar;
                this.f33088a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33090c.dispose();
            this.f33090c = DisposableHelper.DISPOSED;
        }
    }

    public d(xi.g gVar, h0 h0Var) {
        this.f33086a = gVar;
        this.f33087b = h0Var;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33086a.a(new a(dVar, this.f33087b));
    }
}
