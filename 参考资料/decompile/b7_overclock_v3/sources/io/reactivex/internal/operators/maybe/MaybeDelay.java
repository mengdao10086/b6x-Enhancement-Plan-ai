package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeDelay<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f33837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f33838d;

    public static final class DelayMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        public final long delay;
        public final xi.t<? super T> downstream;
        public Throwable error;
        public final xi.h0 scheduler;
        public final TimeUnit unit;
        public T value;

        public DelayMaybeObserver(xi.t<? super T> tVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.downstream = tVar;
            this.delay = j10;
            this.unit = timeUnit;
            this.scheduler = h0Var;
        }

        public void a() {
            DisposableHelper.replace(this, this.scheduler.g(this, this.delay, this.unit));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.t
        public void onComplete() {
            a();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.error = th2;
            a();
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.value = t10;
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.downstream.onError(th2);
                return;
            }
            T t10 = this.value;
            if (t10 != null) {
                this.downstream.onSuccess(t10);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public MaybeDelay(xi.w<T> wVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        super(wVar);
        this.f33836b = j10;
        this.f33837c = timeUnit;
        this.f33838d = h0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new DelayMaybeObserver(tVar, this.f33836b, this.f33837c, this.f33838d));
    }
}
