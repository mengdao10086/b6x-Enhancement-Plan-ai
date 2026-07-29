package kotlinx.coroutines.internal;

import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nSynchronized.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 2 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,33:1\n20#2:34\n*S KotlinDebug\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n*L\n31#1:34\n*E\n"})
public final class q0 {
    @y1
    public static final <T> T a(@yt.k Object obj, @yt.k ik.a<? extends T> aVar) {
        T tO;
        synchronized (obj) {
            try {
                tO = aVar.o();
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        kotlin.jvm.internal.c0.c(1);
        return tO;
    }
}
