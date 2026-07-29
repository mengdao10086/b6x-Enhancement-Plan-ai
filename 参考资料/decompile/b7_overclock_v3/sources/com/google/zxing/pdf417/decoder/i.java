package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21588a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21589b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21590c = 512;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final lf.a f21591d = new lf.a();

    public static c a(g gVar) throws NotFoundException {
        int[] iArrJ;
        if (gVar == null || (iArrJ = gVar.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : iArrJ) {
            i11 += iP - i12;
            if (i12 > 0) {
                break;
            }
        }
        d[] dVarArrD = gVar.d();
        for (int i13 = 0; i11 > 0 && dVarArrD[i13] == null; i13++) {
            i11--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            i10 += iP - iArrJ[length];
            if (iArrJ[length] > 0) {
                break;
            }
        }
        for (int length2 = dVarArrD.length - 1; i10 > 0 && dVarArrD[length2] == null; length2--) {
            i10--;
        }
        return gVar.a().a(i11, i10, gVar.k());
    }

    public static void b(e eVar, b[][] bVarArr) throws NotFoundException {
        b bVar = bVarArr[0][1];
        int[] iArrB = bVar.b();
        int iJ = (eVar.j() * eVar.l()) - r(eVar.k());
        if (iArrB.length == 0) {
            if (iJ < 1 || iJ > 928) {
                throw NotFoundException.b();
            }
            bVar.c(iJ);
            return;
        }
        if (iArrB[0] == iJ || iJ < 1 || iJ > 928) {
            return;
        }
        bVar.c(iJ);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(af.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.f(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.c(af.b, int, int, boolean, int, int):int");
    }

    public static boolean d(int i10, int i11, int i12) {
        return i11 + (-2) <= i10 && i10 <= i12 + 2;
    }

    public static int e(int[] iArr, int[] iArr2, int i10) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return f21591d.a(iArr, i10, iArr2);
        }
        throw ChecksumException.b();
    }

    public static b[][] f(e eVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, eVar.l(), eVar.j() + 2);
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            for (int i11 = 0; i11 < bVarArr[i10].length; i11++) {
                bVarArr[i10][i11] = new b();
            }
        }
        int i12 = 0;
        for (f fVar : eVar.o()) {
            if (fVar != null) {
                for (d dVar : fVar.d()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i12].c(dVar.e());
                    }
                }
            }
            i12++;
        }
        return bVarArr;
    }

    public static af.d g(e eVar) throws NotFoundException, ChecksumException, FormatException {
        b[][] bVarArrF = f(eVar);
        b(eVar, bVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.l() * eVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < eVar.l(); i10++) {
            int i11 = 0;
            while (i11 < eVar.j()) {
                int i12 = i11 + 1;
                int[] iArrB = bVarArrF[i10][i12].b();
                int iJ = (eVar.j() * i10) + i11;
                if (iArrB.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrB.length == 1) {
                    iArr[iJ] = iArrB[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrB);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return h(eVar.k(), iArr, kf.a.c(arrayList), kf.a.c(arrayList3), iArr2);
    }

    public static af.d h(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException, FormatException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i11 = 100;
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                throw ChecksumException.b();
            }
            for (int i13 = 0; i13 < length; i13++) {
                iArr[iArr3[i13]] = iArr4[i13][iArr5[i13]];
            }
            try {
                return j(iArr, i10, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.b();
                }
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    if (iArr5[i14] < iArr4[i14].length - 1) {
                        iArr5[i14] = iArr5[i14] + 1;
                        break;
                    }
                    iArr5[i14] = 0;
                    if (i14 == length - 1) {
                        throw ChecksumException.b();
                    }
                    i14++;
                }
                i11 = i12;
            }
        }
    }

    public static af.d i(af.b bVar, l lVar, l lVar2, l lVar3, l lVar4, int i10, int i11) throws NotFoundException, ChecksumException, FormatException {
        e eVarV;
        int i12;
        int i13;
        int i14;
        g gVarS = null;
        g gVarS2 = null;
        c cVar = new c(bVar, lVar, lVar2, lVar3, lVar4);
        boolean z10 = true;
        while (true) {
            if (lVar != null) {
                gVarS = s(bVar, cVar, lVar, true, i10, i11);
            }
            if (lVar3 != null) {
                gVarS2 = s(bVar, cVar, lVar3, false, i10, i11);
            }
            eVarV = v(gVarS, gVarS2);
            if (eVarV == null) {
                throw NotFoundException.b();
            }
            c cVarM = eVarV.m();
            if (!z10 || cVarM == null || (cVarM.g() >= cVar.g() && cVarM.e() <= cVar.e())) {
                break;
            }
            cVar = cVarM;
            z10 = false;
        }
        eVarV.p(cVar);
        int iJ = eVarV.j() + 1;
        eVarV.q(0, gVarS);
        eVarV.q(iJ, gVarS2);
        boolean z11 = gVarS != null;
        int iMin = i10;
        int iMax = i11;
        for (int i15 = 1; i15 <= iJ; i15++) {
            int i16 = z11 ? i15 : iJ - i15;
            if (eVarV.n(i16) == null) {
                f gVar = (i16 == 0 || i16 == iJ) ? new g(cVar, i16 == 0) : new f(cVar);
                eVarV.q(i16, gVar);
                int i17 = -1;
                int iG = cVar.g();
                int i18 = -1;
                while (iG <= cVar.e()) {
                    int iT = t(eVarV, i16, iG, z11);
                    if (iT >= 0 && iT <= cVar.d()) {
                        i12 = iT;
                    } else if (i18 == i17) {
                        i13 = i18;
                        i14 = iG;
                        i18 = i13;
                        iG = i14 + 1;
                        i17 = -1;
                    } else {
                        i12 = i18;
                    }
                    i13 = i18;
                    int i19 = iG;
                    d dVarK = k(bVar, cVar.f(), cVar.d(), z11, i12, i19, iMin, iMax);
                    i14 = i19;
                    if (dVarK != null) {
                        gVar.f(i14, dVarK);
                        iMin = Math.min(iMin, dVarK.f());
                        iMax = Math.max(iMax, dVarK.f());
                        i18 = i12;
                    } else {
                        i18 = i13;
                    }
                    iG = i14 + 1;
                    i17 = -1;
                }
            }
        }
        return g(eVarV);
    }

    public static af.d j(int[] iArr, int i10, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.b();
        }
        int i11 = 1 << (i10 + 1);
        int iE = e(iArr, iArr2, i11);
        x(iArr, i11);
        af.d dVarB = DecodedBitStreamParser.b(iArr, String.valueOf(i10));
        dVarB.n(Integer.valueOf(iE));
        dVarB.m(Integer.valueOf(iArr2.length));
        return dVarB;
    }

    public static d k(af.b bVar, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int iD;
        int iB;
        int iC = c(bVar, i10, i11, z10, i12, i13);
        int[] iArrQ = q(bVar, i10, i11, z10, iC, i13);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = bf.a.d(iArrQ);
        if (z10) {
            i16 = iC + iD2;
        } else {
            for (int i17 = 0; i17 < iArrQ.length / 2; i17++) {
                int i18 = iArrQ[i17];
                iArrQ[i17] = iArrQ[(iArrQ.length - 1) - i17];
                iArrQ[(iArrQ.length - 1) - i17] = i18;
            }
            iC -= iD2;
            i16 = iC;
        }
        if (d(iD2, i14, i15) && (iB = kf.a.b((iD = h.d(iArrQ)))) != -1) {
            return new d(iC, i16, n(iD), iB);
        }
        return null;
    }

    public static a l(g gVar, g gVar2) {
        a aVarI;
        a aVarI2;
        if (gVar == null || (aVarI = gVar.i()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.i();
        }
        if (gVar2 == null || (aVarI2 = gVar2.i()) == null || aVarI.a() == aVarI2.a() || aVarI.b() == aVarI2.b() || aVarI.c() == aVarI2.c()) {
            return aVarI;
        }
        return null;
    }

    public static int[] m(int i10) {
        int[] iArr = new int[8];
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i10 & 1;
            if (i13 != i11) {
                i12--;
                if (i12 < 0) {
                    return iArr;
                }
                i11 = i13;
            }
            iArr[i12] = iArr[i12] + 1;
            i10 >>= 1;
        }
    }

    public static int n(int i10) {
        return o(m(i10));
    }

    public static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int p(int[] iArr) {
        int iMax = -1;
        for (int i10 : iArr) {
            iMax = Math.max(iMax, i10);
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] q(af.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.f(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.q(af.b, int, int, boolean, int, int):int[]");
    }

    public static int r(int i10) {
        return 2 << i10;
    }

    public static g s(af.b bVar, c cVar, l lVar, boolean z10, int i10, int i11) {
        g gVar = new g(cVar, z10);
        int i12 = 0;
        while (i12 < 2) {
            int i13 = i12 == 0 ? 1 : -1;
            int iC = (int) lVar.c();
            for (int iD = (int) lVar.d(); iD <= cVar.e() && iD >= cVar.g(); iD += i13) {
                d dVarK = k(bVar, 0, bVar.m(), z10, iC, iD, i10, i11);
                if (dVarK != null) {
                    gVar.f(iD, dVarK);
                    iC = z10 ? dVarK.d() : dVarK.b();
                }
            }
            i12++;
        }
        return gVar;
    }

    public static int t(e eVar, int i10, int i11, boolean z10) {
        int i12 = z10 ? 1 : -1;
        int i13 = i10 - i12;
        d dVarB = u(eVar, i13) ? eVar.n(i13).b(i11) : null;
        if (dVarB != null) {
            return z10 ? dVarB.b() : dVarB.d();
        }
        d dVarC = eVar.n(i10).c(i11);
        if (dVarC != null) {
            return z10 ? dVarC.d() : dVarC.b();
        }
        if (u(eVar, i13)) {
            dVarC = eVar.n(i13).c(i11);
        }
        if (dVarC != null) {
            return z10 ? dVarC.b() : dVarC.d();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (!u(eVar, i10)) {
                c cVarM = eVar.m();
                return z10 ? cVarM.f() : cVarM.d();
            }
            for (d dVar : eVar.n(i10).d()) {
                if (dVar != null) {
                    return (z10 ? dVar.b() : dVar.d()) + (i12 * i14 * (dVar.b() - dVar.d()));
                }
            }
            i14++;
        }
    }

    public static boolean u(e eVar, int i10) {
        return i10 >= 0 && i10 <= eVar.j() + 1;
    }

    public static e v(g gVar, g gVar2) throws NotFoundException {
        a aVarL;
        if ((gVar == null && gVar2 == null) || (aVarL = l(gVar, gVar2)) == null) {
            return null;
        }
        return new e(aVarL, c.j(a(gVar), a(gVar2)));
    }

    public static String w(b[][] bVarArr) {
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            try {
                formatter.format("Row %2d: ", Integer.valueOf(i10));
                for (int i11 = 0; i11 < bVarArr[i10].length; i11++) {
                    b bVar = bVarArr[i10][i11];
                    if (bVar.b().length == 0) {
                        formatter.format("        ", null);
                    } else {
                        formatter.format("%4d(%2d)", Integer.valueOf(bVar.b()[0]), bVar.a(bVar.b()[0]));
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        formatter.close();
                    } catch (Throwable th4) {
                        th2.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    public static void x(int[] iArr, int i10) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.b();
        }
        int i11 = iArr[0];
        if (i11 > iArr.length) {
            throw FormatException.b();
        }
        if (i11 == 0) {
            if (i10 >= iArr.length) {
                throw FormatException.b();
            }
            iArr[0] = iArr.length - i10;
        }
    }
}
