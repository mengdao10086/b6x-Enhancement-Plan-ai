package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleZipArray<T, R> extends i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T>[] f34991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f34992b;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5556924161382950569L;
        public final l0<? super R> downstream;
        public final ZipSingleObserver<T>[] observers;
        public final Object[] values;
        public final dj.o<? super Object[], ? extends R> zipper;

        public ZipCoordinator(l0<? super R> l0Var, int i10, dj.o<? super Object[], ? extends R> oVar) {
            super(i10);
            this.downstream = l0Var;
            this.zipper = oVar;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                zipSingleObserverArr[i11] = new ZipSingleObserver<>(this, i11);
            }
            this.observers = zipSingleObserverArr;
            this.values = new Object[i10];
        }

        public void a(int i10) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i11 = 0; i11 < i10; i11++) {
                zipSingleObserverArr[i11].a();
            }
            while (true) {
                i10++;
                if (i10 >= length) {
                    return;
                } else {
                    zipSingleObserverArr[i10].a();
                }
            }
        }

        public void b(Throwable th2, int i10) {
            if (getAndSet(0) <= 0) {
                kj.a.Y(th2);
            } else {
                a(i10);
                this.downstream.onError(th2);
            }
        }

        public void c(T t10, int i10) {
            this.values[i10] = t10;
            if (decrementAndGet() == 0) {
                try {
                    this.downstream.onSuccess(io.reactivex.internal.functions.a.g(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.downstream.onError(th2);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> zipSingleObserver : this.observers) {
                    zipSingleObserver.a();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    public static final class ZipSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        public final int index;
        public final ZipCoordinator<T, ?> parent;

        public ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i10) {
            this.parent = zipCoordinator;
            this.index = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.parent.b(th2, this.index);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.parent.c(t10, this.index);
        }
    }

    public final class a implements dj.o<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // dj.o
        public R apply(T t10) throws Exception {
            return (R) io.reactivex.internal.functions.a.g(SingleZipArray.this.f34992b.apply(new Object[]{t10}), "The zipper returned a null value");
        }
    }

    public SingleZipArray(o0<? extends T>[] o0VarArr, dj.o<? super Object[], ? extends R> oVar) {
        this.f34991a = o0VarArr;
        this.f34992b = oVar;
    }

    @Override // xi.i0
    public void b1(l0<? super R> l0Var) {
        o0<? extends T>[] o0VarArr = this.f34991a;
        int length = o0VarArr.length;
        if (length == 1) {
            o0VarArr[0].a(new v.a(l0Var, new a()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(l0Var, length, this.f34992b);
        l0Var.onSubscribe(zipCoordinator);
        for (int i10 = 0; i10 < length && !zipCoordinator.isDisposed(); i10++) {
            o0<? extends T> o0Var = o0VarArr[i10];
            if (o0Var == null) {
                zipCoordinator.b(new NullPointerException("One of the sources is null"), i10);
                return;
            }
            o0Var.a(zipCoordinator.observers[i10]);
        }
    }
}
