package io.reactivex.internal.operators.single;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class q<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends T> f35066a;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f35068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f35069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f35070d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f35071e;

        public a(l0<? super T> l0Var) {
            this.f35067a = l0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f35071e = true;
            this.f35068b.cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35071e;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f35070d) {
                return;
            }
            this.f35070d = true;
            T t10 = this.f35069c;
            this.f35069c = null;
            if (t10 == null) {
                this.f35067a.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.f35067a.onSuccess(t10);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f35070d) {
                kj.a.Y(th2);
                return;
            }
            this.f35070d = true;
            this.f35069c = null;
            this.f35067a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f35070d) {
                return;
            }
            if (this.f35069c == null) {
                this.f35069c = t10;
                return;
            }
            this.f35068b.cancel();
            this.f35070d = true;
            this.f35069c = null;
            this.f35067a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f35068b, eVar)) {
                this.f35068b = eVar;
                this.f35067a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public q(bu.c<? extends T> cVar) {
        this.f35066a = cVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35066a.d(new a(l0Var));
    }
}
