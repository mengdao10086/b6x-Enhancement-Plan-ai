package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableTimer extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f33064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeUnit f33065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f33066c;

    public static final class TimerDisposable extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        public final xi.d downstream;

        public TimerDisposable(xi.d dVar) {
            this.downstream = dVar;
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onComplete();
        }
    }

    public CompletableTimer(long j10, TimeUnit timeUnit, h0 h0Var) {
        this.f33064a = j10;
        this.f33065b = timeUnit;
        this.f33066c = h0Var;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        TimerDisposable timerDisposable = new TimerDisposable(dVar);
        dVar.onSubscribe(timerDisposable);
        timerDisposable.a(this.f33066c.g(timerDisposable, this.f33064a, this.f33065b));
    }
}
