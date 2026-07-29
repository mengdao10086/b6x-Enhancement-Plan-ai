package ts;

import gm.f2;
import gm.h0;
import is.g;
import is.k;
import is.l;
import is.m;
import is.n;
import is.p;
import java.io.IOException;
import org.bouncycastle.pqc.crypto.lms.f;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.e0;
import org.bouncycastle.pqc.crypto.xmss.k0;
import org.bouncycastle.pqc.crypto.xmss.x;
import org.bouncycastle.util.o;
import pn.s;
import pn.u;
import rs.i;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static u a(np.c cVar) throws IOException {
        return b(cVar, null);
    }

    public static u b(np.c cVar, h0 h0Var) throws IOException {
        if (cVar instanceof os.e) {
            os.e eVar = (os.e) cVar;
            return new u(e.d(eVar.e()), new f2(eVar.d()), h0Var);
        }
        if (cVar instanceof i) {
            i iVar = (i) cVar;
            return new u(new zn.b(g.f35791r, new k(e.f(iVar.d()))), new f2(iVar.e()));
        }
        if (cVar instanceof ns.g) {
            zn.b bVar = new zn.b(g.f35795v);
            short[] sArrD = ((ns.g) cVar).d();
            byte[] bArr = new byte[sArrD.length * 2];
            for (int i10 = 0; i10 != sArrD.length; i10++) {
                o.M(sArrD[i10], bArr, i10 * 2);
            }
            return new u(bVar, new f2(bArr));
        }
        if (cVar instanceof org.bouncycastle.pqc.crypto.lms.u) {
            org.bouncycastle.pqc.crypto.lms.u uVar = (org.bouncycastle.pqc.crypto.lms.u) cVar;
            byte[] bArrB = org.bouncycastle.pqc.crypto.lms.a.i().m(1).c(uVar).b();
            return new u(new zn.b(s.f46801e5), new f2(bArrB), h0Var, org.bouncycastle.pqc.crypto.lms.a.i().m(1).c(uVar.p()).b());
        }
        if (cVar instanceof f) {
            f fVar = (f) cVar;
            byte[] bArrB2 = org.bouncycastle.pqc.crypto.lms.a.i().m(fVar.j()).c(fVar).b();
            return new u(new zn.b(s.f46801e5), new f2(bArrB2), h0Var, org.bouncycastle.pqc.crypto.lms.a.i().m(fVar.j()).c(fVar.l().f()).b());
        }
        if (cVar instanceof e0) {
            e0 e0Var = (e0) cVar;
            return new u(new zn.b(g.f35796w, new l(e0Var.i().b(), e.h(e0Var.d()))), c(e0Var), h0Var);
        }
        if (cVar instanceof x) {
            x xVar = (x) cVar;
            return new u(new zn.b(g.F, new m(xVar.i().a(), xVar.i().b(), e.h(xVar.d()))), d(xVar), h0Var);
        }
        if (!(cVar instanceof ms.g)) {
            throw new IOException("key parameters not recognized");
        }
        ms.g gVar = (ms.g) cVar;
        return new u(new zn.b(g.f35787n), new is.c(gVar.i(), gVar.h(), gVar.e(), gVar.f(), gVar.j(), e.a(gVar.d())));
    }

    public static p c(e0 e0Var) throws IOException {
        byte[] encoded = e0Var.getEncoded();
        int iH = e0Var.i().h();
        int iB = e0Var.i().b();
        int iB2 = (int) k0.b(encoded, 0, 4);
        if (!k0.n(iB, iB2)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        byte[] bArrI = k0.i(encoded, 4, iH);
        int i10 = 4 + iH;
        byte[] bArrI2 = k0.i(encoded, i10, iH);
        int i11 = i10 + iH;
        byte[] bArrI3 = k0.i(encoded, i11, iH);
        int i12 = i11 + iH;
        byte[] bArrI4 = k0.i(encoded, i12, iH);
        int i13 = i12 + iH;
        byte[] bArrI5 = k0.i(encoded, i13, encoded.length - i13);
        try {
            BDS bds = (BDS) k0.g(bArrI5, BDS.class);
            return bds.d() != (1 << iB) - 1 ? new p(iB2, bArrI, bArrI2, bArrI3, bArrI4, bArrI5, bds.d()) : new p(iB2, bArrI, bArrI2, bArrI3, bArrI4, bArrI5);
        } catch (ClassNotFoundException e10) {
            throw new IOException("cannot parse BDS: " + e10.getMessage());
        }
    }

    public static n d(x xVar) throws IOException {
        byte[] encoded = xVar.getEncoded();
        int iG = xVar.i().g();
        int iA = xVar.i().a();
        int i10 = (iA + 7) / 8;
        long jB = (int) k0.b(encoded, 0, i10);
        if (!k0.n(iA, jB)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        int i11 = i10 + 0;
        byte[] bArrI = k0.i(encoded, i11, iG);
        int i12 = i11 + iG;
        byte[] bArrI2 = k0.i(encoded, i12, iG);
        int i13 = i12 + iG;
        byte[] bArrI3 = k0.i(encoded, i13, iG);
        int i14 = i13 + iG;
        byte[] bArrI4 = k0.i(encoded, i14, iG);
        int i15 = i14 + iG;
        byte[] bArrI5 = k0.i(encoded, i15, encoded.length - i15);
        try {
            BDSStateMap bDSStateMap = (BDSStateMap) k0.g(bArrI5, BDSStateMap.class);
            return bDSStateMap.b() != (1 << iA) - 1 ? new n(jB, bArrI, bArrI2, bArrI3, bArrI4, bArrI5, bDSStateMap.b()) : new n(jB, bArrI, bArrI2, bArrI3, bArrI4, bArrI5);
        } catch (ClassNotFoundException e10) {
            throw new IOException("cannot parse BDSStateMap: " + e10.getMessage());
        }
    }
}
