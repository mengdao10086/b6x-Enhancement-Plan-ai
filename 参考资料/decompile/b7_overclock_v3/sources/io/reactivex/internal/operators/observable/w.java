package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* JADX INFO: loaded from: classes5.dex */
public final class w<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xi.g0<? super T> f34757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f34758b;

        public a(xi.g0<? super T> g0Var) {
            this.f34757a = g0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f34758b;
            this.f34758b = EmptyComponent.INSTANCE;
            this.f34757a = EmptyComponent.asObserver();
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34758b.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            xi.g0<? super T> g0Var = this.f34757a;
            this.f34758b = EmptyComponent.INSTANCE;
            this.f34757a = EmptyComponent.asObserver();
            g0Var.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            xi.g0<? super T> g0Var = this.f34757a;
            this.f34758b = EmptyComponent.INSTANCE;
            this.f34757a = EmptyComponent.asObserver();
            g0Var.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34757a.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34758b, bVar)) {
                this.f34758b = bVar;
                this.f34757a.onSubscribe(this);
            }
        }
    }

    public w(xi.e0<T> e0Var) {
        super(e0Var);
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var));
    }
}
