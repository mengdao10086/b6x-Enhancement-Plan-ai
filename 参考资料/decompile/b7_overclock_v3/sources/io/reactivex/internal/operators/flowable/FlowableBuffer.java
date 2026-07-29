package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends io.reactivex.internal.operators.flowable.a<T, C> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Callable<C> f33165e;

    public static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements xi.o<T>, bu.e, dj.e {
        private static final long serialVersionUID = -7370244972039324525L;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public boolean done;
        public final bu.d<? super C> downstream;
        public int index;
        public long produced;
        public final int size;
        public final int skip;
        public bu.e upstream;
        public final AtomicBoolean once = new AtomicBoolean();
        public final ArrayDeque<C> buffers = new ArrayDeque<>();

        public PublisherBufferOverlappingSubscriber(bu.d<? super C> dVar, int i10, int i11, Callable<C> callable) {
            this.downstream = dVar;
            this.size = i10;
            this.skip = i11;
            this.bufferSupplier = callable;
        }

        @Override // dj.e
        public boolean a() {
            return this.cancelled;
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j10 = this.produced;
            if (j10 != 0) {
                io.reactivex.internal.util.b.e(this, j10);
            }
            io.reactivex.internal.util.n.g(this.downstream, this.buffers, this, this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i10 = this.index;
            int i11 = i10 + 1;
            if (i10 == 0) {
                try {
                    arrayDeque.offer((C) ((Collection) io.reactivex.internal.functions.a.g(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer")));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                    return;
                }
            }
            C cPeek = arrayDeque.peek();
            if (cPeek != null && cPeek.size() + 1 == this.size) {
                arrayDeque.poll();
                cPeek.add(t10);
                this.produced++;
                this.downstream.onNext(cPeek);
            }
            Iterator<C> it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                it2.next().add(t10);
            }
            if (i11 == this.skip) {
                i11 = 0;
            }
            this.index = i11;
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
            if (!SubscriptionHelper.validate(j10) || io.reactivex.internal.util.n.i(j10, this.downstream, this.buffers, this, this)) {
                return;
            }
            if (this.once.get() || !this.once.compareAndSet(false, true)) {
                this.upstream.request(io.reactivex.internal.util.b.d(this.skip, j10));
            } else {
                this.upstream.request(io.reactivex.internal.util.b.c(this.size, io.reactivex.internal.util.b.d(this.skip, j10 - 1)));
            }
        }
    }

    public static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -5616169793639412593L;
        public C buffer;
        public final Callable<C> bufferSupplier;
        public boolean done;
        public final bu.d<? super C> downstream;
        public int index;
        public final int size;
        public final int skip;
        public bu.e upstream;

        public PublisherBufferSkipSubscriber(bu.d<? super C> dVar, int i10, int i11, Callable<C> callable) {
            this.downstream = dVar;
            this.size = i10;
            this.skip = i11;
            this.bufferSupplier = callable;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c10 = this.buffer;
            this.buffer = null;
            if (c10 != null) {
                this.downstream.onNext(c10);
            }
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            C c10 = this.buffer;
            int i10 = this.index;
            int i11 = i10 + 1;
            if (i10 == 0) {
                try {
                    c10 = (C) io.reactivex.internal.functions.a.g(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c10;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                    return;
                }
            }
            if (c10 != null) {
                c10.add(t10);
                if (c10.size() == this.size) {
                    this.buffer = null;
                    this.downstream.onNext(c10);
                }
            }
            if (i11 == this.skip) {
                i11 = 0;
            }
            this.index = i11;
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
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.upstream.request(io.reactivex.internal.util.b.d(this.skip, j10));
                    return;
                }
                this.upstream.request(io.reactivex.internal.util.b.c(io.reactivex.internal.util.b.d(j10, this.size), io.reactivex.internal.util.b.d(this.skip - this.size, j10 - 1)));
            }
        }
    }

    public static final class a<T, C extends Collection<? super T>> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super C> f33166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Callable<C> f33167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C f33169d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public bu.e f33170e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f33171f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f33172g;

        public a(bu.d<? super C> dVar, int i10, Callable<C> callable) {
            this.f33166a = dVar;
            this.f33168c = i10;
            this.f33167b = callable;
        }

        @Override // bu.e
        public void cancel() {
            this.f33170e.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33171f) {
                return;
            }
            this.f33171f = true;
            C c10 = this.f33169d;
            if (c10 != null && !c10.isEmpty()) {
                this.f33166a.onNext(c10);
            }
            this.f33166a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33171f) {
                kj.a.Y(th2);
            } else {
                this.f33171f = true;
                this.f33166a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33171f) {
                return;
            }
            C c10 = this.f33169d;
            if (c10 == null) {
                try {
                    c10 = (C) io.reactivex.internal.functions.a.g(this.f33167b.call(), "The bufferSupplier returned a null buffer");
                    this.f33169d = c10;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                    return;
                }
            }
            c10.add(t10);
            int i10 = this.f33172g + 1;
            if (i10 != this.f33168c) {
                this.f33172g = i10;
                return;
            }
            this.f33172g = 0;
            this.f33169d = null;
            this.f33166a.onNext(c10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33170e, eVar)) {
                this.f33170e = eVar;
                this.f33166a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                this.f33170e.request(io.reactivex.internal.util.b.d(j10, this.f33168c));
            }
        }
    }

    public FlowableBuffer(xi.j<T> jVar, int i10, int i11, Callable<C> callable) {
        super(jVar);
        this.f33163c = i10;
        this.f33164d = i11;
        this.f33165e = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super C> dVar) {
        int i10 = this.f33163c;
        int i11 = this.f33164d;
        if (i10 == i11) {
            this.f33524b.j6(new a(dVar, i10, this.f33165e));
        } else if (i11 > i10) {
            this.f33524b.j6(new PublisherBufferSkipSubscriber(dVar, this.f33163c, this.f33164d, this.f33165e));
        } else {
            this.f33524b.j6(new PublisherBufferOverlappingSubscriber(dVar, this.f33163c, this.f33164d, this.f33165e));
        }
    }
}
