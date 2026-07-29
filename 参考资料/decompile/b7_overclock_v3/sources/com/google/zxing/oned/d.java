package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f21428e = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f21429f = {52, gg.b.S, 97, 352, 49, 304, 112, 37, 292, 100, gg.b.f29505x, 73, 328, 25, 280, 88, 13, gg.b.D, 76, 28, gg.b.f29457l, 67, 322, 19, 274, 82, 7, gg.b.f29481r, 70, 22, gg.b.f29445i, s0.c.f49294u, 448, 145, 400, 208, 133, gg.b.f29469o, 196, os.a.f46207a, 162, 138, 42};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f21430g = 148;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f21433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f21434d;

    public d() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h(java.lang.CharSequence r12) throws com.google.zxing.FormatException {
        /*
            int r0 = r12.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        Lb:
            if (r3 >= r0) goto Lbe
            char r4 = r12.charAt(r3)
            r5 = 47
            r6 = 37
            r7 = 36
            r8 = 43
            if (r4 == r8) goto L27
            if (r4 == r7) goto L27
            if (r4 == r6) goto L27
            if (r4 != r5) goto L22
            goto L27
        L22:
            r1.append(r4)
            goto Lb5
        L27:
            int r3 = r3 + 1
            char r9 = r12.charAt(r3)
            r10 = 90
            r11 = 65
            if (r4 == r7) goto Lab
            r7 = 79
            if (r4 == r6) goto L5d
            if (r4 == r8) goto L51
            if (r4 == r5) goto L3e
        L3b:
            r4 = 0
            goto Lb2
        L3e:
            if (r9 < r11) goto L46
            if (r9 > r7) goto L46
            int r9 = r9 + (-32)
            goto Lb1
        L46:
            if (r9 != r10) goto L4c
            r4 = 58
            goto Lb2
        L4c:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.b()
            throw r12
        L51:
            if (r9 < r11) goto L58
            if (r9 > r10) goto L58
            int r9 = r9 + 32
            goto Lb1
        L58:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.b()
            throw r12
        L5d:
            if (r9 < r11) goto L66
            r4 = 69
            if (r9 > r4) goto L66
            int r9 = r9 + (-38)
            goto Lb1
        L66:
            r4 = 70
            if (r9 < r4) goto L71
            r4 = 74
            if (r9 > r4) goto L71
            int r9 = r9 + (-11)
            goto Lb1
        L71:
            r4 = 75
            if (r9 < r4) goto L7a
            if (r9 > r7) goto L7a
            int r9 = r9 + 16
            goto Lb1
        L7a:
            r4 = 80
            if (r9 < r4) goto L85
            r4 = 84
            if (r9 > r4) goto L85
            int r9 = r9 + 43
            goto Lb1
        L85:
            r4 = 85
            if (r9 != r4) goto L8a
            goto L3b
        L8a:
            r4 = 86
            if (r9 != r4) goto L91
            r4 = 64
            goto Lb2
        L91:
            r4 = 87
            if (r9 != r4) goto L98
            r4 = 96
            goto Lb2
        L98:
            r4 = 88
            if (r9 == r4) goto La8
            r4 = 89
            if (r9 == r4) goto La8
            if (r9 != r10) goto La3
            goto La8
        La3:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.b()
            throw r12
        La8:
            r4 = 127(0x7f, float:1.78E-43)
            goto Lb2
        Lab:
            if (r9 < r11) goto Lb9
            if (r9 > r10) goto Lb9
            int r9 = r9 + (-64)
        Lb1:
            char r4 = (char) r9
        Lb2:
            r1.append(r4)
        Lb5:
            int r3 = r3 + 1
            goto Lb
        Lb9:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.b()
            throw r12
        Lbe:
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.d.h(java.lang.CharSequence):java.lang.String");
    }

    public static int[] i(af.a aVar, int[] iArr) throws NotFoundException {
        int iL = aVar.l();
        int iJ = aVar.j(0);
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
                    if (k(iArr) == 148 && aVar.n(Math.max(0, i10 - ((iJ - i10) / 2)), i10, false)) {
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

    public static char j(int i10) throws NotFoundException {
        int i11 = 0;
        while (true) {
            int[] iArr = f21429f;
            if (i11 >= iArr.length) {
                if (i10 == 148) {
                    return '*';
                }
                throw NotFoundException.b();
            }
            if (iArr[i11] == i10) {
                return f21428e.charAt(i11);
            }
            i11++;
        }
    }

    public static int k(int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            int i11 = Integer.MAX_VALUE;
            for (int i12 : iArr) {
                if (i12 < i11 && i12 > i10) {
                    i11 = i12;
                }
            }
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = iArr[i16];
                if (i17 > i11) {
                    i14 |= 1 << ((length - 1) - i16);
                    i13++;
                    i15 += i17;
                }
            }
            if (i13 == 3) {
                for (int i18 = 0; i18 < length && i13 > 0; i18++) {
                    int i19 = iArr[i18];
                    if (i19 > i11) {
                        i13--;
                        if (i19 * 2 >= i15) {
                            return -1;
                        }
                    }
                }
                return i14;
            }
            if (i13 <= 3) {
                return -1;
            }
            i10 = i11;
        }
    }

    @Override // com.google.zxing.oned.q
    public ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = this.f21434d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f21433c;
        sb2.setLength(0);
        int iJ = aVar.j(i(aVar, iArr)[1]);
        int iL = aVar.l();
        while (true) {
            q.f(aVar, iJ, iArr);
            int iK = k(iArr);
            if (iK < 0) {
                throw NotFoundException.b();
            }
            char cJ = j(iK);
            sb2.append(cJ);
            int i11 = iJ;
            for (int i12 : iArr) {
                i11 += i12;
            }
            int iJ2 = aVar.j(i11);
            if (cJ == '*') {
                sb2.setLength(sb2.length() - 1);
                int i13 = 0;
                for (int i14 : iArr) {
                    i13 += i14;
                }
                int i15 = (iJ2 - iJ) - i13;
                if (iJ2 != iL && i15 * 2 < i13) {
                    throw NotFoundException.b();
                }
                if (this.f21431a) {
                    int length = sb2.length() - 1;
                    int iIndexOf = 0;
                    for (int i16 = 0; i16 < length; i16++) {
                        iIndexOf += f21428e.indexOf(this.f21433c.charAt(i16));
                    }
                    if (sb2.charAt(length) != f21428e.charAt(iIndexOf % 43)) {
                        throw ChecksumException.b();
                    }
                    sb2.setLength(length);
                }
                if (sb2.length() == 0) {
                    throw NotFoundException.b();
                }
                float f10 = i10;
                ve.k kVar = new ve.k(this.f21432b ? h(sb2) : sb2.toString(), null, new ve.l[]{new ve.l((r2[1] + r2[0]) / 2.0f, f10), new ve.l(iJ + (i13 / 2.0f), f10)}, BarcodeFormat.CODE_39);
                kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]A0");
                return kVar;
            }
            iJ = iJ2;
        }
    }

    public d(boolean z10) {
        this(z10, false);
    }

    public d(boolean z10, boolean z11) {
        this.f21431a = z10;
        this.f21432b = z11;
        this.f21433c = new StringBuilder(20);
        this.f21434d = new int[9];
    }
}
