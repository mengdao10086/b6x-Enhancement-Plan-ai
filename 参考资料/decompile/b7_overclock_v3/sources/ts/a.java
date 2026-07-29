package ts;

import gm.c0;
import gm.s;
import gm.y;
import gm.z;
import is.k;
import is.l;
import is.m;
import is.n;
import is.p;
import java.io.IOException;
import java.io.InputStream;
import ns.g;
import org.bouncycastle.pqc.crypto.lms.f;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.d0;
import org.bouncycastle.pqc.crypto.xmss.e0;
import org.bouncycastle.pqc.crypto.xmss.k0;
import org.bouncycastle.pqc.crypto.xmss.w;
import org.bouncycastle.pqc.crypto.xmss.x;
import org.bouncycastle.util.o;
import pn.u;
import rs.i;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static short[] a(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 != length; i10++) {
            sArr[i10] = o.y(bArr, i10 * 2);
        }
        return sArr;
    }

    public static np.c b(InputStream inputStream) throws IOException {
        return c(u.z(new s(inputStream).n()));
    }

    public static np.c c(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (yVarX.Q(im.a.W)) {
            return new os.e(e.e(uVar.B()), z.I(uVar.G()).J());
        }
        if (yVarX.C(im.a.f32497s)) {
            return new i(z.I(uVar.G()).J(), e.g(k.x(uVar.B().A())));
        }
        if (yVarX.C(im.a.f32482f0)) {
            return new g(a(z.I(uVar.G()).J()));
        }
        if (yVarX.C(pn.s.f46801e5)) {
            byte[] bArrJ = z.I(uVar.G()).J();
            gm.d dVarC = uVar.C();
            if (o.a(bArrJ, 0) == 1) {
                if (dVarC == null) {
                    return org.bouncycastle.pqc.crypto.lms.u.k(org.bouncycastle.util.a.W(bArrJ, 4, bArrJ.length));
                }
                byte[] bArrL = dVarC.L();
                return org.bouncycastle.pqc.crypto.lms.u.l(org.bouncycastle.util.a.W(bArrJ, 4, bArrJ.length), org.bouncycastle.util.a.W(bArrL, 4, bArrL.length));
            }
            if (dVarC == null) {
                return f.g(org.bouncycastle.util.a.W(bArrJ, 4, bArrJ.length));
            }
            return f.h(org.bouncycastle.util.a.W(bArrJ, 4, bArrJ.length), dVarC.L());
        }
        if (yVarX.C(im.a.f32501w)) {
            l lVarY = l.y(uVar.B().A());
            y yVarX2 = lVarY.z().x();
            p pVarZ = p.z(uVar.G());
            try {
                e0.b bVarP = new e0.b(new d0(lVarY.x(), e.b(yVarX2))).l(pVarZ.y()).r(pVarZ.E()).q(pVarZ.D()).o(pVarZ.B()).p(pVarZ.C());
                if (pVarZ.F() != 0) {
                    bVarP.m(pVarZ.A());
                }
                if (pVarZ.x() != null) {
                    bVarP.k(((BDS) k0.g(pVarZ.x(), BDS.class)).q(yVarX2));
                }
                return bVarP.j();
            } catch (ClassNotFoundException e10) {
                throw new IOException("ClassNotFoundException processing BDS state: " + e10.getMessage());
            }
        }
        if (!yVarX.C(is.g.F)) {
            if (!yVarX.C(is.g.f35787n)) {
                throw new RuntimeException("algorithm identifier in private key not recognised");
            }
            is.c cVarA = is.c.A(uVar.G());
            return new ms.g(cVarA.C(), cVarA.B(), cVarA.y(), cVarA.z(), cVarA.D(), e.c(cVarA.x().x()));
        }
        m mVarY = m.y(uVar.B().A());
        y yVarX3 = mVarY.A().x();
        try {
            n nVarZ = n.z(uVar.G());
            x.b bVarQ = new x.b(new w(mVarY.x(), mVarY.z(), e.b(yVarX3))).m(nVarZ.y()).s(nVarZ.E()).r(nVarZ.D()).p(nVarZ.B()).q(nVarZ.C());
            if (nVarZ.F() != 0) {
                bVarQ.n(nVarZ.A());
            }
            if (nVarZ.x() != null) {
                bVarQ.l(((BDSStateMap) k0.g(nVarZ.x(), BDSStateMap.class)).i(yVarX3));
            }
            return bVarQ.k();
        } catch (ClassNotFoundException e11) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e11.getMessage());
        }
    }

    public static np.c d(byte[] bArr) throws IOException {
        return c(u.z(c0.D(bArr)));
    }
}
