package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super T> f35027b;

    public static final class a<T> implements l0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.g<? super T> f35029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f35030c;

        public a(l0<? super T> l0Var, dj.g<? super T> gVar) {
            this.f35028a = l0Var;
            this.f35029b = gVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f35030c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35030c.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35028a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f35030c, bVar)) {
                this.f35030c = bVar;
                this.f35028a.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f35028a.onSuccess(t10);
            try {
                this.f35029b.accept(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }
    }

    public g(o0<T> o0Var, dj.g<? super T> gVar) {
        this.f35026a = o0Var;
        this.f35027b = gVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35026a.a(new a(l0Var, this.f35027b));
    }
}
