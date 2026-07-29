package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRefCount<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cj.a<T> f33383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeUnit f33386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xi.h0 f33387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RefConnection f33388g;

    public static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements Runnable, dj.g<io.reactivex.disposables.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final FlowableRefCount<?> parent;
        public long subscriberCount;
        public io.reactivex.disposables.b timer;

        public RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.disposables.b bVar) throws Exception {
            DisposableHelper.replace(this, bVar);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ej.c) this.parent.f33383b).e(bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.Q8(this);
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final bu.d<? super T> downstream;
        public final FlowableRefCount<T> parent;
        public bu.e upstream;

        public RefCountSubscriber(bu.d<? super T> dVar, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.downstream = dVar;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.M8(this.connection);
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.P8(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!compareAndSet(false, true)) {
                kj.a.Y(th2);
            } else {
                this.parent.P8(this.connection);
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.upstream.request(j10);
        }
    }

    public FlowableRefCount(cj.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    public void M8(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f33388g;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j10 = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j10;
                if (j10 == 0 && refConnection.connected) {
                    if (this.f33385d == 0) {
                        Q8(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.a(this.f33387f.g(refConnection, this.f33385d, this.f33386e));
                }
            }
        }
    }

    public void N8(RefConnection refConnection) {
        io.reactivex.disposables.b bVar = refConnection.timer;
        if (bVar != null) {
            bVar.dispose();
            refConnection.timer = null;
        }
    }

    public void O8(RefConnection refConnection) {
        cj.a<T> aVar = this.f33383b;
        if (aVar instanceof io.reactivex.disposables.b) {
            ((io.reactivex.disposables.b) aVar).dispose();
        } else if (aVar instanceof ej.c) {
            ((ej.c) aVar).e(refConnection.get());
        }
    }

    public void P8(RefConnection refConnection) {
        synchronized (this) {
            if (this.f33383b instanceof s0) {
                RefConnection refConnection2 = this.f33388g;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f33388g = null;
                    N8(refConnection);
                }
                long j10 = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j10;
                if (j10 == 0) {
                    O8(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f33388g;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    N8(refConnection);
                    long j11 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j11;
                    if (j11 == 0) {
                        this.f33388g = null;
                        O8(refConnection);
                    }
                }
            }
        }
    }

    public void Q8(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f33388g) {
                this.f33388g = null;
                io.reactivex.disposables.b bVar = refConnection.get();
                DisposableHelper.dispose(refConnection);
                cj.a<T> aVar = this.f33383b;
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

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        RefConnection refConnection;
        boolean z10;
        io.reactivex.disposables.b bVar;
        synchronized (this) {
            refConnection = this.f33388g;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f33388g = refConnection;
            }
            long j10 = refConnection.subscriberCount;
            if (j10 == 0 && (bVar = refConnection.timer) != null) {
                bVar.dispose();
            }
            long j11 = j10 + 1;
            refConnection.subscriberCount = j11;
            z10 = true;
            if (refConnection.connected || j11 != this.f33384c) {
                z10 = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f33383b.j6(new RefCountSubscriber(dVar, this, refConnection));
        if (z10) {
            this.f33383b.Q8(refConnection);
        }
    }

    public FlowableRefCount(cj.a<T> aVar, int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f33383b = aVar;
        this.f33384c = i10;
        this.f33385d = j10;
        this.f33386e = timeUnit;
        this.f33387f = h0Var;
    }
}
