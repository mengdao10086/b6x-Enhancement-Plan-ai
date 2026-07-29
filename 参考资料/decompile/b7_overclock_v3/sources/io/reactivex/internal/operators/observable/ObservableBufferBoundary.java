package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<U> f34123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.e0<? extends Open> f34124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super Open, ? extends xi.e0<? extends Close>> f34125d;

    public static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8466418554264089604L;
        public final dj.o<? super Open, ? extends xi.e0<? extends Close>> bufferClose;
        public final xi.e0<? extends Open> bufferOpen;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final xi.g0<? super C> downstream;
        public long index;
        public final io.reactivex.internal.queue.a<C> queue = new io.reactivex.internal.queue.a<>(xi.z.U());
        public final io.reactivex.disposables.a observers = new io.reactivex.disposables.a();
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        public Map<Long, C> buffers = new LinkedHashMap();
        public final AtomicThrowable errors = new AtomicThrowable();

        public static final class BufferOpenObserver<Open> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<Open>, io.reactivex.disposables.b {
            private static final long serialVersionUID = -8498650778633225126L;
            public final BufferBoundaryObserver<?, ?, Open, ?> parent;

            public BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.parent = bufferBoundaryObserver;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // xi.g0
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.f(this);
            }

            @Override // xi.g0
            public void onError(Throwable th2) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.a(this, th2);
            }

            @Override // xi.g0
            public void onNext(Open open) {
                this.parent.d(open);
            }

            @Override // xi.g0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public BufferBoundaryObserver(xi.g0<? super C> g0Var, xi.e0<? extends Open> e0Var, dj.o<? super Open, ? extends xi.e0<? extends Close>> oVar, Callable<C> callable) {
            this.downstream = g0Var;
            this.bufferSupplier = callable;
            this.bufferOpen = e0Var;
            this.bufferClose = oVar;
        }

        public void a(io.reactivex.disposables.b bVar, Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            this.observers.c(bVar);
            onError(th2);
        }

        public void b(BufferCloseObserver<T, C> bufferCloseObserver, long j10) {
            boolean z10;
            this.observers.c(bufferCloseObserver);
            if (this.observers.g() == 0) {
                DisposableHelper.dispose(this.upstream);
                z10 = true;
            } else {
                z10 = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(j10)));
                if (z10) {
                    this.done = true;
                }
                c();
            }
        }

        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            xi.g0<? super C> g0Var = this.downstream;
            io.reactivex.internal.queue.a<C> aVar = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                if (z10 && this.errors.get() != null) {
                    aVar.clear();
                    g0Var.onError(this.errors.c());
                    return;
                }
                C cPoll = aVar.poll();
                boolean z11 = cPoll == null;
                if (z10 && z11) {
                    g0Var.onComplete();
                    return;
                } else if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    g0Var.onNext(cPoll);
                }
            }
            aVar.clear();
        }

        public void d(Open open) {
            try {
                Collection collection = (Collection) io.reactivex.internal.functions.a.g(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                long j10 = this.index;
                this.index = 1 + j10;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j10), (C) collection);
                    BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j10);
                    this.observers.b(bufferCloseObserver);
                    e0Var.c(bufferCloseObserver);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                DisposableHelper.dispose(this.upstream);
                onError(th2);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        public void f(BufferOpenObserver<Open> bufferOpenObserver) {
            this.observers.c(bufferOpenObserver);
            if (this.observers.g() == 0) {
                DisposableHelper.dispose(this.upstream);
                this.done = true;
                c();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // xi.g0
        public void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    this.queue.offer(it2.next());
                }
                this.buffers = null;
                this.done = true;
                c();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            this.observers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            c();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    it2.next().add(t10);
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this.upstream, bVar)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.observers.b(bufferOpenObserver);
                this.bufferOpen.c(bufferOpenObserver);
            }
        }
    }

    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8498650778633225126L;
        public final long index;
        public final BufferBoundaryObserver<T, C, ?, ?> parent;

        public BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j10) {
            this.parent = bufferBoundaryObserver;
            this.index = j10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // xi.g0
        public void onComplete() {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.b(this, this.index);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                kj.a.Y(th2);
            } else {
                lazySet(disposableHelper);
                this.parent.a(this, th2);
            }
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                bVar.dispose();
                this.parent.b(this, this.index);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableBufferBoundary(xi.e0<T> e0Var, xi.e0<? extends Open> e0Var2, dj.o<? super Open, ? extends xi.e0<? extends Close>> oVar, Callable<U> callable) {
        super(e0Var);
        this.f34124c = e0Var2;
        this.f34125d = oVar;
        this.f34123b = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(g0Var, this.f34124c, this.f34125d, this.f34123b);
        g0Var.onSubscribe(bufferBoundaryObserver);
        this.f34421a.c(bufferBoundaryObserver);
    }
}
