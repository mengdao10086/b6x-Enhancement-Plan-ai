package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTakeUntil<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<? extends U> f33468c;

    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -4945480365982832967L;
        public final bu.d<? super T> downstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        public final AtomicThrowable error = new AtomicThrowable();

        public final class OtherSubscriber extends AtomicReference<bu.e> implements xi.o<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            public OtherSubscriber() {
            }

            @Override // bu.d
            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                io.reactivex.internal.util.g.a(takeUntilMainSubscriber.downstream, takeUntilMainSubscriber, takeUntilMainSubscriber.error);
            }

            @Override // bu.d
            public void onError(Throwable th2) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                io.reactivex.internal.util.g.c(takeUntilMainSubscriber.downstream, th2, takeUntilMainSubscriber, takeUntilMainSubscriber.error);
            }

            @Override // bu.d
            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            @Override // xi.o, bu.d
            public void onSubscribe(bu.e eVar) {
                SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
            }
        }

        public TakeUntilMainSubscriber(bu.d<? super T> dVar) {
            this.downstream = dVar;
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // bu.d
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.other);
            io.reactivex.internal.util.g.c(this.downstream, th2, this, this.error);
        }

        @Override // bu.d
        public void onNext(T t10) {
            io.reactivex.internal.util.g.e(this.downstream, t10, this, this.error);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, eVar);
        }

        @Override // bu.e
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j10);
        }
    }

    public FlowableTakeUntil(xi.j<T> jVar, bu.c<? extends U> cVar) {
        super(jVar);
        this.f33468c = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(dVar);
        dVar.onSubscribe(takeUntilMainSubscriber);
        this.f33468c.d(takeUntilMainSubscriber.other);
        this.f33524b.j6(takeUntilMainSubscriber);
    }
}
