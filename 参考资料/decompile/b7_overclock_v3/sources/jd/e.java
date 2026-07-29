package jd;

import g.p0;
import hd.b0;
import hd.c0;
import hd.u0;
import java.util.ArrayList;
import java.util.zip.Inflater;
import jd.d;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f36339a = 2037673328;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f36340b = 1836279920;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f36341c = 1918990112;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f36342d = 1684433976;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f36343e = 1835365224;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f36344f = 1886547818;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f36345g = 10000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f36346h = 32000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f36347i = 128000;

    @p0
    public static d a(byte[] bArr, int i10) {
        ArrayList<d.b> arrayListF;
        c0 c0Var = new c0(bArr);
        try {
            arrayListF = c(c0Var) ? f(c0Var) : e(c0Var);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListF = null;
        }
        if (arrayListF == null) {
            return null;
        }
        int size = arrayListF.size();
        if (size == 1) {
            return new d(arrayListF.get(0), i10);
        }
        if (size != 2) {
            return null;
        }
        return new d(arrayListF.get(0), arrayListF.get(1), i10);
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >> 1);
    }

    public static boolean c(c0 c0Var) {
        c0Var.T(4);
        int iO = c0Var.o();
        c0Var.S(0);
        return iO == 1886547818;
    }

    @p0
    public static d.b d(c0 c0Var) {
        int iO = c0Var.o();
        if (iO > 10000) {
            return null;
        }
        float[] fArr = new float[iO];
        for (int i10 = 0; i10 < iO; i10++) {
            fArr[i10] = c0Var.n();
        }
        int iO2 = c0Var.o();
        if (iO2 > 32000) {
            return null;
        }
        double d10 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iO) * 2.0d) / dLog);
        b0 b0Var = new b0(c0Var.d());
        int i11 = 8;
        b0Var.q(c0Var.e() * 8);
        float[] fArr2 = new float[iO2 * 5];
        int i12 = 5;
        int[] iArr = new int[5];
        int i13 = 0;
        int i14 = 0;
        while (i13 < iO2) {
            int i15 = 0;
            while (i15 < i12) {
                int iB = iArr[i15] + b(b0Var.h(iCeil));
                if (iB >= iO || iB < 0) {
                    return null;
                }
                fArr2[i14] = fArr[iB];
                iArr[i15] = iB;
                i15++;
                i14++;
                i12 = 5;
            }
            i13++;
            i12 = 5;
        }
        b0Var.q((b0Var.e() + 7) & (-8));
        int i16 = 32;
        int iH = b0Var.h(32);
        d.c[] cVarArr = new d.c[iH];
        int i17 = 0;
        while (i17 < iH) {
            int iH2 = b0Var.h(i11);
            int iH3 = b0Var.h(i11);
            int iH4 = b0Var.h(i16);
            if (iH4 > 128000) {
                return null;
            }
            int iCeil2 = (int) Math.ceil(Math.log(((double) iO2) * d10) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int iB2 = 0;
            for (int i18 = 0; i18 < iH4; i18++) {
                iB2 += b(b0Var.h(iCeil2));
                if (iB2 < 0 || iB2 >= iO2) {
                    return null;
                }
                int i19 = i18 * 3;
                int i20 = iB2 * 5;
                fArr3[i19] = fArr2[i20];
                fArr3[i19 + 1] = fArr2[i20 + 1];
                fArr3[i19 + 2] = fArr2[i20 + 2];
                int i21 = i18 * 2;
                fArr4[i21] = fArr2[i20 + 3];
                fArr4[i21 + 1] = fArr2[i20 + 4];
            }
            cVarArr[i17] = new d.c(iH2, fArr3, fArr4, iH3);
            i17++;
            i16 = 32;
            d10 = 2.0d;
            i11 = 8;
        }
        return new d.b(cVarArr);
    }

    @p0
    public static ArrayList<d.b> e(c0 c0Var) {
        if (c0Var.G() != 0) {
            return null;
        }
        c0Var.T(7);
        int iO = c0Var.o();
        if (iO == 1684433976) {
            c0 c0Var2 = new c0();
            Inflater inflater = new Inflater(true);
            try {
                if (!u0.C0(c0Var, c0Var2, inflater)) {
                    return null;
                }
                inflater.end();
                c0Var = c0Var2;
            } finally {
                inflater.end();
            }
        } else if (iO != 1918990112) {
            return null;
        }
        return g(c0Var);
    }

    @p0
    public static ArrayList<d.b> f(c0 c0Var) {
        int iO;
        c0Var.T(8);
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF && (iO = c0Var.o() + iE) > iE && iO <= iF) {
            int iO2 = c0Var.o();
            if (iO2 == 2037673328 || iO2 == 1836279920) {
                c0Var.R(iO);
                return e(c0Var);
            }
            c0Var.S(iO);
            iE = iO;
        }
        return null;
    }

    @p0
    public static ArrayList<d.b> g(c0 c0Var) {
        ArrayList<d.b> arrayList = new ArrayList<>();
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF) {
            int iO = c0Var.o() + iE;
            if (iO <= iE || iO > iF) {
                return null;
            }
            if (c0Var.o() == 1835365224) {
                d.b bVarD = d(c0Var);
                if (bVarD == null) {
                    return null;
                }
                arrayList.add(bVarD);
            }
            c0Var.S(iO);
            iE = iO;
        }
        return arrayList;
    }
}
