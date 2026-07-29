package kotlinx.coroutines.scheduling;

import al.d;
import al.i;
import al.j;
import al.m;
import al.p;
import hk.e;
import hk.v;
import ik.l;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.random.Random;
import kotlin.z1;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.r0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n90#2:1034\n90#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n87#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
public final class CoroutineScheduler implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final a f38957h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final AtomicLongFieldUpdater f38958i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final AtomicLongFieldUpdater f38959j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public static final AtomicIntegerFieldUpdater f38960k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @e
    @k
    public static final o0 f38961l = new o0("NOT_IN_STACK");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f38962m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f38963n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f38964o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f38965p = 21;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f38966q = 2097151;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f38967r = 4398044413952L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f38968s = 42;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f38969t = 9223367638808264704L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f38970u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f38971v = 2097150;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f38972w = 2097151;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f38973x = -2097152;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f38974y = 2097152;

    @v
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @e
    public final int f38975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @e
    public final int f38976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @e
    public final long f38977c;

    @v
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @e
    @k
    public final String f38978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @e
    @k
    public final d f38979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @e
    @k
    public final d f38980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @e
    @k
    public final j0<c> f38981g;

    @v
    private volatile long parkedWorkersStack;

    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38982a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f38982a = iArr;
        }
    }

    public CoroutineScheduler(int i10, int i11, long j10, @k String str) {
        this.f38975a = i10;
        this.f38976b = i11;
        this.f38977c = j10;
        this.f38978d = str;
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (!(i11 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f38979e = new d();
        this.f38980f = new d();
        this.f38981g = new j0<>((i10 + 1) * 2);
        this.controlState = ((long) i10) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ boolean u1(CoroutineScheduler coroutineScheduler, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f38959j.get(coroutineScheduler);
        }
        return coroutineScheduler.s1(j10);
    }

    public static /* synthetic */ void z(CoroutineScheduler coroutineScheduler, Runnable runnable, j jVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            jVar = m.f757i;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        coroutineScheduler.u(runnable, jVar, z10);
    }

    public final void F0(@k c cVar, int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38958i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int iW = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & f38973x;
            if (iW == i10) {
                iW = i11 == 0 ? W(cVar) : i11;
            }
            if (iW >= 0 && f38958i.compareAndSet(this, j10, j11 | ((long) iW))) {
                return;
            }
        }
    }

    public final long G0() {
        return f38959j.addAndGet(this, 4398046511104L);
    }

    public final int I() {
        return (int) ((f38959j.get(this) & f38969t) >> 42);
    }

    public final int L() {
        return (int) (f38959j.get(this) & 2097151);
    }

    public final long M() {
        return f38959j.addAndGet(this, 2097152L);
    }

    public final void M0(@k i iVar) {
        try {
            iVar.run();
        } catch (Throwable th2) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
                if (bVarB == null) {
                }
            } finally {
                kotlinx.coroutines.b bVarB2 = kotlinx.coroutines.c.b();
                if (bVarB2 != null) {
                    bVarB2.f();
                }
            }
        }
    }

    public final int P() {
        return (int) (f38959j.incrementAndGet(this) & 2097151);
    }

    public final void T(AtomicLongFieldUpdater atomicLongFieldUpdater, l<? super Long, z1> lVar, Object obj) {
        while (true) {
            lVar.i(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    public final int W(c cVar) {
        Object objJ = cVar.j();
        while (objJ != f38961l) {
            if (objJ == null) {
                return 0;
            }
            c cVar2 = (c) objJ;
            int i10 = cVar2.i();
            if (i10 != 0) {
                return i10;
            }
            objJ = cVar2.j();
        }
        return -1;
    }

    public final c Z() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38958i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVarB = this.f38981g.b((int) (2097151 & j10));
            if (cVarB == null) {
                return null;
            }
            long j11 = (2097152 + j10) & f38973x;
            int iW = W(cVarB);
            if (iW >= 0 && f38958i.compareAndSet(this, j10, ((long) iW) | j11)) {
                cVarB.w(f38961l);
                return cVarB;
            }
        }
    }

    public final boolean b0(@k c cVar) {
        long j10;
        long j11;
        int i10;
        if (cVar.j() != f38961l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38958i;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            j11 = (2097152 + j10) & f38973x;
            i10 = cVar.i();
            cVar.w(this.f38981g.b((int) (2097151 & j10)));
        } while (!f38958i.compareAndSet(this, j10, j11 | ((long) i10)));
        return true;
    }

    public final boolean c(i iVar) {
        return iVar.f746b.M0() == 1 ? this.f38980f.a(iVar) : this.f38979e.a(iVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        d1(10000L);
    }

    public final int d(long j10) {
        return (int) ((j10 & f38969t) >> 42);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d1(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.f38960k
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$c r0 = r7.l()
            kotlinx.coroutines.internal.j0<kotlinx.coroutines.scheduling.CoroutineScheduler$c> r1 = r7.f38981g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = a()     // Catch: java.lang.Throwable -> L87
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L87
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r4 = (int) r3
            monitor-exit(r1)
            if (r2 > r4) goto L49
            r1 = 1
        L23:
            kotlinx.coroutines.internal.j0<kotlinx.coroutines.scheduling.CoroutineScheduler$c> r3 = r7.f38981g
            java.lang.Object r3 = r3.b(r1)
            kotlin.jvm.internal.f0.m(r3)
            kotlinx.coroutines.scheduling.CoroutineScheduler$c r3 = (kotlinx.coroutines.scheduling.CoroutineScheduler.c) r3
            if (r3 == r0) goto L44
        L30:
            boolean r5 = r3.isAlive()
            if (r5 == 0) goto L3d
            java.util.concurrent.locks.LockSupport.unpark(r3)
            r3.join(r8)
            goto L30
        L3d:
            al.p r3 = r3.f38984a
            al.d r5 = r7.f38980f
            r3.g(r5)
        L44:
            if (r1 == r4) goto L49
            int r1 = r1 + 1
            goto L23
        L49:
            al.d r8 = r7.f38980f
            r8.b()
            al.d r8 = r7.f38979e
            r8.b()
        L53:
            if (r0 == 0) goto L5b
            al.i r8 = r0.h(r2)
            if (r8 != 0) goto L83
        L5b:
            al.d r8 = r7.f38979e
            java.lang.Object r8 = r8.h()
            al.i r8 = (al.i) r8
            if (r8 != 0) goto L83
            al.d r8 = r7.f38980f
            java.lang.Object r8 = r8.h()
            al.i r8 = (al.i) r8
            if (r8 != 0) goto L83
            if (r0 == 0) goto L76
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.z(r8)
        L76:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.f38958i
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.f38959j
            r8.set(r7, r0)
            return
        L83:
            r7.M0(r8)
            goto L53
        L87:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.d1(long):void");
    }

    @Override // java.util.concurrent.Executor
    public void execute(@k Runnable runnable) {
        z(this, runnable, null, false, 6, null);
    }

    public final int f(long j10) {
        return (int) ((j10 & f38967r) >> 21);
    }

    public final int h() {
        synchronized (this.f38981g) {
            if (isTerminated()) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f38959j;
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 & 2097151);
            int iU = qk.v.u(i10 - ((int) ((j10 & f38967r) >> 21)), 0);
            if (iU >= this.f38975a) {
                return 0;
            }
            if (i10 >= this.f38976b) {
                return 0;
            }
            int i11 = ((int) (f38959j.get(this) & 2097151)) + 1;
            if (!(i11 > 0 && this.f38981g.b(i11) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(this, i11);
            this.f38981g.c(i11, cVar);
            if (!(i11 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int i12 = iU + 1;
            cVar.start();
            return i12;
        }
    }

    public final void h1(long j10, boolean z10) {
        if (z10 || z1() || s1(j10)) {
            return;
        }
        z1();
    }

    @k
    public final i i(@k Runnable runnable, @k j jVar) {
        long jA = m.f754f.a();
        if (!(runnable instanceof i)) {
            return new al.l(runnable, jA, jVar);
        }
        i iVar = (i) runnable;
        iVar.f745a = jA;
        iVar.f746b = jVar;
        return iVar;
    }

    public final void i1() {
        if (z1() || u1(this, 0L, 1, null)) {
            return;
        }
        z1();
    }

    public final boolean isTerminated() {
        return f38960k.get(this) != 0;
    }

    public final int k(long j10) {
        return (int) (j10 & 2097151);
    }

    public final c l() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !f0.g(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    public final void m() {
        f38959j.addAndGet(this, f38973x);
    }

    public final i m1(c cVar, i iVar, boolean z10) {
        if (cVar == null || cVar.f38986c == WorkerState.TERMINATED) {
            return iVar;
        }
        if (iVar.f746b.M0() == 0 && cVar.f38986c == WorkerState.BLOCKING) {
            return iVar;
        }
        cVar.f38990g = true;
        return cVar.f38984a.a(iVar, z10);
    }

    public final int n() {
        return (int) (f38959j.getAndDecrement(this) & 2097151);
    }

    public final boolean p1() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38959j;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) ((f38969t & j10) >> 42)) == 0) {
                return false;
            }
        } while (!f38959j.compareAndSet(this, j10, j10 - 4398046511104L));
        return true;
    }

    public final boolean s1(long j10) {
        if (qk.v.u(((int) (2097151 & j10)) - ((int) ((j10 & f38967r) >> 21)), 0) < this.f38975a) {
            int iH = h();
            if (iH == 1 && this.f38975a > 1) {
                h();
            }
            if (iH > 0) {
                return true;
            }
        }
        return false;
    }

    @k
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f38981g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            c cVarB = this.f38981g.b(i15);
            if (cVarB != null) {
                int iF = cVarB.f38984a.f();
                int i16 = b.f38982a[cVarB.f38986c.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(iF);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (iF > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(iF);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = f38959j.get(this);
        return this.f38978d + '@' + r0.b(this) + "[Pool Size {core = " + this.f38975a + ", max = " + this.f38976b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f38979e.c() + ", global blocking queue size = " + this.f38980f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((f38967r & j10) >> 21)) + ", CPUs acquired = " + (this.f38975a - ((int) ((f38969t & j10) >> 42))) + "}]";
    }

    public final void u(@k Runnable runnable, @k j jVar, boolean z10) {
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        if (bVarB != null) {
            bVarB.e();
        }
        i iVarI = i(runnable, jVar);
        boolean z11 = false;
        boolean z12 = iVarI.f746b.M0() == 1;
        long jAddAndGet = z12 ? f38959j.addAndGet(this, 2097152L) : 0L;
        c cVarL = l();
        i iVarM1 = m1(cVarL, iVarI, z10);
        if (iVarM1 != null && !c(iVarM1)) {
            throw new RejectedExecutionException(this.f38978d + " was terminated");
        }
        if (z10 && cVarL != null) {
            z11 = true;
        }
        if (z12) {
            h1(jAddAndGet, z11);
        } else {
            if (z11) {
                return;
            }
            i1();
        }
    }

    public final boolean z1() {
        c cVarZ;
        do {
            cVarZ = Z();
            if (cVarZ == null) {
                return false;
            }
        } while (!c.m().compareAndSet(cVarZ, -1, 0));
        LockSupport.unpark(cVarZ);
        return true;
    }

    @t0({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n87#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @k
        public static final AtomicIntegerFieldUpdater f38983i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @e
        @k
        public final p f38984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public final Ref.ObjectRef<i> f38985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @e
        @k
        public WorkerState f38986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f38987d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f38988e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f38989f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @e
        public boolean f38990g;
        private volatile int indexInArray;

        @yt.l
        private volatile Object nextParkedWorker;

        @v
        private volatile int workerCtl;

        public c() {
            setDaemon(true);
            this.f38984a = new p();
            this.f38985b = new Ref.ObjectRef<>();
            this.f38986c = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f38961l;
            this.f38989f = Random.f38003a.o();
        }

        @k
        public static final AtomicIntegerFieldUpdater m() {
            return f38983i;
        }

        public final i A(int i10) {
            int i11 = (int) (CoroutineScheduler.f38959j.get(CoroutineScheduler.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int iQ = q(i11);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                iQ++;
                if (iQ > i11) {
                    iQ = 1;
                }
                c cVarB = coroutineScheduler.f38981g.b(iQ);
                if (cVarB != null && cVarB != this) {
                    long jP = cVarB.f38984a.p(i10, this.f38985b);
                    if (jP == -1) {
                        Ref.ObjectRef<i> objectRef = this.f38985b;
                        i iVar = objectRef.element;
                        objectRef.element = null;
                        return iVar;
                    }
                    if (jP > 0) {
                        jMin = Math.min(jMin, jP);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f38988e = jMin;
            return null;
        }

        public final void B() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f38981g) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (CoroutineScheduler.f38959j.get(coroutineScheduler) & 2097151)) <= coroutineScheduler.f38975a) {
                    return;
                }
                if (f38983i.compareAndSet(this, -1, 1)) {
                    int i10 = this.indexInArray;
                    v(0);
                    coroutineScheduler.F0(this, i10, 0);
                    int andDecrement = (int) (CoroutineScheduler.f38959j.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != i10) {
                        c cVarB = coroutineScheduler.f38981g.b(andDecrement);
                        f0.m(cVarB);
                        c cVar = cVarB;
                        coroutineScheduler.f38981g.c(i10, cVar);
                        cVar.v(i10);
                        coroutineScheduler.F0(cVar, andDecrement, i10);
                    }
                    coroutineScheduler.f38981g.c(andDecrement, null);
                    z1 z1Var = z1.f38230a;
                    this.f38986c = WorkerState.TERMINATED;
                }
            }
        }

        public final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            CoroutineScheduler.f38959j.addAndGet(CoroutineScheduler.this, CoroutineScheduler.f38973x);
            if (this.f38986c != WorkerState.TERMINATED) {
                this.f38986c = WorkerState.DORMANT;
            }
        }

        public final void c(int i10) {
            if (i10 != 0 && z(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.i1();
            }
        }

        public final void d(i iVar) {
            int iM0 = iVar.f746b.M0();
            n(iM0);
            c(iM0);
            CoroutineScheduler.this.M0(iVar);
            b(iM0);
        }

        public final i e(boolean z10) {
            i iVarS;
            i iVarS2;
            if (z10) {
                boolean z11 = q(CoroutineScheduler.this.f38975a * 2) == 0;
                if (z11 && (iVarS2 = s()) != null) {
                    return iVarS2;
                }
                i iVarH = this.f38984a.h();
                if (iVarH != null) {
                    return iVarH;
                }
                if (!z11 && (iVarS = s()) != null) {
                    return iVarS;
                }
            } else {
                i iVarS3 = s();
                if (iVarS3 != null) {
                    return iVarS3;
                }
            }
            return A(3);
        }

        public final i f() {
            i iVarI = this.f38984a.i();
            if (iVarI != null) {
                return iVarI;
            }
            i iVarH = CoroutineScheduler.this.f38980f.h();
            return iVarH == null ? A(1) : iVarH;
        }

        public final i g() {
            i iVarK = this.f38984a.k();
            if (iVarK != null) {
                return iVarK;
            }
            i iVarH = CoroutineScheduler.this.f38980f.h();
            return iVarH == null ? A(2) : iVarH;
        }

        @yt.l
        public final i h(boolean z10) {
            return x() ? e(z10) : f();
        }

        public final int i() {
            return this.indexInArray;
        }

        @yt.l
        public final Object j() {
            return this.nextParkedWorker;
        }

        @k
        public final CoroutineScheduler k() {
            return CoroutineScheduler.this;
        }

        public final int l() {
            return this.workerCtl;
        }

        public final void n(int i10) {
            this.f38987d = 0L;
            if (this.f38986c == WorkerState.PARKING) {
                this.f38986c = WorkerState.BLOCKING;
            }
        }

        public final boolean o() {
            return this.nextParkedWorker != CoroutineScheduler.f38961l;
        }

        public final boolean p() {
            return this.f38986c == WorkerState.BLOCKING;
        }

        public final int q(int i10) {
            int i11 = this.f38989f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f38989f = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void r() {
            if (this.f38987d == 0) {
                this.f38987d = System.nanoTime() + CoroutineScheduler.this.f38977c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f38977c);
            if (System.nanoTime() - this.f38987d >= 0) {
                this.f38987d = 0L;
                B();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            u();
        }

        public final i s() {
            if (q(2) == 0) {
                i iVarH = CoroutineScheduler.this.f38979e.h();
                return iVarH != null ? iVarH : CoroutineScheduler.this.f38980f.h();
            }
            i iVarH2 = CoroutineScheduler.this.f38980f.h();
            return iVarH2 != null ? iVarH2 : CoroutineScheduler.this.f38979e.h();
        }

        public final long t() {
            boolean z10 = this.f38986c == WorkerState.CPU_ACQUIRED;
            i iVarG = z10 ? g() : f();
            if (iVarG == null) {
                long j10 = this.f38988e;
                if (j10 == 0) {
                    return -1L;
                }
                return j10;
            }
            CoroutineScheduler.this.M0(iVarG);
            if (!z10) {
                CoroutineScheduler.f38959j.addAndGet(CoroutineScheduler.this, CoroutineScheduler.f38973x);
            }
            return 0L;
        }

        public final void u() {
            loop0: while (true) {
                boolean z10 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f38986c != WorkerState.TERMINATED) {
                    i iVarH = h(this.f38990g);
                    if (iVarH != null) {
                        this.f38988e = 0L;
                        d(iVarH);
                    } else {
                        this.f38990g = false;
                        if (this.f38988e == 0) {
                            y();
                        } else if (z10) {
                            z(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f38988e);
                            this.f38988e = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
                break loop0;
            }
            z(WorkerState.TERMINATED);
        }

        public final void v(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f38978d);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void w(@yt.l Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean x() {
            boolean z10;
            if (this.f38986c != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f38959j;
                while (true) {
                    long j10 = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((CoroutineScheduler.f38969t & j10) >> 42)) == 0) {
                        z10 = false;
                        break;
                    }
                    if (CoroutineScheduler.f38959j.compareAndSet(coroutineScheduler, j10, j10 - 4398046511104L)) {
                        z10 = true;
                        break;
                    }
                }
                if (!z10) {
                    return false;
                }
                this.f38986c = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        public final void y() {
            if (!o()) {
                CoroutineScheduler.this.b0(this);
                return;
            }
            f38983i.set(this, -1);
            while (o() && f38983i.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.f38986c != WorkerState.TERMINATED) {
                z(WorkerState.PARKING);
                Thread.interrupted();
                r();
            }
        }

        public final boolean z(@k WorkerState workerState) {
            WorkerState workerState2 = this.f38986c;
            boolean z10 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z10) {
                CoroutineScheduler.f38959j.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f38986c = workerState;
            }
            return z10;
        }

        public c(CoroutineScheduler coroutineScheduler, int i10) {
            this();
            v(i10);
        }
    }

    public /* synthetic */ CoroutineScheduler(int i10, int i11, long j10, String str, int i12, u uVar) {
        this(i10, i11, (i12 & 4) != 0 ? m.f753e : j10, (i12 & 8) != 0 ? m.f749a : str);
    }
}
