package io.reactivex.internal.schedulers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements Future<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.disposables.b f35164a;

    public b(io.reactivex.disposables.b bVar) {
        this.f35164a = bVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        this.f35164a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
