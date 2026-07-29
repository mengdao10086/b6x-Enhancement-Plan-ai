package org.bouncycastle.jce;

import co.l;
import co.n;
import co.r;
import gm.c0;
import gm.y;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class ECKeyUtil {

    public static class UnexpectedException extends RuntimeException {
        private Throwable cause;

        public UnexpectedException(Throwable th2) {
            super(th2.toString());
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public static PrivateKey a(PrivateKey privateKey, String str) throws NoSuchAlgorithmException, IllegalArgumentException, NoSuchProviderException {
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return b(privateKey, provider);
        }
        throw new NoSuchProviderException("cannot find provider: " + str);
    }

    public static PrivateKey b(PrivateKey privateKey, Provider provider) throws NoSuchAlgorithmException, IllegalArgumentException {
        l lVar;
        try {
            u uVarZ = u.z(c0.D(privateKey.getEncoded()));
            if (uVarZ.B().x().C(qm.a.f47463m)) {
                throw new UnsupportedEncodingException("cannot convert GOST key to explicit parameters.");
            }
            co.j jVarY = co.j.y(uVarZ.B().A());
            if (jVarY.B()) {
                lVar = org.bouncycastle.jcajce.provider.asymmetric.util.i.j(y.N(jVarY.z()));
                if (lVar.G()) {
                    lVar = new l(lVar.y(), lVar.x(), lVar.E(), lVar.C());
                }
            } else {
                if (!jVarY.A()) {
                    return privateKey;
                }
                uq.c cVar = BouncyCastleProvider.f45330c;
                lVar = new l(cVar.b().a(), new n(cVar.b().b(), false), cVar.b().d(), cVar.b().c());
            }
            return KeyFactory.getInstance(privateKey.getAlgorithm(), provider).generatePrivate(new PKCS8EncodedKeySpec(new u(new zn.b(r.f11174l0, new co.j(lVar)), uVarZ.G()).getEncoded()));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (NoSuchAlgorithmException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new UnexpectedException(e12);
        }
    }

    public static PublicKey c(PublicKey publicKey, String str) throws NoSuchAlgorithmException, IllegalArgumentException, NoSuchProviderException {
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return d(publicKey, provider);
        }
        throw new NoSuchProviderException("cannot find provider: " + str);
    }

    public static PublicKey d(PublicKey publicKey, Provider provider) throws NoSuchAlgorithmException, IllegalArgumentException {
        l lVar;
        try {
            c1 c1VarA = c1.A(c0.D(publicKey.getEncoded()));
            if (c1VarA.x().x().C(qm.a.f47463m)) {
                throw new IllegalArgumentException("cannot convert GOST key to explicit parameters.");
            }
            co.j jVarY = co.j.y(c1VarA.x().A());
            if (jVarY.B()) {
                lVar = org.bouncycastle.jcajce.provider.asymmetric.util.i.j(y.N(jVarY.z()));
                if (lVar.G()) {
                    lVar = new l(lVar.y(), lVar.x(), lVar.E(), lVar.C());
                }
            } else {
                if (!jVarY.A()) {
                    return publicKey;
                }
                uq.c cVar = BouncyCastleProvider.f45330c;
                lVar = new l(cVar.b().a(), new n(cVar.b().b(), false), cVar.b().d(), cVar.b().c());
            }
            return KeyFactory.getInstance(publicKey.getAlgorithm(), provider).generatePublic(new X509EncodedKeySpec(new c1(new zn.b(r.f11174l0, new co.j(lVar)), c1VarA.C().H()).getEncoded()));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (NoSuchAlgorithmException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new UnexpectedException(e12);
        }
    }
}
