package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatWithMaybe<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<? extends T> f34152b;

    public static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -1953724749712440952L;
        public final xi.g0<? super T> downstream;
        public boolean inMaybe;
        public xi.w<? extends T> other;

        public ConcatWithObserver(xi.g0<? super T> g0Var, xi.w<? extends T> wVar) {
            this.downstream = g0Var;
            this.other = wVar;
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
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            xi.w<? extends T> wVar = this.other;
            this.other = null;
            wVar.a(this);
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
            if (!DisposableHelper.setOnce(this, bVar) || this.inMaybe) {
                return;
            }
            this.downstream.onSubscribe(this);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.downstream.onNext(t10);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithMaybe(xi.z<T> zVar, xi.w<? extends T> wVar) {
        super(zVar);
        this.f34152b = wVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new ConcatWithObserver(g0Var, this.f34152b));
    }
}
