package kotlinx.coroutines.internal;

import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
public final class p0 {
    @y1
    public static /* synthetic */ void a() {
    }

    @y1
    public static final <T> T b(@yt.k Object obj, @yt.k ik.a<? extends T> aVar) {
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
