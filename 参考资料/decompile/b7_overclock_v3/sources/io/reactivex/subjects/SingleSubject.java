package io.reactivex.subjects;

import bj.e;
import bj.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleSubject<T> extends i0<T> implements l0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SingleDisposable[] f35407e = new SingleDisposable[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SingleDisposable[] f35408f = new SingleDisposable[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f35411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f35412d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f35410b = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<SingleDisposable<T>[]> f35409a = new AtomicReference<>(f35407e);

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        public final l0<? super T> downstream;

        public SingleDisposable(l0<? super T> l0Var, SingleSubject<T> singleSubject) {
            this.downstream = l0Var;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SingleSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.V1(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @bj.c
    @e
    public static <T> SingleSubject<T> O1() {
        return new SingleSubject<>();
    }

    public boolean N1(@e SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.f35409a.get();
            if (singleDisposableArr == f35408f) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[length + 1];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.f35409a.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    @f
    public Throwable P1() {
        if (this.f35409a.get() == f35408f) {
            return this.f35412d;
        }
        return null;
    }

    @f
    public T Q1() {
        if (this.f35409a.get() == f35408f) {
            return this.f35411c;
        }
        return null;
    }

    public boolean R1() {
        return this.f35409a.get().length != 0;
    }

    public boolean S1() {
        return this.f35409a.get() == f35408f && this.f35412d != null;
    }

    public boolean T1() {
        return this.f35409a.get() == f35408f && this.f35411c != null;
    }

    public int U1() {
        return this.f35409a.get().length;
    }

    public void V1(@e SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.f35409a.get();
            int length = singleDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (singleDisposableArr[i11] == singleDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                singleDisposableArr2 = f35407e;
            } else {
                SingleDisposable<T>[] singleDisposableArr3 = new SingleDisposable[length - 1];
                System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i10);
                System.arraycopy(singleDisposableArr, i10 + 1, singleDisposableArr3, i10, (length - i10) - 1);
                singleDisposableArr2 = singleDisposableArr3;
            }
        } while (!this.f35409a.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    @Override // xi.i0
    public void b1(@e l0<? super T> l0Var) {
        SingleDisposable<T> singleDisposable = new SingleDisposable<>(l0Var, this);
        l0Var.onSubscribe(singleDisposable);
        if (N1(singleDisposable)) {
            if (singleDisposable.isDisposed()) {
                V1(singleDisposable);
            }
        } else {
            Throwable th2 = this.f35412d;
            if (th2 != null) {
                l0Var.onError(th2);
            } else {
                l0Var.onSuccess(this.f35411c);
            }
        }
    }

    @Override // xi.l0
    public void onError(@e Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f35410b.compareAndSet(false, true)) {
            kj.a.Y(th2);
            return;
        }
        this.f35412d = th2;
        for (SingleDisposable<T> singleDisposable : this.f35409a.getAndSet(f35408f)) {
            singleDisposable.downstream.onError(th2);
        }
    }

    @Override // xi.l0
    public void onSubscribe(@e io.reactivex.disposables.b bVar) {
        if (this.f35409a.get() == f35408f) {
            bVar.dispose();
        }
    }

    @Override // xi.l0
    public void onSuccess(@e T t10) {
        io.reactivex.internal.functions.a.g(t10, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35410b.compareAndSet(false, true)) {
            this.f35411c = t10;
            for (SingleDisposable<T> singleDisposable : this.f35409a.getAndSet(f35408f)) {
                singleDisposable.downstream.onSuccess(t10);
            }
        }
    }
}
