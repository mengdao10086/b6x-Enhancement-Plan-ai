package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.l1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m1 extends k1 {
    public void A2(long j10, @yt.k l1.c cVar) {
        s0.f38948i.K2(j10, cVar);
    }

    public final void B2() {
        kotlin.z1 z1Var;
        Thread threadZ2 = z2();
        if (Thread.currentThread() != threadZ2) {
            b bVarB = c.b();
            if (bVarB != null) {
                bVarB.g(threadZ2);
                z1Var = kotlin.z1.f38230a;
            } else {
                z1Var = null;
            }
            if (z1Var == null) {
                LockSupport.unpark(threadZ2);
            }
        }
    }

    @yt.k
    public abstract Thread z2();
}
