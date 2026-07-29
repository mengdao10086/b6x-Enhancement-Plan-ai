package ye;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f57308a = 33;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f57309b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f57310c = 32;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f57311d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f57312e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] a(af.a aVar, int i10, int i11) {
        int[] iArr = new int[i11];
        int iL = aVar.l() / i10;
        for (int i12 = 0; i12 < iL; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 |= aVar.h((i12 * i10) + i14) ? 1 << ((i10 - i14) - 1) : 0;
            }
            iArr[i12] = i13;
        }
        return iArr;
    }

    public static void b(af.b bVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    bVar.s(i14, i13);
                    bVar.s(i14, i15);
                    bVar.s(i13, i14);
                    bVar.s(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        bVar.s(i16, i16);
        int i17 = i16 + 1;
        bVar.s(i17, i16);
        bVar.s(i16, i17);
        int i18 = i10 + i11;
        bVar.s(i18, i16);
        bVar.s(i18, i17);
        bVar.s(i18, i18 - 1);
    }

    public static void c(af.b bVar, boolean z10, int i10, af.a aVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (aVar.h(i12)) {
                    bVar.s(i13, i11 - 5);
                }
                if (aVar.h(i12 + 7)) {
                    bVar.s(i11 + 5, i13);
                }
                if (aVar.h(20 - i12)) {
                    bVar.s(i13, i11 + 5);
                }
                if (aVar.h(27 - i12)) {
                    bVar.s(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (aVar.h(i12)) {
                bVar.s(i14, i11 - 7);
            }
            if (aVar.h(i12 + 10)) {
                bVar.s(i11 + 7, i14);
            }
            if (aVar.h(29 - i12)) {
                bVar.s(i14, i11 + 7);
            }
            if (aVar.h(39 - i12)) {
                bVar.s(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static a d(String str) {
        return g(str.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static a e(String str, int i10, int i11) {
        return i(str.getBytes(StandardCharsets.ISO_8859_1), i10, i11, null);
    }

    public static a f(String str, int i10, int i11, Charset charset) {
        return i(str.getBytes(charset != null ? charset : StandardCharsets.ISO_8859_1), i10, i11, charset);
    }

    public static a g(byte[] bArr) {
        return i(bArr, 33, 0, null);
    }

    public static a h(byte[] bArr, int i10, int i11) {
        return i(bArr, i10, i11, null);
    }

    public static a i(byte[] bArr, int i10, int i11, Charset charset) {
        af.a aVarM;
        int i12;
        boolean z10;
        int iAbs;
        int iN;
        int i13;
        af.a aVarA = new d(bArr, charset).a();
        int iL = ((aVarA.l() * i10) / 100) + 11;
        int iL2 = aVarA.l() + iL;
        int i14 = 0;
        int i15 = 1;
        if (i11 == 0) {
            af.a aVarM2 = null;
            int i16 = 0;
            int i17 = 0;
            while (i16 <= 32) {
                boolean z11 = i16 <= 3;
                int i18 = z11 ? i16 + 1 : i16;
                int iN2 = n(i18, z11);
                if (iL2 <= iN2) {
                    if (aVarM2 == null || i17 != f57312e[i18]) {
                        int i19 = f57312e[i18];
                        i17 = i19;
                        aVarM2 = m(aVarA, i19);
                    }
                    int i20 = iN2 - (iN2 % i17);
                    if ((!z11 || aVarM2.l() <= i17 * 64) && aVarM2.l() + iL <= i20) {
                        aVarM = aVarM2;
                        i12 = i17;
                        z10 = z11;
                        iAbs = i18;
                        iN = iN2;
                    }
                }
                i16++;
                i14 = 0;
                i15 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z10 = i11 < 0;
        iAbs = Math.abs(i11);
        if (iAbs > (z10 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i11)));
        }
        iN = n(iAbs, z10);
        i12 = f57312e[iAbs];
        int i21 = iN - (iN % i12);
        aVarM = m(aVarA, i12);
        if (aVarM.l() + iL > i21) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z10 && aVarM.l() > i12 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        af.a aVarJ = j(aVarM, iN, i12);
        int iL3 = aVarM.l() / i12;
        af.a aVarK = k(z10, iAbs, iL3);
        int i22 = (z10 ? 11 : 14) + (iAbs * 4);
        int[] iArr = new int[i22];
        int i23 = 2;
        if (z10) {
            for (int i24 = 0; i24 < i22; i24++) {
                iArr[i24] = i24;
            }
            i13 = i22;
        } else {
            int i25 = i22 / 2;
            i13 = i22 + 1 + (((i25 - 1) / 15) * 2);
            int i26 = i13 / 2;
            for (int i27 = 0; i27 < i25; i27++) {
                iArr[(i25 - i27) - 1] = (i26 - r15) - 1;
                iArr[i25 + i27] = (i27 / 15) + i27 + i26 + i15;
            }
        }
        af.b bVar = new af.b(i13);
        int i28 = 0;
        int i29 = 0;
        while (i28 < iAbs) {
            int i30 = ((iAbs - i28) * 4) + (z10 ? 9 : 12);
            int i31 = 0;
            while (i31 < i30) {
                int i32 = i31 * 2;
                while (i14 < i23) {
                    if (aVarJ.h(i29 + i32 + i14)) {
                        int i33 = i28 * 2;
                        bVar.s(iArr[i33 + i14], iArr[i33 + i31]);
                    }
                    if (aVarJ.h((i30 * 2) + i29 + i32 + i14)) {
                        int i34 = i28 * 2;
                        bVar.s(iArr[i34 + i31], iArr[((i22 - 1) - i34) - i14]);
                    }
                    if (aVarJ.h((i30 * 4) + i29 + i32 + i14)) {
                        int i35 = (i22 - 1) - (i28 * 2);
                        bVar.s(iArr[i35 - i14], iArr[i35 - i31]);
                    }
                    if (aVarJ.h((i30 * 6) + i29 + i32 + i14)) {
                        int i36 = i28 * 2;
                        bVar.s(iArr[((i22 - 1) - i36) - i31], iArr[i36 + i14]);
                    }
                    i14++;
                    i23 = 2;
                }
                i31++;
                i14 = 0;
                i23 = 2;
            }
            i29 += i30 * 8;
            i28++;
            i14 = 0;
            i23 = 2;
        }
        c(bVar, z10, i13, aVarK);
        if (z10) {
            b(bVar, i13 / 2, 5);
        } else {
            int i37 = i13 / 2;
            b(bVar, i37, 7);
            int i38 = 0;
            int i39 = 0;
            while (i39 < (i22 / 2) - 1) {
                for (int i40 = i37 & 1; i40 < i13; i40 += 2) {
                    int i41 = i37 - i38;
                    bVar.s(i41, i40);
                    int i42 = i37 + i38;
                    bVar.s(i42, i40);
                    bVar.s(i40, i41);
                    bVar.s(i40, i42);
                }
                i39 += 15;
                i38 += 16;
            }
        }
        a aVar = new a();
        aVar.g(z10);
        aVar.j(i13);
        aVar.h(iAbs);
        aVar.f(iL3);
        aVar.i(bVar);
        return aVar;
    }

    public static af.a j(af.a aVar, int i10, int i11) {
        int iL = aVar.l() / i11;
        cf.d dVar = new cf.d(l(i11));
        int i12 = i10 / i11;
        int[] iArrA = a(aVar, i11, i12);
        dVar.b(iArrA, i12 - iL);
        af.a aVar2 = new af.a();
        aVar2.c(0, i10 % i11);
        for (int i13 : iArrA) {
            aVar2.c(i13, i11);
        }
        return aVar2;
    }

    public static af.a k(boolean z10, int i10, int i11) {
        af.a aVar = new af.a();
        if (z10) {
            aVar.c(i10 - 1, 2);
            aVar.c(i11 - 1, 6);
            return j(aVar, 28, 4);
        }
        aVar.c(i10 - 1, 5);
        aVar.c(i11 - 1, 11);
        return j(aVar, 40, 4);
    }

    public static cf.a l(int i10) {
        if (i10 == 4) {
            return cf.a.f10937k;
        }
        if (i10 == 6) {
            return cf.a.f10936j;
        }
        if (i10 == 8) {
            return cf.a.f10940n;
        }
        if (i10 == 10) {
            return cf.a.f10935i;
        }
        if (i10 == 12) {
            return cf.a.f10934h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i10);
    }

    public static af.a m(af.a aVar, int i10) {
        af.a aVar2 = new af.a();
        int iL = aVar.l();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < iL) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= iL || aVar.h(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                aVar2.c(i16, i10);
            } else if (i16 == 0) {
                aVar2.c(i13 | 1, i10);
            } else {
                aVar2.c(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return aVar2;
    }

    public static int n(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }
}
