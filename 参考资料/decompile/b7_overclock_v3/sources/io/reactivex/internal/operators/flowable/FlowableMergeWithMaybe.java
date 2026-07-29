package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableMergeWithMaybe<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.w<? extends T> f33324c;

    public static final class MergeWithObserver<T> extends AtomicInteger implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33325a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f33326b = 2;
        private static final long serialVersionUID = -4592979584110982903L;
        public volatile boolean cancelled;
        public int consumed;
        public final bu.d<? super T> downstream;
        public long emitted;
        public final int limit;
        public volatile boolean mainDone;
        public volatile int otherState;
        public final int prefetch;
        public volatile fj.n<T> queue;
        public T singleItem;
        public final AtomicReference<bu.e> mainSubscription = new AtomicReference<>();
        public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        public final AtomicThrowable error = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();

        public static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // xi.t
            public void onComplete() {
                this.parent.d();
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.parent.f(th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.t
            public void onSuccess(T t10) {
                this.parent.h(t10);
            }
        }

        public MergeWithObserver(bu.d<? super T> dVar) {
            this.downstream = dVar;
            int iY = xi.j.Y();
            this.prefetch = iY;
            this.limit = iY - (iY >> 2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            bu.d<? super T> dVar = this.downstream;
            long j10 = this.emitted;
            int i10 = this.consumed;
            int i11 = this.limit;
            int i12 = 1;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.requested.get();
                while (j10 != j11) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    }
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        dVar.onError(this.error.c());
                        return;
                    }
                    int i13 = this.otherState;
                    if (i13 == i12) {
                        T t10 = this.singleItem;
                        this.singleItem = null;
                        this.otherState = 2;
                        dVar.onNext(t10);
                        j10++;
                    } else {
                        boolean z10 = this.mainDone;
                        fj.n<T> nVar = this.queue;
                        a0.c cVarPoll = nVar != null ? nVar.poll() : null;
                        boolean z11 = cVarPoll == null;
                        if (z10 && z11 && i13 == 2) {
                            this.queue = null;
                            dVar.onComplete();
                            return;
                        } else {
                            if (z11) {
                                break;
                            }
                            dVar.onNext(cVarPoll);
                            j10++;
                            i10++;
                            if (i10 == i11) {
                                this.mainSubscription.get().request(i11);
                                i10 = 0;
                            }
                            i12 = 1;
                        }
                    }
                }
                if (j10 == j11) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    }
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        dVar.onError(this.error.c());
                        return;
                    }
                    boolean z12 = this.mainDone;
                    fj.n<T> nVar2 = this.queue;
                    boolean z13 = nVar2 == null || nVar2.isEmpty();
                    if (z12 && z13 && this.otherState == 2) {
                        this.queue = null;
                        dVar.onComplete();
                        return;
                    }
                }
                this.emitted = j10;
                this.consumed = i10;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                } else {
                    i12 = 1;
                }
            }
        }

        public fj.n<T> c() {
            fj.n<T> nVar = this.queue;
            if (nVar != null) {
                return nVar;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(xi.j.Y());
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        public void d() {
            this.otherState = 2;
            a();
        }

        public void f(Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else {
                SubscriptionHelper.cancel(this.mainSubscription);
                a();
            }
        }

        public void h(T t10) {
            if (compareAndSet(0, 1)) {
                long j10 = this.emitted;
                if (this.requested.get() != j10) {
                    this.emitted = j10 + 1;
                    this.downstream.onNext(t10);
                    this.otherState = 2;
                } else {
                    this.singleItem = t10;
                    this.otherState = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.singleItem = t10;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // bu.d
        public void onComplete() {
            this.mainDone = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this.otherObserver);
                a();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (compareAndSet(0, 1)) {
                long j10 = this.emitted;
                if (this.requested.get() != j10) {
                    fj.n<T> nVar = this.queue;
                    if (nVar == null || nVar.isEmpty()) {
                        this.emitted = j10 + 1;
                        this.downstream.onNext(t10);
                        int i10 = this.consumed + 1;
                        if (i10 == this.limit) {
                            this.consumed = 0;
                            this.mainSubscription.get().request(i10);
                        } else {
                            this.consumed = i10;
                        }
                    } else {
                        nVar.offer(t10);
                    }
                } else {
                    c().offer(t10);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t10);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this.mainSubscription, eVar, this.prefetch);
        }

        @Override // bu.e
        public void request(long j10) {
            io.reactivex.internal.util.b.a(this.requested, j10);
            a();
        }
    }

    public FlowableMergeWithMaybe(xi.j<T> jVar, xi.w<? extends T> wVar) {
        super(jVar);
        this.f33324c = wVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(dVar);
        dVar.onSubscribe(mergeWithObserver);
        this.f33524b.j6(mergeWithObserver);
        this.f33324c.a(mergeWithObserver.otherObserver);
    }
}
