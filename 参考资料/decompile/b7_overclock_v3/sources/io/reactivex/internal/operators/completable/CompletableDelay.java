package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableDelay extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f33046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f33047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33048e;

    public static final class Delay extends AtomicReference<io.reactivex.disposables.b> implements xi.d, Runnable, io.reactivex.disposables.b {
        private static final long serialVersionUID = 465972761105851022L;
        public final long delay;
        public final boolean delayError;
        public final xi.d downstream;
        public Throwable error;
        public final h0 scheduler;
        public final TimeUnit unit;

        public Delay(xi.d dVar, long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
            this.downstream = dVar;
            this.delay = j10;
            this.unit = timeUnit;
            this.scheduler = h0Var;
            this.delayError = z10;
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
            DisposableHelper.replace(this, this.scheduler.g(this, this.delay, this.unit));
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.error = th2;
            DisposableHelper.replace(this, this.scheduler.g(this, this.delayError ? this.delay : 0L, this.unit));
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
            this.error = null;
            if (th2 != null) {
                this.downstream.onError(th2);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public CompletableDelay(xi.g gVar, long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        this.f33044a = gVar;
        this.f33045b = j10;
        this.f33046c = timeUnit;
        this.f33047d = h0Var;
        this.f33048e = z10;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33044a.a(new Delay(dVar, this.f33045b, this.f33046c, this.f33047d, this.f33048e));
    }
}
