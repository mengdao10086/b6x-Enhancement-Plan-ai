package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.w<? extends U>> f33855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<? super T, ? super U, ? extends R> f33856c;

    public static final class FlatMapBiMainObserver<T, U, R> implements xi.t<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.w<? extends U>> f33857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InnerObserver<T, U, R> f33858b;

        public static final class InnerObserver<T, U, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            public final xi.t<? super R> downstream;
            public final dj.c<? super T, ? super U, ? extends R> resultSelector;
            public T value;

            public InnerObserver(xi.t<? super R> tVar, dj.c<? super T, ? super U, ? extends R> cVar) {
                this.downstream = tVar;
                this.resultSelector = cVar;
            }

            @Override // xi.t
            public void onComplete() {
                this.downstream.onComplete();
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.downstream.onError(th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.t
            public void onSuccess(U u6) {
                T t10 = this.value;
                this.value = null;
                try {
                    this.downstream.onSuccess(io.reactivex.internal.functions.a.g(this.resultSelector.apply(t10, u6), "The resultSelector returned a null value"));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.downstream.onError(th2);
                }
            }
        }

        public FlatMapBiMainObserver(xi.t<? super R> tVar, dj.o<? super T, ? extends xi.w<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar) {
            this.f33858b = new InnerObserver<>(tVar, cVar);
            this.f33857a = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.f33858b);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f33858b.get());
        }

        @Override // xi.t
        public void onComplete() {
            this.f33858b.downstream.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33858b.downstream.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this.f33858b, bVar)) {
                this.f33858b.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                xi.w wVar = (xi.w) io.reactivex.internal.functions.a.g(this.f33857a.apply(t10), "The mapper returned a null MaybeSource");
                if (DisposableHelper.replace(this.f33858b, null)) {
                    InnerObserver<T, U, R> innerObserver = this.f33858b;
                    innerObserver.value = t10;
                    wVar.a(innerObserver);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33858b.downstream.onError(th2);
            }
        }
    }

    public MaybeFlatMapBiSelector(xi.w<T> wVar, dj.o<? super T, ? extends xi.w<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar) {
        super(wVar);
        this.f33855b = oVar;
        this.f33856c = cVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        this.f33914a.a(new FlatMapBiMainObserver(tVar, this.f33855b, this.f33856c));
    }
}
