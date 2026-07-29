package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final short f45763a = -32126;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final short f45764b = -31869;

    public static u a(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i10, byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        if (bArr2 != null && bArr2.length >= lMSigParameters.d()) {
            return new u(lMSigParameters, lMOtsParameters, i10, bArr, 1 << lMSigParameters.c(), bArr2);
        }
        throw new IllegalArgumentException("root seed is less than " + lMSigParameters.d());
    }

    public static w b(n nVar) {
        return new w(nVar.i().e(), z.c(nVar.i(), nVar.k(), nVar.a()), nVar.l(), nVar.d());
    }

    public static w c(u uVar, byte[] bArr) {
        n nVarW = uVar.W();
        nVarW.update(bArr, 0, bArr.length);
        return b(nVarW);
    }

    public static boolean d(v vVar, n nVar) {
        w wVar = (w) nVar.m();
        LMSigParameters lMSigParametersC = wVar.c();
        int iC = lMSigParametersC.c();
        byte[][] bArrE = wVar.e();
        byte[] bArrG = z.g(nVar);
        int iD = (1 << iC) + wVar.d();
        byte[] bArrE2 = vVar.e();
        org.bouncycastle.crypto.s sVarA = b.a(lMSigParametersC.b());
        int iH = sVarA.h();
        byte[] bArr = new byte[iH];
        sVarA.update(bArrE2, 0, bArrE2.length);
        a0.e(iD, sVarA);
        a0.d(f45763a, sVarA);
        sVarA.update(bArrG, 0, bArrG.length);
        sVarA.c(bArr, 0);
        int i10 = 0;
        while (iD > 1) {
            if ((iD & 1) == 1) {
                sVarA.update(bArrE2, 0, bArrE2.length);
                a0.e(iD / 2, sVarA);
                a0.d(f45764b, sVarA);
                sVarA.update(bArrE[i10], 0, bArrE[i10].length);
                sVarA.update(bArr, 0, iH);
            } else {
                sVarA.update(bArrE2, 0, bArrE2.length);
                a0.e(iD / 2, sVarA);
                a0.d(f45764b, sVarA);
                sVarA.update(bArr, 0, iH);
                sVarA.update(bArrE[i10], 0, bArrE[i10].length);
            }
            sVarA.c(bArr, 0);
            iD /= 2;
            i10++;
        }
        return vVar.k(bArr);
    }

    public static boolean e(v vVar, w wVar, byte[] bArr) {
        n nVarD = vVar.d(wVar);
        a0.b(bArr, nVarD);
        return d(vVar, nVarD);
    }

    public static boolean f(v vVar, byte[] bArr, byte[] bArr2) {
        n nVarA = vVar.a(bArr);
        a0.b(bArr2, nVarA);
        return d(vVar, nVarA);
    }
}
