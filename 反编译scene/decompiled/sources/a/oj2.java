package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oj2 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f2258a = AtomicReferenceFieldUpdater.newUpdater(oj2.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7030a = AtomicIntegerFieldUpdater.newUpdater(oj2.class, "producerIndex");
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(oj2.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(oj2.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReferenceArray<jj2> f2259a = new AtomicReferenceArray<>(128);
    public volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;
    public volatile int consumerIndex = 0;
    public volatile int blockingTasksInBuffer = 0;

    public static /* synthetic */ jj2 b(oj2 oj2Var, jj2 jj2Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oj2Var.a(jj2Var, z);
    }

    public final jj2 a(jj2 jj2Var, boolean z) {
        if (z) {
            return c(jj2Var);
        }
        jj2 jj2Var2 = (jj2) f2258a.getAndSet(this, jj2Var);
        if (jj2Var2 != null) {
            return c(jj2Var2);
        }
        return null;
    }

    public final jj2 c(jj2 jj2Var) {
        if (jj2Var.f1550a.c() == 1) {
            c.incrementAndGet(this);
        }
        if (e() == 127) {
            return jj2Var;
        }
        int i = this.producerIndex & 127;
        while (this.f2259a.get(i) != null) {
            Thread.yield();
        }
        this.f2259a.lazySet(i, jj2Var);
        f7030a.incrementAndGet(this);
        return null;
    }

    public final void d(jj2 jj2Var) {
        if (jj2Var != null) {
            if (jj2Var.f1550a.c() == 1) {
                int iDecrementAndGet = c.decrementAndGet(this);
                if (be2.a()) {
                    if (!(iDecrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(fj2 fj2Var) {
        jj2 jj2Var = (jj2) f2258a.getAndSet(this, null);
        if (jj2Var != null) {
            fj2Var.a(jj2Var);
        }
        while (j(fj2Var)) {
        }
    }

    public final jj2 h() {
        jj2 jj2Var = (jj2) f2258a.getAndSet(this, null);
        return jj2Var != null ? jj2Var : i();
    }

    public final jj2 i() {
        jj2 andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (b.compareAndSet(this, i, i + 1) && (andSet = this.f2259a.getAndSet(i2, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    public final boolean j(fj2 fj2Var) {
        jj2 jj2VarI = i();
        if (jj2VarI == null) {
            return false;
        }
        fj2Var.a(jj2VarI);
        return true;
    }

    public final long k(oj2 oj2Var) {
        if (be2.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i = oj2Var.producerIndex;
        AtomicReferenceArray<jj2> atomicReferenceArray = oj2Var.f2259a;
        for (int i2 = oj2Var.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (oj2Var.blockingTasksInBuffer == 0) {
                break;
            }
            jj2 jj2Var = atomicReferenceArray.get(i3);
            if (jj2Var != null) {
                if ((jj2Var.f1550a.c() == 1) && atomicReferenceArray.compareAndSet(i3, jj2Var, null)) {
                    c.decrementAndGet(oj2Var);
                    b(this, jj2Var, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(oj2Var, true);
    }

    public final long l(oj2 oj2Var) {
        if (be2.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        jj2 jj2VarI = oj2Var.i();
        if (jj2VarI == null) {
            return m(oj2Var, false);
        }
        jj2 jj2VarB = b(this, jj2VarI, false, 2, null);
        if (!be2.a()) {
            return -1L;
        }
        if (jj2VarB == null) {
            return -1L;
        }
        throw new AssertionError();
    }

    public final long m(oj2 oj2Var, boolean z) {
        jj2 jj2Var;
        do {
            jj2Var = (jj2) oj2Var.lastScheduledTask;
            if (jj2Var == null) {
                return -2L;
            }
            if (z) {
                if (!(jj2Var.f1550a.c() == 1)) {
                    return -2L;
                }
            }
            long jA = mj2.f1941a.a() - jj2Var.f6518a;
            long j = mj2.f1940a;
            if (jA < j) {
                return j - jA;
            }
        } while (!f2258a.compareAndSet(oj2Var, jj2Var, null));
        b(this, jj2Var, false, 2, null);
        return -1L;
    }
}
