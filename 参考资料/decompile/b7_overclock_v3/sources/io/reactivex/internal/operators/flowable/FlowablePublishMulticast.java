package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowablePublishMulticast<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super xi.j<T>, ? extends bu.c<? extends R>> f33359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33361e;

    public static final class MulticastSubscription<T> extends AtomicLong implements bu.e {
        private static final long serialVersionUID = 8664815189257569791L;
        public final bu.d<? super T> downstream;
        public long emitted;
        public final a<T> parent;

        public MulticastSubscription(bu.d<? super T> dVar, a<T> aVar) {
            this.downstream = dVar;
            this.parent = aVar;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        @Override // bu.e
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.Q8(this);
                this.parent.O8();
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.b(this, j10);
                this.parent.O8();
            }
        }
    }

    public static final class a<T> extends xi.j<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final MulticastSubscription[] f33362m = new MulticastSubscription[0];

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final MulticastSubscription[] f33363n = new MulticastSubscription[0];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f33366d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f33367e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f33368f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile fj.o<T> f33370h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f33371i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile boolean f33372j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Throwable f33373k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f33374l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f33364b = new AtomicInteger();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicReference<bu.e> f33369g = new AtomicReference<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReference<MulticastSubscription<T>[]> f33365c = new AtomicReference<>(f33362m);

        public a(int i10, boolean z10) {
            this.f33366d = i10;
            this.f33367e = i10 - (i10 >> 2);
            this.f33368f = z10;
        }

        public boolean M8(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.f33365c.get();
                if (multicastSubscriptionArr == f33363n) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!this.f33365c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        public void N8() {
            for (MulticastSubscription<T> multicastSubscription : this.f33365c.getAndSet(f33363n)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onComplete();
                }
            }
        }

        public void O8() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            Throwable th2;
            Throwable th3;
            if (this.f33364b.getAndIncrement() != 0) {
                return;
            }
            fj.o<T> oVar = this.f33370h;
            int i10 = this.f33374l;
            int i11 = this.f33367e;
            boolean z10 = this.f33371i != 1;
            AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.f33365c;
            MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference2.get();
            int iAddAndGet = 1;
            while (true) {
                int length = multicastSubscriptionArr.length;
                if (oVar == null || length == 0) {
                    atomicReference = atomicReference2;
                } else {
                    int length2 = multicastSubscriptionArr.length;
                    long j10 = Long.MAX_VALUE;
                    long j11 = Long.MAX_VALUE;
                    int i12 = 0;
                    while (i12 < length2) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i12];
                        AtomicReference<MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                        long j12 = multicastSubscription.get() - multicastSubscription.emitted;
                        if (j12 == Long.MIN_VALUE) {
                            length--;
                        } else if (j11 > j12) {
                            j11 = j12;
                        }
                        i12++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j13 = 0;
                    if (length == 0) {
                        j11 = 0;
                    }
                    while (j11 != j13) {
                        if (isDisposed()) {
                            oVar.clear();
                            return;
                        }
                        boolean z11 = this.f33372j;
                        if (z11 && !this.f33368f && (th3 = this.f33373k) != null) {
                            P8(th3);
                            return;
                        }
                        try {
                            T tPoll = oVar.poll();
                            boolean z12 = tPoll == null;
                            if (z11 && z12) {
                                Throwable th4 = this.f33373k;
                                if (th4 != null) {
                                    P8(th4);
                                    return;
                                } else {
                                    N8();
                                    return;
                                }
                            }
                            if (z12) {
                                break;
                            }
                            int length3 = multicastSubscriptionArr.length;
                            int i13 = 0;
                            boolean z13 = false;
                            while (i13 < length3) {
                                MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i13];
                                long j14 = multicastSubscription2.get();
                                if (j14 != Long.MIN_VALUE) {
                                    if (j14 != j10) {
                                        multicastSubscription2.emitted++;
                                    }
                                    multicastSubscription2.downstream.onNext(tPoll);
                                } else {
                                    z13 = true;
                                }
                                i13++;
                                j10 = Long.MAX_VALUE;
                            }
                            j11--;
                            if (z10 && (i10 = i10 + 1) == i11) {
                                this.f33369g.get().request(i11);
                                i10 = 0;
                            }
                            MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                            if (z13 || multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                multicastSubscriptionArr = multicastSubscriptionArr2;
                                break;
                            } else {
                                j13 = 0;
                                j10 = Long.MAX_VALUE;
                            }
                        } catch (Throwable th5) {
                            io.reactivex.exceptions.a.b(th5);
                            SubscriptionHelper.cancel(this.f33369g);
                            P8(th5);
                            return;
                        }
                    }
                    if (j11 == j13) {
                        if (isDisposed()) {
                            oVar.clear();
                            return;
                        }
                        boolean z14 = this.f33372j;
                        if (z14 && !this.f33368f && (th2 = this.f33373k) != null) {
                            P8(th2);
                            return;
                        }
                        if (z14 && oVar.isEmpty()) {
                            Throwable th6 = this.f33373k;
                            if (th6 != null) {
                                P8(th6);
                                return;
                            } else {
                                N8();
                                return;
                            }
                        }
                    }
                }
                this.f33374l = i10;
                iAddAndGet = this.f33364b.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (oVar == null) {
                    oVar = this.f33370h;
                }
                multicastSubscriptionArr = atomicReference.get();
                atomicReference2 = atomicReference;
            }
        }

        public void P8(Throwable th2) {
            for (MulticastSubscription<T> multicastSubscription : this.f33365c.getAndSet(f33363n)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onError(th2);
                }
            }
        }

        public void Q8(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.f33365c.get();
                int length = multicastSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (multicastSubscriptionArr[i11] == multicastSubscription) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    multicastSubscriptionArr2 = f33362m;
                } else {
                    MulticastSubscription<T>[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i10);
                    System.arraycopy(multicastSubscriptionArr, i10 + 1, multicastSubscriptionArr3, i10, (length - i10) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!this.f33365c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            fj.o<T> oVar;
            SubscriptionHelper.cancel(this.f33369g);
            if (this.f33364b.getAndIncrement() != 0 || (oVar = this.f33370h) == null) {
                return;
            }
            oVar.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33369g.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // xi.j
        public void k6(bu.d<? super T> dVar) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(dVar, this);
            dVar.onSubscribe(multicastSubscription);
            if (M8(multicastSubscription)) {
                if (multicastSubscription.a()) {
                    Q8(multicastSubscription);
                    return;
                } else {
                    O8();
                    return;
                }
            }
            Throwable th2 = this.f33373k;
            if (th2 != null) {
                dVar.onError(th2);
            } else {
                dVar.onComplete();
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33372j) {
                return;
            }
            this.f33372j = true;
            O8();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33372j) {
                kj.a.Y(th2);
                return;
            }
            this.f33373k = th2;
            this.f33372j = true;
            O8();
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33372j) {
                return;
            }
            if (this.f33371i != 0 || this.f33370h.offer(t10)) {
                O8();
            } else {
                this.f33369g.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this.f33369g, eVar)) {
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.f33371i = iRequestFusion;
                        this.f33370h = lVar;
                        this.f33372j = true;
                        O8();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f33371i = iRequestFusion;
                        this.f33370h = lVar;
                        io.reactivex.internal.util.n.j(eVar, this.f33366d);
                        return;
                    }
                }
                this.f33370h = io.reactivex.internal.util.n.c(this.f33366d);
                io.reactivex.internal.util.n.j(eVar, this.f33366d);
            }
        }
    }

    public static final class b<R> implements xi.o<R>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super R> f33375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<?> f33376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33377c;

        public b(bu.d<? super R> dVar, a<?> aVar) {
            this.f33375a = dVar;
            this.f33376b = aVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33377c.cancel();
            this.f33376b.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            this.f33375a.onComplete();
            this.f33376b.dispose();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33375a.onError(th2);
            this.f33376b.dispose();
        }

        @Override // bu.d
        public void onNext(R r10) {
            this.f33375a.onNext(r10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33377c, eVar)) {
                this.f33377c = eVar;
                this.f33375a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33377c.request(j10);
        }
    }

    public FlowablePublishMulticast(xi.j<T> jVar, dj.o<? super xi.j<T>, ? extends bu.c<? extends R>> oVar, int i10, boolean z10) {
        super(jVar);
        this.f33359c = oVar;
        this.f33360d = i10;
        this.f33361e = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        a aVar = new a(this.f33360d, this.f33361e);
        try {
            ((bu.c) io.reactivex.internal.functions.a.g(this.f33359c.apply(aVar), "selector returned a null Publisher")).d(new b(dVar, aVar));
            this.f33524b.j6(aVar);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
