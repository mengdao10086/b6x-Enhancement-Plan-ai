package rq;

import fp.v;
import gr.n;
import gr.p;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import np.b1;
import np.c1;
import np.d1;
import np.z0;
import org.bouncycastle.jcajce.provider.asymmetric.gost.BCGOST3410PrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.gost.BCGOST3410PublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class e extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f49120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f49121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f49122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f49124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f49125f;

    public e() {
        super("GOST3410");
        this.f49121b = new v();
        this.f49123d = 1024;
        this.f49124e = null;
        this.f49125f = false;
    }

    public final void a(n nVar, SecureRandom secureRandom) {
        p pVarA = nVar.a();
        z0 z0Var = new z0(secureRandom, new b1(pVarA.b(), pVarA.c(), pVarA.a()));
        this.f49120a = z0Var;
        this.f49121b.a(z0Var);
        this.f49125f = true;
        this.f49122c = nVar;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f49125f) {
            a(new n(qm.a.f47467q.L()), org.bouncycastle.crypto.n.f());
        }
        org.bouncycastle.crypto.c cVarB = this.f49121b.b();
        return new KeyPair(new BCGOST3410PublicKey((d1) cVarB.b(), this.f49122c), new BCGOST3410PrivateKey((c1) cVarB.a(), this.f49122c));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f49123d = i10;
        this.f49124e = secureRandom;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof n)) {
            throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
        }
        a((n) algorithmParameterSpec, secureRandom);
    }
}
