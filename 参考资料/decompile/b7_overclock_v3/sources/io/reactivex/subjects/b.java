package io.reactivex.subjects;

import bj.f;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> extends c<T> implements a.InterfaceC0399a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<T> f35441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f35442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.reactivex.internal.util.a<Object> f35443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f35444d;

    public b(c<T> cVar) {
        this.f35441a = cVar;
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        this.f35441a.c(g0Var);
    }

    @Override // io.reactivex.internal.util.a.InterfaceC0399a, dj.r
    public boolean a(Object obj) {
        return NotificationLite.acceptFull(obj, this.f35441a);
    }

    @Override // io.reactivex.subjects.c
    @f
    public Throwable i8() {
        return this.f35441a.i8();
    }

    @Override // io.reactivex.subjects.c
    public boolean j8() {
        return this.f35441a.j8();
    }

    @Override // io.reactivex.subjects.c
    public boolean k8() {
        return this.f35441a.k8();
    }

    @Override // io.reactivex.subjects.c
    public boolean l8() {
        return this.f35441a.l8();
    }

    public void n8() {
        io.reactivex.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f35443c;
                if (aVar == null) {
                    this.f35442b = false;
                    return;
                }
                this.f35443c = null;
            }
            aVar.d(this);
        }
    }

    @Override // xi.g0
    public void onComplete() {
        if (this.f35444d) {
            return;
        }
        synchronized (this) {
            if (this.f35444d) {
                return;
            }
            this.f35444d = true;
            if (!this.f35442b) {
                this.f35442b = true;
                this.f35441a.onComplete();
                return;
            }
            io.reactivex.internal.util.a<Object> aVar = this.f35443c;
            if (aVar == null) {
                aVar = new io.reactivex.internal.util.a<>(4);
                this.f35443c = aVar;
            }
            aVar.c(NotificationLite.complete());
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        if (this.f35444d) {
            kj.a.Y(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f35444d) {
                this.f35444d = true;
                if (this.f35442b) {
                    io.reactivex.internal.util.a<Object> aVar = this.f35443c;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f35443c = aVar;
                    }
                    aVar.f(NotificationLite.error(th2));
                    return;
                }
                this.f35442b = true;
                z10 = false;
            }
            if (z10) {
                kj.a.Y(th2);
            } else {
                this.f35441a.onError(th2);
            }
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        if (this.f35444d) {
            return;
        }
        synchronized (this) {
            if (this.f35444d) {
                return;
            }
            if (!this.f35442b) {
                this.f35442b = true;
                this.f35441a.onNext(t10);
                n8();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f35443c;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f35443c = aVar;
                }
                aVar.c(NotificationLite.next(t10));
            }
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        boolean z10 = true;
        if (!this.f35444d) {
            synchronized (this) {
                if (!this.f35444d) {
                    if (this.f35442b) {
                        io.reactivex.internal.util.a<Object> aVar = this.f35443c;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.f35443c = aVar;
                        }
                        aVar.c(NotificationLite.disposable(bVar));
                        return;
                    }
                    this.f35442b = true;
                    z10 = false;
                }
            }
        }
        if (z10) {
            bVar.dispose();
        } else {
            this.f35441a.onSubscribe(bVar);
            n8();
        }
    }
}
