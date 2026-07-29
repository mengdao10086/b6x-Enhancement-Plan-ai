package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.e0<? extends U>> f34144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorMode f34146d;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -6951100001833242599L;
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final xi.g0<? super R> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final dj.o<? super T, ? extends xi.e0<? extends R>> mapper;
        public final DelayErrorInnerObserver<R> observer;
        public fj.o<T> queue;
        public int sourceMode;
        public final boolean tillTheEnd;
        public io.reactivex.disposables.b upstream;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            public final xi.g0<? super R> downstream;
            public final ConcatMapDelayErrorObserver<?, R> parent;

            public DelayErrorInnerObserver(xi.g0<? super R> g0Var, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.downstream = g0Var;
                this.parent = concatMapDelayErrorObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.g0
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.a();
            }

            @Override // xi.g0
            public void onError(Throwable th2) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (!concatMapDelayErrorObserver.error.a(th2)) {
                    kj.a.Y(th2);
                    return;
                }
                if (!concatMapDelayErrorObserver.tillTheEnd) {
                    concatMapDelayErrorObserver.upstream.dispose();
                }
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.a();
            }

            @Override // xi.g0
            public void onNext(R r10) {
                this.downstream.onNext(r10);
            }

            @Override // xi.g0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        public ConcatMapDelayErrorObserver(xi.g0<? super R> g0Var, dj.o<? super T, ? extends xi.e0<? extends R>> oVar, int i10, boolean z10) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.bufferSize = i10;
            this.tillTheEnd = z10;
            this.observer = new DelayErrorInnerObserver<>(g0Var, this);
        }

        public void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            xi.g0<? super R> g0Var = this.downstream;
            fj.o<T> oVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        oVar.clear();
                        return;
                    }
                    if (!this.tillTheEnd && atomicThrowable.get() != null) {
                        oVar.clear();
                        this.cancelled = true;
                        g0Var.onError(atomicThrowable.c());
                        return;
                    }
                    boolean z10 = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z11 = tPoll == null;
                        if (z10 && z11) {
                            this.cancelled = true;
                            Throwable thC = atomicThrowable.c();
                            if (thC != null) {
                                g0Var.onError(thC);
                                return;
                            } else {
                                g0Var.onComplete();
                                return;
                            }
                        }
                        if (!z11) {
                            try {
                                xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                if (e0Var instanceof Callable) {
                                    try {
                                        a0.b bVar = (Object) ((Callable) e0Var).call();
                                        if (bVar != null && !this.cancelled) {
                                            g0Var.onNext(bVar);
                                        }
                                    } catch (Throwable th2) {
                                        io.reactivex.exceptions.a.b(th2);
                                        atomicThrowable.a(th2);
                                    }
                                } else {
                                    this.active = true;
                                    e0Var.c(this.observer);
                                }
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.b(th3);
                                this.cancelled = true;
                                this.upstream.dispose();
                                oVar.clear();
                                atomicThrowable.a(th3);
                                g0Var.onError(atomicThrowable.c());
                                return;
                            }
                        }
                    } catch (Throwable th4) {
                        io.reactivex.exceptions.a.b(th4);
                        this.cancelled = true;
                        this.upstream.dispose();
                        atomicThrowable.a(th4);
                        g0Var.onError(atomicThrowable.c());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                a();
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.sourceMode == 0) {
                this.queue.offer(t10);
            }
            a();
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
                        a();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8828587559905699186L;
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean disposed;
        public volatile boolean done;
        public final xi.g0<? super U> downstream;
        public int fusionMode;
        public final InnerObserver<U> inner;
        public final dj.o<? super T, ? extends xi.e0<? extends U>> mapper;
        public fj.o<T> queue;
        public io.reactivex.disposables.b upstream;

        public static final class InnerObserver<U> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            public final xi.g0<? super U> downstream;
            public final SourceObserver<?, ?> parent;

            public InnerObserver(xi.g0<? super U> g0Var, SourceObserver<?, ?> sourceObserver) {
                this.downstream = g0Var;
                this.parent = sourceObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.g0
            public void onComplete() {
                this.parent.b();
            }

            @Override // xi.g0
            public void onError(Throwable th2) {
                this.parent.dispose();
                this.downstream.onError(th2);
            }

            @Override // xi.g0
            public void onNext(U u6) {
                this.downstream.onNext(u6);
            }

            @Override // xi.g0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        public SourceObserver(xi.g0<? super U> g0Var, dj.o<? super T, ? extends xi.e0<? extends U>> oVar, int i10) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.bufferSize = i10;
            this.inner = new InnerObserver<>(g0Var, this);
        }

        public void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z10 = this.done;
                    try {
                        T tPoll = this.queue.poll();
                        boolean z11 = tPoll == null;
                        if (z10 && z11) {
                            this.disposed = true;
                            this.downstream.onComplete();
                            return;
                        } else if (!z11) {
                            try {
                                xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                this.active = true;
                                e0Var.c(this.inner);
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                dispose();
                                this.queue.clear();
                                this.downstream.onError(th2);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        dispose();
                        this.queue.clear();
                        this.downstream.onError(th3);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        public void b() {
            this.active = false;
            a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.inner.a();
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t10);
            }
            a();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof fj.j) {
                    fj.j jVar = (fj.j) bVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = jVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.e0<? extends U>> oVar, int i10, ErrorMode errorMode) {
        super(e0Var);
        this.f34144b = oVar;
        this.f34146d = errorMode;
        this.f34145c = Math.max(8, i10);
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        if (ObservableScalarXMap.b(this.f34421a, g0Var, this.f34144b)) {
            return;
        }
        if (this.f34146d == ErrorMode.IMMEDIATE) {
            this.f34421a.c(new SourceObserver(new io.reactivex.observers.l(g0Var), this.f34144b, this.f34145c));
        } else {
            this.f34421a.c(new ConcatMapDelayErrorObserver(g0Var, this.f34144b, this.f34145c, this.f34146d == ErrorMode.END));
        }
    }
}
