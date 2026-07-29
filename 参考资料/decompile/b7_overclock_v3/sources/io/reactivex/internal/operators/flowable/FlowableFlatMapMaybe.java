package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFlatMapMaybe<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.w<? extends R>> f33245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33247e;

    public static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 8600231336733376951L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final bu.d<? super R> downstream;
        public final dj.o<? super T, ? extends xi.w<? extends R>> mapper;
        public final int maxConcurrency;
        public bu.e upstream;
        public final AtomicLong requested = new AtomicLong();
        public final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicInteger active = new AtomicInteger(1);
        public final AtomicReference<io.reactivex.internal.queue.a<R>> queue = new AtomicReference<>();

        public final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.t<R>, io.reactivex.disposables.b {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // xi.t
            public void onComplete() {
                FlatMapMaybeSubscriber.this.d(this);
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                FlatMapMaybeSubscriber.this.f(this, th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.t
            public void onSuccess(R r10) {
                FlatMapMaybeSubscriber.this.h(this, r10);
            }
        }

        public FlatMapMaybeSubscriber(bu.d<? super R> dVar, dj.o<? super T, ? extends xi.w<? extends R>> oVar, boolean z10, int i10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
        
            if (r10 != r6) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        
            if (r17.cancelled == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        
            if (r17.delayErrors != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
        
            if (r17.errors.get() == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
        
            r2 = r17.errors.c();
            clear();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
        
            if (r2.get() != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
        
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
        
            if (r7 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
        
            if (r6 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
        
            if (r12 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
        
            r2 = r17.errors.c();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
        
            if (r2 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
        
            if (r10 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
        
            io.reactivex.internal.util.b.e(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
        
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
        
            r17.upstream.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b() {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.b():void");
        }

        public io.reactivex.internal.queue.a<R> c() {
            io.reactivex.internal.queue.a<R> aVar;
            do {
                io.reactivex.internal.queue.a<R> aVar2 = this.queue.get();
                if (aVar2 != null) {
                    return aVar2;
                }
                aVar = new io.reactivex.internal.queue.a<>(xi.j.Y());
            } while (!this.queue.compareAndSet(null, aVar));
            return aVar;
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        public void clear() {
            io.reactivex.internal.queue.a<R> aVar = this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        public void d(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z10 = this.active.decrementAndGet() == 0;
                    io.reactivex.internal.queue.a<R> aVar = this.queue.get();
                    if (z10 && (aVar == null || aVar.isEmpty())) {
                        Throwable thC = this.errors.c();
                        if (thC != null) {
                            this.downstream.onError(thC);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    b();
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            a();
        }

        public void f(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.set.c(innerObserver);
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            this.active.decrementAndGet();
            a();
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber<T, R>.InnerObserver r6, R r7) {
            /*
                r5 = this;
                io.reactivex.disposables.a r0 = r5.set
                r0.c(r6)
                int r6 = r5.get()
                if (r6 != 0) goto L7a
                r6 = 0
                r0 = 1
                boolean r1 = r5.compareAndSet(r6, r0)
                if (r1 == 0) goto L7a
                java.util.concurrent.atomic.AtomicInteger r1 = r5.active
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L1c
                r6 = 1
            L1c:
                java.util.concurrent.atomic.AtomicLong r0 = r5.requested
                long r0 = r0.get()
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L67
                bu.d<? super R> r0 = r5.downstream
                r0.onNext(r7)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.queue.a<R>> r7 = r5.queue
                java.lang.Object r7 = r7.get()
                io.reactivex.internal.queue.a r7 = (io.reactivex.internal.queue.a) r7
                if (r6 == 0) goto L53
                if (r7 == 0) goto L3f
                boolean r6 = r7.isEmpty()
                if (r6 == 0) goto L53
            L3f:
                io.reactivex.internal.util.AtomicThrowable r6 = r5.errors
                java.lang.Throwable r6 = r6.c()
                if (r6 == 0) goto L4d
                bu.d<? super R> r7 = r5.downstream
                r7.onError(r6)
                goto L52
            L4d:
                bu.d<? super R> r6 = r5.downstream
                r6.onComplete()
            L52:
                return
            L53:
                java.util.concurrent.atomic.AtomicLong r6 = r5.requested
                r0 = 1
                io.reactivex.internal.util.b.e(r6, r0)
                int r6 = r5.maxConcurrency
                r7 = 2147483647(0x7fffffff, float:NaN)
                if (r6 == r7) goto L70
                bu.e r6 = r5.upstream
                r6.request(r0)
                goto L70
            L67:
                io.reactivex.internal.queue.a r6 = r5.c()
                monitor-enter(r6)
                r6.offer(r7)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L77
            L70:
                int r6 = r5.decrementAndGet()
                if (r6 != 0) goto L8f
                return
            L77:
                r7 = move-exception
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L77
                throw r7
            L7a:
                io.reactivex.internal.queue.a r6 = r5.c()
                monitor-enter(r6)
                r6.offer(r7)     // Catch: java.lang.Throwable -> L93
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L93
                java.util.concurrent.atomic.AtomicInteger r6 = r5.active
                r6.decrementAndGet()
                int r6 = r5.getAndIncrement()
                if (r6 == 0) goto L8f
                return
            L8f:
                r5.b()
                return
            L93:
                r7 = move-exception
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L93
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.h(io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver, java.lang.Object):void");
        }

        @Override // bu.d
        public void onComplete() {
            this.active.decrementAndGet();
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.active.decrementAndGet();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            a();
        }

        @Override // bu.d
        public void onNext(T t10) {
            try {
                xi.w wVar = (xi.w) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.b(innerObserver)) {
                    return;
                }
                wVar.a(innerObserver);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                int i10 = this.maxConcurrency;
                if (i10 == Integer.MAX_VALUE) {
                    eVar.request(Long.MAX_VALUE);
                } else {
                    eVar.request(i10);
                }
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

    public FlowableFlatMapMaybe(xi.j<T> jVar, dj.o<? super T, ? extends xi.w<? extends R>> oVar, boolean z10, int i10) {
        super(jVar);
        this.f33245c = oVar;
        this.f33246d = z10;
        this.f33247e = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        this.f33524b.j6(new FlatMapMaybeSubscriber(dVar, this.f33245c, this.f33246d, this.f33247e));
    }
}
