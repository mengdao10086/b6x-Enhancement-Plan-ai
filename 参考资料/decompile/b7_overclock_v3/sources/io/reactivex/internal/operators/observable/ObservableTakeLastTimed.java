package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f34357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f34358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f34359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f34360g;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final long count;
        public final boolean delayError;
        public final xi.g0<? super T> downstream;
        public Throwable error;
        public final io.reactivex.internal.queue.a<Object> queue;
        public final xi.h0 scheduler;
        public final long time;
        public final TimeUnit unit;
        public io.reactivex.disposables.b upstream;

        public TakeLastTimedObserver(xi.g0<? super T> g0Var, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
            this.downstream = g0Var;
            this.count = j10;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = h0Var;
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.delayError = z10;
        }

        public void a() {
            Throwable th2;
            if (compareAndSet(false, true)) {
                xi.g0<? super T> g0Var = this.downstream;
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                boolean z10 = this.delayError;
                long jE = this.scheduler.e(this.unit) - this.time;
                while (!this.cancelled) {
                    if (!z10 && (th2 = this.error) != null) {
                        aVar.clear();
                        g0Var.onError(th2);
                        return;
                    }
                    Object objPoll = aVar.poll();
                    if (objPoll == null) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            g0Var.onError(th3);
                            return;
                        } else {
                            g0Var.onComplete();
                            return;
                        }
                    }
                    Object objPoll2 = aVar.poll();
                    if (((Long) objPoll).longValue() >= jE) {
                        g0Var.onNext(objPoll2);
                    }
                }
                aVar.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.error = th2;
            a();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            long jE = this.scheduler.e(this.unit);
            long j10 = this.time;
            long j11 = this.count;
            boolean z10 = j11 == Long.MAX_VALUE;
            aVar.offer(Long.valueOf(jE), t10);
            while (!aVar.isEmpty()) {
                if (((Long) aVar.peek()).longValue() > jE - j10 && (z10 || (aVar.p() >> 1) <= j11)) {
                    return;
                }
                aVar.poll();
                aVar.poll();
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

    public ObservableTakeLastTimed(xi.e0<T> e0Var, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
        super(e0Var);
        this.f34355b = j10;
        this.f34356c = j11;
        this.f34357d = timeUnit;
        this.f34358e = h0Var;
        this.f34359f = i10;
        this.f34360g = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new TakeLastTimedObserver(g0Var, this.f34355b, this.f34356c, this.f34357d, this.f34358e, this.f34359f, this.f34360g));
    }
}
