package okio;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0002R\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00070\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\r¨\u0006\u0018"}, d2 = {"Lokio/q0;", "", "Lokio/p0;", "e", "segment", "Lkotlin/z1;", "d", "Ljava/util/concurrent/atomic/AtomicReference;", "a", "", "b", "I", "c", "()I", "MAX_SIZE", "Lokio/p0;", "LOCK", "HASH_BUCKET_COUNT", "", "[Ljava/util/concurrent/atomic/AtomicReference;", "hashBuckets", "byteCount", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final q0 f44190a = new q0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f44191b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final p0 f44192c = new p0(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final AtomicReference<p0>[] f44194e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f44193d = iHighestOneBit;
        AtomicReference<p0>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f44194e = atomicReferenceArr;
    }

    @hk.m
    public static final void d(@yt.k p0 segment) {
        AtomicReference<p0> atomicReferenceA;
        p0 p0Var;
        kotlin.jvm.internal.f0.p(segment, "segment");
        if (!(segment.f44179f == null && segment.f44180g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.f44177d || (p0Var = (atomicReferenceA = f44190a.a()).get()) == f44192c) {
            return;
        }
        int i10 = p0Var == null ? 0 : p0Var.f44176c;
        if (i10 >= f44191b) {
            return;
        }
        segment.f44179f = p0Var;
        segment.f44175b = 0;
        segment.f44176c = i10 + 8192;
        if (atomicReferenceA.compareAndSet(p0Var, segment)) {
            return;
        }
        segment.f44179f = null;
    }

    @hk.m
    @yt.k
    public static final p0 e() {
        AtomicReference<p0> atomicReferenceA = f44190a.a();
        p0 p0Var = f44192c;
        p0 andSet = atomicReferenceA.getAndSet(p0Var);
        if (andSet == p0Var) {
            return new p0();
        }
        if (andSet == null) {
            atomicReferenceA.set(null);
            return new p0();
        }
        atomicReferenceA.set(andSet.f44179f);
        andSet.f44179f = null;
        andSet.f44176c = 0;
        return andSet;
    }

    public final AtomicReference<p0> a() {
        return f44194e[(int) (Thread.currentThread().getId() & (((long) f44193d) - 1))];
    }

    public final int b() {
        p0 p0Var = a().get();
        if (p0Var == null) {
            return 0;
        }
        return p0Var.f44176c;
    }

    public final int c() {
        return f44191b;
    }
}
