package nt;

import gm.f0;
import gm.z;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.jce.g;
import zn.b0;
import zn.c0;
import zn.c1;
import zn.i;
import zn.t1;
import zn.y;

/* JADX INFO: loaded from: classes6.dex */
public class a extends i {
    public a(PublicKey publicKey) throws InvalidKeyException {
        super(E(publicKey));
    }

    public a(X509Certificate x509Certificate) throws CertificateParsingException {
        super(D(x509Certificate));
    }

    public a(t1 t1Var) {
        super((f0) t1Var.b());
    }

    public a(y yVar) {
        super((f0) yVar.C());
    }

    public a(byte[] bArr) throws IOException {
        super((f0) b.a(bArr));
    }

    public static f0 D(X509Certificate x509Certificate) throws CertificateParsingException {
        try {
            if (x509Certificate.getVersion() != 3) {
                return (f0) new i(c1.A(x509Certificate.getPublicKey().getEncoded()), new c0(new b0(g.b(x509Certificate))), x509Certificate.getSerialNumber()).b();
            }
            b0 b0Var = new b0(g.b(x509Certificate));
            byte[] extensionValue = x509Certificate.getExtensionValue(y.f59058e.L());
            return extensionValue != null ? (f0) new i(((z) b.a(extensionValue)).J(), new c0(b0Var), x509Certificate.getSerialNumber()).b() : (f0) new i(c1.A(x509Certificate.getPublicKey().getEncoded()), new c0(b0Var), x509Certificate.getSerialNumber()).b();
        } catch (Exception e10) {
            throw new CertificateParsingException("Exception extracting certificate details: " + e10.toString());
        }
    }

    public static f0 E(PublicKey publicKey) throws InvalidKeyException {
        try {
            return (f0) new i(c1.A(publicKey.getEncoded())).b();
        } catch (Exception e10) {
            throw new InvalidKeyException("can't process key: " + e10);
        }
    }
}
