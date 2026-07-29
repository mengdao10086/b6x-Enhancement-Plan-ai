package io.reactivex.processors;

import bj.f;
import bu.d;
import bu.e;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<T> f35377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.reactivex.internal.util.a<Object> f35379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f35380e;

    public b(a<T> aVar) {
        this.f35377b = aVar;
    }

    @Override // io.reactivex.processors.a
    @f
    public Throwable M8() {
        return this.f35377b.M8();
    }

    @Override // io.reactivex.processors.a
    public boolean N8() {
        return this.f35377b.N8();
    }

    @Override // io.reactivex.processors.a
    public boolean O8() {
        return this.f35377b.O8();
    }

    @Override // io.reactivex.processors.a
    public boolean P8() {
        return this.f35377b.P8();
    }

    public void R8() {
        io.reactivex.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f35379d;
                if (aVar == null) {
                    this.f35378c = false;
                    return;
                }
                this.f35379d = null;
            }
            aVar.a(this.f35377b);
        }
    }

    @Override // xi.j
    public void k6(d<? super T> dVar) {
        this.f35377b.d(dVar);
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f35380e) {
            return;
        }
        synchronized (this) {
            if (this.f35380e) {
                return;
            }
            this.f35380e = true;
            if (!this.f35378c) {
                this.f35378c = true;
                this.f35377b.onComplete();
                return;
            }
            io.reactivex.internal.util.a<Object> aVar = this.f35379d;
            if (aVar == null) {
                aVar = new io.reactivex.internal.util.a<>(4);
                this.f35379d = aVar;
            }
            aVar.c(NotificationLite.complete());
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.f35380e) {
            kj.a.Y(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f35380e) {
                this.f35380e = true;
                if (this.f35378c) {
                    io.reactivex.internal.util.a<Object> aVar = this.f35379d;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f35379d = aVar;
                    }
                    aVar.f(NotificationLite.error(th2));
                    return;
                }
                this.f35378c = true;
                z10 = false;
            }
            if (z10) {
                kj.a.Y(th2);
            } else {
                this.f35377b.onError(th2);
            }
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.f35380e) {
            return;
        }
        synchronized (this) {
            if (this.f35380e) {
                return;
            }
            if (!this.f35378c) {
                this.f35378c = true;
                this.f35377b.onNext(t10);
                R8();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f35379d;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f35379d = aVar;
                }
                aVar.c(NotificationLite.next(t10));
            }
        }
    }

    @Override // bu.d
    public void onSubscribe(e eVar) {
        boolean z10 = true;
        if (!this.f35380e) {
            synchronized (this) {
                if (!this.f35380e) {
                    if (this.f35378c) {
                        io.reactivex.internal.util.a<Object> aVar = this.f35379d;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.f35379d = aVar;
                        }
                        aVar.c(NotificationLite.subscription(eVar));
                        return;
                    }
                    this.f35378c = true;
                    z10 = false;
                }
            }
        }
        if (z10) {
            eVar.cancel();
        } else {
            this.f35377b.onSubscribe(eVar);
            R8();
        }
    }
}
