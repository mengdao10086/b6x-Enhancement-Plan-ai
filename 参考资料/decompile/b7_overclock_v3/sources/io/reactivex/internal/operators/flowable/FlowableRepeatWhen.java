package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRepeatWhen<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super xi.j<Object>, ? extends bu.c<?>> f33393c;

    public static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RepeatWhenSubscriber(bu.d<? super T> dVar, io.reactivex.processors.a<Object> aVar, bu.e eVar) {
            super(dVar, aVar, eVar);
        }

        @Override // bu.d
        public void onComplete() {
            l(0);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.receiver.cancel();
            this.downstream.onError(th2);
        }
    }

    public static final class WhenReceiver<T, U> extends AtomicInteger implements xi.o<Object>, bu.e {
        private static final long serialVersionUID = 2827772011130406689L;
        public final bu.c<T> source;
        public WhenSourceSubscriber<T, U> subscriber;
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public WhenReceiver(bu.c<T> cVar) {
            this.source = cVar;
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // bu.d
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                    this.source.d(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
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

    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements xi.o<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        public final bu.d<? super T> downstream;
        public final io.reactivex.processors.a<U> processor;
        private long produced;
        public final bu.e receiver;

        public WhenSourceSubscriber(bu.d<? super T> dVar, io.reactivex.processors.a<U> aVar, bu.e eVar) {
            super(false);
            this.downstream = dVar;
            this.processor = aVar;
            this.receiver = eVar;
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, bu.e
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }

        public final void l(U u6) {
            k(EmptySubscription.INSTANCE);
            long j10 = this.produced;
            if (j10 != 0) {
                this.produced = 0L;
                i(j10);
            }
            this.receiver.request(1L);
            this.processor.onNext(u6);
        }

        @Override // bu.d
        public final void onNext(T t10) {
            this.produced++;
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public final void onSubscribe(bu.e eVar) {
            k(eVar);
        }
    }

    public FlowableRepeatWhen(xi.j<T> jVar, dj.o<? super xi.j<Object>, ? extends bu.c<?>> oVar) {
        super(jVar);
        this.f33393c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        io.reactivex.subscribers.e eVar = new io.reactivex.subscribers.e(dVar);
        io.reactivex.processors.a<T> aVarQ8 = UnicastProcessor.T8(8).Q8();
        try {
            bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.f33393c.apply(aVarQ8), "handler returned a null Publisher");
            WhenReceiver whenReceiver = new WhenReceiver(this.f33524b);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(eVar, aVarQ8, whenReceiver);
            whenReceiver.subscriber = repeatWhenSubscriber;
            dVar.onSubscribe(repeatWhenSubscriber);
            cVar.d(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
