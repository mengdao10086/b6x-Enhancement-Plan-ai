package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableCombineLatest<T, R> extends xi.z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T>[] f34139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends xi.e0<? extends T>> f34140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f34141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34143e;

    public static final class CombinerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        public final int index;
        public final LatestCoordinator<T, R> parent;

        public CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i10) {
            this.parent = latestCoordinator;
            this.index = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.g0
        public void onComplete() {
            this.parent.d(this.index);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.parent.f(this.index, th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.parent.h(this.index, t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public volatile boolean cancelled;
        public final dj.o<? super Object[], ? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final xi.g0<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public Object[] latest;
        public final CombinerObserver<T, R>[] observers;
        public final io.reactivex.internal.queue.a<Object[]> queue;

        public LatestCoordinator(xi.g0<? super R> g0Var, dj.o<? super Object[], ? extends R> oVar, int i10, int i11, boolean z10) {
            this.downstream = g0Var;
            this.combiner = oVar;
            this.delayError = z10;
            this.latest = new Object[i10];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                combinerObserverArr[i12] = new CombinerObserver<>(this, i12);
            }
            this.observers = combinerObserverArr;
            this.queue = new io.reactivex.internal.queue.a<>(i11);
        }

        public void a() {
            for (CombinerObserver<T, R> combinerObserver : this.observers) {
                combinerObserver.a();
            }
        }

        public void b(io.reactivex.internal.queue.a<?> aVar) {
            synchronized (this) {
                this.latest = null;
            }
            aVar.clear();
        }

        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.a<Object[]> aVar = this.queue;
            xi.g0<? super R> g0Var = this.downstream;
            boolean z10 = this.delayError;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!z10 && this.errors.get() != null) {
                    a();
                    b(aVar);
                    g0Var.onError(this.errors.c());
                    return;
                }
                boolean z11 = this.done;
                Object[] objArrPoll = aVar.poll();
                boolean z12 = objArrPoll == null;
                if (z11 && z12) {
                    b(aVar);
                    Throwable thC = this.errors.c();
                    if (thC == null) {
                        g0Var.onComplete();
                        return;
                    } else {
                        g0Var.onError(thC);
                        return;
                    }
                }
                if (z12) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        g0Var.onNext((Object) io.reactivex.internal.functions.a.g(this.combiner.apply(objArrPoll), "The combiner returned a null value"));
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.errors.a(th2);
                        a();
                        b(aVar);
                        g0Var.onError(this.errors.c());
                        return;
                    }
                }
            }
            b(aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0019 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0007, B:12:0x0011, B:15:0x001b, B:14:0x0019), top: B:23:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void d(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = 1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.complete     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.complete = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.done = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.a()
            L21:
                r3.c()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.d(int):void");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            a();
            if (getAndIncrement() == 0) {
                b(this.queue);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0025 A[Catch: all -> 0x002a, TryCatch #0 {, blocks: (B:7:0x000e, B:9:0x0012, B:11:0x0014, B:16:0x001d, B:19:0x0027, B:18:0x0025), top: B:29:0x000e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.errors
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L2d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch: java.lang.Throwable -> L2a
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L2a
                if (r3 != 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.complete     // Catch: java.lang.Throwable -> L2a
                int r1 = r1 + r0
                r2.complete = r1     // Catch: java.lang.Throwable -> L2a
                int r4 = r4.length     // Catch: java.lang.Throwable -> L2a
                if (r1 != r4) goto L27
            L25:
                r2.done = r0     // Catch: java.lang.Throwable -> L2a
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                r0 = r3
                goto L2d
            L2a:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                throw r3
            L2d:
                if (r0 == 0) goto L32
                r2.a()
            L32:
                r2.c()
                goto L39
            L36:
                kj.a.Y(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.f(int, java.lang.Throwable):void");
        }

        public void h(int i10, T t10) {
            boolean z10;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i10];
                int i11 = this.active;
                if (obj == null) {
                    i11++;
                    this.active = i11;
                }
                objArr[i10] = t10;
                if (i11 == objArr.length) {
                    this.queue.offer((Object[]) objArr.clone());
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    c();
                }
            }
        }

        public void i(xi.e0<? extends T>[] e0VarArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.downstream.onSubscribe(this);
            for (int i10 = 0; i10 < length && !this.done && !this.cancelled; i10++) {
                e0VarArr[i10].c(combinerObserverArr[i10]);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public ObservableCombineLatest(xi.e0<? extends T>[] e0VarArr, Iterable<? extends xi.e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
        this.f34139a = e0VarArr;
        this.f34140b = iterable;
        this.f34141c = oVar;
        this.f34142d = i10;
        this.f34143e = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        int length;
        xi.e0<? extends T>[] e0VarArr = this.f34139a;
        if (e0VarArr == null) {
            e0VarArr = new xi.e0[8];
            length = 0;
            for (xi.e0<? extends T> e0Var : this.f34140b) {
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
        int i10 = length;
        if (i10 == 0) {
            EmptyDisposable.complete(g0Var);
        } else {
            new LatestCoordinator(g0Var, this.f34141c, i10, this.f34142d, this.f34143e).i(e0VarArr);
        }
    }
}
