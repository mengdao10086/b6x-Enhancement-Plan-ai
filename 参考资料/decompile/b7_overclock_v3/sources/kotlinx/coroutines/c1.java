package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class c1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final CoroutineDispatcher f38295a;

    public c1(@yt.k CoroutineDispatcher coroutineDispatcher) {
        this.f38295a = coroutineDispatcher;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@yt.k Runnable runnable) {
        CoroutineDispatcher coroutineDispatcher = this.f38295a;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f37755a;
        if (coroutineDispatcher.j2(emptyCoroutineContext)) {
            this.f38295a.h2(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    @yt.k
    public String toString() {
        return this.f38295a.toString();
    }
}
