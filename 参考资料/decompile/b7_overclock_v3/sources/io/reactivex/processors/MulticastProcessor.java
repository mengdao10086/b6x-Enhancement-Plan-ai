package io.reactivex.processors;

import bj.c;
import bj.g;
import bu.d;
import bu.e;
import fj.l;
import fj.o;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;

/* JADX INFO: loaded from: classes5.dex */
@g("none")
@bj.a(BackpressureKind.FULL)
public final class MulticastProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final MulticastSubscription[] f35323n = new MulticastSubscription[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final MulticastSubscription[] f35324o = new MulticastSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f35325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<e> f35326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<MulticastSubscription<T>[]> f35327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f35328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f35329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f35330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f35331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile o<T> f35332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f35333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile Throwable f35334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f35335l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f35336m;

    public static final class MulticastSubscription<T> extends AtomicLong implements e {
        private static final long serialVersionUID = -363282618957264509L;
        public final d<? super T> downstream;
        public long emitted;
        public final MulticastProcessor<T> parent;

        public MulticastSubscription(d<? super T> dVar, MulticastProcessor<T> multicastProcessor) {
            this.downstream = dVar;
            this.parent = multicastProcessor;
        }

        public void a() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th2);
            }
        }

        public void c(T t10) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t10);
            }
        }

        @Override // bu.e
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.Y8(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            long j11;
            long j12;
            if (SubscriptionHelper.validate(j10)) {
                do {
                    j11 = get();
                    if (j11 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j11 == Long.MAX_VALUE) {
                        return;
                    } else {
                        j12 = j11 + j10;
                    }
                } while (!compareAndSet(j11, j12 >= 0 ? j12 : Long.MAX_VALUE));
                this.parent.W8();
            }
        }
    }

    public MulticastProcessor(int i10, boolean z10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        this.f35329f = i10;
        this.f35330g = i10 - (i10 >> 2);
        this.f35325b = new AtomicInteger();
        this.f35327d = new AtomicReference<>(f35323n);
        this.f35326c = new AtomicReference<>();
        this.f35331h = z10;
        this.f35328e = new AtomicBoolean();
    }

    @c
    @bj.e
    public static <T> MulticastProcessor<T> S8() {
        return new MulticastProcessor<>(j.Y(), false);
    }

    @c
    @bj.e
    public static <T> MulticastProcessor<T> T8(int i10) {
        return new MulticastProcessor<>(i10, false);
    }

    @c
    @bj.e
    public static <T> MulticastProcessor<T> U8(int i10, boolean z10) {
        return new MulticastProcessor<>(i10, z10);
    }

    @c
    @bj.e
    public static <T> MulticastProcessor<T> V8(boolean z10) {
        return new MulticastProcessor<>(j.Y(), z10);
    }

    @Override // io.reactivex.processors.a
    public Throwable M8() {
        if (this.f35328e.get()) {
            return this.f35334k;
        }
        return null;
    }

    @Override // io.reactivex.processors.a
    public boolean N8() {
        return this.f35328e.get() && this.f35334k == null;
    }

    @Override // io.reactivex.processors.a
    public boolean O8() {
        return this.f35327d.get().length != 0;
    }

    @Override // io.reactivex.processors.a
    public boolean P8() {
        return this.f35328e.get() && this.f35334k != null;
    }

    public boolean R8(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription<T>[] multicastSubscriptionArr;
        MulticastSubscription<T>[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = this.f35327d.get();
            if (multicastSubscriptionArr == f35324o) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!this.f35327d.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    public void W8() {
        T tPoll;
        if (this.f35325b.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<MulticastSubscription<T>[]> atomicReference = this.f35327d;
        int i10 = this.f35335l;
        int i11 = this.f35330g;
        int i12 = this.f35336m;
        int iAddAndGet = 1;
        while (true) {
            o<T> oVar = this.f35332i;
            if (oVar != null) {
                MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                if (multicastSubscriptionArr.length != 0) {
                    int length = multicastSubscriptionArr.length;
                    long j10 = -1;
                    long jMin = -1;
                    int i13 = 0;
                    while (i13 < length) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i13];
                        long j11 = multicastSubscription.get();
                        if (j11 >= 0) {
                            jMin = jMin == j10 ? j11 - multicastSubscription.emitted : Math.min(jMin, j11 - multicastSubscription.emitted);
                        }
                        i13++;
                        j10 = -1;
                    }
                    int i14 = i10;
                    while (jMin > 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                        if (multicastSubscriptionArr2 == f35324o) {
                            oVar.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                            break;
                        }
                        boolean z10 = this.f35333j;
                        try {
                            tPoll = oVar.poll();
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            SubscriptionHelper.cancel(this.f35326c);
                            this.f35334k = th2;
                            this.f35333j = true;
                            tPoll = null;
                            z10 = true;
                        }
                        boolean z11 = tPoll == null;
                        if (z10 && z11) {
                            Throwable th3 = this.f35334k;
                            if (th3 != null) {
                                for (MulticastSubscription<T> multicastSubscription2 : atomicReference.getAndSet(f35324o)) {
                                    multicastSubscription2.b(th3);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription3 : atomicReference.getAndSet(f35324o)) {
                                multicastSubscription3.a();
                            }
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        for (MulticastSubscription<T> multicastSubscription4 : multicastSubscriptionArr) {
                            multicastSubscription4.c(tPoll);
                        }
                        jMin--;
                        if (i12 != 1 && (i14 = i14 + 1) == i11) {
                            this.f35326c.get().request(i11);
                            i14 = 0;
                        }
                    }
                    if (jMin == 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr3 = atomicReference.get();
                        MulticastSubscription<T>[] multicastSubscriptionArr4 = f35324o;
                        if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                            oVar.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr3) {
                            i10 = i14;
                        } else if (this.f35333j && oVar.isEmpty()) {
                            Throwable th4 = this.f35334k;
                            if (th4 != null) {
                                for (MulticastSubscription<T> multicastSubscription5 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                    multicastSubscription5.b(th4);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription6 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                multicastSubscription6.a();
                            }
                            return;
                        }
                    }
                    i10 = i14;
                }
            }
            this.f35335l = i10;
            iAddAndGet = this.f35325b.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    public boolean X8(T t10) {
        if (this.f35328e.get()) {
            return false;
        }
        io.reactivex.internal.functions.a.g(t10, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35336m != 0 || !this.f35332i.offer(t10)) {
            return false;
        }
        W8();
        return true;
    }

    public void Y8(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = this.f35327d.get();
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
            if (length != 1) {
                MulticastSubscription<T>[] multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i10);
                System.arraycopy(multicastSubscriptionArr, i10 + 1, multicastSubscriptionArr2, i10, (length - i10) - 1);
                if (this.f35327d.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2)) {
                    return;
                }
            } else if (this.f35331h) {
                if (this.f35327d.compareAndSet(multicastSubscriptionArr, f35324o)) {
                    SubscriptionHelper.cancel(this.f35326c);
                    this.f35328e.set(true);
                    return;
                }
            } else if (this.f35327d.compareAndSet(multicastSubscriptionArr, f35323n)) {
                return;
            }
        }
    }

    public void Z8() {
        if (SubscriptionHelper.setOnce(this.f35326c, EmptySubscription.INSTANCE)) {
            this.f35332i = new SpscArrayQueue(this.f35329f);
        }
    }

    public void a9() {
        if (SubscriptionHelper.setOnce(this.f35326c, EmptySubscription.INSTANCE)) {
            this.f35332i = new io.reactivex.internal.queue.a(this.f35329f);
        }
    }

    @Override // xi.j
    public void k6(d<? super T> dVar) {
        Throwable th2;
        MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(dVar, this);
        dVar.onSubscribe(multicastSubscription);
        if (R8(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                Y8(multicastSubscription);
                return;
            } else {
                W8();
                return;
            }
        }
        if ((this.f35328e.get() || !this.f35331h) && (th2 = this.f35334k) != null) {
            dVar.onError(th2);
        } else {
            dVar.onComplete();
        }
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f35328e.compareAndSet(false, true)) {
            this.f35333j = true;
            W8();
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f35328e.compareAndSet(false, true)) {
            kj.a.Y(th2);
            return;
        }
        this.f35334k = th2;
        this.f35333j = true;
        W8();
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.f35328e.get()) {
            return;
        }
        if (this.f35336m == 0) {
            io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.f35332i.offer(t10)) {
                SubscriptionHelper.cancel(this.f35326c);
                onError(new MissingBackpressureException());
                return;
            }
        }
        W8();
    }

    @Override // bu.d
    public void onSubscribe(e eVar) {
        if (SubscriptionHelper.setOnce(this.f35326c, eVar)) {
            if (eVar instanceof l) {
                l lVar = (l) eVar;
                int iRequestFusion = lVar.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.f35336m = iRequestFusion;
                    this.f35332i = lVar;
                    this.f35333j = true;
                    W8();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.f35336m = iRequestFusion;
                    this.f35332i = lVar;
                    eVar.request(this.f35329f);
                    return;
                }
            }
            this.f35332i = new SpscArrayQueue(this.f35329f);
            eVar.request(this.f35329f);
        }
    }
}
