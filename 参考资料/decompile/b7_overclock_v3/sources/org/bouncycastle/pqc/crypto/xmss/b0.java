package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.d;
import org.bouncycastle.pqc.crypto.xmss.f;

/* JADX INFO: loaded from: classes6.dex */
public class b0 {
    public static XMSSNode a(h hVar, l lVar, f fVar) {
        double d10;
        Objects.requireNonNull(lVar, "publicKey == null");
        Objects.requireNonNull(fVar, "address == null");
        int iA = hVar.e().a();
        byte[][] bArrA = lVar.a();
        XMSSNode[] xMSSNodeArr = new XMSSNode[bArrA.length];
        for (int i10 = 0; i10 < bArrA.length; i10++) {
            xMSSNodeArr[i10] = new XMSSNode(0, bArrA[i10]);
        }
        f.b bVarG = new f.b().h(fVar.b()).i(fVar.c()).n(fVar.f()).o(0).p(fVar.h()).g(fVar.a());
        while (true) {
            f fVar2 = (f) bVarG.e();
            if (iA <= 1) {
                return xMSSNodeArr[0];
            }
            int i11 = 0;
            while (true) {
                d10 = iA / 2;
                if (i11 >= ((int) Math.floor(d10))) {
                    break;
                }
                fVar2 = (f) new f.b().h(fVar2.b()).i(fVar2.c()).n(fVar2.f()).o(fVar2.g()).p(i11).g(fVar2.a()).e();
                int i12 = i11 * 2;
                xMSSNodeArr[i11] = b(hVar, xMSSNodeArr[i12], xMSSNodeArr[i12 + 1], fVar2);
                i11++;
            }
            if (iA % 2 == 1) {
                xMSSNodeArr[(int) Math.floor(d10)] = xMSSNodeArr[iA - 1];
            }
            iA = (int) Math.ceil(((double) iA) / 2.0d);
            bVarG = new f.b().h(fVar2.b()).i(fVar2.c()).n(fVar2.f()).o(fVar2.g() + 1).p(fVar2.h()).g(fVar2.a());
        }
    }

    public static XMSSNode b(h hVar, XMSSNode xMSSNode, XMSSNode xMSSNode2, o oVar) {
        Objects.requireNonNull(xMSSNode, "left == null");
        Objects.requireNonNull(xMSSNode2, "right == null");
        if (xMSSNode.a() != xMSSNode2.a()) {
            throw new IllegalStateException("height of both nodes must be equal");
        }
        Objects.requireNonNull(oVar, "address == null");
        byte[] bArrI = hVar.i();
        if (oVar instanceof f) {
            f fVar = (f) oVar;
            oVar = (f) new f.b().h(fVar.b()).i(fVar.c()).n(fVar.f()).o(fVar.g()).p(fVar.h()).g(0).e();
        } else if (oVar instanceof d) {
            d dVar = (d) oVar;
            oVar = (d) new d.b().h(dVar.b()).i(dVar.c()).m(dVar.g()).n(dVar.h()).g(0).e();
        }
        byte[] bArrD = hVar.d().d(bArrI, oVar.e());
        if (oVar instanceof f) {
            f fVar2 = (f) oVar;
            oVar = (f) new f.b().h(fVar2.b()).i(fVar2.c()).n(fVar2.f()).o(fVar2.g()).p(fVar2.h()).g(1).e();
        } else if (oVar instanceof d) {
            d dVar2 = (d) oVar;
            oVar = (d) new d.b().h(dVar2.b()).i(dVar2.c()).m(dVar2.g()).n(dVar2.h()).g(1).e();
        }
        byte[] bArrD2 = hVar.d().d(bArrI, oVar.e());
        if (oVar instanceof f) {
            f fVar3 = (f) oVar;
            oVar = (f) new f.b().h(fVar3.b()).i(fVar3.c()).n(fVar3.f()).o(fVar3.g()).p(fVar3.h()).g(2).e();
        } else if (oVar instanceof d) {
            d dVar3 = (d) oVar;
            oVar = (d) new d.b().h(dVar3.b()).i(dVar3.c()).m(dVar3.g()).n(dVar3.h()).g(2).e();
        }
        byte[] bArrD3 = hVar.d().d(bArrI, oVar.e());
        int iF = hVar.e().f();
        byte[] bArr = new byte[iF * 2];
        for (int i10 = 0; i10 < iF; i10++) {
            bArr[i10] = (byte) (xMSSNode.b()[i10] ^ bArrD2[i10]);
        }
        for (int i11 = 0; i11 < iF; i11++) {
            bArr[i11 + iF] = (byte) (xMSSNode2.b()[i11] ^ bArrD3[i11]);
        }
        return new XMSSNode(xMSSNode.a(), hVar.d().b(bArrD, bArr));
    }
}
