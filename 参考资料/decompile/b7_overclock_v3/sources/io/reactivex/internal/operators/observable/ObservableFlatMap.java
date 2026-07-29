package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.e0<? extends U>> f34168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34171e;

    public static final class InnerObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        public volatile boolean done;
        public int fusionMode;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final long f34172id;
        public final MergeObserver<T, U> parent;
        public volatile fj.o<U> queue;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j10) {
            this.f34172id = j10;
            this.parent = mergeObserver;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            this.parent.d();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.parent.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            MergeObserver<T, U> mergeObserver = this.parent;
            if (!mergeObserver.delayErrors) {
                mergeObserver.c();
            }
            this.done = true;
            this.parent.d();
        }

        @Override // xi.g0
        public void onNext(U u6) {
            if (this.fusionMode == 0) {
                this.parent.l(u6, this);
            } else {
                this.parent.d();
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof fj.j)) {
                fj.j jVar = (fj.j) bVar;
                int iRequestFusion = jVar.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                    this.done = true;
                    this.parent.d();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                }
            }
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InnerObserver<?, ?>[] f34173a = new InnerObserver[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InnerObserver<?, ?>[] f34174b = new InnerObserver[0];
        private static final long serialVersionUID = -2117620485640801370L;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final xi.g0<? super U> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public long lastId;
        public int lastIndex;
        public final dj.o<? super T, ? extends xi.e0<? extends U>> mapper;
        public final int maxConcurrency;
        public final AtomicReference<InnerObserver<?, ?>[]> observers;
        public volatile fj.n<U> queue;
        public Queue<xi.e0<? extends U>> sources;
        public long uniqueId;
        public io.reactivex.disposables.b upstream;
        public int wip;

        public MergeObserver(xi.g0<? super U> g0Var, dj.o<? super T, ? extends xi.e0<? extends U>> oVar, boolean z10, int i10, int i11) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            this.bufferSize = i11;
            if (i10 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i10);
            }
            this.observers = new AtomicReference<>(f34173a);
        }

        public boolean a(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == f34174b) {
                    innerObserver.a();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!this.observers.compareAndSet(innerObserverArr, (InnerObserver<?, ?>[]) innerObserverArr2));
            return true;
        }

        public boolean b() {
            if (this.cancelled) {
                return true;
            }
            Throwable th2 = this.errors.get();
            if (this.delayErrors || th2 == null) {
                return false;
            }
            c();
            Throwable thC = this.errors.c();
            if (thC != ExceptionHelper.f35249a) {
                this.downstream.onError(thC);
            }
            return true;
        }

        public boolean c() {
            InnerObserver<?, ?>[] andSet;
            this.upstream.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
            InnerObserver<?, ?>[] innerObserverArr2 = f34174b;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.observers.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.a();
            }
            return true;
        }

        public void d() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            Throwable thC;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!c() || (thC = this.errors.c()) == null || thC == ExceptionHelper.f35249a) {
                return;
            }
            kj.a.Y(thC);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:113:0x00f5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:128:0x00fd A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x00fc A[PHI: r4
  0x00fc: PHI (r4v6 int) = (r4v4 int), (r4v7 int) binds: [B:77:0x00db, B:89:0x00fa] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f() {
            /*
                Method dump skipped, instruction units count: 283
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.f():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void h(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerObserverArr[i11] == innerObserver) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = f34173a;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i10);
                    System.arraycopy(innerObserverArr, i10 + 1, innerObserverArr3, i10, (length - i10) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
        }

        public void i(xi.e0<? extends U> e0Var) {
            xi.e0<? extends U> e0VarPoll;
            while (e0Var instanceof Callable) {
                if (!m((Callable) e0Var) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                boolean z10 = false;
                synchronized (this) {
                    e0VarPoll = this.sources.poll();
                    if (e0VarPoll == null) {
                        this.wip--;
                        z10 = true;
                    }
                }
                if (z10) {
                    d();
                    return;
                }
                e0Var = e0VarPoll;
            }
            long j10 = this.uniqueId;
            this.uniqueId = 1 + j10;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j10);
            if (a(innerObserver)) {
                e0Var.c(innerObserver);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void k(int i10) {
            while (true) {
                int i11 = i10 - 1;
                if (i10 == 0) {
                    return;
                }
                synchronized (this) {
                    xi.e0<? extends U> e0VarPoll = this.sources.poll();
                    if (e0VarPoll == null) {
                        this.wip--;
                    } else {
                        i(e0VarPoll);
                    }
                }
                i10 = i11;
            }
        }

        public void l(U u6, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(u6);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                fj.o aVar = innerObserver.queue;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.queue.a(this.bufferSize);
                    innerObserver.queue = aVar;
                }
                aVar.offer(u6);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            f();
        }

        public boolean m(Callable<? extends U> callable) {
            try {
                U uCall = callable.call();
                if (uCall == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(uCall);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    fj.n<U> aVar = this.queue;
                    if (aVar == null) {
                        aVar = this.maxConcurrency == Integer.MAX_VALUE ? new io.reactivex.internal.queue.a<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
                        this.queue = aVar;
                    }
                    if (!aVar.offer(uCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                f();
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.errors.a(th2);
                d();
                return true;
            }
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            d();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
            } else if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                d();
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            try {
                xi.e0<? extends U> e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i10 = this.wip;
                        if (i10 == this.maxConcurrency) {
                            this.sources.offer(e0Var);
                            return;
                        }
                        this.wip = i10 + 1;
                    }
                }
                i(e0Var);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.e0<? extends U>> oVar, boolean z10, int i10, int i11) {
        super(e0Var);
        this.f34168b = oVar;
        this.f34169c = z10;
        this.f34170d = i10;
        this.f34171e = i11;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        if (ObservableScalarXMap.b(this.f34421a, g0Var, this.f34168b)) {
            return;
        }
        this.f34421a.c(new MergeObserver(g0Var, this.f34168b, this.f34169c, this.f34170d, this.f34171e));
    }
}
