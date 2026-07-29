package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableObserveOn extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f33057b;

    public static final class ObserveOnCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        public final xi.d downstream;
        public Throwable error;
        public final h0 scheduler;

        public ObserveOnCompletableObserver(xi.d dVar, h0 h0Var) {
            this.downstream = dVar;
            this.scheduler = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.f(this));
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.error = th2;
            DisposableHelper.replace(this, this.scheduler.f(this));
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th2 = this.error;
            if (th2 == null) {
                this.downstream.onComplete();
            } else {
                this.error = null;
                this.downstream.onError(th2);
            }
        }
    }

    public CompletableObserveOn(xi.g gVar, h0 h0Var) {
        this.f33056a = gVar;
        this.f33057b = h0Var;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33056a.a(new ObserveOnCompletableObserver(dVar, this.f33057b));
    }
}
