package com.google.zxing.oned;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f21412a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f21413b = 0.25f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f21414c = 0.7f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21415d = 98;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21416e = 99;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21417f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f21418g = 101;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f21419h = 102;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21420i = 97;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f21421j = 96;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f21422k = 101;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f21423l = 100;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f21424m = 103;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f21425n = 104;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f21426o = 105;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f21427p = 106;

    public static int h(af.a aVar, int[] iArr, int i10) throws NotFoundException {
        q.f(aVar, i10, iArr);
        float f10 = 0.25f;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = f21412a;
            if (i12 >= iArr2.length) {
                break;
            }
            float fE = q.e(iArr, iArr2[i12], 0.7f);
            if (fE < f10) {
                i11 = i12;
                f10 = fE;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.b();
    }

    public static int[] i(af.a aVar) throws NotFoundException {
        int iL = aVar.l();
        int iJ = aVar.j(0);
        int[] iArr = new int[6];
        int i10 = iJ;
        boolean z10 = false;
        int i11 = 0;
        while (iJ < iL) {
            if (aVar.h(iJ) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == 5) {
                    float f10 = 0.25f;
                    int i12 = -1;
                    for (int i13 = 103; i13 <= 105; i13++) {
                        float fE = q.e(iArr, f21412a[i13], 0.7f);
                        if (fE < f10) {
                            i12 = i13;
                            f10 = fE;
                        }
                    }
                    if (i12 >= 0 && aVar.n(Math.max(0, i10 - ((iJ - i10) / 2)), i10, false)) {
                        return new int[]{i10, iJ, i12};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i14 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i14);
                    iArr[i14] = 0;
                    iArr[i11] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            iJ++;
        }
        throw NotFoundException.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011f A[FALL_THROUGH, PHI: r21 r22
  0x011f: PHI (r21v8 boolean) = 
  (r21v5 boolean)
  (r21v5 boolean)
  (r21v5 boolean)
  (r21v5 boolean)
  (r21v15 boolean)
  (r21v15 boolean)
  (r21v15 boolean)
  (r21v15 boolean)
 binds: [B:73:0x011c, B:81:0x0133, B:85:0x013f, B:84:0x013b, B:43:0x00c5, B:51:0x00db, B:55:0x00e7, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]
  0x011f: PHI (r22v8 int) = (r22v1 int), (r22v6 int), (r22v6 int), (r22v6 int), (r22v1 int), (r22v12 int), (r22v12 int), (r22v12 int) binds: [B:73:0x011c, B:81:0x0133, B:85:0x013f, B:84:0x013b, B:43:0x00c5, B:51:0x00db, B:55:0x00e7, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0153 A[PHI: r21
  0x0153: PHI (r21v12 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:91:0x0151, B:60:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0157 A[PHI: r21
  0x0157: PHI (r21v11 boolean) = (r21v5 boolean), (r21v5 boolean), (r21v15 boolean), (r21v15 boolean) binds: [B:90:0x014f, B:91:0x0151, B:59:0x00f2, B:60:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015a A[PHI: r21
  0x015a: PHI (r21v10 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:73:0x011c, B:43:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0162 A[PHI: r21
  0x0162: PHI (r21v9 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:73:0x011c, B:43:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0166 A[PHI: r21
  0x0166: PHI (r21v7 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:72:0x011a, B:42:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ve.k b(int r26, af.a r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        /*
            Method dump skipped, instruction units count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.c.b(int, af.a, java.util.Map):ve.k");
    }
}
