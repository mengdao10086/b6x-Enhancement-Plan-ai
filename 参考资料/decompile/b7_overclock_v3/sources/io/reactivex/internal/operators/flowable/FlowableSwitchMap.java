package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSwitchMap<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends R>> f33456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33458e;

    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<bu.e> implements xi.o<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final int bufferSize;
        public volatile boolean done;
        public int fusionMode;
        public final long index;
        public final SwitchMapSubscriber<T, R> parent;
        public volatile fj.o<R> queue;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j10, int i10) {
            this.parent = switchMapSubscriber;
            this.index = j10;
            this.bufferSize = i10;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void b(long j10) {
            if (this.fusionMode != 1) {
                get().request(j10);
            }
        }

        @Override // bu.d
        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.b();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique || !switchMapSubscriber.error.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!switchMapSubscriber.delayErrors) {
                switchMapSubscriber.upstream.cancel();
                switchMapSubscriber.done = true;
            }
            this.done = true;
            switchMapSubscriber.b();
        }

        @Override // bu.d
        public void onNext(R r10) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                if (this.fusionMode != 0 || this.queue.offer(r10)) {
                    switchMapSubscriber.b();
                } else {
                    onError(new MissingBackpressureException("Queue full?!"));
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this, eVar)) {
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.b();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        eVar.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                eVar.request(this.bufferSize);
            }
        }
    }

    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SwitchMapInnerSubscriber<Object, Object> f33459a;
        private static final long serialVersionUID = -3491074160481096299L;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final bu.d<? super R> downstream;
        public final dj.o<? super T, ? extends bu.c<? extends R>> mapper;
        public volatile long unique;
        public bu.e upstream;
        public final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicThrowable error = new AtomicThrowable();

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>(null, -1L, 1);
            f33459a = switchMapInnerSubscriber;
            switchMapInnerSubscriber.a();
        }

        public SwitchMapSubscriber(bu.d<? super R> dVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, boolean z10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.bufferSize = i10;
            this.delayErrors = z10;
        }

        public void a() {
            SwitchMapInnerSubscriber<T, R> andSet;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber2 = f33459a;
            if (switchMapInnerSubscriber == switchMapInnerSubscriber2 || (andSet = this.active.getAndSet((SwitchMapInnerSubscriber<T, R>) switchMapInnerSubscriber2)) == switchMapInnerSubscriber2 || andSet == null) {
                return;
            }
            andSet.a();
        }

        public void b() {
            boolean z10;
            a0.c cVarPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super R> dVar = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.done) {
                    if (this.delayErrors) {
                        if (this.active.get() == null) {
                            if (this.error.get() != null) {
                                dVar.onError(this.error.c());
                                return;
                            } else {
                                dVar.onComplete();
                                return;
                            }
                        }
                    } else if (this.error.get() != null) {
                        a();
                        dVar.onError(this.error.c());
                        return;
                    } else if (this.active.get() == null) {
                        dVar.onComplete();
                        return;
                    }
                }
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
                fj.o<R> oVar = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.queue : null;
                if (oVar != null) {
                    if (switchMapInnerSubscriber.done) {
                        if (this.delayErrors) {
                            if (oVar.isEmpty()) {
                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                            }
                        } else if (this.error.get() != null) {
                            a();
                            dVar.onError(this.error.c());
                            return;
                        } else if (oVar.isEmpty()) {
                            this.active.compareAndSet(switchMapInnerSubscriber, null);
                        }
                    }
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (true) {
                        z10 = false;
                        if (j11 != j10) {
                            if (!this.cancelled) {
                                boolean z11 = switchMapInnerSubscriber.done;
                                try {
                                    cVarPoll = oVar.poll();
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    switchMapInnerSubscriber.a();
                                    this.error.a(th2);
                                    cVarPoll = null;
                                    z11 = true;
                                }
                                boolean z12 = cVarPoll == null;
                                if (switchMapInnerSubscriber != this.active.get()) {
                                    break;
                                }
                                if (z11) {
                                    if (!this.delayErrors) {
                                        if (this.error.get() == null) {
                                            if (z12) {
                                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                                                break;
                                            }
                                        } else {
                                            dVar.onError(this.error.c());
                                            return;
                                        }
                                    } else if (z12) {
                                        this.active.compareAndSet(switchMapInnerSubscriber, null);
                                        break;
                                    }
                                }
                                if (z12) {
                                    break;
                                }
                                dVar.onNext(cVarPoll);
                                j11++;
                            } else {
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                    z10 = true;
                    if (j11 != 0 && !this.cancelled) {
                        if (j10 != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j11);
                        }
                        switchMapInnerSubscriber.b(j11);
                    }
                    if (z10) {
                        continue;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            a();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done || !this.error.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                a();
            }
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onNext(T t10) {
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber;
            if (this.done) {
                return;
            }
            long j10 = this.unique + 1;
            this.unique = j10;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
            if (switchMapInnerSubscriber2 != null) {
                switchMapInnerSubscriber2.a();
            }
            try {
                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The publisher returned is null");
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber<>(this, j10, this.bufferSize);
                do {
                    switchMapInnerSubscriber = this.active.get();
                    if (switchMapInnerSubscriber == f33459a) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerSubscriber, switchMapInnerSubscriber3));
                cVar.d(switchMapInnerSubscriber3);
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
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                if (this.unique == 0) {
                    this.upstream.request(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    public FlowableSwitchMap(xi.j<T> jVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, boolean z10) {
        super(jVar);
        this.f33456c = oVar;
        this.f33457d = i10;
        this.f33458e = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        if (w0.b(this.f33524b, dVar, this.f33456c)) {
            return;
        }
        this.f33524b.j6(new SwitchMapSubscriber(dVar, this.f33456c, this.f33457d, this.f33458e));
    }
}
