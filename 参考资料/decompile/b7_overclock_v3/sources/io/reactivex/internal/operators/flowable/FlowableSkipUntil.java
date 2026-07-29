package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSkipUntil<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<U> f33451c;

    public static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements fj.a<T>, bu.e {
        private static final long serialVersionUID = -6270983465606289181L;
        public final bu.d<? super T> downstream;
        public volatile boolean gate;
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public final SkipUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        public final AtomicThrowable error = new AtomicThrowable();

        public final class OtherSubscriber extends AtomicReference<bu.e> implements xi.o<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            public OtherSubscriber() {
            }

            @Override // bu.d
            public void onComplete() {
                SkipUntilMainSubscriber.this.gate = true;
            }

            @Override // bu.d
            public void onError(Throwable th2) {
                SubscriptionHelper.cancel(SkipUntilMainSubscriber.this.upstream);
                SkipUntilMainSubscriber skipUntilMainSubscriber = SkipUntilMainSubscriber.this;
                io.reactivex.internal.util.g.c(skipUntilMainSubscriber.downstream, th2, skipUntilMainSubscriber, skipUntilMainSubscriber.error);
            }

            @Override // bu.d
            public void onNext(Object obj) {
                SkipUntilMainSubscriber.this.gate = true;
                get().cancel();
            }

            @Override // xi.o, bu.d
            public void onSubscribe(bu.e eVar) {
                SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
            }
        }

        public SkipUntilMainSubscriber(bu.d<? super T> dVar) {
            this.downstream = dVar;
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // fj.a
        public boolean m(T t10) {
            if (!this.gate) {
                return false;
            }
            io.reactivex.internal.util.g.e(this.downstream, t10, this, this.error);
            return true;
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
            if (m(t10)) {
                return;
            }
            this.upstream.get().request(1L);
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

    public FlowableSkipUntil(xi.j<T> jVar, bu.c<U> cVar) {
        super(jVar);
        this.f33451c = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(dVar);
        dVar.onSubscribe(skipUntilMainSubscriber);
        this.f33451c.d(skipUntilMainSubscriber.other);
        this.f33524b.j6(skipUntilMainSubscriber);
    }
}
