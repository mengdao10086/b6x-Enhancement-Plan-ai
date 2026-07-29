package oq;

import gm.c0;
import gm.f2;
import gm.z;
import java.io.IOException;
import java.security.SignatureException;

/* JADX INFO: loaded from: classes7.dex */
public class d extends c {
    public void b(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            byte b10 = bArr[i10];
            bArr[i10] = bArr[(bArr.length - 1) - i10];
            bArr[(bArr.length - 1) - i10] = b10;
        }
    }

    @Override // oq.c, java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArrJ = z.I(super.engineSign()).J();
        b(bArrJ);
        try {
            return new f2(bArrJ).getEncoded();
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // oq.c, java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        try {
            byte[] bArrJ = ((z) c0.D(bArr)).J();
            b(bArrJ);
            try {
                return super.engineVerify(new f2(bArrJ).getEncoded());
            } catch (SignatureException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new SignatureException(e11.toString());
            }
        } catch (IOException unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
