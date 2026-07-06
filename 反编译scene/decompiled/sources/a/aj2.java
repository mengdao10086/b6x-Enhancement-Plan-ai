package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class aj2 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5614a = AtomicIntegerFieldUpdater.newUpdater(aj2.class, "workerCtl");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f77a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f78a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bj2 f79a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ cj2 f80a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final oj2 f81a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f82b;
    public volatile int indexInArray;
    public volatile Object nextParkedWorker;
    public volatile int workerCtl;

    public aj2(cj2 cj2Var) {
        this.f80a = cj2Var;
        setDaemon(true);
        this.f81a = new oj2();
        this.f79a = bj2.DORMANT;
        this.workerCtl = 0;
        this.nextParkedWorker = cj2.f5802a;
        this.f77a = z92.f8050a.b();
    }

    public aj2(cj2 cj2Var, int i) {
        this(cj2Var);
        n(i);
    }

    public final void a(int i) {
        if (i == 0) {
            return;
        }
        cj2.b.addAndGet(this.f80a, -2097152L);
        bj2 bj2Var = this.f79a;
        if (bj2Var != bj2.TERMINATED) {
            if (be2.a()) {
                if (!(bj2Var == bj2.BLOCKING)) {
                    throw new AssertionError();
                }
            }
            this.f79a = bj2.DORMANT;
        }
    }

    public final void b(int i) {
        if (i != 0 && r(bj2.BLOCKING)) {
            this.f80a.q();
        }
    }

    public final void c(jj2 jj2Var) {
        int iC = jj2Var.f1550a.c();
        h(iC);
        b(iC);
        this.f80a.n(jj2Var);
        a(iC);
    }

    public final jj2 d(boolean z) {
        jj2 jj2VarL;
        jj2 jj2VarL2;
        if (z) {
            boolean z2 = j(this.f80a.f414a * 2) == 0;
            if (z2 && (jj2VarL2 = l()) != null) {
                return jj2VarL2;
            }
            jj2 jj2VarH = this.f81a.h();
            if (jj2VarH != null) {
                return jj2VarH;
            }
            if (!z2 && (jj2VarL = l()) != null) {
                return jj2VarL;
            }
        } else {
            jj2 jj2VarL3 = l();
            if (jj2VarL3 != null) {
                return jj2VarL3;
            }
        }
        return s(false);
    }

    public final jj2 e(boolean z) {
        jj2 jj2VarD;
        if (p()) {
            return d(z);
        }
        if (!z || (jj2VarD = this.f81a.h()) == null) {
            jj2VarD = this.f80a.f420b.d();
        }
        return jj2VarD != null ? jj2VarD : s(true);
    }

    public final int f() {
        return this.indexInArray;
    }

    public final Object g() {
        return this.nextParkedWorker;
    }

    public final void h(int i) {
        this.f78a = 0L;
        if (this.f79a == bj2.PARKING) {
            if (be2.a()) {
                if (!(i == 1)) {
                    throw new AssertionError();
                }
            }
            this.f79a = bj2.BLOCKING;
        }
    }

    public final boolean i() {
        return this.nextParkedWorker != cj2.f5802a;
    }

    public final int j(int i) {
        int i2 = this.f77a;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.f77a = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
    }

    public final void k() {
        if (this.f78a == 0) {
            this.f78a = System.nanoTime() + this.f80a.f415a;
        }
        LockSupport.parkNanos(this.f80a.f415a);
        if (System.nanoTime() - this.f78a >= 0) {
            this.f78a = 0L;
            t();
        }
    }

    public final jj2 l() {
        fj2 fj2Var;
        if (j(2) == 0) {
            jj2 jj2VarD = this.f80a.f416a.d();
            if (jj2VarD != null) {
                return jj2VarD;
            }
            fj2Var = this.f80a.f420b;
        } else {
            jj2 jj2VarD2 = this.f80a.f420b.d();
            if (jj2VarD2 != null) {
                return jj2VarD2;
            }
            fj2Var = this.f80a.f416a;
        }
        return fj2Var.d();
    }

    public final void m() {
        loop0: while (true) {
            boolean z = false;
            while (!this.f80a.i() && this.f79a != bj2.TERMINATED) {
                jj2 jj2VarE = e(this.f82b);
                if (jj2VarE != null) {
                    this.b = 0L;
                    c(jj2VarE);
                } else {
                    this.f82b = false;
                    if (this.b == 0) {
                        q();
                    } else if (z) {
                        r(bj2.PARKING);
                        Thread.interrupted();
                        LockSupport.parkNanos(this.b);
                        this.b = 0L;
                    } else {
                        z = true;
                    }
                }
            }
            break loop0;
        }
        r(bj2.TERMINATED);
    }

    public final void n(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f80a.f417a);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void o(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean p() {
        boolean z;
        if (this.f79a != bj2.CPU_ACQUIRED) {
            cj2 cj2Var = this.f80a;
            while (true) {
                long j = cj2Var.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    z = false;
                    break;
                }
                if (cj2.b.compareAndSet(cj2Var, j, j - 4398046511104L)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.f79a = bj2.CPU_ACQUIRED;
        }
        return true;
    }

    public final void q() {
        if (!i()) {
            this.f80a.l(this);
            return;
        }
        if (be2.a()) {
            if (!(this.f81a.f() == 0)) {
                throw new AssertionError();
            }
        }
        this.workerCtl = -1;
        while (i() && !this.f80a.i() && this.f79a != bj2.TERMINATED) {
            r(bj2.PARKING);
            Thread.interrupted();
            k();
        }
    }

    public final boolean r(bj2 bj2Var) {
        bj2 bj2Var2 = this.f79a;
        boolean z = bj2Var2 == bj2.CPU_ACQUIRED;
        if (z) {
            cj2.b.addAndGet(this.f80a, 4398046511104L);
        }
        if (bj2Var2 != bj2Var) {
            this.f79a = bj2Var;
        }
        return z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        m();
    }

    public final jj2 s(boolean z) {
        if (be2.a()) {
            if (!(this.f81a.f() == 0)) {
                throw new AssertionError();
            }
        }
        int iH = this.f80a.h();
        if (iH < 2) {
            return null;
        }
        int iJ = j(iH);
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < iH; i++) {
            iJ++;
            if (iJ > iH) {
                iJ = 1;
            }
            aj2 aj2Var = this.f80a.f418a.get(iJ);
            if (aj2Var != null && aj2Var != this) {
                if (be2.a()) {
                    if (!(this.f81a.f() == 0)) {
                        throw new AssertionError();
                    }
                }
                oj2 oj2Var = this.f81a;
                oj2 oj2Var2 = aj2Var.f81a;
                long jK = z ? oj2Var.k(oj2Var2) : oj2Var.l(oj2Var2);
                if (jK == -1) {
                    return this.f81a.h();
                }
                if (jK > 0) {
                    jMin = Math.min(jMin, jK);
                }
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.b = jMin;
        return null;
    }

    public final void t() {
        synchronized (this.f80a.f418a) {
            if (this.f80a.i()) {
                return;
            }
            if (this.f80a.h() <= this.f80a.f414a) {
                return;
            }
            if (f5614a.compareAndSet(this, -1, 1)) {
                int i = this.indexInArray;
                n(0);
                this.f80a.m(this, i, 0);
                int andDecrement = (int) (cj2.b.getAndDecrement(this.f80a) & 2097151);
                if (andDecrement != i) {
                    aj2 aj2Var = this.f80a.f418a.get(andDecrement);
                    f92.b(aj2Var);
                    aj2 aj2Var2 = aj2Var;
                    this.f80a.f418a.set(i, aj2Var2);
                    aj2Var2.n(i);
                    this.f80a.m(aj2Var2, andDecrement, i);
                }
                this.f80a.f418a.set(andDecrement, null);
                m42 m42Var = m42.f6769a;
                this.f79a = bj2.TERMINATED;
            }
        }
    }
}
