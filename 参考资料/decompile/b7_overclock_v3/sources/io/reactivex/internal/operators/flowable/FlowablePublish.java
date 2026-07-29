package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowablePublish<T> extends cj.a<T> implements fj.h<T>, s0<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f33345f = Long.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.j<T> f33346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<PublishSubscriber<T>> f33347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bu.c<T> f33349e;

    public static final class InnerSubscriber<T> extends AtomicLong implements bu.e {
        private static final long serialVersionUID = -4453897557930727610L;
        public final bu.d<? super T> child;
        public long emitted;
        public volatile PublishSubscriber<T> parent;

        public InnerSubscriber(bu.d<? super T> dVar) {
            this.child = dVar;
        }

        @Override // bu.e
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (publishSubscriber = this.parent) == null) {
                return;
            }
            publishSubscriber.d(this);
            publishSubscriber.c();
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.b(this, j10);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.c();
                }
            }
        }
    }

    public static final class PublishSubscriber<T> extends AtomicInteger implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InnerSubscriber[] f33350a = new InnerSubscriber[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InnerSubscriber[] f33351b = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        public final int bufferSize;
        public final AtomicReference<PublishSubscriber<T>> current;
        public volatile fj.o<T> queue;
        public int sourceMode;
        public volatile Object terminalEvent;
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(f33350a);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i10) {
            this.current = atomicReference;
            this.bufferSize = i10;
        }

        public boolean a(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber<T>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == f33351b) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        public boolean b(Object obj, boolean z10) {
            int i10 = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet = this.subscribers.getAndSet(f33351b);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i10 < length) {
                            andSet[i10].child.onError(error);
                            i10++;
                        }
                    } else {
                        kj.a.Y(error);
                    }
                    return true;
                }
                if (z10) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet2 = this.subscribers.getAndSet(f33351b);
                    int length2 = andSet2.length;
                    while (i10 < length2) {
                        andSet2[i10].child.onComplete();
                        i10++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:72:0x011f, code lost:
        
            if (r11 == 0) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0124, code lost:
        
            if (r25.sourceMode == 1) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0126, code lost:
        
            r25.upstream.get().request(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0132, code lost:
        
            r4 = r0;
            r3 = 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c() {
            /*
                Method dump skipped, instruction units count: 357
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.c():void");
        }

        public void d(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber<T>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i11].equals(innerSubscriber)) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = f33350a;
                } else {
                    InnerSubscriber<T>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i10);
                    System.arraycopy(innerSubscriberArr, i10 + 1, innerSubscriberArr3, i10, (length - i10) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = f33351b;
            if (innerSubscriberArr == innerSubscriberArr2 || this.subscribers.getAndSet(innerSubscriberArr2) == innerSubscriberArr2) {
                return;
            }
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.subscribers.get() == f33351b;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                c();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.terminalEvent != null) {
                kj.a.Y(th2);
            } else {
                this.terminalEvent = NotificationLite.error(th2);
                c();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.sourceMode != 0 || this.queue.offer(t10)) {
                c();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this.upstream, eVar)) {
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.terminalEvent = NotificationLite.complete();
                        c();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
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

    public static final class a<T> implements bu.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<PublishSubscriber<T>> f33352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33353b;

        public a(AtomicReference<PublishSubscriber<T>> atomicReference, int i10) {
            this.f33352a = atomicReference;
            this.f33353b = i10;
        }

        @Override // bu.c
        public void d(bu.d<? super T> dVar) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber<T> innerSubscriber = new InnerSubscriber<>(dVar);
            dVar.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.f33352a.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f33352a, this.f33353b);
                    if (this.f33352a.compareAndSet(publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    } else {
                        continue;
                    }
                }
                if (publishSubscriber.a(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.d(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.c();
        }
    }

    public FlowablePublish(bu.c<T> cVar, xi.j<T> jVar, AtomicReference<PublishSubscriber<T>> atomicReference, int i10) {
        this.f33349e = cVar;
        this.f33346b = jVar;
        this.f33347c = atomicReference;
        this.f33348d = i10;
    }

    public static <T> cj.a<T> Y8(xi.j<T> jVar, int i10) {
        AtomicReference atomicReference = new AtomicReference();
        return kj.a.O(new FlowablePublish(new a(atomicReference, i10), jVar, atomicReference, i10));
    }

    @Override // cj.a
    public void Q8(dj.g<? super io.reactivex.disposables.b> gVar) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.f33347c.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f33347c, this.f33348d);
            if (this.f33347c.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z10 = !publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(publishSubscriber);
            if (z10) {
                this.f33346b.j6(publishSubscriber);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.s0
    public bu.c<T> b() {
        return this.f33346b;
    }

    @Override // io.reactivex.internal.operators.flowable.s0
    public int c() {
        return this.f33348d;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33349e.d(dVar);
    }

    @Override // fj.h
    public bu.c<T> source() {
        return this.f33346b;
    }
}
