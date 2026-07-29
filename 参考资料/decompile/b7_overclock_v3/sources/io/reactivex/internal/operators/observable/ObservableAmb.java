package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableAmb<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T>[] f34109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends xi.e0<? extends T>> f34110b;

    public static final class AmbInnerObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        public final xi.g0<? super T> downstream;
        public final int index;
        public final a<T> parent;
        public boolean won;

        public AmbInnerObserver(a<T> aVar, int i10, xi.g0<? super T> g0Var) {
            this.parent = aVar;
            this.index = i10;
            this.downstream = g0Var;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.b(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.won) {
                this.downstream.onError(th2);
            } else if (!this.parent.b(this.index)) {
                kj.a.Y(th2);
            } else {
                this.won = true;
                this.downstream.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.won) {
                this.downstream.onNext(t10);
            } else if (!this.parent.b(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.downstream.onNext(t10);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class a<T> implements io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AmbInnerObserver<T>[] f34112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f34113c = new AtomicInteger();

        public a(xi.g0<? super T> g0Var, int i10) {
            this.f34111a = g0Var;
            this.f34112b = new AmbInnerObserver[i10];
        }

        public void a(xi.e0<? extends T>[] e0VarArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f34112b;
            int length = ambInnerObserverArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                ambInnerObserverArr[i10] = new AmbInnerObserver<>(this, i11, this.f34111a);
                i10 = i11;
            }
            this.f34113c.lazySet(0);
            this.f34111a.onSubscribe(this);
            for (int i12 = 0; i12 < length && this.f34113c.get() == 0; i12++) {
                e0VarArr[i12].c(ambInnerObserverArr[i12]);
            }
        }

        public boolean b(int i10) {
            int i11 = this.f34113c.get();
            int i12 = 0;
            if (i11 != 0) {
                return i11 == i10;
            }
            if (!this.f34113c.compareAndSet(0, i10)) {
                return false;
            }
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f34112b;
            int length = ambInnerObserverArr.length;
            while (i12 < length) {
                int i13 = i12 + 1;
                if (i13 != i10) {
                    ambInnerObserverArr[i12].a();
                }
                i12 = i13;
            }
            return true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f34113c.get() != -1) {
                this.f34113c.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.f34112b) {
                    ambInnerObserver.a();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34113c.get() == -1;
        }
    }

    public ObservableAmb(xi.e0<? extends T>[] e0VarArr, Iterable<? extends xi.e0<? extends T>> iterable) {
        this.f34109a = e0VarArr;
        this.f34110b = iterable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        int length;
        xi.e0<? extends T>[] e0VarArr = this.f34109a;
        if (e0VarArr == null) {
            e0VarArr = new xi.e0[8];
            try {
                length = 0;
                for (xi.e0<? extends T> e0Var : this.f34110b) {
                    if (e0Var == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), g0Var);
                        return;
                    }
                    if (length == e0VarArr.length) {
                        xi.e0<? extends T>[] e0VarArr2 = new xi.e0[(length >> 2) + length];
                        System.arraycopy(e0VarArr, 0, e0VarArr2, 0, length);
                        e0VarArr = e0VarArr2;
                    }
                    int i10 = length + 1;
                    e0VarArr[length] = e0Var;
                    length = i10;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, g0Var);
                return;
            }
        } else {
            length = e0VarArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(g0Var);
        } else if (length == 1) {
            e0VarArr[0].c(g0Var);
        } else {
            new a(g0Var, length).a(e0VarArr);
        }
    }
}
