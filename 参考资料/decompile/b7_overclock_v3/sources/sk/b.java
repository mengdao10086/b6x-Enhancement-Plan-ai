package sk;

import hk.h;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "TimingKt")
public final class b {
    public static final long a(@k ik.a<z1> block) {
        f0.p(block, "block");
        long jNanoTime = System.nanoTime();
        block.o();
        return System.nanoTime() - jNanoTime;
    }

    public static final long b(@k ik.a<z1> block) {
        f0.p(block, "block");
        long jCurrentTimeMillis = System.currentTimeMillis();
        block.o();
        return System.currentTimeMillis() - jCurrentTimeMillis;
    }
}
