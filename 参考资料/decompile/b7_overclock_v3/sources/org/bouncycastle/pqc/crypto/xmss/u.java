package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.pqc.crypto.xmss.g;
import org.bouncycastle.pqc.crypto.xmss.x;
import org.bouncycastle.pqc.crypto.xmss.y;

/* JADX INFO: loaded from: classes6.dex */
public final class u implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w f45950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d0 f45951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecureRandom f45952i;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        t tVar = (t) yVar;
        this.f45952i = tVar.a();
        w wVarC = tVar.c();
        this.f45950g = wVarC;
        this.f45951h = wVarC.j();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        x xVarC = c(new x.b(this.f45950g).k().f());
        this.f45951h.i().l(new byte[this.f45950g.g()], xVarC.j());
        int iB = this.f45950g.b() - 1;
        BDS bds = new BDS(this.f45951h, xVarC.j(), xVarC.m(), (g) new g.b().h(iB).e());
        XMSSNode xMSSNodeH = bds.h();
        xVarC.f().d(iB, bds);
        x xVarK = new x.b(this.f45950g).s(xVarC.m()).r(xVarC.l()).p(xVarC.j()).q(xMSSNodeH.b()).l(xVarC.f()).k();
        return new org.bouncycastle.crypto.c((np.c) new y.b(this.f45950g).h(xMSSNodeH.b()).g(xVarK.j()).e(), (np.c) xVarK);
    }

    public final x c(BDSStateMap bDSStateMap) {
        int iG = this.f45950g.g();
        byte[] bArr = new byte[iG];
        this.f45952i.nextBytes(bArr);
        byte[] bArr2 = new byte[iG];
        this.f45952i.nextBytes(bArr2);
        byte[] bArr3 = new byte[iG];
        this.f45952i.nextBytes(bArr3);
        return new x.b(this.f45950g).s(bArr).r(bArr2).p(bArr3).l(bDSStateMap).k();
    }
}
