package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.pqc.crypto.xmss.e0;
import org.bouncycastle.pqc.crypto.xmss.f0;
import org.bouncycastle.pqc.crypto.xmss.g;

/* JADX INFO: loaded from: classes6.dex */
public final class q implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d0 f45937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f45938h;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        p pVar = (p) yVar;
        this.f45938h = pVar.a();
        this.f45937g = pVar.c();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        e0 e0VarC = c(this.f45937g, this.f45938h);
        XMSSNode xMSSNodeH = e0VarC.f().h();
        e0 e0VarJ = new e0.b(this.f45937g).r(e0VarC.m()).q(e0VarC.l()).o(e0VarC.j()).p(xMSSNodeH.b()).k(e0VarC.f()).j();
        return new org.bouncycastle.crypto.c((np.c) new f0.b(this.f45937g).h(xMSSNodeH.b()).g(e0VarJ.j()).e(), (np.c) e0VarJ);
    }

    public final e0 c(d0 d0Var, SecureRandom secureRandom) {
        int iH = d0Var.h();
        byte[] bArr = new byte[iH];
        secureRandom.nextBytes(bArr);
        byte[] bArr2 = new byte[iH];
        secureRandom.nextBytes(bArr2);
        byte[] bArr3 = new byte[iH];
        secureRandom.nextBytes(bArr3);
        return new e0.b(d0Var).r(bArr).q(bArr2).o(bArr3).k(new BDS(d0Var, bArr3, bArr, (g) new g.b().e())).j();
    }
}
