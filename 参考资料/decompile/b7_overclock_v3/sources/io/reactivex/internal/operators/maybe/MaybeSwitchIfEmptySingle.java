package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeSwitchIfEmptySingle<T> extends xi.i0<T> implements fj.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0<? extends T> f33891b;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4603919676453758899L;
        public final l0<? super T> downstream;
        public final o0<? extends T> other;

        public static final class a<T> implements l0<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final l0<? super T> f33892a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference<io.reactivex.disposables.b> f33893b;

            public a(l0<? super T> l0Var, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.f33892a = l0Var;
                this.f33893b = atomicReference;
            }

            @Override // xi.l0
            public void onError(Throwable th2) {
                this.f33892a.onError(th2);
            }

            @Override // xi.l0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.f33893b, bVar);
            }

            @Override // xi.l0
            public void onSuccess(T t10) {
                this.f33892a.onSuccess(t10);
            }
        }

        public SwitchIfEmptyMaybeObserver(l0<? super T> l0Var, o0<? extends T> o0Var) {
            this.downstream = l0Var;
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

        @Override // xi.t
        public void onComplete() {
            io.reactivex.disposables.b bVar = get();
            if (bVar == DisposableHelper.DISPOSED || !compareAndSet(bVar, null)) {
                return;
            }
            this.other.a(new a(this.downstream, this));
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public MaybeSwitchIfEmptySingle(xi.w<T> wVar, o0<? extends T> o0Var) {
        this.f33890a = wVar;
        this.f33891b = o0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f33890a.a(new SwitchIfEmptyMaybeObserver(l0Var, this.f33891b));
    }

    @Override // fj.f
    public xi.w<T> source() {
        return this.f33890a;
    }
}
