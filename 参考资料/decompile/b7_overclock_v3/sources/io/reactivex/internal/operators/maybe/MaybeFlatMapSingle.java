package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapSingle<T, R> extends xi.i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends o0<? extends R>> f33869b;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4827726964688405508L;
        public final l0<? super R> downstream;
        public final dj.o<? super T, ? extends o0<? extends R>> mapper;

        public FlatMapMaybeObserver(l0<? super R> l0Var, dj.o<? super T, ? extends o0<? extends R>> oVar) {
            this.downstream = l0Var;
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
            this.downstream.onError(new NoSuchElementException());
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
                o0 o0Var = (o0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null SingleSource");
                if (isDisposed()) {
                    return;
                }
                o0Var.a(new a(this, this.downstream));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }
    }

    public static final class a<R> implements l0<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f33870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l0<? super R> f33871b;

        public a(AtomicReference<io.reactivex.disposables.b> atomicReference, l0<? super R> l0Var) {
            this.f33870a = atomicReference;
            this.f33871b = l0Var;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f33871b.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f33870a, bVar);
        }

        @Override // xi.l0
        public void onSuccess(R r10) {
            this.f33871b.onSuccess(r10);
        }
    }

    public MaybeFlatMapSingle(xi.w<T> wVar, dj.o<? super T, ? extends o0<? extends R>> oVar) {
        this.f33868a = wVar;
        this.f33869b = oVar;
    }

    @Override // xi.i0
    public void b1(l0<? super R> l0Var) {
        this.f33868a.a(new FlatMapMaybeObserver(l0Var, this.f33869b));
    }
}
