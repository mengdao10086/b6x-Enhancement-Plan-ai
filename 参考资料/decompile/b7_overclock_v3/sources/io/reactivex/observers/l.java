package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T> implements g0<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f35301g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0<? super T> f35302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f35303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.reactivex.disposables.b f35304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public io.reactivex.internal.util.a<Object> f35306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f35307f;

    public l(@bj.e g0<? super T> g0Var) {
        this(g0Var, false);
    }

    public void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f35306e;
                if (aVar == null) {
                    this.f35305d = false;
                    return;
                }
                this.f35306e = null;
            }
        } while (!aVar.b(this.f35302a));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f35304c.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f35304c.isDisposed();
    }

    @Override // xi.g0
    public void onComplete() {
        if (this.f35307f) {
            return;
        }
        synchronized (this) {
            if (this.f35307f) {
                return;
            }
            if (!this.f35305d) {
                this.f35307f = true;
                this.f35305d = true;
                this.f35302a.onComplete();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f35306e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f35306e = aVar;
                }
                aVar.c(NotificationLite.complete());
            }
        }
    }

    @Override // xi.g0
    public void onError(@bj.e Throwable th2) {
        if (this.f35307f) {
            kj.a.Y(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f35307f) {
                if (this.f35305d) {
                    this.f35307f = true;
                    io.reactivex.internal.util.a<Object> aVar = this.f35306e;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f35306e = aVar;
                    }
                    Object objError = NotificationLite.error(th2);
                    if (this.f35303b) {
                        aVar.c(objError);
                    } else {
                        aVar.f(objError);
                    }
                    return;
                }
                this.f35307f = true;
                this.f35305d = true;
                z10 = false;
            }
            if (z10) {
                kj.a.Y(th2);
            } else {
                this.f35302a.onError(th2);
            }
        }
    }

    @Override // xi.g0
    public void onNext(@bj.e T t10) {
        if (this.f35307f) {
            return;
        }
        if (t10 == null) {
            this.f35304c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f35307f) {
                return;
            }
            if (!this.f35305d) {
                this.f35305d = true;
                this.f35302a.onNext(t10);
                a();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f35306e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f35306e = aVar;
                }
                aVar.c(NotificationLite.next(t10));
            }
        }
    }

    @Override // xi.g0
    public void onSubscribe(@bj.e io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f35304c, bVar)) {
            this.f35304c = bVar;
            this.f35302a.onSubscribe(this);
        }
    }

    public l(@bj.e g0<? super T> g0Var, boolean z10) {
        this.f35302a = g0Var;
        this.f35303b = z10;
    }
}
