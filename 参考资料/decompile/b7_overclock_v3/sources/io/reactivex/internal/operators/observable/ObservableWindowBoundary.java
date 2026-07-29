package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindowBoundary<T, B> extends io.reactivex.internal.operators.observable.a<T, xi.z<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<B> f34392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34393c;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f34394a = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final int capacityHint;
        public volatile boolean done;
        public final xi.g0<? super xi.z<T>> downstream;
        public UnicastSubject<T> window;
        public final a<T, B> boundaryObserver = new a<>(this);
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();

        public WindowBoundaryMainObserver(xi.g0<? super xi.z<T>> g0Var, int i10) {
            this.downstream = g0Var;
            this.capacityHint = i10;
        }

        public void a() {
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
                } else if (objPoll != f34394a) {
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
                        g0Var.onNext(unicastSubjectP8);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        public void b() {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            a();
        }

        public void c(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                a();
            }
        }

        public void d() {
            this.queue.offer(f34394a);
            a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // xi.g0
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.boundaryObserver.dispose();
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                a();
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.queue.offer(t10);
            a();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this.upstream, bVar)) {
                d();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    public static final class a<T, B> extends io.reactivex.observers.d<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f34395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34396c;

        public a(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f34395b = windowBoundaryMainObserver;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34396c) {
                return;
            }
            this.f34396c = true;
            this.f34395b.b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34396c) {
                kj.a.Y(th2);
            } else {
                this.f34396c = true;
                this.f34395b.c(th2);
            }
        }

        @Override // xi.g0
        public void onNext(B b10) {
            if (this.f34396c) {
                return;
            }
            this.f34395b.d();
        }
    }

    public ObservableWindowBoundary(xi.e0<T> e0Var, xi.e0<B> e0Var2, int i10) {
        super(e0Var);
        this.f34392b = e0Var2;
        this.f34393c = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super xi.z<T>> g0Var) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(g0Var, this.f34393c);
        g0Var.onSubscribe(windowBoundaryMainObserver);
        this.f34392b.c(windowBoundaryMainObserver.boundaryObserver);
        this.f34421a.c(windowBoundaryMainObserver);
    }
}
