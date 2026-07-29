package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class c0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f34454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34455d;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f34458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f34459d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public io.reactivex.disposables.b f34460e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f34461f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f34462g;

        public a(xi.g0<? super T> g0Var, long j10, T t10, boolean z10) {
            this.f34456a = g0Var;
            this.f34457b = j10;
            this.f34458c = t10;
            this.f34459d = z10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34460e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34460e.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34462g) {
                return;
            }
            this.f34462g = true;
            T t10 = this.f34458c;
            if (t10 == null && this.f34459d) {
                this.f34456a.onError(new NoSuchElementException());
                return;
            }
            if (t10 != null) {
                this.f34456a.onNext(t10);
            }
            this.f34456a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34462g) {
                kj.a.Y(th2);
            } else {
                this.f34462g = true;
                this.f34456a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34462g) {
                return;
            }
            long j10 = this.f34461f;
            if (j10 != this.f34457b) {
                this.f34461f = j10 + 1;
                return;
            }
            this.f34462g = true;
            this.f34460e.dispose();
            this.f34456a.onNext(t10);
            this.f34456a.onComplete();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34460e, bVar)) {
                this.f34460e = bVar;
                this.f34456a.onSubscribe(this);
            }
        }
    }

    public c0(xi.e0<T> e0Var, long j10, T t10, boolean z10) {
        super(e0Var);
        this.f34453b = j10;
        this.f34454c = t10;
        this.f34455d = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34453b, this.f34454c, this.f34455d));
    }
}
