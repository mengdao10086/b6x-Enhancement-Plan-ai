package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class j0 extends m0<long[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final long[] f37908d;

    public j0(int i10) {
        super(i10);
        this.f37908d = new long[i10];
    }

    public final void h(long j10) {
        long[] jArr = this.f37908d;
        int iB = b();
        e(iB + 1);
        jArr[iB] = j10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k long[] jArr) {
        f0.p(jArr, "<this>");
        return jArr.length;
    }

    @yt.k
    public final long[] j() {
        return g(this.f37908d, new long[f()]);
    }
}
