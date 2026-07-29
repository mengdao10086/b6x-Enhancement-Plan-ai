package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @bj.f
    public final xi.e0<?>[] f34407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @bj.f
    public final Iterable<? extends xi.e0<?>> f34408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @bj.e
    public final dj.o<? super Object[], R> f34409d;

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1577321883966341961L;
        public final dj.o<? super Object[], R> combiner;
        public volatile boolean done;
        public final xi.g0<? super R> downstream;
        public final AtomicThrowable error;
        public final WithLatestInnerObserver[] observers;
        public final AtomicReference<io.reactivex.disposables.b> upstream;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromObserver(xi.g0<? super R> g0Var, dj.o<? super Object[], R> oVar, int i10) {
            this.downstream = g0Var;
            this.combiner = oVar;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                withLatestInnerObserverArr[i11] = new WithLatestInnerObserver(this, i11);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i10);
            this.upstream = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        public void a(int i10) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i11 = 0; i11 < withLatestInnerObserverArr.length; i11++) {
                if (i11 != i10) {
                    withLatestInnerObserverArr[i11].a();
                }
            }
        }

        public void b(int i10, boolean z10) {
            if (z10) {
                return;
            }
            this.done = true;
            a(i10);
            io.reactivex.internal.util.g.b(this.downstream, this, this.error);
        }

        public void c(int i10, Throwable th2) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            a(i10);
            io.reactivex.internal.util.g.d(this.downstream, th2, this, this.error);
        }

        public void d(int i10, Object obj) {
            this.values.set(i10, obj);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.a();
            }
        }

        public void f(xi.e0<?>[] e0VarArr, int i10) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<io.reactivex.disposables.b> atomicReference = this.upstream;
            for (int i11 = 0; i11 < i10 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i11++) {
                e0VarArr[i11].c(withLatestInnerObserverArr[i11]);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            a(-1);
            io.reactivex.internal.util.g.b(this.downstream, this, this.error);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            a(-1);
            io.reactivex.internal.util.g.d(this.downstream, th2, this, this.error);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i10 = 0;
            objArr[0] = t10;
            while (i10 < length) {
                Object obj = atomicReferenceArray.get(i10);
                if (obj == null) {
                    return;
                }
                i10++;
                objArr[i10] = obj;
            }
            try {
                io.reactivex.internal.util.g.f(this.downstream, io.reactivex.internal.functions.a.g(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromObserver<?, ?> parent;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i10) {
            this.parent = withLatestFromObserver;
            this.index = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.g0
        public void onComplete() {
            this.parent.b(this.index, this.hasValue);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.parent.c(this.index, th2);
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.d(this.index, obj);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public final class a implements dj.o<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // dj.o
        public R apply(T t10) throws Exception {
            return (R) io.reactivex.internal.functions.a.g(ObservableWithLatestFromMany.this.f34409d.apply(new Object[]{t10}), "The combiner returned a null value");
        }
    }

    public ObservableWithLatestFromMany(@bj.e xi.e0<T> e0Var, @bj.e xi.e0<?>[] e0VarArr, @bj.e dj.o<? super Object[], R> oVar) {
        super(e0Var);
        this.f34407b = e0VarArr;
        this.f34408c = null;
        this.f34409d = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        int length;
        xi.e0<?>[] e0VarArr = this.f34407b;
        if (e0VarArr == null) {
            e0VarArr = new xi.e0[8];
            try {
                length = 0;
                for (xi.e0<?> e0Var : this.f34408c) {
                    if (length == e0VarArr.length) {
                        e0VarArr = (xi.e0[]) Arrays.copyOf(e0VarArr, (length >> 1) + length);
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
            new x0(this.f34421a, new a()).I5(g0Var);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(g0Var, this.f34409d, length);
        g0Var.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.f(e0VarArr, length);
        this.f34421a.c(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(@bj.e xi.e0<T> e0Var, @bj.e Iterable<? extends xi.e0<?>> iterable, @bj.e dj.o<? super Object[], R> oVar) {
        super(e0Var);
        this.f34407b = null;
        this.f34408c = iterable;
        this.f34409d = oVar;
    }
}
