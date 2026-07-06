package a;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cj2 implements Executor, Closeable {
    public volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fj2 f416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReferenceArray<aj2> f418a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f419b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final fj2 f420b;
    public volatile long controlState;
    public volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final li2 f5802a = new li2("NOT_IN_STACK");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicLongFieldUpdater f413a = AtomicLongFieldUpdater.newUpdater(cj2.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(cj2.class, "controlState");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicIntegerFieldUpdater f412a = AtomicIntegerFieldUpdater.newUpdater(cj2.class, "_isTerminated");

    public cj2(int i, int i2, long j, String str) {
        this.f414a = i;
        this.f419b = i2;
        this.f415a = j;
        this.f417a = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + this.f414a + " should be at least 1").toString());
        }
        if (!(this.f419b >= this.f414a)) {
            throw new IllegalArgumentException(("Max pool size " + this.f419b + " should be greater than or equals to core pool size " + this.f414a).toString());
        }
        if (!(this.f419b <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + this.f419b + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(this.f415a > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + this.f415a + " must be positive").toString());
        }
        this.f416a = new fj2();
        this.f420b = new fj2();
        this.parkedWorkersStack = 0L;
        this.f418a = new AtomicReferenceArray<>(this.f419b + 1);
        this.controlState = ((long) this.f414a) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void g(cj2 cj2Var, Runnable runnable, kj2 kj2Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            kj2Var = ij2.f1377a;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        cj2Var.f(runnable, kj2Var, z);
    }

    public static /* synthetic */ boolean t(cj2 cj2Var, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cj2Var.controlState;
        }
        return cj2Var.s(j);
    }

    public final boolean b(jj2 jj2Var) {
        return (jj2Var.f1550a.c() == 1 ? this.f420b : this.f416a).a(jj2Var);
    }

    public final int c() {
        int i;
        synchronized (this.f418a) {
            if (i()) {
                i = -1;
            } else {
                long j = this.controlState;
                int i2 = (int) (j & 2097151);
                int iB = ga2.b(i2 - ((int) ((j & 4398044413952L) >> 21)), 0);
                if (iB >= this.f414a) {
                    return 0;
                }
                if (i2 >= this.f419b) {
                    return 0;
                }
                int i3 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i3 > 0 && this.f418a.get(i3) == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                aj2 aj2Var = new aj2(this, i3);
                this.f418a.set(i3, aj2Var);
                if (!(i3 == ((int) (2097151 & b.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                aj2Var.start();
                i = iB + 1;
            }
            return i;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        o(10000L);
    }

    public final jj2 d(Runnable runnable, kj2 kj2Var) {
        long jA = mj2.f1941a.a();
        if (!(runnable instanceof jj2)) {
            return new lj2(runnable, jA, kj2Var);
        }
        jj2 jj2Var = (jj2) runnable;
        jj2Var.f6518a = jA;
        jj2Var.f1550a = kj2Var;
        return jj2Var;
    }

    public final aj2 e() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof aj2)) {
            threadCurrentThread = null;
        }
        aj2 aj2Var = (aj2) threadCurrentThread;
        if (aj2Var == null || !f92.a(aj2Var.f80a, this)) {
            return null;
        }
        return aj2Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        g(this, runnable, null, false, 6, null);
    }

    public final void f(Runnable runnable, kj2 kj2Var, boolean z) {
        rg2 rg2VarA = sg2.a();
        if (rg2VarA != null) {
            rg2VarA.d();
        }
        jj2 jj2VarD = d(runnable, kj2Var);
        aj2 aj2VarE = e();
        jj2 jj2VarR = r(aj2VarE, jj2VarD, z);
        if (jj2VarR != null && !b(jj2VarR)) {
            throw new RejectedExecutionException(this.f417a + " was terminated");
        }
        boolean z2 = z && aj2VarE != null;
        if (jj2VarD.f1550a.c() != 0) {
            p(z2);
        } else {
            if (z2) {
                return;
            }
            q();
        }
    }

    public final int h() {
        return (int) (this.controlState & 2097151);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean i() {
        return this._isTerminated;
    }

    public final int j(aj2 aj2Var) {
        int iF;
        do {
            Object objG = aj2Var.g();
            if (objG == f5802a) {
                return -1;
            }
            if (objG == null) {
                return 0;
            }
            aj2Var = (aj2) objG;
            iF = aj2Var.f();
        } while (iF == 0);
        return iF;
    }

    public final aj2 k() {
        while (true) {
            long j = this.parkedWorkersStack;
            aj2 aj2Var = this.f418a.get((int) (2097151 & j));
            if (aj2Var == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int iJ = j(aj2Var);
            if (iJ >= 0 && f413a.compareAndSet(this, j, ((long) iJ) | j2)) {
                aj2Var.o(f5802a);
                return aj2Var;
            }
        }
    }

    public final boolean l(aj2 aj2Var) {
        long j;
        long j2;
        int iF;
        if (aj2Var.g() != f5802a) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (2097151 & j);
            j2 = (2097152 + j) & (-2097152);
            iF = aj2Var.f();
            if (be2.a()) {
                if (!(iF != 0)) {
                    throw new AssertionError();
                }
            }
            aj2Var.o(this.f418a.get(i));
        } while (!f413a.compareAndSet(this, j, ((long) iF) | j2));
        return true;
    }

    public final void m(aj2 aj2Var, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int iJ = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (iJ == i) {
                iJ = i2 == 0 ? j(aj2Var) : i2;
            }
            if (iJ >= 0 && f413a.compareAndSet(this, j, j2 | ((long) iJ))) {
                return;
            }
        }
    }

    public final void n(jj2 jj2Var) {
        try {
            jj2Var.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                rg2 rg2VarA = sg2.a();
                if (rg2VarA == null) {
                }
            } finally {
                rg2 rg2VarA2 = sg2.a();
                if (rg2VarA2 != null) {
                    rg2VarA2.f();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(long r9) throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a.cj2.f412a
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            a.aj2 r0 = r8.e()
            java.util.concurrent.atomic.AtomicReferenceArray<a.aj2> r3 = r8.f418a
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb5
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r3)
            if (r2 > r4) goto L5b
            r3 = r2
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<a.aj2> r5 = r8.f418a
            java.lang.Object r5 = r5.get(r3)
            a.f92.b(r5)
            a.aj2 r5 = (a.aj2) r5
            if (r5 == r0) goto L56
        L2a:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r5.join(r9)
            goto L2a
        L37:
            a.bj2 r6 = r5.f79a
            boolean r7 = a.be2.a()
            if (r7 == 0) goto L4f
            a.bj2 r7 = a.bj2.TERMINATED
            if (r6 != r7) goto L45
            r6 = r2
            goto L46
        L45:
            r6 = r1
        L46:
            if (r6 == 0) goto L49
            goto L4f
        L49:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L4f:
            a.oj2 r5 = r5.f81a
            a.fj2 r6 = r8.f420b
            r5.g(r6)
        L56:
            if (r3 == r4) goto L5b
            int r3 = r3 + 1
            goto L1d
        L5b:
            a.fj2 r9 = r8.f420b
            r9.b()
            a.fj2 r9 = r8.f416a
            r9.b()
        L65:
            if (r0 == 0) goto L6e
            a.jj2 r9 = r0.e(r2)
            if (r9 == 0) goto L6e
            goto L76
        L6e:
            a.fj2 r9 = r8.f416a
            java.lang.Object r9 = r9.d()
            a.jj2 r9 = (a.jj2) r9
        L76:
            if (r9 == 0) goto L79
            goto L81
        L79:
            a.fj2 r9 = r8.f420b
            java.lang.Object r9 = r9.d()
            a.jj2 r9 = (a.jj2) r9
        L81:
            if (r9 == 0) goto L87
            r8.n(r9)
            goto L65
        L87:
            if (r0 == 0) goto L8e
            a.bj2 r9 = a.bj2.TERMINATED
            r0.r(r9)
        L8e:
            boolean r9 = a.be2.a()
            if (r9 == 0) goto Lae
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r9 = (int) r9
            int r10 = r8.f414a
            if (r9 != r10) goto La5
            r1 = r2
        La5:
            if (r1 == 0) goto La8
            goto Lae
        La8:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        Lae:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lb5:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.cj2.o(long):void");
    }

    public final void p(boolean z) {
        long jAddAndGet = b.addAndGet(this, 2097152L);
        if (z || u() || s(jAddAndGet)) {
            return;
        }
        u();
    }

    public final void q() {
        if (u() || t(this, 0L, 1, null)) {
            return;
        }
        u();
    }

    public final jj2 r(aj2 aj2Var, jj2 jj2Var, boolean z) {
        if (aj2Var == null || aj2Var.f79a == bj2.TERMINATED) {
            return jj2Var;
        }
        if (jj2Var.f1550a.c() == 0 && aj2Var.f79a == bj2.BLOCKING) {
            return jj2Var;
        }
        aj2Var.f82b = true;
        return aj2Var.f81a.a(jj2Var, z);
    }

    public final boolean s(long j) {
        if (ga2.b(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f414a) {
            int iC = c();
            if (iC == 1 && this.f414a > 1) {
                c();
            }
            if (iC > 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        ArrayList arrayList = new ArrayList();
        int length = this.f418a.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            aj2 aj2Var = this.f418a.get(i6);
            if (aj2Var != null) {
                int iF = aj2Var.f81a.f();
                int i7 = zi2.f8075a[aj2Var.f79a.ordinal()];
                if (i7 != 1) {
                    if (i7 == 2) {
                        i2++;
                        sb = new StringBuilder();
                        sb.append(String.valueOf(iF));
                        str = "b";
                    } else if (i7 == 3) {
                        i++;
                        sb = new StringBuilder();
                        sb.append(String.valueOf(iF));
                        str = "c";
                    } else if (i7 == 4) {
                        i4++;
                        if (iF > 0) {
                            sb = new StringBuilder();
                            sb.append(String.valueOf(iF));
                            str = "d";
                        }
                    } else if (i7 == 5) {
                        i5++;
                    }
                    sb.append(str);
                    arrayList.add(sb.toString());
                } else {
                    i3++;
                }
            }
        }
        long j = this.controlState;
        return this.f417a + '@' + ce2.b(this) + "[Pool Size {core = " + this.f414a + ", max = " + this.f419b + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f416a.c() + ", global blocking queue size = " + this.f420b.c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f414a - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    public final boolean u() {
        aj2 aj2VarK;
        do {
            aj2VarK = k();
            if (aj2VarK == null) {
                return false;
            }
        } while (!aj2.f5614a.compareAndSet(aj2VarK, -1, 0));
        LockSupport.unpark(aj2VarK);
        return true;
    }
}
