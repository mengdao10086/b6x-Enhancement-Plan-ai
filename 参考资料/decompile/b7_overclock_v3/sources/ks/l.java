package ks;

import np.w1;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class l implements js.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f39224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f39225b;

    public class a implements ks.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ org.bouncycastle.util.m f39226a;

        public a(org.bouncycastle.util.m mVar) {
            this.f39226a = mVar;
        }

        @Override // ks.a
        public s get() {
            return (s) this.f39226a.d();
        }
    }

    public l(s sVar) {
        if (!(sVar instanceof org.bouncycastle.util.m)) {
            throw new IllegalArgumentException("digest must implement Memoable");
        }
        this.f39224a = new k(new a(((org.bouncycastle.util.m) sVar).d()));
    }

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (z10) {
            this.f39225b = kVar instanceof w1 ? (g) ((w1) kVar).a() : (g) kVar;
        }
        this.f39224a.a(z10, kVar);
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        if (this.f39225b == null) {
            throw new IllegalStateException("signing key no longer usable");
        }
        byte[] bArrB = this.f39224a.b(bArr);
        this.f39225b = this.f39225b.q();
        return bArrB;
    }

    @Override // js.g
    public np.c c() {
        g gVar = this.f39225b;
        this.f39225b = null;
        return gVar;
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        return this.f39224a.d(bArr, bArr2);
    }
}
