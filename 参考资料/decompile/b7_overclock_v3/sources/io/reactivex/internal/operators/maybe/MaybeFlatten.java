package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatten<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.w<? extends R>> f33876b;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4375739915521278546L;
        public final xi.t<? super R> downstream;
        public final dj.o<? super T, ? extends xi.w<? extends R>> mapper;
        public io.reactivex.disposables.b upstream;

        public final class a implements xi.t<R> {
            public a() {
            }

            @Override // xi.t
            public void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                FlatMapMaybeObserver.this.downstream.onError(th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, bVar);
            }

            @Override // xi.t
            public void onSuccess(R r10) {
                FlatMapMaybeObserver.this.downstream.onSuccess(r10);
            }
        }

        public FlatMapMaybeObserver(xi.t<? super R> tVar, dj.o<? super T, ? extends xi.w<? extends R>> oVar) {
            this.downstream = tVar;
            this.mapper = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
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
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                xi.w wVar = (xi.w) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                wVar.a(new a());
            } catch (Exception e10) {
                io.reactivex.exceptions.a.b(e10);
                this.downstream.onError(e10);
            }
        }
    }

    public MaybeFlatten(xi.w<T> wVar, dj.o<? super T, ? extends xi.w<? extends R>> oVar) {
        super(wVar);
        this.f33876b = oVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        this.f33914a.a(new FlatMapMaybeObserver(tVar, this.f33876b));
    }
}
