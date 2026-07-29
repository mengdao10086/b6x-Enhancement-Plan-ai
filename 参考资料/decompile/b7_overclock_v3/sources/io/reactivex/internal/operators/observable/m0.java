package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class m0<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends T> f34602a;

    public static final class a<T> extends gj.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<? extends T> f34604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f34605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f34608f;

        public a(xi.g0<? super T> g0Var, Iterator<? extends T> it2) {
            this.f34603a = g0Var;
            this.f34604b = it2;
        }

        public void a() {
            while (!isDisposed()) {
                try {
                    this.f34603a.onNext(io.reactivex.internal.functions.a.g(this.f34604b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f34604b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f34603a.onComplete();
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.f34603a.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    this.f34603a.onError(th3);
                    return;
                }
            }
        }

        @Override // fj.o
        public void clear() {
            this.f34607e = true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34605c = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34605c;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f34607e;
        }

        @Override // fj.o
        @bj.f
        public T poll() {
            if (this.f34607e) {
                return null;
            }
            if (!this.f34608f) {
                this.f34608f = true;
            } else if (!this.f34604b.hasNext()) {
                this.f34607e = true;
                return null;
            }
            return (T) io.reactivex.internal.functions.a.g(this.f34604b.next(), "The iterator returned a null value");
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f34606d = true;
            return 1;
        }
    }

    public m0(Iterable<? extends T> iterable) {
        this.f34602a = iterable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        try {
            Iterator<? extends T> it2 = this.f34602a.iterator();
            try {
                if (!it2.hasNext()) {
                    EmptyDisposable.complete(g0Var);
                    return;
                }
                a aVar = new a(g0Var, it2);
                g0Var.onSubscribe(aVar);
                if (aVar.f34606d) {
                    return;
                }
                aVar.a();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, g0Var);
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptyDisposable.error(th3, g0Var);
        }
    }
}
