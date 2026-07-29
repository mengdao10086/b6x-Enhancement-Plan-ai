package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f21397d = 2.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f21398e = 1.5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21402i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f21404a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f21405b = new int[80];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21406c = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f21399f = "0123456789-$:/.+ABCD";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char[] f21400g = f21399f.toCharArray();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f21401h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f21403j = {'A', 'B', 'C', 'D'};

    public static boolean h(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.zxing.oned.q
    public ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.f21405b, 0);
        k(aVar);
        int iJ = j();
        this.f21404a.setLength(0);
        int i11 = iJ;
        do {
            int iL = l(i11);
            if (iL == -1) {
                throw NotFoundException.b();
            }
            this.f21404a.append((char) iL);
            i11 += 8;
            if (this.f21404a.length() > 1 && h(f21403j, f21400g[iL])) {
                break;
            }
        } while (i11 < this.f21406c);
        int i12 = i11 - 1;
        int i13 = this.f21405b[i12];
        int i14 = 0;
        for (int i15 = -8; i15 < -1; i15++) {
            i14 += this.f21405b[i11 + i15];
        }
        if (i11 < this.f21406c && i13 < i14 / 2) {
            throw NotFoundException.b();
        }
        m(iJ);
        for (int i16 = 0; i16 < this.f21404a.length(); i16++) {
            StringBuilder sb2 = this.f21404a;
            sb2.setCharAt(i16, f21400g[sb2.charAt(i16)]);
        }
        char cCharAt = this.f21404a.charAt(0);
        char[] cArr = f21403j;
        if (!h(cArr, cCharAt)) {
            throw NotFoundException.b();
        }
        StringBuilder sb3 = this.f21404a;
        if (!h(cArr, sb3.charAt(sb3.length() - 1))) {
            throw NotFoundException.b();
        }
        if (this.f21404a.length() <= 3) {
            throw NotFoundException.b();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb4 = this.f21404a;
            sb4.deleteCharAt(sb4.length() - 1);
            this.f21404a.deleteCharAt(0);
        }
        int i17 = 0;
        for (int i18 = 0; i18 < iJ; i18++) {
            i17 += this.f21405b[i18];
        }
        float f10 = i17;
        while (iJ < i12) {
            i17 += this.f21405b[iJ];
            iJ++;
        }
        float f11 = i10;
        ve.k kVar = new ve.k(this.f21404a.toString(), null, new ve.l[]{new ve.l(f10, f11), new ve.l(i17, f11)}, BarcodeFormat.CODABAR);
        kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]F0");
        return kVar;
    }

    public final void i(int i10) {
        int[] iArr = this.f21405b;
        int i11 = this.f21406c;
        iArr[i11] = i10;
        int i12 = i11 + 1;
        this.f21406c = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[i12 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f21405b = iArr2;
        }
    }

    public final int j() throws NotFoundException {
        for (int i10 = 1; i10 < this.f21406c; i10 += 2) {
            int iL = l(i10);
            if (iL != -1 && h(f21403j, f21400g[iL])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f21405b[i12];
                }
                if (i10 == 1 || this.f21405b[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw NotFoundException.b();
    }

    public final void k(af.a aVar) throws NotFoundException {
        int i10 = 0;
        this.f21406c = 0;
        int iK = aVar.k(0);
        int iL = aVar.l();
        if (iK >= iL) {
            throw NotFoundException.b();
        }
        boolean z10 = true;
        while (iK < iL) {
            if (aVar.h(iK) != z10) {
                i10++;
            } else {
                i(i10);
                z10 = !z10;
                i10 = 1;
            }
            iK++;
        }
        i(i10);
    }

    public final int l(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.f21406c) {
            return -1;
        }
        int[] iArr = this.f21405b;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = 0;
        for (int i16 = i10; i16 < i11; i16 += 2) {
            int i17 = iArr[i16];
            if (i17 < i14) {
                i14 = i17;
            }
            if (i17 > i15) {
                i15 = i17;
            }
        }
        int i18 = (i14 + i15) / 2;
        int i19 = 0;
        for (int i20 = i10 + 1; i20 < i11; i20 += 2) {
            int i21 = iArr[i20];
            if (i21 < i12) {
                i12 = i21;
            }
            if (i21 > i19) {
                i19 = i21;
            }
        }
        int i22 = (i12 + i19) / 2;
        int i23 = 128;
        int i24 = 0;
        for (int i25 = 0; i25 < 7; i25++) {
            i23 >>= 1;
            if (iArr[i10 + i25] > ((i25 & 1) == 0 ? i18 : i22)) {
                i24 |= i23;
            }
        }
        while (true) {
            int[] iArr2 = f21401h;
            if (i13 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i13] == i24) {
                return i13;
            }
            i13++;
        }
    }

    public final void m(int i10) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f21404a.length() - 1;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            if (i12 > length) {
                break;
            }
            int i13 = f21401h[this.f21404a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) * 2);
                iArr[i15] = iArr[i15] + this.f21405b[i11 + i14];
                iArr2[i15] = iArr2[i15] + 1;
                i13 >>= 1;
            }
            i11 += 8;
            i12++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i16 = 0; i16 < 2; i16++) {
            fArr2[i16] = 0.0f;
            int i17 = i16 + 2;
            fArr2[i17] = ((iArr[i16] / iArr2[i16]) + (iArr[i17] / iArr2[i17])) / 2.0f;
            fArr[i16] = fArr2[i17];
            fArr[i17] = ((iArr[i17] * 2.0f) + 1.5f) / iArr2[i17];
        }
        for (int i18 = 0; i18 <= length; i18++) {
            int i19 = f21401h[this.f21404a.charAt(i18)];
            for (int i20 = 6; i20 >= 0; i20--) {
                int i21 = (i20 & 1) + ((i19 & 1) * 2);
                float f10 = this.f21405b[i10 + i20];
                if (f10 < fArr2[i21] || f10 > fArr[i21]) {
                    throw NotFoundException.b();
                }
                i19 >>= 1;
            }
            i10 += 8;
        }
    }
}
