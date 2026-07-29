package ir;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class k extends b {
    @Override // ir.b
    public i c(i iVar, BigInteger bigInteger) {
        e eVarI = iVar.i();
        if (bigInteger.bitLength() > m.a(eVarI)) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        l lVarC = m.c(iVar);
        g gVarA = lVarC.a();
        int iC = lVarC.c();
        int i10 = ((r1 + iC) - 1) / iC;
        i iVarW = eVarI.w();
        int i11 = iC * i10;
        int[] iArrT = rr.o.T(i11, bigInteger);
        int i12 = i11 - 1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = 0;
            for (int i15 = i12 - i13; i15 >= 0; i15 -= i10) {
                int i16 = iArrT[i15 >>> 5] >>> (i15 & 31);
                i14 = ((i14 ^ (i16 >>> 1)) << 1) ^ i16;
            }
            iVarW = iVarW.N(gVarA.a(i14));
        }
        return iVarW.a(lVarC.b());
    }
}
