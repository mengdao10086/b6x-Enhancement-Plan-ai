package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34354b;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 7240042530241604978L;
        public volatile boolean cancelled;
        public final int count;
        public final xi.g0<? super T> downstream;
        public io.reactivex.disposables.b upstream;

        public TakeLastObserver(xi.g0<? super T> g0Var, int i10) {
            this.downstream = g0Var;
            this.count = i10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            xi.g0<? super T> g0Var = this.downstream;
            while (!this.cancelled) {
                T tPoll = poll();
                if (tPoll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    g0Var.onComplete();
                    return;
                }
                g0Var.onNext(tPoll);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.count == size()) {
                poll();
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

    public ObservableTakeLast(xi.e0<T> e0Var, int i10) {
        super(e0Var);
        this.f34354b = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new TakeLastObserver(g0Var, this.f34354b));
    }
}
