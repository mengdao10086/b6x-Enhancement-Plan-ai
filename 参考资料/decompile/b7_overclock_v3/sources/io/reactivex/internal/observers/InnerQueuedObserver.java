package io.reactivex.internal.observers;

import fj.o;
import gj.j;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.n;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<b> implements g0<T>, b {
    private static final long serialVersionUID = -5417183359794346637L;
    public volatile boolean done;
    public int fusionMode;
    public final j<T> parent;
    public final int prefetch;
    public o<T> queue;

    public InnerQueuedObserver(j<T> jVar, int i10) {
        this.parent = jVar;
        this.prefetch = i10;
    }

    public int a() {
        return this.fusionMode;
    }

    public boolean b() {
        return this.done;
    }

    public o<T> c() {
        return this.queue;
    }

    public void d() {
        this.done = true;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xi.g0
    public void onComplete() {
        this.parent.d(this);
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        this.parent.c(this, th2);
    }

    @Override // xi.g0
    public void onNext(T t10) {
        if (this.fusionMode == 0) {
            this.parent.f(this, t10);
        } else {
            this.parent.b();
        }
    }

    @Override // xi.g0
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof fj.j) {
                fj.j jVar = (fj.j) bVar;
                int iRequestFusion = jVar.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                    this.done = true;
                    this.parent.d(this);
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                    return;
                }
            }
            this.queue = n.c(-this.prefetch);
        }
    }
}
