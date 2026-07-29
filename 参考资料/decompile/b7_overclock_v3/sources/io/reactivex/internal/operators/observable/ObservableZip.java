package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableZip<T, R> extends xi.z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T>[] f34411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends xi.e0<? extends T>> f34412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f34413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34415e;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2983708048395377667L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public final xi.g0<? super R> downstream;
        public final a<T, R>[] observers;
        public final T[] row;
        public final dj.o<? super Object[], ? extends R> zipper;

        public ZipCoordinator(xi.g0<? super R> g0Var, dj.o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
            this.downstream = g0Var;
            this.zipper = oVar;
            this.observers = new a[i10];
            this.row = (T[]) new Object[i10];
            this.delayError = z10;
        }

        public void a() {
            clear();
            b();
        }

        public void b() {
            for (a<T, R> aVar : this.observers) {
                aVar.a();
            }
        }

        public boolean c(boolean z10, boolean z11, xi.g0<? super R> g0Var, boolean z12, a<?, ?> aVar) {
            if (this.cancelled) {
                a();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (z12) {
                if (!z11) {
                    return false;
                }
                Throwable th2 = aVar.f34419d;
                this.cancelled = true;
                a();
                if (th2 != null) {
                    g0Var.onError(th2);
                } else {
                    g0Var.onComplete();
                }
                return true;
            }
            Throwable th3 = aVar.f34419d;
            if (th3 != null) {
                this.cancelled = true;
                a();
                g0Var.onError(th3);
                return true;
            }
            if (!z11) {
                return false;
            }
            this.cancelled = true;
            a();
            g0Var.onComplete();
            return true;
        }

        public void clear() {
            for (a<T, R> aVar : this.observers) {
                aVar.f34417b.clear();
            }
        }

        public void d() {
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            a<T, R>[] aVarArr = this.observers;
            xi.g0<? super R> g0Var = this.downstream;
            T[] tArr = this.row;
            boolean z10 = this.delayError;
            int iAddAndGet = 1;
            while (true) {
                int i10 = 0;
                int i11 = 0;
                for (a<T, R> aVar : aVarArr) {
                    if (tArr[i11] == null) {
                        boolean z11 = aVar.f34418c;
                        T tPoll = aVar.f34417b.poll();
                        boolean z12 = tPoll == null;
                        if (c(z11, z12, g0Var, z10, aVar)) {
                            return;
                        }
                        if (z12) {
                            i10++;
                        } else {
                            tArr[i11] = tPoll;
                        }
                    } else if (aVar.f34418c && !z10 && (th2 = aVar.f34419d) != null) {
                        this.cancelled = true;
                        a();
                        g0Var.onError(th2);
                        return;
                    }
                    i11++;
                }
                if (i10 != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        g0Var.onNext((Object) io.reactivex.internal.functions.a.g(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        a();
                        g0Var.onError(th3);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            b();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void f(xi.e0<? extends T>[] e0VarArr, int i10) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                aVarArr[i11] = new a<>(this, i10);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i12 = 0; i12 < length && !this.cancelled; i12++) {
                e0VarArr[i12].c(aVarArr[i12]);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class a<T, R> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ZipCoordinator<T, R> f34416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.internal.queue.a<T> f34417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f34418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f34419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f34420e = new AtomicReference<>();

        public a(ZipCoordinator<T, R> zipCoordinator, int i10) {
            this.f34416a = zipCoordinator;
            this.f34417b = new io.reactivex.internal.queue.a<>(i10);
        }

        public void a() {
            DisposableHelper.dispose(this.f34420e);
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34418c = true;
            this.f34416a.d();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34419d = th2;
            this.f34418c = true;
            this.f34416a.d();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34417b.offer(t10);
            this.f34416a.d();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.f34420e, bVar);
        }
    }

    public ObservableZip(xi.e0<? extends T>[] e0VarArr, Iterable<? extends xi.e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
        this.f34411a = e0VarArr;
        this.f34412b = iterable;
        this.f34413c = oVar;
        this.f34414d = i10;
        this.f34415e = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        int length;
        xi.e0<? extends T>[] e0VarArr = this.f34411a;
        if (e0VarArr == null) {
            e0VarArr = new xi.e0[8];
            length = 0;
            for (xi.e0<? extends T> e0Var : this.f34412b) {
                if (length == e0VarArr.length) {
                    xi.e0<? extends T>[] e0VarArr2 = new xi.e0[(length >> 2) + length];
                    System.arraycopy(e0VarArr, 0, e0VarArr2, 0, length);
                    e0VarArr = e0VarArr2;
                }
                e0VarArr[length] = e0Var;
                length++;
            }
        } else {
            length = e0VarArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(g0Var);
        } else {
            new ZipCoordinator(g0Var, this.f34413c, length, this.f34415e).f(e0VarArr, this.f34414d);
        }
    }
}
