package fp;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class h implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public np.m f28642g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28642g = (np.m) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        i iVar = i.f28649a;
        np.q qVarC = this.f28642g.c();
        BigInteger bigIntegerA = iVar.a(qVarC, this.f28642g.a());
        return new org.bouncycastle.crypto.c((np.c) new np.s(iVar.b(qVarC, bigIntegerA), qVarC), (np.c) new np.r(bigIntegerA, qVarC));
    }
}
