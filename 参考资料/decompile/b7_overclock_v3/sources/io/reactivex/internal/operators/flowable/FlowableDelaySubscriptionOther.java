package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<? extends T> f33223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<U> f33224c;

    public static final class MainSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 2259811067697317255L;
        public final bu.d<? super T> downstream;
        public final bu.c<? extends T> main;
        public final MainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();

        public final class OtherSubscriber extends AtomicReference<bu.e> implements xi.o<Object> {
            private static final long serialVersionUID = -3892798459447644106L;

            public OtherSubscriber() {
            }

            @Override // bu.d
            public void onComplete() {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.a();
                }
            }

            @Override // bu.d
            public void onError(Throwable th2) {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.downstream.onError(th2);
                } else {
                    kj.a.Y(th2);
                }
            }

            @Override // bu.d
            public void onNext(Object obj) {
                bu.e eVar = get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (eVar != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    eVar.cancel();
                    MainSubscriber.this.a();
                }
            }

            @Override // xi.o, bu.d
            public void onSubscribe(bu.e eVar) {
                if (SubscriptionHelper.setOnce(this, eVar)) {
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        public MainSubscriber(bu.d<? super T> dVar, bu.c<? extends T> cVar) {
            this.downstream = dVar;
            this.main = cVar;
        }

        public void a() {
            this.main.d(this);
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // bu.d
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this, eVar);
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                SubscriptionHelper.deferredRequest(this.upstream, this, j10);
            }
        }
    }

    public FlowableDelaySubscriptionOther(bu.c<? extends T> cVar, bu.c<U> cVar2) {
        this.f33223b = cVar;
        this.f33224c = cVar2;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        MainSubscriber mainSubscriber = new MainSubscriber(dVar, this.f33223b);
        dVar.onSubscribe(mainSubscriber);
        this.f33224c.d(mainSubscriber.other);
    }
}
