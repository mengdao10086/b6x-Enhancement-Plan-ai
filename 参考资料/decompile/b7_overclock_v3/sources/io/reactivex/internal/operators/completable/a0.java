package io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class a0<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends T> f33078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f33079c;

    public final class a implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f33080a;

        public a(l0<? super T> l0Var) {
            this.f33080a = l0Var;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            T tCall;
            a0 a0Var = a0.this;
            Callable<? extends T> callable = a0Var.f33078b;
            if (callable != null) {
                try {
                    tCall = callable.call();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f33080a.onError(th2);
                    return;
                }
            } else {
                tCall = a0Var.f33079c;
            }
            if (tCall == null) {
                this.f33080a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f33080a.onSuccess(tCall);
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.f33080a.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33080a.onSubscribe(bVar);
        }
    }

    public a0(xi.g gVar, Callable<? extends T> callable, T t10) {
        this.f33077a = gVar;
        this.f33079c = t10;
        this.f33078b = callable;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f33077a.a(new a(l0Var));
    }
}
