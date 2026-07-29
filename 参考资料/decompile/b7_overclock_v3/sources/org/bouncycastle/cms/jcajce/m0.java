package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes5.dex */
public class m0 extends org.bouncycastle.jcajce.util.g implements d {
    public m0(String str) {
        super(str);
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public org.bouncycastle.operator.jcajce.e f(zn.b bVar, PrivateKey privateKey) {
        return new org.bouncycastle.operator.jcajce.e(bVar, a.a(privateKey)).e(this.f45254a);
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public org.bouncycastle.operator.jcajce.i m(zn.b bVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return new org.bouncycastle.operator.jcajce.i(bVar, a.a(privateKey), bArr, bArr2).c(this.f45254a);
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public cs.h0 o(zn.b bVar, SecretKey secretKey) {
        return new org.bouncycastle.operator.jcajce.k(bVar, secretKey).c(this.f45254a);
    }
}
