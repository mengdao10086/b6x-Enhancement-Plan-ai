package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeCreate<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.u<T> f33835a;

    public static final class Emitter<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.s<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2467358622224974244L;
        public final xi.t<? super T> downstream;

        public Emitter(xi.t<? super T> tVar) {
            this.downstream = tVar;
        }

        @Override // xi.s
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

        @Override // xi.s
        public void b(dj.f fVar) {
            c(new CancellableDisposable(fVar));
        }

        @Override // xi.s
        public void c(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.s, io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.s
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

        @Override // xi.s
        public void onError(Throwable th2) {
            if (a(th2)) {
                return;
            }
            kj.a.Y(th2);
        }

        @Override // xi.s
        public void onSuccess(T t10) {
            io.reactivex.disposables.b andSet;
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return;
            }
            try {
                if (t10 == null) {
                    this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.downstream.onSuccess(t10);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th2) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th2;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", Emitter.class.getSimpleName(), super.toString());
        }
    }

    public MaybeCreate(xi.u<T> uVar) {
        this.f33835a = uVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        Emitter emitter = new Emitter(tVar);
        tVar.onSubscribe(emitter);
        try {
            this.f33835a.a(emitter);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            emitter.onError(th2);
        }
    }
}
