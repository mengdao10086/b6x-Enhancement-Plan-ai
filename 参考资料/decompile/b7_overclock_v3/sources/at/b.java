package at;

import et.h;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPublicKey;
import ps.e;
import ps.f;
import ps.g;

/* JADX INFO: loaded from: classes6.dex */
public class b extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ps.b f8879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ps.c f8880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f8882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8883e;

    public b() {
        super("Rainbow");
        this.f8880b = new ps.c();
        this.f8881c = 1024;
        this.f8882d = n.f();
        this.f8883e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f8883e) {
            ps.b bVar = new ps.b(this.f8882d, new e(new h().d()));
            this.f8879a = bVar;
            this.f8880b.a(bVar);
            this.f8883e = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f8880b.b();
        return new KeyPair(new BCRainbowPublicKey((g) cVarB.b()), new BCRainbowPrivateKey((f) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f8881c = i10;
        this.f8882d = secureRandom;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof h)) {
            throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
        }
        ps.b bVar = new ps.b(secureRandom, new e(((h) algorithmParameterSpec).d()));
        this.f8879a = bVar;
        this.f8880b.a(bVar);
        this.f8883e = true;
    }
}
