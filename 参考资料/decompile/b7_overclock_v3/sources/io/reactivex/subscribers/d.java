package io.reactivex.subscribers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> implements o<T>, bu.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.d<? super T> f35455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bu.e f35456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35457c;

    public d(bu.d<? super T> dVar) {
        this.f35455a = dVar;
    }

    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f35455a.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f35455a.onError(nullPointerException);
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
        this.f35457c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f35455a.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f35455a.onError(nullPointerException);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(new CompositeException(nullPointerException, th3));
        }
    }

    @Override // bu.e
    public void cancel() {
        try {
            this.f35456b.cancel();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f35457c) {
            return;
        }
        this.f35457c = true;
        if (this.f35456b == null) {
            a();
            return;
        }
        try {
            this.f35455a.onComplete();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.f35457c) {
            kj.a.Y(th2);
            return;
        }
        this.f35457c = true;
        if (this.f35456b != null) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f35455a.onError(th2);
                return;
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                kj.a.Y(new CompositeException(th2, th3));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f35455a.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f35455a.onError(new CompositeException(th2, nullPointerException));
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                kj.a.Y(new CompositeException(th2, nullPointerException, th4));
            }
        } catch (Throwable th5) {
            io.reactivex.exceptions.a.b(th5);
            kj.a.Y(new CompositeException(th2, nullPointerException, th5));
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.f35457c) {
            return;
        }
        if (this.f35456b == null) {
            b();
            return;
        }
        if (t10 == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f35456b.cancel();
                onError(nullPointerException);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(new CompositeException(nullPointerException, th2));
                return;
            }
        }
        try {
            this.f35455a.onNext(t10);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            try {
                this.f35456b.cancel();
                onError(th3);
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                onError(new CompositeException(th3, th4));
            }
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(bu.e eVar) {
        if (SubscriptionHelper.validate(this.f35456b, eVar)) {
            this.f35456b = eVar;
            try {
                this.f35455a.onSubscribe(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35457c = true;
                try {
                    eVar.cancel();
                    kj.a.Y(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    kj.a.Y(new CompositeException(th2, th3));
                }
            }
        }
    }

    @Override // bu.e
    public void request(long j10) {
        try {
            this.f35456b.request(j10);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            try {
                this.f35456b.cancel();
                kj.a.Y(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                kj.a.Y(new CompositeException(th2, th3));
            }
        }
    }
}
