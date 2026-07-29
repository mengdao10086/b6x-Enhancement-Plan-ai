package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWindow<T> extends a<T, xi.j<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33499e;

    public static final class WindowExactSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        public final int bufferSize;
        public final bu.d<? super xi.j<T>> downstream;
        public long index;
        public final AtomicBoolean once;
        public final long size;
        public bu.e upstream;
        public UnicastProcessor<T> window;

        public WindowExactSubscriber(bu.d<? super xi.j<T>> dVar, long j10, int i10) {
            super(1);
            this.downstream = dVar;
            this.size = j10;
            this.once = new AtomicBoolean();
            this.bufferSize = i10;
        }

        @Override // bu.e
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // bu.d
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th2);
            }
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = this.index;
            UnicastProcessor<T> unicastProcessorU8 = this.window;
            if (j10 == 0) {
                getAndIncrement();
                unicastProcessorU8 = UnicastProcessor.U8(this.bufferSize, this);
                this.window = unicastProcessorU8;
                this.downstream.onNext(unicastProcessorU8);
            }
            long j11 = j10 + 1;
            unicastProcessorU8.onNext(t10);
            if (j11 != this.size) {
                this.index = j11;
                return;
            }
            this.index = 0L;
            this.window = null;
            unicastProcessorU8.onComplete();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                this.upstream.request(io.reactivex.internal.util.b.d(this.size, j10));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public static final class WindowOverlapSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final bu.d<? super xi.j<T>> downstream;
        public Throwable error;
        public final AtomicBoolean firstRequest;
        public long index;
        public final AtomicBoolean once;
        public long produced;
        public final io.reactivex.internal.queue.a<UnicastProcessor<T>> queue;
        public final AtomicLong requested;
        public final long size;
        public final long skip;
        public bu.e upstream;
        public final ArrayDeque<UnicastProcessor<T>> windows;
        public final AtomicInteger wip;

        public WindowOverlapSubscriber(bu.d<? super xi.j<T>> dVar, long j10, long j11, int i10) {
            super(1);
            this.downstream = dVar;
            this.size = j10;
            this.skip = j11;
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i10;
        }

        public boolean a(boolean z10, boolean z11, bu.d<?> dVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled) {
                aVar.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                aVar.clear();
                dVar.onError(th2);
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        public void b() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            bu.d<? super xi.j<T>> dVar = this.downstream;
            io.reactivex.internal.queue.a<UnicastProcessor<T>> aVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    boolean z10 = this.done;
                    UnicastProcessor<T> unicastProcessorPoll = aVar.poll();
                    boolean z11 = unicastProcessorPoll == null;
                    if (a(z10, z11, dVar, aVar)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(unicastProcessorPoll);
                    j11++;
                }
                if (j11 == j10 && a(this.done, aVar.isEmpty(), dVar, aVar)) {
                    return;
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j11);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<UnicastProcessor<T>> it2 = this.windows.iterator();
            while (it2.hasNext()) {
                it2.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            Iterator<UnicastProcessor<T>> it2 = this.windows.iterator();
            while (it2.hasNext()) {
                it2.next().onError(th2);
            }
            this.windows.clear();
            this.error = th2;
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            long j10 = this.index;
            if (j10 == 0 && !this.cancelled) {
                getAndIncrement();
                UnicastProcessor<T> unicastProcessorU8 = UnicastProcessor.U8(this.bufferSize, this);
                this.windows.offer(unicastProcessorU8);
                this.queue.offer(unicastProcessorU8);
                b();
            }
            long j11 = j10 + 1;
            Iterator<UnicastProcessor<T>> it2 = this.windows.iterator();
            while (it2.hasNext()) {
                it2.next().onNext(t10);
            }
            long j12 = this.produced + 1;
            if (j12 == this.size) {
                this.produced = j12 - this.skip;
                UnicastProcessor<T> unicastProcessorPoll = this.windows.poll();
                if (unicastProcessorPoll != null) {
                    unicastProcessorPoll.onComplete();
                }
            } else {
                this.produced = j12;
            }
            if (j11 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j11;
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(io.reactivex.internal.util.b.d(this.skip, j10));
                } else {
                    this.upstream.request(io.reactivex.internal.util.b.c(this.size, io.reactivex.internal.util.b.d(this.skip, j10 - 1)));
                }
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        public final int bufferSize;
        public final bu.d<? super xi.j<T>> downstream;
        public final AtomicBoolean firstRequest;
        public long index;
        public final AtomicBoolean once;
        public final long size;
        public final long skip;
        public bu.e upstream;
        public UnicastProcessor<T> window;

        public WindowSkipSubscriber(bu.d<? super xi.j<T>> dVar, long j10, long j11, int i10) {
            super(1);
            this.downstream = dVar;
            this.size = j10;
            this.skip = j11;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i10;
        }

        @Override // bu.e
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // bu.d
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th2);
            }
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = this.index;
            UnicastProcessor<T> unicastProcessorU8 = this.window;
            if (j10 == 0) {
                getAndIncrement();
                unicastProcessorU8 = UnicastProcessor.U8(this.bufferSize, this);
                this.window = unicastProcessorU8;
                this.downstream.onNext(unicastProcessorU8);
            }
            long j11 = j10 + 1;
            if (unicastProcessorU8 != null) {
                unicastProcessorU8.onNext(t10);
            }
            if (j11 == this.size) {
                this.window = null;
                unicastProcessorU8.onComplete();
            }
            if (j11 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j11;
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(io.reactivex.internal.util.b.d(this.skip, j10));
                } else {
                    this.upstream.request(io.reactivex.internal.util.b.c(io.reactivex.internal.util.b.d(this.size, j10), io.reactivex.internal.util.b.d(this.skip - this.size, j10 - 1)));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public FlowableWindow(xi.j<T> jVar, long j10, long j11, int i10) {
        super(jVar);
        this.f33497c = j10;
        this.f33498d = j11;
        this.f33499e = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super xi.j<T>> dVar) {
        long j10 = this.f33498d;
        long j11 = this.f33497c;
        if (j10 == j11) {
            this.f33524b.j6(new WindowExactSubscriber(dVar, this.f33497c, this.f33499e));
        } else if (j10 > j11) {
            this.f33524b.j6(new WindowSkipSubscriber(dVar, this.f33497c, this.f33498d, this.f33499e));
        } else {
            this.f33524b.j6(new WindowOverlapSubscriber(dVar, this.f33497c, this.f33498d, this.f33499e));
        }
    }
}
