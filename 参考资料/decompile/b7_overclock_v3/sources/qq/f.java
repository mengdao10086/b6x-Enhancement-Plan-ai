package qq;

import fp.s;
import fp.t;
import gr.j;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import np.t0;
import np.v0;
import np.w0;
import np.x0;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public class f extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t0 f47603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f47604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f47607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f47608f;

    public f() {
        super("ElGamal");
        this.f47604b = new s();
        this.f47605c = 1024;
        this.f47606d = 20;
        this.f47607e = n.f();
        this.f47608f = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        t0 t0Var;
        if (!this.f47608f) {
            DHParameterSpec dHParameterSpecE = BouncyCastleProvider.f45330c.e(this.f47605c);
            if (dHParameterSpecE != null) {
                t0Var = new t0(this.f47607e, new v0(dHParameterSpecE.getP(), dHParameterSpecE.getG(), dHParameterSpecE.getL()));
            } else {
                t tVar = new t();
                tVar.b(this.f47605c, this.f47606d, this.f47607e);
                t0Var = new t0(this.f47607e, tVar.a());
            }
            this.f47603a = t0Var;
            this.f47604b.a(this.f47603a);
            this.f47608f = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f47604b.b();
        return new KeyPair(new BCElGamalPublicKey((x0) cVarB.b()), new BCElGamalPrivateKey((w0) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f47605c = i10;
        this.f47607e = secureRandom;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        t0 t0Var;
        boolean z10 = algorithmParameterSpec instanceof j;
        if (!z10 && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
        }
        if (z10) {
            j jVar = (j) algorithmParameterSpec;
            t0Var = new t0(secureRandom, new v0(jVar.b(), jVar.a()));
        } else {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            t0Var = new t0(secureRandom, new v0(dHParameterSpec.getP(), dHParameterSpec.getG(), dHParameterSpec.getL()));
        }
        this.f47603a = t0Var;
        this.f47604b.a(this.f47603a);
        this.f47608f = true;
    }
}
