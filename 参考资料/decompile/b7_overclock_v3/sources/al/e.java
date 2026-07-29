package al;

import hk.v;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends ExecutorCoroutineDispatcher implements j, Executor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f733i = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final c f734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public final String f736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final ConcurrentLinkedQueue<Runnable> f738h = new ConcurrentLinkedQueue<>();

    @v
    private volatile int inFlightTasks;

    public e(@yt.k c cVar, int i10, @yt.l String str, int i11) {
        this.f734d = cVar;
        this.f735e = i10;
        this.f736f = str;
        this.f737g = i11;
    }

    @Override // al.j
    public int M0() {
        return this.f737g;
    }

    @Override // al.j
    public void W() {
        Runnable runnablePoll = this.f738h.poll();
        if (runnablePoll != null) {
            this.f734d.q2(runnablePoll, this, true);
            return;
        }
        f733i.decrementAndGet(this);
        Runnable runnablePoll2 = this.f738h.poll();
        if (runnablePoll2 == null) {
            return;
        }
        n2(runnablePoll2, true);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(@yt.k Runnable runnable) {
        n2(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        n2(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void i2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        n2(runnable, true);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @yt.k
    public Executor m2() {
        return this;
    }

    public final void n2(Runnable runnable, boolean z10) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f733i;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f735e) {
                this.f734d.q2(runnable, this, z10);
                return;
            }
            this.f738h.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f735e) {
                return;
            } else {
                runnable = this.f738h.poll();
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        String str = this.f736f;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f734d + ']';
    }
}
