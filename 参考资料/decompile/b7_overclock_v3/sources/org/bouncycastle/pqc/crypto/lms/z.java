package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes6.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final short f45802a = -32640;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f45803b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f45804c = 23;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f45805d = 22;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f45806e = -3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f45807f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f45808g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final short f45809h = -32383;

    public static int a(byte[] bArr, int i10, LMOtsParameters lMOtsParameters) {
        int i11 = (1 << lMOtsParameters.i()) - 1;
        int iB = 0;
        for (int i12 = 0; i12 < (i10 * 8) / lMOtsParameters.i(); i12++) {
            iB = (iB + i11) - b(bArr, i12, lMOtsParameters.i());
        }
        return iB << lMOtsParameters.c();
    }

    public static int b(byte[] bArr, int i10, int i11) {
        int i12 = (i10 * i11) / 8;
        return (bArr[i12] >>> (((~i10) & ((8 / i11) - 1)) * i11)) & ((1 << i11) - 1);
    }

    public static l c(j jVar, byte[] bArr, byte[] bArr2) {
        LMOtsParameters lMOtsParametersD = jVar.d();
        int iD = lMOtsParametersD.d();
        int iE = lMOtsParametersD.e();
        int i10 = lMOtsParametersD.i();
        byte[] bArr3 = new byte[iE * iD];
        org.bouncycastle.crypto.s sVarA = b.a(lMOtsParametersD.b());
        b0 b0VarA = jVar.a();
        int iA = a(bArr, iD, lMOtsParametersD);
        bArr[iD] = (byte) ((iA >>> 8) & 255);
        bArr[iD + 1] = (byte) iA;
        int i11 = iD + 23;
        byte[] bArrB = a.i().d(jVar.b()).m(jVar.e()).k(0, i11).b();
        b0VarA.h(0);
        int i12 = 0;
        while (i12 < iE) {
            org.bouncycastle.util.o.K((short) i12, bArrB, 20);
            int i13 = 23;
            b0VarA.b(bArrB, i12 < iE + (-1), 23);
            int iB = b(bArr, i12, i10);
            for (int i14 = 0; i14 < iB; i14++) {
                bArrB[22] = (byte) i14;
                sVarA.update(bArrB, 0, i11);
                i13 = 23;
                sVarA.c(bArrB, 23);
            }
            System.arraycopy(bArrB, i13, bArr3, iD * i12, iD);
            i12++;
        }
        return new l(lMOtsParametersD, bArr2, bArr3);
    }

    public static l d(LMSigParameters lMSigParameters, j jVar, byte[][] bArr, byte[] bArr2, boolean z10) {
        byte[] bArrA;
        byte[] bArrK = new byte[34];
        if (z10) {
            bArrA = new byte[32];
            System.arraycopy(bArr2, 0, bArrK, 0, jVar.d().d());
        } else {
            n nVarF = jVar.f(lMSigParameters, bArr);
            a0.a(bArr2, 0, bArr2.length, nVarF);
            bArrA = nVarF.a();
            bArrK = nVarF.k();
        }
        return c(jVar, bArrK, bArrA);
    }

    public static boolean e(k kVar, l lVar, byte[] bArr, boolean z10) throws LMSException {
        if (lVar.c().equals(kVar.f())) {
            return org.bouncycastle.util.a.g(f(kVar, lVar, bArr), kVar.e());
        }
        throw new LMSException("public key and signature ots types do not match");
    }

    public static byte[] f(k kVar, l lVar, byte[] bArr) {
        n nVarA = kVar.a(lVar);
        a0.b(bArr, nVarA);
        return g(nVarA);
    }

    public static byte[] g(n nVar) {
        k kVarJ = nVar.j();
        LMOtsParameters lMOtsParametersF = kVarJ.f();
        Object objM = nVar.m();
        l lVarB = objM instanceof w ? ((w) objM).b() : (l) objM;
        int iD = lMOtsParametersF.d();
        int i10 = lMOtsParametersF.i();
        int iE = lMOtsParametersF.e();
        byte[] bArrK = nVar.k();
        int iA = a(bArrK, iD, lMOtsParametersF);
        bArrK[iD] = (byte) ((iA >>> 8) & 255);
        bArrK[iD + 1] = (byte) iA;
        byte[] bArrC = kVarJ.c();
        int iG = kVarJ.g();
        org.bouncycastle.crypto.s sVarA = b.a(lMOtsParametersF.b());
        a0.b(bArrC, sVarA);
        a0.e(iG, sVarA);
        a0.d(f45802a, sVarA);
        a aVarM = a.i().d(bArrC).m(iG);
        int i11 = iD + 23;
        byte[] bArrB = aVarM.k(0, i11).b();
        int i12 = (1 << i10) - 1;
        byte[] bArrD = lVarB.d();
        org.bouncycastle.crypto.s sVarA2 = b.a(lMOtsParametersF.b());
        for (int i13 = 0; i13 < iE; i13++) {
            org.bouncycastle.util.o.K((short) i13, bArrB, 20);
            System.arraycopy(bArrD, i13 * iD, bArrB, 23, iD);
            for (int iB = b(bArrK, i13, i10); iB < i12; iB++) {
                bArrB[22] = (byte) iB;
                sVarA2.update(bArrB, 0, i11);
                sVarA2.c(bArrB, 23);
            }
            sVarA.update(bArrB, 23, iD);
        }
        byte[] bArr = new byte[iD];
        sVarA.c(bArr, 0);
        return bArr;
    }

    public static k h(j jVar) {
        return new k(jVar.d(), jVar.b(), jVar.e(), i(jVar.d(), jVar.b(), jVar.e(), jVar.c()));
    }

    public static byte[] i(LMOtsParameters lMOtsParameters, byte[] bArr, int i10, byte[] bArr2) {
        org.bouncycastle.crypto.s sVarA = b.a(lMOtsParameters.b());
        byte[] bArrB = a.i().d(bArr).m(i10).l(-32640).k(0, 22).b();
        sVarA.update(bArrB, 0, bArrB.length);
        org.bouncycastle.crypto.s sVarA2 = b.a(lMOtsParameters.b());
        byte[] bArrB2 = a.i().d(bArr).m(i10).k(0, sVarA2.h() + 23).b();
        b0 b0Var = new b0(bArr, bArr2, b.a(lMOtsParameters.b()));
        b0Var.i(i10);
        b0Var.h(0);
        int iE = lMOtsParameters.e();
        int iD = lMOtsParameters.d();
        int i11 = (1 << lMOtsParameters.i()) - 1;
        int i12 = 0;
        while (i12 < iE) {
            b0Var.b(bArrB2, i12 < iE + (-1), 23);
            org.bouncycastle.util.o.K((short) i12, bArrB2, 20);
            for (int i13 = 0; i13 < i11; i13++) {
                bArrB2[22] = (byte) i13;
                sVarA2.update(bArrB2, 0, bArrB2.length);
                sVarA2.c(bArrB2, 23);
            }
            sVarA.update(bArrB2, 23, iD);
            i12++;
        }
        byte[] bArr3 = new byte[sVarA.h()];
        sVarA.c(bArr3, 0);
        return bArr3;
    }
}
