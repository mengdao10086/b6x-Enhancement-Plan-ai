package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableTakeUntilCompletable extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.a f33062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.g f33063b;

    public static final class TakeUntilMainObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = 3533011714830024923L;
        public final xi.d downstream;
        public final OtherObserver other = new OtherObserver(this);
        public final AtomicBoolean once = new AtomicBoolean();

        public static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d {
            private static final long serialVersionUID = 5176264485428790318L;
            public final TakeUntilMainObserver parent;

            public OtherObserver(TakeUntilMainObserver takeUntilMainObserver) {
                this.parent = takeUntilMainObserver;
            }

            @Override // xi.d, xi.t
            public void onComplete() {
                this.parent.a();
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                this.parent.b(th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public TakeUntilMainObserver(xi.d dVar) {
            this.downstream = dVar;
        }

        public void a() {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                this.downstream.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (!this.once.compareAndSet(false, true)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this);
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                DisposableHelper.dispose(this.other);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.other);
                this.downstream.onComplete();
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            if (!this.once.compareAndSet(false, true)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this.other);
                this.downstream.onError(th2);
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public CompletableTakeUntilCompletable(xi.a aVar, xi.g gVar) {
        this.f33062a = aVar;
        this.f33063b = gVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(dVar);
        dVar.onSubscribe(takeUntilMainObserver);
        this.f33063b.a(takeUntilMainObserver.other);
        this.f33062a.a(takeUntilMainObserver);
    }
}
