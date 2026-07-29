package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapCompletable<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.g> f33860b;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, xi.d, io.reactivex.disposables.b {
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
            DisposableHelper.replace(this, bVar);
        }

        @Override // xi.t
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

    public MaybeFlatMapCompletable(xi.w<T> wVar, dj.o<? super T, ? extends xi.g> oVar) {
        this.f33859a = wVar;
        this.f33860b = oVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(dVar, this.f33860b);
        dVar.onSubscribe(flatMapCompletableObserver);
        this.f33859a.a(flatMapCompletableObserver);
    }
}
