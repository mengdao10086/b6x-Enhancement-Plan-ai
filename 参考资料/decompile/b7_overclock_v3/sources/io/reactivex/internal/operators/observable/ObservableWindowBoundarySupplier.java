package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends io.reactivex.internal.operators.observable.a<T, xi.z<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends xi.e0<B>> f34397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34398c;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<Object, Object> f34399a = new a<>(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Object f34400b = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final int capacityHint;
        public volatile boolean done;
        public final xi.g0<? super xi.z<T>> downstream;
        public final Callable<? extends xi.e0<B>> other;
        public io.reactivex.disposables.b upstream;
        public UnicastSubject<T> window;
        public final AtomicReference<a<T, B>> boundaryObserver = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();

        public WindowBoundaryMainObserver(xi.g0<? super xi.z<T>> g0Var, int i10, Callable<? extends xi.e0<B>> callable) {
            this.downstream = g0Var;
            this.capacityHint = i10;
            this.other = callable;
        }

        public void a() {
            AtomicReference<a<T, B>> atomicReference = this.boundaryObserver;
            a<Object, Object> aVar = f34399a;
            a<T, B> andSet = atomicReference.getAndSet((a<T, B>) aVar);
            if (andSet == null || andSet == aVar) {
                return;
            }
            andSet.dispose();
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            xi.g0<? super xi.z<T>> g0Var = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int iAddAndGet = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z10 = this.done;
                if (z10 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thC = atomicThrowable.c();
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onError(thC);
                    }
                    g0Var.onError(thC);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                if (z10 && z11) {
                    Throwable thC2 = atomicThrowable.c();
                    if (thC2 == null) {
                        if (unicastSubject != null) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        g0Var.onComplete();
                        return;
                    }
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onError(thC2);
                    }
                    g0Var.onError(thC2);
                    return;
                }
                if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f34400b) {
                    unicastSubject.onNext((T) objPoll);
                } else {
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastSubject<T> unicastSubjectP8 = UnicastSubject.p8(this.capacityHint, this);
                        this.window = unicastSubjectP8;
                        this.windows.getAndIncrement();
                        try {
                            xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.other.call(), "The other Callable returned a null ObservableSource");
                            a<T, B> aVar = new a<>(this);
                            if (this.boundaryObserver.compareAndSet(null, aVar)) {
                                e0Var.c(aVar);
                                g0Var.onNext(unicastSubjectP8);
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            atomicThrowable.a(th2);
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        public void c() {
            this.upstream.dispose();
            this.done = true;
            b();
        }

        public void d(Throwable th2) {
            this.upstream.dispose();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                b();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                a();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        public void f(a<T, B> aVar) {
            this.boundaryObserver.compareAndSet(aVar, null);
            this.queue.offer(f34400b);
            b();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // xi.g0
        public void onComplete() {
            a();
            this.done = true;
            b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            a();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                b();
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.queue.offer(t10);
            b();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                this.queue.offer(f34400b);
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    public static final class a<T, B> extends io.reactivex.observers.d<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f34401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34402c;

        public a(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f34401b = windowBoundaryMainObserver;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34402c) {
                return;
            }
            this.f34402c = true;
            this.f34401b.c();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34402c) {
                kj.a.Y(th2);
            } else {
                this.f34402c = true;
                this.f34401b.d(th2);
            }
        }

        @Override // xi.g0
        public void onNext(B b10) {
            if (this.f34402c) {
                return;
            }
            this.f34402c = true;
            dispose();
            this.f34401b.f(this);
        }
    }

    public ObservableWindowBoundarySupplier(xi.e0<T> e0Var, Callable<? extends xi.e0<B>> callable, int i10) {
        super(e0Var);
        this.f34397b = callable;
        this.f34398c = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super xi.z<T>> g0Var) {
        this.f34421a.c(new WindowBoundaryMainObserver(g0Var, this.f34398c, this.f34397b));
    }
}
