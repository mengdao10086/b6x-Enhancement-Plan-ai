package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class g0<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends T> f33948b;

    public static final class a<T> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super Throwable, ? extends T> f33950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33951c;

        public a(xi.t<? super T> tVar, dj.o<? super Throwable, ? extends T> oVar) {
            this.f33949a = tVar;
            this.f33950b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33951c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33951c.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.f33949a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            try {
                this.f33949a.onSuccess(io.reactivex.internal.functions.a.g(this.f33950b.apply(th2), "The valueSupplier returned a null value"));
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f33949a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33951c, bVar)) {
                this.f33951c = bVar;
                this.f33949a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33949a.onSuccess(t10);
        }
    }

    public g0(xi.w<T> wVar, dj.o<? super Throwable, ? extends T> oVar) {
        super(wVar);
        this.f33948b = oVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new a(tVar, this.f33948b));
    }
}
