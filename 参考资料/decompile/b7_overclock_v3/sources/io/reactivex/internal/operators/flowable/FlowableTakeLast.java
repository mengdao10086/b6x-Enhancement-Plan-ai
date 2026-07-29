package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTakeLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33461c;

    public static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 7240042530241604978L;
        public volatile boolean cancelled;
        public final int count;
        public volatile boolean done;
        public final bu.d<? super T> downstream;
        public bu.e upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger wip = new AtomicInteger();

        public TakeLastSubscriber(bu.d<? super T> dVar, int i10) {
            this.downstream = dVar;
            this.count = i10;
        }

        public void a() {
            if (this.wip.getAndIncrement() == 0) {
                bu.d<? super T> dVar = this.downstream;
                long jAddAndGet = this.requested.get();
                while (!this.cancelled) {
                    if (this.done) {
                        long j10 = 0;
                        while (j10 != jAddAndGet) {
                            if (this.cancelled) {
                                return;
                            }
                            T tPoll = poll();
                            if (tPoll == null) {
                                dVar.onComplete();
                                return;
                            } else {
                                dVar.onNext(tPoll);
                                j10++;
                            }
                        }
                        if (j10 != 0 && jAddAndGet != Long.MAX_VALUE) {
                            jAddAndGet = this.requested.addAndGet(-j10);
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.count == size()) {
                poll();
            }
            offer(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                a();
            }
        }
    }

    public FlowableTakeLast(xi.j<T> jVar, int i10) {
        super(jVar);
        this.f33461c = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new TakeLastSubscriber(dVar, this.f33461c));
    }
}
