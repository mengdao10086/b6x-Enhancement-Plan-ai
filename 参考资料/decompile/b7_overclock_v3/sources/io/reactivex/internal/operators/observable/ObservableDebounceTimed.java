package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDebounceTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f34157d;

    public static final class DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements Runnable, io.reactivex.disposables.b {
        private static final long serialVersionUID = 6812032969491025141L;
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final a<T> parent;
        public final T value;

        public DebounceEmitter(T t10, long j10, a<T> aVar) {
            this.value = t10;
            this.idx = j10;
            this.parent = aVar;
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }
    }

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f34160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0.c f34161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public io.reactivex.disposables.b f34162e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public io.reactivex.disposables.b f34163f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile long f34164g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f34165h;

        public a(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.f34158a = g0Var;
            this.f34159b = j10;
            this.f34160c = timeUnit;
            this.f34161d = cVar;
        }

        public void a(long j10, T t10, DebounceEmitter<T> debounceEmitter) {
            if (j10 == this.f34164g) {
                this.f34158a.onNext(t10);
                debounceEmitter.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34162e.dispose();
            this.f34161d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34161d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34165h) {
                return;
            }
            this.f34165h = true;
            io.reactivex.disposables.b bVar = this.f34163f;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f34158a.onComplete();
            this.f34161d.dispose();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34165h) {
                kj.a.Y(th2);
                return;
            }
            io.reactivex.disposables.b bVar = this.f34163f;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f34165h = true;
            this.f34158a.onError(th2);
            this.f34161d.dispose();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34165h) {
                return;
            }
            long j10 = this.f34164g + 1;
            this.f34164g = j10;
            io.reactivex.disposables.b bVar = this.f34163f;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t10, j10, this);
            this.f34163f = debounceEmitter;
            debounceEmitter.a(this.f34161d.c(debounceEmitter, this.f34159b, this.f34160c));
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34162e, bVar)) {
                this.f34162e = bVar;
                this.f34158a.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(xi.e0<T> e0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        super(e0Var);
        this.f34155b = j10;
        this.f34156c = timeUnit;
        this.f34157d = h0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(new io.reactivex.observers.l(g0Var), this.f34155b, this.f34156c, this.f34157d.d()));
    }
}
