package xs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import ms.o;
import ms.q;
import ms.r;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePublicKey;

/* JADX INFO: loaded from: classes6.dex */
public class g extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ms.l f56119a;

    public g() {
        super("McEliece");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        org.bouncycastle.crypto.c cVarB = this.f56119a.b();
        return new KeyPair(new BCMcEliecePublicKey((r) cVarB.b()), new BCMcEliecePrivateKey((q) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        try {
            initialize(new et.f(), secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
        }
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.f56119a = new ms.l();
        et.f fVar = (et.f) algorithmParameterSpec;
        this.f56119a.a(new ms.k(secureRandom, new o(fVar.b(), fVar.d())));
    }
}
