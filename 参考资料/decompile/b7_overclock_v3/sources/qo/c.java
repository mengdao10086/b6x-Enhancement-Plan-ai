package qo;

import gm.z;
import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import po.d;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class c extends d {
    public c(X509Certificate x509Certificate) {
        super(e(x509Certificate.getIssuerX500Principal()), x509Certificate.getSerialNumber(), f(x509Certificate));
    }

    public c(X500Principal x500Principal, BigInteger bigInteger) {
        super(e(x500Principal), bigInteger);
    }

    public c(X500Principal x500Principal, BigInteger bigInteger, byte[] bArr) {
        super(e(x500Principal), bigInteger, bArr);
    }

    public static xn.d e(X500Principal x500Principal) {
        if (x500Principal == null) {
            return null;
        }
        return xn.d.A(x500Principal.getEncoded());
    }

    public static byte[] f(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(y.f59058e.L());
        if (extensionValue != null) {
            return z.I(z.I(extensionValue).J()).J();
        }
        return null;
    }
}
