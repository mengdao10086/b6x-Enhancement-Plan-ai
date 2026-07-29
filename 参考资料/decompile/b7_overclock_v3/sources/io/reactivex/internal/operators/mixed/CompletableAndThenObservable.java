package io.reactivex.internal.operators.mixed;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.d;
import xi.e0;
import xi.g;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableAndThenObservable<R> extends z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f34021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0<? extends R> f34022b;

    public static final class AndThenObservableObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements g0<R>, d, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8948264376121066672L;
        public final g0<? super R> downstream;
        public e0<? extends R> other;

        public AndThenObservableObserver(g0<? super R> g0Var, e0<? extends R> e0Var) {
            this.other = e0Var;
            this.downstream = g0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            e0<? extends R> e0Var = this.other;
            if (e0Var == null) {
                this.downstream.onComplete();
            } else {
                this.other = null;
                e0Var.c(this);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public CompletableAndThenObservable(g gVar, e0<? extends R> e0Var) {
        this.f34021a = gVar;
        this.f34022b = e0Var;
    }

    @Override // xi.z
    public void I5(g0<? super R> g0Var) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(g0Var, this.f34022b);
        g0Var.onSubscribe(andThenObservableObserver);
        this.f34021a.a(andThenObservableObserver);
    }
}
