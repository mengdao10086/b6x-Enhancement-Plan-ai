package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f35032b;

    public static final class a<T> implements l0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.a f35034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f35035c;

        public a(l0<? super T> l0Var, dj.a aVar) {
            this.f35033a = l0Var;
            this.f35034b = aVar;
        }

        public final void a() {
            try {
                this.f35034b.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f35035c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35035c.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35033a.onError(th2);
            a();
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f35035c, bVar)) {
                this.f35035c = bVar;
                this.f35033a.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f35033a.onSuccess(t10);
            a();
        }
    }

    public h(o0<T> o0Var, dj.a aVar) {
        this.f35031a = o0Var;
        this.f35032b = aVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35031a.a(new a(l0Var, this.f35032b));
    }
}
