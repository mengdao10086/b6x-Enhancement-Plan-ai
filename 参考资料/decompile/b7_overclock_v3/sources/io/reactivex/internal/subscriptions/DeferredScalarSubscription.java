package io.reactivex.internal.subscriptions;

import bj.f;
import bu.d;

/* JADX INFO: loaded from: classes5.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35238a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f35239b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f35240c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f35241d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f35242e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f35243f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f35244g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f35245h = 32;
    private static final long serialVersionUID = -2151279923272604993L;
    public final d<? super T> downstream;
    public T value;

    public DeferredScalarSubscription(d<? super T> dVar) {
        this.downstream = dVar;
    }

    public final void c(T t10) {
        int i10 = get();
        while (i10 != 8) {
            if ((i10 & (-3)) != 0) {
                return;
            }
            if (i10 == 2) {
                lazySet(3);
                d<? super T> dVar = this.downstream;
                dVar.onNext(t10);
                if (get() != 4) {
                    dVar.onComplete();
                    return;
                }
                return;
            }
            this.value = t10;
            if (compareAndSet(0, 1)) {
                return;
            }
            i10 = get();
            if (i10 == 4) {
                this.value = null;
                return;
            }
        }
        this.value = t10;
        lazySet(16);
        d<? super T> dVar2 = this.downstream;
        dVar2.onNext(t10);
        if (get() != 4) {
            dVar2.onComplete();
        }
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // fj.o
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final boolean h() {
        return get() == 4;
    }

    @Override // fj.o
    public final boolean isEmpty() {
        return get() != 16;
    }

    public final boolean k() {
        return getAndSet(4) != 4;
    }

    @Override // fj.o
    @f
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t10 = this.value;
        this.value = null;
        return t10;
    }

    @Override // bu.e
    public final void request(long j10) {
        T t10;
        if (SubscriptionHelper.validate(j10)) {
            do {
                int i10 = get();
                if ((i10 & (-2)) != 0) {
                    return;
                }
                if (i10 == 1) {
                    if (!compareAndSet(1, 3) || (t10 = this.value) == null) {
                        return;
                    }
                    this.value = null;
                    d<? super T> dVar = this.downstream;
                    dVar.onNext(t10);
                    if (get() != 4) {
                        dVar.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // fj.k
    public final int requestFusion(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }
}
