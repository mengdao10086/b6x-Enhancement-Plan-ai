package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRefCount<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ij.a<T> f34273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f34276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f34277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RefConnection f34278f;

    public static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements Runnable, dj.g<io.reactivex.disposables.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final ObservableRefCount<?> parent;
        public long subscriberCount;
        public io.reactivex.disposables.b timer;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.disposables.b bVar) throws Exception {
            DisposableHelper.replace(this, bVar);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ej.c) this.parent.f34273a).e(bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.m8(this);
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final xi.g0<? super T> downstream;
        public final ObservableRefCount<T> parent;
        public io.reactivex.disposables.b upstream;

        public RefCountObserver(xi.g0<? super T> g0Var, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = g0Var;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.i8(this.connection);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.l8(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!compareAndSet(false, true)) {
                kj.a.Y(th2);
            } else {
                this.parent.l8(this.connection);
                this.downstream.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ij.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        RefConnection refConnection;
        boolean z10;
        io.reactivex.disposables.b bVar;
        synchronized (this) {
            refConnection = this.f34278f;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f34278f = refConnection;
            }
            long j10 = refConnection.subscriberCount;
            if (j10 == 0 && (bVar = refConnection.timer) != null) {
                bVar.dispose();
            }
            long j11 = j10 + 1;
            refConnection.subscriberCount = j11;
            z10 = true;
            if (refConnection.connected || j11 != this.f34274b) {
                z10 = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f34273a.c(new RefCountObserver(g0Var, this, refConnection));
        if (z10) {
            this.f34273a.m8(refConnection);
        }
    }

    public void i8(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f34278f;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j10 = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j10;
                if (j10 == 0 && refConnection.connected) {
                    if (this.f34275c == 0) {
                        m8(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.a(this.f34277e.g(refConnection, this.f34275c, this.f34276d));
                }
            }
        }
    }

    public void j8(RefConnection refConnection) {
        io.reactivex.disposables.b bVar = refConnection.timer;
        if (bVar != null) {
            bVar.dispose();
            refConnection.timer = null;
        }
    }

    public void k8(RefConnection refConnection) {
        ij.a<T> aVar = this.f34273a;
        if (aVar instanceof io.reactivex.disposables.b) {
            ((io.reactivex.disposables.b) aVar).dispose();
        } else if (aVar instanceof ej.c) {
            ((ej.c) aVar).e(refConnection.get());
        }
    }

    public void l8(RefConnection refConnection) {
        synchronized (this) {
            if (this.f34273a instanceof d1) {
                RefConnection refConnection2 = this.f34278f;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f34278f = null;
                    j8(refConnection);
                }
                long j10 = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j10;
                if (j10 == 0) {
                    k8(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f34278f;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    j8(refConnection);
                    long j11 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j11;
                    if (j11 == 0) {
                        this.f34278f = null;
                        k8(refConnection);
                    }
                }
            }
        }
    }

    public void m8(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f34278f) {
                this.f34278f = null;
                io.reactivex.disposables.b bVar = refConnection.get();
                DisposableHelper.dispose(refConnection);
                ij.a<T> aVar = this.f34273a;
                if (aVar instanceof io.reactivex.disposables.b) {
                    ((io.reactivex.disposables.b) aVar).dispose();
                } else if (aVar instanceof ej.c) {
                    if (bVar == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ej.c) aVar).e(bVar);
                    }
                }
            }
        }
    }

    public ObservableRefCount(ij.a<T> aVar, int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f34273a = aVar;
        this.f34274b = i10;
        this.f34275c = j10;
        this.f34276d = timeUnit;
        this.f34277e = h0Var;
    }
}
