package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableZip<T, R> extends xi.j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<? extends T>[] f33519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterable<? extends bu.c<? extends T>> f33520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f33521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33523f;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements bu.e {
        private static final long serialVersionUID = -2434867452883857743L;
        public volatile boolean cancelled;
        public final Object[] current;
        public final boolean delayErrors;
        public final bu.d<? super R> downstream;
        public final AtomicThrowable errors;
        public final AtomicLong requested;
        public final ZipSubscriber<T, R>[] subscribers;
        public final dj.o<? super Object[], ? extends R> zipper;

        public ZipCoordinator(bu.d<? super R> dVar, dj.o<? super Object[], ? extends R> oVar, int i10, int i11, boolean z10) {
            this.downstream = dVar;
            this.zipper = oVar;
            this.delayErrors = z10;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                zipSubscriberArr[i12] = new ZipSubscriber<>(this, i11);
            }
            this.current = new Object[i10];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        public void a() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        public void b() {
            boolean z10;
            T tPoll;
            boolean z11;
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super R> dVar = this.downstream;
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            int length = zipSubscriberArr.length;
            Object[] objArr = this.current;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j10 != j11) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        a();
                        dVar.onError(this.errors.c());
                        return;
                    }
                    boolean z12 = false;
                    for (int i10 = 0; i10 < length; i10++) {
                        ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i10];
                        if (objArr[i10] == null) {
                            try {
                                z10 = zipSubscriber.done;
                                fj.o<T> oVar = zipSubscriber.queue;
                                tPoll = oVar != null ? oVar.poll() : null;
                                z11 = tPoll == null;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.errors.a(th2);
                                if (!this.delayErrors) {
                                    a();
                                    dVar.onError(this.errors.c());
                                    return;
                                }
                            }
                            if (z10 && z11) {
                                a();
                                if (this.errors.get() != null) {
                                    dVar.onError(this.errors.c());
                                    return;
                                } else {
                                    dVar.onComplete();
                                    return;
                                }
                            }
                            if (z11) {
                                z12 = true;
                            } else {
                                objArr[i10] = tPoll;
                            }
                        }
                    }
                    if (z12) {
                        break;
                    }
                    try {
                        dVar.onNext((Object) io.reactivex.internal.functions.a.g(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                        j11++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        a();
                        this.errors.a(th3);
                        dVar.onError(this.errors.c());
                        return;
                    }
                }
                if (j10 == j11) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        a();
                        dVar.onError(this.errors.c());
                        return;
                    }
                    for (int i11 = 0; i11 < length; i11++) {
                        ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i11];
                        if (objArr[i11] == null) {
                            try {
                                boolean z13 = zipSubscriber2.done;
                                fj.o<T> oVar2 = zipSubscriber2.queue;
                                T tPoll2 = oVar2 != null ? oVar2.poll() : null;
                                boolean z14 = tPoll2 == null;
                                if (z13 && z14) {
                                    a();
                                    if (this.errors.get() != null) {
                                        dVar.onError(this.errors.c());
                                        return;
                                    } else {
                                        dVar.onComplete();
                                        return;
                                    }
                                }
                                if (!z14) {
                                    objArr[i11] = tPoll2;
                                }
                            } catch (Throwable th4) {
                                io.reactivex.exceptions.a.b(th4);
                                this.errors.a(th4);
                                if (!this.delayErrors) {
                                    a();
                                    dVar.onError(this.errors.c());
                                    return;
                                }
                            }
                        }
                    }
                }
                if (j11 != 0) {
                    for (ZipSubscriber<T, R> zipSubscriber3 : zipSubscriberArr) {
                        zipSubscriber3.request(j11);
                    }
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j11);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void c(ZipSubscriber<T, R> zipSubscriber, Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                zipSubscriber.done = true;
                b();
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            a();
        }

        public void d(bu.c<? extends T>[] cVarArr, int i10) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i11 = 0; i11 < i10 && !this.cancelled; i11++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                cVarArr[i11].d(zipSubscriberArr[i11]);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }
    }

    public static final class ZipSubscriber<T, R> extends AtomicReference<bu.e> implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -4627193790118206028L;
        public volatile boolean done;
        public final int limit;
        public final ZipCoordinator<T, R> parent;
        public final int prefetch;
        public long produced;
        public fj.o<T> queue;
        public int sourceMode;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i10) {
            this.parent = zipCoordinator;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            this.parent.b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.c(this, th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.sourceMode != 2) {
                this.queue.offer(t10);
            }
            this.parent.b();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this, eVar)) {
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.b();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        eVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                eVar.request(this.prefetch);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (this.sourceMode != 1) {
                long j11 = this.produced + j10;
                if (j11 < this.limit) {
                    this.produced = j11;
                } else {
                    this.produced = 0L;
                    get().request(j11);
                }
            }
        }
    }

    public FlowableZip(bu.c<? extends T>[] cVarArr, Iterable<? extends bu.c<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
        this.f33519b = cVarArr;
        this.f33520c = iterable;
        this.f33521d = oVar;
        this.f33522e = i10;
        this.f33523f = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        int length;
        bu.c<? extends T>[] cVarArr = this.f33519b;
        if (cVarArr == null) {
            cVarArr = new bu.c[8];
            length = 0;
            for (bu.c<? extends T> cVar : this.f33520c) {
                if (length == cVarArr.length) {
                    bu.c<? extends T>[] cVarArr2 = new bu.c[(length >> 2) + length];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                    cVarArr = cVarArr2;
                }
                cVarArr[length] = cVar;
                length++;
            }
        } else {
            length = cVarArr.length;
        }
        int i10 = length;
        if (i10 == 0) {
            EmptySubscription.complete(dVar);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(dVar, this.f33521d, i10, this.f33522e, this.f33523f);
        dVar.onSubscribe(zipCoordinator);
        zipCoordinator.d(cVarArr, i10);
    }
}
