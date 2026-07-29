package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleUnsubscribeOn<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f34985b;

    public static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        public final l0<? super T> downstream;

        /* JADX INFO: renamed from: ds, reason: collision with root package name */
        public io.reactivex.disposables.b f34986ds;
        public final h0 scheduler;

        public UnsubscribeOnSingleObserver(l0<? super T> l0Var, h0 h0Var) {
            this.downstream = l0Var;
            this.scheduler = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            io.reactivex.disposables.b andSet = getAndSet(disposableHelper);
            if (andSet != disposableHelper) {
                this.f34986ds = andSet;
                this.scheduler.f(this);
            }
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
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34986ds.dispose();
        }
    }

    public SingleUnsubscribeOn(o0<T> o0Var, h0 h0Var) {
        this.f34984a = o0Var;
        this.f34985b = h0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34984a.a(new UnsubscribeOnSingleObserver(l0Var, this.f34985b));
    }
}
