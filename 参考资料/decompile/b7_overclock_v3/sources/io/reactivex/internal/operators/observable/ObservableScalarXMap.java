package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements fj.j<T>, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f34313a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f34314b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f34315c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f34316d = 3;
        private static final long serialVersionUID = 3880992722410194083L;
        public final xi.g0<? super T> observer;
        public final T value;

        public ScalarDisposable(xi.g0<? super T> g0Var, T t10) {
            this.observer = g0Var;
            this.value = t10;
        }

        @Override // fj.o
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // fj.o
        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        @Override // fj.o
        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public static final class a<T, R> extends xi.z<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f34317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.e0<? extends R>> f34318b;

        public a(T t10, dj.o<? super T, ? extends xi.e0<? extends R>> oVar) {
            this.f34317a = t10;
            this.f34318b = oVar;
        }

        @Override // xi.z
        public void I5(xi.g0<? super R> g0Var) {
            try {
                xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.f34318b.apply(this.f34317a), "The mapper returned a null ObservableSource");
                if (!(e0Var instanceof Callable)) {
                    e0Var.c(g0Var);
                    return;
                }
                try {
                    Object objCall = ((Callable) e0Var).call();
                    if (objCall == null) {
                        EmptyDisposable.complete(g0Var);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(g0Var, objCall);
                    g0Var.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    EmptyDisposable.error(th2, g0Var);
                }
            } catch (Throwable th3) {
                EmptyDisposable.error(th3, g0Var);
            }
        }
    }

    public ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> xi.z<U> a(T t10, dj.o<? super T, ? extends xi.e0<? extends U>> oVar) {
        return kj.a.U(new a(t10, oVar));
    }

    public static <T, R> boolean b(xi.e0<T> e0Var, xi.g0<? super R> g0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar) {
        if (!(e0Var instanceof Callable)) {
            return false;
        }
        try {
            a0.b bVar = (Object) ((Callable) e0Var).call();
            if (bVar == null) {
                EmptyDisposable.complete(g0Var);
                return true;
            }
            try {
                xi.e0 e0Var2 = (xi.e0) io.reactivex.internal.functions.a.g(oVar.apply(bVar), "The mapper returned a null ObservableSource");
                if (e0Var2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) e0Var2).call();
                        if (objCall == null) {
                            EmptyDisposable.complete(g0Var);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(g0Var, objCall);
                        g0Var.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        EmptyDisposable.error(th2, g0Var);
                        return true;
                    }
                } else {
                    e0Var2.c(g0Var);
                }
                return true;
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                EmptyDisposable.error(th3, g0Var);
                return true;
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            EmptyDisposable.error(th4, g0Var);
            return true;
        }
    }
}
