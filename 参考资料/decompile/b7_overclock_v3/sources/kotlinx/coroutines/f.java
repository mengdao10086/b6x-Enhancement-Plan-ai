package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
public final class f<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final Thread f38473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final k1 f38474e;

    public f(@yt.k CoroutineContext coroutineContext, @yt.k Thread thread, @yt.l k1 k1Var) {
        super(coroutineContext, true, true);
        this.f38473d = thread;
        this.f38474e = k1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T J1() throws Throwable {
        kotlin.z1 z1Var;
        b bVarB = c.b();
        if (bVarB != null) {
            bVarB.d();
        }
        try {
            k1 k1Var = this.f38474e;
            if (k1Var != null) {
                k1.s2(k1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    k1 k1Var2 = this.f38474e;
                    long jW2 = k1Var2 != null ? k1Var2.w2() : Long.MAX_VALUE;
                    if (n()) {
                        T t10 = (T) j2.h(K0());
                        c0Var = t10 instanceof c0 ? (c0) t10 : null;
                        if (c0Var == null) {
                            return t10;
                        }
                        throw c0Var.f38294a;
                    }
                    b bVarB2 = c.b();
                    if (bVarB2 != null) {
                        bVarB2.c(this, jW2);
                        z1Var = kotlin.z1.f38230a;
                    } else {
                        z1Var = null;
                    }
                    if (z1Var == null) {
                        LockSupport.parkNanos(this, jW2);
                    }
                } finally {
                    k1 k1Var3 = this.f38474e;
                    if (k1Var3 != null) {
                        k1.n2(k1Var3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            h0(interruptedException);
            throw interruptedException;
        } finally {
            b bVarB3 = c.b();
            if (bVarB3 != null) {
                bVarB3.h();
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean Q0() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void e0(@yt.l Object obj) {
        kotlin.z1 z1Var;
        if (kotlin.jvm.internal.f0.g(Thread.currentThread(), this.f38473d)) {
            return;
        }
        Thread thread = this.f38473d;
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
}
