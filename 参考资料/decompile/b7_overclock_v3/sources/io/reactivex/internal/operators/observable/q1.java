package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class q1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34672b;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f34674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f34676d;

        public a(xi.g0<? super T> g0Var, long j10) {
            this.f34673a = g0Var;
            this.f34676d = j10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34675c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34675c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34674b) {
                return;
            }
            this.f34674b = true;
            this.f34675c.dispose();
            this.f34673a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34674b) {
                kj.a.Y(th2);
                return;
            }
            this.f34674b = true;
            this.f34675c.dispose();
            this.f34673a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34674b) {
                return;
            }
            long j10 = this.f34676d;
            long j11 = j10 - 1;
            this.f34676d = j11;
            if (j10 > 0) {
                boolean z10 = j11 == 0;
                this.f34673a.onNext(t10);
                if (z10) {
                    onComplete();
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34675c, bVar)) {
                this.f34675c = bVar;
                if (this.f34676d != 0) {
                    this.f34673a.onSubscribe(this);
                    return;
                }
                this.f34674b = true;
                bVar.dispose();
                EmptyDisposable.complete(this.f34673a);
            }
        }
    }

    public q1(xi.e0<T> e0Var, long j10) {
        super(e0Var);
        this.f34672b = j10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34672b));
    }
}
