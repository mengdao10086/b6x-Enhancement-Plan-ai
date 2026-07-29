package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableAmb<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<? extends T>[] f33157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterable<? extends bu.c<? extends T>> f33158c;

    public static final class AmbInnerSubscriber<T> extends AtomicReference<bu.e> implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -1185974347409665484L;
        public final bu.d<? super T> downstream;
        public final int index;
        public final AtomicLong missedRequested = new AtomicLong();
        public final a<T> parent;
        public boolean won;

        public AmbInnerSubscriber(a<T> aVar, int i10, bu.d<? super T> dVar) {
            this.parent = aVar;
            this.index = i10;
            this.downstream = dVar;
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // bu.d
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (!this.parent.b(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.won) {
                this.downstream.onError(th2);
            } else if (this.parent.b(this.index)) {
                this.won = true;
                this.downstream.onError(th2);
            } else {
                get().cancel();
                kj.a.Y(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.won) {
                this.downstream.onNext(t10);
            } else if (!this.parent.b(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onNext(t10);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, eVar);
        }

        @Override // bu.e
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j10);
        }
    }

    public static final class a<T> implements bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AmbInnerSubscriber<T>[] f33160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f33161c = new AtomicInteger();

        public a(bu.d<? super T> dVar, int i10) {
            this.f33159a = dVar;
            this.f33160b = new AmbInnerSubscriber[i10];
        }

        public void a(bu.c<? extends T>[] cVarArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.f33160b;
            int length = ambInnerSubscriberArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                ambInnerSubscriberArr[i10] = new AmbInnerSubscriber<>(this, i11, this.f33159a);
                i10 = i11;
            }
            this.f33161c.lazySet(0);
            this.f33159a.onSubscribe(this);
            for (int i12 = 0; i12 < length && this.f33161c.get() == 0; i12++) {
                cVarArr[i12].d(ambInnerSubscriberArr[i12]);
            }
        }

        public boolean b(int i10) {
            int i11 = 0;
            if (this.f33161c.get() != 0 || !this.f33161c.compareAndSet(0, i10)) {
                return false;
            }
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.f33160b;
            int length = ambInnerSubscriberArr.length;
            while (i11 < length) {
                int i12 = i11 + 1;
                if (i12 != i10) {
                    ambInnerSubscriberArr[i11].cancel();
                }
                i11 = i12;
            }
            return true;
        }

        @Override // bu.e
        public void cancel() {
            if (this.f33161c.get() != -1) {
                this.f33161c.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.f33160b) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                int i10 = this.f33161c.get();
                if (i10 > 0) {
                    this.f33160b[i10 - 1].request(j10);
                    return;
                }
                if (i10 == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.f33160b) {
                        ambInnerSubscriber.request(j10);
                    }
                }
            }
        }
    }

    public FlowableAmb(bu.c<? extends T>[] cVarArr, Iterable<? extends bu.c<? extends T>> iterable) {
        this.f33157b = cVarArr;
        this.f33158c = iterable;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        int length;
        bu.c<? extends T>[] cVarArr = this.f33157b;
        if (cVarArr == null) {
            cVarArr = new bu.c[8];
            try {
                length = 0;
                for (bu.c<? extends T> cVar : this.f33158c) {
                    if (cVar == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), dVar);
                        return;
                    }
                    if (length == cVarArr.length) {
                        bu.c<? extends T>[] cVarArr2 = new bu.c[(length >> 2) + length];
                        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                        cVarArr = cVarArr2;
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
            EmptySubscription.complete(dVar);
        } else if (length == 1) {
            cVarArr[0].d(dVar);
        } else {
            new a(dVar, length).a(cVarArr);
        }
    }
}
