package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapNotification<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.w<? extends R>> f33864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends xi.w<? extends R>> f33865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<? extends xi.w<? extends R>> f33866d;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4375739915521278546L;
        public final xi.t<? super R> downstream;
        public final Callable<? extends xi.w<? extends R>> onCompleteSupplier;
        public final dj.o<? super Throwable, ? extends xi.w<? extends R>> onErrorMapper;
        public final dj.o<? super T, ? extends xi.w<? extends R>> onSuccessMapper;
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

        public FlatMapMaybeObserver(xi.t<? super R> tVar, dj.o<? super T, ? extends xi.w<? extends R>> oVar, dj.o<? super Throwable, ? extends xi.w<? extends R>> oVar2, Callable<? extends xi.w<? extends R>> callable) {
            this.downstream = tVar;
            this.onSuccessMapper = oVar;
            this.onErrorMapper = oVar2;
            this.onCompleteSupplier = callable;
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
            try {
                ((xi.w) io.reactivex.internal.functions.a.g(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).a(new a());
            } catch (Exception e10) {
                io.reactivex.exceptions.a.b(e10);
                this.downstream.onError(e10);
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            try {
                ((xi.w) io.reactivex.internal.functions.a.g(this.onErrorMapper.apply(th2), "The onErrorMapper returned a null MaybeSource")).a(new a());
            } catch (Exception e10) {
                io.reactivex.exceptions.a.b(e10);
                this.downstream.onError(new CompositeException(th2, e10));
            }
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
                ((xi.w) io.reactivex.internal.functions.a.g(this.onSuccessMapper.apply(t10), "The onSuccessMapper returned a null MaybeSource")).a(new a());
            } catch (Exception e10) {
                io.reactivex.exceptions.a.b(e10);
                this.downstream.onError(e10);
            }
        }
    }

    public MaybeFlatMapNotification(xi.w<T> wVar, dj.o<? super T, ? extends xi.w<? extends R>> oVar, dj.o<? super Throwable, ? extends xi.w<? extends R>> oVar2, Callable<? extends xi.w<? extends R>> callable) {
        super(wVar);
        this.f33864b = oVar;
        this.f33865c = oVar2;
        this.f33866d = callable;
    }

    @Override // xi.q
    public void q1(xi.t<? super R> tVar) {
        this.f33914a.a(new FlatMapMaybeObserver(tVar, this.f33864b, this.f33865c, this.f33866d));
    }
}
