package ms;

import ft.x;
import ft.y;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static ft.g[] a(g gVar, ft.g gVar2) {
        int iH = gVar.h();
        x xVarJ = gVar.j();
        ft.h hVarE = gVar.e();
        y yVarF = gVar.f();
        ft.e eVarG = gVar.g();
        y[] yVarArrK = gVar.k();
        ft.g gVar3 = (ft.g) gVar2.e(xVarJ.a());
        ft.g gVarC = ft.s.c((ft.g) eVarG.i(gVar3), hVarE, yVarF, yVarArrK);
        ft.g gVar4 = (ft.g) ((ft.g) gVar3.a(gVarC)).e(xVarJ);
        return new ft.g[]{gVar4.h(iH), (ft.g) gVarC.e(xVarJ)};
    }

    public static ft.g b(h hVar, ft.g gVar, ft.g gVar2) {
        return (ft.g) hVar.e().A(gVar).a(gVar2);
    }
}
