package ir;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class z extends b {
    @Override // ir.b
    public i c(i iVar, BigInteger bigInteger) {
        i iVarA;
        a0 a0VarP = b0.p(iVar, b0.l(bigInteger.bitLength()), true);
        i[] iVarArrC = a0VarP.c();
        i[] iVarArrD = a0VarP.d();
        int iG = a0VarP.g();
        int[] iArrE = b0.e(iG, bigInteger);
        i iVarW = iVar.i().w();
        int length = iArrE.length;
        if (length > 1) {
            length--;
            int i10 = iArrE[length];
            int i11 = i10 >> 16;
            int i12 = i10 & 65535;
            int iAbs = Math.abs(i11);
            i[] iVarArr = i11 < 0 ? iVarArrD : iVarArrC;
            if ((iAbs << 2) < (1 << iG)) {
                int iA = 32 - org.bouncycastle.util.j.a(iAbs);
                int i13 = iG - iA;
                iVarA = iVarArr[((1 << (iG - 1)) - 1) >>> 1].a(iVarArr[(((iAbs ^ (1 << (iA - 1))) << i13) + 1) >>> 1]);
                i12 -= i13;
            } else {
                iVarA = iVarArr[iAbs >>> 1];
            }
            iVarW = iVarA.L(i12);
        }
        while (length > 0) {
            length--;
            int i14 = iArrE[length];
            int i15 = i14 >> 16;
            iVarW = iVarW.N((i15 < 0 ? iVarArrD : iVarArrC)[Math.abs(i15) >>> 1]).L(i14 & 65535);
        }
        return iVarW;
    }
}
