package io.reactivex.disposables;

import bj.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<b> f32975a;

    public d() {
        this.f32975a = new AtomicReference<>();
    }

    @f
    public b a() {
        b bVar = this.f32975a.get();
        return bVar == DisposableHelper.DISPOSED ? c.a() : bVar;
    }

    public boolean b(@f b bVar) {
        return DisposableHelper.replace(this.f32975a, bVar);
    }

    public boolean c(@f b bVar) {
        return DisposableHelper.set(this.f32975a, bVar);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.f32975a);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f32975a.get());
    }

    public d(@f b bVar) {
        this.f32975a = new AtomicReference<>(bVar);
    }
}
