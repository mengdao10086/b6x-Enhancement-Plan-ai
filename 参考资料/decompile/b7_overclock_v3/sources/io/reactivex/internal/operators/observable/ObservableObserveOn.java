package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f34249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34251d;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements xi.g0<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        public final int bufferSize;
        public final boolean delayError;
        public volatile boolean disposed;
        public volatile boolean done;
        public final xi.g0<? super T> downstream;
        public Throwable error;
        public boolean outputFused;
        public fj.o<T> queue;
        public int sourceMode;
        public io.reactivex.disposables.b upstream;
        public final h0.c worker;

        public ObserveOnObserver(xi.g0<? super T> g0Var, h0.c cVar, boolean z10, int i10) {
            this.downstream = g0Var;
            this.worker = cVar;
            this.delayError = z10;
            this.bufferSize = i10;
        }

        public boolean a(boolean z10, boolean z11, xi.g0<? super T> g0Var) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th2 = this.error;
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                this.disposed = true;
                if (th2 != null) {
                    g0Var.onError(th2);
                } else {
                    g0Var.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th2 != null) {
                this.disposed = true;
                this.queue.clear();
                g0Var.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z11) {
                return false;
            }
            this.disposed = true;
            g0Var.onComplete();
            this.worker.dispose();
            return true;
        }

        public void b() {
            int iAddAndGet = 1;
            while (!this.disposed) {
                boolean z10 = this.done;
                Throwable th2 = this.error;
                if (!this.delayError && z10 && th2 != null) {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext(null);
                if (z10) {
                    this.disposed = true;
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        this.downstream.onError(th3);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c() {
            /*
                r7 = this;
                fj.o<T> r0 = r7.queue
                xi.g0<? super T> r1 = r7.downstream
                r2 = 1
                r3 = 1
            L6:
                boolean r4 = r7.done
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.a(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.done
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = 1
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.a(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r3 = move-exception
                io.reactivex.exceptions.a.b(r3)
                r7.disposed = r2
                io.reactivex.disposables.b r2 = r7.upstream
                r2.dispose()
                r0.clear()
                r1.onError(r3)
                xi.h0$c r0 = r7.worker
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.c():void");
        }

        @Override // fj.o
        public void clear() {
            this.queue.clear();
        }

        public void d() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
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
                return;
            }
            this.error = th2;
            this.done = true;
            d();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t10);
            }
            d();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof fj.j) {
                    fj.j jVar = (fj.j) bVar;
                    int iRequestFusion = jVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        d();
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

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                b();
            } else {
                c();
            }
        }
    }

    public ObservableObserveOn(xi.e0<T> e0Var, xi.h0 h0Var, boolean z10, int i10) {
        super(e0Var);
        this.f34249b = h0Var;
        this.f34250c = z10;
        this.f34251d = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        xi.h0 h0Var = this.f34249b;
        if (h0Var instanceof io.reactivex.internal.schedulers.l) {
            this.f34421a.c(g0Var);
        } else {
            this.f34421a.c(new ObserveOnObserver(g0Var, h0Var.d(), this.f34250c, this.f34251d));
        }
    }
}
