package org.bouncycastle.cms.jcajce;

import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorException;
import so.g1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e0 implements g1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PrivateKey f44538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f44539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f44540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f44541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f44542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f44543h;

    public e0(PrivateKey privateKey) {
        c cVar = new c(new b());
        this.f44539d = cVar;
        this.f44540e = cVar;
        this.f44541f = new HashMap();
        this.f44542g = false;
        this.f44538c = a.a(privateKey);
    }

    public Key g(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        if (!a.h(bVar.x())) {
            org.bouncycastle.operator.jcajce.e eVarD = this.f44539d.d(bVar, this.f44538c).d(this.f44543h);
            if (!this.f44541f.isEmpty()) {
                for (gm.y yVar : this.f44541f.keySet()) {
                    eVarD.c(yVar, (String) this.f44541f.get(yVar));
                }
            }
            try {
                Key keyW = this.f44539d.w(bVar2.x(), eVarD.b(bVar2, bArr));
                if (this.f44542g) {
                    this.f44539d.y(bVar2, keyW);
                }
                return keyW;
            } catch (OperatorException e10) {
                throw new CMSException("exception unwrapping key: " + e10.getMessage(), e10);
            }
        }
        try {
            qm.j jVarX = qm.j.x(bArr);
            qm.k kVarZ = jVarX.z();
            PublicKey publicKeyGeneratePublic = this.f44539d.j(bVar.x()).generatePublic(new X509EncodedKeySpec(kVarZ.y().getEncoded()));
            KeyAgreement keyAgreementI = this.f44539d.i(bVar.x());
            keyAgreementI.init(this.f44538c, new cr.w(kVarZ.B()));
            keyAgreementI.doPhase(publicKeyGeneratePublic, true);
            gm.y yVar2 = qm.a.f47455e;
            SecretKey secretKeyGenerateSecret = keyAgreementI.generateSecret(yVar2.L());
            Cipher cipherF = this.f44539d.f(yVar2);
            cipherF.init(4, secretKeyGenerateSecret, new cr.k(kVarZ.x(), kVarZ.B()));
            qm.h hVarY = jVarX.y();
            return cipherF.unwrap(org.bouncycastle.util.a.B(hVarY.x(), hVarY.z()), this.f44539d.u(bVar2.x()), 3);
        } catch (Exception e11) {
            throw new CMSException("exception unwrapping key: " + e11.getMessage(), e11);
        }
    }

    public e0 h(gm.y yVar, String str) {
        this.f44541f.put(yVar, str);
        return this;
    }

    public e0 i(String str) {
        this.f44540e = a.b(str);
        return this;
    }

    public e0 j(Provider provider) {
        this.f44540e = a.c(provider);
        return this;
    }

    public e0 k(boolean z10) {
        this.f44542g = z10;
        return this;
    }

    public e0 l(boolean z10) {
        this.f44543h = z10;
        return this;
    }

    public e0 m(String str) {
        c cVar = new c(new m0(str));
        this.f44539d = cVar;
        this.f44540e = cVar;
        return this;
    }

    public e0 n(Provider provider) {
        c cVar = new c(new n0(provider));
        this.f44539d = cVar;
        this.f44540e = cVar;
        return this;
    }
}
