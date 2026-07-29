package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.flowable.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<? super T, ? super U, ? extends R> f33511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bu.c<? extends U> f33512d;

    public static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements fj.a<T>, bu.e {
        private static final long serialVersionUID = -312246233408980075L;
        public final dj.c<? super T, ? super U, ? extends R> combiner;
        public final bu.d<? super R> downstream;
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<bu.e> other = new AtomicReference<>();

        public WithLatestFromSubscriber(bu.d<? super R> dVar, dj.c<? super T, ? super U, ? extends R> cVar) {
            this.downstream = dVar;
            this.combiner = cVar;
        }

        public void a(Throwable th2) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(th2);
        }

        public boolean b(bu.e eVar) {
            return SubscriptionHelper.setOnce(this.other, eVar);
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // fj.a
        public boolean m(T t10) {
            U u6 = get();
            if (u6 != null) {
                try {
                    this.downstream.onNext(io.reactivex.internal.functions.a.g(this.combiner.apply(t10, u6), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    this.downstream.onError(th2);
                }
            }
            return false;
        }

        @Override // bu.d
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th2);
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

    public final class a implements xi.o<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WithLatestFromSubscriber<T, U, R> f33513a;

        public a(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.f33513a = withLatestFromSubscriber;
        }

        @Override // bu.d
        public void onComplete() {
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33513a.a(th2);
        }

        @Override // bu.d
        public void onNext(U u6) {
            this.f33513a.lazySet(u6);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (this.f33513a.b(eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableWithLatestFrom(xi.j<T> jVar, dj.c<? super T, ? super U, ? extends R> cVar, bu.c<? extends U> cVar2) {
        super(jVar);
        this.f33511c = cVar;
        this.f33512d = cVar2;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        io.reactivex.subscribers.e eVar = new io.reactivex.subscribers.e(dVar);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(eVar, this.f33511c);
        eVar.onSubscribe(withLatestFromSubscriber);
        this.f33512d.d(new a(withLatestFromSubscriber));
        this.f33524b.j6(withLatestFromSubscriber);
    }
}
