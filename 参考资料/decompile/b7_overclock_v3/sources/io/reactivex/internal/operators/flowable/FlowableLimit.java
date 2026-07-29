package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableLimit<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33319c;

    public static final class LimitSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 2288246011222124525L;
        public final bu.d<? super T> downstream;
        public long remaining;
        public bu.e upstream;

        public LimitSubscriber(bu.d<? super T> dVar, long j10) {
            this.downstream = dVar;
            this.remaining = j10;
            lazySet(j10);
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.remaining <= 0) {
                kj.a.Y(th2);
            } else {
                this.remaining = 0L;
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = this.remaining;
            if (j10 > 0) {
                long j11 = j10 - 1;
                this.remaining = j11;
                this.downstream.onNext(t10);
                if (j11 == 0) {
                    this.upstream.cancel();
                    this.downstream.onComplete();
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                if (this.remaining == 0) {
                    eVar.cancel();
                    EmptySubscription.complete(this.downstream);
                } else {
                    this.upstream = eVar;
                    this.downstream.onSubscribe(this);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            long j11;
            long j12;
            if (SubscriptionHelper.validate(j10)) {
                do {
                    j11 = get();
                    if (j11 == 0) {
                        return;
                    } else {
                        j12 = j11 <= j10 ? j11 : j10;
                    }
                } while (!compareAndSet(j11, j11 - j12));
                this.upstream.request(j12);
            }
        }
    }

    public FlowableLimit(xi.j<T> jVar, long j10) {
        super(jVar);
        this.f33319c = j10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new LimitSubscriber(dVar, this.f33319c));
    }
}
