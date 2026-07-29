package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMapEager<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.e0<? extends R>> f34147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorMode f34148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34150e;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b, gj.j<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        public int activeCount;
        public volatile boolean cancelled;
        public InnerQueuedObserver<R> current;
        public volatile boolean done;
        public final xi.g0<? super R> downstream;
        public final ErrorMode errorMode;
        public final dj.o<? super T, ? extends xi.e0<? extends R>> mapper;
        public final int maxConcurrency;
        public final int prefetch;
        public fj.o<T> queue;
        public int sourceMode;
        public io.reactivex.disposables.b upstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        public ConcatMapEagerMainObserver(xi.g0<? super R> g0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar, int i10, int i11, ErrorMode errorMode) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.maxConcurrency = i10;
            this.prefetch = i11;
            this.errorMode = errorMode;
        }

        public void a() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> innerQueuedObserverPoll = this.observers.poll();
                if (innerQueuedObserverPoll == null) {
                    return;
                } else {
                    innerQueuedObserverPoll.dispose();
                }
            }
        }

        @Override // gj.j
        public void b() {
            R rPoll;
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            fj.o<T> oVar = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
            xi.g0<? super R> g0Var = this.downstream;
            ErrorMode errorMode = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                int i10 = this.activeCount;
                while (i10 != this.maxConcurrency) {
                    if (this.cancelled) {
                        oVar.clear();
                        a();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                        oVar.clear();
                        a();
                        g0Var.onError(this.error.c());
                        return;
                    }
                    try {
                        T tPoll = oVar.poll();
                        if (tPoll == null) {
                            break;
                        }
                        xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                        InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                        arrayDeque.offer(innerQueuedObserver);
                        e0Var.c(innerQueuedObserver);
                        i10++;
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.upstream.dispose();
                        oVar.clear();
                        a();
                        this.error.a(th2);
                        g0Var.onError(this.error.c());
                        return;
                    }
                }
                this.activeCount = i10;
                if (this.cancelled) {
                    oVar.clear();
                    a();
                    return;
                }
                if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                    oVar.clear();
                    a();
                    g0Var.onError(this.error.c());
                    return;
                }
                InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                if (innerQueuedObserver2 == null) {
                    if (errorMode == ErrorMode.BOUNDARY && this.error.get() != null) {
                        oVar.clear();
                        a();
                        g0Var.onError(this.error.c());
                        return;
                    }
                    boolean z11 = this.done;
                    InnerQueuedObserver<R> innerQueuedObserverPoll = arrayDeque.poll();
                    boolean z12 = innerQueuedObserverPoll == null;
                    if (z11 && z12) {
                        if (this.error.get() == null) {
                            g0Var.onComplete();
                            return;
                        }
                        oVar.clear();
                        a();
                        g0Var.onError(this.error.c());
                        return;
                    }
                    if (!z12) {
                        this.current = innerQueuedObserverPoll;
                    }
                    innerQueuedObserver2 = innerQueuedObserverPoll;
                }
                if (innerQueuedObserver2 != null) {
                    fj.o<R> oVarC = innerQueuedObserver2.c();
                    while (!this.cancelled) {
                        boolean zB = innerQueuedObserver2.b();
                        if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                            oVar.clear();
                            a();
                            g0Var.onError(this.error.c());
                            return;
                        }
                        try {
                            rPoll = oVarC.poll();
                            z10 = rPoll == null;
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.error.a(th3);
                            this.current = null;
                            this.activeCount--;
                        }
                        if (zB && z10) {
                            this.current = null;
                            this.activeCount--;
                        } else if (!z10) {
                            g0Var.onNext(rPoll);
                        }
                    }
                    oVar.clear();
                    a();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // gj.j
        public void c(InnerQueuedObserver<R> innerQueuedObserver, Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.upstream.dispose();
            }
            innerQueuedObserver.d();
            b();
        }

        @Override // gj.j
        public void d(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.d();
            b();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            h();
        }

        @Override // gj.j
        public void f(InnerQueuedObserver<R> innerQueuedObserver, R r10) {
            innerQueuedObserver.c().offer(r10);
            b();
        }

        public void h() {
            if (getAndIncrement() == 0) {
                do {
                    this.queue.clear();
                    a();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                b();
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.sourceMode == 0) {
                this.queue.offer(t10);
            }
            b();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof fj.j) {
                    fj.j jVar = (fj.j) bVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        b();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar, ErrorMode errorMode, int i10, int i11) {
        super(e0Var);
        this.f34147b = oVar;
        this.f34148c = errorMode;
        this.f34149d = i10;
        this.f34150e = i11;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        this.f34421a.c(new ConcatMapEagerMainObserver(g0Var, this.f34147b, this.f34149d, this.f34150e, this.f34148c));
    }
}
