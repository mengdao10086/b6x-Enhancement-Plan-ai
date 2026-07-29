package io.reactivex.processors;

import bj.c;
import bj.e;
import bj.f;
import bu.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class AsyncProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AsyncSubscription[] f35308e = new AsyncSubscription[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AsyncSubscription[] f35309f = new AsyncSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<AsyncSubscription<T>[]> f35310b = new AtomicReference<>(f35308e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f35311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f35312d;

    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        public final AsyncProcessor<T> parent;

        public AsyncSubscription(d<? super T> dVar, AsyncProcessor<T> asyncProcessor) {
            super(dVar);
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            if (super.k()) {
                this.parent.X8(this);
            }
        }

        public void onComplete() {
            if (h()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            if (h()) {
                kj.a.Y(th2);
            } else {
                this.downstream.onError(th2);
            }
        }
    }

    @c
    @e
    public static <T> AsyncProcessor<T> S8() {
        return new AsyncProcessor<>();
    }

    @Override // io.reactivex.processors.a
    @f
    public Throwable M8() {
        if (this.f35310b.get() == f35309f) {
            return this.f35311c;
        }
        return null;
    }

    @Override // io.reactivex.processors.a
    public boolean N8() {
        return this.f35310b.get() == f35309f && this.f35311c == null;
    }

    @Override // io.reactivex.processors.a
    public boolean O8() {
        return this.f35310b.get().length != 0;
    }

    @Override // io.reactivex.processors.a
    public boolean P8() {
        return this.f35310b.get() == f35309f && this.f35311c != null;
    }

    public boolean R8(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription<T>[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.f35310b.get();
            if (asyncSubscriptionArr == f35309f) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[length + 1];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!this.f35310b.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    @f
    public T T8() {
        if (this.f35310b.get() == f35309f) {
            return this.f35312d;
        }
        return null;
    }

    @Deprecated
    public Object[] U8() {
        T tT8 = T8();
        return tT8 != null ? new Object[]{tT8} : new Object[0];
    }

    @Deprecated
    public T[] V8(T[] tArr) {
        T tT8 = T8();
        if (tT8 == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = tT8;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    public boolean W8() {
        return this.f35310b.get() == f35309f && this.f35312d != null;
    }

    public void X8(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription<T>[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.f35310b.get();
            int length = asyncSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (asyncSubscriptionArr[i11] == asyncSubscription) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                asyncSubscriptionArr2 = f35308e;
            } else {
                AsyncSubscription<T>[] asyncSubscriptionArr3 = new AsyncSubscription[length - 1];
                System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i10);
                System.arraycopy(asyncSubscriptionArr, i10 + 1, asyncSubscriptionArr3, i10, (length - i10) - 1);
                asyncSubscriptionArr2 = asyncSubscriptionArr3;
            }
        } while (!this.f35310b.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    @Override // xi.j
    public void k6(d<? super T> dVar) {
        AsyncSubscription<T> asyncSubscription = new AsyncSubscription<>(dVar, this);
        dVar.onSubscribe(asyncSubscription);
        if (R8(asyncSubscription)) {
            if (asyncSubscription.h()) {
                X8(asyncSubscription);
                return;
            }
            return;
        }
        Throwable th2 = this.f35311c;
        if (th2 != null) {
            dVar.onError(th2);
            return;
        }
        T t10 = this.f35312d;
        if (t10 != null) {
            asyncSubscription.c(t10);
        } else {
            asyncSubscription.onComplete();
        }
    }

    @Override // bu.d
    public void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f35310b.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f35309f;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            return;
        }
        T t10 = this.f35312d;
        AsyncSubscription<T>[] andSet = this.f35310b.getAndSet(asyncSubscriptionArr2);
        int i10 = 0;
        if (t10 == null) {
            int length = andSet.length;
            while (i10 < length) {
                andSet[i10].onComplete();
                i10++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i10 < length2) {
            andSet[i10].c(t10);
            i10++;
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f35310b.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f35309f;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            kj.a.Y(th2);
            return;
        }
        this.f35312d = null;
        this.f35311c = th2;
        for (AsyncSubscription<T> asyncSubscription : this.f35310b.getAndSet(asyncSubscriptionArr2)) {
            asyncSubscription.onError(th2);
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35310b.get() == f35309f) {
            return;
        }
        this.f35312d = t10;
    }

    @Override // bu.d
    public void onSubscribe(bu.e eVar) {
        if (this.f35310b.get() == f35309f) {
            eVar.cancel();
        } else {
            eVar.request(Long.MAX_VALUE);
        }
    }
}
