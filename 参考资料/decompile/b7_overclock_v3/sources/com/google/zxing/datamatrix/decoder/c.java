package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cf.c f21286a = new cf.c(cf.a.f10939m);

    public final void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f21286a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.b();
        }
    }

    public af.d b(af.b bVar) throws ChecksumException, FormatException {
        a aVar = new a(bVar);
        b[] bVarArrB = b.b(aVar.c(), aVar.b());
        int iC = 0;
        for (b bVar2 : bVarArrB) {
            iC += bVar2.c();
        }
        byte[] bArr = new byte[iC];
        int length = bVarArrB.length;
        for (int i10 = 0; i10 < length; i10++) {
            b bVar3 = bVarArrB[i10];
            byte[] bArrA = bVar3.a();
            int iC2 = bVar3.c();
            a(bArrA, iC2);
            for (int i11 = 0; i11 < iC2; i11++) {
                bArr[(i11 * length) + i10] = bArrA[i11];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }

    public af.d c(boolean[][] zArr) throws ChecksumException, FormatException {
        return b(af.b.o(zArr));
    }
}
