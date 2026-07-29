package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.c0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeZipArray<T, R> extends xi.q<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<? extends T>[] f33911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f33912b;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5556924161382950569L;
        public final xi.t<? super R> downstream;
        public final ZipMaybeObserver<T>[] observers;
        public final Object[] values;
        public final dj.o<? super Object[], ? extends R> zipper;

        public ZipCoordinator(xi.t<? super R> tVar, int i10, dj.o<? super Object[], ? extends R> oVar) {
            super(i10);
            this.downstream = tVar;
            this.zipper = oVar;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                zipMaybeObserverArr[i11] = new ZipMaybeObserver<>(this, i11);
            }
            this.observers = zipMaybeObserverArr;
            this.values = new Object[i10];
        }

        public void a(int i10) {
            ZipMaybeObserver<T>[] zipMaybeObserverArr = this.observers;
            int length = zipMaybeObserverArr.length;
            for (int i11 = 0; i11 < i10; i11++) {
                zipMaybeObserverArr[i11].a();
            }
            while (true) {
                i10++;
                if (i10 >= length) {
                    return;
                } else {
                    zipMaybeObserverArr[i10].a();
                }
            }
        }

        public void b(int i10) {
            if (getAndSet(0) > 0) {
                a(i10);
                this.downstream.onComplete();
            }
        }

        public void c(Throwable th2, int i10) {
            if (getAndSet(0) <= 0) {
                kj.a.Y(th2);
            } else {
                a(i10);
                this.downstream.onError(th2);
            }
        }

        public void d(T t10, int i10) {
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
                for (ZipMaybeObserver<T> zipMaybeObserver : this.observers) {
                    zipMaybeObserver.a();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    public static final class ZipMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        public final int index;
        public final ZipCoordinator<T, ?> parent;

        public ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i10) {
            this.parent = zipCoordinator;
            this.index = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.t
        public void onComplete() {
            this.parent.b(this.index);
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.parent.c(th2, this.index);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.parent.d(t10, this.index);
        }
    }

    public final class a implements dj.o<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // dj.o
        public R apply(T t10) throws Exception {
            return (R) io.reactivex.internal.functions.a.g(MaybeZipArray.this.f33912b.apply(new Object[]{t10}), "The zipper returned a null value");
        }
    }

    public MaybeZipArray(xi.w<? extends T>[] wVarArr, dj.o<? super Object[], ? extends R> oVar) {
        this.f33911a = wVarArr;
        this.f33912b = oVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        xi.w<? extends T>[] wVarArr = this.f33911a;
        int length = wVarArr.length;
        if (length == 1) {
            wVarArr[0].a(new c0.a(tVar, new a()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(tVar, length, this.f33912b);
        tVar.onSubscribe(zipCoordinator);
        for (int i10 = 0; i10 < length && !zipCoordinator.isDisposed(); i10++) {
            xi.w<? extends T> wVar = wVarArr[i10];
            if (wVar == null) {
                zipCoordinator.c(new NullPointerException("One of the sources is null"), i10);
                return;
            }
            wVar.a(zipCoordinator.observers[i10]);
        }
    }
}
