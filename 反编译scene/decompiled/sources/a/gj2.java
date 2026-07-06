package a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gj2 extends gf2 implements kj2, Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f6214a = AtomicIntegerFieldUpdater.newUpdater(gj2.class, "inFlightTasks");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f1022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ej2 f1023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1024a;
    public final int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ConcurrentLinkedQueue<Runnable> f1025a = new ConcurrentLinkedQueue<>();
    public volatile int inFlightTasks = 0;

    public gj2(ej2 ej2Var, int i, String str, int i2) {
        this.f1023a = ej2Var;
        this.f1022a = i;
        this.f1024a = str;
        this.b = i2;
    }

    @Override // a.kj2
    public int c() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        p(runnable, false);
    }

    @Override // a.kj2
    public void f() {
        Runnable runnablePoll = this.f1025a.poll();
        if (runnablePoll != null) {
            this.f1023a.t(runnablePoll, this, true);
            return;
        }
        f6214a.decrementAndGet(this);
        Runnable runnablePoll2 = this.f1025a.poll();
        if (runnablePoll2 != null) {
            p(runnablePoll2, true);
        }
    }

    @Override // a.od2
    public void l(l62 l62Var, Runnable runnable) {
        p(runnable, false);
    }

    public final void p(Runnable runnable, boolean z) {
        while (f6214a.incrementAndGet(this) > this.f1022a) {
            this.f1025a.add(runnable);
            if (f6214a.decrementAndGet(this) >= this.f1022a || (runnable = this.f1025a.poll()) == null) {
                return;
            }
        }
        this.f1023a.t(runnable, this, z);
    }

    @Override // a.od2
    public String toString() {
        String str = this.f1024a;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f1023a + ']';
    }
}
