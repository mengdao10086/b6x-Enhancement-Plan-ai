package pk;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends kotlin.random.a {
    @Override // kotlin.random.Random
    public double l(double d10) {
        return ThreadLocalRandom.current().nextDouble(d10);
    }

    @Override // kotlin.random.Random
    public int q(int i10, int i11) {
        return ThreadLocalRandom.current().nextInt(i10, i11);
    }

    @Override // kotlin.random.Random
    public long t(long j10) {
        return ThreadLocalRandom.current().nextLong(j10);
    }

    @Override // kotlin.random.Random
    public long u(long j10, long j11) {
        return ThreadLocalRandom.current().nextLong(j10, j11);
    }

    @Override // kotlin.random.a
    @k
    public Random v() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        f0.o(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
