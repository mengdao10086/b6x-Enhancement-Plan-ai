package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @bj.f
    public final bu.c<?>[] f33515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @bj.f
    public final Iterable<? extends bu.c<?>> f33516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.o<? super Object[], R> f33517e;

    public static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements fj.a<T>, bu.e {
        private static final long serialVersionUID = 1577321883966341961L;
        public final dj.o<? super Object[], R> combiner;
        public volatile boolean done;
        public final bu.d<? super R> downstream;
        public final AtomicThrowable error;
        public final AtomicLong requested;
        public final WithLatestInnerSubscriber[] subscribers;
        public final AtomicReference<bu.e> upstream;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromSubscriber(bu.d<? super R> dVar, dj.o<? super Object[], R> oVar, int i10) {
            this.downstream = dVar;
            this.combiner = oVar;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                withLatestInnerSubscriberArr[i11] = new WithLatestInnerSubscriber(this, i11);
            }
            this.subscribers = withLatestInnerSubscriberArr;
            this.values = new AtomicReferenceArray<>(i10);
            this.upstream = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        public void a(int i10) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            for (int i11 = 0; i11 < withLatestInnerSubscriberArr.length; i11++) {
                if (i11 != i10) {
                    withLatestInnerSubscriberArr[i11].a();
                }
            }
        }

        public void b(int i10, boolean z10) {
            if (z10) {
                return;
            }
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            a(i10);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        public void c(int i10, Throwable th2) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            a(i10);
            io.reactivex.internal.util.g.c(this.downstream, th2, this, this.error);
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            for (WithLatestInnerSubscriber withLatestInnerSubscriber : this.subscribers) {
                withLatestInnerSubscriber.a();
            }
        }

        public void d(int i10, Object obj) {
            this.values.set(i10, obj);
        }

        public void f(bu.c<?>[] cVarArr, int i10) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            AtomicReference<bu.e> atomicReference = this.upstream;
            for (int i11 = 0; i11 < i10 && atomicReference.get() != SubscriptionHelper.CANCELLED; i11++) {
                cVarArr[i11].d(withLatestInnerSubscriberArr[i11]);
            }
        }

        @Override // fj.a
        public boolean m(T t10) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t10;
            int i10 = 0;
            while (i10 < length) {
                Object obj = atomicReferenceArray.get(i10);
                if (obj == null) {
                    return false;
                }
                i10++;
                objArr[i10] = obj;
            }
            try {
                io.reactivex.internal.util.g.e(this.downstream, io.reactivex.internal.functions.a.g(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                onError(th2);
                return false;
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            a(-1);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            a(-1);
            io.reactivex.internal.util.g.c(this.downstream, th2, this, this.error);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (m(t10) || this.done) {
                return;
            }
            this.upstream.get().request(1L);
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

    public static final class WithLatestInnerSubscriber extends AtomicReference<bu.e> implements xi.o<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromSubscriber<?, ?> parent;

        public WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i10) {
            this.parent = withLatestFromSubscriber;
            this.index = i10;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        @Override // bu.d
        public void onComplete() {
            this.parent.b(this.index, this.hasValue);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.c(this.index, th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.d(this.index, obj);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public final class a implements dj.o<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // dj.o
        public R apply(T t10) throws Exception {
            return (R) io.reactivex.internal.functions.a.g(FlowableWithLatestFromMany.this.f33517e.apply(new Object[]{t10}), "The combiner returned a null value");
        }
    }

    public FlowableWithLatestFromMany(@bj.e xi.j<T> jVar, @bj.e bu.c<?>[] cVarArr, dj.o<? super Object[], R> oVar) {
        super(jVar);
        this.f33515c = cVarArr;
        this.f33516d = null;
        this.f33517e = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        int length;
        bu.c<?>[] cVarArr = this.f33515c;
        if (cVarArr == null) {
            cVarArr = new bu.c[8];
            try {
                length = 0;
                for (bu.c<?> cVar : this.f33516d) {
                    if (length == cVarArr.length) {
                        cVarArr = (bu.c[]) Arrays.copyOf(cVarArr, (length >> 1) + length);
                    }
                    int i10 = length + 1;
                    cVarArr[length] = cVar;
                    length = i10;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptySubscription.error(th2, dVar);
                return;
            }
        } else {
            length = cVarArr.length;
        }
        if (length == 0) {
            new p0(this.f33524b, new a()).k6(dVar);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(dVar, this.f33517e, length);
        dVar.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.f(cVarArr, length);
        this.f33524b.j6(withLatestFromSubscriber);
    }

    public FlowableWithLatestFromMany(@bj.e xi.j<T> jVar, @bj.e Iterable<? extends bu.c<?>> iterable, @bj.e dj.o<? super Object[], R> oVar) {
        super(jVar);
        this.f33515c = null;
        this.f33516d = iterable;
        this.f33517e = oVar;
    }
}
