package io.reactivex.internal.observers;

import dj.a;
import dj.g;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.f;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class LambdaObserver<T> extends AtomicReference<b> implements g0<T>, b, f {
    private static final long serialVersionUID = -7251123623727029452L;
    public final a onComplete;
    public final g<? super Throwable> onError;
    public final g<? super T> onNext;
    public final g<? super b> onSubscribe;

    public LambdaObserver(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super b> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // io.reactivex.observers.f
    public boolean a() {
        return this.onError != Functions.f32984f;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // xi.g0
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        if (isDisposed()) {
            kj.a.Y(th2);
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            kj.a.Y(new CompositeException(th2, th3));
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t10);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            get().dispose();
            onError(th2);
        }
    }

    @Override // xi.g0
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                bVar.dispose();
                onError(th2);
            }
        }
    }
}
