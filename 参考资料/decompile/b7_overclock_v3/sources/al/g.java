package al;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: classes5.dex */
public class g extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final String f743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public CoroutineScheduler f744h;

    public g() {
        this(0, 0, 0L, null, 15, null);
    }

    public /* synthetic */ g(int i10, int i11, long j10, String str, int i12, u uVar) {
        this((i12 & 1) != 0 ? m.f751c : i10, (i12 & 2) != 0 ? m.f752d : i11, (i12 & 4) != 0 ? m.f753e : j10, (i12 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        this.f744h.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        CoroutineScheduler.z(this.f744h, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void i2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        CoroutineScheduler.z(this.f744h, runnable, null, true, 2, null);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @yt.k
    public Executor m2() {
        return this.f744h;
    }

    public final CoroutineScheduler n2() {
        return new CoroutineScheduler(this.f740d, this.f741e, this.f742f, this.f743g);
    }

    public final void o2(@yt.k Runnable runnable, @yt.k j jVar, boolean z10) {
        this.f744h.u(runnable, jVar, z10);
    }

    public final void p2() {
        r2();
    }

    public final synchronized void q2(long j10) {
        this.f744h.d1(j10);
    }

    public final synchronized void r2() {
        this.f744h.d1(1000L);
        this.f744h = n2();
    }

    public g(int i10, int i11, long j10, @yt.k String str) {
        this.f740d = i10;
        this.f741e = i11;
        this.f742f = j10;
        this.f743g = str;
        this.f744h = n2();
    }
}
