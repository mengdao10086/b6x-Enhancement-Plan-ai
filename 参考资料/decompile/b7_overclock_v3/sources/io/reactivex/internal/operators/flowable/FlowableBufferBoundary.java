package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<U> f33173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bu.c<? extends Open> f33174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.o<? super Open, ? extends bu.c<? extends Close>> f33175e;

    public static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -8466418554264089604L;
        public final dj.o<? super Open, ? extends bu.c<? extends Close>> bufferClose;
        public final bu.c<? extends Open> bufferOpen;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final bu.d<? super C> downstream;
        public long emitted;
        public long index;
        public final io.reactivex.internal.queue.a<C> queue = new io.reactivex.internal.queue.a<>(xi.j.Y());
        public final io.reactivex.disposables.a subscribers = new io.reactivex.disposables.a();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public Map<Long, C> buffers = new LinkedHashMap();
        public final AtomicThrowable errors = new AtomicThrowable();

        public static final class BufferOpenSubscriber<Open> extends AtomicReference<bu.e> implements xi.o<Open>, io.reactivex.disposables.b {
            private static final long serialVersionUID = -8498650778633225126L;
            public final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            public BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.parent = bufferBoundarySubscriber;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }

            @Override // bu.d
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.f(this);
            }

            @Override // bu.d
            public void onError(Throwable th2) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.a(this, th2);
            }

            @Override // bu.d
            public void onNext(Open open) {
                this.parent.d(open);
            }

            @Override // xi.o, bu.d
            public void onSubscribe(bu.e eVar) {
                SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
            }
        }

        public BufferBoundarySubscriber(bu.d<? super C> dVar, bu.c<? extends Open> cVar, dj.o<? super Open, ? extends bu.c<? extends Close>> oVar, Callable<C> callable) {
            this.downstream = dVar;
            this.bufferSupplier = callable;
            this.bufferOpen = cVar;
            this.bufferClose = oVar;
        }

        public void a(io.reactivex.disposables.b bVar, Throwable th2) {
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.c(bVar);
            onError(th2);
        }

        public void b(BufferCloseSubscriber<T, C> bufferCloseSubscriber, long j10) {
            boolean z10;
            this.subscribers.c(bufferCloseSubscriber);
            if (this.subscribers.g() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                z10 = true;
            } else {
                z10 = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(j10)));
                if (z10) {
                    this.done = true;
                }
                c();
            }
        }

        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j10 = this.emitted;
            bu.d<? super C> dVar = this.downstream;
            io.reactivex.internal.queue.a<C> aVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j11 = this.requested.get();
                while (j10 != j11) {
                    if (this.cancelled) {
                        aVar.clear();
                        return;
                    }
                    boolean z10 = this.done;
                    if (z10 && this.errors.get() != null) {
                        aVar.clear();
                        dVar.onError(this.errors.c());
                        return;
                    }
                    C cPoll = aVar.poll();
                    boolean z11 = cPoll == null;
                    if (z10 && z11) {
                        dVar.onComplete();
                        return;
                    } else {
                        if (z11) {
                            break;
                        }
                        dVar.onNext(cPoll);
                        j10++;
                    }
                }
                if (j10 == j11) {
                    if (this.cancelled) {
                        aVar.clear();
                        return;
                    }
                    if (this.done) {
                        if (this.errors.get() != null) {
                            aVar.clear();
                            dVar.onError(this.errors.c());
                            return;
                        } else if (aVar.isEmpty()) {
                            dVar.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j10;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // bu.e
        public void cancel() {
            if (SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        public void d(Open open) {
            try {
                Collection collection = (Collection) io.reactivex.internal.functions.a.g(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.bufferClose.apply(open), "The bufferClose returned a null Publisher");
                long j10 = this.index;
                this.index = 1 + j10;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j10), (C) collection);
                    BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j10);
                    this.subscribers.b(bufferCloseSubscriber);
                    cVar.d(bufferCloseSubscriber);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                SubscriptionHelper.cancel(this.upstream);
                onError(th2);
            }
        }

        public void f(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.subscribers.c(bufferOpenSubscriber);
            if (this.subscribers.g() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                this.done = true;
                c();
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.subscribers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    this.queue.offer(it2.next());
                }
                this.buffers = null;
                this.done = true;
                c();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            c();
        }

        @Override // bu.d
        public void onNext(T t10) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    it2.next().add(t10);
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this.upstream, eVar)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.subscribers.b(bufferOpenSubscriber);
                this.bufferOpen.d(bufferOpenSubscriber);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            io.reactivex.internal.util.b.a(this.requested, j10);
            c();
        }
    }

    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<bu.e> implements xi.o<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8498650778633225126L;
        public final long index;
        public final BufferBoundarySubscriber<T, C, ?, ?> parent;

        public BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j10) {
            this.parent = bufferBoundarySubscriber;
            this.index = j10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            bu.e eVar = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.b(this, this.index);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            bu.e eVar = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar == subscriptionHelper) {
                kj.a.Y(th2);
            } else {
                lazySet(subscriptionHelper);
                this.parent.a(this, th2);
            }
        }

        @Override // bu.d
        public void onNext(Object obj) {
            bu.e eVar = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                lazySet(subscriptionHelper);
                eVar.cancel();
                this.parent.b(this, this.index);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(xi.j<T> jVar, bu.c<? extends Open> cVar, dj.o<? super Open, ? extends bu.c<? extends Close>> oVar, Callable<U> callable) {
        super(jVar);
        this.f33174d = cVar;
        this.f33175e = oVar;
        this.f33173c = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(dVar, this.f33174d, this.f33175e, this.f33173c);
        dVar.onSubscribe(bufferBoundarySubscriber);
        this.f33524b.j6(bufferBoundarySubscriber);
    }
}
