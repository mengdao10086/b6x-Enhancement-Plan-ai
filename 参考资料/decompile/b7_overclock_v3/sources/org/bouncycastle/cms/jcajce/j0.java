package org.bouncycastle.cms.jcajce;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.cms.CMSException;
import so.q1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j0 implements q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44577c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f44578d = new c(new b());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public char[] f44579e;

    public j0(char[] cArr) {
        this.f44579e = cArr;
    }

    @Override // so.q1
    public byte[] b(int i10, zn.b bVar, int i11) throws CMSException {
        return this.f44578d.a(i10, this.f44579e, bVar, i11);
    }

    @Override // so.q1
    public int d() {
        return this.f44577c;
    }

    public Key g(zn.b bVar, zn.b bVar2, byte[] bArr, byte[] bArr2) throws CMSException {
        Cipher cipherN = this.f44578d.n(bVar.x());
        try {
            cipherN.init(4, new SecretKeySpec(bArr, cipherN.getAlgorithm()), new IvParameterSpec(gm.z.I(bVar.A()).J()));
            return cipherN.unwrap(bArr2, bVar2.x().L(), 3);
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot process content encryption key: " + e10.getMessage(), e10);
        }
    }

    @Override // so.q1
    public char[] getPassword() {
        return this.f44579e;
    }

    public j0 h(int i10) {
        this.f44577c = i10;
        return this;
    }

    public j0 i(String str) {
        this.f44578d = new c(new m0(str));
        return this;
    }

    public j0 j(Provider provider) {
        this.f44578d = new c(new n0(provider));
        return this;
    }
}
