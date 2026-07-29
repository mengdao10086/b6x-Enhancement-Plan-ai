package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class o<T, U> extends xi.i0<U> implements fj.d<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends U> f34635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.b<? super U, ? super T> f34636c;

    public static final class a<T, U> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super U> f34637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.b<? super U, ? super T> f34638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final U f34639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34640d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34641e;

        public a(xi.l0<? super U> l0Var, U u6, dj.b<? super U, ? super T> bVar) {
            this.f34637a = l0Var;
            this.f34638b = bVar;
            this.f34639c = u6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34640d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34640d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34641e) {
                return;
            }
            this.f34641e = true;
            this.f34637a.onSuccess(this.f34639c);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34641e) {
                kj.a.Y(th2);
            } else {
                this.f34641e = true;
                this.f34637a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34641e) {
                return;
            }
            try {
                this.f34638b.a(this.f34639c, t10);
            } catch (Throwable th2) {
                this.f34640d.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34640d, bVar)) {
                this.f34640d = bVar;
                this.f34637a.onSubscribe(this);
            }
        }
    }

    public o(xi.e0<T> e0Var, Callable<? extends U> callable, dj.b<? super U, ? super T> bVar) {
        this.f34634a = e0Var;
        this.f34635b = callable;
        this.f34636c = bVar;
    }

    @Override // fj.d
    public xi.z<U> b() {
        return kj.a.U(new n(this.f34634a, this.f34635b, this.f34636c));
    }

    @Override // xi.i0
    public void b1(xi.l0<? super U> l0Var) {
        try {
            this.f34634a.c(new a(l0Var, io.reactivex.internal.functions.a.g(this.f34635b.call(), "The initialSupplier returned a null value"), this.f34636c));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, l0Var);
        }
    }
}
