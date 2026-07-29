package io.reactivex.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> implements o<T>, bu.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f35458g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.d<? super T> f35459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f35460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bu.e f35461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public io.reactivex.internal.util.a<Object> f35463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f35464f;

    public e(bu.d<? super T> dVar) {
        this(dVar, false);
    }

    public void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f35463e;
                if (aVar == null) {
                    this.f35462d = false;
                    return;
                }
                this.f35463e = null;
            }
        } while (!aVar.a(this.f35459a));
    }

    @Override // bu.e
    public void cancel() {
        this.f35461c.cancel();
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f35464f) {
            return;
        }
        synchronized (this) {
            if (this.f35464f) {
                return;
            }
            if (!this.f35462d) {
                this.f35464f = true;
                this.f35462d = true;
                this.f35459a.onComplete();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f35463e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f35463e = aVar;
                }
                aVar.c(NotificationLite.complete());
            }
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.f35464f) {
            kj.a.Y(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f35464f) {
                if (this.f35462d) {
                    this.f35464f = true;
                    io.reactivex.internal.util.a<Object> aVar = this.f35463e;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f35463e = aVar;
                    }
                    Object objError = NotificationLite.error(th2);
                    if (this.f35460b) {
                        aVar.c(objError);
                    } else {
                        aVar.f(objError);
                    }
                    return;
                }
                this.f35464f = true;
                this.f35462d = true;
                z10 = false;
            }
            if (z10) {
                kj.a.Y(th2);
            } else {
                this.f35459a.onError(th2);
            }
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.f35464f) {
            return;
        }
        if (t10 == null) {
            this.f35461c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f35464f) {
                return;
            }
            if (!this.f35462d) {
                this.f35462d = true;
                this.f35459a.onNext(t10);
                a();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f35463e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f35463e = aVar;
                }
                aVar.c(NotificationLite.next(t10));
            }
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(bu.e eVar) {
        if (SubscriptionHelper.validate(this.f35461c, eVar)) {
            this.f35461c = eVar;
            this.f35459a.onSubscribe(this);
        }
    }

    @Override // bu.e
    public void request(long j10) {
        this.f35461c.request(j10);
    }

    public e(bu.d<? super T> dVar, boolean z10) {
        this.f35459a = dVar;
        this.f35460b = z10;
    }
}
