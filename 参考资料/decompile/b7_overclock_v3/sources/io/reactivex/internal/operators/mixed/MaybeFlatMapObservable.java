package io.reactivex.internal.operators.mixed;

import dj.o;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.e0;
import xi.g0;
import xi.t;
import xi.w;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapObservable<T, R> extends z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w<T> f34062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends e0<? extends R>> f34063b;

    public static final class FlatMapObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements g0<R>, t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8948264376121066672L;
        public final g0<? super R> downstream;
        public final o<? super T, ? extends e0<? extends R>> mapper;

        public FlatMapObserver(g0<? super R> g0Var, o<? super T, ? extends e0<? extends R>> oVar) {
            this.downstream = g0Var;
            this.mapper = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                ((e0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null Publisher")).c(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public MaybeFlatMapObservable(w<T> wVar, o<? super T, ? extends e0<? extends R>> oVar) {
        this.f34062a = wVar;
        this.f34063b = oVar;
    }

    @Override // xi.z
    public void I5(g0<? super R> g0Var) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(g0Var, this.f34063b);
        g0Var.onSubscribe(flatMapObserver);
        this.f34062a.a(flatMapObserver);
    }
}
