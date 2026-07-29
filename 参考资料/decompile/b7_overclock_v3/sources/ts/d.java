package ts;

import gm.f2;
import is.g;
import is.k;
import is.l;
import is.m;
import is.o;
import is.q;
import java.io.IOException;
import ns.h;
import org.bouncycastle.pqc.crypto.lms.v;
import org.bouncycastle.pqc.crypto.xmss.f0;
import org.bouncycastle.pqc.crypto.xmss.y;
import os.f;
import pn.s;
import rs.j;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static c1 a(np.c cVar) throws IOException {
        if (cVar instanceof f) {
            f fVar = (f) cVar;
            return new c1(e.d(fVar.e()), fVar.d());
        }
        if (cVar instanceof j) {
            j jVar = (j) cVar;
            return new c1(new zn.b(g.f35791r, new k(e.f(jVar.d()))), jVar.e());
        }
        if (cVar instanceof h) {
            return new c1(new zn.b(g.f35795v), ((h) cVar).d());
        }
        if (cVar instanceof v) {
            return new c1(new zn.b(s.f46801e5), new f2(org.bouncycastle.pqc.crypto.lms.a.i().m(1).c((v) cVar).b()));
        }
        if (cVar instanceof org.bouncycastle.pqc.crypto.lms.g) {
            org.bouncycastle.pqc.crypto.lms.g gVar = (org.bouncycastle.pqc.crypto.lms.g) cVar;
            return new c1(new zn.b(s.f46801e5), new f2(org.bouncycastle.pqc.crypto.lms.a.i().m(gVar.e()).c(gVar.f()).b()));
        }
        if (cVar instanceof f0) {
            f0 f0Var = (f0) cVar;
            byte[] bArrF = f0Var.f();
            byte[] bArrG = f0Var.g();
            byte[] encoded = f0Var.getEncoded();
            return encoded.length > bArrF.length + bArrG.length ? new c1(new zn.b(bn.a.f9499a), new f2(encoded)) : new c1(new zn.b(g.f35796w, new l(f0Var.e().b(), e.h(f0Var.d()))), new q(bArrF, bArrG));
        }
        if (!(cVar instanceof y)) {
            if (!(cVar instanceof ms.h)) {
                throw new IOException("key parameters not recognized");
            }
            ms.h hVar = (ms.h) cVar;
            return new c1(new zn.b(g.f35787n), new is.d(hVar.g(), hVar.h(), hVar.e(), e.a(hVar.d())));
        }
        y yVar = (y) cVar;
        byte[] bArrF2 = yVar.f();
        byte[] bArrG2 = yVar.g();
        byte[] encoded2 = yVar.getEncoded();
        return encoded2.length > bArrF2.length + bArrG2.length ? new c1(new zn.b(bn.a.f9500b), new f2(encoded2)) : new c1(new zn.b(g.F, new m(yVar.e().a(), yVar.e().b(), e.h(yVar.d()))), new o(yVar.f(), yVar.g()));
    }
}
