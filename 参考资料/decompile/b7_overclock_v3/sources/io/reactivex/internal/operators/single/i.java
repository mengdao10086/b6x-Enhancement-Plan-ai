package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super Throwable> f35037b;

    public final class a implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35038a;

        public a(l0<? super T> l0Var) {
            this.f35038a = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            try {
                i.this.f35037b.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f35038a.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35038a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f35038a.onSuccess(t10);
        }
    }

    public i(o0<T> o0Var, dj.g<? super Throwable> gVar) {
        this.f35036a = o0Var;
        this.f35037b = gVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35036a.a(new a(l0Var));
    }
}
