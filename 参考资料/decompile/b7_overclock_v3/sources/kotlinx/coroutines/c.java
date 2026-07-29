package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public static b f38292a;

    @bk.f
    public static final long a() {
        b bVarB = b();
        return bVarB != null ? bVarB.a() : System.currentTimeMillis();
    }

    @yt.l
    public static final b b() {
        return f38292a;
    }

    @bk.f
    public static final long c() {
        b bVarB = b();
        return bVarB != null ? bVarB.b() : System.nanoTime();
    }

    @bk.f
    public static final void d(Object obj, long j10) {
        kotlin.z1 z1Var;
        b bVarB = b();
        if (bVarB != null) {
            bVarB.c(obj, j10);
            z1Var = kotlin.z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            LockSupport.parkNanos(obj, j10);
        }
    }

    @bk.f
    public static final void e() {
        b bVarB = b();
        if (bVarB != null) {
            bVarB.d();
        }
    }

    public static final void f(@yt.l b bVar) {
        f38292a = bVar;
    }

    @bk.f
    public static final void g() {
        b bVarB = b();
        if (bVarB != null) {
            bVarB.e();
        }
    }

    @bk.f
    public static final void h() {
        b bVarB = b();
        if (bVarB != null) {
            bVarB.f();
        }
    }

    @bk.f
    public static final void i(Thread thread) {
        kotlin.z1 z1Var;
        b bVarB = b();
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

    @bk.f
    public static final void j() {
        b bVarB = b();
        if (bVarB != null) {
            bVarB.h();
        }
    }

    @bk.f
    public static final Runnable k(Runnable runnable) {
        Runnable runnableI;
        b bVarB = b();
        return (bVarB == null || (runnableI = bVarB.i(runnable)) == null) ? runnable : runnableI;
    }
}
