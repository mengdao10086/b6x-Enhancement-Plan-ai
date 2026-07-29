package uo;

import java.math.BigInteger;
import np.e0;
import np.f0;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f52365a;

    public byte[] a(org.bouncycastle.crypto.k kVar) {
        f0 f0Var = (f0) kVar;
        f fVar = new f();
        f fVar2 = new f();
        fVar.a(this.f52365a.c());
        BigInteger bigIntegerC = fVar.c(f0Var.b());
        fVar2.a(this.f52365a.a());
        BigInteger bigIntegerC2 = fVar2.c(f0Var.a());
        int iB = b();
        byte[] bArr = new byte[iB * 2];
        org.bouncycastle.util.b.a(bigIntegerC2, bArr, 0, iB);
        org.bouncycastle.util.b.a(bigIntegerC, bArr, iB, iB);
        return bArr;
    }

    public int b() {
        return (this.f52365a.c().d().a().v() + 7) / 8;
    }

    public void c(org.bouncycastle.crypto.k kVar) {
        this.f52365a = (e0) kVar;
    }
}
