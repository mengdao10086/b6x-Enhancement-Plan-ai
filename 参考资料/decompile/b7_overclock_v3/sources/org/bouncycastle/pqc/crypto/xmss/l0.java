package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.d;
import org.bouncycastle.pqc.crypto.xmss.f;

/* JADX INFO: loaded from: classes6.dex */
public class l0 {
    public static XMSSNode a(h hVar, int i10, byte[] bArr, g0 g0Var, g gVar, int i11) {
        d.b bVar;
        if (bArr.length != hVar.e().f()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        Objects.requireNonNull(g0Var, "signature == null");
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        f fVar = (f) new f.b().h(gVar.b()).i(gVar.c()).n(gVar.h()).e();
        d dVar = (d) new d.b().h(gVar.b()).i(gVar.c()).n(gVar.h()).e();
        XMSSNode[] xMSSNodeArr = new XMSSNode[2];
        xMSSNodeArr[0] = b0.a(hVar, hVar.h(bArr, g0Var.c(), gVar), fVar);
        for (int i12 = 0; i12 < i10; i12++) {
            d dVar2 = (d) new d.b().h(dVar.b()).i(dVar.c()).m(i12).n(dVar.h()).g(dVar.a()).e();
            if (Math.floor(i11 / (1 << i12)) % 2.0d == 0.0d) {
                bVar = new d.b();
                dVar = (d) bVar.h(dVar2.b()).i(dVar2.c()).m(dVar2.g()).n(dVar2.h() / 2).g(dVar2.a()).e();
                xMSSNodeArr[1] = b0.b(hVar, xMSSNodeArr[0], g0Var.a().get(i12), dVar);
                xMSSNodeArr[1] = new XMSSNode(xMSSNodeArr[1].a() + 1, xMSSNodeArr[1].b());
            } else {
                bVar = new d.b();
                dVar = (d) bVar.h(dVar2.b()).i(dVar2.c()).m(dVar2.g()).n((dVar2.h() - 1) / 2).g(dVar2.a()).e();
                xMSSNodeArr[1] = b0.b(hVar, g0Var.a().get(i12), xMSSNodeArr[0], dVar);
                xMSSNodeArr[1] = new XMSSNode(xMSSNodeArr[1].a() + 1, xMSSNodeArr[1].b());
            }
            xMSSNodeArr[0] = xMSSNodeArr[1];
        }
        return xMSSNodeArr[0];
    }
}
