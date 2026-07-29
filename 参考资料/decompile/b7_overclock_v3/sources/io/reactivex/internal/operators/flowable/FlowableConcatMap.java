package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatMap<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends R>> f33200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ErrorMode f33202e;

    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements xi.o<T>, b<R>, bu.e {
        private static final long serialVersionUID = -3511336836796789179L;
        public volatile boolean active;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final int limit;
        public final dj.o<? super T, ? extends bu.c<? extends R>> mapper;
        public final int prefetch;
        public fj.o<T> queue;
        public int sourceMode;
        public bu.e upstream;
        public final ConcatMapInner<R> inner = new ConcatMapInner<>(this);
        public final AtomicThrowable errors = new AtomicThrowable();

        public BaseConcatMapSubscriber(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10) {
            this.mapper = oVar;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.b
        public final void c() {
            this.active = false;
            d();
        }

        public abstract void d();

        public abstract void f();

        @Override // bu.d
        public final void onComplete() {
            this.done = true;
            d();
        }

        @Override // bu.d
        public final void onNext(T t10) {
            if (this.sourceMode == 2 || this.queue.offer(t10)) {
                d();
            } else {
                this.upstream.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // xi.o, bu.d
        public final void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        f();
                        d();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        f();
                        eVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                f();
                eVar.request(this.prefetch);
            }
        }
    }

    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        public final bu.d<? super R> downstream;
        public final boolean veryEnd;

        public ConcatMapDelayed(bu.d<? super R> dVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, boolean z10) {
            super(oVar, i10);
            this.downstream = dVar;
            this.veryEnd = z10;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.b
        public void a(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.veryEnd) {
                this.upstream.cancel();
                this.done = true;
            }
            this.active = false;
            d();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.b
        public void b(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void d() {
            Object objCall;
            if (getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z10 = this.done;
                        if (z10 && !this.veryEnd && this.errors.get() != null) {
                            this.downstream.onError(this.errors.c());
                            return;
                        }
                        try {
                            T tPoll = this.queue.poll();
                            boolean z11 = tPoll == null;
                            if (z10 && z11) {
                                Throwable thC = this.errors.c();
                                if (thC != null) {
                                    this.downstream.onError(thC);
                                    return;
                                } else {
                                    this.downstream.onComplete();
                                    return;
                                }
                            }
                            if (!z11) {
                                try {
                                    bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.mapper.apply(tPoll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i10 = this.consumed + 1;
                                        if (i10 == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i10);
                                        } else {
                                            this.consumed = i10;
                                        }
                                    }
                                    if (cVar instanceof Callable) {
                                        try {
                                            objCall = ((Callable) cVar).call();
                                        } catch (Throwable th2) {
                                            io.reactivex.exceptions.a.b(th2);
                                            this.errors.a(th2);
                                            if (!this.veryEnd) {
                                                this.upstream.cancel();
                                                this.downstream.onError(this.errors.c());
                                                return;
                                            }
                                            objCall = null;
                                        }
                                        if (objCall == null) {
                                            continue;
                                        } else if (this.inner.h()) {
                                            this.downstream.onNext(objCall);
                                        } else {
                                            this.active = true;
                                            this.inner.k(new SimpleScalarSubscription(objCall, this.inner));
                                        }
                                    } else {
                                        this.active = true;
                                        cVar.d(this.inner);
                                    }
                                } catch (Throwable th3) {
                                    io.reactivex.exceptions.a.b(th3);
                                    this.upstream.cancel();
                                    this.errors.a(th3);
                                    this.downstream.onError(this.errors.c());
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            io.reactivex.exceptions.a.b(th4);
                            this.upstream.cancel();
                            this.errors.a(th4);
                            this.downstream.onError(this.errors.c());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void f() {
            this.downstream.onSubscribe(this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                d();
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.inner.request(j10);
        }
    }

    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        public final bu.d<? super R> downstream;
        public final AtomicInteger wip;

        public ConcatMapImmediate(bu.d<? super R> dVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10) {
            super(oVar, i10);
            this.downstream = dVar;
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.b
        public void a(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.downstream.onError(this.errors.c());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.b
        public void b(R r10) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(r10);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.downstream.onError(this.errors.c());
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void d() {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z10 = this.done;
                        try {
                            T tPoll = this.queue.poll();
                            boolean z11 = tPoll == null;
                            if (z10 && z11) {
                                this.downstream.onComplete();
                                return;
                            }
                            if (!z11) {
                                try {
                                    bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.mapper.apply(tPoll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i10 = this.consumed + 1;
                                        if (i10 == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i10);
                                        } else {
                                            this.consumed = i10;
                                        }
                                    }
                                    if (cVar instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) cVar).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (!this.inner.h()) {
                                                this.active = true;
                                                this.inner.k(new SimpleScalarSubscription(objCall, this.inner));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.downstream.onNext(objCall);
                                                if (!compareAndSet(1, 0)) {
                                                    this.downstream.onError(this.errors.c());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            io.reactivex.exceptions.a.b(th2);
                                            this.upstream.cancel();
                                            this.errors.a(th2);
                                            this.downstream.onError(this.errors.c());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        cVar.d(this.inner);
                                    }
                                } catch (Throwable th3) {
                                    io.reactivex.exceptions.a.b(th3);
                                    this.upstream.cancel();
                                    this.errors.a(th3);
                                    this.downstream.onError(this.errors.c());
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            io.reactivex.exceptions.a.b(th4);
                            this.upstream.cancel();
                            this.errors.a(th4);
                            this.downstream.onError(this.errors.c());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void f() {
            this.downstream.onSubscribe(this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.downstream.onError(this.errors.c());
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.inner.request(j10);
        }
    }

    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements xi.o<R> {
        private static final long serialVersionUID = 897683679971470653L;
        public final b<R> parent;
        public long produced;

        public ConcatMapInner(b<R> bVar) {
            super(false);
            this.parent = bVar;
        }

        @Override // bu.d
        public void onComplete() {
            long j10 = this.produced;
            if (j10 != 0) {
                this.produced = 0L;
                i(j10);
            }
            this.parent.c();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            long j10 = this.produced;
            if (j10 != 0) {
                this.produced = 0L;
                i(j10);
            }
            this.parent.a(th2);
        }

        @Override // bu.d
        public void onNext(R r10) {
            this.produced++;
            this.parent.b(r10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            k(eVar);
        }
    }

    public static final class SimpleScalarSubscription<T> extends AtomicBoolean implements bu.e {
        public final bu.d<? super T> downstream;
        public final T value;

        public SimpleScalarSubscription(T t10, bu.d<? super T> dVar) {
            this.value = t10;
            this.downstream = dVar;
        }

        @Override // bu.e
        public void cancel() {
        }

        @Override // bu.e
        public void request(long j10) {
            if (j10 <= 0 || !compareAndSet(false, true)) {
                return;
            }
            bu.d<? super T> dVar = this.downstream;
            dVar.onNext(this.value);
            dVar.onComplete();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33203a;

        static {
            int[] iArr = new int[ErrorMode.values().length];
            f33203a = iArr;
            try {
                iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33203a[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface b<T> {
        void a(Throwable th2);

        void b(T t10);

        void c();
    }

    public FlowableConcatMap(xi.j<T> jVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, ErrorMode errorMode) {
        super(jVar);
        this.f33200c = oVar;
        this.f33201d = i10;
        this.f33202e = errorMode;
    }

    public static <T, R> bu.d<T> M8(bu.d<? super R> dVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, ErrorMode errorMode) {
        int i11 = a.f33203a[errorMode.ordinal()];
        return i11 != 1 ? i11 != 2 ? new ConcatMapImmediate(dVar, oVar, i10) : new ConcatMapDelayed(dVar, oVar, i10, true) : new ConcatMapDelayed(dVar, oVar, i10, false);
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        if (w0.b(this.f33524b, dVar, this.f33200c)) {
            return;
        }
        this.f33524b.d(M8(dVar, this.f33200c, this.f33201d, this.f33202e));
    }
}
