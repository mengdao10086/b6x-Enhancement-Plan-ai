package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapSingleElement<T, R> extends xi.q<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends o0<? extends R>> f33873b;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4827726964688405508L;
        public final xi.t<? super R> downstream;
        public final dj.o<? super T, ? extends o0<? extends R>> mapper;

        public FlatMapMaybeObserver(xi.t<? super R> tVar, dj.o<? super T, ? extends o0<? extends R>> oVar) {
            this.downstream = tVar;
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
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                ((o0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null SingleSource")).a(new a(this, this.downstream));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }
    }

    public static final class a<R> implements l0<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f33874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.t<? super R> f33875b;

        public a(AtomicReference<io.reactivex.disposables.b> atomicReference, xi.t<? super R> tVar) {
            this.f33874a = atomicReference;
            this.f33875b = tVar;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f33875b.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f33874a, bVar);
        }

        @Override // xi.l0
        public void onSuccess(R r10) {
            this.f33875b.onSuccess(r10);
        }
    }

    public MaybeFlatMapSingleElement(xi.w<T> wVar, dj.o<? super T, ? extends o0<? extends R>> oVar) {
        this.f33872a = wVar;
        this.f33873b = oVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        this.f33872a.a(new FlatMapMaybeObserver(tVar, this.f33873b));
    }
}
