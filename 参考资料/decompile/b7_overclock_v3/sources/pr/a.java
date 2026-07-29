package pr;

import co.l;
import com.bumptech.glide.load.engine.GlideException;
import ir.d;
import ir.e;
import ir.f;
import ir.i;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;
import m9.h;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f47011a = 16;

    public static void A(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger[] bigIntegerArrI = i(bigInteger, bigInteger2);
        BigInteger[] bigIntegerArr = {bigIntegerArrI[2], bigIntegerArrI[3].negate()};
        BigInteger[] bigIntegerArrC = c(new BigInteger[]{bigIntegerArrI[0], bigIntegerArrI[1].negate()}, new BigInteger[]{bigIntegerArrI[4], bigIntegerArrI[5].negate()});
        if (!p(bigIntegerArrC, bigInteger) && a(bigIntegerArr[0], bigIntegerArr[1])) {
            BigInteger bigInteger3 = bigIntegerArr[0];
            BigInteger bigInteger4 = bigIntegerArr[1];
            BigInteger bigIntegerDivide = bigInteger3.add(bigInteger4.multiply(bigInteger2)).divide(bigInteger);
            BigInteger[] bigIntegerArrH = h(new BigInteger[]{bigIntegerDivide.abs(), bigInteger4.abs()});
            if (bigIntegerArrH != null) {
                BigInteger bigIntegerNegate = bigIntegerArrH[0];
                BigInteger bigIntegerNegate2 = bigIntegerArrH[1];
                if (bigIntegerDivide.signum() < 0) {
                    bigIntegerNegate = bigIntegerNegate.negate();
                }
                if (bigInteger4.signum() > 0) {
                    bigIntegerNegate2 = bigIntegerNegate2.negate();
                }
                BigInteger bigIntegerSubtract = bigIntegerDivide.multiply(bigIntegerNegate).subtract(bigInteger4.multiply(bigIntegerNegate2));
                BigInteger bigInteger5 = d.f35647b;
                if (!bigIntegerSubtract.equals(bigInteger5)) {
                    throw new IllegalStateException();
                }
                BigInteger bigIntegerSubtract2 = bigIntegerNegate2.multiply(bigInteger).subtract(bigIntegerNegate.multiply(bigInteger2));
                BigInteger bigIntegerNegate3 = bigIntegerNegate.negate();
                BigInteger bigIntegerNegate4 = bigIntegerSubtract2.negate();
                BigInteger bigIntegerAdd = q(bigInteger.subtract(bigInteger5)).add(bigInteger5);
                BigInteger[] bigIntegerArrM = m(b(bigIntegerNegate3, bigIntegerAdd, bigInteger4), b(bigIntegerNegate4, bigIntegerAdd, bigInteger3));
                if (bigIntegerArrM != null) {
                    for (BigInteger bigIntegerAdd2 = bigIntegerArrM[0]; bigIntegerAdd2.compareTo(bigIntegerArrM[1]) <= 0; bigIntegerAdd2 = bigIntegerAdd2.add(d.f35647b)) {
                        BigInteger[] bigIntegerArr2 = {bigIntegerSubtract2.add(bigIntegerAdd2.multiply(bigInteger3)), bigIntegerNegate.add(bigIntegerAdd2.multiply(bigInteger4))};
                        if (o(bigIntegerArr2, bigIntegerArrC)) {
                            bigIntegerArrC = bigIntegerArr2;
                        }
                    }
                }
            }
        }
        BigInteger bigIntegerSubtract3 = bigIntegerArr[0].multiply(bigIntegerArrC[1]).subtract(bigIntegerArr[1].multiply(bigIntegerArrC[0]));
        int iBitLength = (bigInteger.bitLength() + 16) - (bigInteger.bitLength() & 7);
        BigInteger bigIntegerB = B(bigIntegerArrC[1].shiftLeft(iBitLength), bigIntegerSubtract3);
        BigInteger bigIntegerNegate5 = B(bigIntegerArr[1].shiftLeft(iBitLength), bigIntegerSubtract3).negate();
        z("v1", "{ " + bigIntegerArr[0].toString(16) + ", " + bigIntegerArr[1].toString(16) + " }");
        z("v2", "{ " + bigIntegerArrC[0].toString(16) + ", " + bigIntegerArrC[1].toString(16) + " }");
        z("d", bigIntegerSubtract3.toString(16));
        z("(OPT) g1", bigIntegerB.toString(16));
        z("(OPT) g2", bigIntegerNegate5.toString(16));
        z("(OPT) bits", Integer.toString(iBitLength));
    }

    public static BigInteger B(BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z10 = bigInteger.signum() != bigInteger2.signum();
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        BigInteger bigIntegerDivide = bigIntegerAbs.add(bigIntegerAbs2.shiftRight(1)).divide(bigIntegerAbs2);
        return z10 ? bigIntegerDivide.negate() : bigIntegerDivide;
    }

    public static BigInteger[] C(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        BigInteger bigIntegerS = s(bigInteger3.multiply(bigInteger3).subtract(bigInteger2.multiply(bigInteger4).shiftLeft(2)).mod(bigInteger), bigInteger);
        if (bigIntegerS == null) {
            throw new IllegalStateException("Solving quadratic equation failed unexpectedly");
        }
        BigInteger bigIntegerModInverse = bigInteger2.shiftLeft(1).modInverse(bigInteger);
        return new BigInteger[]{bigIntegerS.subtract(bigInteger3).multiply(bigIntegerModInverse).mod(bigInteger), bigIntegerS.negate().subtract(bigInteger3).multiply(bigIntegerModInverse).mod(bigInteger)};
    }

    public static void D(BigInteger[] bigIntegerArr) {
        BigInteger bigInteger = bigIntegerArr[0];
        bigIntegerArr[0] = bigIntegerArr[1];
        bigIntegerArr[1] = bigInteger;
    }

    public static boolean a(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.gcd(bigInteger2).equals(d.f35647b);
    }

    public static BigInteger[] b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return u(bigInteger.subtract(bigInteger2).divide(bigInteger3), bigInteger.add(bigInteger2).divide(bigInteger3));
    }

    public static BigInteger[] c(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        return o(bigIntegerArr, bigIntegerArr2) ? bigIntegerArr : bigIntegerArr2;
    }

    public static void d(l lVar) {
        Objects.requireNonNull(lVar, h.f40777t);
        e(lVar, "<UNKNOWN>");
    }

    public static void e(l lVar, String str) {
        e eVarY = lVar.y();
        if (ir.c.o(eVarY)) {
            BigInteger bigIntegerE = eVarY.u().e();
            if (eVarY.q().j() && bigIntegerE.mod(d.f35650e).equals(d.f35647b)) {
                System.out.println("Curve '" + str + "' has a 'GLV Type A' endomorphism with these parameters:");
                v(lVar);
            }
            if (eVarY.o().j() && bigIntegerE.mod(d.f35649d).equals(d.f35647b)) {
                System.out.println("Curve '" + str + "' has a 'GLV Type B' endomorphism with these parameters:");
                x(lVar);
            }
        }
    }

    public static void f(String str) {
        l lVarJ = ap.a.j(str);
        if (lVarJ != null || (lVarJ = co.e.b(str)) != null) {
            e(lVarJ, str);
            return;
        }
        System.err.println("Unknown curve: " + str);
    }

    public static ArrayList g(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static BigInteger[] h(BigInteger[] bigIntegerArr) {
        boolean z10 = bigIntegerArr[0].compareTo(bigIntegerArr[1]) < 0;
        if (z10) {
            D(bigIntegerArr);
        }
        BigInteger bigInteger = bigIntegerArr[0];
        BigInteger bigInteger2 = bigIntegerArr[1];
        BigInteger bigInteger3 = d.f35647b;
        BigInteger bigInteger4 = d.f35646a;
        BigInteger bigInteger5 = bigInteger3;
        BigInteger bigInteger6 = bigInteger4;
        BigInteger bigInteger7 = bigInteger2;
        BigInteger bigInteger8 = bigInteger;
        while (bigInteger7.compareTo(d.f35647b) > 0) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger8.divideAndRemainder(bigInteger7);
            BigInteger bigInteger9 = bigIntegerArrDivideAndRemainder[0];
            BigInteger bigInteger10 = bigIntegerArrDivideAndRemainder[1];
            BigInteger bigIntegerSubtract = bigInteger3.subtract(bigInteger9.multiply(bigInteger4));
            BigInteger bigIntegerSubtract2 = bigInteger6.subtract(bigInteger9.multiply(bigInteger5));
            BigInteger bigInteger11 = bigInteger7;
            bigInteger7 = bigInteger10;
            bigInteger8 = bigInteger11;
            BigInteger bigInteger12 = bigInteger4;
            bigInteger4 = bigIntegerSubtract;
            bigInteger3 = bigInteger12;
            bigInteger6 = bigInteger5;
            bigInteger5 = bigIntegerSubtract2;
        }
        if (bigInteger7.signum() <= 0) {
            return null;
        }
        BigInteger[] bigIntegerArr2 = {bigInteger4, bigInteger5};
        if (z10) {
            D(bigIntegerArr2);
        }
        return bigIntegerArr2;
    }

    public static BigInteger[] i(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = d.f35646a;
        BigInteger bigInteger4 = d.f35647b;
        BigInteger bigInteger5 = bigInteger;
        while (true) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger5.divideAndRemainder(bigInteger2);
            BigInteger bigInteger6 = bigIntegerArrDivideAndRemainder[0];
            BigInteger bigInteger7 = bigIntegerArrDivideAndRemainder[1];
            BigInteger bigIntegerSubtract = bigInteger3.subtract(bigInteger6.multiply(bigInteger4));
            if (n(bigInteger2, bigInteger)) {
                return new BigInteger[]{bigInteger5, bigInteger3, bigInteger2, bigInteger4, bigInteger7, bigIntegerSubtract};
            }
            bigInteger5 = bigInteger2;
            bigInteger3 = bigInteger4;
            bigInteger2 = bigInteger7;
            bigInteger4 = bigIntegerSubtract;
        }
    }

    public static f[] j(e eVar) {
        BigInteger bigIntegerModPow;
        BigInteger bigIntegerE = eVar.u().e();
        BigInteger bigIntegerDivide = bigIntegerE.divide(d.f35649d);
        SecureRandom secureRandom = new SecureRandom();
        do {
            BigInteger bigInteger = d.f35648c;
            bigIntegerModPow = org.bouncycastle.util.b.g(bigInteger, bigIntegerE.subtract(bigInteger), secureRandom).modPow(bigIntegerDivide, bigIntegerE);
        } while (bigIntegerModPow.equals(d.f35647b));
        f fVarN = eVar.n(bigIntegerModPow);
        return new f[]{fVarN, fVarN.p()};
    }

    public static f[] k(e eVar) {
        f fVarO = eVar.n(d.f35647b).n().o();
        if (fVarO != null) {
            return new f[]{fVarO, fVarO.n()};
        }
        throw new IllegalStateException("Calculation of non-trivial order-4  field elements failed unexpectedly");
    }

    public static BigInteger l(BigInteger bigInteger, BigInteger bigInteger2) {
        for (int i10 = 2; i10 < 1000; i10++) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(i10);
            if (!bigIntegerValueOf.modPow(bigInteger2, bigInteger).equals(d.f35647b)) {
                return bigIntegerValueOf;
            }
        }
        throw new IllegalStateException();
    }

    public static BigInteger[] m(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        BigInteger bigIntegerMax = bigIntegerArr[0].max(bigIntegerArr2[0]);
        BigInteger bigIntegerMin = bigIntegerArr[1].min(bigIntegerArr2[1]);
        if (bigIntegerMax.compareTo(bigIntegerMin) > 0) {
            return null;
        }
        return new BigInteger[]{bigIntegerMax, bigIntegerMin};
    }

    public static boolean n(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        int iBitLength = bigIntegerAbs2.bitLength();
        int iBitLength2 = bigIntegerAbs.bitLength() * 2;
        return iBitLength2 + (-1) <= iBitLength && (iBitLength2 < iBitLength || bigIntegerAbs.multiply(bigIntegerAbs).compareTo(bigIntegerAbs2) < 0);
    }

    public static boolean o(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        BigInteger bigIntegerAbs = bigIntegerArr[0].abs();
        BigInteger bigIntegerAbs2 = bigIntegerArr[1].abs();
        BigInteger bigIntegerAbs3 = bigIntegerArr2[0].abs();
        BigInteger bigIntegerAbs4 = bigIntegerArr2[1].abs();
        boolean z10 = bigIntegerAbs.compareTo(bigIntegerAbs3) < 0;
        return z10 == (bigIntegerAbs2.compareTo(bigIntegerAbs4) < 0) ? z10 : bigIntegerAbs.multiply(bigIntegerAbs).add(bigIntegerAbs2.multiply(bigIntegerAbs2)).compareTo(bigIntegerAbs3.multiply(bigIntegerAbs3).add(bigIntegerAbs4.multiply(bigIntegerAbs4))) < 0;
    }

    public static boolean p(BigInteger[] bigIntegerArr, BigInteger bigInteger) {
        return n(bigIntegerArr[0].abs().max(bigIntegerArr[1].abs()), bigInteger);
    }

    public static BigInteger q(BigInteger bigInteger) {
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(bigInteger.bitLength() / 2);
        while (true) {
            BigInteger bigIntegerShiftRight2 = bigIntegerShiftRight.add(bigInteger.divide(bigIntegerShiftRight)).shiftRight(1);
            if (bigIntegerShiftRight2.equals(bigIntegerShiftRight)) {
                return bigIntegerShiftRight2;
            }
            bigIntegerShiftRight = bigIntegerShiftRight2;
        }
    }

    public static void r(String[] strArr) {
        if (strArr.length > 0) {
            for (String str : strArr) {
                f(str);
            }
            return;
        }
        TreeSet treeSet = new TreeSet(g(co.e.e()));
        treeSet.addAll(g(ap.a.m()));
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            f((String) it2.next());
        }
    }

    public static BigInteger s(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger2.testBit(0)) {
            throw new IllegalStateException();
        }
        BigInteger bigInteger3 = d.f35647b;
        BigInteger bigIntegerShiftRight = bigInteger2.subtract(bigInteger3).shiftRight(1);
        if (!bigInteger.modPow(bigIntegerShiftRight, bigInteger2).equals(bigInteger3)) {
            return null;
        }
        BigInteger bigIntegerShiftRight2 = bigIntegerShiftRight;
        while (!bigIntegerShiftRight2.testBit(0)) {
            bigIntegerShiftRight2 = bigIntegerShiftRight2.shiftRight(1);
            if (!bigInteger.modPow(bigIntegerShiftRight2, bigInteger2).equals(d.f35647b)) {
                return t(bigInteger, bigIntegerShiftRight2, bigInteger2, bigIntegerShiftRight);
            }
        }
        return bigInteger.modPow(bigIntegerShiftRight2.add(d.f35647b).shiftRight(1), bigInteger2);
    }

    public static BigInteger t(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        BigInteger bigIntegerL = l(bigInteger3, bigInteger4);
        BigInteger bigIntegerShiftRight = bigInteger4;
        while (!bigInteger2.testBit(0)) {
            bigInteger2 = bigInteger2.shiftRight(1);
            bigIntegerShiftRight = bigIntegerShiftRight.shiftRight(1);
            if (!bigInteger.modPow(bigInteger2, bigInteger3).equals(bigIntegerL.modPow(bigIntegerShiftRight, bigInteger3))) {
                bigIntegerShiftRight = bigIntegerShiftRight.add(bigInteger4);
            }
        }
        return bigInteger.modInverse(bigInteger3).modPow(bigInteger2.subtract(d.f35647b).shiftRight(1), bigInteger3).multiply(bigIntegerL.modPow(bigIntegerShiftRight.shiftRight(1), bigInteger3)).mod(bigInteger3);
    }

    public static BigInteger[] u(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(bigInteger2) <= 0 ? new BigInteger[]{bigInteger, bigInteger2} : new BigInteger[]{bigInteger2, bigInteger};
    }

    public static void v(l lVar) {
        BigInteger bigIntegerE = lVar.E();
        BigInteger bigInteger = d.f35647b;
        BigInteger[] bigIntegerArrC = C(bigIntegerE, bigInteger, d.f35646a, bigInteger);
        f[] fVarArrK = k(lVar.y());
        w(lVar, bigIntegerArrC[0], fVarArrK);
        System.out.println("OR");
        w(lVar, bigIntegerArrC[1], fVarArrK);
    }

    public static void w(l lVar, BigInteger bigInteger, f[] fVarArr) {
        i iVarB = lVar.B().B();
        i iVarB2 = iVarB.z(bigInteger).B();
        if (!iVarB.q().n().equals(iVarB2.q())) {
            throw new IllegalStateException("Derivation of GLV Type A parameters failed unexpectedly");
        }
        f fVar = fVarArr[0];
        if (!iVarB.r().k(fVar).equals(iVarB2.r())) {
            fVar = fVarArr[1];
            if (!iVarB.r().k(fVar).equals(iVarB2.r())) {
                throw new IllegalStateException("Derivation of GLV Type A parameters failed unexpectedly");
            }
        }
        z("Point map", "lambda * (x, y) = (-x, i * y)");
        z("i", fVar.v().toString(16));
        z("lambda", bigInteger.toString(16));
        A(lVar.E(), bigInteger);
    }

    public static void x(l lVar) {
        BigInteger bigIntegerE = lVar.E();
        BigInteger bigInteger = d.f35647b;
        BigInteger[] bigIntegerArrC = C(bigIntegerE, bigInteger, bigInteger, bigInteger);
        f[] fVarArrJ = j(lVar.y());
        y(lVar, bigIntegerArrC[0], fVarArrJ);
        System.out.println("OR");
        y(lVar, bigIntegerArrC[1], fVarArrJ);
    }

    public static void y(l lVar, BigInteger bigInteger, f[] fVarArr) {
        i iVarB = lVar.B().B();
        i iVarB2 = iVarB.z(bigInteger).B();
        if (!iVarB.r().equals(iVarB2.r())) {
            throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
        }
        f fVar = fVarArr[0];
        if (!iVarB.q().k(fVar).equals(iVarB2.q())) {
            fVar = fVarArr[1];
            if (!iVarB.q().k(fVar).equals(iVarB2.q())) {
                throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
            }
        }
        z("Point map", "lambda * (x, y) = (beta * x, y)");
        z("beta", fVar.v().toString(16));
        z("lambda", bigInteger.toString(16));
        A(lVar.E(), bigInteger);
    }

    public static void z(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer(GlideException.a.f12263d);
        stringBuffer.append(str);
        while (stringBuffer.length() < 20) {
            stringBuffer.append(zc.f.f58383m);
        }
        stringBuffer.append(": ");
        stringBuffer.append(obj.toString());
        System.out.println(stringBuffer.toString());
    }
}
