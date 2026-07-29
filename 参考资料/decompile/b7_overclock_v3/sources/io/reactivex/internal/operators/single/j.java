package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class j<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.b<? super T, ? super Throwable> f35041b;

    public final class a implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35042a;

        public a(l0<? super T> l0Var) {
            this.f35042a = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            try {
                j.this.f35041b.a(null, th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f35042a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35042a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                j.this.f35041b.a(t10, null);
                this.f35042a.onSuccess(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35042a.onError(th2);
            }
        }
    }

    public j(o0<T> o0Var, dj.b<? super T, ? super Throwable> bVar) {
        this.f35040a = o0Var;
        this.f35041b = bVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35040a.a(new a(l0Var));
    }
}
