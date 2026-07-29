package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class z1<T, U, V> extends xi.z<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.z<? extends T> f34815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<U> f34816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<? super T, ? super U, ? extends V> f34817c;

    public static final class a<T, U, V> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super V> f34818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<U> f34819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.c<? super T, ? super U, ? extends V> f34820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f34821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34822e;

        public a(xi.g0<? super V> g0Var, Iterator<U> it2, dj.c<? super T, ? super U, ? extends V> cVar) {
            this.f34818a = g0Var;
            this.f34819b = it2;
            this.f34820c = cVar;
        }

        public void a(Throwable th2) {
            this.f34822e = true;
            this.f34821d.dispose();
            this.f34818a.onError(th2);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34821d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34821d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34822e) {
                return;
            }
            this.f34822e = true;
            this.f34818a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34822e) {
                kj.a.Y(th2);
            } else {
                this.f34822e = true;
                this.f34818a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34822e) {
                return;
            }
            try {
                try {
                    this.f34818a.onNext(io.reactivex.internal.functions.a.g(this.f34820c.apply(t10, io.reactivex.internal.functions.a.g(this.f34819b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f34819b.hasNext()) {
                            return;
                        }
                        this.f34822e = true;
                        this.f34821d.dispose();
                        this.f34818a.onComplete();
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        a(th2);
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    a(th3);
                }
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                a(th4);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34821d, bVar)) {
                this.f34821d = bVar;
                this.f34818a.onSubscribe(this);
            }
        }
    }

    public z1(xi.z<? extends T> zVar, Iterable<U> iterable, dj.c<? super T, ? super U, ? extends V> cVar) {
        this.f34815a = zVar;
        this.f34816b = iterable;
        this.f34817c = cVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super V> g0Var) {
        try {
            Iterator it2 = (Iterator) io.reactivex.internal.functions.a.g(this.f34816b.iterator(), "The iterator returned by other is null");
            try {
                if (it2.hasNext()) {
                    this.f34815a.c(new a(g0Var, it2, this.f34817c));
                } else {
                    EmptyDisposable.complete(g0Var);
                }
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
