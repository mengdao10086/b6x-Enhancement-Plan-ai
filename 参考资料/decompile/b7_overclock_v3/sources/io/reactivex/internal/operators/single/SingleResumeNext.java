package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleResumeNext<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f34968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends o0<? extends T>> f34969b;

    public static final class ResumeMainSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5314538511045349925L;
        public final l0<? super T> downstream;
        public final dj.o<? super Throwable, ? extends o0<? extends T>> nextFunction;

        public ResumeMainSingleObserver(l0<? super T> l0Var, dj.o<? super Throwable, ? extends o0<? extends T>> oVar) {
            this.downstream = l0Var;
            this.nextFunction = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            try {
                ((o0) io.reactivex.internal.functions.a.g(this.nextFunction.apply(th2), "The nextFunction returned a null SingleSource.")).a(new gj.o(this, this.downstream));
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public SingleResumeNext(o0<? extends T> o0Var, dj.o<? super Throwable, ? extends o0<? extends T>> oVar) {
        this.f34968a = o0Var;
        this.f34969b = oVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34968a.a(new ResumeMainSingleObserver(l0Var, this.f34969b));
    }
}
