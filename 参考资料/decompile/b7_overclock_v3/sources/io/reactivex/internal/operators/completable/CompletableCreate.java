package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableCreate extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e f33043a;

    public static final class Emitter extends AtomicReference<io.reactivex.disposables.b> implements xi.c, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2467358622224974244L;
        public final xi.d downstream;

        public Emitter(xi.d dVar) {
            this.downstream = dVar;
        }

        @Override // xi.c
        public boolean a(Throwable th2) {
            io.reactivex.disposables.b andSet;
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.downstream.onError(th2);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // xi.c
        public void b(dj.f fVar) {
            c(new CancellableDisposable(fVar));
        }

        @Override // xi.c
        public void c(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.c, io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.c
        public void onComplete() {
            io.reactivex.disposables.b andSet;
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // xi.c
        public void onError(Throwable th2) {
            if (a(th2)) {
                return;
            }
            kj.a.Y(th2);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", Emitter.class.getSimpleName(), super.toString());
        }
    }

    public CompletableCreate(xi.e eVar) {
        this.f33043a = eVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        Emitter emitter = new Emitter(dVar);
        dVar.onSubscribe(emitter);
        try {
            this.f33043a.a(emitter);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            emitter.onError(th2);
        }
    }
}
