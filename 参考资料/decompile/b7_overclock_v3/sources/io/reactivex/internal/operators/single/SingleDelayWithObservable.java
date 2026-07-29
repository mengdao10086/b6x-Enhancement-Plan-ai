package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.e0;
import xi.g0;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDelayWithObservable<T, U> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0<U> f34937b;

    public static final class OtherSubscriber<T, U> extends AtomicReference<io.reactivex.disposables.b> implements g0<U>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8565274649390031272L;
        public boolean done;
        public final l0<? super T> downstream;
        public final o0<T> source;

        public OtherSubscriber(l0<? super T> l0Var, o0<T> o0Var) {
            this.downstream = l0Var;
            this.source = o0Var;
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
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.a(new gj.o(this, this.downstream));
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                this.downstream.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(U u6) {
            get().dispose();
            onComplete();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.set(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithObservable(o0<T> o0Var, e0<U> e0Var) {
        this.f34936a = o0Var;
        this.f34937b = e0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34937b.c(new OtherSubscriber(l0Var, this.f34936a));
    }
}
