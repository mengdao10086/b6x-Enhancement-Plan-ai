package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CertificateEncodingException;
import zn.j;
import zn.o;

/* JADX INFO: loaded from: classes7.dex */
class X509CertificateInternal extends X509CertificateImpl {
    private final byte[] encoding;
    private final CertificateEncodingException exception;

    public X509CertificateInternal(org.bouncycastle.jcajce.util.d dVar, o oVar, j jVar, boolean[] zArr, String str, byte[] bArr, byte[] bArr2, CertificateEncodingException certificateEncodingException) {
        super(dVar, oVar, jVar, zArr, str, bArr);
        this.encoding = bArr2;
        this.exception = certificateEncodingException;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        CertificateEncodingException certificateEncodingException = this.exception;
        if (certificateEncodingException != null) {
            throw certificateEncodingException;
        }
        byte[] bArr = this.encoding;
        if (bArr != null) {
            return bArr;
        }
        throw new CertificateEncodingException();
    }
}
