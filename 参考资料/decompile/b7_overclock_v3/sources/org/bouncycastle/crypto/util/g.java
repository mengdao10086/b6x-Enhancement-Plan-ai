package org.bouncycastle.crypto.util;

import gm.f0;
import gm.j2;
import gm.n0;
import gm.t;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import np.a0;
import np.f2;
import np.k0;
import np.l0;
import np.o0;
import np.p0;
import np.z;
import org.bouncycastle.util.Strings;
import pn.x;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f44737a = Strings.i("openssh-key-v1\u0000");

    public static boolean a(f0 f0Var) {
        for (int i10 = 0; i10 < f0Var.size(); i10++) {
            if (!(f0Var.K(i10) instanceof t)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b(np.c cVar) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("param is null");
        }
        if (!(cVar instanceof f2) && !(cVar instanceof l0)) {
            if (cVar instanceof a0) {
                a0 a0Var = (a0) cVar;
                z zVarD = a0Var.d();
                gm.i iVar = new gm.i();
                iVar.a(new t(0L));
                iVar.a(new t(zVarD.b()));
                iVar.a(new t(zVarD.c()));
                iVar.a(new t(zVarD.a()));
                iVar.a(new t(zVarD.a().modPow(a0Var.e(), zVarD.b())));
                iVar.a(new t(a0Var.e()));
                try {
                    return new j2(iVar).getEncoded();
                } catch (Exception e10) {
                    throw new IllegalStateException("unable to encode DSAPrivateKeyParameters " + e10.getMessage());
                }
            }
            if (!(cVar instanceof o0)) {
                throw new IllegalArgumentException("unable to convert " + cVar.getClass().getName() + " to openssh private key");
            }
            o0 o0Var = (o0) cVar;
            p0 p0VarE = o0Var.e();
            p pVar = new p();
            pVar.g(f44737a);
            pVar.h("none");
            pVar.h("none");
            pVar.h("");
            pVar.d(1);
            pVar.f(h.a(p0VarE));
            p pVar2 = new p();
            int iNextInt = org.bouncycastle.crypto.n.f().nextInt();
            pVar2.d(iNextInt);
            pVar2.d(iNextInt);
            pVar2.h(h.f44740c);
            byte[] encoded = p0VarE.getEncoded();
            pVar2.f(encoded);
            pVar2.f(org.bouncycastle.util.a.B(o0Var.getEncoded(), encoded));
            pVar2.h("");
            pVar.f(pVar2.b());
            return pVar.a();
        }
        return m.a(cVar).G().b().getEncoded();
    }

    public static np.c c(byte[] bArr) {
        np.c l0Var = null;
        if (bArr[0] == 48) {
            f0 f0VarJ = f0.J(bArr);
            if (f0VarJ.size() == 6) {
                if (a(f0VarJ) && ((t) f0VarJ.K(0)).J().equals(org.bouncycastle.util.b.f46032a)) {
                    l0Var = new a0(((t) f0VarJ.K(5)).J(), new z(((t) f0VarJ.K(1)).J(), ((t) f0VarJ.K(2)).J(), ((t) f0VarJ.K(3)).J()));
                }
            } else if (f0VarJ.size() == 9) {
                if (a(f0VarJ) && ((t) f0VarJ.K(0)).J().equals(org.bouncycastle.util.b.f46032a)) {
                    x xVarB = x.B(f0VarJ);
                    l0Var = new f2(xVarB.C(), xVarB.G(), xVarB.F(), xVarB.D(), xVarB.E(), xVarB.y(), xVarB.z(), xVarB.x());
                }
            } else if (f0VarJ.size() == 4 && (f0VarJ.K(3) instanceof n0) && (f0VarJ.K(2) instanceof n0)) {
                rn.a aVarX = rn.a.x(f0VarJ);
                y yVarN = y.N(aVarX.B());
                l0Var = new l0(aVarX.y(), new k0(yVarN, co.e.c(yVarN)));
            }
        } else {
            o oVar = new o(f44737a, bArr);
            if (!"none".equals(oVar.g())) {
                throw new IllegalStateException("encrypted keys not supported");
            }
            oVar.i();
            oVar.i();
            if (oVar.h() != 1) {
                throw new IllegalStateException("multiple keys not supported");
            }
            h.c(oVar.d());
            byte[] bArrE = oVar.e();
            if (oVar.b()) {
                throw new IllegalArgumentException("decoded key has trailing data");
            }
            o oVar2 = new o(bArrE);
            if (oVar2.h() != oVar2.h()) {
                throw new IllegalStateException("private key check values are not the same");
            }
            String strG = oVar2.g();
            if (h.f44740c.equals(strG)) {
                oVar2.d();
                byte[] bArrD = oVar2.d();
                if (bArrD.length != 64) {
                    throw new IllegalStateException("private key value of wrong length");
                }
                l0Var = new o0(bArrD, 0);
            } else if (strG.startsWith(h.f44739b)) {
                y yVarB = SSHNamedCurves.b(Strings.c(oVar2.d()));
                if (yVarB == null) {
                    throw new IllegalStateException("OID not found for: " + strG);
                }
                co.l lVarC = kn.c.c(yVarB);
                if (lVarC == null) {
                    throw new IllegalStateException("Curve not found for: " + yVarB);
                }
                oVar2.d();
                l0Var = new l0(new BigInteger(1, oVar2.d()), new k0(yVarB, lVarC));
            }
            oVar2.i();
            if (oVar2.b()) {
                throw new IllegalArgumentException("private key block has trailing data");
            }
        }
        if (l0Var != null) {
            return l0Var;
        }
        throw new IllegalArgumentException("unable to parse key");
    }
}
