package io.reactivex.internal.operators.parallel;

import fj.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelJoin<T> extends j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj.a<? extends T> f34832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34834d;

    public static final class JoinInnerSubscriber<T> extends AtomicReference<bu.e> implements o<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        public final int limit;
        public final JoinSubscriptionBase<T> parent;
        public final int prefetch;
        public long produced;
        public volatile n<T> queue;

        public JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i10) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        public boolean a() {
            return SubscriptionHelper.cancel(this);
        }

        public n<T> b() {
            n<T> nVar = this.queue;
            if (nVar != null) {
                return nVar;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        public void c(long j10) {
            long j11 = this.produced + j10;
            if (j11 < this.limit) {
                this.produced = j11;
            } else {
                this.produced = 0L;
                get().request(j11);
            }
        }

        public void d() {
            long j10 = this.produced + 1;
            if (j10 != this.limit) {
                this.produced = j10;
            } else {
                this.produced = 0L;
                get().request(j10);
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.parent.d();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.f(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.parent.h(this, t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, this.prefetch);
        }
    }

    public static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        public JoinSubscription(bu.d<? super T> dVar, int i10, int i11) {
            super(dVar, i10, i11);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            i();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void d() {
            this.done.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void f(Throwable th2) {
            if (this.errors.compareAndSet(null, th2)) {
                a();
                c();
            } else if (th2 != this.errors.get()) {
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void h(JoinInnerSubscriber<T> joinInnerSubscriber, T t10) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t10);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.c(1L);
                } else if (!joinInnerSubscriber.b().offer(t10)) {
                    a();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.downstream.onError(missingBackpressureException);
                        return;
                    } else {
                        kj.a.Y(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.b().offer(t10)) {
                a();
                f(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            i();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
        
            if (r13 == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
        
            if (r15 == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        
            if (r15 == false) goto L87;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i() {
            /*
                Method dump skipped, instruction units count: 208
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.i():void");
        }
    }

    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements bu.e {
        private static final long serialVersionUID = 3100232009247827843L;
        public volatile boolean cancelled;
        public final bu.d<? super T> downstream;
        public final JoinInnerSubscriber<T>[] subscribers;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger done = new AtomicInteger();

        public JoinSubscriptionBase(bu.d<? super T> dVar, int i10, int i11) {
            this.downstream = dVar;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                joinInnerSubscriberArr[i12] = new JoinInnerSubscriber<>(this, i11);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i10);
        }

        public void a() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.a();
            }
        }

        public void b() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.queue = null;
            }
        }

        public abstract void c();

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            a();
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public abstract void d();

        public abstract void f(Throwable th2);

        public abstract void h(JoinInnerSubscriber<T> joinInnerSubscriber, T t10);

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                c();
            }
        }
    }

    public static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        public JoinSubscriptionDelayError(bu.d<? super T> dVar, int i10, int i11) {
            super(dVar, i10, i11);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            i();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void d() {
            this.done.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void f(Throwable th2) {
            this.errors.a(th2);
            this.done.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void h(JoinInnerSubscriber<T> joinInnerSubscriber, T t10) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t10);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.c(1L);
                } else if (!joinInnerSubscriber.b().offer(t10)) {
                    joinInnerSubscriber.a();
                    this.errors.a(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    i();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!joinInnerSubscriber.b().offer(t10) && joinInnerSubscriber.a()) {
                    this.errors.a(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            i();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        
            if (r13 == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
        
            if (r15 == false) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        
            if (r18.errors.get() == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            r3.onError(r18.errors.c());
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        
            if (r15 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i() {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.i():void");
        }
    }

    public ParallelJoin(jj.a<? extends T> aVar, int i10, boolean z10) {
        this.f34832b = aVar;
        this.f34833c = i10;
        this.f34834d = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        JoinSubscriptionBase joinSubscriptionDelayError = this.f34834d ? new JoinSubscriptionDelayError(dVar, this.f34832b.F(), this.f34833c) : new JoinSubscription(dVar, this.f34832b.F(), this.f34833c);
        dVar.onSubscribe(joinSubscriptionDelayError);
        this.f34832b.Q(joinSubscriptionDelayError.subscribers);
    }
}
