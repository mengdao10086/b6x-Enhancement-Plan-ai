package dt;

import et.m;
import gm.y;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.pqc.crypto.xmss.d0;
import org.bouncycastle.pqc.crypto.xmss.e0;
import org.bouncycastle.pqc.crypto.xmss.f0;
import org.bouncycastle.pqc.crypto.xmss.p;
import org.bouncycastle.pqc.crypto.xmss.q;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSPublicKey;
import zo.h0;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class c extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f26511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f26512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f26513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f26514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f26515e;

    public c() {
        super("XMSS");
        this.f26513c = new q();
        this.f26514d = n.f();
        this.f26515e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f26515e) {
            p pVar = new p(new d0(10, new h0()), this.f26514d);
            this.f26511a = pVar;
            this.f26513c.a(pVar);
            this.f26515e = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f26513c.b();
        return new KeyPair(new BCXMSSPublicKey(this.f26512b, (f0) cVarB.b()), new BCXMSSPrivateKey(this.f26512b, (e0) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        p pVar;
        if (!(algorithmParameterSpec instanceof m)) {
            throw new InvalidAlgorithmParameterException("parameter object not a XMSSParameterSpec");
        }
        m mVar = (m) algorithmParameterSpec;
        if (mVar.b().equals("SHA256")) {
            this.f26512b = kn.d.f37592c;
            pVar = new p(new d0(mVar.a(), new zo.e0()), secureRandom);
        } else if (mVar.b().equals("SHA512")) {
            this.f26512b = kn.d.f37596e;
            pVar = new p(new d0(mVar.a(), new h0()), secureRandom);
        } else {
            if (!mVar.b().equals("SHAKE128")) {
                if (mVar.b().equals("SHAKE256")) {
                    this.f26512b = kn.d.f37614n;
                    pVar = new p(new d0(mVar.a(), new j0(256)), secureRandom);
                }
                this.f26513c.a(this.f26511a);
                this.f26515e = true;
            }
            this.f26512b = kn.d.f37612m;
            pVar = new p(new d0(mVar.a(), new j0(128)), secureRandom);
        }
        this.f26511a = pVar;
        this.f26513c.a(this.f26511a);
        this.f26515e = true;
    }
}
