package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import xi.h0;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f35006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f35007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f35008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f35009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f35010e;

    public final class a implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SequentialDisposable f35011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l0<? super T> f35012b;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.single.d$a$a, reason: collision with other inner class name */
        public final class RunnableC0396a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f35014a;

            public RunnableC0396a(Throwable th2) {
                this.f35014a = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f35012b.onError(this.f35014a);
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f35016a;

            public b(T t10) {
                this.f35016a = t10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f35012b.onSuccess(this.f35016a);
            }
        }

        public a(SequentialDisposable sequentialDisposable, l0<? super T> l0Var) {
            this.f35011a = sequentialDisposable;
            this.f35012b = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            SequentialDisposable sequentialDisposable = this.f35011a;
            h0 h0Var = d.this.f35009d;
            RunnableC0396a runnableC0396a = new RunnableC0396a(th2);
            d dVar = d.this;
            sequentialDisposable.a(h0Var.g(runnableC0396a, dVar.f35010e ? dVar.f35007b : 0L, dVar.f35008c));
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f35011a.a(bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            SequentialDisposable sequentialDisposable = this.f35011a;
            h0 h0Var = d.this.f35009d;
            b bVar = new b(t10);
            d dVar = d.this;
            sequentialDisposable.a(h0Var.g(bVar, dVar.f35007b, dVar.f35008c));
        }
    }

    public d(o0<? extends T> o0Var, long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        this.f35006a = o0Var;
        this.f35007b = j10;
        this.f35008c = timeUnit;
        this.f35009d = h0Var;
        this.f35010e = z10;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        l0Var.onSubscribe(sequentialDisposable);
        this.f35006a.a(new a(sequentialDisposable, l0Var));
    }
}
