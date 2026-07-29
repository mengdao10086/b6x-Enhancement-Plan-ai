package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class q extends m0<char[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final char[] f37939d;

    public q(int i10) {
        super(i10);
        this.f37939d = new char[i10];
    }

    public final void h(char c10) {
        char[] cArr = this.f37939d;
        int iB = b();
        e(iB + 1);
        cArr[iB] = c10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k char[] cArr) {
        f0.p(cArr, "<this>");
        return cArr.length;
    }

    @yt.k
    public final char[] j() {
        return g(this.f37939d, new char[f()]);
    }
}
