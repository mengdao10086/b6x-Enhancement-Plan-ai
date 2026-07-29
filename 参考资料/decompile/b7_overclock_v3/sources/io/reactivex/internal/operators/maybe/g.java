package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super T> f33944b;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.g<? super T> f33946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33947c;

        public a(xi.t<? super T> tVar, dj.g<? super T> gVar) {
            this.f33945a = tVar;
            this.f33946b = gVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33947c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33947c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33945a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33945a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33947c, bVar)) {
                this.f33947c = bVar;
                this.f33945a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33945a.onSuccess(t10);
            try {
                this.f33946b.accept(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }
    }

    public g(xi.w<T> wVar, dj.g<? super T> gVar) {
        super(wVar);
        this.f33944b = gVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar, this.f33944b));
    }
}
