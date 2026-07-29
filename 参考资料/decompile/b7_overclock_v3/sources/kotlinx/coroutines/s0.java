package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.l1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,186:1\n1#2:187\n*E\n"})
public final class s0 extends l1 implements Runnable {

    @yt.l
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final s0 f38948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final String f38949j = "kotlinx.coroutines.DefaultExecutor";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f38950k = 1000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f38951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f38952m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f38953n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f38954o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f38955p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f38956q = 4;

    static {
        Long l10;
        s0 s0Var = new s0();
        f38948i = s0Var;
        k1.s2(s0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f38951l = timeUnit.toNanos(l10.longValue());
    }

    public static /* synthetic */ void S2() {
    }

    @Override // kotlinx.coroutines.m1
    public void A2(long j10, @yt.k l1.c cVar) {
        X2();
    }

    @Override // kotlinx.coroutines.l1
    public void F2(@yt.k Runnable runnable) {
        if (T2()) {
            X2();
        }
        super.F2(runnable);
    }

    public final synchronized void P2() {
        if (U2()) {
            debugStatus = 3;
            J2();
            kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread Q2() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, f38949j);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final synchronized void R2() {
        debugStatus = 0;
        Q2();
        while (debugStatus == 0) {
            kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        }
    }

    public final boolean T2() {
        return debugStatus == 4;
    }

    public final boolean U2() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    public final boolean V2() {
        return _thread != null;
    }

    public final synchronized boolean W2() {
        if (U2()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void X2() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void Y2(long j10) {
        kotlin.z1 z1Var;
        long jCurrentTimeMillis = System.currentTimeMillis() + j10;
        if (!U2()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                b bVarB = c.b();
                if (bVarB != null) {
                    bVarB.g(thread);
                    z1Var = kotlin.z1.f38230a;
                } else {
                    z1Var = null;
                }
                if (z1Var == null) {
                    LockSupport.unpark(thread);
                }
            }
            if (jCurrentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type java.lang.Object");
            wait(j10);
        }
        debugStatus = 0;
    }

    @Override // kotlinx.coroutines.l1, kotlinx.coroutines.w0
    @yt.k
    public g1 h1(long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext) {
        return M2(j10, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        kotlin.z1 z1Var;
        boolean zT2;
        e3.f38471a.d(this);
        b bVarB = c.b();
        if (bVarB != null) {
            bVarB.d();
        }
        try {
            if (!W2()) {
                if (zT2) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jW2 = w2();
                if (jW2 == Long.MAX_VALUE) {
                    b bVarB2 = c.b();
                    long jB = bVarB2 != null ? bVarB2.b() : System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f38951l + jB;
                    }
                    long j11 = j10 - jB;
                    if (j11 <= 0) {
                        _thread = null;
                        P2();
                        b bVarB3 = c.b();
                        if (bVarB3 != null) {
                            bVarB3.h();
                        }
                        if (t2()) {
                            return;
                        }
                        z2();
                        return;
                    }
                    jW2 = qk.v.C(jW2, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jW2 > 0) {
                    if (U2()) {
                        _thread = null;
                        P2();
                        b bVarB4 = c.b();
                        if (bVarB4 != null) {
                            bVarB4.h();
                        }
                        if (t2()) {
                            return;
                        }
                        z2();
                        return;
                    }
                    b bVarB5 = c.b();
                    if (bVarB5 != null) {
                        bVarB5.c(this, jW2);
                        z1Var = kotlin.z1.f38230a;
                    } else {
                        z1Var = null;
                    }
                    if (z1Var == null) {
                        LockSupport.parkNanos(this, jW2);
                    }
                }
            }
        } finally {
            _thread = null;
            P2();
            b bVarB6 = c.b();
            if (bVarB6 != null) {
                bVarB6.h();
            }
            if (!t2()) {
                z2();
            }
        }
    }

    @Override // kotlinx.coroutines.l1, kotlinx.coroutines.k1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.m1
    @yt.k
    public Thread z2() {
        Thread thread = _thread;
        return thread == null ? Q2() : thread;
    }
}
