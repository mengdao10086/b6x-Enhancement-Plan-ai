package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.c<? super T, ? super U, ? extends R> f34403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.e0<? extends U> f34404c;

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -312246233408980075L;
        public final dj.c<? super T, ? super U, ? extends R> combiner;
        public final xi.g0<? super R> downstream;
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        public final AtomicReference<io.reactivex.disposables.b> other = new AtomicReference<>();

        public WithLatestFromObserver(xi.g0<? super R> g0Var, dj.c<? super T, ? super U, ? extends R> cVar) {
            this.downstream = g0Var;
            this.combiner = cVar;
        }

        public void a(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th2);
        }

        public boolean b(io.reactivex.disposables.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // xi.g0
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            U u6 = get();
            if (u6 != null) {
                try {
                    this.downstream.onNext(io.reactivex.internal.functions.a.g(this.combiner.apply(t10, u6), "The combiner returned a null value"));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    dispose();
                    this.downstream.onError(th2);
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public final class a implements xi.g0<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WithLatestFromObserver<T, U, R> f34405a;

        public a(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.f34405a = withLatestFromObserver;
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34405a.a(th2);
        }

        @Override // xi.g0
        public void onNext(U u6) {
            this.f34405a.lazySet(u6);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34405a.b(bVar);
        }
    }

    public ObservableWithLatestFrom(xi.e0<T> e0Var, dj.c<? super T, ? super U, ? extends R> cVar, xi.e0<? extends U> e0Var2) {
        super(e0Var);
        this.f34403b = cVar;
        this.f34404c = e0Var2;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        io.reactivex.observers.l lVar = new io.reactivex.observers.l(g0Var);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(lVar, this.f34403b);
        lVar.onSubscribe(withLatestFromObserver);
        this.f34404c.c(new a(withLatestFromObserver));
        this.f34421a.c(withLatestFromObserver);
    }
}
