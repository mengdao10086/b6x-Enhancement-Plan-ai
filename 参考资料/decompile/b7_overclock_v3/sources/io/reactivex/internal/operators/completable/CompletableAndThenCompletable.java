package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableAndThenCompletable extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.g f33028b;

    public static final class SourceObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = -4101678820158072998L;
        public final xi.d actualObserver;
        public final xi.g next;

        public SourceObserver(xi.d dVar, xi.g gVar) {
            this.actualObserver = dVar;
            this.next = gVar;
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
            this.next.a(new a(this, this.actualObserver));
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.actualObserver.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actualObserver.onSubscribe(this);
            }
        }
    }

    public static final class a implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f33029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.d f33030b;

        public a(AtomicReference<io.reactivex.disposables.b> atomicReference, xi.d dVar) {
            this.f33029a = atomicReference;
            this.f33030b = dVar;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.f33030b.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.f33030b.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f33029a, bVar);
        }
    }

    public CompletableAndThenCompletable(xi.g gVar, xi.g gVar2) {
        this.f33027a = gVar;
        this.f33028b = gVar2;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33027a.a(new SourceObserver(dVar, this.f33028b));
    }
}
