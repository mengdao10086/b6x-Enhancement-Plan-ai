package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableMergeWithCompletable<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.g f34242b;

    public static final class MergeWithObserver<T> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -4592979584110982903L;
        public final xi.g0<? super T> downstream;
        public volatile boolean mainDone;
        public volatile boolean otherDone;
        public final AtomicReference<io.reactivex.disposables.b> mainDisposable = new AtomicReference<>();
        public final OtherObserver otherObserver = new OtherObserver(this);
        public final AtomicThrowable error = new AtomicThrowable();

        public static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<?> parent;

            public OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
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

        public MergeWithObserver(xi.g0<? super T> g0Var) {
            this.downstream = g0Var;
        }

        public void a() {
            this.otherDone = true;
            if (this.mainDone) {
                io.reactivex.internal.util.g.b(this.downstream, this, this.error);
            }
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.util.g.d(this.downstream, th2, this, this.error);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // xi.g0
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                io.reactivex.internal.util.g.b(this.downstream, this, this.error);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.d(this.downstream, th2, this, this.error);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            io.reactivex.internal.util.g.f(this.downstream, t10, this, this.error);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }
    }

    public ObservableMergeWithCompletable(xi.z<T> zVar, xi.g gVar) {
        super(zVar);
        this.f34242b = gVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(g0Var);
        g0Var.onSubscribe(mergeWithObserver);
        this.f34421a.c(mergeWithObserver);
        this.f34242b.a(mergeWithObserver.otherObserver);
    }
}
