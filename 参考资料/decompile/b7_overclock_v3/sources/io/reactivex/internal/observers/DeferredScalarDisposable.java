package io.reactivex.internal.observers;

import bj.f;
import kj.a;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33022a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33023b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f33024c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f33025d = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f33026e = 32;
    private static final long serialVersionUID = -5502432239815349361L;
    public final g0<? super T> downstream;
    public T value;

    public DeferredScalarDisposable(g0<? super T> g0Var) {
        this.downstream = g0Var;
    }

    public final void a() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.downstream.onComplete();
    }

    public final void b(T t10) {
        int i10 = get();
        if ((i10 & 54) != 0) {
            return;
        }
        g0<? super T> g0Var = this.downstream;
        if (i10 == 8) {
            this.value = t10;
            lazySet(16);
            g0Var.onNext(null);
        } else {
            lazySet(2);
            g0Var.onNext(t10);
        }
        if (get() != 4) {
            g0Var.onComplete();
        }
    }

    public final boolean c() {
        return getAndSet(4) != 4;
    }

    @Override // fj.o
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void e(Throwable th2) {
        if ((get() & 54) != 0) {
            a.Y(th2);
        } else {
            lazySet(2);
            this.downstream.onError(th2);
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // fj.o
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // fj.o
    @f
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t10 = this.value;
        this.value = null;
        lazySet(32);
        return t10;
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
