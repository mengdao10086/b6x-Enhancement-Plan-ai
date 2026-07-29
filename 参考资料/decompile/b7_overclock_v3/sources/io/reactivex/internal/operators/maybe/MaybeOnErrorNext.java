package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeOnErrorNext<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends xi.w<? extends T>> f33880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f33881c;

    public static final class OnErrorNextMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 2026620218879969836L;
        public final boolean allowFatal;
        public final xi.t<? super T> downstream;
        public final dj.o<? super Throwable, ? extends xi.w<? extends T>> resumeFunction;

        public static final class a<T> implements xi.t<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final xi.t<? super T> f33882a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference<io.reactivex.disposables.b> f33883b;

            public a(xi.t<? super T> tVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.f33882a = tVar;
                this.f33883b = atomicReference;
            }

            @Override // xi.t
            public void onComplete() {
                this.f33882a.onComplete();
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.f33882a.onError(th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.f33883b, bVar);
            }

            @Override // xi.t
            public void onSuccess(T t10) {
                this.f33882a.onSuccess(t10);
            }
        }

        public OnErrorNextMaybeObserver(xi.t<? super T> tVar, dj.o<? super Throwable, ? extends xi.w<? extends T>> oVar, boolean z10) {
            this.downstream = tVar;
            this.resumeFunction = oVar;
            this.allowFatal = z10;
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
            if (!this.allowFatal && !(th2 instanceof Exception)) {
                this.downstream.onError(th2);
                return;
            }
            try {
                xi.w wVar = (xi.w) io.reactivex.internal.functions.a.g(this.resumeFunction.apply(th2), "The resumeFunction returned a null MaybeSource");
                DisposableHelper.replace(this, null);
                wVar.a(new a(this.downstream, this));
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public MaybeOnErrorNext(xi.w<T> wVar, dj.o<? super Throwable, ? extends xi.w<? extends T>> oVar, boolean z10) {
        super(wVar);
        this.f33880b = oVar;
        this.f33881c = z10;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new OnErrorNextMaybeObserver(tVar, this.f33880b, this.f33881c));
    }
}
