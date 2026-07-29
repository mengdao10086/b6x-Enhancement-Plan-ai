package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTimer extends xi.j<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f33487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33489d;

    public static final class TimerSubscriber extends AtomicReference<io.reactivex.disposables.b> implements bu.e, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final bu.d<? super Long> downstream;
        public volatile boolean requested;

        public TimerSubscriber(bu.d<? super Long> dVar) {
            this.downstream = dVar;
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.trySet(this, bVar);
        }

        @Override // bu.e
        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                this.requested = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (!this.requested) {
                    lazySet(EmptyDisposable.INSTANCE);
                    this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
                } else {
                    this.downstream.onNext(0L);
                    lazySet(EmptyDisposable.INSTANCE);
                    this.downstream.onComplete();
                }
            }
        }
    }

    public FlowableTimer(long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f33488c = j10;
        this.f33489d = timeUnit;
        this.f33487b = h0Var;
    }

    @Override // xi.j
    public void k6(bu.d<? super Long> dVar) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(dVar);
        dVar.onSubscribe(timerSubscriber);
        timerSubscriber.a(this.f33487b.g(timerSubscriber, this.f33488c, this.f33489d));
    }
}
