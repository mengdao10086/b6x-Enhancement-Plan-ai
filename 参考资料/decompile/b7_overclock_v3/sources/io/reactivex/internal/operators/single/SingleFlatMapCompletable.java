package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFlatMapCompletable<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.g> f34951b;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2177128922851101253L;
        public final xi.d downstream;
        public final dj.o<? super T, ? extends xi.g> mapper;

        public FlatMapCompletableObserver(xi.d dVar, dj.o<? super T, ? extends xi.g> oVar) {
            this.downstream = dVar;
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

        @Override // xi.d, xi.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                xi.g gVar = (xi.g) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null CompletableSource");
                if (isDisposed()) {
                    return;
                }
                gVar.a(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }
    }

    public SingleFlatMapCompletable(o0<T> o0Var, dj.o<? super T, ? extends xi.g> oVar) {
        this.f34950a = o0Var;
        this.f34951b = oVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(dVar, this.f34951b);
        dVar.onSubscribe(flatMapCompletableObserver);
        this.f34950a.a(flatMapCompletableObserver);
    }
}
