package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends U> f34613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.b<? super U, ? super T> f34614c;

    public static final class a<T, U> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super U> f34615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.b<? super U, ? super T> f34616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final U f34617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34619e;

        public a(xi.g0<? super U> g0Var, U u6, dj.b<? super U, ? super T> bVar) {
            this.f34615a = g0Var;
            this.f34616b = bVar;
            this.f34617c = u6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34618d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34618d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34619e) {
                return;
            }
            this.f34619e = true;
            this.f34615a.onNext(this.f34617c);
            this.f34615a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34619e) {
                kj.a.Y(th2);
            } else {
                this.f34619e = true;
                this.f34615a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34619e) {
                return;
            }
            try {
                this.f34616b.a(this.f34617c, t10);
            } catch (Throwable th2) {
                this.f34618d.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34618d, bVar)) {
                this.f34618d = bVar;
                this.f34615a.onSubscribe(this);
            }
        }
    }

    public n(xi.e0<T> e0Var, Callable<? extends U> callable, dj.b<? super U, ? super T> bVar) {
        super(e0Var);
        this.f34613b = callable;
        this.f34614c = bVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        try {
            this.f34421a.c(new a(g0Var, io.reactivex.internal.functions.a.g(this.f34613b.call(), "The initialSupplier returned a null value"), this.f34614c));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, g0Var);
        }
    }
}
