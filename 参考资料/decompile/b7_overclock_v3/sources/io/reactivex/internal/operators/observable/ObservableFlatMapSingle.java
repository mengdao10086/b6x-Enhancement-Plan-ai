package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMapSingle<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.o0<? extends R>> f34182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34183c;

    public static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8600231336733376951L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final xi.g0<? super R> downstream;
        public final dj.o<? super T, ? extends xi.o0<? extends R>> mapper;
        public io.reactivex.disposables.b upstream;
        public final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicInteger active = new AtomicInteger(1);
        public final AtomicReference<io.reactivex.internal.queue.a<R>> queue = new AtomicReference<>();

        public final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.l0<R>, io.reactivex.disposables.b {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // xi.l0
            public void onError(Throwable th2) {
                FlatMapSingleObserver.this.d(this, th2);
            }

            @Override // xi.l0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.l0
            public void onSuccess(R r10) {
                FlatMapSingleObserver.this.f(this, r10);
            }
        }

        public FlatMapSingleObserver(xi.g0<? super R> g0Var, dj.o<? super T, ? extends xi.o0<? extends R>> oVar, boolean z10) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            xi.g0<? super R> g0Var = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<io.reactivex.internal.queue.a<R>> atomicReference = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable thC = this.errors.c();
                    clear();
                    g0Var.onError(thC);
                    return;
                }
                boolean z10 = atomicInteger.get() == 0;
                io.reactivex.internal.queue.a<R> aVar = atomicReference.get();
                a0.c cVarPoll = aVar != null ? aVar.poll() : null;
                boolean z11 = cVarPoll == null;
                if (z10 && z11) {
                    Throwable thC2 = this.errors.c();
                    if (thC2 != null) {
                        g0Var.onError(thC2);
                        return;
                    } else {
                        g0Var.onComplete();
                        return;
                    }
                }
                if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    g0Var.onNext(cVarPoll);
                }
            }
            clear();
        }

        public io.reactivex.internal.queue.a<R> c() {
            io.reactivex.internal.queue.a<R> aVar;
            do {
                io.reactivex.internal.queue.a<R> aVar2 = this.queue.get();
                if (aVar2 != null) {
                    return aVar2;
                }
                aVar = new io.reactivex.internal.queue.a<>(xi.z.U());
            } while (!this.queue.compareAndSet(null, aVar));
            return aVar;
        }

        public void clear() {
            io.reactivex.internal.queue.a<R> aVar = this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        public void d(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.set.c(innerObserver);
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f(io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver<T, R>.InnerObserver r3, R r4) {
            /*
                r2 = this;
                io.reactivex.disposables.a r0 = r2.set
                r0.c(r3)
                int r3 = r2.get()
                if (r3 != 0) goto L4e
                r3 = 0
                r0 = 1
                boolean r1 = r2.compareAndSet(r3, r0)
                if (r1 == 0) goto L4e
                xi.g0<? super R> r1 = r2.downstream
                r1.onNext(r4)
                java.util.concurrent.atomic.AtomicInteger r4 = r2.active
                int r4 = r4.decrementAndGet()
                if (r4 != 0) goto L21
                r3 = 1
            L21:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.queue.a<R>> r4 = r2.queue
                java.lang.Object r4 = r4.get()
                io.reactivex.internal.queue.a r4 = (io.reactivex.internal.queue.a) r4
                if (r3 == 0) goto L47
                if (r4 == 0) goto L33
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L47
            L33:
                io.reactivex.internal.util.AtomicThrowable r3 = r2.errors
                java.lang.Throwable r3 = r3.c()
                if (r3 == 0) goto L41
                xi.g0<? super R> r4 = r2.downstream
                r4.onError(r3)
                goto L46
            L41:
                xi.g0<? super R> r3 = r2.downstream
                r3.onComplete()
            L46:
                return
            L47:
                int r3 = r2.decrementAndGet()
                if (r3 != 0) goto L63
                return
            L4e:
                io.reactivex.internal.queue.a r3 = r2.c()
                monitor-enter(r3)
                r3.offer(r4)     // Catch: java.lang.Throwable -> L67
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
                java.util.concurrent.atomic.AtomicInteger r3 = r2.active
                r3.decrementAndGet()
                int r3 = r2.getAndIncrement()
                if (r3 == 0) goto L63
                return
            L63:
                r2.b()
                return
            L67:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver.f(io.reactivex.internal.operators.observable.ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver, java.lang.Object):void");
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            this.active.decrementAndGet();
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.active.decrementAndGet();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            a();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            try {
                xi.o0 o0Var = (xi.o0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.b(innerObserver)) {
                    return;
                }
                o0Var.a(innerObserver);
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

    public ObservableFlatMapSingle(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.o0<? extends R>> oVar, boolean z10) {
        super(e0Var);
        this.f34182b = oVar;
        this.f34183c = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        this.f34421a.c(new FlatMapSingleObserver(g0Var, this.f34182b, this.f34183c));
    }
}
