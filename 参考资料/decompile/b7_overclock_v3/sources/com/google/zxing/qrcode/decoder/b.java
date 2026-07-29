package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.g;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f21597b;

    public b(int i10, byte[] bArr) {
        this.f21596a = i10;
        this.f21597b = bArr;
    }

    public static b[] b(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != gVar.h()) {
            throw new IllegalArgumentException();
        }
        g.b bVarF = gVar.f(errorCorrectionLevel);
        g.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (g.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        b[] bVarArr = new b[iA];
        int i10 = 0;
        for (g.a aVar2 : aVarArrA) {
            int i11 = 0;
            while (i11 < aVar2.a()) {
                int iB = aVar2.b();
                bVarArr[i10] = new b(iB, new byte[bVarF.b() + iB]);
                i11++;
                i10++;
            }
        }
        int length = bVarArr[0].f21597b.length;
        int i12 = iA - 1;
        while (i12 >= 0 && bVarArr[i12].f21597b.length != length) {
            i12--;
        }
        int i13 = i12 + 1;
        int iB2 = length - bVarF.b();
        int i14 = 0;
        for (int i15 = 0; i15 < iB2; i15++) {
            int i16 = 0;
            while (i16 < i10) {
                bVarArr[i16].f21597b[i15] = bArr[i14];
                i16++;
                i14++;
            }
        }
        int i17 = i13;
        while (i17 < i10) {
            bVarArr[i17].f21597b[iB2] = bArr[i14];
            i17++;
            i14++;
        }
        int length2 = bVarArr[0].f21597b.length;
        while (iB2 < length2) {
            int i18 = 0;
            while (i18 < i10) {
                bVarArr[i18].f21597b[i18 < i13 ? iB2 : iB2 + 1] = bArr[i14];
                i18++;
                i14++;
            }
            iB2++;
        }
        return bVarArr;
    }

    public byte[] a() {
        return this.f21597b;
    }

    public int c() {
        return this.f21596a;
    }
}
