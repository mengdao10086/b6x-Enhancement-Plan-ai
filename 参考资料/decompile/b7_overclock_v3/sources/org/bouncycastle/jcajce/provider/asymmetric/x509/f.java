package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;
import zn.p;

/* JADX INFO: loaded from: classes7.dex */
public class f extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f45099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CRLException f45100g;

    public f(org.bouncycastle.jcajce.util.d dVar, p pVar, String str, byte[] bArr, boolean z10, byte[] bArr2, CRLException cRLException) {
        super(dVar, pVar, str, bArr, z10);
        this.f45099f = bArr2;
        this.f45100g = cRLException;
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        CRLException cRLException = this.f45100g;
        if (cRLException != null) {
            throw cRLException;
        }
        byte[] bArr = this.f45099f;
        if (bArr != null) {
            return bArr;
        }
        throw new CRLException();
    }
}
