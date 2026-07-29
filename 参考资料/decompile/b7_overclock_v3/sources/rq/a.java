package rq;

import fp.w;
import gr.p;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import np.b1;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes7.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f49117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49118c = 1024;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        w wVar = new w();
        SecureRandom secureRandom = this.f49117b;
        if (secureRandom != null) {
            wVar.b(this.f49118c, 2, secureRandom);
        } else {
            wVar.b(this.f49118c, 2, n.f());
        }
        b1 b1VarA = wVar.a();
        try {
            AlgorithmParameters algorithmParametersA = a("GOST3410");
            algorithmParametersA.init(new gr.n(new p(b1VarA.b(), b1VarA.c(), b1VarA.a())));
            return algorithmParametersA;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i10, SecureRandom secureRandom) {
        this.f49118c = i10;
        this.f49117b = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
    }
}
