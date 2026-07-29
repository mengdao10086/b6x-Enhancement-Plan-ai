package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class y<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f35085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends T> f35086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f35087c;

    public final class a implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35088a;

        public a(l0<? super T> l0Var) {
            this.f35088a = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            T tApply;
            y yVar = y.this;
            dj.o<? super Throwable, ? extends T> oVar = yVar.f35086b;
            if (oVar != null) {
                try {
                    tApply = oVar.apply(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    this.f35088a.onError(new CompositeException(th2, th3));
                    return;
                }
            } else {
                tApply = yVar.f35087c;
            }
            if (tApply != null) {
                this.f35088a.onSuccess(tApply);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
            nullPointerException.initCause(th2);
            this.f35088a.onError(nullPointerException);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35088a.onSubscribe(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f35088a.onSuccess(t10);
        }
    }

    public y(o0<? extends T> o0Var, dj.o<? super Throwable, ? extends T> oVar, T t10) {
        this.f35085a = o0Var;
        this.f35086b = oVar;
        this.f35087c = t10;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35085a.a(new a(l0Var));
    }
}
