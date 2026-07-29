package kp;

/* JADX INFO: loaded from: classes5.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f39085a;

    @Override // kp.d
    public void a(byte[] bArr) {
        this.f39085a = e.k(bArr);
    }

    @Override // kp.d
    public void b(byte[] bArr) {
        long[] jArrK = e.k(bArr);
        e.s(jArrK, this.f39085a);
        e.e(jArrK, bArr);
    }
}
