package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDelayWithSingle<T, U> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0<U> f34941b;

    public static final class OtherObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements l0<U>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8565274649390031272L;
        public final l0<? super T> downstream;
        public final o0<T> source;

        public OtherObserver(l0<? super T> l0Var, o0<T> o0Var) {
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

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(U u6) {
            this.source.a(new gj.o(this, this.downstream));
        }
    }

    public SingleDelayWithSingle(o0<T> o0Var, o0<U> o0Var2) {
        this.f34940a = o0Var;
        this.f34941b = o0Var2;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34941b.a(new OtherObserver(l0Var, this.f34940a));
    }
}
