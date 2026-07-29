package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class x<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super bu.e> f33791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.q f33792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.a f33793e;

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.g<? super bu.e> f33795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.q f33796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final dj.a f33797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public bu.e f33798e;

        public a(bu.d<? super T> dVar, dj.g<? super bu.e> gVar, dj.q qVar, dj.a aVar) {
            this.f33794a = dVar;
            this.f33795b = gVar;
            this.f33797d = aVar;
            this.f33796c = qVar;
        }

        @Override // bu.e
        public void cancel() {
            bu.e eVar = this.f33798e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (eVar != subscriptionHelper) {
                this.f33798e = subscriptionHelper;
                try {
                    this.f33797d.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
                eVar.cancel();
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33798e != SubscriptionHelper.CANCELLED) {
                this.f33794a.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33798e != SubscriptionHelper.CANCELLED) {
                this.f33794a.onError(th2);
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33794a.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            try {
                this.f33795b.accept(eVar);
                if (SubscriptionHelper.validate(this.f33798e, eVar)) {
                    this.f33798e = eVar;
                    this.f33794a.onSubscribe(this);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                eVar.cancel();
                this.f33798e = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th2, this.f33794a);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            try {
                this.f33796c.a(j10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
            this.f33798e.request(j10);
        }
    }

    public x(xi.j<T> jVar, dj.g<? super bu.e> gVar, dj.q qVar, dj.a aVar) {
        super(jVar);
        this.f33791c = gVar;
        this.f33792d = qVar;
        this.f33793e = aVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar, this.f33791c, this.f33792d, this.f33793e));
    }
}
