package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class m<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f33980b;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f33982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33983c;

        public a(xi.t<? super T> tVar, dj.r<? super T> rVar) {
            this.f33981a = tVar;
            this.f33982b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f33983c;
            this.f33983c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33983c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33981a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33981a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33983c, bVar)) {
                this.f33983c = bVar;
                this.f33981a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                if (this.f33982b.a(t10)) {
                    this.f33981a.onSuccess(t10);
                } else {
                    this.f33981a.onComplete();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33981a.onError(th2);
            }
        }
    }

    public m(xi.w<T> wVar, dj.r<? super T> rVar) {
        super(wVar);
        this.f33980b = rVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar, this.f33980b));
    }
}
