package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeUnsubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f33905b;

    public static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        public final xi.t<? super T> downstream;

        /* JADX INFO: renamed from: ds, reason: collision with root package name */
        public io.reactivex.disposables.b f33906ds;
        public final xi.h0 scheduler;

        public UnsubscribeOnMaybeObserver(xi.t<? super T> tVar, xi.h0 h0Var) {
            this.downstream = tVar;
            this.scheduler = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            io.reactivex.disposables.b andSet = getAndSet(disposableHelper);
            if (andSet != disposableHelper) {
                this.f33906ds = andSet;
                this.scheduler.f(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.t
        public void onComplete() {
            this.downstream.onComplete();
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

        @Override // java.lang.Runnable
        public void run() {
            this.f33906ds.dispose();
        }
    }

    public MaybeUnsubscribeOn(xi.w<T> wVar, xi.h0 h0Var) {
        super(wVar);
        this.f33905b = h0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new UnsubscribeOnMaybeObserver(tVar, this.f33905b));
    }
}
