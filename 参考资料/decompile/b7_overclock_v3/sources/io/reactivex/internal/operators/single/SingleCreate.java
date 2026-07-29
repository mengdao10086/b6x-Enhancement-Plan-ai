package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.k0;
import xi.l0;
import xi.m0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleCreate<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0<T> f34933a;

    public static final class Emitter<T> extends AtomicReference<io.reactivex.disposables.b> implements k0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2467358622224974244L;
        public final l0<? super T> downstream;

        public Emitter(l0<? super T> l0Var) {
            this.downstream = l0Var;
        }

        @Override // xi.k0
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

        @Override // xi.k0
        public void b(dj.f fVar) {
            c(new CancellableDisposable(fVar));
        }

        @Override // xi.k0
        public void c(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xi.k0, io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.k0
        public void onError(Throwable th2) {
            if (a(th2)) {
                return;
            }
            kj.a.Y(th2);
        }

        @Override // xi.k0
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

    public SingleCreate(m0<T> m0Var) {
        this.f34933a = m0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        Emitter emitter = new Emitter(l0Var);
        l0Var.onSubscribe(emitter);
        try {
            this.f34933a.a(emitter);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            emitter.onError(th2);
        }
    }
}
