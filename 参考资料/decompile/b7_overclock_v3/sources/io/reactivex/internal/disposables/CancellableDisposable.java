package io.reactivex.internal.disposables;

import dj.f;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CancellableDisposable extends AtomicReference<f> implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        f andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e10) {
            a.b(e10);
            kj.a.Y(e10);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == null;
    }
}
