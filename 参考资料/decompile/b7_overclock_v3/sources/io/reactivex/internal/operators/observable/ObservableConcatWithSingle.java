package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatWithSingle<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.o0<? extends T> f34153b;

    public static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, xi.l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -1953724749712440952L;
        public final xi.g0<? super T> downstream;
        public boolean inSingle;
        public xi.o0<? extends T> other;

        public ConcatWithObserver(xi.g0<? super T> g0Var, xi.o0<? extends T> o0Var) {
            this.downstream = g0Var;
            this.other = o0Var;
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
            this.inSingle = true;
            DisposableHelper.replace(this, null);
            xi.o0<? extends T> o0Var = this.other;
            this.other = null;
            o0Var.a(this);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (!DisposableHelper.setOnce(this, bVar) || this.inSingle) {
                return;
            }
            this.downstream.onSubscribe(this);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.downstream.onNext(t10);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithSingle(xi.z<T> zVar, xi.o0<? extends T> o0Var) {
        super(zVar);
        this.f34153b = o0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new ConcatWithObserver(g0Var, this.f34153b));
    }
}
