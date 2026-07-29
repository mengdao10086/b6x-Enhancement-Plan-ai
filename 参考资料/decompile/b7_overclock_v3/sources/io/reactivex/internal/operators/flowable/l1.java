package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class l1<T, U, V> extends io.reactivex.internal.operators.flowable.a<T, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterable<U> f33683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.c<? super T, ? super U, ? extends V> f33684d;

    public static final class a<T, U, V> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super V> f33685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<U> f33686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.c<? super T, ? super U, ? extends V> f33687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f33688d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f33689e;

        public a(bu.d<? super V> dVar, Iterator<U> it2, dj.c<? super T, ? super U, ? extends V> cVar) {
            this.f33685a = dVar;
            this.f33686b = it2;
            this.f33687c = cVar;
        }

        public void a(Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            this.f33689e = true;
            this.f33688d.cancel();
            this.f33685a.onError(th2);
        }

        @Override // bu.e
        public void cancel() {
            this.f33688d.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33689e) {
                return;
            }
            this.f33689e = true;
            this.f33685a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33689e) {
                kj.a.Y(th2);
            } else {
                this.f33689e = true;
                this.f33685a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33689e) {
                return;
            }
            try {
                try {
                    this.f33685a.onNext(io.reactivex.internal.functions.a.g(this.f33687c.apply(t10, io.reactivex.internal.functions.a.g(this.f33686b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f33686b.hasNext()) {
                            return;
                        }
                        this.f33689e = true;
                        this.f33688d.cancel();
                        this.f33685a.onComplete();
                    } catch (Throwable th2) {
                        a(th2);
                    }
                } catch (Throwable th3) {
                    a(th3);
                }
            } catch (Throwable th4) {
                a(th4);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33688d, eVar)) {
                this.f33688d = eVar;
                this.f33685a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33688d.request(j10);
        }
    }

    public l1(xi.j<T> jVar, Iterable<U> iterable, dj.c<? super T, ? super U, ? extends V> cVar) {
        super(jVar);
        this.f33683c = iterable;
        this.f33684d = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super V> dVar) {
        try {
            Iterator it2 = (Iterator) io.reactivex.internal.functions.a.g(this.f33683c.iterator(), "The iterator returned by other is null");
            try {
                if (it2.hasNext()) {
                    this.f33524b.j6(new a(dVar, it2, this.f33684d));
                } else {
                    EmptySubscription.complete(dVar);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptySubscription.error(th2, dVar);
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptySubscription.error(th3, dVar);
        }
    }
}
