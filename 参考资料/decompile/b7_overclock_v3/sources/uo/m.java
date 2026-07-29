package uo;

import np.m2;
import np.n2;
import org.bouncycastle.crypto.d0;

/* JADX INFO: loaded from: classes5.dex */
public final class m implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m2 f52381a;

    @Override // org.bouncycastle.crypto.d0
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52381a = (m2) kVar;
    }

    @Override // org.bouncycastle.crypto.d0
    public void b(org.bouncycastle.crypto.k kVar, byte[] bArr, int i10) {
        this.f52381a.f((n2) kVar, bArr, i10);
    }

    @Override // org.bouncycastle.crypto.d0
    public int c() {
        return 32;
    }
}
