package vn;

import ir.i;
import java.math.BigInteger;
import java.util.Random;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e {
    public static i a(ir.e eVar, byte[] bArr) {
        ir.f fVarN = eVar.n(BigInteger.valueOf(bArr[bArr.length - 1] & 1));
        ir.f fVarN2 = eVar.n(new BigInteger(1, bArr));
        if (!d(fVarN2).equals(eVar.o())) {
            fVarN2 = fVarN2.b();
        }
        ir.f fVarK = null;
        if (fVarN2.j()) {
            fVarK = eVar.q().o();
        } else {
            ir.f fVarC = c(eVar, fVarN2.p().h().k(eVar.q()).a(eVar.o()).a(fVarN2));
            if (fVarC != null) {
                if (!d(fVarC).equals(fVarN)) {
                    fVarC = fVarC.b();
                }
                fVarK = fVarN2.k(fVarC);
            }
        }
        if (fVarK != null) {
            return eVar.I(fVarN2.v(), fVarK.v());
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    public static byte[] b(i iVar) {
        i iVarB = iVar.B();
        ir.f fVarF = iVarB.f();
        byte[] bArrE = fVarF.e();
        if (!fVarF.j()) {
            if (d(iVarB.g().d(fVarF)).i()) {
                int length = bArrE.length - 1;
                bArrE[length] = (byte) (bArrE[length] | 1);
            } else {
                int length2 = bArrE.length - 1;
                bArrE[length2] = (byte) (bArrE[length2] & 254);
            }
        }
        return bArrE;
    }

    public static ir.f c(ir.e eVar, ir.f fVar) {
        ir.f fVarA;
        if (fVar.j()) {
            return fVar;
        }
        ir.f fVarN = eVar.n(ir.d.f35646a);
        Random random = new Random();
        int iG = fVar.g();
        do {
            ir.f fVarN2 = eVar.n(new BigInteger(iG, random));
            ir.f fVarA2 = fVar;
            fVarA = fVarN;
            for (int i10 = 1; i10 <= iG - 1; i10++) {
                ir.f fVarP = fVarA2.p();
                fVarA = fVarA.p().a(fVarP.k(fVarN2));
                fVarA2 = fVarP.a(fVar);
            }
            if (!fVarA2.j()) {
                return null;
            }
        } while (fVarA.p().a(fVarA).j());
        return fVarA;
    }

    public static ir.f d(ir.f fVar) {
        ir.f fVarA = fVar;
        for (int i10 = 1; i10 < fVar.g(); i10++) {
            fVarA = fVarA.p().a(fVar);
        }
        return fVarA;
    }
}
