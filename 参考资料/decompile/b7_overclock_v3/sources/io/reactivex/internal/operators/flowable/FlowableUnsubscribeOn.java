package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableUnsubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.h0 f33491c;

    public static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 1015244841293359600L;
        public final bu.d<? super T> downstream;
        public final xi.h0 scheduler;
        public bu.e upstream;

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeSubscriber.this.upstream.cancel();
            }
        }

        public UnsubscribeSubscriber(bu.d<? super T> dVar, xi.h0 h0Var) {
            this.downstream = dVar;
            this.scheduler = h0Var;
        }

        @Override // bu.e
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.f(new a());
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (get()) {
                kj.a.Y(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.upstream.request(j10);
        }
    }

    public FlowableUnsubscribeOn(xi.j<T> jVar, xi.h0 h0Var) {
        super(jVar);
        this.f33491c = h0Var;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new UnsubscribeSubscriber(dVar, this.f33491c));
    }
}
