package tq;

import fp.m0;
import gm.d2;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import np.e2;
import np.f2;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateCrtKey;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey;
import pn.s;

/* JADX INFO: loaded from: classes7.dex */
public class f extends KeyPairGenerator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zn.b f51585d = new zn.b(s.f46854x3, d2.f29657b);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zn.b f51586e = new zn.b(s.G3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f51587f = BigInteger.valueOf(65537);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public np.d2 f51588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m0 f51589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f51590c;

    public static class a extends f {
        public a() {
            super("RSASSA-PSS", f.f51586e);
        }
    }

    public f() {
        this("RSA", f51585d);
    }

    public f(String str, zn.b bVar) {
        super(str);
        this.f51590c = bVar;
        this.f51589b = new m0();
        np.d2 d2Var = new np.d2(f51587f, n.f(), 2048, org.bouncycastle.jcajce.provider.asymmetric.util.n.a(2048));
        this.f51588a = d2Var;
        this.f51589b.a(d2Var);
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        org.bouncycastle.crypto.c cVarB = this.f51589b.b();
        return new KeyPair(new BCRSAPublicKey(this.f51590c, (e2) cVarB.b()), new BCRSAPrivateCrtKey(this.f51590c, (f2) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        np.d2 d2Var = new np.d2(f51587f, secureRandom, i10, org.bouncycastle.jcajce.provider.asymmetric.util.n.a(i10));
        this.f51588a = d2Var;
        this.f51589b.a(d2Var);
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof RSAKeyGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
        }
        RSAKeyGenParameterSpec rSAKeyGenParameterSpec = (RSAKeyGenParameterSpec) algorithmParameterSpec;
        np.d2 d2Var = new np.d2(rSAKeyGenParameterSpec.getPublicExponent(), secureRandom, rSAKeyGenParameterSpec.getKeysize(), org.bouncycastle.jcajce.provider.asymmetric.util.n.a(2048));
        this.f51588a = d2Var;
        this.f51589b.a(d2Var);
    }
}
