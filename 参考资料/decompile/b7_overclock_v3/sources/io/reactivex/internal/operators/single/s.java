package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class s<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f35073a;

    public static final class a<T> implements l0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f35075b;

        public a(l0<? super T> l0Var) {
            this.f35074a = l0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f35075b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35075b.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f35074a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f35075b, bVar)) {
                this.f35075b = bVar;
                this.f35074a.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f35074a.onSuccess(t10);
        }
    }

    public s(o0<? extends T> o0Var) {
        this.f35073a = o0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35073a.a(new a(l0Var));
    }
}
