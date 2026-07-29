package qq;

import fp.t;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import np.v0;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes7.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f47595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47596c = 1024;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47597d = 0;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        t tVar = new t();
        SecureRandom secureRandom = this.f47595b;
        if (secureRandom != null) {
            tVar.b(this.f47596c, 20, secureRandom);
        } else {
            tVar.b(this.f47596c, 20, n.f());
        }
        v0 v0VarA = tVar.a();
        try {
            AlgorithmParameters algorithmParametersA = a("ElGamal");
            algorithmParametersA.init(new DHParameterSpec(v0VarA.c(), v0VarA.a(), this.f47597d));
            return algorithmParametersA;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i10, SecureRandom secureRandom) {
        this.f47596c = i10;
        this.f47595b = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }
        DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
        this.f47596c = dHGenParameterSpec.getPrimeSize();
        this.f47597d = dHGenParameterSpec.getExponentSize();
        this.f47595b = secureRandom;
    }
}
