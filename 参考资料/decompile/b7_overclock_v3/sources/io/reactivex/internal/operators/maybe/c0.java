package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class c0<T, R> extends io.reactivex.internal.operators.maybe.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends R> f33928b;

    public static final class a<T, R> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super R> f33929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends R> f33930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33931c;

        public a(xi.t<? super R> tVar, dj.o<? super T, ? extends R> oVar) {
            this.f33929a = tVar;
            this.f33930b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f33931c;
            this.f33931c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33931c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33929a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33929a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33931c, bVar)) {
                this.f33931c = bVar;
                this.f33929a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                this.f33929a.onSuccess(io.reactivex.internal.functions.a.g(this.f33930b.apply(t10), "The mapper returned a null item"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33929a.onError(th2);
            }
        }
    }

    public c0(xi.w<T> wVar, dj.o<? super T, ? extends R> oVar) {
        super(wVar);
        this.f33928b = oVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        this.f33914a.a(new a(tVar, this.f33928b));
    }
}
