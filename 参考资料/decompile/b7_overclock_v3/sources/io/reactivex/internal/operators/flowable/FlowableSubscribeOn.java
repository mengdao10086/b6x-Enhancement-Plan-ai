package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.h0 f33452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33453d;

    public static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements xi.o<T>, bu.e, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        public final bu.d<? super T> downstream;
        public final boolean nonScheduledRequests;
        public bu.c<T> source;
        public final h0.c worker;
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final bu.e f33454a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f33455b;

            public a(bu.e eVar, long j10) {
                this.f33454a = eVar;
                this.f33455b = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f33454a.request(this.f33455b);
            }
        }

        public SubscribeOnSubscriber(bu.d<? super T> dVar, h0.c cVar, bu.c<T> cVar2, boolean z10) {
            this.downstream = dVar;
            this.worker = cVar;
            this.source = cVar2;
            this.nonScheduledRequests = !z10;
        }

        public void a(long j10, bu.e eVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                eVar.request(j10);
            } else {
                this.worker.b(new a(eVar, j10));
            }
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this.upstream, eVar)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, eVar);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                bu.e eVar = this.upstream.get();
                if (eVar != null) {
                    a(j10, eVar);
                    return;
                }
                io.reactivex.internal.util.b.a(this.requested, j10);
                bu.e eVar2 = this.upstream.get();
                if (eVar2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        a(andSet, eVar2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            bu.c<T> cVar = this.source;
            this.source = null;
            cVar.d(this);
        }
    }

    public FlowableSubscribeOn(xi.j<T> jVar, xi.h0 h0Var, boolean z10) {
        super(jVar);
        this.f33452c = h0Var;
        this.f33453d = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        h0.c cVarD = this.f33452c.d();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(dVar, cVarD, this.f33524b, this.f33453d);
        dVar.onSubscribe(subscribeOnSubscriber);
        cVarD.b(subscribeOnSubscriber);
    }
}
