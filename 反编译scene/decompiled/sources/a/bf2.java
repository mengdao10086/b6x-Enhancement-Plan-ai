package a;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class bf2 extends ve2 {
    public abstract Thread I();

    public final void J(long j, ye2 ye2Var) {
        if (be2.a()) {
            if (!(this != de2.f5890a)) {
                throw new AssertionError();
            }
        }
        de2.f5890a.U(j, ye2Var);
    }

    public final void K() {
        Thread threadI = I();
        if (Thread.currentThread() != threadI) {
            rg2 rg2VarA = sg2.a();
            if (rg2VarA != null) {
                rg2VarA.h(threadI);
            } else {
                LockSupport.unpark(threadI);
            }
        }
    }
}
