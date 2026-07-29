package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends io.reactivex.internal.operators.flowable.a<T, xi.j<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<? extends bu.c<B>> f33505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33506d;

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements xi.o<T>, bu.e, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<Object, Object> f33507a = new a<>(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Object f33508b = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final int capacityHint;
        public volatile boolean done;
        public final bu.d<? super xi.j<T>> downstream;
        public long emitted;
        public final Callable<? extends bu.c<B>> other;
        public bu.e upstream;
        public UnicastProcessor<T> window;
        public final AtomicReference<a<T, B>> boundarySubscriber = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();
        public final AtomicLong requested = new AtomicLong();

        public WindowBoundaryMainSubscriber(bu.d<? super xi.j<T>> dVar, int i10, Callable<? extends bu.c<B>> callable) {
            this.downstream = dVar;
            this.capacityHint = i10;
            this.other = callable;
        }

        public void a() {
            AtomicReference<a<T, B>> atomicReference = this.boundarySubscriber;
            a<Object, Object> aVar = f33507a;
            a<T, B> andSet = atomicReference.getAndSet((a<T, B>) aVar);
            if (andSet == null || andSet == aVar) {
                return;
            }
            andSet.dispose();
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super xi.j<T>> dVar = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            long j10 = this.emitted;
            int iAddAndGet = 1;
            while (this.windows.get() != 0) {
                UnicastProcessor<T> unicastProcessor = this.window;
                boolean z10 = this.done;
                if (z10 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thC = atomicThrowable.c();
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onError(thC);
                    }
                    dVar.onError(thC);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                if (z10 && z11) {
                    Throwable thC2 = atomicThrowable.c();
                    if (thC2 == null) {
                        if (unicastProcessor != null) {
                            this.window = null;
                            unicastProcessor.onComplete();
                        }
                        dVar.onComplete();
                        return;
                    }
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onError(thC2);
                    }
                    dVar.onError(thC2);
                    return;
                }
                if (z11) {
                    this.emitted = j10;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f33508b) {
                    unicastProcessor.onNext((T) objPoll);
                } else {
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        if (j10 != this.requested.get()) {
                            UnicastProcessor<T> unicastProcessorU8 = UnicastProcessor.U8(this.capacityHint, this);
                            this.window = unicastProcessorU8;
                            this.windows.getAndIncrement();
                            try {
                                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.other.call(), "The other Callable returned a null Publisher");
                                a<T, B> aVar = new a<>(this);
                                if (this.boundarySubscriber.compareAndSet(null, aVar)) {
                                    cVar.d(aVar);
                                    j10++;
                                    dVar.onNext(unicastProcessorU8);
                                }
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                atomicThrowable.a(th2);
                                this.done = true;
                            }
                        } else {
                            this.upstream.cancel();
                            a();
                            atomicThrowable.a(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        public void c() {
            this.upstream.cancel();
            this.done = true;
            b();
        }

        @Override // bu.e
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true)) {
                a();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        public void d(Throwable th2) {
            this.upstream.cancel();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                b();
            }
        }

        public void f(a<T, B> aVar) {
            this.boundarySubscriber.compareAndSet(aVar, null);
            this.queue.offer(f33508b);
            b();
        }

        @Override // bu.d
        public void onComplete() {
            a();
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            a();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                b();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.queue.offer(t10);
            b();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                this.queue.offer(f33508b);
                b();
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            io.reactivex.internal.util.b.a(this.requested, j10);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public static final class a<T, B> extends io.reactivex.subscribers.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowBoundaryMainSubscriber<T, B> f33509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f33510c;

        public a(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f33509b = windowBoundaryMainSubscriber;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33510c) {
                return;
            }
            this.f33510c = true;
            this.f33509b.c();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33510c) {
                kj.a.Y(th2);
            } else {
                this.f33510c = true;
                this.f33509b.d(th2);
            }
        }

        @Override // bu.d
        public void onNext(B b10) {
            if (this.f33510c) {
                return;
            }
            this.f33510c = true;
            dispose();
            this.f33509b.f(this);
        }
    }

    public FlowableWindowBoundarySupplier(xi.j<T> jVar, Callable<? extends bu.c<B>> callable, int i10) {
        super(jVar);
        this.f33505c = callable;
        this.f33506d = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super xi.j<T>> dVar) {
        this.f33524b.j6(new WindowBoundaryMainSubscriber(dVar, this.f33506d, this.f33505c));
    }
}
