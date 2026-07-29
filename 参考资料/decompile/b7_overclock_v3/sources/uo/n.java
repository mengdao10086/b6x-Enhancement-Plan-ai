package uo;

import np.p2;
import np.q2;
import org.bouncycastle.crypto.d0;

/* JADX INFO: loaded from: classes5.dex */
public final class n implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p2 f52382a;

    @Override // org.bouncycastle.crypto.d0
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52382a = (p2) kVar;
    }

    @Override // org.bouncycastle.crypto.d0
    public void b(org.bouncycastle.crypto.k kVar, byte[] bArr, int i10) {
        this.f52382a.f((q2) kVar, bArr, i10);
    }

    @Override // org.bouncycastle.crypto.d0
    public int c() {
        return 56;
    }
}
