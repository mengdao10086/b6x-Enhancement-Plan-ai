package io.reactivex.subjects;

import bj.e;
import bj.f;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class AsyncSubject<T> extends c<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AsyncDisposable[] f35381d = new AsyncDisposable[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AsyncDisposable[] f35382e = new AsyncDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<AsyncDisposable<T>[]> f35383a = new AtomicReference<>(f35381d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f35384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f35385c;

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        public final AsyncSubject<T> parent;

        public AsyncDisposable(g0<? super T> g0Var, AsyncSubject<T> asyncSubject) {
            super(g0Var);
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            if (super.c()) {
                this.parent.t8(this);
            }
        }

        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            if (isDisposed()) {
                kj.a.Y(th2);
            } else {
                this.downstream.onError(th2);
            }
        }
    }

    @bj.c
    @e
    public static <T> AsyncSubject<T> o8() {
        return new AsyncSubject<>();
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        AsyncDisposable<T> asyncDisposable = new AsyncDisposable<>(g0Var, this);
        g0Var.onSubscribe(asyncDisposable);
        if (n8(asyncDisposable)) {
            if (asyncDisposable.isDisposed()) {
                t8(asyncDisposable);
                return;
            }
            return;
        }
        Throwable th2 = this.f35384b;
        if (th2 != null) {
            g0Var.onError(th2);
            return;
        }
        T t10 = this.f35385c;
        if (t10 != null) {
            asyncDisposable.b(t10);
        } else {
            asyncDisposable.onComplete();
        }
    }

    @Override // io.reactivex.subjects.c
    public Throwable i8() {
        if (this.f35383a.get() == f35382e) {
            return this.f35384b;
        }
        return null;
    }

    @Override // io.reactivex.subjects.c
    public boolean j8() {
        return this.f35383a.get() == f35382e && this.f35384b == null;
    }

    @Override // io.reactivex.subjects.c
    public boolean k8() {
        return this.f35383a.get().length != 0;
    }

    @Override // io.reactivex.subjects.c
    public boolean l8() {
        return this.f35383a.get() == f35382e && this.f35384b != null;
    }

    public boolean n8(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.f35383a.get();
            if (asyncDisposableArr == f35382e) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[length + 1];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!this.f35383a.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    @Override // xi.g0
    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.f35383a.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f35382e;
        if (asyncDisposableArr == asyncDisposableArr2) {
            return;
        }
        T t10 = this.f35385c;
        AsyncDisposable<T>[] andSet = this.f35383a.getAndSet(asyncDisposableArr2);
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
            andSet[i10].b(t10);
            i10++;
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] asyncDisposableArr = this.f35383a.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f35382e;
        if (asyncDisposableArr == asyncDisposableArr2) {
            kj.a.Y(th2);
            return;
        }
        this.f35385c = null;
        this.f35384b = th2;
        for (AsyncDisposable<T> asyncDisposable : this.f35383a.getAndSet(asyncDisposableArr2)) {
            asyncDisposable.onError(th2);
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35383a.get() == f35382e) {
            return;
        }
        this.f35385c = t10;
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f35383a.get() == f35382e) {
            bVar.dispose();
        }
    }

    @f
    public T p8() {
        if (this.f35383a.get() == f35382e) {
            return this.f35385c;
        }
        return null;
    }

    @Deprecated
    public Object[] q8() {
        T tP8 = p8();
        return tP8 != null ? new Object[]{tP8} : new Object[0];
    }

    @Deprecated
    public T[] r8(T[] tArr) {
        T tP8 = p8();
        if (tP8 == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = tP8;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    public boolean s8() {
        return this.f35383a.get() == f35382e && this.f35385c != null;
    }

    public void t8(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.f35383a.get();
            int length = asyncDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (asyncDisposableArr[i11] == asyncDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                asyncDisposableArr2 = f35381d;
            } else {
                AsyncDisposable<T>[] asyncDisposableArr3 = new AsyncDisposable[length - 1];
                System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i10);
                System.arraycopy(asyncDisposableArr, i10 + 1, asyncDisposableArr3, i10, (length - i10) - 1);
                asyncDisposableArr2 = asyncDisposableArr3;
            }
        } while (!this.f35383a.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
    }
}
