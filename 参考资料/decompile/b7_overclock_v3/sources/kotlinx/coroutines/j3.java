package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class j3 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final j3 f38886c = new j3();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        n3 n3Var = (n3) coroutineContext.c(n3.f38912c);
        if (n3Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        n3Var.f38913b = true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean j2(@yt.k CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @s1
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
