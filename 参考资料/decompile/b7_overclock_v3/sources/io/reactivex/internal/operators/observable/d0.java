package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class d0<T> extends xi.q<T> implements fj.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34478b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f34479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f34482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34483e;

        public a(xi.t<? super T> tVar, long j10) {
            this.f34479a = tVar;
            this.f34480b = j10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34481c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34481c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34483e) {
                return;
            }
            this.f34483e = true;
            this.f34479a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34483e) {
                kj.a.Y(th2);
            } else {
                this.f34483e = true;
                this.f34479a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34483e) {
                return;
            }
            long j10 = this.f34482d;
            if (j10 != this.f34480b) {
                this.f34482d = j10 + 1;
                return;
            }
            this.f34483e = true;
            this.f34481c.dispose();
            this.f34479a.onSuccess(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34481c, bVar)) {
                this.f34481c = bVar;
                this.f34479a.onSubscribe(this);
            }
        }
    }

    public d0(xi.e0<T> e0Var, long j10) {
        this.f34477a = e0Var;
        this.f34478b = j10;
    }

    @Override // fj.d
    public xi.z<T> b() {
        return kj.a.U(new c0(this.f34477a, this.f34478b, null, false));
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f34477a.c(new a(tVar, this.f34478b));
    }
}
