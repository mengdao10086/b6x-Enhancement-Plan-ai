package bs;

import co.r;
import gm.y;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.openssl.PEMException;
import pn.s;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f9589b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f9590a = new org.bouncycastle.jcajce.util.c();

    static {
        HashMap map = new HashMap();
        f9589b = map;
        map.put(r.f11174l0, "ECDSA");
        map.put(s.f46854x3, "RSA");
        map.put(r.W0, "DSA");
    }

    public final KeyFactory a(zn.b bVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        y yVarX = bVar.x();
        String strL = (String) f9589b.get(yVarX);
        if (strL == null) {
            strL = yVarX.L();
        }
        try {
            return this.f9590a.b(strL);
        } catch (NoSuchAlgorithmException e10) {
            if (strL.equals("ECDSA")) {
                return this.f9590a.b("EC");
            }
            throw e10;
        }
    }

    public KeyPair b(zr.g gVar) throws PEMException {
        try {
            KeyFactory keyFactoryA = a(gVar.a().B());
            return new KeyPair(keyFactoryA.generatePublic(new X509EncodedKeySpec(gVar.b().getEncoded())), keyFactoryA.generatePrivate(new PKCS8EncodedKeySpec(gVar.a().getEncoded())));
        } catch (Exception e10) {
            throw new PEMException("unable to convert key pair: " + e10.getMessage(), e10);
        }
    }

    public PrivateKey c(u uVar) throws PEMException {
        try {
            return a(uVar.B()).generatePrivate(new PKCS8EncodedKeySpec(uVar.getEncoded()));
        } catch (Exception e10) {
            throw new PEMException("unable to convert key pair: " + e10.getMessage(), e10);
        }
    }

    public PublicKey d(c1 c1Var) throws PEMException {
        try {
            return a(c1Var.x()).generatePublic(new X509EncodedKeySpec(c1Var.getEncoded()));
        } catch (Exception e10) {
            throw new PEMException("unable to convert key pair: " + e10.getMessage(), e10);
        }
    }

    public b e(String str) {
        this.f9590a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public b f(Provider provider) {
        this.f9590a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }
}
