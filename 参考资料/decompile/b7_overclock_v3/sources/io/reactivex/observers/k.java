package io.reactivex.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T> implements g0<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0<? super T> f35298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.reactivex.disposables.b f35299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35300c;

    public k(@bj.e g0<? super T> g0Var) {
        this.f35298a = g0Var;
    }

    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f35298a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f35298a.onError(nullPointerException);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(new CompositeException(nullPointerException, th3));
        }
    }

    public void b() {
        this.f35300c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f35298a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f35298a.onError(nullPointerException);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(new CompositeException(nullPointerException, th3));
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f35299b.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f35299b.isDisposed();
    }

    @Override // xi.g0
    public void onComplete() {
        if (this.f35300c) {
            return;
        }
        this.f35300c = true;
        if (this.f35299b == null) {
            a();
            return;
        }
        try {
            this.f35298a.onComplete();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }

    @Override // xi.g0
    public void onError(@bj.e Throwable th2) {
        if (this.f35300c) {
            kj.a.Y(th2);
            return;
        }
        this.f35300c = true;
        if (this.f35299b != null) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f35298a.onError(th2);
                return;
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                kj.a.Y(new CompositeException(th2, th3));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f35298a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f35298a.onError(new CompositeException(th2, nullPointerException));
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                kj.a.Y(new CompositeException(th2, nullPointerException, th4));
            }
        } catch (Throwable th5) {
            io.reactivex.exceptions.a.b(th5);
            kj.a.Y(new CompositeException(th2, nullPointerException, th5));
        }
    }

    @Override // xi.g0
    public void onNext(@bj.e T t10) {
        if (this.f35300c) {
            return;
        }
        if (this.f35299b == null) {
            b();
            return;
        }
        if (t10 == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f35299b.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(new CompositeException(nullPointerException, th2));
                return;
            }
        }
        try {
            this.f35298a.onNext(t10);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            try {
                this.f35299b.dispose();
                onError(th3);
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                onError(new CompositeException(th3, th4));
            }
        }
    }

    @Override // xi.g0
    public void onSubscribe(@bj.e io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f35299b, bVar)) {
            this.f35299b = bVar;
            try {
                this.f35298a.onSubscribe(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35300c = true;
                try {
                    bVar.dispose();
                    kj.a.Y(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    kj.a.Y(new CompositeException(th2, th3));
                }
            }
        }
    }
}
