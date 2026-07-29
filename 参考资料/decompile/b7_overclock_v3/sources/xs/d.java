package xs;

import ft.s;
import ft.x;
import ft.y;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PublicKey;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static ft.g[] a(ms.g gVar, ft.g gVar2) {
        int iH = gVar.h();
        x xVarJ = gVar.j();
        ft.h hVarE = gVar.e();
        y yVarF = gVar.f();
        ft.e eVarG = gVar.g();
        y[] yVarArrK = gVar.k();
        ft.g gVar3 = (ft.g) gVar2.e(xVarJ.a());
        ft.g gVarC = s.c((ft.g) eVarG.i(gVar3), hVarE, yVarF, yVarArrK);
        ft.g gVar4 = (ft.g) ((ft.g) gVar3.a(gVarC)).e(xVarJ);
        return new ft.g[]{gVar4.h(iH), (ft.g) gVarC.e(xVarJ)};
    }

    public static ft.g[] b(BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey, ft.g gVar) {
        int iD = bCMcElieceCCA2PrivateKey.d();
        x xVarI = bCMcElieceCCA2PrivateKey.i();
        ft.h hVarA = bCMcElieceCCA2PrivateKey.a();
        y yVarB = bCMcElieceCCA2PrivateKey.b();
        ft.e eVarC = bCMcElieceCCA2PrivateKey.c();
        y[] yVarArrK = bCMcElieceCCA2PrivateKey.k();
        ft.g gVar2 = (ft.g) gVar.e(xVarI.a());
        ft.g gVarC = s.c((ft.g) eVarC.i(gVar2), hVarA, yVarB, yVarArrK);
        ft.g gVar3 = (ft.g) ((ft.g) gVar2.a(gVarC)).e(xVarI);
        return new ft.g[]{gVar3.h(iD), (ft.g) gVarC.e(xVarI)};
    }

    public static ft.g c(ms.h hVar, ft.g gVar, ft.g gVar2) {
        return (ft.g) hVar.e().A(gVar).a(gVar2);
    }

    public static ft.g d(BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey, ft.g gVar, ft.g gVar2) {
        return (ft.g) bCMcElieceCCA2PublicKey.a().A(gVar).a(gVar2);
    }
}
