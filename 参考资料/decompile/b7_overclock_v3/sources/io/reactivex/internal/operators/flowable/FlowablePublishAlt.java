package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowablePublishAlt<T> extends cj.a<T> implements fj.h<T>, ej.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<T> f33354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<PublishConnection<T>> f33356d = new AtomicReference<>();

    public static final class InnerSubscription<T> extends AtomicLong implements bu.e {
        private static final long serialVersionUID = 2845000326761540265L;
        public final bu.d<? super T> downstream;
        public long emitted;
        public final PublishConnection<T> parent;

        public InnerSubscription(bu.d<? super T> dVar, PublishConnection<T> publishConnection) {
            this.downstream = dVar;
            this.parent = publishConnection;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        @Override // bu.e
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.d(this);
                this.parent.c();
            }
        }

        @Override // bu.e
        public void request(long j10) {
            io.reactivex.internal.util.b.b(this, j10);
            this.parent.c();
        }
    }

    public static final class PublishConnection<T> extends AtomicInteger implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InnerSubscription[] f33357a = new InnerSubscription[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InnerSubscription[] f33358b = new InnerSubscription[0];
        private static final long serialVersionUID = -1672047311619175801L;
        public final int bufferSize;
        public int consumed;
        public final AtomicReference<PublishConnection<T>> current;
        public volatile boolean done;
        public Throwable error;
        public volatile fj.o<T> queue;
        public int sourceMode;
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicBoolean connect = new AtomicBoolean();
        public final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(f33357a);

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i10) {
            this.current = atomicReference;
            this.bufferSize = i10;
        }

        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == f33358b) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public boolean b(boolean z10, boolean z11) {
            if (!z10 || !z11) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                f(th2);
                return true;
            }
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f33358b)) {
                if (!innerSubscription.a()) {
                    innerSubscription.downstream.onComplete();
                }
            }
            return true;
        }

        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            fj.o<T> oVar = this.queue;
            int i10 = this.consumed;
            int i11 = this.bufferSize;
            int i12 = i11 - (i11 >> 2);
            boolean z10 = this.sourceMode != 1;
            int iAddAndGet = 1;
            fj.o<T> oVar2 = oVar;
            int i13 = i10;
            while (true) {
                if (oVar2 != null) {
                    long jMin = Long.MAX_VALUE;
                    InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                    boolean z11 = false;
                    for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                        long j10 = innerSubscription.get();
                        if (j10 != Long.MIN_VALUE) {
                            jMin = Math.min(j10 - innerSubscription.emitted, jMin);
                            z11 = true;
                        }
                    }
                    if (!z11) {
                        jMin = 0;
                    }
                    for (long j11 = 0; jMin != j11; j11 = 0) {
                        boolean z12 = this.done;
                        try {
                            T tPoll = oVar2.poll();
                            boolean z13 = tPoll == null;
                            if (b(z12, z13)) {
                                return;
                            }
                            if (z13) {
                                break;
                            }
                            for (InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                if (!innerSubscription2.a()) {
                                    innerSubscription2.downstream.onNext(tPoll);
                                    innerSubscription2.emitted++;
                                }
                            }
                            if (z10 && (i13 = i13 + 1) == i12) {
                                this.upstream.get().request(i12);
                                i13 = 0;
                            }
                            jMin--;
                            if (innerSubscriptionArr != this.subscribers.get()) {
                                break;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.upstream.get().cancel();
                            oVar2.clear();
                            this.done = true;
                            f(th2);
                            return;
                        }
                    }
                    if (b(this.done, oVar2.isEmpty())) {
                        return;
                    }
                }
                this.consumed = i13;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (oVar2 == null) {
                    oVar2 = this.queue;
                }
            }
        }

        public void d(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerSubscriptionArr[i11] == innerSubscription) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = f33357a;
                } else {
                    InnerSubscription<T>[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i10);
                    System.arraycopy(innerSubscriptionArr, i10 + 1, innerSubscriptionArr3, i10, (length - i10) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.subscribers.getAndSet(f33358b);
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        public void f(Throwable th2) {
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f33358b)) {
                if (!innerSubscription.a()) {
                    innerSubscription.downstream.onError(th2);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.subscribers.get() == f33358b;
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            c();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            c();
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
                        this.done = true;
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

    public FlowablePublishAlt(bu.c<T> cVar, int i10) {
        this.f33354b = cVar;
        this.f33355c = i10;
    }

    @Override // cj.a
    public void Q8(dj.g<? super io.reactivex.disposables.b> gVar) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f33356d.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f33356d, this.f33355c);
            if (this.f33356d.compareAndSet(publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z10 = !publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true);
        try {
            gVar.accept(publishConnection);
            if (z10) {
                this.f33354b.d(publishConnection);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    public int c() {
        return this.f33355c;
    }

    @Override // ej.c
    public void e(io.reactivex.disposables.b bVar) {
        this.f33356d.compareAndSet((PublishConnection) bVar, null);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f33356d.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f33356d, this.f33355c);
            if (this.f33356d.compareAndSet(publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerSubscription<T> innerSubscription = new InnerSubscription<>(dVar, publishConnection);
        dVar.onSubscribe(innerSubscription);
        if (publishConnection.a(innerSubscription)) {
            if (innerSubscription.a()) {
                publishConnection.d(innerSubscription);
                return;
            } else {
                publishConnection.c();
                return;
            }
        }
        Throwable th2 = publishConnection.error;
        if (th2 != null) {
            dVar.onError(th2);
        } else {
            dVar.onComplete();
        }
    }

    @Override // fj.h
    public bu.c<T> source() {
        return this.f33354b;
    }
}
