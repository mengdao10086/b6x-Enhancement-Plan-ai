package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class z<T> extends xi.i0<T> implements fj.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f33814c;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super T> f33815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f33817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f33818d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f33819e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f33820f;

        public a(xi.l0<? super T> l0Var, long j10, T t10) {
            this.f33815a = l0Var;
            this.f33816b = j10;
            this.f33817c = t10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33818d.cancel();
            this.f33818d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33818d == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33818d = SubscriptionHelper.CANCELLED;
            if (this.f33820f) {
                return;
            }
            this.f33820f = true;
            T t10 = this.f33817c;
            if (t10 != null) {
                this.f33815a.onSuccess(t10);
            } else {
                this.f33815a.onError(new NoSuchElementException());
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33820f) {
                kj.a.Y(th2);
                return;
            }
            this.f33820f = true;
            this.f33818d = SubscriptionHelper.CANCELLED;
            this.f33815a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33820f) {
                return;
            }
            long j10 = this.f33819e;
            if (j10 != this.f33816b) {
                this.f33819e = j10 + 1;
                return;
            }
            this.f33820f = true;
            this.f33818d.cancel();
            this.f33818d = SubscriptionHelper.CANCELLED;
            this.f33815a.onSuccess(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33818d, eVar)) {
                this.f33818d = eVar;
                this.f33815a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public z(xi.j<T> jVar, long j10, T t10) {
        this.f33812a = jVar;
        this.f33813b = j10;
        this.f33814c = t10;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super T> l0Var) {
        this.f33812a.j6(new a(l0Var, this.f33813b, this.f33814c));
    }

    @Override // fj.b
    public xi.j<T> d() {
        return kj.a.S(new FlowableElementAt(this.f33812a, this.f33813b, this.f33814c, true));
    }
}
