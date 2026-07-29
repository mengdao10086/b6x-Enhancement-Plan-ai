package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublishSelector<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super xi.z<T>, ? extends xi.e0<R>> f34266b;

    public static final class TargetObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<R>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 854110278590336484L;
        public final xi.g0<? super R> downstream;
        public io.reactivex.disposables.b upstream;

        public TargetObserver(xi.g0<? super R> g0Var) {
            this.downstream = g0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class a<T, R> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PublishSubject<T> f34267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f34268b;

        public a(PublishSubject<T> publishSubject, AtomicReference<io.reactivex.disposables.b> atomicReference) {
            this.f34267a = publishSubject;
            this.f34268b = atomicReference;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34267a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34267a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34267a.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.f34268b, bVar);
        }
    }

    public ObservablePublishSelector(xi.e0<T> e0Var, dj.o<? super xi.z<T>, ? extends xi.e0<R>> oVar) {
        super(e0Var);
        this.f34266b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        PublishSubject publishSubjectO8 = PublishSubject.o8();
        try {
            xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.f34266b.apply(publishSubjectO8), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(g0Var);
            e0Var.c(targetObserver);
            this.f34421a.c(new a(publishSubjectO8, targetObserver));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
        }
    }
}
