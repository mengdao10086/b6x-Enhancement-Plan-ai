package com.google.zxing.oned;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;
import rb.k0;
import v7.a;
import w.w;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21435c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f21436d = f21435c.toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f21437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21438f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f21439a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f21440b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, gg.b.f29513z, w.c.f53702v, w.c.f53698r, 418, a.c.C, 402, gg.b.A, 360, 356, 354, 308, 282, 344, 332, 326, 300, gg.b.P, 436, k0.f48142c, 428, w.c.f53700t, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, FloatingActionButton.f20202y, 306, 350};
        f21437e = iArr;
        f21438f = iArr[47];
    }

    public static void h(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    public static void i(CharSequence charSequence, int i10, int i11) throws ChecksumException {
        int iIndexOf = 0;
        int i12 = 1;
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iIndexOf += f21435c.indexOf(charSequence.charAt(i13)) * i12;
            i12++;
            if (i12 > i11) {
                i12 = 1;
            }
        }
        if (charSequence.charAt(i10) != f21436d[iIndexOf % 47]) {
            throw ChecksumException.b();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String j(java.lang.CharSequence r9) throws com.google.zxing.FormatException {
        /*
            int r0 = r9.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        Lb:
            if (r3 >= r0) goto Lb3
            char r4 = r9.charAt(r3)
            r5 = 97
            if (r4 < r5) goto Lac
            r5 = 100
            if (r4 > r5) goto Lac
            int r5 = r0 + (-1)
            if (r3 >= r5) goto La7
            int r3 = r3 + 1
            char r5 = r9.charAt(r3)
            r6 = 79
            r7 = 90
            r8 = 65
            switch(r4) {
                case 97: goto L96;
                case 98: goto L4d;
                case 99: goto L3c;
                case 100: goto L2f;
                default: goto L2c;
            }
        L2c:
            r4 = 0
            goto La3
        L2f:
            if (r5 < r8) goto L37
            if (r5 > r7) goto L37
            int r5 = r5 + 32
            goto L9c
        L37:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.b()
            throw r9
        L3c:
            if (r5 < r8) goto L43
            if (r5 > r6) goto L43
            int r5 = r5 + (-32)
            goto L9c
        L43:
            if (r5 != r7) goto L48
            r4 = 58
            goto La3
        L48:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.b()
            throw r9
        L4d:
            if (r5 < r8) goto L56
            r4 = 69
            if (r5 > r4) goto L56
            int r5 = r5 + (-38)
            goto L9c
        L56:
            r4 = 70
            if (r5 < r4) goto L61
            r4 = 74
            if (r5 > r4) goto L61
            int r5 = r5 + (-11)
            goto L9c
        L61:
            r4 = 75
            if (r5 < r4) goto L6a
            if (r5 > r6) goto L6a
            int r5 = r5 + 16
            goto L9c
        L6a:
            r4 = 80
            if (r5 < r4) goto L75
            r4 = 84
            if (r5 > r4) goto L75
            int r5 = r5 + 43
            goto L9c
        L75:
            r4 = 85
            if (r5 != r4) goto L7a
            goto L2c
        L7a:
            r4 = 86
            if (r5 != r4) goto L81
            r4 = 64
            goto La3
        L81:
            r4 = 87
            if (r5 != r4) goto L88
            r4 = 96
            goto La3
        L88:
            r4 = 88
            if (r5 < r4) goto L91
            if (r5 > r7) goto L91
            r4 = 127(0x7f, float:1.78E-43)
            goto La3
        L91:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.b()
            throw r9
        L96:
            if (r5 < r8) goto L9e
            if (r5 > r7) goto L9e
            int r5 = r5 + (-64)
        L9c:
            char r4 = (char) r5
            goto La3
        L9e:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.b()
            throw r9
        La3:
            r1.append(r4)
            goto Laf
        La7:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.b()
            throw r9
        Lac:
            r1.append(r4)
        Laf:
            int r3 = r3 + 1
            goto Lb
        Lb3:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.f.j(java.lang.CharSequence):java.lang.String");
    }

    public static char l(int i10) throws NotFoundException {
        int i11 = 0;
        while (true) {
            int[] iArr = f21437e;
            if (i11 >= iArr.length) {
                throw NotFoundException.b();
            }
            if (iArr[i11] == i10) {
                return f21436d[i11];
            }
            i11++;
        }
    }

    public static int m(int[] iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int length = iArr.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int iRound = Math.round((iArr[i13] * 9.0f) / i10);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i13 & 1) == 0) {
                for (int i14 = 0; i14 < iRound; i14++) {
                    i12 = (i12 << 1) | 1;
                }
            } else {
                i12 <<= iRound;
            }
        }
        return i12;
    }

    @Override // com.google.zxing.oned.q
    public ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int iJ = aVar.j(k(aVar)[1]);
        int iL = aVar.l();
        int[] iArr = this.f21440b;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f21439a;
        sb2.setLength(0);
        while (true) {
            q.f(aVar, iJ, iArr);
            int iM = m(iArr);
            if (iM < 0) {
                throw NotFoundException.b();
            }
            char cL = l(iM);
            sb2.append(cL);
            int i11 = iJ;
            for (int i12 : iArr) {
                i11 += i12;
            }
            int iJ2 = aVar.j(i11);
            if (cL == '*') {
                sb2.deleteCharAt(sb2.length() - 1);
                int i13 = 0;
                for (int i14 : iArr) {
                    i13 += i14;
                }
                if (iJ2 == iL || !aVar.h(iJ2)) {
                    throw NotFoundException.b();
                }
                if (sb2.length() < 2) {
                    throw NotFoundException.b();
                }
                h(sb2);
                sb2.setLength(sb2.length() - 2);
                float f10 = i10;
                ve.k kVar = new ve.k(j(sb2), null, new ve.l[]{new ve.l((r14[1] + r14[0]) / 2.0f, f10), new ve.l(iJ + (i13 / 2.0f), f10)}, BarcodeFormat.CODE_93);
                kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]G0");
                return kVar;
            }
            iJ = iJ2;
        }
    }

    public final int[] k(af.a aVar) throws NotFoundException {
        int iL = aVar.l();
        int iJ = aVar.j(0);
        Arrays.fill(this.f21440b, 0);
        int[] iArr = this.f21440b;
        int length = iArr.length;
        int i10 = iJ;
        boolean z10 = false;
        int i11 = 0;
        while (iJ < iL) {
            if (aVar.h(iJ) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (m(iArr) == f21438f) {
                        return new int[]{i10, iJ};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i12 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i12);
                    iArr[i12] = 0;
                    iArr[i11] = 0;
                    i11--;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            iJ++;
        }
        throw NotFoundException.b();
    }
}
