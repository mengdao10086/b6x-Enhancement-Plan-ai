package bs;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.jcajce.JcaX509CRLHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class a extends zr.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f9584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f9586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f9587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Provider f9588i;

    public a(Object obj) throws IOException {
        super(c(obj));
    }

    public a(Object obj, zr.f fVar) throws IOException {
        super(c(obj), fVar);
    }

    public static Object c(Object obj) throws IOException {
        if (obj instanceof X509Certificate) {
            try {
                return new JcaX509CertificateHolder((X509Certificate) obj);
            } catch (CertificateEncodingException e10) {
                throw new IllegalArgumentException("Cannot encode object: " + e10.toString());
            }
        }
        if (!(obj instanceof X509CRL)) {
            return obj instanceof KeyPair ? c(((KeyPair) obj).getPrivate()) : obj instanceof PrivateKey ? u.z(((Key) obj).getEncoded()) : obj instanceof PublicKey ? c1.A(((PublicKey) obj).getEncoded()) : obj;
        }
        try {
            return new JcaX509CRLHolder((X509CRL) obj);
        } catch (CRLException e11) {
            throw new IllegalArgumentException("Cannot encode object: " + e11.toString());
        }
    }
}
