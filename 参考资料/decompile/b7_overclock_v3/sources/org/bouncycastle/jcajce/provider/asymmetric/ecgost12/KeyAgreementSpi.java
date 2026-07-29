package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import co.q;
import cr.w;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import np.g0;
import np.l0;
import np.z1;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import uo.j;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreementSpi extends org.bouncycastle.jcajce.provider.asymmetric.util.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final q f44996m = new q();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f44997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g0 f44998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j f44999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f45000l;

    public static class a extends KeyAgreementSpi {
        public a() {
            super("ECGOST3410-2012-256", new j(new zo.j()), null);
        }
    }

    public static class b extends KeyAgreementSpi {
        public b() {
            super("ECGOST3410-2012-512", new j(new zo.j()), null);
        }
    }

    public KeyAgreementSpi(String str, j jVar, org.bouncycastle.crypto.q qVar) {
        super(str, qVar);
        this.f44997i = str;
        this.f44999k = jVar;
    }

    public static np.c f(PublicKey publicKey) throws InvalidKeyException {
        return publicKey instanceof BCECGOST3410_2012PublicKey ? ((BCECGOST3410_2012PublicKey) publicKey).d() : i.d(publicKey);
    }

    public static String g(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a
    public byte[] a() {
        return this.f45000l;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z10) throws IllegalStateException, InvalidKeyException {
        if (this.f44998j == null) {
            throw new IllegalStateException(this.f44997i + " not initialised.");
        }
        if (!z10) {
            throw new IllegalStateException(this.f44997i + " can only be between two parties.");
        }
        if (!(key instanceof PublicKey)) {
            throw new InvalidKeyException(this.f44997i + " key agreement requires " + g(ECPublicKey.class) + " for doPhase");
        }
        try {
            this.f45000l = this.f44999k.a(f((PublicKey) key));
            return null;
        } catch (Exception e10) {
            throw new InvalidKeyException("calculation failed: " + e10.getMessage()) { // from class: org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi.1
                @Override // java.lang.Throwable
                public Throwable getCause() {
                    return e10;
                }
            };
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        h(key, null);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null && !(algorithmParameterSpec instanceof w)) {
            throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
        }
        h(key, algorithmParameterSpec);
    }

    public final void h(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        if (key instanceof PrivateKey) {
            l0 l0Var = (l0) i.c((PrivateKey) key);
            this.f44998j = l0Var.d();
            byte[] bArrA = algorithmParameterSpec instanceof w ? ((w) algorithmParameterSpec).a() : null;
            this.f45050c = bArrA;
            this.f44999k.d(new z1(l0Var, bArrA));
            return;
        }
        throw new InvalidKeyException(this.f44997i + " key agreement requires " + g(ECPrivateKey.class) + " for initialisation");
    }
}
