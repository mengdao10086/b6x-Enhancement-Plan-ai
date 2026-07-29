package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;

/* JADX INFO: loaded from: classes5.dex */
public final class s<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bu.d<? super T> f33741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33742b;

        public a(bu.d<? super T> dVar) {
            this.f33741a = dVar;
        }

        @Override // bu.e
        public void cancel() {
            bu.e eVar = this.f33742b;
            this.f33742b = EmptyComponent.INSTANCE;
            this.f33741a = EmptyComponent.asSubscriber();
            eVar.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            bu.d<? super T> dVar = this.f33741a;
            this.f33742b = EmptyComponent.INSTANCE;
            this.f33741a = EmptyComponent.asSubscriber();
            dVar.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            bu.d<? super T> dVar = this.f33741a;
            this.f33742b = EmptyComponent.INSTANCE;
            this.f33741a = EmptyComponent.asSubscriber();
            dVar.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33741a.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33742b, eVar)) {
                this.f33742b = eVar;
                this.f33741a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33742b.request(j10);
        }
    }

    public s(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar));
    }
}
