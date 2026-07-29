package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSkipLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f34344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f34346f;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public final xi.g0<? super T> downstream;
        public Throwable error;
        public final io.reactivex.internal.queue.a<Object> queue;
        public final xi.h0 scheduler;
        public final long time;
        public final TimeUnit unit;
        public io.reactivex.disposables.b upstream;

        public SkipLastTimedObserver(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
            this.downstream = g0Var;
            this.time = j10;
            this.unit = timeUnit;
            this.scheduler = h0Var;
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.delayError = z10;
        }

        public void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            xi.g0<? super T> g0Var = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            boolean z10 = this.delayError;
            TimeUnit timeUnit = this.unit;
            xi.h0 h0Var = this.scheduler;
            long j10 = this.time;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z11 = this.done;
                Long l10 = (Long) aVar.peek();
                boolean z12 = l10 == null;
                long jE = h0Var.e(timeUnit);
                if (!z12 && l10.longValue() > jE - j10) {
                    z12 = true;
                }
                if (z11) {
                    if (!z10) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.queue.clear();
                            g0Var.onError(th2);
                            return;
                        } else if (z12) {
                            g0Var.onComplete();
                            return;
                        }
                    } else if (z12) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            g0Var.onError(th3);
                            return;
                        } else {
                            g0Var.onComplete();
                            return;
                        }
                    }
                }
                if (z12) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    aVar.poll();
                    g0Var.onNext(aVar.poll());
                }
            }
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
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
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.queue.offer(Long.valueOf(this.scheduler.e(this.unit)), t10);
            a();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(xi.e0<T> e0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
        super(e0Var);
        this.f34342b = j10;
        this.f34343c = timeUnit;
        this.f34344d = h0Var;
        this.f34345e = i10;
        this.f34346f = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new SkipLastTimedObserver(g0Var, this.f34342b, this.f34343c, this.f34344d, this.f34345e, this.f34346f));
    }
}
