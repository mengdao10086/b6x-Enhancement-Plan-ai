package ir;

import ir.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    public static i a(e eVar, i iVar) {
        if (eVar.m(iVar.i())) {
            return eVar.k(iVar.l(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static i b(i iVar) {
        if (iVar.y()) {
            return iVar;
        }
        throw new IllegalStateException("Invalid result");
    }

    public static i c(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        i iVarA;
        i iVarB;
        e eVarI = iVar.i();
        int iA = m.a(eVarI);
        if (bigInteger.bitLength() > iA || bigInteger2.bitLength() > iA) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        l lVarC = m.c(iVar);
        l lVarC2 = m.c(iVar2);
        g gVarA = lVarC.a();
        g gVarA2 = lVarC2.a();
        int iC = lVarC.c();
        if (iC != lVarC2.c()) {
            k kVar = new k();
            iVarA = kVar.a(iVar, bigInteger);
            iVarB = kVar.a(iVar2, bigInteger2);
        } else {
            int i10 = ((iA + iC) - 1) / iC;
            i iVarW = eVarI.w();
            int i11 = iC * i10;
            int[] iArrT = rr.o.T(i11, bigInteger);
            int[] iArrT2 = rr.o.T(i11, bigInteger2);
            int i12 = i11 - 1;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = 0;
                int i15 = 0;
                for (int i16 = i12 - i13; i16 >= 0; i16 -= i10) {
                    int i17 = i16 >>> 5;
                    int i18 = i16 & 31;
                    int i19 = iArrT[i17] >>> i18;
                    i14 = ((i14 ^ (i19 >>> 1)) << 1) ^ i19;
                    int i20 = iArrT2[i17] >>> i18;
                    i15 = ((i15 ^ (i20 >>> 1)) << 1) ^ i20;
                }
                iVarW = iVarW.N(gVarA.b(i14).a(gVarA2.b(i15)));
            }
            iVarA = iVarW.a(lVarC.b());
            iVarB = lVarC2.b();
        }
        return iVarA.a(iVarB);
    }

    public static i d(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        e eVarI = iVar.i();
        i iVarW = eVarI.w();
        i[] iVarArr = {iVar2, iVar.J(iVar2), iVar, iVar.a(iVar2)};
        eVarI.C(iVarArr);
        i[] iVarArr2 = {iVarArr[3].A(), iVarArr[2].A(), iVarArr[1].A(), iVarArr[0].A(), iVarW, iVarArr[0], iVarArr[1], iVarArr[2], iVarArr[3]};
        byte[] bArrF = b0.f(bigInteger, bigInteger2);
        int length = bArrF.length;
        while (true) {
            length--;
            if (length < 0) {
                return iVarW;
            }
            byte b10 = bArrF[length];
            iVarW = iVarW.N(iVarArr2[(((b10 << 24) >> 28) * 3) + 4 + ((b10 << 28) >> 28)]);
        }
    }

    public static i e(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        boolean z10 = bigInteger.signum() < 0;
        boolean z11 = bigInteger2.signum() < 0;
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        int iM = b0.m(bigIntegerAbs.bitLength(), 8);
        int iM2 = b0.m(bigIntegerAbs2.bitLength(), 8);
        a0 a0VarP = b0.p(iVar, iM, true);
        a0 a0VarP2 = b0.p(iVar2, iM2, true);
        int iA = m.a(iVar.i());
        if (!z10 && !z11 && bigInteger.bitLength() <= iA && bigInteger2.bitLength() <= iA && a0VarP.h() && a0VarP2.h()) {
            return c(iVar, bigInteger, iVar2, bigInteger2);
        }
        int iMin = Math.min(8, a0VarP.g());
        int iMin2 = Math.min(8, a0VarP2.g());
        return g(z10 ? a0VarP.d() : a0VarP.c(), z10 ? a0VarP.c() : a0VarP.d(), b0.h(iMin, bigIntegerAbs), z11 ? a0VarP2.d() : a0VarP2.c(), z11 ? a0VarP2.c() : a0VarP2.d(), b0.h(iMin2, bigIntegerAbs2));
    }

    public static i f(mr.a aVar, i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z10 = bigInteger.signum() < 0;
        boolean z11 = bigInteger2.signum() < 0;
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        a0 a0VarP = b0.p(iVar, b0.m(Math.max(bigIntegerAbs.bitLength(), bigIntegerAbs2.bitLength()), 8), true);
        a0 a0VarQ = b0.q(mr.c.c(aVar, iVar), aVar.a(), a0VarP, true);
        int iMin = Math.min(8, a0VarP.g());
        int iMin2 = Math.min(8, a0VarQ.g());
        return g(z10 ? a0VarP.d() : a0VarP.c(), z10 ? a0VarP.c() : a0VarP.d(), b0.h(iMin, bigIntegerAbs), z11 ? a0VarQ.d() : a0VarQ.c(), z11 ? a0VarQ.c() : a0VarQ.d(), b0.h(iMin2, bigIntegerAbs2));
    }

    public static i g(i[] iVarArr, i[] iVarArr2, byte[] bArr, i[] iVarArr3, i[] iVarArr4, byte[] bArr2) {
        i iVarA;
        int iMax = Math.max(bArr.length, bArr2.length);
        i iVarW = iVarArr[0].i().w();
        int i10 = iMax - 1;
        i iVarN = iVarW;
        int i11 = 0;
        while (i10 >= 0) {
            byte b10 = i10 < bArr.length ? bArr[i10] : (byte) 0;
            byte b11 = i10 < bArr2.length ? bArr2[i10] : (byte) 0;
            if ((b10 | b11) == 0) {
                i11++;
            } else {
                if (b10 != 0) {
                    iVarA = iVarW.a((b10 < 0 ? iVarArr2 : iVarArr)[Math.abs((int) b10) >>> 1]);
                } else {
                    iVarA = iVarW;
                }
                if (b11 != 0) {
                    iVarA = iVarA.a((b11 < 0 ? iVarArr4 : iVarArr3)[Math.abs((int) b11) >>> 1]);
                }
                if (i11 > 0) {
                    iVarN = iVarN.L(i11);
                    i11 = 0;
                }
                iVarN = iVarN.N(iVarA);
            }
            i10--;
        }
        return i11 > 0 ? iVarN.L(i11) : iVarN;
    }

    public static i h(mr.a aVar, i[] iVarArr, BigInteger[] bigIntegerArr) {
        i[] iVarArr2 = iVarArr;
        int length = iVarArr2.length;
        int i10 = length << 1;
        boolean[] zArr = new boolean[i10];
        a0[] a0VarArr = new a0[i10];
        byte[][] bArr = new byte[i10][];
        j jVarA = aVar.a();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 << 1;
            int i13 = i12 + 1;
            BigInteger bigInteger = bigIntegerArr[i12];
            zArr[i12] = bigInteger.signum() < 0;
            BigInteger bigIntegerAbs = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr[i13];
            zArr[i13] = bigInteger2.signum() < 0;
            BigInteger bigIntegerAbs2 = bigInteger2.abs();
            int iM = b0.m(Math.max(bigIntegerAbs.bitLength(), bigIntegerAbs2.bitLength()), 8);
            i iVar = iVarArr2[i11];
            a0 a0VarP = b0.p(iVar, iM, true);
            a0 a0VarQ = b0.q(mr.c.c(aVar, iVar), jVarA, a0VarP, true);
            int iMin = Math.min(8, a0VarP.g());
            int iMin2 = Math.min(8, a0VarQ.g());
            a0VarArr[i12] = a0VarP;
            a0VarArr[i13] = a0VarQ;
            bArr[i12] = b0.h(iMin, bigIntegerAbs);
            bArr[i13] = b0.h(iMin2, bigIntegerAbs2);
            i11++;
            iVarArr2 = iVarArr;
        }
        return j(zArr, a0VarArr, bArr);
    }

    public static i i(i[] iVarArr, BigInteger[] bigIntegerArr) {
        int length = iVarArr.length;
        boolean[] zArr = new boolean[length];
        a0[] a0VarArr = new a0[length];
        byte[][] bArr = new byte[length][];
        for (int i10 = 0; i10 < length; i10++) {
            BigInteger bigInteger = bigIntegerArr[i10];
            zArr[i10] = bigInteger.signum() < 0;
            BigInteger bigIntegerAbs = bigInteger.abs();
            a0 a0VarP = b0.p(iVarArr[i10], b0.m(bigIntegerAbs.bitLength(), 8), true);
            int iMin = Math.min(8, a0VarP.g());
            a0VarArr[i10] = a0VarP;
            bArr[i10] = b0.h(iMin, bigIntegerAbs);
        }
        return j(zArr, a0VarArr, bArr);
    }

    public static i j(boolean[] zArr, a0[] a0VarArr, byte[][] bArr) {
        int length = bArr.length;
        int iMax = 0;
        for (byte[] bArr2 : bArr) {
            iMax = Math.max(iMax, bArr2.length);
        }
        i iVarW = a0VarArr[0].c()[0].i().w();
        int i10 = iMax - 1;
        i iVarN = iVarW;
        int i11 = 0;
        while (i10 >= 0) {
            i iVarA = iVarW;
            for (int i12 = 0; i12 < length; i12++) {
                byte[] bArr3 = bArr[i12];
                byte b10 = i10 < bArr3.length ? bArr3[i10] : (byte) 0;
                if (b10 != 0) {
                    int iAbs = Math.abs((int) b10);
                    a0 a0Var = a0VarArr[i12];
                    iVarA = iVarA.a(((b10 < 0) == zArr[i12] ? a0Var.c() : a0Var.d())[iAbs >>> 1]);
                }
            }
            if (iVarA == iVarW) {
                i11++;
            } else {
                if (i11 > 0) {
                    iVarN = iVarN.L(i11);
                    i11 = 0;
                }
                iVarN = iVarN.N(iVarA);
            }
            i10--;
        }
        return i11 > 0 ? iVarN.L(i11) : iVarN;
    }

    public static i k(i[] iVarArr, BigInteger[] bigIntegerArr, mr.d dVar) {
        BigInteger bigIntegerY = iVarArr[0].i().y();
        int length = iVarArr.length;
        int i10 = length << 1;
        BigInteger[] bigIntegerArr2 = new BigInteger[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            BigInteger[] bigIntegerArrC = dVar.c(bigIntegerArr[i12].mod(bigIntegerY));
            int i13 = i11 + 1;
            bigIntegerArr2[i11] = bigIntegerArrC[0];
            i11 = i13 + 1;
            bigIntegerArr2[i13] = bigIntegerArrC[1];
        }
        if (dVar.b()) {
            return h(dVar, iVarArr, bigIntegerArr2);
        }
        i[] iVarArr2 = new i[i10];
        int i14 = 0;
        for (i iVar : iVarArr) {
            i iVarC = mr.c.c(dVar, iVar);
            int i15 = i14 + 1;
            iVarArr2[i14] = iVar;
            i14 = i15 + 1;
            iVarArr2[i15] = iVarC;
        }
        return i(iVarArr2, bigIntegerArr2);
    }

    public static i l(e eVar, i iVar) {
        if (eVar.m(iVar.i())) {
            return eVar.A(iVar);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean m(e eVar) {
        return n(eVar.u());
    }

    public static boolean n(qr.b bVar) {
        return bVar.d() > 1 && bVar.e().equals(d.f35648c) && (bVar instanceof qr.g);
    }

    public static boolean o(e eVar) {
        return p(eVar.u());
    }

    public static boolean p(qr.b bVar) {
        return bVar.d() == 1;
    }

    public static void q(f[] fVarArr, int i10, int i11) {
        r(fVarArr, i10, i11, null);
    }

    public static void r(f[] fVarArr, int i10, int i11, f fVar) {
        f[] fVarArr2 = new f[i11];
        int i12 = 0;
        fVarArr2[0] = fVarArr[i10];
        while (true) {
            i12++;
            if (i12 >= i11) {
                break;
            } else {
                fVarArr2[i12] = fVarArr2[i12 - 1].k(fVarArr[i10 + i12]);
            }
        }
        int i13 = i12 - 1;
        if (fVar != null) {
            fVarArr2[i13] = fVarArr2[i13].k(fVar);
        }
        f fVarH = fVarArr2[i13].h();
        while (i13 > 0) {
            int i14 = i13 - 1;
            int i15 = i13 + i10;
            f fVar2 = fVarArr[i15];
            fVarArr[i15] = fVarArr2[i14].k(fVarH);
            fVarH = fVarH.k(fVar2);
            i13 = i14;
        }
        fVarArr[i10] = fVarH;
    }

    public static i s(i iVar, BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        i iVarW = iVar.i().w();
        int iBitLength = bigIntegerAbs.bitLength();
        if (iBitLength > 0) {
            if (bigIntegerAbs.testBit(0)) {
                iVarW = iVar;
            }
            for (int i10 = 1; i10 < iBitLength; i10++) {
                iVar = iVar.M();
                if (bigIntegerAbs.testBit(i10)) {
                    iVarW = iVarW.a(iVar);
                }
            }
        }
        return bigInteger.signum() < 0 ? iVarW.A() : iVarW;
    }

    public static i t(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        return b(d(iVar, bigInteger, l(iVar.i(), iVar2), bigInteger2));
    }

    public static i u(i[] iVarArr, BigInteger[] bigIntegerArr) {
        if (iVarArr != null && bigIntegerArr != null && iVarArr.length == bigIntegerArr.length) {
            if (iVarArr.length >= 1) {
                int length = iVarArr.length;
                if (length == 1) {
                    return iVarArr[0].z(bigIntegerArr[0]);
                }
                if (length == 2) {
                    return v(iVarArr[0], bigIntegerArr[0], iVarArr[1], bigIntegerArr[1]);
                }
                i iVar = iVarArr[0];
                e eVarI = iVar.i();
                i[] iVarArr2 = new i[length];
                iVarArr2[0] = iVar;
                for (int i10 = 1; i10 < length; i10++) {
                    iVarArr2[i10] = l(eVarI, iVarArr[i10]);
                }
                mr.a aVarT = eVarI.t();
                return aVarT instanceof mr.d ? b(k(iVarArr2, bigIntegerArr, (mr.d) aVarT)) : b(i(iVarArr2, bigIntegerArr));
            }
        }
        throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
    }

    public static i v(i iVar, BigInteger bigInteger, i iVar2, BigInteger bigInteger2) {
        i iVarK;
        e eVarI = iVar.i();
        i iVarL = l(eVarI, iVar2);
        if ((eVarI instanceof e.b) && ((e.b) eVarI).N()) {
            iVarK = iVar.z(bigInteger).a(iVarL.z(bigInteger2));
        } else {
            mr.a aVarT = eVarI.t();
            iVarK = aVarT instanceof mr.d ? k(new i[]{iVar, iVarL}, new BigInteger[]{bigInteger, bigInteger2}, (mr.d) aVarT) : e(iVar, bigInteger, iVarL, bigInteger2);
        }
        return b(iVarK);
    }

    public static i w(i iVar) {
        if (iVar.x()) {
            return iVar;
        }
        throw new IllegalStateException("Invalid point");
    }
}
