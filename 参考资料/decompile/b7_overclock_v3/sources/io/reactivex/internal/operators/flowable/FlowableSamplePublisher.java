package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSamplePublisher<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<T> f33421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<?> f33422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33423d;

    public static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        public volatile boolean done;
        public final AtomicInteger wip;

        public SampleMainEmitLast(bu.d<? super T> dVar, bu.c<?> cVar) {
            super(dVar, cVar);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void b() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                c();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void d() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z10 = this.done;
                    c();
                    if (z10) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(bu.d<? super T> dVar, bu.c<?> cVar) {
            super(dVar, cVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void b() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void d() {
            c();
        }
    }

    public static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -3517602651313910099L;
        public final bu.d<? super T> downstream;
        public final bu.c<?> sampler;
        public bu.e upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<bu.e> other = new AtomicReference<>();

        public SamplePublisherSubscriber(bu.d<? super T> dVar, bu.c<?> cVar) {
            this.downstream = dVar;
            this.sampler = cVar;
        }

        public void a() {
            this.upstream.cancel();
            b();
        }

        public abstract void b();

        public void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(andSet);
                    io.reactivex.internal.util.b.e(this.requested, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            this.upstream.cancel();
        }

        public abstract void d();

        public void e(Throwable th2) {
            this.upstream.cancel();
            this.downstream.onError(th2);
        }

        public void f(bu.e eVar) {
            SubscriptionHelper.setOnce(this.other, eVar, Long.MAX_VALUE);
        }

        @Override // bu.d
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            lazySet(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.d(new a(this));
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
            }
        }
    }

    public static final class a<T> implements xi.o<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SamplePublisherSubscriber<T> f33424a;

        public a(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.f33424a = samplePublisherSubscriber;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33424a.a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33424a.e(th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            this.f33424a.d();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            this.f33424a.f(eVar);
        }
    }

    public FlowableSamplePublisher(bu.c<T> cVar, bu.c<?> cVar2, boolean z10) {
        this.f33421b = cVar;
        this.f33422c = cVar2;
        this.f33423d = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        io.reactivex.subscribers.e eVar = new io.reactivex.subscribers.e(dVar);
        if (this.f33423d) {
            this.f33421b.d(new SampleMainEmitLast(eVar, this.f33422c));
        } else {
            this.f33421b.d(new SampleMainNoLast(eVar, this.f33422c));
        }
    }
}
