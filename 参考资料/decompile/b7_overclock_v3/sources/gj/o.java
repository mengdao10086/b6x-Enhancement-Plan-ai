package gj;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class o<T> implements l0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f29612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0<? super T> f29613b;

    public o(AtomicReference<io.reactivex.disposables.b> atomicReference, l0<? super T> l0Var) {
        this.f29612a = atomicReference;
        this.f29613b = l0Var;
    }

    @Override // xi.l0
    public void onError(Throwable th2) {
        this.f29613b.onError(th2);
    }

    @Override // xi.l0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.replace(this.f29612a, bVar);
    }

    @Override // xi.l0
    public void onSuccess(T t10) {
        this.f29613b.onSuccess(t10);
    }
}
