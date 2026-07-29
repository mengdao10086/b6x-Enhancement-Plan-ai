package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cf.c f21601a = new cf.c(cf.a.f10938l);

    public final void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f21601a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.b();
        }
    }

    public af.d b(af.b bVar) throws ChecksumException, FormatException {
        return c(bVar, null);
    }

    public af.d c(af.b bVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException e10;
        a aVar = new a(bVar);
        FormatException formatException = null;
        try {
            return d(aVar, map);
        } catch (ChecksumException e11) {
            e10 = e11;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                af.d dVarD = d(aVar, map);
                dVarD.p(new f(true));
                return dVarD;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e10;
            }
        } catch (FormatException e12) {
            e10 = null;
            formatException = e12;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            af.d dVarD2 = d(aVar, map);
            dVarD2.p(new f(true));
            return dVarD2;
        }
    }

    public final af.d d(a aVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        g gVarE = aVar.e();
        ErrorCorrectionLevel errorCorrectionLevelD = aVar.d().d();
        b[] bVarArrB = b.b(aVar.c(), gVarE, errorCorrectionLevelD);
        int iC = 0;
        for (b bVar : bVarArrB) {
            iC += bVar.c();
        }
        byte[] bArr = new byte[iC];
        int i10 = 0;
        for (b bVar2 : bVarArrB) {
            byte[] bArrA = bVar2.a();
            int iC2 = bVar2.c();
            a(bArrA, iC2);
            int i11 = 0;
            while (i11 < iC2) {
                bArr[i10] = bArrA[i11];
                i11++;
                i10++;
            }
        }
        return c.a(bArr, gVarE, errorCorrectionLevelD, map);
    }

    public af.d e(boolean[][] zArr) throws ChecksumException, FormatException {
        return f(zArr, null);
    }

    public af.d f(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return c(af.b.o(zArr), map);
    }
}
