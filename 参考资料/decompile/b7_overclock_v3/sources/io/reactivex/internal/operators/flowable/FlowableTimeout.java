package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTimeout<T, U, V> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<U> f33476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<V>> f33477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bu.c<? extends T> f33478e;

    public static final class TimeoutConsumer extends AtomicReference<bu.e> implements xi.o<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8708641127342403073L;
        public final long idx;
        public final a parent;

        public TimeoutConsumer(long j10, a aVar) {
            this.idx = j10;
            this.parent = aVar;
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
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.a(this.idx);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj == subscriptionHelper) {
                kj.a.Y(th2);
            } else {
                lazySet(subscriptionHelper);
                this.parent.b(this.idx, th2);
            }
        }

        @Override // bu.d
        public void onNext(Object obj) {
            bu.e eVar = (bu.e) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                eVar.cancel();
                lazySet(subscriptionHelper);
                this.parent.a(this.idx);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements xi.o<T>, a {
        private static final long serialVersionUID = 3764492702657003550L;
        public long consumed;
        public final bu.d<? super T> downstream;
        public bu.c<? extends T> fallback;
        public final AtomicLong index;
        public final dj.o<? super T, ? extends bu.c<?>> itemTimeoutIndicator;
        public final SequentialDisposable task;
        public final AtomicReference<bu.e> upstream;

        public TimeoutFallbackSubscriber(bu.d<? super T> dVar, dj.o<? super T, ? extends bu.c<?>> oVar, bu.c<? extends T> cVar) {
            super(true);
            this.downstream = dVar;
            this.itemTimeoutIndicator = oVar;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference<>();
            this.fallback = cVar;
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void a(long j10) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                bu.c<? extends T> cVar = this.fallback;
                this.fallback = null;
                long j11 = this.consumed;
                if (j11 != 0) {
                    i(j11);
                }
                cVar.d(new FlowableTimeoutTimed.a(this.downstream, this));
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.a
        public void b(long j10, Throwable th2) {
            if (!this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                kj.a.Y(th2);
            } else {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, bu.e
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        public void l(bu.c<?> cVar) {
            if (cVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.a(timeoutConsumer)) {
                    cVar.d(timeoutConsumer);
                }
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.task.dispose();
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = this.index.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = j10 + 1;
                if (this.index.compareAndSet(j10, j11)) {
                    io.reactivex.disposables.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.consumed++;
                    this.downstream.onNext(t10);
                    try {
                        bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.itemTimeoutIndicator.apply(t10), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j11, this);
                        if (this.task.a(timeoutConsumer)) {
                            cVar.d(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.upstream.get().cancel();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th2);
                    }
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this.upstream, eVar)) {
                k(eVar);
            }
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e, a {
        private static final long serialVersionUID = 3764492702657003550L;
        public final bu.d<? super T> downstream;
        public final dj.o<? super T, ? extends bu.c<?>> itemTimeoutIndicator;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public TimeoutSubscriber(bu.d<? super T> dVar, dj.o<? super T, ? extends bu.c<?>> oVar) {
            this.downstream = dVar;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void a(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.a
        public void b(long j10, Throwable th2) {
            if (!compareAndSet(j10, Long.MAX_VALUE)) {
                kj.a.Y(th2);
            } else {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th2);
            }
        }

        public void c(bu.c<?> cVar) {
            if (cVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.a(timeoutConsumer)) {
                    cVar.d(timeoutConsumer);
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
            } else {
                this.task.dispose();
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    io.reactivex.disposables.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.downstream.onNext(t10);
                    try {
                        bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.itemTimeoutIndicator.apply(t10), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j11, this);
                        if (this.task.a(timeoutConsumer)) {
                            cVar.d(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.upstream.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th2);
                    }
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, eVar);
        }

        @Override // bu.e
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j10);
        }
    }

    public interface a extends FlowableTimeoutTimed.b {
        void b(long j10, Throwable th2);
    }

    public FlowableTimeout(xi.j<T> jVar, bu.c<U> cVar, dj.o<? super T, ? extends bu.c<V>> oVar, bu.c<? extends T> cVar2) {
        super(jVar);
        this.f33476c = cVar;
        this.f33477d = oVar;
        this.f33478e = cVar2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (this.f33478e == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(dVar, this.f33477d);
            dVar.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.c(this.f33476c);
            this.f33524b.j6(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(dVar, this.f33477d, this.f33478e);
        dVar.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.l(this.f33476c);
        this.f33524b.j6(timeoutFallbackSubscriber);
    }
}
