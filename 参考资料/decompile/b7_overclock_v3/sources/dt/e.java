package dt;

import et.l;
import gm.y;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.pqc.crypto.xmss.t;
import org.bouncycastle.pqc.crypto.xmss.u;
import org.bouncycastle.pqc.crypto.xmss.w;
import org.bouncycastle.pqc.crypto.xmss.x;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSMTPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSMTPublicKey;
import zo.e0;
import zo.h0;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class e extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f26516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f26517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f26518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f26519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f26520e;

    public e() {
        super("XMSSMT");
        this.f26517b = new u();
        this.f26519d = n.f();
        this.f26520e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f26520e) {
            t tVar = new t(new w(10, 20, new h0()), this.f26519d);
            this.f26516a = tVar;
            this.f26517b.a(tVar);
            this.f26520e = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f26517b.b();
        return new KeyPair(new BCXMSSMTPublicKey(this.f26518c, (org.bouncycastle.pqc.crypto.xmss.y) cVarB.b()), new BCXMSSMTPrivateKey(this.f26518c, (x) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        t tVar;
        if (!(algorithmParameterSpec instanceof l)) {
            throw new InvalidAlgorithmParameterException("parameter object not a XMSSMTParameterSpec");
        }
        l lVar = (l) algorithmParameterSpec;
        if (lVar.c().equals("SHA256")) {
            this.f26518c = kn.d.f37592c;
            tVar = new t(new w(lVar.a(), lVar.b(), new e0()), secureRandom);
        } else if (lVar.c().equals("SHA512")) {
            this.f26518c = kn.d.f37596e;
            tVar = new t(new w(lVar.a(), lVar.b(), new h0()), secureRandom);
        } else {
            if (!lVar.c().equals("SHAKE128")) {
                if (lVar.c().equals("SHAKE256")) {
                    this.f26518c = kn.d.f37614n;
                    tVar = new t(new w(lVar.a(), lVar.b(), new j0(256)), secureRandom);
                }
                this.f26517b.a(this.f26516a);
                this.f26520e = true;
            }
            this.f26518c = kn.d.f37612m;
            tVar = new t(new w(lVar.a(), lVar.b(), new j0(128)), secureRandom);
        }
        this.f26516a = tVar;
        this.f26517b.a(this.f26516a);
        this.f26520e = true;
    }
}
