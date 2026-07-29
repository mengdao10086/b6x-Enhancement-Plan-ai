package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeCache<T> extends xi.q<T> implements xi.t<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CacheDisposable[] f33826e = new CacheDisposable[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CacheDisposable[] f33827f = new CacheDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<xi.w<T>> f33828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f33829b = new AtomicReference<>(f33826e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f33830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f33831d;

    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5791853038359966195L;
        public final xi.t<? super T> downstream;

        public CacheDisposable(xi.t<? super T> tVar, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.downstream = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.f2(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public MaybeCache(xi.w<T> wVar) {
        this.f33828a = new AtomicReference<>(wVar);
    }

    public boolean e2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f33829b.get();
            if (cacheDisposableArr == f33827f) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f33829b.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void f2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f33829b.get();
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
                cacheDisposableArr2 = f33826e;
            } else {
                CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i10);
                System.arraycopy(cacheDisposableArr, i10 + 1, cacheDisposableArr3, i10, (length - i10) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.f33829b.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // xi.t
    public void onComplete() {
        for (CacheDisposable<T> cacheDisposable : this.f33829b.getAndSet(f33827f)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
        }
    }

    @Override // xi.t
    public void onError(Throwable th2) {
        this.f33831d = th2;
        for (CacheDisposable<T> cacheDisposable : this.f33829b.getAndSet(f33827f)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th2);
            }
        }
    }

    @Override // xi.t
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }

    @Override // xi.t
    public void onSuccess(T t10) {
        this.f33830c = t10;
        for (CacheDisposable<T> cacheDisposable : this.f33829b.getAndSet(f33827f)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t10);
            }
        }
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(tVar, this);
        tVar.onSubscribe(cacheDisposable);
        if (e2(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                f2(cacheDisposable);
                return;
            }
            xi.w<T> andSet = this.f33828a.getAndSet(null);
            if (andSet != null) {
                andSet.a(this);
                return;
            }
            return;
        }
        if (cacheDisposable.isDisposed()) {
            return;
        }
        Throwable th2 = this.f33831d;
        if (th2 != null) {
            tVar.onError(th2);
            return;
        }
        T t10 = this.f33830c;
        if (t10 != null) {
            tVar.onSuccess(t10);
        } else {
            tVar.onComplete();
        }
    }
}
