package a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class de2 extends af2 implements Runnable {
    public static volatile Thread _thread;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final de2 f5890a;
    public static final long b;
    public static volatile int debugStatus;

    static {
        Long l;
        de2 de2Var = new de2();
        f5890a = de2Var;
        ve2.B(de2Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        b = timeUnit.toNanos(l.longValue());
    }

    @Override // a.bf2
    public Thread I() {
        Thread thread = _thread;
        return thread != null ? thread : a0();
    }

    public final synchronized void Z() {
        if (b0()) {
            debugStatus = 3;
            T();
            notifyAll();
        }
    }

    public final synchronized Thread a0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean b0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public final synchronized boolean c0() {
        if (b0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // a.af2, a.je2
    public re2 e(long j, Runnable runnable) {
        return W(j, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zR;
        qg2.f7212a.d(this);
        rg2 rg2VarA = sg2.a();
        if (rg2VarA != null) {
            rg2VarA.g();
        }
        try {
            if (!c0()) {
                if (zR) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jE = E();
                if (jE == Long.MAX_VALUE) {
                    rg2 rg2VarA2 = sg2.a();
                    long jA = rg2VarA2 != null ? rg2VarA2.a() : System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = b + jA;
                    }
                    long j2 = j - jA;
                    if (j2 <= 0) {
                        _thread = null;
                        Z();
                        rg2 rg2VarA3 = sg2.a();
                        if (rg2VarA3 != null) {
                            rg2VarA3.e();
                        }
                        if (R()) {
                            return;
                        }
                        I();
                        return;
                    }
                    jE = ga2.e(jE, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jE > 0) {
                    if (b0()) {
                        _thread = null;
                        Z();
                        rg2 rg2VarA4 = sg2.a();
                        if (rg2VarA4 != null) {
                            rg2VarA4.e();
                        }
                        if (R()) {
                            return;
                        }
                        I();
                        return;
                    }
                    rg2 rg2VarA5 = sg2.a();
                    if (rg2VarA5 != null) {
                        rg2VarA5.c(this, jE);
                    } else {
                        LockSupport.parkNanos(this, jE);
                    }
                }
            }
        } finally {
            _thread = null;
            Z();
            rg2 rg2VarA6 = sg2.a();
            if (rg2VarA6 != null) {
                rg2VarA6.e();
            }
            if (!R()) {
                I();
            }
        }
    }
}
