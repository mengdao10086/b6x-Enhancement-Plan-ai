package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRetryWhen<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super xi.j<Throwable>, ? extends bu.c<?>> f33420c;

    public static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RetryWhenSubscriber(bu.d<? super T> dVar, io.reactivex.processors.a<Throwable> aVar, bu.e eVar) {
            super(dVar, aVar, eVar);
        }

        @Override // bu.d
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            l(th2);
        }
    }

    public FlowableRetryWhen(xi.j<T> jVar, dj.o<? super xi.j<Throwable>, ? extends bu.c<?>> oVar) {
        super(jVar);
        this.f33420c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        io.reactivex.subscribers.e eVar = new io.reactivex.subscribers.e(dVar);
        io.reactivex.processors.a<T> aVarQ8 = UnicastProcessor.T8(8).Q8();
        try {
            bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.f33420c.apply(aVarQ8), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.f33524b);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(eVar, aVarQ8, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            dVar.onSubscribe(retryWhenSubscriber);
            cVar.d(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
