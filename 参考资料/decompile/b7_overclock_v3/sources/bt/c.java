package bt;

import et.k;
import gm.y;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import kn.d;
import org.bouncycastle.crypto.n;
import org.bouncycastle.pqc.jcajce.provider.sphincs.BCSphincs256PrivateKey;
import org.bouncycastle.pqc.jcajce.provider.sphincs.BCSphincs256PublicKey;
import rs.e;
import rs.f;
import rs.i;
import rs.j;
import zo.g0;
import zo.i0;

/* JADX INFO: loaded from: classes6.dex */
public class c extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f9643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f9644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f9645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f9646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9647e;

    public c() {
        super("SPHINCS256");
        this.f9643a = d.f37602h;
        this.f9645c = new f();
        this.f9646d = n.f();
        this.f9647e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f9647e) {
            e eVar = new e(this.f9646d, new i0(256));
            this.f9644b = eVar;
            this.f9645c.a(eVar);
            this.f9647e = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f9645c.b();
        return new KeyPair(new BCSphincs256PublicKey(this.f9643a, (j) cVarB.b()), new BCSphincs256PrivateKey(this.f9643a, (i) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        e eVar;
        if (!(algorithmParameterSpec instanceof k)) {
            throw new InvalidAlgorithmParameterException("parameter object not a SPHINCS256KeyGenParameterSpec");
        }
        k kVar = (k) algorithmParameterSpec;
        if (!kVar.a().equals(k.f27170b)) {
            if (kVar.a().equals("SHA3-256")) {
                this.f9643a = d.f37606j;
                eVar = new e(secureRandom, new g0(256));
            }
            this.f9645c.a(this.f9644b);
            this.f9647e = true;
        }
        this.f9643a = d.f37602h;
        eVar = new e(secureRandom, new i0(256));
        this.f9644b = eVar;
        this.f9645c.a(this.f9644b);
        this.f9647e = true;
    }
}
