package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class i1<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.c<R, ? super T, R> f34550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<R> f34551c;

    public static final class a<T, R> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super R> f34552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<R, ? super T, R> f34553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public R f34554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34556e;

        public a(xi.g0<? super R> g0Var, dj.c<R, ? super T, R> cVar, R r10) {
            this.f34552a = g0Var;
            this.f34553b = cVar;
            this.f34554c = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34555d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34555d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34556e) {
                return;
            }
            this.f34556e = true;
            this.f34552a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34556e) {
                kj.a.Y(th2);
            } else {
                this.f34556e = true;
                this.f34552a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34556e) {
                return;
            }
            try {
                R r10 = (R) io.reactivex.internal.functions.a.g(this.f34553b.apply(this.f34554c, t10), "The accumulator returned a null value");
                this.f34554c = r10;
                this.f34552a.onNext(r10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34555d.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34555d, bVar)) {
                this.f34555d = bVar;
                this.f34552a.onSubscribe(this);
                this.f34552a.onNext(this.f34554c);
            }
        }
    }

    public i1(xi.e0<T> e0Var, Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        super(e0Var);
        this.f34550b = cVar;
        this.f34551c = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        try {
            this.f34421a.c(new a(g0Var, this.f34550b, io.reactivex.internal.functions.a.g(this.f34551c.call(), "The seed supplied is null")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
        }
    }
}
