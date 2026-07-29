package kotlin.random;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPlatformRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRandom.kt\nkotlin/random/AbstractPlatformRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
public abstract class a extends Random {
    @Override // kotlin.random.Random
    public int b(int i10) {
        return d.j(v().nextInt(), i10);
    }

    @Override // kotlin.random.Random
    public boolean c() {
        return v().nextBoolean();
    }

    @Override // kotlin.random.Random
    @k
    public byte[] f(@k byte[] array) {
        f0.p(array, "array");
        v().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public double k() {
        return v().nextDouble();
    }

    @Override // kotlin.random.Random
    public float n() {
        return v().nextFloat();
    }

    @Override // kotlin.random.Random
    public int o() {
        return v().nextInt();
    }

    @Override // kotlin.random.Random
    public int p(int i10) {
        return v().nextInt(i10);
    }

    @Override // kotlin.random.Random
    public long r() {
        return v().nextLong();
    }

    @k
    public abstract java.util.Random v();
}
