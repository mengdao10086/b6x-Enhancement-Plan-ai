package ys;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import ns.e;
import ns.g;
import ns.h;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.y;
import org.bouncycastle.pqc.jcajce.provider.newhope.BCNHPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.newhope.BCNHPublicKey;

/* JADX INFO: loaded from: classes6.dex */
public class c extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f57558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f57559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57560c;

    public c() {
        super("NH");
        this.f57558a = new e();
        this.f57559b = n.f();
        this.f57560c = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f57560c) {
            this.f57558a.a(new y(this.f57559b, 1024));
            this.f57560c = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f57558a.b();
        return new KeyPair(new BCNHPublicKey((h) cVarB.b()), new BCNHPrivateKey((g) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        if (i10 != 1024) {
            throw new IllegalArgumentException("strength must be 1024 bits");
        }
        this.f57558a.a(new y(secureRandom, 1024));
        this.f57560c = true;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("parameter object not recognised");
    }
}
