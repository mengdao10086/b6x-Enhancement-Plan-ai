package nq;

import fp.k;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import np.q;
import org.bouncycastle.jcajce.provider.asymmetric.util.n;

/* JADX INFO: loaded from: classes7.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f42586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42587c = 2048;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42588d = 0;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        k kVar = new k();
        kVar.b(this.f42587c, n.a(this.f42587c), org.bouncycastle.crypto.n.g(this.f42586b));
        q qVarA = kVar.a();
        try {
            AlgorithmParameters algorithmParametersA = a("DH");
            algorithmParametersA.init(new DHParameterSpec(qVarA.f(), qVarA.b(), this.f42588d));
            return algorithmParametersA;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i10, SecureRandom secureRandom) {
        this.f42587c = i10;
        this.f42586b = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }
        DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
        this.f42587c = dHGenParameterSpec.getPrimeSize();
        this.f42588d = dHGenParameterSpec.getExponentSize();
        this.f42586b = secureRandom;
    }
}
