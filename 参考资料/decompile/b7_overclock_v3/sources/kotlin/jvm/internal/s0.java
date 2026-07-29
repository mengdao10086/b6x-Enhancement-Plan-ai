package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class s0 extends m0<short[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final short[] f37952d;

    public s0(int i10) {
        super(i10);
        this.f37952d = new short[i10];
    }

    public final void h(short s10) {
        short[] sArr = this.f37952d;
        int iB = b();
        e(iB + 1);
        sArr[iB] = s10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k short[] sArr) {
        f0.p(sArr, "<this>");
        return sArr.length;
    }

    @yt.k
    public final short[] j() {
        return g(this.f37952d, new short[f()]);
    }
}
