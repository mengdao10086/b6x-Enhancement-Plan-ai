package p001if;

import af.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ve.k;
import ve.l;
import ve.m;
import za.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f32359m = {1, 10, 34, 70, 126};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f32360n = {4, 20, 48, 81};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f32361o = {0, 161, 961, 2015, 2715};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f32362p = {0, 336, h1.Y, 1516};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f32363q = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f32364r = {2, 4, 6, 8};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[][] f32365s = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<d> f32366k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<d> f32367l = new ArrayList();

    public static void s(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z10 = false;
        Iterator<d> it2 = collection.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            d next = it2.next();
            if (next.b() == dVar.b()) {
                next.e();
                z10 = true;
                break;
            }
        }
        if (z10) {
            return;
        }
        collection.add(dVar);
    }

    public static boolean u(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    public static k v(d dVar, d dVar2) {
        String strValueOf = String.valueOf((((long) dVar.b()) * 4537077) + ((long) dVar2.b()));
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(strValueOf);
        int i10 = 0;
        for (int i11 = 0; i11 < 13; i11++) {
            int iCharAt = sb2.charAt(i11) - '0';
            if ((i11 & 1) == 0) {
                iCharAt *= 3;
            }
            i10 += iCharAt;
        }
        int i12 = 10 - (i10 % 10);
        if (i12 == 10) {
            i12 = 0;
        }
        sb2.append(i12);
        l[] lVarArrA = dVar.d().a();
        l[] lVarArrA2 = dVar2.d().a();
        k kVar = new k(sb2.toString(), null, new l[]{lVarArrA[0], lVarArrA[1], lVarArrA2[0], lVarArrA2[1]}, BarcodeFormat.RSS_14);
        kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return kVar;
    }

    @Override // com.google.zxing.oned.q
    public k b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        s(this.f32366k, x(aVar, false, i10, map));
        aVar.p();
        s(this.f32367l, x(aVar, true, i10, map));
        aVar.p();
        for (d dVar : this.f32366k) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f32367l) {
                    if (dVar2.c() > 1 && u(dVar, dVar2)) {
                        return v(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.b();
    }

    @Override // com.google.zxing.oned.q, ve.j
    public void reset() {
        this.f32366k.clear();
        this.f32367l.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003f A[PHI: r6 r7
  0x003f: PHI (r6v6 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:26:0x003d, B:13:0x0025] A[DONT_GENERATE, DONT_INLINE]
  0x003f: PHI (r7v4 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:26:0x003d, B:13:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0041 A[PHI: r6 r7
  0x0041: PHI (r6v9 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:26:0x003d, B:13:0x0025] A[DONT_GENERATE, DONT_INLINE]
  0x0041: PHI (r7v9 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:26:0x003d, B:13:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p001if.e.t(boolean, int):void");
    }

    public final b w(a aVar, c cVar, boolean z10) throws NotFoundException {
        int[] iArrJ = j();
        Arrays.fill(iArrJ, 0);
        if (z10) {
            q.g(aVar, cVar.b()[0], iArrJ);
        } else {
            q.f(aVar, cVar.b()[1], iArrJ);
            int i10 = 0;
            for (int length = iArrJ.length - 1; i10 < length; length--) {
                int i11 = iArrJ[i10];
                iArrJ[i10] = iArrJ[length];
                iArrJ[length] = i11;
                i10++;
            }
        }
        int i12 = z10 ? 16 : 15;
        float fD = bf.a.d(iArrJ) / i12;
        int[] iArrN = n();
        int[] iArrL = l();
        float[] fArrO = o();
        float[] fArrM = m();
        for (int i13 = 0; i13 < iArrJ.length; i13++) {
            float f10 = iArrJ[i13] / fD;
            int i14 = (int) (0.5f + f10);
            if (i14 < 1) {
                i14 = 1;
            } else if (i14 > 8) {
                i14 = 8;
            }
            int i15 = i13 / 2;
            if ((i13 & 1) == 0) {
                iArrN[i15] = i14;
                fArrO[i15] = f10 - i14;
            } else {
                iArrL[i15] = i14;
                fArrM[i15] = f10 - i14;
            }
        }
        t(z10, i12);
        int i16 = 0;
        int i17 = 0;
        for (int length2 = iArrN.length - 1; length2 >= 0; length2--) {
            i16 = (i16 * 9) + iArrN[length2];
            i17 += iArrN[length2];
        }
        int i18 = 0;
        int i19 = 0;
        for (int length3 = iArrL.length - 1; length3 >= 0; length3--) {
            i18 = (i18 * 9) + iArrL[length3];
            i19 += iArrL[length3];
        }
        int i20 = i16 + (i18 * 3);
        if (!z10) {
            if ((i19 & 1) != 0 || i19 > 10 || i19 < 4) {
                throw NotFoundException.b();
            }
            int i21 = (10 - i19) / 2;
            int i22 = f32364r[i21];
            return new b((f.b(iArrL, 9 - i22, false) * f32360n[i21]) + f.b(iArrN, i22, true) + f32362p[i21], i20);
        }
        if ((i17 & 1) != 0 || i17 > 12 || i17 < 4) {
            throw NotFoundException.b();
        }
        int i23 = (12 - i17) / 2;
        int i24 = f32363q[i23];
        return new b((f.b(iArrN, i24, false) * f32359m[i23]) + f.b(iArrL, 9 - i24, true) + f32361o[i23], i20);
    }

    public final d x(a aVar, boolean z10, int i10, Map<DecodeHintType, ?> map) {
        try {
            c cVarZ = z(aVar, i10, z10, y(aVar, z10));
            m mVar = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (mVar != null) {
                int[] iArrB = cVarZ.b();
                float fL = ((iArrB[0] + iArrB[1]) - 1) / 2.0f;
                if (z10) {
                    fL = (aVar.l() - 1) - fL;
                }
                mVar.a(new l(fL, i10));
            }
            b bVarW = w(aVar, cVarZ, true);
            b bVarW2 = w(aVar, cVarZ, false);
            return new d((bVarW.b() * 1597) + bVarW2.b(), bVarW.a() + (bVarW2.a() * 4), cVarZ);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] y(a aVar, boolean z10) throws NotFoundException {
        int[] iArrK = k();
        iArrK[0] = 0;
        iArrK[1] = 0;
        iArrK[2] = 0;
        iArrK[3] = 0;
        int iL = aVar.l();
        int i10 = 0;
        boolean z11 = false;
        while (i10 < iL) {
            z11 = !aVar.h(i10);
            if (z10 == z11) {
                break;
            }
            i10++;
        }
        int i11 = i10;
        int i12 = 0;
        while (i10 < iL) {
            if (aVar.h(i10) != z11) {
                iArrK[i12] = iArrK[i12] + 1;
            } else {
                if (i12 != 3) {
                    i12++;
                } else {
                    if (a.q(iArrK)) {
                        return new int[]{i11, i10};
                    }
                    i11 += iArrK[0] + iArrK[1];
                    iArrK[0] = iArrK[2];
                    iArrK[1] = iArrK[3];
                    iArrK[2] = 0;
                    iArrK[3] = 0;
                    i12--;
                }
                iArrK[i12] = 1;
                z11 = !z11;
            }
            i10++;
        }
        throw NotFoundException.b();
    }

    public final c z(a aVar, int i10, boolean z10, int[] iArr) throws NotFoundException {
        int iL;
        int i11;
        boolean zH = aVar.h(iArr[0]);
        int i12 = iArr[0] - 1;
        while (i12 >= 0 && zH != aVar.h(i12)) {
            i12--;
        }
        int i13 = i12 + 1;
        int i14 = iArr[0] - i13;
        int[] iArrK = k();
        System.arraycopy(iArrK, 0, iArrK, 1, iArrK.length - 1);
        iArrK[0] = i14;
        int iR = a.r(iArrK, f32365s);
        int i15 = iArr[1];
        if (z10) {
            int iL2 = (aVar.l() - 1) - i13;
            iL = (aVar.l() - 1) - i15;
            i11 = iL2;
        } else {
            iL = i15;
            i11 = i13;
        }
        return new c(iR, new int[]{i13, iArr[1]}, i11, iL, i10);
    }
}
