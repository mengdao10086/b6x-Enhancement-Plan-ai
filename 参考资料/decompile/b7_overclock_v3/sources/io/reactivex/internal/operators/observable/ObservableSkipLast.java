package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSkipLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34341b;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -3807491841935125653L;
        public final xi.g0<? super T> downstream;
        public final int skip;
        public io.reactivex.disposables.b upstream;

        public SkipLastObserver(xi.g0<? super T> g0Var, int i10) {
            super(i10);
            this.downstream = g0Var;
            this.skip = i10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            }
            offer(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(xi.e0<T> e0Var, int i10) {
        super(e0Var);
        this.f34341b = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new SkipLastObserver(g0Var, this.f34341b));
    }
}
