package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFlatMapMaybe<T, R> extends xi.q<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f34958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.w<? extends R>> f34959b;

    public static final class FlatMapSingleObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5843758257109742742L;
        public final xi.t<? super R> downstream;
        public final dj.o<? super T, ? extends xi.w<? extends R>> mapper;

        public FlatMapSingleObserver(xi.t<? super R> tVar, dj.o<? super T, ? extends xi.w<? extends R>> oVar) {
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

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                xi.w wVar = (xi.w) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                wVar.a(new a(this, this.downstream));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }
    }

    public static final class a<R> implements xi.t<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f34960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.t<? super R> f34961b;

        public a(AtomicReference<io.reactivex.disposables.b> atomicReference, xi.t<? super R> tVar) {
            this.f34960a = atomicReference;
            this.f34961b = tVar;
        }

        @Override // xi.t
        public void onComplete() {
            this.f34961b.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f34961b.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f34960a, bVar);
        }

        @Override // xi.t
        public void onSuccess(R r10) {
            this.f34961b.onSuccess(r10);
        }
    }

    public SingleFlatMapMaybe(o0<? extends T> o0Var, dj.o<? super T, ? extends xi.w<? extends R>> oVar) {
        this.f34959b = oVar;
        this.f34958a = o0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        this.f34958a.a(new FlatMapSingleObserver(tVar, this.f34959b));
    }
}
