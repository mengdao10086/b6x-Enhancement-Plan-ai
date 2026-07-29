package nq;

import fp.h;
import fp.k;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import np.m;
import np.q;
import np.r;
import np.s;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.j;

/* JADX INFO: loaded from: classes7.dex */
public class g extends KeyPairGenerator {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Hashtable f42612f = new Hashtable();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Object f42613g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f42614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f42615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f42617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42618e;

    public g() {
        super("DH");
        this.f42615b = new h();
        this.f42616c = 2048;
        this.f42617d = n.f();
        this.f42618e = false;
    }

    public final m a(SecureRandom secureRandom, DHParameterSpec dHParameterSpec) {
        return dHParameterSpec instanceof cr.c ? new m(secureRandom, ((cr.c) dHParameterSpec).a()) : new m(secureRandom, new q(dHParameterSpec.getP(), dHParameterSpec.getG(), null, dHParameterSpec.getL()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        m mVarA;
        if (!this.f42618e) {
            Integer numG = j.g(this.f42616c);
            if (f42612f.containsKey(numG)) {
                mVarA = (m) f42612f.get(numG);
            } else {
                DHParameterSpec dHParameterSpecE = BouncyCastleProvider.f45330c.e(this.f42616c);
                if (dHParameterSpecE != null) {
                    mVarA = a(this.f42617d, dHParameterSpecE);
                } else {
                    synchronized (f42613g) {
                        if (f42612f.containsKey(numG)) {
                            this.f42614a = (m) f42612f.get(numG);
                        } else {
                            k kVar = new k();
                            int i10 = this.f42616c;
                            kVar.b(i10, org.bouncycastle.jcajce.provider.asymmetric.util.n.a(i10), this.f42617d);
                            m mVar = new m(this.f42617d, kVar.a());
                            this.f42614a = mVar;
                            f42612f.put(numG, mVar);
                        }
                    }
                    this.f42615b.a(this.f42614a);
                    this.f42618e = true;
                }
            }
            this.f42614a = mVarA;
            this.f42615b.a(this.f42614a);
            this.f42618e = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f42615b.b();
        return new KeyPair(new BCDHPublicKey((s) cVarB.b()), new BCDHPrivateKey((r) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f42616c = i10;
        this.f42617d = secureRandom;
        this.f42618e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
        }
        try {
            m mVarA = a(secureRandom, (DHParameterSpec) algorithmParameterSpec);
            this.f42614a = mVarA;
            this.f42615b.a(mVarA);
            this.f42618e = true;
        } catch (IllegalArgumentException e10) {
            throw new InvalidAlgorithmParameterException(e10.getMessage(), e10);
        }
    }
}
