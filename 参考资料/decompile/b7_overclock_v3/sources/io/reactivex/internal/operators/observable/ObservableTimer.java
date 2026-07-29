package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTimer extends xi.z<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.h0 f34380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34382c;

    public static final class TimerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final xi.g0<? super Long> downstream;

        public TimerObserver(xi.g0<? super Long> g0Var) {
            this.downstream = g0Var;
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.trySet(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        }
    }

    public ObservableTimer(long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f34381b = j10;
        this.f34382c = timeUnit;
        this.f34380a = h0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super Long> g0Var) {
        TimerObserver timerObserver = new TimerObserver(g0Var);
        g0Var.onSubscribe(timerObserver);
        timerObserver.a(this.f34380a.g(timerObserver, this.f34381b, this.f34382c));
    }
}
