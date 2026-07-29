package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleTimer extends i0<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeUnit f34980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f34981c;

    public static final class TimerDisposable extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        public final l0<? super Long> downstream;

        public TimerDisposable(l0<? super Long> l0Var) {
            this.downstream = l0Var;
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
            this.downstream.onSuccess(0L);
        }
    }

    public SingleTimer(long j10, TimeUnit timeUnit, h0 h0Var) {
        this.f34979a = j10;
        this.f34980b = timeUnit;
        this.f34981c = h0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super Long> l0Var) {
        TimerDisposable timerDisposable = new TimerDisposable(l0Var);
        l0Var.onSubscribe(timerDisposable);
        timerDisposable.a(this.f34981c.g(timerDisposable, this.f34979a, this.f34980b));
    }
}
