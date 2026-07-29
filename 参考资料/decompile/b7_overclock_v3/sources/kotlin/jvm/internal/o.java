package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class o extends m0<byte[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final byte[] f37926d;

    public o(int i10) {
        super(i10);
        this.f37926d = new byte[i10];
    }

    public final void h(byte b10) {
        byte[] bArr = this.f37926d;
        int iB = b();
        e(iB + 1);
        bArr[iB] = b10;
    }

    @Override // kotlin.jvm.internal.m0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@yt.k byte[] bArr) {
        f0.p(bArr, "<this>");
        return bArr.length;
    }

    @yt.k
    public final byte[] j() {
        return g(this.f37926d, new byte[f()]);
    }
}
