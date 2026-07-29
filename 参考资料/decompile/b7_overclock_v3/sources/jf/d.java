package jf;

import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.listener.ISchedulers;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.q;
import com.google.zxing.oned.rss.expanded.decoders.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mb.e;
import ob.h;
import p001if.f;
import rb.a0;
import rb.h0;
import v7.a;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends p001if.a {
    public static final int A = 11;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f36374t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f36375u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f36376v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f36377w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f36378x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f36379y = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f36381k = new ArrayList(11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<c> f36382l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int[] f36383m = new int[2];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f36369o = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f36370p = {4, 20, 52, 104, a.c.f52774j};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f36371q = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[][] f36372r = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[][] f36373s = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{a0.f47918w, 145, 13, 39, 117, 140, 209, 205}, new int[]{s0.c.f49294u, 157, 49, uf.c.Ya, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, h.H, 85, 44, 132}, new int[]{NormalCmdFactory.TASK_CANCEL_ALL, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, a.c.f52773i, e.f41031i2, 139, a.c.f52775k, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, ISchedulers.SUB_CANCEL}, new int[]{70, ISchedulers.IS_M3U8_PEER, 208, a.c.f52772h, 184, 130, 179, 115}, new int[]{134, 191, rc.c.f48463k0, 31, 93, 68, a.c.f52774j, 190}, new int[]{com.google.zxing.oned.d.f21430g, 22, 66, 198, h0.K, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, WaspWingInfo.COLD_LEVEL_STANDARD_B7, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, a.c.f52776l, 199, HideBottomViewOnScrollBehavior.f19616g}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, DoubleMath.MAX_FACTORIAL, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, e.f41073w1, 100, 89}};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[][] f36380z = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    public static int A(af.a aVar, int i10) {
        return aVar.h(i10) ? aVar.j(aVar.k(i10)) : aVar.k(aVar.j(i10));
    }

    public static boolean C(p001if.c cVar, boolean z10, boolean z11) {
        return (cVar.c() == 0 && z10 && z11) ? false : true;
    }

    public static boolean D(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z10;
        boolean z11;
        Iterator<c> it2 = iterable2.iterator();
        do {
            z10 = false;
            if (!it2.hasNext()) {
                return false;
            }
            c next = it2.next();
            Iterator<b> it3 = iterable.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z10 = true;
                    break;
                }
                b next2 = it3.next();
                Iterator<b> it4 = next.a().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z11 = false;
                        break;
                    }
                    if (next2.equals(it4.next())) {
                        z11 = true;
                        break;
                    }
                }
                if (!z11) {
                    break;
                }
            }
        } while (!z10);
        return true;
    }

    public static boolean E(List<b> list) {
        boolean z10;
        for (int[] iArr : f36380z) {
            if (list.size() <= iArr.length) {
                int i10 = 0;
                while (true) {
                    if (i10 >= list.size()) {
                        z10 = true;
                        break;
                    }
                    if (list.get(i10).a().c() != iArr[i10]) {
                        z10 = false;
                        break;
                    }
                    i10++;
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void G(Collection<b> collection, Collection<c> collection2) {
        Iterator<c> it2 = collection2.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            if (next.a().size() != collection.size()) {
                boolean z10 = true;
                Iterator<b> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    } else if (!collection.contains(it3.next())) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    it2.remove();
                }
            }
        }
    }

    public static void I(int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length / 2; i10++) {
            int i11 = iArr[i10];
            int i12 = (length - i10) - 1;
            iArr[i10] = iArr[i12];
            iArr[i12] = i11;
        }
    }

    public static k w(List<b> list) throws NotFoundException, FormatException {
        String strD = j.a(a.a(list)).d();
        l[] lVarArrA = list.get(0).a().a();
        l[] lVarArrA2 = list.get(list.size() - 1).a().a();
        k kVar = new k(strD, null, new l[]{lVarArrA[0], lVarArrA[1], lVarArrA2[0], lVarArrA2[1]}, BarcodeFormat.RSS_EXPANDED);
        kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return kVar;
    }

    public List<c> B() {
        return this.f36382l;
    }

    public final p001if.c F(af.a aVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        if (z10) {
            int i14 = this.f36383m[0] - 1;
            while (i14 >= 0 && !aVar.h(i14)) {
                i14--;
            }
            int i15 = i14 + 1;
            int[] iArr = this.f36383m;
            i13 = iArr[0] - i15;
            i11 = iArr[1];
            i12 = i15;
        } else {
            int[] iArr2 = this.f36383m;
            int i16 = iArr2[0];
            int iK = aVar.k(iArr2[1] + 1);
            i11 = iK;
            i12 = i16;
            i13 = iK - this.f36383m[1];
        }
        int[] iArrK = k();
        System.arraycopy(iArrK, 0, iArrK, 1, iArrK.length - 1);
        iArrK[0] = i13;
        try {
            return new p001if.c(p001if.a.r(iArrK, f36372r), new int[]{i12, i11}, i12, i11, i10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public b H(af.a aVar, List<b> list, int i10) throws NotFoundException {
        p001if.c cVarF;
        p001if.b bVarX;
        boolean z10 = list.size() % 2 == 0;
        if (this.f36384n) {
            z10 = !z10;
        }
        int iA = -1;
        boolean z11 = true;
        do {
            z(aVar, list, iA);
            cVarF = F(aVar, i10, z10);
            if (cVarF == null) {
                iA = A(aVar, this.f36383m[0]);
            } else {
                z11 = false;
            }
        } while (z11);
        p001if.b bVarX2 = x(aVar, cVarF, z10, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw NotFoundException.b();
        }
        try {
            bVarX = x(aVar, cVarF, z10, false);
        } catch (NotFoundException unused) {
            bVarX = null;
        }
        return new b(bVarX2, bVarX, cVarF);
    }

    public final void J(int i10) {
        boolean zC = false;
        int i11 = 0;
        boolean zC2 = false;
        while (true) {
            if (i11 >= this.f36382l.size()) {
                break;
            }
            c cVar = this.f36382l.get(i11);
            if (cVar.b() > i10) {
                zC = cVar.c(this.f36381k);
                break;
            } else {
                zC2 = cVar.c(this.f36381k);
                i11++;
            }
        }
        if (zC || zC2 || D(this.f36381k, this.f36382l)) {
            return;
        }
        this.f36382l.add(i11, new c(this.f36381k, i10));
        G(this.f36381k, this.f36382l);
    }

    @Override // com.google.zxing.oned.q
    public k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f36381k.clear();
        this.f36384n = false;
        try {
            return w(y(i10, aVar));
        } catch (NotFoundException unused) {
            this.f36381k.clear();
            this.f36384n = true;
            return w(y(i10, aVar));
        }
    }

    @Override // com.google.zxing.oned.q, ve.j
    public void reset() {
        this.f36381k.clear();
        this.f36382l.clear();
    }

    public final void s(int i10) throws NotFoundException {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int iD = bf.a.d(n());
        int iD2 = bf.a.d(l());
        boolean z14 = true;
        if (iD > 13) {
            z10 = false;
            z11 = true;
        } else {
            z10 = iD < 4;
            z11 = false;
        }
        if (iD2 > 13) {
            z12 = false;
            z13 = true;
        } else {
            z12 = iD2 < 4;
            z13 = false;
        }
        int i11 = (iD + iD2) - i10;
        boolean z15 = (iD & 1) == 1;
        boolean z16 = (iD2 & 1) == 0;
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 != 1) {
                    throw NotFoundException.b();
                }
                if (z15) {
                    if (z16) {
                        throw NotFoundException.b();
                    }
                    z14 = z10;
                    z11 = true;
                } else {
                    if (!z16) {
                        throw NotFoundException.b();
                    }
                    z14 = z10;
                    z13 = true;
                }
            } else if (z15) {
                if (!z16) {
                    throw NotFoundException.b();
                }
                if (iD >= iD2) {
                    z14 = z10;
                    z12 = true;
                    z11 = true;
                }
                z13 = true;
            } else {
                if (z16) {
                    throw NotFoundException.b();
                }
                z14 = z10;
            }
        } else if (z15) {
            if (z16) {
                throw NotFoundException.b();
            }
        } else {
            if (!z16) {
                throw NotFoundException.b();
            }
            z14 = z10;
            z12 = true;
        }
        if (z14) {
            if (z11) {
                throw NotFoundException.b();
            }
            p001if.a.p(n(), o());
        }
        if (z11) {
            p001if.a.i(n(), o());
        }
        if (z12) {
            if (z13) {
                throw NotFoundException.b();
            }
            p001if.a.p(l(), o());
        }
        if (z13) {
            p001if.a.i(l(), m());
        }
    }

    public final boolean t() {
        b bVar = this.f36381k.get(0);
        p001if.b bVarB = bVar.b();
        p001if.b bVarC = bVar.c();
        if (bVarC == null) {
            return false;
        }
        int iA = bVarC.a();
        int i10 = 2;
        for (int i11 = 1; i11 < this.f36381k.size(); i11++) {
            b bVar2 = this.f36381k.get(i11);
            iA += bVar2.b().a();
            i10++;
            p001if.b bVarC2 = bVar2.c();
            if (bVarC2 != null) {
                iA += bVarC2.a();
                i10++;
            }
        }
        return ((i10 + (-4)) * hr.a.f31427a) + (iA % hr.a.f31427a) == bVarB.b();
    }

    public final List<b> u(List<c> list, int i10) throws NotFoundException {
        while (i10 < this.f36382l.size()) {
            c cVar = this.f36382l.get(i10);
            this.f36381k.clear();
            Iterator<c> it2 = list.iterator();
            while (it2.hasNext()) {
                this.f36381k.addAll(it2.next().a());
            }
            this.f36381k.addAll(cVar.a());
            if (E(this.f36381k)) {
                if (t()) {
                    return this.f36381k;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return u(arrayList, i10 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i10++;
        }
        throw NotFoundException.b();
    }

    public final List<b> v(boolean z10) {
        List<b> listU = null;
        if (this.f36382l.size() > 25) {
            this.f36382l.clear();
            return null;
        }
        this.f36381k.clear();
        if (z10) {
            Collections.reverse(this.f36382l);
        }
        try {
            listU = u(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z10) {
            Collections.reverse(this.f36382l);
        }
        return listU;
    }

    public p001if.b x(af.a aVar, p001if.c cVar, boolean z10, boolean z11) throws NotFoundException {
        int[] iArrJ = j();
        Arrays.fill(iArrJ, 0);
        if (z11) {
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
        float fD = bf.a.d(iArrJ) / 17;
        float f10 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fD - f10) / f10 > 0.3f) {
            throw NotFoundException.b();
        }
        int[] iArrN = n();
        int[] iArrL = l();
        float[] fArrO = o();
        float[] fArrM = m();
        for (int i12 = 0; i12 < iArrJ.length; i12++) {
            float f11 = (iArrJ[i12] * 1.0f) / fD;
            int i13 = (int) (0.5f + f11);
            if (i13 < 1) {
                if (f11 < 0.3f) {
                    throw NotFoundException.b();
                }
                i13 = 1;
            } else if (i13 > 8) {
                if (f11 > 8.7f) {
                    throw NotFoundException.b();
                }
                i13 = 8;
            }
            int i14 = i12 / 2;
            if ((i12 & 1) == 0) {
                iArrN[i14] = i13;
                fArrO[i14] = f11 - i13;
            } else {
                iArrL[i14] = i13;
                fArrM[i14] = f11 - i13;
            }
        }
        s(17);
        int iC = (((cVar.c() * 4) + (z10 ? 0 : 2)) + (!z11 ? 1 : 0)) - 1;
        int i15 = 0;
        int i16 = 0;
        for (int length2 = iArrN.length - 1; length2 >= 0; length2--) {
            if (C(cVar, z10, z11)) {
                i15 += iArrN[length2] * f36373s[iC][length2 * 2];
            }
            i16 += iArrN[length2];
        }
        int i17 = 0;
        for (int length3 = iArrL.length - 1; length3 >= 0; length3--) {
            if (C(cVar, z10, z11)) {
                i17 += iArrL[length3] * f36373s[iC][(length3 * 2) + 1];
            }
        }
        int i18 = i15 + i17;
        if ((i16 & 1) != 0 || i16 > 13 || i16 < 4) {
            throw NotFoundException.b();
        }
        int i19 = (13 - i16) / 2;
        int i20 = f36369o[i19];
        return new p001if.b((f.b(iArrN, i20, true) * f36370p[i19]) + f.b(iArrL, 9 - i20, false) + f36371q[i19], i18);
    }

    public List<b> y(int i10, af.a aVar) throws NotFoundException {
        boolean z10 = false;
        while (!z10) {
            try {
                List<b> list = this.f36381k;
                list.add(H(aVar, list, i10));
            } catch (NotFoundException e10) {
                if (this.f36381k.isEmpty()) {
                    throw e10;
                }
                z10 = true;
            }
        }
        if (t()) {
            return this.f36381k;
        }
        boolean z11 = !this.f36382l.isEmpty();
        J(i10);
        if (z11) {
            List<b> listV = v(false);
            if (listV != null) {
                return listV;
            }
            List<b> listV2 = v(true);
            if (listV2 != null) {
                return listV2;
            }
        }
        throw NotFoundException.b();
    }

    public final void z(af.a aVar, List<b> list, int i10) throws NotFoundException {
        int[] iArrK = k();
        iArrK[0] = 0;
        iArrK[1] = 0;
        iArrK[2] = 0;
        iArrK[3] = 0;
        int iL = aVar.l();
        if (i10 < 0) {
            i10 = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z10 = list.size() % 2 != 0;
        if (this.f36384n) {
            z10 = !z10;
        }
        boolean z11 = false;
        while (i10 < iL) {
            z11 = !aVar.h(i10);
            if (!z11) {
                break;
            } else {
                i10++;
            }
        }
        boolean z12 = z11;
        int i11 = 0;
        int i12 = i10;
        while (i10 < iL) {
            if (aVar.h(i10) != z12) {
                iArrK[i11] = iArrK[i11] + 1;
            } else {
                if (i11 == 3) {
                    if (z10) {
                        I(iArrK);
                    }
                    if (p001if.a.q(iArrK)) {
                        int[] iArr = this.f36383m;
                        iArr[0] = i12;
                        iArr[1] = i10;
                        return;
                    }
                    if (z10) {
                        I(iArrK);
                    }
                    i12 += iArrK[0] + iArrK[1];
                    iArrK[0] = iArrK[2];
                    iArrK[1] = iArrK[3];
                    iArrK[2] = 0;
                    iArrK[3] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArrK[i11] = 1;
                z12 = !z12;
            }
            i10++;
        }
        throw NotFoundException.b();
    }
}
