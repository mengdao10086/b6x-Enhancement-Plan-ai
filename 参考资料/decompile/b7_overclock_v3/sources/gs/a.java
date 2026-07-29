package gs;

import co.r;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Hashtable;
import pn.s;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class a extends es.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Hashtable f29977d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f29978c;

    static {
        Hashtable hashtable = new Hashtable();
        f29977d = hashtable;
        hashtable.put(s.f46854x3, "RSA");
        f29977d.put(r.W0, "DSA");
    }

    public a(es.b bVar) {
        super(bVar.k());
        this.f29978c = new org.bouncycastle.jcajce.util.c();
    }

    public a(pn.e eVar) {
        super(eVar);
        this.f29978c = new org.bouncycastle.jcajce.util.c();
    }

    public a(byte[] bArr) throws IOException {
        super(bArr);
        this.f29978c = new org.bouncycastle.jcajce.util.c();
    }

    public PublicKey l() throws NoSuchAlgorithmException, InvalidKeyException {
        KeyFactory keyFactoryB;
        try {
            c1 c1VarH = h();
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(c1VarH.getEncoded());
            try {
                keyFactoryB = this.f29978c.b(c1VarH.x().x().L());
            } catch (NoSuchAlgorithmException e10) {
                if (f29977d.get(c1VarH.x().x()) == null) {
                    throw e10;
                }
                keyFactoryB = this.f29978c.b((String) f29977d.get(c1VarH.x().x()));
            }
            return keyFactoryB.generatePublic(x509EncodedKeySpec);
        } catch (IOException unused) {
            throw new InvalidKeyException("error extracting key encoding");
        } catch (NoSuchProviderException e11) {
            throw new NoSuchAlgorithmException("cannot find provider: " + e11.getMessage());
        } catch (InvalidKeySpecException unused2) {
            throw new InvalidKeyException("error decoding public key");
        }
    }

    public a m(String str) {
        this.f29978c = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public a n(Provider provider) {
        this.f29978c = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }
}
