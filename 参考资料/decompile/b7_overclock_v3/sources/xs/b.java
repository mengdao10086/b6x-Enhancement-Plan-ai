package xs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PublicKey;

/* JADX INFO: loaded from: classes6.dex */
public class b extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ms.c f56114a;

    public b() {
        super("McEliece-CCA2");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        org.bouncycastle.crypto.c cVarB = this.f56114a.b();
        return new KeyPair(new BCMcElieceCCA2PublicKey((ms.h) cVarB.b()), new BCMcElieceCCA2PrivateKey((ms.g) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f56114a = new ms.c();
        this.f56114a.a(new ms.b(secureRandom, new ms.e()));
    }

    @Override // java.security.KeyPairGenerator
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        this.f56114a = new ms.c();
        et.e eVar = (et.e) algorithmParameterSpec;
        this.f56114a.a(new ms.b(n.f(), new ms.e(eVar.c(), eVar.e(), eVar.a())));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.f56114a = new ms.c();
        et.e eVar = (et.e) algorithmParameterSpec;
        this.f56114a.a(new ms.b(secureRandom, new ms.e(eVar.c(), eVar.e(), eVar.a())));
    }
}
