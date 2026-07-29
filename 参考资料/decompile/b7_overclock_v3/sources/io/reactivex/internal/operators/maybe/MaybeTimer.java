package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeTimer extends xi.q<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f33900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeUnit f33901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.h0 f33902c;

    public static final class TimerDisposable extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        public final xi.t<? super Long> downstream;

        public TimerDisposable(xi.t<? super Long> tVar) {
            this.downstream = tVar;
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

    public MaybeTimer(long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f33900a = j10;
        this.f33901b = timeUnit;
        this.f33902c = h0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super Long> tVar) {
        TimerDisposable timerDisposable = new TimerDisposable(tVar);
        tVar.onSubscribe(timerDisposable);
        timerDisposable.a(this.f33902c.g(timerDisposable, this.f33900a, this.f33901b));
    }
}
