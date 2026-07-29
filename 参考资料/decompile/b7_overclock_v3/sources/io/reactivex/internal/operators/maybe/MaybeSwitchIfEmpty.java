package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeSwitchIfEmpty<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<? extends T> f33887b;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2223459372976438024L;
        public final xi.t<? super T> downstream;
        public final xi.w<? extends T> other;

        public static final class a<T> implements xi.t<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final xi.t<? super T> f33888a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference<io.reactivex.disposables.b> f33889b;

            public a(xi.t<? super T> tVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.f33888a = tVar;
                this.f33889b = atomicReference;
            }

            @Override // xi.t
            public void onComplete() {
                this.f33888a.onComplete();
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.f33888a.onError(th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.f33889b, bVar);
            }

            @Override // xi.t
            public void onSuccess(T t10) {
                this.f33888a.onSuccess(t10);
            }
        }

        public SwitchIfEmptyMaybeObserver(xi.t<? super T> tVar, xi.w<? extends T> wVar) {
            this.downstream = tVar;
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

    public MaybeSwitchIfEmpty(xi.w<T> wVar, xi.w<? extends T> wVar2) {
        super(wVar);
        this.f33887b = wVar2;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new SwitchIfEmptyMaybeObserver(tVar, this.f33887b));
    }
}
