package mf;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f41202c = 0.42f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f41203d = 0.8f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f41206g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f41207h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f41208i = 25;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f41209j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f41210k = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f41200a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f41201b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f41204e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f41205f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f41211l = {0, 180, 270, 90};

    public static af.b a(af.b bVar, int i10) {
        if (i10 % 360 == 0) {
            return bVar;
        }
        af.b bVarClone = bVar.clone();
        bVarClone.p(i10);
        return bVarClone;
    }

    public static void b(l[] lVarArr, l[] lVarArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            lVarArr[iArr[i10]] = lVarArr2[i10];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        r5 = (ve.l[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r5[1] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r5[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<ve.l[]> c(boolean r8, af.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.i()
            if (r3 >= r6) goto L7e
            ve.l[] r4 = g(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 != 0) goto L20
            goto L7e
        L20:
            java.util.Iterator r4 = r0.iterator()
        L24:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L50
            java.lang.Object r5 = r4.next()
            ve.l[] r5 = (ve.l[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L40
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.d()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L40:
            r7 = r5[r6]
            if (r7 == 0) goto L24
            r5 = r5[r6]
            float r5 = r5.d()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L24
        L50:
            int r3 = r3 + 5
            goto L8
        L53:
            r0.add(r4)
            if (r8 != 0) goto L59
            goto L7e
        L59:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6c
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.d()
            goto L7a
        L6c:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.c()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.d()
        L7a:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mf.a.c(boolean, af.b):java.util.List");
    }

    public static b d(ve.b bVar, Map<DecodeHintType, ?> map, boolean z10) throws NotFoundException {
        af.b bVarB = bVar.b();
        for (int i10 : f41211l) {
            af.b bVarA = a(bVarB, i10);
            List<l[]> listC = c(z10, bVarA);
            if (!listC.isEmpty()) {
                return new b(bVarA, listC, i10);
            }
        }
        return new b(bVarB, new ArrayList(), 0);
    }

    public static int[] e(af.b bVar, int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (bVar.f(i10, i11) && i10 > 0) {
            int i14 = i13 + 1;
            if (i13 >= 3) {
                break;
            }
            i10--;
            i13 = i14;
        }
        int length = iArr.length;
        int i15 = i10;
        int i16 = 0;
        boolean z10 = false;
        while (i10 < i12) {
            if (bVar.f(i10, i11) != z10) {
                iArr2[i16] = iArr2[i16] + 1;
            } else {
                if (i16 != length - 1) {
                    i16++;
                } else {
                    if (h(iArr2, iArr) < 0.42f) {
                        return new int[]{i15, i10};
                    }
                    i15 += iArr2[0] + iArr2[1];
                    int i17 = i16 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i17);
                    iArr2[i17] = 0;
                    iArr2[i16] = 0;
                    i16--;
                }
                iArr2[i16] = 1;
                z10 = !z10;
            }
            i10++;
        }
        if (i16 != length - 1 || h(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i15, i10 - 1};
    }

    public static l[] f(af.b bVar, int i10, int i11, int i12, int i13, int[] iArr) {
        boolean z10;
        int i14;
        int i15;
        l[] lVarArr = new l[4];
        int[] iArr2 = new int[iArr.length];
        int i16 = i12;
        while (true) {
            if (i16 >= i10) {
                z10 = false;
                break;
            }
            int[] iArrE = e(bVar, i13, i16, i11, iArr, iArr2);
            if (iArrE != null) {
                int i17 = i16;
                int[] iArr3 = iArrE;
                int i18 = i17;
                while (true) {
                    if (i18 <= 0) {
                        i15 = i18;
                        break;
                    }
                    int i19 = i18 - 1;
                    int[] iArrE2 = e(bVar, i13, i19, i11, iArr, iArr2);
                    if (iArrE2 == null) {
                        i15 = i19 + 1;
                        break;
                    }
                    iArr3 = iArrE2;
                    i18 = i19;
                }
                float f10 = i15;
                lVarArr[0] = new l(iArr3[0], f10);
                lVarArr[1] = new l(iArr3[1], f10);
                i16 = i15;
                z10 = true;
            } else {
                i16 += 5;
            }
        }
        int i20 = i16 + 1;
        if (z10) {
            int[] iArr4 = {(int) lVarArr[0].c(), (int) lVarArr[1].c()};
            int i21 = i20;
            int i22 = 0;
            while (true) {
                if (i21 >= i10) {
                    i14 = i22;
                    break;
                }
                i14 = i22;
                int[] iArrE3 = e(bVar, iArr4[0], i21, i11, iArr, iArr2);
                if (iArrE3 != null && Math.abs(iArr4[0] - iArrE3[0]) < 5 && Math.abs(iArr4[1] - iArrE3[1]) < 5) {
                    iArr4 = iArrE3;
                    i22 = 0;
                } else {
                    if (i14 > 25) {
                        break;
                    }
                    i22 = i14 + 1;
                }
                i21++;
            }
            i20 = i21 - (i14 + 1);
            float f11 = i20;
            lVarArr[2] = new l(iArr4[0], f11);
            lVarArr[3] = new l(iArr4[1], f11);
        }
        if (i20 - i16 < 10) {
            Arrays.fill(lVarArr, (Object) null);
        }
        return lVarArr;
    }

    public static l[] g(af.b bVar, int i10, int i11) {
        int i12 = bVar.i();
        int iM = bVar.m();
        l[] lVarArr = new l[8];
        b(lVarArr, f(bVar, i12, iM, i10, i11, f41204e), f41200a);
        if (lVarArr[4] != null) {
            i11 = (int) lVarArr[4].c();
            i10 = (int) lVarArr[4].d();
        }
        b(lVarArr, f(bVar, i12, iM, i10, i11, f41205f), f41201b);
        return lVarArr;
    }

    public static float h(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f10 = i10;
        float f11 = f10 / i11;
        float f12 = 0.8f * f11;
        float f13 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f14 = iArr2[i13] * f11;
            float f15 = iArr[i13];
            float f16 = f15 > f14 ? f15 - f14 : f14 - f15;
            if (f16 > f12) {
                return Float.POSITIVE_INFINITY;
            }
            f13 += f16;
        }
        return f13 / f10;
    }
}
