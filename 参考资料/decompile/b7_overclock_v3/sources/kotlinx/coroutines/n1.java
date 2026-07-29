package kotlinx.coroutines;

import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: classes5.dex */
public final class n1 {
    @yt.k
    public static final k1 a() {
        return new g(Thread.currentThread());
    }

    @y0
    @kotlin.s0
    @y1
    public static final boolean b(@yt.k Thread thread) {
        if (thread instanceof CoroutineScheduler.c) {
            return ((CoroutineScheduler.c) thread).p();
        }
        return false;
    }

    public static final void c(@yt.k ik.a<kotlin.z1> aVar) {
        aVar.o();
    }

    @y1
    public static final long d() {
        k1 k1VarA = e3.f38471a.a();
        if (k1VarA != null) {
            return k1VarA.w2();
        }
        return Long.MAX_VALUE;
    }

    @y0
    @kotlin.s0
    @y1
    public static final long e() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof CoroutineScheduler.c) {
            return ((CoroutineScheduler.c) threadCurrentThread).t();
        }
        throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + threadCurrentThread);
    }
}
