package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class e0<T> extends xi.i0<T> implements fj.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f34491c;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super T> f34492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f34494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f34496e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f34497f;

        public a(xi.l0<? super T> l0Var, long j10, T t10) {
            this.f34492a = l0Var;
            this.f34493b = j10;
            this.f34494c = t10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34495d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34495d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34497f) {
                return;
            }
            this.f34497f = true;
            T t10 = this.f34494c;
            if (t10 != null) {
                this.f34492a.onSuccess(t10);
            } else {
                this.f34492a.onError(new NoSuchElementException());
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34497f) {
                kj.a.Y(th2);
            } else {
                this.f34497f = true;
                this.f34492a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34497f) {
                return;
            }
            long j10 = this.f34496e;
            if (j10 != this.f34493b) {
                this.f34496e = j10 + 1;
                return;
            }
            this.f34497f = true;
            this.f34495d.dispose();
            this.f34492a.onSuccess(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34495d, bVar)) {
                this.f34495d = bVar;
                this.f34492a.onSubscribe(this);
            }
        }
    }

    public e0(xi.e0<T> e0Var, long j10, T t10) {
        this.f34489a = e0Var;
        this.f34490b = j10;
        this.f34491c = t10;
    }

    @Override // fj.d
    public xi.z<T> b() {
        return kj.a.U(new c0(this.f34489a, this.f34490b, this.f34491c, true));
    }

    @Override // xi.i0
    public void b1(xi.l0<? super T> l0Var) {
        this.f34489a.c(new a(l0Var, this.f34490b, this.f34491c));
    }
}
