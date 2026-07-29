package org.bouncycastle.jcajce.provider.asymmetric.util;

import gm.f0;
import gm.y;
import ir.e;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import np.g0;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f45056a = new HashMap();

    static {
        Enumeration enumerationM = ap.a.m();
        while (enumerationM.hasMoreElements()) {
            String str = (String) enumerationM.nextElement();
            co.l lVarB = co.e.b(str);
            if (lVarB != null) {
                f45056a.put(lVarB.y(), ap.a.j(str).y());
            }
        }
        ir.e eVarY = ap.a.j("Curve25519").y();
        f45056a.put(new e.f(eVarY.u().e(), eVarY.o().v(), eVarY.q().v(), eVarY.y(), eVarY.r()), eVarY);
    }

    public static ir.e a(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a10 = ellipticCurve.getA();
        BigInteger b10 = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            e.f fVar = new e.f(((ECFieldFp) field).getP(), a10, b10);
            return f45056a.containsKey(fVar) ? (ir.e) f45056a.get(fVar) : fVar;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m10 = eCFieldF2m.getM();
        int[] iArrA = i.a(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new e.C0401e(m10, iArrA[0], iArrA[1], iArrA[2], a10, b10);
    }

    public static EllipticCurve b(ir.e eVar, byte[] bArr) {
        return new EllipticCurve(c(eVar.u()), eVar.o().v(), eVar.q().v(), null);
    }

    public static ECField c(qr.b bVar) {
        if (ir.c.p(bVar)) {
            return new ECFieldFp(bVar.e());
        }
        qr.f fVarC = ((qr.g) bVar).c();
        int[] iArrB = fVarC.b();
        return new ECFieldF2m(fVarC.a(), org.bouncycastle.util.a.O0(org.bouncycastle.util.a.Y(iArrB, 1, iArrB.length - 1)));
    }

    public static ir.i d(ir.e eVar, ECPoint eCPoint) {
        return eVar.h(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ir.i e(ECParameterSpec eCParameterSpec, ECPoint eCPoint) {
        return d(a(eCParameterSpec.getCurve()), eCPoint);
    }

    public static ECPoint f(ir.i iVar) {
        ir.i iVarB = iVar.B();
        return new ECPoint(iVarB.f().v(), iVarB.g().v());
    }

    public static gr.e g(ECParameterSpec eCParameterSpec) {
        ir.e eVarA = a(eCParameterSpec.getCurve());
        ir.i iVarD = d(eVarA, eCParameterSpec.getGenerator());
        BigInteger order = eCParameterSpec.getOrder();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(eCParameterSpec.getCofactor());
        byte[] seed = eCParameterSpec.getCurve().getSeed();
        return eCParameterSpec instanceof gr.d ? new gr.c(((gr.d) eCParameterSpec).c(), eVarA, iVarD, order, bigIntegerValueOf, seed) : new gr.e(eVarA, iVarD, order, bigIntegerValueOf, seed);
    }

    public static ECParameterSpec h(EllipticCurve ellipticCurve, gr.e eVar) {
        ECPoint eCPointF = f(eVar.b());
        return eVar instanceof gr.c ? new gr.d(((gr.c) eVar).f(), ellipticCurve, eCPointF, eVar.d(), eVar.c()) : new ECParameterSpec(ellipticCurve, eCPointF, eVar.d(), eVar.c().intValue());
    }

    public static ECParameterSpec i(co.j jVar, ir.e eVar) {
        ECParameterSpec dVar;
        if (jVar.B()) {
            y yVar = (y) jVar.z();
            co.l lVarJ = i.j(yVar);
            if (lVarJ == null) {
                Map mapA = BouncyCastleProvider.f45330c.a();
                if (!mapA.isEmpty()) {
                    lVarJ = (co.l) mapA.get(yVar);
                }
            }
            return new gr.d(i.e(yVar), b(eVar, lVarJ.F()), f(lVarJ.B()), lVarJ.E(), lVarJ.C());
        }
        if (jVar.A()) {
            return null;
        }
        f0 f0VarJ = f0.J(jVar.z());
        if (f0VarJ.size() > 3) {
            co.l lVarD = co.l.D(f0VarJ);
            EllipticCurve ellipticCurveB = b(eVar, lVarD.F());
            dVar = lVarD.C() != null ? new ECParameterSpec(ellipticCurveB, f(lVarD.B()), lVarD.E(), lVarD.C().intValue()) : new ECParameterSpec(ellipticCurveB, f(lVarD.B()), lVarD.E(), 1);
        } else {
            qm.g gVarA = qm.g.A(f0VarJ);
            gr.c cVarB = org.bouncycastle.jce.a.b(qm.b.h(gVarA.B()));
            dVar = new gr.d(qm.b.h(gVarA.B()), b(cVarB.a(), cVarB.e()), f(cVarB.b()), cVarB.d(), cVarB.c());
        }
        return dVar;
    }

    public static ECParameterSpec j(co.l lVar) {
        return new ECParameterSpec(b(lVar.y(), null), f(lVar.B()), lVar.E(), lVar.C().intValue());
    }

    public static ECParameterSpec k(g0 g0Var) {
        return new ECParameterSpec(b(g0Var.a(), null), f(g0Var.b()), g0Var.e(), g0Var.c().intValue());
    }

    public static ir.e l(uq.c cVar, co.j jVar) {
        Set setC = cVar.c();
        if (!jVar.B()) {
            if (jVar.A()) {
                return cVar.b().a();
            }
            f0 f0VarJ = f0.J(jVar.z());
            if (setC.isEmpty()) {
                return (f0VarJ.size() > 3 ? co.l.D(f0VarJ) : qm.b.g(y.N(f0VarJ.K(0)))).y();
            }
            throw new IllegalStateException("encoded parameters not acceptable");
        }
        y yVarN = y.N(jVar.z());
        if (!setC.isEmpty() && !setC.contains(yVarN)) {
            throw new IllegalStateException("named curve not acceptable");
        }
        co.l lVarJ = i.j(yVarN);
        if (lVarJ == null) {
            lVarJ = (co.l) cVar.a().get(yVarN);
        }
        return lVarJ.y();
    }

    public static g0 m(uq.c cVar, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return i.g(cVar, g(eCParameterSpec));
        }
        gr.e eVarB = cVar.b();
        return new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c(), eVarB.e());
    }
}
