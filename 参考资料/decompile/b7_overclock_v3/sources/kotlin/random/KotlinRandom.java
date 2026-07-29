package kotlin.random;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
final class KotlinRandom extends java.util.Random {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f38001a = new a(null);
    private static final long serialVersionUID = 0;

    @k
    private final Random impl;
    private boolean seedInitialized;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public KotlinRandom(@k Random impl) {
        f0.p(impl, "impl");
        this.impl = impl;
    }

    @k
    public final Random a() {
        return this.impl;
    }

    @Override // java.util.Random
    public int next(int i10) {
        return this.impl.b(i10);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.c();
    }

    @Override // java.util.Random
    public void nextBytes(@k byte[] bytes) {
        f0.p(bytes, "bytes");
        this.impl.f(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.k();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.n();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.o();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.r();
    }

    @Override // java.util.Random
    public void setSeed(long j10) {
        if (this.seedInitialized) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.seedInitialized = true;
    }

    @Override // java.util.Random
    public int nextInt(int i10) {
        return this.impl.p(i10);
    }
}
