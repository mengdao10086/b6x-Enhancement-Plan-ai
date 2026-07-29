package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWindowBoundary<T, B> extends io.reactivex.internal.operators.flowable.a<T, xi.j<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<B> f33500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33501d;

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements xi.o<T>, bu.e, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f33502a = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final int capacityHint;
        public volatile boolean done;
        public final bu.d<? super xi.j<T>> downstream;
        public long emitted;
        public UnicastProcessor<T> window;
        public final a<T, B> boundarySubscriber = new a<>(this);
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();
        public final AtomicLong requested = new AtomicLong();

        public WindowBoundaryMainSubscriber(bu.d<? super xi.j<T>> dVar, int i10) {
            this.downstream = dVar;
            this.capacityHint = i10;
        }

        public void a() {
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
                } else if (objPoll != f33502a) {
                    unicastProcessor.onNext((T) objPoll);
                } else {
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastProcessor<T> unicastProcessorU8 = UnicastProcessor.U8(this.capacityHint, this);
                        this.window = unicastProcessorU8;
                        this.windows.getAndIncrement();
                        if (j10 != this.requested.get()) {
                            j10++;
                            dVar.onNext(unicastProcessorU8);
                        } else {
                            SubscriptionHelper.cancel(this.upstream);
                            this.boundarySubscriber.dispose();
                            atomicThrowable.a(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        public void b() {
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            a();
        }

        public void c(Throwable th2) {
            SubscriptionHelper.cancel(this.upstream);
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                a();
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundarySubscriber.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.upstream);
                }
            }
        }

        public void d() {
            this.queue.offer(f33502a);
            a();
        }

        @Override // bu.d
        public void onComplete() {
            this.boundarySubscriber.dispose();
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.boundarySubscriber.dispose();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                a();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.queue.offer(t10);
            a();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this.upstream, eVar, Long.MAX_VALUE);
        }

        @Override // bu.e
        public void request(long j10) {
            io.reactivex.internal.util.b.a(this.requested, j10);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.upstream);
            }
        }
    }

    public static final class a<T, B> extends io.reactivex.subscribers.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowBoundaryMainSubscriber<T, B> f33503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f33504c;

        public a(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f33503b = windowBoundaryMainSubscriber;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33504c) {
                return;
            }
            this.f33504c = true;
            this.f33503b.b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33504c) {
                kj.a.Y(th2);
            } else {
                this.f33504c = true;
                this.f33503b.c(th2);
            }
        }

        @Override // bu.d
        public void onNext(B b10) {
            if (this.f33504c) {
                return;
            }
            this.f33503b.d();
        }
    }

    public FlowableWindowBoundary(xi.j<T> jVar, bu.c<B> cVar, int i10) {
        super(jVar);
        this.f33500c = cVar;
        this.f33501d = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super xi.j<T>> dVar) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(dVar, this.f33501d);
        dVar.onSubscribe(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.d();
        this.f33500c.d(windowBoundaryMainSubscriber.boundarySubscriber);
        this.f33524b.j6(windowBoundaryMainSubscriber);
    }
}
