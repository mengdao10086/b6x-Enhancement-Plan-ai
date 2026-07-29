package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class t {
    public static final int a(@yt.k AtomicInteger atomicInteger) {
        return atomicInteger.get();
    }

    public static final void b(@yt.k AtomicInteger atomicInteger, int i10) {
        atomicInteger.set(i10);
    }
}
