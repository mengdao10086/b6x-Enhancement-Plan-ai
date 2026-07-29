package uo;

import java.math.BigInteger;
import np.t;
import np.u;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f52361a;

    public byte[] a(org.bouncycastle.crypto.k kVar) {
        u uVar = (u) kVar;
        b bVar = new b();
        b bVar2 = new b();
        bVar.a(this.f52361a.c());
        BigInteger bigIntegerC = bVar.c(uVar.b());
        bVar2.a(this.f52361a.a());
        BigInteger bigIntegerC2 = bVar2.c(uVar.a());
        int iB = b();
        byte[] bArr = new byte[iB * 2];
        org.bouncycastle.util.b.a(bigIntegerC2, bArr, 0, iB);
        org.bouncycastle.util.b.a(bigIntegerC, bArr, iB, iB);
        return bArr;
    }

    public int b() {
        return (this.f52361a.c().d().f().bitLength() + 7) / 8;
    }

    public void c(org.bouncycastle.crypto.k kVar) {
        this.f52361a = (t) kVar;
    }
}
