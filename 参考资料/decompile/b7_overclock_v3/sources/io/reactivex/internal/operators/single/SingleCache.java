package io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleCache<T> extends i0<T> implements l0<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CacheDisposable[] f34926f = new CacheDisposable[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CacheDisposable[] f34927g = new CacheDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f34928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f34929b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f34930c = new AtomicReference<>(f34926f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f34931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f34932e;

    public static final class CacheDisposable<T> extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 7514387411091976596L;
        public final l0<? super T> downstream;
        public final SingleCache<T> parent;

        public CacheDisposable(l0<? super T> l0Var, SingleCache<T> singleCache) {
            this.downstream = l0Var;
            this.parent = singleCache;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.O1(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(o0<? extends T> o0Var) {
        this.f34928a = o0Var;
    }

    public boolean N1(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f34930c.get();
            if (cacheDisposableArr == f34927g) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f34930c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void O1(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f34930c.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (cacheDisposableArr[i11] == cacheDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = f34926f;
            } else {
                CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i10);
                System.arraycopy(cacheDisposableArr, i10 + 1, cacheDisposableArr3, i10, (length - i10) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.f34930c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(l0Var, this);
        l0Var.onSubscribe(cacheDisposable);
        if (N1(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                O1(cacheDisposable);
            }
            if (this.f34929b.getAndIncrement() == 0) {
                this.f34928a.a(this);
                return;
            }
            return;
        }
        Throwable th2 = this.f34932e;
        if (th2 != null) {
            l0Var.onError(th2);
        } else {
            l0Var.onSuccess(this.f34931d);
        }
    }

    @Override // xi.l0
    public void onError(Throwable th2) {
        this.f34932e = th2;
        for (CacheDisposable<T> cacheDisposable : this.f34930c.getAndSet(f34927g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th2);
            }
        }
    }

    @Override // xi.l0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }

    @Override // xi.l0
    public void onSuccess(T t10) {
        this.f34931d = t10;
        for (CacheDisposable<T> cacheDisposable : this.f34930c.getAndSet(f34927g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t10);
            }
        }
    }
}
