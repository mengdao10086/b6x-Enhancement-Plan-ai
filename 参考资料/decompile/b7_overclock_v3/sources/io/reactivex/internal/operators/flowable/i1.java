package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class i1<T, U extends Collection<? super T>> extends xi.i0<U> implements fj.b<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<U> f33625b;

    public static final class a<T, U extends Collection<? super T>> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super U> f33626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public U f33628c;

        public a(xi.l0<? super U> l0Var, U u6) {
            this.f33626a = l0Var;
            this.f33628c = u6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33627b.cancel();
            this.f33627b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33627b == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33627b = SubscriptionHelper.CANCELLED;
            this.f33626a.onSuccess(this.f33628c);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33628c = null;
            this.f33627b = SubscriptionHelper.CANCELLED;
            this.f33626a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33628c.add(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33627b, eVar)) {
                this.f33627b = eVar;
                this.f33626a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public i1(xi.j<T> jVar) {
        this(jVar, ArrayListSupplier.asCallable());
    }

    @Override // xi.i0
    public void b1(xi.l0<? super U> l0Var) {
        try {
            this.f33624a.j6(new a(l0Var, (Collection) io.reactivex.internal.functions.a.g(this.f33625b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, l0Var);
        }
    }

    @Override // fj.b
    public xi.j<U> d() {
        return kj.a.S(new FlowableToList(this.f33624a, this.f33625b));
    }

    public i1(xi.j<T> jVar, Callable<U> callable) {
        this.f33624a = jVar;
        this.f33625b = callable;
    }
}
