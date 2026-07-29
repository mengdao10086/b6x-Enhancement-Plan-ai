package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class z<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33151a;

    public static final class a extends gj.b<Void> implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0<?> f33152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f33153b;

        public a(g0<?> g0Var) {
            this.f33152a = g0Var;
        }

        @Override // fj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void poll() throws Exception {
            return null;
        }

        @Override // fj.o
        public void clear() {
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33153b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33153b.isDisposed();
        }

        @Override // fj.o
        public boolean isEmpty() {
            return true;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.f33152a.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.f33152a.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33153b, bVar)) {
                this.f33153b = bVar;
                this.f33152a.onSubscribe(this);
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return i10 & 2;
        }
    }

    public z(xi.g gVar) {
        this.f33151a = gVar;
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        this.f33151a.a(new a(g0Var));
    }
}
