package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public class y0 extends x0 {
    @bk.f
    public static final <R> R l(Object lock, ik.a<? extends R> block) {
        R rO;
        kotlin.jvm.internal.f0.p(lock, "lock");
        kotlin.jvm.internal.f0.p(block, "block");
        synchronized (lock) {
            try {
                rO = block.o();
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        kotlin.jvm.internal.c0.c(1);
        return rO;
    }
}
