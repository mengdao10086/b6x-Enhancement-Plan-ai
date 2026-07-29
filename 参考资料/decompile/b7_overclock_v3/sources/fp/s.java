package fp;

import java.math.BigInteger;
import np.t0;
import np.v0;
import np.w0;
import np.x0;

/* JADX INFO: loaded from: classes5.dex */
public class s implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t0 f28689g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28689g = (t0) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        i iVar = i.f28649a;
        v0 v0VarC = this.f28689g.c();
        np.q qVar = new np.q(v0VarC.c(), v0VarC.a(), null, v0VarC.b());
        BigInteger bigIntegerA = iVar.a(qVar, this.f28689g.a());
        return new org.bouncycastle.crypto.c((np.c) new x0(iVar.b(qVar, bigIntegerA), v0VarC), (np.c) new w0(bigIntegerA, v0VarC));
    }
}
