package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class v1<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<U> f34753b;

    public static final class a<T, U extends Collection<? super T>> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super U> f34754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public U f34756c;

        public a(xi.g0<? super U> g0Var, U u6) {
            this.f34754a = g0Var;
            this.f34756c = u6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34755b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34755b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            U u6 = this.f34756c;
            this.f34756c = null;
            this.f34754a.onNext(u6);
            this.f34754a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34756c = null;
            this.f34754a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34756c.add(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34755b, bVar)) {
                this.f34755b = bVar;
                this.f34754a.onSubscribe(this);
            }
        }
    }

    public v1(xi.e0<T> e0Var, int i10) {
        super(e0Var);
        this.f34753b = Functions.f(i10);
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        try {
            this.f34421a.c(new a(g0Var, (Collection) io.reactivex.internal.functions.a.g(this.f34753b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
        }
    }

    public v1(xi.e0<T> e0Var, Callable<U> callable) {
        super(e0Var);
        this.f34753b = callable;
    }
}
