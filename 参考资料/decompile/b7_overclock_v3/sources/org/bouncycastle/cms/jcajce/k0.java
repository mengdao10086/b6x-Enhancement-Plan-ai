package org.bouncycastle.cms.jcajce;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.cms.CMSException;
import so.s1;

/* JADX INFO: loaded from: classes5.dex */
public class k0 extends s1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f44580k;

    public k0(gm.y yVar, char[] cArr) {
        super(yVar, cArr);
        this.f44580k = new c(new b());
    }

    @Override // so.s1
    public byte[] b(int i10, zn.b bVar, int i11) throws CMSException {
        return this.f44580k.a(i10, this.f50304a, bVar, i11);
    }

    @Override // so.s1
    public byte[] c(zn.b bVar, byte[] bArr, cs.q qVar) throws CMSException {
        Key keyV = this.f44580k.v(qVar);
        Cipher cipherN = this.f44580k.n(bVar.x());
        try {
            cipherN.init(3, new SecretKeySpec(bArr, cipherN.getAlgorithm()), new IvParameterSpec(gm.z.I(bVar.A()).J()));
            return cipherN.wrap(keyV);
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot process content encryption key: " + e10.getMessage(), e10);
        }
    }

    public k0 i(String str) {
        this.f44580k = new c(new m0(str));
        return this;
    }

    public k0 j(Provider provider) {
        this.f44580k = new c(new n0(provider));
        return this;
    }
}
