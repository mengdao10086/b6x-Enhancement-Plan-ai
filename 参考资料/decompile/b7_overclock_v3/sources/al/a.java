package al;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.internal.r0;
import kotlinx.coroutines.internal.t0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.y1;
import qk.v;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f725d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final CoroutineDispatcher f726e = n.f759c.k2(t0.e(e1.f38469a, v.u(64, r0.a()), 0, 0, 12, null));

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(@yt.k Runnable runnable) {
        h2(EmptyCoroutineContext.f37755a, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        f726e.h2(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @y1
    public void i2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        f726e.i2(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @s1
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        return n.f759c.k2(i10);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @yt.k
    public Executor m2() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        return "Dispatchers.IO";
    }
}
