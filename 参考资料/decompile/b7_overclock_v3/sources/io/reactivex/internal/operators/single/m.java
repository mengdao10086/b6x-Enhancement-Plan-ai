package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class m<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f35054b;

    public final class a implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35055a;

        public a(l0<? super T> l0Var) {
            this.f35055a = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            try {
                m.this.f35054b.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f35055a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35055a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                m.this.f35054b.run();
                this.f35055a.onSuccess(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35055a.onError(th2);
            }
        }
    }

    public m(o0<T> o0Var, dj.a aVar) {
        this.f35053a = o0Var;
        this.f35054b = aVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35053a.a(new a(l0Var));
    }
}
