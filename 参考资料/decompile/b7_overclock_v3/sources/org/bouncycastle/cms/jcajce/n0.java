package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import java.security.Provider;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes5.dex */
public class n0 extends org.bouncycastle.jcajce.util.i implements d {
    public n0(Provider provider) {
        super(provider);
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public org.bouncycastle.operator.jcajce.e f(zn.b bVar, PrivateKey privateKey) {
        return new org.bouncycastle.operator.jcajce.e(bVar, a.a(privateKey)).f(this.f45255a);
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public org.bouncycastle.operator.jcajce.i m(zn.b bVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return new org.bouncycastle.operator.jcajce.i(bVar, a.a(privateKey), bArr, bArr2).d(this.f45255a);
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public cs.h0 o(zn.b bVar, SecretKey secretKey) {
        return new org.bouncycastle.operator.jcajce.k(bVar, secretKey).d(this.f45255a);
    }
}
