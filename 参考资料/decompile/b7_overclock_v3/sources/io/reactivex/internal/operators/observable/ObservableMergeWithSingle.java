package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableMergeWithSingle<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.o0<? extends T> f34246b;

    public static final class MergeWithObserver<T> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f34247a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f34248b = 2;
        private static final long serialVersionUID = -4592979584110982903L;
        public volatile boolean disposed;
        public final xi.g0<? super T> downstream;
        public volatile boolean mainDone;
        public volatile int otherState;
        public volatile fj.n<T> queue;
        public T singleItem;
        public final AtomicReference<io.reactivex.disposables.b> mainDisposable = new AtomicReference<>();
        public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        public final AtomicThrowable error = new AtomicThrowable();

        public static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.l0<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // xi.l0
            public void onError(Throwable th2) {
                this.parent.d(th2);
            }

            @Override // xi.l0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.l0
            public void onSuccess(T t10) {
                this.parent.f(t10);
            }
        }

        public MergeWithObserver(xi.g0<? super T> g0Var) {
            this.downstream = g0Var;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            xi.g0<? super T> g0Var = this.downstream;
            int iAddAndGet = 1;
            while (!this.disposed) {
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    g0Var.onError(this.error.c());
                    return;
                }
                int i10 = this.otherState;
                if (i10 == 1) {
                    T t10 = this.singleItem;
                    this.singleItem = null;
                    this.otherState = 2;
                    g0Var.onNext(t10);
                    i10 = 2;
                }
                boolean z10 = this.mainDone;
                fj.n<T> nVar = this.queue;
                a0.c cVarPoll = nVar != null ? nVar.poll() : null;
                boolean z11 = cVarPoll == null;
                if (z10 && z11 && i10 == 2) {
                    this.queue = null;
                    g0Var.onComplete();
                    return;
                } else if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    g0Var.onNext(cVarPoll);
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        public fj.n<T> c() {
            fj.n<T> nVar = this.queue;
            if (nVar != null) {
                return nVar;
            }
            io.reactivex.internal.queue.a aVar = new io.reactivex.internal.queue.a(xi.z.U());
            this.queue = aVar;
            return aVar;
        }

        public void d(Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this.mainDisposable);
                a();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        public void f(T t10) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t10);
                this.otherState = 2;
            } else {
                this.singleItem = t10;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // xi.g0
        public void onComplete() {
            this.mainDone = true;
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this.otherObserver);
                a();
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t10);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }
    }

    public ObservableMergeWithSingle(xi.z<T> zVar, xi.o0<? extends T> o0Var) {
        super(zVar);
        this.f34246b = o0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(g0Var);
        g0Var.onSubscribe(mergeWithObserver);
        this.f34421a.c(mergeWithObserver);
        this.f34246b.a(mergeWithObserver.otherObserver);
    }
}
