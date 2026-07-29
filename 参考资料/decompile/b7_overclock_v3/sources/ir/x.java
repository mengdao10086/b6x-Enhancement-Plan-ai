package ir;

import ir.e;
import ir.i;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f35738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f35739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f35740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f35741d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f35742e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e0[] f35743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[][] f35744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e0[] f35745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[][] f35746i;

    static {
        BigInteger bigInteger = d.f35647b;
        BigInteger bigIntegerNegate = bigInteger.negate();
        f35738a = bigIntegerNegate;
        f35739b = d.f35648c.negate();
        BigInteger bigIntegerNegate2 = d.f35649d.negate();
        f35740c = bigIntegerNegate2;
        BigInteger bigInteger2 = d.f35646a;
        f35743f = new e0[]{null, new e0(bigInteger, bigInteger2), null, new e0(bigIntegerNegate2, bigIntegerNegate), null, new e0(bigIntegerNegate, bigIntegerNegate), null, new e0(bigInteger, bigIntegerNegate), null};
        f35744g = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        f35745h = new e0[]{null, new e0(bigInteger, bigInteger2), null, new e0(bigIntegerNegate2, bigInteger), null, new e0(bigIntegerNegate, bigInteger), null, new e0(bigInteger, bigInteger), null};
        f35746i = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public static v a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b10, int i10, int i11) {
        BigInteger bigIntegerMultiply = bigInteger2.multiply(bigInteger.shiftRight(((i10 - r0) - 2) + b10));
        BigInteger bigIntegerAdd = bigIntegerMultiply.add(bigInteger3.multiply(bigIntegerMultiply.shiftRight(i10)));
        int i12 = (((i10 + 5) / 2) + i11) - i11;
        BigInteger bigIntegerShiftRight = bigIntegerAdd.shiftRight(i12);
        if (bigIntegerAdd.testBit(i12 - 1)) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(d.f35647b);
        }
        return new v(bigIntegerShiftRight, i11);
    }

    public static BigInteger[] b(byte b10, int i10, boolean z10) {
        BigInteger bigInteger;
        BigInteger bigIntegerSubtract;
        if (b10 != 1 && b10 != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        if (z10) {
            bigInteger = d.f35648c;
            bigIntegerSubtract = BigInteger.valueOf(b10);
        } else {
            bigInteger = d.f35646a;
            bigIntegerSubtract = d.f35647b;
        }
        int i11 = 1;
        while (i11 < i10) {
            i11++;
            BigInteger bigInteger2 = bigIntegerSubtract;
            bigIntegerSubtract = (b10 == 1 ? bigIntegerSubtract : bigIntegerSubtract.negate()).subtract(bigInteger.shiftLeft(1));
            bigInteger = bigInteger2;
        }
        return new BigInteger[]{bigInteger, bigIntegerSubtract};
    }

    public static byte c(int i10) {
        return (byte) (i10 == 0 ? -1 : 1);
    }

    public static byte d(e.b bVar) {
        if (bVar.N()) {
            return bVar.o().j() ? (byte) -1 : (byte) 1;
        }
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    public static byte e(f fVar) {
        return (byte) (fVar.j() ? -1 : 1);
    }

    public static i.b[] f(i.b bVar, byte b10) {
        byte[][] bArr = b10 == 0 ? f35744g : f35746i;
        i.b[] bVarArr = new i.b[(bArr.length + 1) >>> 1];
        bVarArr[0] = bVar;
        int length = bArr.length;
        for (int i10 = 3; i10 < length; i10 += 2) {
            bVarArr[i10 >>> 1] = k(bVar, bArr[i10]);
        }
        bVar.i().C(bVarArr);
        return bVarArr;
    }

    public static int g(BigInteger bigInteger) {
        if (bigInteger != null) {
            if (bigInteger.equals(d.f35648c)) {
                return 1;
            }
            if (bigInteger.equals(d.f35650e)) {
                return 2;
            }
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    public static BigInteger[] h(int i10, int i11, BigInteger bigInteger) {
        byte bC = c(i11);
        int iG = g(bigInteger);
        BigInteger[] bigIntegerArrB = b(bC, (i10 + 3) - i11, false);
        if (bC == 1) {
            bigIntegerArrB[0] = bigIntegerArrB[0].negate();
            bigIntegerArrB[1] = bigIntegerArrB[1].negate();
        }
        BigInteger bigInteger2 = d.f35647b;
        return new BigInteger[]{bigInteger2.add(bigIntegerArrB[1]).shiftRight(iG), bigInteger2.add(bigIntegerArrB[0]).shiftRight(iG).negate()};
    }

    public static BigInteger[] i(e.b bVar) {
        if (!bVar.N()) {
            throw new IllegalArgumentException("si is defined for Koblitz curves only");
        }
        int iV = bVar.v();
        int iIntValue = bVar.o().v().intValue();
        byte bC = c(iIntValue);
        int iG = g(bVar.r());
        BigInteger[] bigIntegerArrB = b(bC, (iV + 3) - iIntValue, false);
        if (bC == 1) {
            bigIntegerArrB[0] = bigIntegerArrB[0].negate();
            bigIntegerArrB[1] = bigIntegerArrB[1].negate();
        }
        BigInteger bigInteger = d.f35647b;
        return new BigInteger[]{bigInteger.add(bigIntegerArrB[1]).shiftRight(iG), bigInteger.add(bigIntegerArrB[0]).shiftRight(iG).negate()};
    }

    public static BigInteger j(byte b10, int i10) {
        if (i10 == 4) {
            return b10 == 1 ? BigInteger.valueOf(6L) : BigInteger.valueOf(10L);
        }
        BigInteger[] bigIntegerArrB = b(b10, i10, false);
        BigInteger bit = d.f35646a.setBit(i10);
        return d.f35648c.multiply(bigIntegerArrB[0]).multiply(bigIntegerArrB[1].modInverse(bit)).mod(bit);
    }

    public static i.b k(i.b bVar, byte[] bArr) {
        i.b bVar2 = (i.b) bVar.i().w();
        i.b bVar3 = (i.b) bVar.A();
        int i10 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i10++;
            byte b10 = bArr[length];
            if (b10 != 0) {
                bVar2 = (i.b) bVar2.P(i10).a(b10 > 0 ? bVar : bVar3);
                i10 = 0;
            }
        }
        return i10 > 0 ? bVar2.P(i10) : bVar2;
    }

    public static i.b l(i.b bVar, BigInteger bigInteger) {
        e.b bVar2 = (e.b) bVar.i();
        int iV = bVar2.v();
        int iIntValue = bVar2.o().v().intValue();
        return m(bVar, p(bigInteger, iV, (byte) iIntValue, bVar2.K(), c(iIntValue), (byte) 10));
    }

    public static i.b m(i.b bVar, e0 e0Var) {
        return k(bVar, s(e(((e.b) bVar.i()).o()), e0Var));
    }

    public static v n(byte b10, v vVar, v vVar2) {
        v vVarS;
        v vVarN = vVar.n(vVar);
        v vVarN2 = vVar.n(vVar2);
        v vVarR = vVar2.n(vVar2).r(1);
        if (b10 == 1) {
            vVarS = vVarN.a(vVarN2);
        } else {
            if (b10 != -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            vVarS = vVarN.s(vVarN2);
        }
        return vVarS.a(vVarR);
    }

    public static BigInteger o(byte b10, e0 e0Var) {
        BigInteger bigIntegerSubtract;
        BigInteger bigInteger = e0Var.f35693a;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger);
        BigInteger bigIntegerMultiply2 = e0Var.f35693a.multiply(e0Var.f35694b);
        BigInteger bigInteger2 = e0Var.f35694b;
        BigInteger bigIntegerShiftLeft = bigInteger2.multiply(bigInteger2).shiftLeft(1);
        if (b10 == 1) {
            bigIntegerSubtract = bigIntegerMultiply.add(bigIntegerMultiply2);
        } else {
            if (b10 != -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            bigIntegerSubtract = bigIntegerMultiply.subtract(bigIntegerMultiply2);
        }
        return bigIntegerSubtract.add(bigIntegerShiftLeft);
    }

    public static e0 p(BigInteger bigInteger, int i10, byte b10, BigInteger[] bigIntegerArr, byte b11, byte b12) {
        BigInteger bigIntegerAdd = b11 == 1 ? bigIntegerArr[0].add(bigIntegerArr[1]) : bigIntegerArr[0].subtract(bigIntegerArr[1]);
        BigInteger bigInteger2 = b(b11, i10, true)[1];
        e0 e0VarQ = q(a(bigInteger, bigIntegerArr[0], bigInteger2, b10, i10, b12), a(bigInteger, bigIntegerArr[1], bigInteger2, b10, i10, b12), b11);
        return new e0(bigInteger.subtract(bigIntegerAdd.multiply(e0VarQ.f35693a)).subtract(BigInteger.valueOf(2L).multiply(bigIntegerArr[1]).multiply(e0VarQ.f35694b)), bigIntegerArr[1].multiply(e0VarQ.f35693a).subtract(bigIntegerArr[0].multiply(e0VarQ.f35694b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        if (r5.f(ir.x.f35738a) < 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (r5.f(r9) >= 0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.e0 q(ir.v r8, ir.v r9, byte r10) {
        /*
            int r0 = r8.k()
            int r1 = r9.k()
            if (r1 != r0) goto La5
            r0 = -1
            r1 = 1
            if (r10 == r1) goto L19
            if (r10 != r0) goto L11
            goto L19
        L11:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "mu must be 1 or -1"
            r8.<init>(r9)
            throw r8
        L19:
            java.math.BigInteger r2 = r8.q()
            java.math.BigInteger r3 = r9.q()
            ir.v r8 = r8.t(r2)
            ir.v r9 = r9.t(r3)
            ir.v r4 = r8.a(r8)
            if (r10 != r1) goto L34
            ir.v r4 = r4.a(r9)
            goto L38
        L34:
            ir.v r4 = r4.s(r9)
        L38:
            ir.v r5 = r9.a(r9)
            ir.v r5 = r5.a(r9)
            ir.v r9 = r5.a(r9)
            if (r10 != r1) goto L4f
            ir.v r5 = r8.s(r5)
            ir.v r8 = r8.a(r9)
            goto L57
        L4f:
            ir.v r5 = r8.a(r5)
            ir.v r8 = r8.s(r9)
        L57:
            java.math.BigInteger r9 = ir.d.f35647b
            int r6 = r4.f(r9)
            r7 = 0
            if (r6 < 0) goto L69
            java.math.BigInteger r6 = ir.x.f35738a
            int r6 = r5.f(r6)
            if (r6 >= 0) goto L73
            goto L71
        L69:
            java.math.BigInteger r1 = ir.d.f35648c
            int r1 = r8.f(r1)
            if (r1 < 0) goto L72
        L71:
            r7 = r10
        L72:
            r1 = 0
        L73:
            java.math.BigInteger r6 = ir.x.f35738a
            int r4 = r4.f(r6)
            if (r4 >= 0) goto L82
            int r8 = r5.f(r9)
            if (r8 < 0) goto L8d
            goto L8a
        L82:
            java.math.BigInteger r9 = ir.x.f35739b
            int r8 = r8.f(r9)
            if (r8 >= 0) goto L8c
        L8a:
            int r8 = -r10
            byte r7 = (byte) r8
        L8c:
            r0 = r1
        L8d:
            long r8 = (long) r0
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r8)
            java.math.BigInteger r8 = r2.add(r8)
            long r9 = (long) r7
            java.math.BigInteger r9 = java.math.BigInteger.valueOf(r9)
            java.math.BigInteger r9 = r3.add(r9)
            ir.e0 r10 = new ir.e0
            r10.<init>(r8, r9)
            return r10
        La5:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "lambda0 and lambda1 do not have same scale"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.x.q(ir.v, ir.v, byte):ir.e0");
    }

    public static i.b r(i.b bVar) {
        return bVar.O();
    }

    public static byte[] s(byte b10, e0 e0Var) {
        if (b10 != 1 && b10 != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int iBitLength = o(b10, e0Var).bitLength();
        byte[] bArr = new byte[iBitLength > 30 ? iBitLength + 4 : 34];
        BigInteger bigIntegerClearBit = e0Var.f35693a;
        BigInteger bigInteger = e0Var.f35694b;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            BigInteger bigInteger2 = d.f35646a;
            if (bigIntegerClearBit.equals(bigInteger2) && bigInteger.equals(bigInteger2)) {
                int i12 = i10 + 1;
                byte[] bArr2 = new byte[i12];
                System.arraycopy(bArr, 0, bArr2, 0, i12);
                return bArr2;
            }
            if (bigIntegerClearBit.testBit(0)) {
                bArr[i11] = (byte) d.f35648c.subtract(bigIntegerClearBit.subtract(bigInteger.shiftLeft(1)).mod(d.f35650e)).intValue();
                bigIntegerClearBit = bArr[i11] == 1 ? bigIntegerClearBit.clearBit(0) : bigIntegerClearBit.add(d.f35647b);
                i10 = i11;
            } else {
                bArr[i11] = 0;
            }
            BigInteger bigIntegerShiftRight = bigIntegerClearBit.shiftRight(1);
            BigInteger bigIntegerAdd = b10 == 1 ? bigInteger.add(bigIntegerShiftRight) : bigInteger.subtract(bigIntegerShiftRight);
            BigInteger bigIntegerNegate = bigIntegerClearBit.shiftRight(1).negate();
            i11++;
            bigIntegerClearBit = bigIntegerAdd;
            bigInteger = bigIntegerNegate;
        }
    }

    public static byte[] t(byte b10, e0 e0Var, byte b11, BigInteger bigInteger, BigInteger bigInteger2, e0[] e0VarArr) {
        boolean z10;
        if (b10 != 1 && b10 != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int iBitLength = o(b10, e0Var).bitLength();
        byte[] bArr = new byte[iBitLength > 30 ? iBitLength + 4 + b11 : b11 + 34];
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(1);
        BigInteger bigIntegerAdd = e0Var.f35693a;
        BigInteger bigIntegerAdd2 = e0Var.f35694b;
        int i10 = 0;
        while (true) {
            BigInteger bigInteger3 = d.f35646a;
            if (bigIntegerAdd.equals(bigInteger3) && bigIntegerAdd2.equals(bigInteger3)) {
                return bArr;
            }
            if (bigIntegerAdd.testBit(0)) {
                BigInteger bigIntegerMod = bigIntegerAdd.add(bigIntegerAdd2.multiply(bigInteger2)).mod(bigInteger);
                if (bigIntegerMod.compareTo(bigIntegerShiftRight) >= 0) {
                    bigIntegerMod = bigIntegerMod.subtract(bigInteger);
                }
                byte bIntValue = (byte) bigIntegerMod.intValue();
                bArr[i10] = bIntValue;
                if (bIntValue < 0) {
                    bIntValue = (byte) (-bIntValue);
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    bigIntegerAdd = bigIntegerAdd.subtract(e0VarArr[bIntValue].f35693a);
                    bigIntegerAdd2 = bigIntegerAdd2.subtract(e0VarArr[bIntValue].f35694b);
                } else {
                    bigIntegerAdd = bigIntegerAdd.add(e0VarArr[bIntValue].f35693a);
                    bigIntegerAdd2 = bigIntegerAdd2.add(e0VarArr[bIntValue].f35694b);
                }
            } else {
                bArr[i10] = 0;
            }
            BigInteger bigIntegerShiftRight2 = bigIntegerAdd.shiftRight(1);
            BigInteger bigIntegerAdd3 = b10 == 1 ? bigIntegerAdd2.add(bigIntegerShiftRight2) : bigIntegerAdd2.subtract(bigIntegerShiftRight2);
            BigInteger bigIntegerNegate = bigIntegerAdd.shiftRight(1).negate();
            i10++;
            bigIntegerAdd = bigIntegerAdd3;
            bigIntegerAdd2 = bigIntegerNegate;
        }
    }
}
